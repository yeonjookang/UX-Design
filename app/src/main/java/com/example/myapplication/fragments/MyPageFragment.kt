package com.example.myapplication.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.activitys.ShowProfileActivity
import com.example.myapplication.databinding.FragmentMyPageBinding

class MyPageFragment : Fragment() {
    private lateinit var binding: FragmentMyPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMyPageBinding.inflate(layoutInflater)

        onClick()

        return binding.root
    }

    private fun onClick() {
        binding.profilePreviewBtn.setOnClickListener{
            val intent = Intent(activity, ShowProfileActivity::class.java)
            startActivity(intent)
        }
    }


}

