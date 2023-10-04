package com.chobo.login1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val auth = Firebase.auth

        val btn_register = findViewById<Button>(R.id.btn_ac_login_register)
        val btn_login = findViewById<Button>(R.id.btn_login)
        val et_mail = findViewById<EditText>(R.id.et_login_email)
        val et_pwd = findViewById<EditText>(R.id.et_login_pwd)

        btn_register.setOnClickListener {//회원가입 버튼 클릭
            var intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        btn_login.setOnClickListener {//로그인 버튼 클릭
            val email = et_mail.text.toString()
            val pwd = et_pwd.text.toString()

            if(!email.isEmpty() && !pwd.isEmpty()){
                auth.signInWithEmailAndPassword(email, pwd)
                    .addOnCompleteListener{ result ->
                        if(result.isSuccessful){
                            Toast.makeText(this, "로그인에 성공했습니다!", Toast.LENGTH_SHORT).show()

                            var intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)

                            finish()
                        }
                        else{
                            Toast.makeText(this, "실패", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }

    }
}