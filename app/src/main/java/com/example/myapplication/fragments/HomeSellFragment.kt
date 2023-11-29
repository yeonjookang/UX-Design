package com.example.myapplication.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.activitys.SellDetailActivity
import com.example.myapplication.adapters.SellDataAdapter
import com.example.myapplication.databinding.FragmentHomeSellBinding
import com.example.myapplication.datas.SellData
import com.example.myapplication.datas.ShareData

class HomeSellFragment : Fragment() {
    private lateinit var viewBinding : FragmentHomeSellBinding
    lateinit var adapter: SellDataAdapter
    var datas = ArrayList<SellData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentHomeSellBinding.inflate(layoutInflater)
        init()
        return viewBinding.root
    }

    private fun init() {
        datas.add(SellData("무선 이어폰 판매합니다", "건구스",""))
        datas.add(SellData("무선 이어폰 판매합니다", "건구스",""))
        datas.add(SellData("무선 이어폰 판매합니다", "건구스",""))
        datas.add(SellData("무선 이어폰 판매합니다", "건구스",""))
        datas.add(SellData("무선 이어폰 판매합니다", "건구스",""))
        viewBinding.sellItemList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        adapter = SellDataAdapter(datas)

        adapter.itemClickListener1 = object: SellDataAdapter.OnItemClickListener{
            override fun OnItemClick(data: SellData) {
                val intent = Intent(requireActivity(), SellDetailActivity::class.java)
                intent.putExtra("sell_title", data.title)
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                startActivity(intent)
            }
        }
        viewBinding.sellItemList.adapter = adapter
    }

}