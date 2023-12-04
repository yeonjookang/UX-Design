package com.example.myapplication.activitys

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.SaleData
import com.example.myapplication.data.ShareData
import com.example.myapplication.databinding.ActivityShowProfileBinding
import com.example.myapplication.datas.SellData

class ShowProfileActivity : AppCompatActivity() {
    lateinit var binding: ActivityShowProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sale_rv = findViewById<RecyclerView>(R.id.saleList)
        val saleList = arrayListOf<SaleData>()
        saleList.add(SaleData("무선 아이폰 판매합니다", "건덕이", R.drawable.sale_image))
        saleList.add(SaleData("마우스 새거 입니다", "건덕이", R.drawable.logitech))
        saleList.add(SaleData("농구공 안써서 팝니다", "건덕이", R.drawable.basketball))

        val saleListAdapter = ShowProfileSaleListAdapter(saleList)
        sale_rv.adapter = saleListAdapter
        sale_rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val share_rv = findViewById<RecyclerView>(R.id.shareList)
        val shareList = arrayListOf<ShareData>()
        shareList.add(ShareData("공학용 계산기 빌려주실 분ㅠㅠ", "건덕이"))
        shareList.add(ShareData("c타입 충전기 가진 분 계신가요", "건덕이"))
        shareList.add(ShareData("두통약 여분 있는 사람 제발..", "건덕이"))

        val shareListAdapter = ShowProfileShareListAdapter(shareList)
        share_rv.adapter = shareListAdapter
        share_rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}
