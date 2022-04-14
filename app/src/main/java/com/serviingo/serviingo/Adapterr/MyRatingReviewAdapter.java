package com.serviingo.serviingo.Adapterr;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.serviingo.serviingo.R;
import com.serviingo.serviingo.callback.ItemClickListenerr;
import com.serviingo.serviingo.modelrepo.Responsee.MyRatingAndReviewRespo;
import com.serviingo.serviingo.modelrepo.Responsee.MyRatingAndReviewRespooo;
import com.serviingo.serviingo.utils.util;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class MyRatingReviewAdapter extends RecyclerView.Adapter<MyRatingReviewAdapter.myViewHolder> {
    MyRatingAndReviewRespooo modelArrayList;
    Context context;
    OnReviewItemListener onReviewItemListener;


    public MyRatingReviewAdapter(MyRatingAndReviewRespooo modelArrayList, Context context, OnReviewItemListener onReviewItemListener) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.onReviewItemListener = onReviewItemListener;

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_rating, parent, false);
        return new MyRatingReviewAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        if (modelArrayList.getData().get(position).getRatingReviews()!=null) {
            holder.RateReview.setVisibility(View.GONE);
            holder.tvdelete.setVisibility(View.VISIBLE);
            holder.LLOrder.setVisibility(View.VISIBLE);
        }else {
            holder.RateReview.setVisibility(View.VISIBLE);
            holder.tvdelete.setVisibility(View.GONE);
            holder.LLOrder.setVisibility(View.GONE);

        }

       holder.tvhead.setText(modelArrayList.getData().get(position).getPackage().getName());
        holder.tvtext.setText(Html.fromHtml(String.valueOf(modelArrayList.getData().get(position).getPackage().getAboutPackage())));
        String dateAndTime = modelArrayList.getData().get(position).getCreatedAt();
       /// holder.tvdate.setText("Date:- "+util.getDate(dateAndTime));
        holder.tvTime.setText(modelArrayList.getData().get(position).getServing_datetime());
        holder.tvordernumber.setText("Order No:- "+modelArrayList.getData().get(position).getOrderNumber());
        holder.tvwallet.setText(modelArrayList.getData().get(position).getTotalAmount());


        Picasso.get().load(modelArrayList.getData().get(position).getPackage().getPackageImage().getBaseUrl()+modelArrayList.getData().get(position).getPackage().getPackageImage().getImage()).into(holder.profile_image);
        if (modelArrayList.getData().get(position).getVendorSomeInfo()!=null)
        {

            holder. tvvendorname.setText("Vendor Name:- "+modelArrayList.getData().get(position).getVendorSomeInfo().getFirstName());
        }


        holder.RateReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onReviewItemListener.AddReviewonClick(modelArrayList, position);

            }
        });
        holder.tvEditReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onReviewItemListener.EditReviewonClick(modelArrayList, position);

            }
        });
        holder.tvdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onReviewItemListener.DeleteReviewonClick(modelArrayList, position);

            }
        });
        holder.imagenext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onReviewItemListener.imagenextClick(modelArrayList, position);

            }
        });




        //holder.tvaddress.setText( modelArrayList.getData().getAddress().get(position).getGetState().getName();


    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().size();

    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView tvhead,tvvendorname, tvdate,tvordernumber, tvTime, tvwallet, tvEditReview, tvcomplete, tvdelete, RateReview,tvtext;
        LinearLayout LLOrder;
        CircleImageView profile_image;
        ImageView imagenext;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            tvhead = itemView.findViewById(R.id.tvhead);
            tvordernumber= itemView.findViewById(R.id.tvordernumber);
            tvdate = itemView.findViewById(R.id.tvdate);
            tvTime = itemView.findViewById(R.id.tvTime);
            tvwallet = itemView.findViewById(R.id.tvwallet);
            tvEditReview = itemView.findViewById(R.id.tvEditReview);
            tvcomplete = itemView.findViewById(R.id.tvcomplete);
            tvdelete = itemView.findViewById(R.id.tvdelete);
            RateReview = itemView.findViewById(R.id.RateReview);
            LLOrder = itemView.findViewById(R.id.LLOrder);
            tvtext = itemView.findViewById(R.id.tvtext);
            profile_image= itemView.findViewById(R.id.profile_image);
            imagenext= itemView.findViewById(R.id.imagenext);
            tvvendorname= itemView.findViewById(R.id.tvvendorname);
        }


    }

    public interface OnReviewItemListener {

        void AddReviewonClick(MyRatingAndReviewRespooo data, int position);

        void EditReviewonClick(MyRatingAndReviewRespooo data, int position);

        void DeleteReviewonClick(MyRatingAndReviewRespooo data, int position);
        void imagenextClick(MyRatingAndReviewRespooo data, int position);


    }

}
