package com.example.myapplication.activitys

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityShowProfileBinding

class ShowProfileActivity:AppCompatActivity() {
    lateinit var binding: ActivityShowProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


}