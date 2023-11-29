package com.example.myapplication.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivitySellDetailBinding

class SellDetailActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivitySellDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySellDetailBinding.inflate(layoutInflater)
        setContentView(viewBinding.root) // 이 부분을 수정
        init()
    }

    private fun init(){
        viewBinding.backDetail.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent)
        }
    }

}