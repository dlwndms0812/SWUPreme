package com.example.swupreme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.daycheck.R

//달력 화면
class MainActivity : AppCompatActivity(), BottomSheetDialog.BottomSheetButtonClickListener{
    lateinit var addBtn: Button
    lateinit var moodBtn: Button
    lateinit var textView_clickedItem: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addBtn = findViewById(R.id.add_Btn)
        moodBtn = findViewById(R.id.mood_Btn)
        textView_clickedItem = findViewById(R.id.textView_clickedItem)


        //추가 버튼을 누르면 DayActivity로 이동
        addBtn.setOnClickListener {
            val intent = Intent(this, DayActivity::class.java)
            startActivity(intent)
        }

        //기분 버튼을 누르면 위로 올라오게 하기
        moodBtn.setOnClickListener {
            val bottomSheetDialog: BottomSheetDialog = BottomSheetDialog()
            bottomSheetDialog.show(supportFragmentManager,"exampleBottomSheet")
        }
    }

    override fun onButtonClicked(text: String) {
        textView_clickedItem.text = text
    }

}