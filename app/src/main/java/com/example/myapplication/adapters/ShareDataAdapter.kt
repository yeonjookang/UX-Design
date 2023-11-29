package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.RowShareProductBinding
import com.example.myapplication.datas.ShareData
import java.util.ArrayList

class ShareDataAdapter (val items: ArrayList<ShareData>) :
    RecyclerView.Adapter<ShareDataAdapter.ViewHolder>(){

    interface OnItemClickListener {
        fun OnItemClick(data: ShareData)
    }

    var itemClickListener1:OnItemClickListener?=null

    inner

    class ViewHolder(val binding: RowShareProductBinding) : RecyclerView.ViewHolder(binding.root){
        init{
            binding.root.setOnClickListener{itemClickListener1?.OnItemClick(items[adapterPosition])}
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int):ViewHolder{

        var view= RowShareProductBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount():Int{
        return items.size
    }

    override fun onBindViewHolder(holder:ViewHolder,position:Int){
        holder.binding.shareTitle.text=items[position].title
        holder.binding.shareAuthor.text=items[position].author
        //이미지 정보 추가
    }
    fun getItemIndex(data: ShareData):Int{
        return items.indexOf(data)
    }
}