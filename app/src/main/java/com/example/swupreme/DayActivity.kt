package com.example.swupreme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.daycheck.R

//하루 기록 화면
class DayActivity : AppCompatActivity() {
    lateinit var saveBtn: Button
    lateinit var backBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_day)

        saveBtn = findViewById(R.id.save_Btn)
        backBtn = findViewById(R.id.back_Btn)

        //저장 버튼을 누르면 DayActivity로 이동
        saveBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //취소 버튼을 누르면 전으로 이동


    }
}