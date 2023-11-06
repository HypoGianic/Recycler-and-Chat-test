package com.hypo.chattychatchat.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hypo.chattychatchat.Model.ChatList;
import com.hypo.chattychatchat.R;

import java.util.List;

public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.ViewHolder> {
    private List<ChatList> chatList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(ChatList chat);
    }

    public ChatListAdapter(List<ChatList> chatList, OnItemClickListener listener) {
        this.chatList = chatList;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.friend_list_view_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ChatList item = chatList.get(position);
        holder.tvUserName.setText(item.getUserName());
        holder.imvUserImage.setImageResource(item.getImageResource());

    }


    @Override
    public int getItemCount() {
        return chatList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvUserName;
        ImageView imvUserImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUserName = itemView.findViewById(R.id.chat_List_user_name);
            imvUserImage = itemView.findViewById(R.id.circularImageView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && listener != null) {
                        listener.onItemClick(chatList.get(position));

                    }
                }
            });
        }

    }
}
