package com.example.myapplication.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.adapter.MessageAdapter
import com.example.myapplication.databinding.ActivityChatBinding
import com.example.myapplication.dataclass.Message
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ChatActivity : AppCompatActivity() {

    private lateinit var receiverName: String
    private lateinit var receiverUid: String

    // 바인딩 객체
    private lateinit var viewBinding: ActivityChatBinding

    lateinit var mAuth: FirebaseAuth    // 인증 객체
    lateinit var mDbRef: DatabaseReference // DB 객체

    private lateinit var receiverRoom: String   // 받는 대화방
    private lateinit var senderRoom: String // 보내는 대화방

    private lateinit var messageList: ArrayList<Message>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)


         // 초기화
        messageList = ArrayList()
        val messageAdapter: MessageAdapter = MessageAdapter(this, messageList)

        // RecyclerView
        viewBinding.chatRecyclerView.layoutManager = LinearLayoutManager(this)
        viewBinding.chatRecyclerView.adapter = messageAdapter


        // 넘어온 데이터 변수에 담기
        receiverName = intent.getStringExtra("nickname").toString()
        receiverUid = intent.getStringExtra("uId").toString()

        mAuth = FirebaseAuth.getInstance()
        mDbRef = FirebaseDatabase.getInstance().reference

        // 접속자 uId
        val senderUid = mAuth.currentUser?.uid

        // 보낸이 방
        senderRoom = receiverUid + senderUid

        // 받는 이 방
        receiverRoom = senderUid + receiverUid

        // 액션바에 상대방 이름 보여주기
        // supportActionBar?.title = receiverName

        // 메시지 전송 버튼 이벤트 (메시지 DB에 저장하고, 입력메시지 화면에 보여주기)
        viewBinding.sendBtn.setOnClickListener{
            val message = viewBinding.messageEdit.text.toString()
            val messageObject = Message(message, senderUid)

            // 데이터 저장
            mDbRef.child("chats").child(senderRoom).child("messages").push()
                .setValue(messageObject).addOnSuccessListener {
                    // 저장 성공하면 -> 받는 쪽에도 데이터 저장
                    mDbRef.child("chats").child(receiverRoom).child("messages").push()
                        .setValue(messageObject)
                }
            // 입력 값 초기화
            viewBinding.messageEdit.setText("")
        }

        // 메시지 가져오기
        // chats/senderRoom/messages 안의 데이터가 변경되면 onDataChange 함수 호출됨
        mDbRef.child("chats").child(senderRoom).child("messages")
            .addValueEventListener(object: ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    messageList.clear()

                    for(postSnapshot in snapshot.children){
                        val message = postSnapshot.getValue(Message::class.java)
                        messageList.add(message!!)
                    }
                    // 적용
                    messageAdapter.notifyDataSetChanged()
                }

                override fun onCancelled(error: DatabaseError) {

                }

            })
    }
}