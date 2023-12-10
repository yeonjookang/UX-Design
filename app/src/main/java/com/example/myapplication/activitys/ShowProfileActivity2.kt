package com.example.myapplication.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.SaleData
import com.example.myapplication.data.ShareData
import com.example.myapplication.databinding.ActivityShowProfile2Binding
import com.example.myapplication.databinding.ActivityShowProfileBinding

class ShowProfileActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityShowProfile2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowProfile2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val sale_rv = findViewById<RecyclerView>(R.id.saleList)
        val saleList = arrayListOf<SaleData>()
        saleList.add(SaleData("무선 아이폰 팔아요", "건구스", R.drawable.sale_image))
        saleList.add(SaleData("에버랜드 티켓 팔아요", "건구스", R.drawable.everland))
        saleList.add(SaleData("스파게티 소스 싸게 가져가세요", "건구스", R.drawable.pasta))

        val saleListAdapter = ShowProfileSaleListAdapter(saleList)
        sale_rv.adapter = saleListAdapter
        sale_rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val share_rv = findViewById<RecyclerView>(R.id.shareList)
        val shareList = arrayListOf<ShareData>()
        shareList.add(ShareData("공학용 계산기 빌려주실 분ㅠㅠg", "건구스"))
        shareList.add(ShareData("연필 빌려주세요", "건구스"))
        shareList.add(ShareData("노트북 충전기 급하게 구합니다.", "건구스"))

        val shareListAdapter = ShowProfileShareListAdapter(shareList)
        share_rv.adapter = shareListAdapter
        share_rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}