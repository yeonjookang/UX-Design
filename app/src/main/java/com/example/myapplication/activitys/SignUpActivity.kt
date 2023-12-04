package com.example.myapplication.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivitySignUpBinding
import com.example.myapplication.dataclass.User
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database
import android.graphics.Color

class SignUpActivity : AppCompatActivity() {

    lateinit var viewBinding: ActivitySignUpBinding

    lateinit var mAuth: FirebaseAuth

    private lateinit var mDbRef: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        // 인증 객체 초기화
        mAuth = Firebase.auth

        // 데이터베이스 초기화
        mDbRef = Firebase.database.reference


        viewBinding.signUpBtn.setOnClickListener{
            val nickname = viewBinding.nicknameEdit.text.toString().trim()
            val email = viewBinding.emailEdit.text.toString().trim()
            val password = viewBinding.passwordEdit.text.toString().trim()

            if (isValidEmail(email)) {
                signUp(nickname, email, password)
            } else {
                viewBinding.emailEdit.setTextColor(Color.RED)
                Toast.makeText(this, "이메일 형식이 올바르지 않습니다.", Toast.LENGTH_SHORT).show()
            }
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
     * 회원 가입
     */
    private fun signUp(nickname: String, email:String, password:String) {

        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // 성공시 실행
                    Toast.makeText(this, "회원 가입 성공", Toast.LENGTH_SHORT).show()
                    val intent: Intent = Intent(this@SignUpActivity, LogInActivity::class.java)
                    startActivity(intent)
                    addUserToDatabase(nickname, email, mAuth.currentUser?.uid!!)

                } else {
                    // 실패시 실행
                    Toast.makeText(this, "회원 가입 실패", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun addUserToDatabase(nickname: String, email: String, uId: String) {
        mDbRef.child("user").child(uId).setValue(User(nickname, email, uId))
    }
}