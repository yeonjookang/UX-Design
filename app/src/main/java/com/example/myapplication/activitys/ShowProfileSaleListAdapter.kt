package com.example.myapplication.activitys

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.SaleData
import com.example.myapplication.databinding.ItemSaleBinding

class ShowProfileSaleListAdapter(private val saleItems: List<SaleData>) :
    RecyclerView.Adapter<ShowProfileSaleListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // 여기에 뷰 홀더 바인딩을 위한 뷰 참조를 초기화합니다.
        val titleTextView: TextView = view.findViewById(R.id.title_of_sale)
        val userIdTextView: TextView = view.findViewById(R.id.user_id_textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sale, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = saleItems[position]
        holder.titleTextView.text = item.title
        holder.userIdTextView.text = item.userName
    }

    override fun getItemCount() = saleItems.size
}