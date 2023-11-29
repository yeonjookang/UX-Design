package com.example.myapplication.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.activitys.ShareDetailActivity
import com.example.myapplication.adapters.ShareDataAdapter
import com.example.myapplication.databinding.FragmentHomeShareBinding
import com.example.myapplication.datas.ShareData

class HomeShareFragment : Fragment() {
    private lateinit var viewBinding : FragmentHomeShareBinding
    lateinit var adapter: ShareDataAdapter
    var datas = ArrayList<ShareData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentHomeShareBinding.inflate(layoutInflater)
        init()
        return viewBinding.root
    }

    private fun init() {
        datas.add(ShareData("공학용 계산기 빌려주실 분 ㅠㅠ", "건구스"))
        datas.add(ShareData("공학용 계산기 빌려주실 분 ㅠㅠ", "건구스"))
        datas.add(ShareData("공학용 계산기 빌려주실 분 ㅠㅠ", "건구스"))
        datas.add(ShareData("공학용 계산기 빌려주실 분 ㅠㅠ", "건구스"))
        datas.add(ShareData("공학용 계산기 빌려주실 분 ㅠㅠ", "건구스"))

        viewBinding.shareItemList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        adapter = ShareDataAdapter(datas)

        adapter.itemClickListener1 = object: ShareDataAdapter.OnItemClickListener{
            override fun OnItemClick(data: ShareData) {
                val intent = Intent(requireActivity(),
                    ShareDetailActivity::class.java)
                intent.putExtra("share_title", data.title)
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                startActivity(intent)
            }
        }
        viewBinding.shareItemList.adapter = adapter
    }
}