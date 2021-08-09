package com.example.swupreme

import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.yanzhenjie.permission.Action
import com.yanzhenjie.permission.AndPermission
import com.yanzhenjie.permission.runtime.Permission

class MainActivity : AppCompatActivity() {
    var mapFragment: SupportMapFragment? = null
    var map: GoogleMap? = null
    var myLocationMarker: MarkerOptions? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync { googleMap ->
            Log.d("Map", "지도 준비됨.")
            map = googleMap
        }
        try {
            MapsInitializer.initialize(this)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener { startLocationService() }
        AndPermission.with(this)
                .runtime()
                .permission(
                        Permission.ACCESS_FINE_LOCATION,
                        Permission.ACCESS_COARSE_LOCATION)
                .onGranted { permissions -> showToast("허용된 권한 개수 : " + permissions.size) }
                .onDenied { permissions -> showToast("거부된 권한 개수 : " + permissions.size) }
                .start()
    }

    fun showToast(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    fun startLocationService() {
        val manager = getSystemService(LOCATION_SERVICE) as LocationManager
        try {
            val location = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
            if (location != null) {
                val latitude = location.latitude
                val longitude = location.longitude
                val message = "최근 위치 -> Latitude : $latitude\nLongitude:$longitude"
                Log.d("Map", message)
            }
            val gpsListener: GPSListener = GPSListener()
            val minTime: Long = 10000
            val minDistance = 0f
            manager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                minTime, minDistance, gpsListener
            )
            Toast.makeText(
                applicationContext, "내 위치확인 요청함",
                Toast.LENGTH_SHORT
            ).show()
        } catch (e: SecurityException) {
            e.printStackTrace()
        }
    }

    internal inner class GPSListener : LocationListener {
        override fun onLocationChanged(location: Location) {
            val latitude = location.latitude
            val longitude = location.longitude
            val message = "내 위치 -> Latitude : $latitude\nLongitude:$longitude"
            Log.d("Map", message)
            showCurrentLocation(latitude, longitude)
        }

        override fun onProviderDisabled(provider: String) {}
        override fun onProviderEnabled(provider: String) {}
        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
    }

    private fun showCurrentLocation(latitude: Double, longitude: Double) {
        val curPoint = LatLng(latitude, longitude)
        map!!.animateCamera(CameraUpdateFactory.newLatLngZoom(curPoint, 15f))
        showMyLocationMarker(curPoint)
    }

    private fun showMyLocationMarker(curPoint: LatLng) {
        if (myLocationMarker == null) {
            myLocationMarker = MarkerOptions()
            myLocationMarker!!.position(curPoint)
            myLocationMarker!!.title("● 내 위치\n")
            myLocationMarker!!.snippet("● GPS로 확인한 위치")
            myLocationMarker!!.icon(BitmapDescriptorFactory.fromResource(R.drawable.mylocation))
            map!!.addMarker(myLocationMarker)
        } else {
            myLocationMarker!!.position(curPoint)
        }
    }
}


//front-end 1 branch