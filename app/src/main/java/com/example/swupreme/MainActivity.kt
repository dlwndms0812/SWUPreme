package com.example.swupreme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import com.example.daycheck.R

//달력 화면
class MainActivity : AppCompatActivity(){
    lateinit var addBtn: Button
    lateinit var calendarView: CalendarView
    lateinit var diaryTextView: TextView
    lateinit var personmood: TextView
    lateinit var personsymptom: TextView
    lateinit var personexercise: TextView
    lateinit var persondrink: TextView
    lateinit var personsmoking: TextView
    lateinit var personsleep: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        addBtn = findViewById(R.id.add_Btn)
        calendarView = findViewById(R.id.calendarView)
        diaryTextView = findViewById(R.id.diaryTextView)
        //personmood = findViewById(R.id.person_mood)
        //personsymptom = findViewById(R.id.person_symptom)
        personexercise = findViewById(R.id.person_exercise)
        persondrink = findViewById(R.id.person_drink)
        personsmoking = findViewById(R.id.person_smoking)
        personsleep = findViewById(R.id.person_sleep)

        //val sf:SharedPreferences = getSharedPreferences("userInfo", MODE_PRIVATE)
        //personexercise.setText("${sf.getString("exercising","-")}")
        //persondrink.setText("${sf.getString("drinking","-")}")
        //personsmoking.setText("${sf.getString("smoking","-")}")
        //personsleep.setText("${sf.getString("sleeping","-")}")


        //추가 버튼을 누르면 DayActivity로 이동
        addBtn.setOnClickListener {
            val intent = Intent(this, DayActivity::class.java)
            startActivity(intent)
        }

        //달력 날짜 선택되면 날짜 표시
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            diaryTextView.visibility = View.VISIBLE
            diaryTextView.text = String.format("%d / %d / %d", year, month + 1, dayOfMonth)
            loadData()
        }

        //데이터 전달받기
        //personmood.text = intent.getStringExtra("mood")
        //personexercise.setText(intent.getStringExtra("exercising"))
        //persondrink.setText(intent.getStringExtra("drinking"))
        //personsmoking.setText(intent.getStringExtra("smoking"))
        //personsleep.setText(intent.getStringExtra("sleeping"))

    }

    fun loadData() {

        val pref = this.getPreferences(0)
        val exerciseTime = pref.getString("KEY_EXERCISE","")
        val isDrinked = pref.getString("KEY_DRINK","")
        val isSmoking = pref.getString("KEY_SMOKING", "")
        val sleepTime = pref.getString("KEY_SLEEP", "")

        if(exerciseTime!=null || isDrinked!=null || isSmoking!=null || sleepTime!=null){
            personexercise.setText(exerciseTime.toString())
            persondrink.setText(isDrinked.toString())
            personsmoking.setText(isSmoking.toString())
            personsleep.setText(sleepTime.toString())
        }

    }

}