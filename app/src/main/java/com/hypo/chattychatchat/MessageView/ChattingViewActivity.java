package com.hypo.chattychatchat.MessageView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import com.hypo.chattychatchat.MessageView.Message;


import androidx.appcompat.app.AppCompatActivity;

import com.hypo.chattychatchat.R;

import java.util.ArrayList;

public class ChattingViewActivity extends AppCompatActivity {
    private ListView messageListView;
    private EditText messageEditText;
    private Button sendButton;
    private ArrayList<Message> messages;
    private ArrayAdapter<Message> messageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting_view);

        messageListView = findViewById(R.id.message_List_View);
        messageEditText = findViewById(R.id.message_Edit_Text);
        sendButton = findViewById(R.id.send_Button);

        messages = new ArrayList<>();
        messageAdapter = new ArrayAdapter<>(this, R.layout.message_item, R.id.messageTextView, messages);
        messageListView.setAdapter(messageAdapter);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messageContent = messageEditText.getText().toString();
                if (!messageContent.isEmpty()) {
                    Message message = new Message(messageContent, true);
                    messages.add(message);
                    messageAdapter.notifyDataSetChanged();
                    messageListView.smoothScrollToPosition(messages.size() - 1);
                    messageEditText.setText("");
                }
            }
        });
    }
}
