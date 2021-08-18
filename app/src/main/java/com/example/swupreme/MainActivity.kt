package com.example.swupreme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import com.example.daycheck.R

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.FileReader
import java.time.LocalDate

//달력 화면
class MainActivity : AppCompatActivity() {
    lateinit var addBtn: Button
    lateinit var calendarView: CalendarView
    lateinit var diaryTextView: TextView
    lateinit var personmood: TextView
    lateinit var personsymptom: TextView
    lateinit var personexercise: TextView
    lateinit var persondrink: TextView
    lateinit var personsmoking: TextView
    lateinit var personsleep: TextView

    var fname: String = ""
    var str: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        addBtn = findViewById(R.id.add_Btn)
        calendarView = findViewById(R.id.calendarView)
        diaryTextView = findViewById(R.id.diaryTextView)
        personmood = findViewById(R.id.person_mood)
        personsymptom = findViewById(R.id.person_symptom)
        personexercise = findViewById(R.id.person_exercise)
        persondrink = findViewById(R.id.person_drink)
        personsmoking = findViewById(R.id.person_smoking)
        personsleep = findViewById(R.id.person_sleep)


        //추가 버튼을 누르면 DayActivity로 이동
        addBtn.setOnClickListener {
            val intent = Intent(this, DayActivity::class.java)
            startActivity(intent)
            calendarView.callOnClick()
        }

        //달력 날짜 선택되면 날짜 표시
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            diaryTextView.visibility = View.VISIBLE
            diaryTextView.text = String.format("%d / %d / %d", year, month + 1, dayOfMonth)

            val SharedPreferences = getSharedPreferences("person",0)
            personmood.text = SharedPreferences.getString("mood","")
            personsymptom.text = SharedPreferences.getString("symptom","")
            personexercise.text = SharedPreferences.getString("Exercising","")
            persondrink.text = SharedPreferences.getString("Drinking","")
            personsmoking.text = SharedPreferences.getString("Smoking", "")
            personsleep.text = SharedPreferences.getString("Sleeping", "")

        }


    }

    fun checkedDay(cYear: Int, cMonth: Int, cDay: Int){
        fname = "" +cYear + "-" + (cMonth + 1) + "" + "-" + cDay + ".txt"
        var fis: FileInputStream? = null

        try {
            fis = openFileInput(fname) // fname 파일 오픈

            val fileData = ByteArray(fis.available()) // fileData에 파이트 형식으로 저장
            fis.read(fileData) // fileData를 읽음
            fis.close()

            str = fileData.toString() // str 변수에 fileData를 저장
            personsymptom.text = "${str}"
        }catch (e: Exception){
            System.out.println("오류")
            e.printStackTrace()

        }
    }

}