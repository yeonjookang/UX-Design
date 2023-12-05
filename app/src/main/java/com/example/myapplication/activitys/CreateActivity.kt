package com.example.myapplication.activitys

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityCreateBinding
import com.example.myapplication.datas.ShareData

class CreateActivity : AppCompatActivity() {
    lateinit var viewBinding : ActivityCreateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)
        viewBinding = ActivityCreateBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        init()
    }

    private fun init(){
        viewBinding.createTeamButton.setOnClickListener {

            if(viewBinding.recruitTitle.text.isEmpty()){
                Toast.makeText(this, "제목을 입력해주세요.", Toast.LENGTH_SHORT)
                    .show()
                viewBinding.recruitTitle.requestFocus()
                return@setOnClickListener
            }else if(viewBinding.content.text.isEmpty()){
                Toast.makeText(this, "내용을 입력해주세요.", Toast.LENGTH_SHORT)
                    .show()
                viewBinding.content.requestFocus()
                return@setOnClickListener
            }

            val intent = Intent()
            intent.putExtra("newTitle", viewBinding.recruitTitle.text.toString())
            intent.putExtra("newContent", viewBinding.content.text.toString())
            setResult(Activity.RESULT_OK, intent)
            Toast.makeText(this, "게시글이 생성되었습니다.", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}