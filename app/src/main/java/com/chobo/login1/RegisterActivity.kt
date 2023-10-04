package com.chobo.login1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val auth = Firebase.auth

        val btn_register = findViewById<Button>(R.id.btn_ac_register_register)
        val et_mail = findViewById<EditText>(R.id.et_email)
        val et_pwd = findViewById<EditText>(R.id.et_pwd)

        btn_register.setOnClickListener {//회원가입 버튼 클릭
            val email = et_mail.text.toString()
            val pwd = et_pwd.text.toString()

            if(!email.isEmpty() && !pwd.isEmpty()){
                auth.createUserWithEmailAndPassword(email, pwd)
                    .addOnCompleteListener{ result ->
                        if(result.isSuccessful){
                            Toast.makeText(this, "회원가입에 성공했습니다!", Toast.LENGTH_SHORT).show()

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