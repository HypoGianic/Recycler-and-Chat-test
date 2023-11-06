package com.hypo.chattychatchat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.hypo.chattychatchat.Adapter.ChatListAdapter;
import com.hypo.chattychatchat.MessageView.ChattingViewActivity;
import com.hypo.chattychatchat.Model.ChatList;

import java.util.ArrayList;
import java.util.List;

public class ChatListActivity extends AppCompatActivity implements ChatListAdapter.OnItemClickListener {
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);
        recyclerView=findViewById(R.id.chat_list_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<ChatList> chatList=new ArrayList<>();
        chatList.add(new ChatList("Ko Myat",R.drawable.profile));



        ChatListAdapter adapter = new ChatListAdapter(chatList, (ChatListAdapter.OnItemClickListener) this);
        recyclerView.setAdapter(adapter);



    }
    @Override
    public void onItemClick(ChatList chat) {
        Intent intent = new Intent(this,ChattingViewActivity.class);
        intent.putExtra("chatName", chat.getUserName());
        startActivity(intent);
    }


}