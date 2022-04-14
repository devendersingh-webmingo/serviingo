package com.serviingo.serviingo.Adapterr;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.serviingo.serviingo.R;
import com.serviingo.serviingo.modelrepo.Responsee.CartRepo;
import com.serviingo.serviingo.modelrepo.Responsee.TicketChatListRepo;
import com.serviingo.serviingo.storage.SharedPrefManager;
import com.serviingo.serviingo.utils.util;


public class TicketchatListAdapter extends RecyclerView.Adapter<TicketchatListAdapter.myViewHolder> {

    TicketChatListRepo modelArrayList;
    Context context;
    private MessageClickListener itemClickListenerr;


    public static final int MSG_TYPE_LEFT = 0;
    public static final int MSG_TYPE_RIGHT = 1;

    public TicketchatListAdapter(TicketChatListRepo modelArrayList, Context context, MessageClickListener itemClickListenerr) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.itemClickListenerr = itemClickListenerr;

    }

    /*   public TicketchatListAdapter(TicketChatListRepo modelArrayList, Context context) {
           this.modelArrayList = modelArrayList;
           this.context = context;
       }
   */
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        if (viewType == MSG_TYPE_RIGHT) {
            View view = LayoutInflater.from(context).inflate(R.layout.chat_item_right, parent, false);
            return new TicketchatListAdapter.myViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.chat_item_left, parent, false);
            return new TicketchatListAdapter.myViewHolder(view);
        }

        /*
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item_left, parent, false);

        return new TicketchatListAdapter.myViewHolder(view);*/
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.show_message.setVisibility(View.GONE);
        holder.date.setText(modelArrayList.data.chats.get(position).message);
        if (modelArrayList.data.chats.get(position).file != null) {
            holder.show_message.setVisibility(View.VISIBLE);

            //  holder.show_message.setText(String.valueOf(modelArrayList.data.chats.get(position).file));
        }
        String dateAndTime = util.getTime(modelArrayList.data.chats.get(position).createdAt);
        String day = util.getDate(modelArrayList.data.chats.get(position).createdAt);

        ///holder.time.setText(dateAndTime + day);
        holder.time.setText(modelArrayList.data.chats.get(position).date_time);

        holder.show_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListenerr.ViewMediaClick(modelArrayList, position);

            }
        });

    }

    @Override
    public int getItemCount() {
        return modelArrayList.data.chats.size();

    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView date, show_message, time;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.date);
            show_message = itemView.findViewById(R.id.show_message);
            time = itemView.findViewById(R.id.time);
        }
    }

    @Override
    public int getItemViewType(int position) {
        //   fuser = FirebaseAuth.getInstance().getCurrentUser();

        if (modelArrayList.data.chats.get(position).userId==Integer.valueOf(SharedPrefManager.getInstans(context).GetUserID())) {
            return MSG_TYPE_RIGHT;
        } else {


            return MSG_TYPE_LEFT;
        }
    }

    public interface MessageClickListener {

        void ViewMediaClick(TicketChatListRepo repo, int position);


    }
}
