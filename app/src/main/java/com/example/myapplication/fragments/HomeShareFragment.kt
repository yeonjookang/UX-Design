package com.example.myapplication.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.activitys.CreateActivity
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

    private val createActivityLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            result.data?.let { data ->
                val newTitle = data.getStringExtra("newTitle")
                val newContent = data.getStringExtra("newContent")

                // 새로운 SellData 객체 추가
                datas.add(ShareData(newTitle!!, "건구스"))
                adapter.notifyDataSetChanged()
            }
        }
    }

    private fun init() {
        datas.add(ShareData("공학용 계산기 빌려주실 분 ㅠㅠ", "건구스"))
        datas.add(ShareData("기숙사에 가위 있으신 분", "자취러"))
        datas.add(ShareData("맥북 충전기 급하게 구합니당", "사과"))
        datas.add(ShareData("시험 봐야하는데 지우개가 없어요", "건더기"))
        datas.add(ShareData("노트 몇장만 찢어주실분..", "건대최고"))

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

        viewBinding.createTeamButton.setOnClickListener {
            val intent = Intent(requireContext(), CreateActivity::class.java)
            createActivityLauncher.launch(intent)
        }
    }
}