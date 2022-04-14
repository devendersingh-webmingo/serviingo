package com.serviingo.serviingo.Adapterr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.serviingo.serviingo.R;
import com.serviingo.serviingo.modelrepo.Responsee.IncompletedBookingRepo;
import com.serviingo.serviingo.utils.util;
import com.squareup.picasso.Picasso;


public class IncompltedBookingAdapter extends RecyclerView.Adapter<IncompltedBookingAdapter.myViewHolder> {

    IncompletedBookingRepo modelArrayList;
    Context context;
    private IncompltedBooking itemClickListenerr;

    public IncompltedBookingAdapter(IncompletedBookingRepo modelArrayList, Context context, IncompltedBooking itemClickListenerr) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.itemClickListenerr = itemClickListenerr;
    }

  /*  public IncompltedBookingAdapter(Context context) {
        this.context = context;
    }*/

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.incompletebooking_items, parent, false);

        return new IncompltedBookingAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.title.setText(modelArrayList.getData().getIncompleteOrders().getData().get(position).getGetPackageInfo().getName());
        String dateAndTime = util.getDate(modelArrayList.getData().getIncompleteOrders().getData().get(position).getCreatedAt());
        String dateAndTimee = util.getTime(modelArrayList.getData().getIncompleteOrders().getData().get(position).getCreatedAt());
        //Picasso.get().load(modelArrayList.getData().getCategories().get(position).getImage()).into(holder.ivimageone);
        holder.dateandtimeTv.setText(modelArrayList.getData().getIncompleteOrders().getData().get(position).getTemp_created_time() );
        if (modelArrayList.getData().getIncompleteOrders().getData().get(position).getServing_datetime() != null) {
            holder.servedatetime.setText(modelArrayList.getData().getIncompleteOrders().getData().get(position).getServing_datetime());
        } else {
            holder.servedatetime.setVisibility(View.GONE);
            holder.servedatetimetv.setVisibility(View.GONE);
        }


        if (modelArrayList.getData().getIncompleteOrders().getData().get(position).getMembershipId() != null) {
            holder.memebershipstatus.setText("Yes");
        }

        Picasso.get().load(modelArrayList.getData().getIncompleteOrders().getData().get(position).getGetPackageInfo().getPackageImage().getBaseUrl()+modelArrayList.getData().getIncompleteOrders().getData().get(position).getGetPackageInfo().getPackageImage().getImage()).into(holder.imageView);

        holder.editImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListenerr.EditClickk(modelArrayList, position);
            }
        });
        holder.deleteimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListenerr.Deletelclick(String.valueOf(modelArrayList.getData().getIncompleteOrders().getData().get(position).getId()), position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().getIncompleteOrders().getData().size();


    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView, editImage, deleteimage;
        TextView title, dateandtimeTv, memebershipstatus, servedatetime, servedatetimetv;
        RelativeLayout clickRL;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.title);
            servedatetimetv = itemView.findViewById(R.id.servedatetimetv);
            dateandtimeTv = itemView.findViewById(R.id.dateandtimeTv);
            memebershipstatus = itemView.findViewById(R.id.memebershipstatus);
            servedatetime = itemView.findViewById(R.id.servedatetime);
            editImage = itemView.findViewById(R.id.editImage);
            deleteimage = itemView.findViewById(R.id.deleteimage);

        }
    }

    public interface IncompltedBooking {

        void EditClickk(IncompletedBookingRepo repo, int pos);

        void Deletelclick(String id, int pos);

    }
}
