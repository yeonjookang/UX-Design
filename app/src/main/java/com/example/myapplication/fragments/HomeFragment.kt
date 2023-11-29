package com.example.myapplication.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var viewBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewBinding = FragmentHomeBinding.inflate(layoutInflater)
        setFragment()
        return viewBinding.root
    }

    private fun setFragment() {
        /**
         * 가장 처음 지정될 아이콘 및 프레그먼트 설정
         */
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_status, HomeSellFragment())
            .commitAllowingStateLoss()

        /**
         * 각 아이콘 클릭으로 인한 프레그먼트 변경 이벤트
         */

        viewBinding.radioGroup.setOnCheckedChangeListener { group, id ->
            if(id== R.id.radioButton){
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_status, HomeShareFragment())
                    .commitAllowingStateLoss()
            }
            else{
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_status, HomeSellFragment())
                    .commitAllowingStateLoss()
            }
        }
    }
}