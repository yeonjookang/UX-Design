package com.example.myapplication.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.adapter.UserAdapter
import com.example.myapplication.databinding.FragmentChatListBinding
import com.example.myapplication.dataclass.User
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database

class ChatListFragment : Fragment() {
    private lateinit var viewBinding: FragmentChatListBinding
    lateinit var adapter: UserAdapter

    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDbRef: DatabaseReference

    private lateinit var userList: ArrayList<User>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewBinding = FragmentChatListBinding.inflate(layoutInflater)

        mAuth = Firebase.auth
        mDbRef = Firebase.database.reference

        // 유저리스트 초기화
        userList = ArrayList()
        adapter = UserAdapter(requireContext(), userList)

        viewBinding.userRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewBinding.userRecyclerView.adapter = adapter

        // 사용자 정보 가져오기
        mDbRef.child("user").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (postSnapshot in snapshot.children) {

                    // 유저 정보 - 나 제외한 나머지 유저들 정보
                    val currentUser = postSnapshot.getValue(User::class.java)

                    if (mAuth.currentUser?.uid != currentUser?.uId) {
                        userList.add(currentUser!!)
                    }
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                // 실패 시 실행
            }
        })

        return viewBinding.root
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu, menu)
//
//        return super.onCreateOptionsMenu(menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if(item.itemId == R.id.log_out){
//            mAuth.signOut() //로그아웃
//
//            //로그인 액티비티로 이동
//            val intent = Intent(this@MainActivity, LogInActivity::class.java)
//            startActivity(intent)
//            finish()
//            return true
//        }
//        return true
//    }

}
