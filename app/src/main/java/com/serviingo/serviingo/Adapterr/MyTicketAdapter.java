package com.serviingo.serviingo.Adapterr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.serviingo.serviingo.R;
import com.serviingo.serviingo.modelrepo.Responsee.CartRepo;
import com.serviingo.serviingo.modelrepo.Responsee.MyTicketRepo;
import com.serviingo.serviingo.storage.SharedPrefManager;
import com.serviingo.serviingo.utils.util;

import de.hdodenhof.circleimageview.CircleImageView;


public class MyTicketAdapter extends RecyclerView.Adapter<MyTicketAdapter.myViewHolder> {

    MyTicketRepo modelArrayList;
    Context context;
    private TicketClick itemClickListenerr;

    public MyTicketAdapter(MyTicketRepo modelArrayList, Context context, TicketClick itemClickListenerr) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.itemClickListenerr = itemClickListenerr;
    }

   /* public MyTicketAdapter(MyTicketRepo modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }*/

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reviews_ui, parent, false);

        return new MyTicketAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.LastReplied.setVisibility(View.GONE);
        holder.viewimage.setVisibility(View.GONE);

        holder.name.setText(SharedPrefManager.getInstans(context).getfullname());
        holder.message.setText(modelArrayList.getData().getData().get(position).getQuery());
        holder.rating.setText(modelArrayList.getData().getData().get(position).getStatus());


        holder.Priority.setText(modelArrayList.getData().getData().get(position).getPriority());
        try {
            if (modelArrayList.getData().getData().get(position).getLastReply().size() > 0) {

                holder.LastReplied.setText("Last Replied :" + util.getTime(modelArrayList.getData().getData().get(position).getLastReply().get(position).getCreatedAt()));


            } else {
                holder.LastReplied.setVisibility(View.GONE);
            }
        } catch (Exception e) {

        }

        //holder.LastReplied.setText("Last Replied :" + util.getTime(modelArrayList.getData().getData().get(position).getCreatedAt()));
        if (modelArrayList.getData().getData().get(position).getDate_time() != null) {
            holder.dateandtime.setText("Created at : " + modelArrayList.getData().getData().get(position).getDate_time());

        }

        holder.ticketid.setText("Ticket ID: " + modelArrayList.getData().getData().get(position).getTicketId());
        holder.openchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListenerr.OpenTicketClick(modelArrayList, position);
            }
        });
        if (modelArrayList.getData().getData().get(position).getGetSupportQuestion() != null) {
            holder.QueryModuleTV.setVisibility(View.VISIBLE);

            holder.QuerySubjectTv.setVisibility(View.VISIBLE);

            holder.QueryModuleTV.setText("Query Module: " + modelArrayList.getData().getData().get(position).getGetSupportQuestion().getModels());
            holder.QuerySubjectTv.setText("Query Subject: " + modelArrayList.getData().getData().get(position).getGetSupportQuestion().getQueries());


        }
        if (modelArrayList.getData().getData().get(position).getFile() != null) {
            holder.viewimage.setVisibility(View.VISIBLE);
            holder.viewimage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListenerr.OpenimageClick(modelArrayList.getData().getData().get(position).getFile());
                }
            });
        }


/*

        if (modelArrayList.getData().getAddonServices().get(position).getAfterDiscount()!=null)
        {
            holder.text.setText( " \u20B9 "+modelArrayList.getData().getAddonServices().get(position).getAfterDiscount());

        }else {
            holder.text.setText( " \u20B9 "+modelArrayList.getData().getAddonServices().get(position).getAmount());

        }

        holder.tvwallet.setText(modelArrayList.getData().getAddonServices().get(position).getName());
*/


    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().getData().size();


    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView tvdate, message, rating, name, Priority, LastReplied, ticketid, QueryModuleTV, QuerySubjectTv, dateandtime;
        ImageView openchat, viewimage;
        CircleImageView circleImageView;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            message = itemView.findViewById(R.id.message);
            tvdate = itemView.findViewById(R.id.tvdate);
            dateandtime = itemView.findViewById(R.id.dateandtime);
            rating = itemView.findViewById(R.id.rating);
            name = itemView.findViewById(R.id.choosefile);
            circleImageView = itemView.findViewById(R.id.ivImages);
            Priority = itemView.findViewById(R.id.Medium);
            LastReplied = itemView.findViewById(R.id.LastReplied);
            ticketid = itemView.findViewById(R.id.ticketid);
            openchat = itemView.findViewById(R.id.openchat);
            viewimage = itemView.findViewById(R.id.viewimage);
            QueryModuleTV = itemView.findViewById(R.id.QueryModuleTV);
            QuerySubjectTv = itemView.findViewById(R.id.QuerySubjectTv);


        }
    }

    public interface TicketClick {

        void OpenTicketClick(MyTicketRepo ticketRepo, int position);

        void OpenimageClick(String imageurl);


    }
}
