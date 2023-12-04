package com.example.myapplication.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.activitys.ChatActivity
import com.example.myapplication.dataclass.User

class UserAdapter(private val context: Context, private val userList: ArrayList<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>(){

    /**
     * 화면 설정 - user layout을 연결하는 기능
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.user_layout, parent, false)

        return UserViewHolder(view)
    }

    // userList의 갯수 리턴
    override fun getItemCount(): Int {
        return userList.size
    }

    /**
     * 데이터 설정 - 데이터를 전달받아 user_layout에 보여주는 기능
     */
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        // 데이터 담기
        val currentUser = userList[position]
        // 화면에 데이터 보여주기
        holder.nicknameText.text = currentUser.nickname
        // 아이템 클릭 이벤트
        holder.itemView.setOnClickListener{
            val intent = Intent(context, ChatActivity::class.java)
            // 넘길 데이터
            intent.putExtra("nickname", currentUser.nickname)
            intent.putExtra("uId", currentUser.uId)

            context.startActivity(intent)
        }
    }


    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val nicknameText: TextView = itemView.findViewById(R.id.nickname_text)
    }
}