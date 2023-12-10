package com.example.myapplication.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.activitys.CreateActivity
import com.example.myapplication.activitys.SellDetailActivity
import com.example.myapplication.adapters.SellDataAdapter
import com.example.myapplication.databinding.FragmentHomeSellBinding
import com.example.myapplication.datas.SellData

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
        datas.add(SellData("무선 아이폰 판매합니다", "건구스", R.drawable.sale_image))
        datas.add(SellData("혹시 스파게티 소스 필요하신분", "파스타홀릭", R.drawable.pasta))
        datas.add(SellData("화장품 팔아요~!", "쌩얼미인", R.drawable.makeup))
        datas.add(SellData("고데기 팝니다", "건덕이", R.drawable.godegi))
        datas.add(SellData("에버랜드 자유이용권 팔아용", "수능끝", R.drawable.everland))
        datas.add(SellData("버거킹 와퍼세트 교환권 판매합니다!", "버버벅킹", R.drawable.burger))
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

        viewBinding.createTeamButton.setOnClickListener {
            val intent = Intent(requireContext(), CreateActivity::class.java)
            startActivity(intent)
        }
    }

}