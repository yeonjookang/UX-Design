package com.example.myapplication.adapters;

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.RowSellProductBinding;
import com.example.myapplication.datas.SellData;

import java.util.ArrayList;

class SellDataAdapter(val items:ArrayList<SellData>) :
    RecyclerView.Adapter<SellDataAdapter.ViewHolder>(){

    interface OnItemClickListener {
        fun OnItemClick(data:SellData)
    }

    var itemClickListener1:OnItemClickListener?=null

    inner

    class ViewHolder(val binding:RowSellProductBinding) :RecyclerView.ViewHolder(binding.root){
        init{
            binding.root.setOnClickListener{itemClickListener1?.OnItemClick(items[adapterPosition])}
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int):ViewHolder{

        var view=RowSellProductBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount():Int{
        return items.size
    }

    override fun onBindViewHolder(holder:ViewHolder,position:Int){
        holder.binding.sellTitle.text=items[position].title
        holder.binding.sellAuthor.text=items[position].author
        //이미지 정보 추가
    }
    fun getItemIndex(data:SellData):Int{
        return items.indexOf(data)
    }
}
