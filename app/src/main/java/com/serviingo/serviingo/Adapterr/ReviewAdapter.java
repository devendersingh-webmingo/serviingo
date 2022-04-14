package com.serviingo.serviingo.Adapterr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.serviingo.serviingo.R;
import com.serviingo.serviingo.modelrepo.Responsee.CategoriesDetailsRepo;
import com.squareup.picasso.Picasso;


public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.myViewHolder> {

    CategoriesDetailsRepo modelArrayList;
    Context context;

    public ReviewAdapter(CategoriesDetailsRepo modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapterreview, parent, false);

        return new ReviewAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        if (modelArrayList.getData().getCategory().getCategoryRating().getReviews().get(position).getGetUserInfo() != null) {

            holder.choosefile.setText(modelArrayList.getData().getCategory().getCategoryRating().getReviews().get(position).getGetUserInfo().getName());
            holder.addressTV.setText(modelArrayList.getData().getCategory().getCategoryRating().getReviews().get(position).getGetUserInfo().getGetCity().getName() + ", " + modelArrayList.getData().getCategory().getCategoryRating().getReviews().get(position).getGetUserInfo().getGetState().getName());

            if ((modelArrayList.getData().getCategory().getCategoryRating().getReviews().get(position).getGetUserInfo().getProfilePhotoPath() != null)) {
                Picasso.get().load(modelArrayList.getData().getCategory().getCategoryRating().getImageBaseUrl() + modelArrayList.getData().getCategory().getCategoryRating().getReviews().get(position).getGetUserInfo().getProfilePhotoPath()).into(holder.ivImages);

            }


        }




        holder.tvdate.setText(modelArrayList.getData().getCategory().getCategoryRating().getReviews().get(position).getRating() );

        holder.newText.setText(modelArrayList.getData().getCategory().getCategoryRating().getReviews().get(position).getReview());


    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().getCategory().getCategoryRating().getReviews().size();


    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView choosefile, tvdate, newText, addressTV;
        ImageView ivImages;

        LinearLayout ll;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            tvdate = itemView.findViewById(R.id.tvdate);
            choosefile = itemView.findViewById(R.id.choosefile);
            newText = itemView.findViewById(R.id.newText);
            addressTV = itemView.findViewById(R.id.addressTV);
            ivImages = itemView.findViewById(R.id.ivImages);

            ll = itemView.findViewById(R.id.ll);
        }
    }
   /* public interface CheckBoxListener {

        void CheckedClick(String id, int position,Boolean bb);


    }*/
}
