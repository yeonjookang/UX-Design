package com.example.myapplication.activitys

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.ShareData

class ShowProfileShareListAdapter(private val shareItems: List<ShareData>) : RecyclerView.Adapter<ShowProfileShareListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.titleTextView) // ID는 예시입니다.
        // 기타 필요한 뷰 바인딩
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.share_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = shareItems[position]
        holder.titleTextView.text = item.title
        // 기타 데이터 바인딩
    }

    override fun getItemCount() = shareItems.size
}