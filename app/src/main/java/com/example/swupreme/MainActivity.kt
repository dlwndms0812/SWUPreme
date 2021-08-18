package com.example.swupreme

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build

import android.os.Bundle
import android.view.View

import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.swupreme.HomeActivity.cnt
import kotlinx.android.synthetic.main.activity_main.*

import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.swupreme.application.BaseApplication
import com.example.swupreme.R
import com.example.swupreme.util.Util
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val navController by lazy{
        findNavController(R.id.diagnosisFragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



       cnt=90;

        //val intent = Intent(this@MainActivity, LoginActivity::class.java)
        val intent=Intent(this@MainActivity, LoginActivity::class.java)
        startActivity(intent)




    }

}


//back-end branch