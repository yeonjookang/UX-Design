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
        val titleTextView: TextView = view.findViewById(R.id.title_of_share)
        val userIdTextView: TextView = view.findViewById(R.id.user_id_textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_share, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = shareItems[position]
        holder.titleTextView.text = item.title
        holder.userIdTextView.text = item.userName
    }

    override fun getItemCount() = shareItems.size
}