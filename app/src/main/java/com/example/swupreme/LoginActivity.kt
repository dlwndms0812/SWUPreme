package com.example.swupreme

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Response
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject

class LoginActivity : AppCompatActivity() {
    private lateinit var et_id: EditText
    private lateinit var et_pass: EditText
    private lateinit var btn_login: Button
    private lateinit var btn_register: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        et_id = findViewById<EditText>(R.id.et_id)
        et_pass = findViewById<EditText>(R.id.et_pass)
        btn_login = findViewById<Button>(R.id.btn_login)
        btn_register = findViewById<Button>(R.id.btn_register)
        btn_register.setOnClickListener( View.OnClickListener
            //회원가입 버튼을 클릭시 수행
            {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            })
        btn_login.setOnClickListener(View.OnClickListener {
            val userID = et_id.getText().toString()
            val userPass = et_pass.getText().toString()
            val responseListener: Response.Listener<String> = Response.Listener { response ->
                try {
                    val jasonObject = JSONObject(response)
                    val success = jasonObject.getBoolean("success")
                    if (success) { //회원등록 성공한 경우
                        val userID = jasonObject.getString("userID")
                        val userPass = jasonObject.getString("userPassword")
                        Toast.makeText(applicationContext, "로그인 성공", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        intent.putExtra("log", "User")
                        intent.putExtra("userID", userID)
                        startActivity(intent)
                    } else { //회원등록 실패한 경우
                        Toast.makeText(applicationContext, "로그인 실패", Toast.LENGTH_SHORT).show()
                        return@Listener
                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }
            val loginRequest = LoginRequest(userID, userPass, responseListener)
            val queue = Volley.newRequestQueue(this@LoginActivity)
            queue.add(loginRequest)
        })
    }
}