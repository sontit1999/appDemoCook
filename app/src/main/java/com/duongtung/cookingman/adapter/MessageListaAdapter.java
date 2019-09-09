package com.duongtung.cookingman.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.duongtung.cookingman.R;
import com.duongtung.cookingman.model.Message;

import java.util.List;

public class MessageListaAdapter extends RecyclerView.Adapter<MessageListaAdapter.MessageViewHolder>{
    private Context mContext;
    private List<Message> listMessage;


    public static final int SEND = 1;
    public static final int RECIVE = 2;



    public MessageListaAdapter(List<Message> list ) {
        listMessage = list;
    }

    @Override
    public int getItemViewType(int position) {
        switch (listMessage.get(position).getSender().getId()){
            case 1: return SEND ;
            case 2: return RECIVE;
        }

         return 5;
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case SEND:
                View itemView0 = li.inflate(R.layout.item_chat_sent, parent, false);
                return new MessageViewHolder(itemView0);
            case RECIVE:
                View itemView1 = li.inflate(R.layout.item_chat_recive, parent, false);
                return new MessageViewHolder(itemView1);

            default:
                break;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        holder.bind(listMessage.get(position));
    }


    @Override
    public int getItemCount() {
        return listMessage.size();
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {
        private TextView tvMessage;
        private TextView tvTime;
        private ImageView iv_avatar;

        public MessageViewHolder(View itemView) {
            super(itemView);
            tvMessage = (TextView) itemView.findViewById(R.id.tv_message);
            tvTime = (TextView) itemView.findViewById(R.id.tv_time);
            iv_avatar = (ImageView) itemView.findViewById(R.id.iv_avatar);

        }

        public void bind(Message message){
            tvMessage.setText(message.getMessage());
            tvTime.setText(message.getSendAt());
            Glide.with(tvMessage.getContext())
                    .load(message.getSender().getProfileUrl())
                    .into(iv_avatar);
        }
    }
    public void addMessage(Message message){
        listMessage.add(message);
        notifyDataSetChanged();
    }
}
