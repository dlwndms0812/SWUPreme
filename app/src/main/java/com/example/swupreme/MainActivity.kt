package com.example.swupreme

import android.content.Intent

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.example.swupreme.HomeActivity.cnt
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cnt=90;

        //val intent = Intent(this@MainActivity, LoginActivity::class.java)
        val intent=Intent(this@MainActivity, HomeActivity::class.java)
        startActivity(intent)




    }


}


//back-end branch