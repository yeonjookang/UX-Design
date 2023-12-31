package com.example.myapplication.activitys

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.myapplication.databinding.ActivityHomeBinding
import com.example.myapplication.databinding.ActivityLogInBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class LogInActivity : AppCompatActivity() {

    lateinit var viewBinding : ActivityLogInBinding
    lateinit var mAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        // 인증 객체 초기화
        mAuth = Firebase.auth

        // 로그인 버튼 이벤트
        viewBinding.loginBtn.setOnClickListener{

            val email = viewBinding.emailEdit.text.toString()
            val password = viewBinding.passwordEdit.text.toString()

            if (isValidEmail(email)) {
                login(email, password)
            } else {
                viewBinding.emailEdit.setTextColor(Color.RED)
                Toast.makeText(this, "이메일 형식이 올바르지 않습니다.", Toast.LENGTH_SHORT).show()
            }
        }

        // 회원가입 버튼 이벤트
        viewBinding.signUpBtn.setOnClickListener {
            val intent: Intent = Intent(this@LogInActivity, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    /**
     * 이메일 형식 유효성 검사
     */
    private fun isValidEmail(email: String): Boolean {
        val emailRegex = Regex("^[A-Za-z0-9._%+-]+@konkuk\\.ac\\.kr$")
        return emailRegex.matches(email)
    }


    /**
     * 로그인
     */
    private fun login(email: String, password: String) {
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // 성공시 실행
                    val intent: Intent = Intent(this@LogInActivity, HomeActivity::class.java)

                    startActivity(intent)
                    Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    // 실패시 실행
                    Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
                    Log.d("Login", "Error: ${task.exception}")
                }
            }
    }

}