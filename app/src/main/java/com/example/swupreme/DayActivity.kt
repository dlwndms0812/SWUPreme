package com.example.swupreme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.daycheck.R

//하루 기록 화면
class DayActivity : AppCompatActivity() {
    //private var person: Person? = null
    private var mood: String = ""
    private var symptom: String = ""
    private var isExercising: String = ""
    private var isDrinked: String = ""
    private var isSmoking: String = ""
    private var isSleeping: String = ""

    lateinit var saveBtn: Button
    lateinit var backBtn: Button

    lateinit var exercising_radio: RadioGroup
    lateinit var drink_radio: RadioGroup
    lateinit var smoking_radio: RadioGroup
    lateinit var sleeping_radio: RadioGroup
    lateinit var ex_zero : RadioButton
    lateinit var ex_30m : RadioButton
    lateinit var ex_1h: RadioButton
    lateinit var ex_1h30m: RadioButton
    lateinit var ex_2h: RadioButton
    lateinit var sleep_5h: RadioButton
    lateinit var sleep_6h: RadioButton
    lateinit var sleep_7h: RadioButton
    lateinit var sleep_8h: RadioButton
    lateinit var sleep_9h: RadioButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_day)

        saveBtn = findViewById(R.id.save_Btn)
        backBtn = findViewById(R.id.back_Btn)
        exercising_radio = findViewById(R.id.exercising_radio)
        drink_radio = findViewById(R.id.drink_radio)
        smoking_radio = findViewById(R.id.smoking_radio)
        sleeping_radio = findViewById(R.id.sleeping_radio)
        ex_zero = findViewById(R.id.ex_zero)
        ex_30m = findViewById(R.id.ex_30m)
        ex_1h = findViewById(R.id.ex_1h)
        ex_1h30m = findViewById(R.id.ex_1h30m)
        ex_2h = findViewById(R.id.ex_2h)
        sleep_5h = findViewById(R.id.sleep_5h)
        sleep_6h = findViewById(R.id.sleep_6h)
        sleep_7h = findViewById(R.id.sleep_7h)
        sleep_8h = findViewById(R.id.sleep_8h)
        sleep_9h = findViewById(R.id.sleep_9h)


        //운동 시간 선택
        exercising_radio.setOnCheckedChangeListener{radioGroup, checkedId ->
            when(checkedId){
                R.id.ex_zero ->  isExercising = "안함"
                R.id.ex_30m -> isExercising = "30분"
                R.id.ex_1h -> isExercising = "1시간"
                R.id.ex_1h30m -> isExercising = "1시간30분"
                R.id.ex_2h -> isExercising = "2시간 이상"
            }
        }
        //음주 유무 선택
        drink_radio.setOnCheckedChangeListener{radioGroup, i->if(i==R.id.drink_true) isDrinked = "유"
        else isDrinked = "무"}
        //흡연 유무 선택
        smoking_radio.setOnCheckedChangeListener{radioGroup, i->if(i==R.id.smoking_true) isSmoking = "유"
        else isSmoking = "무"}
        //수면 시간 선택
        sleeping_radio.setOnCheckedChangeListener {radioGroup, checkedId ->
            when(checkedId){
                R.id.sleep_5h -> isSleeping = "6시간 미만"
                R.id.sleep_6h -> isSleeping = "6시간"
                R.id.sleep_7h -> isSleeping = "7시간"
                R.id.sleep_8h -> isSleeping = "8시간"
                R.id.sleep_9h -> isSleeping = "8시간 이상"
            }
        }


        //저장 버튼을 누르면 데이터 전달
        saveBtn.setOnClickListener {
            saveData(isExercising,isDrinked,isSmoking,isSleeping)
            val intent = Intent(this, MainActivity::class.java)
            //intent.putExtra("ImageName", imgName)
            intent.putExtra("exercising", isExercising.toString())
            intent.putExtra("drinking", isDrinked.toString())
            intent.putExtra("smoking", isSmoking.toString())
            intent.putExtra("sleeping", isSleeping.toString())

            //val sf:SharedPreferences = getSharedPreferences("userinfo", MODE_PRIVATE)
            //val editor: SharedPreferences.Editor = sf.edit()
            //editor.putString("exercising", isExercising.toString())
            //editor.putString("drinking", isDrinked.toString())
            //editor.putString("smoking", isSmoking.toString())
            //editor.putString("sleeping", isSleeping.toString())
            //editor.commit()

            startActivity(intent)
            //현재 날짜 불러옴
            //val cal = Calendar.getInstance()
            //val year = cal.get(Calendar.Year)
            //val month = cal.get(Calendar.MONTH) + 1
            //val day = cal.get(Calendar.DATE)
            //현재 날짜에 몸 상태 추가
            //val person = Person(mood, symptom ,excerciseTime, isDrinked,
            //isSmoking, sleepTime, year, month, day)
            //personViewModel.addPerson(person)
        }

        //취소 버튼을 누르면 전으로 이동
        backBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
    fun saveData(excerciseTime:String, isDrinked:String, isSmoking: String, sleepTime:String){
        val pref = this.getPreferences(0)
        val editor = pref.edit()

        editor.putString("KEY_EXERCISE",excerciseTime)
        editor.putString("KEY_DRINK", isDrinked)
        editor.putString("KEY_SMOKING", isSmoking)
        editor.putString("KEY_SLEEP", sleepTime)
        editor.commit()
        editor.apply()

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}