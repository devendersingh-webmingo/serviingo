package com.serviingo.serviingo.Adapterr;

import android.content.Context;
import android.graphics.Paint;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.iarcuschin.simpleratingbar.SimpleRatingBar;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.modelrepo.Responsee.PackageReviews;
import com.serviingo.serviingo.storage.SharedPrefManager;
import com.squareup.picasso.Picasso;


public class PackageReviwAdapter extends RecyclerView.Adapter<PackageReviwAdapter.myViewHolder> {

    PackageReviews modelArrayList;
    Context context;
    int quantity;

    public PackageReviwAdapter(PackageReviews modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }

  /*  public MyPackageAdapter(subsubcategory_detailsRepo modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }*/

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlereview, parent, false);

        return new PackageReviwAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {


        holder.tvPublishDate.setText("Review Date "+modelArrayList.getData().getReviews().get(position).getReviewdate());

        holder.text_rating.setRating(Float.parseFloat(String.valueOf(modelArrayList.getData().getReviews().get(position).getRating())));
        holder.tvdate.setText(modelArrayList.getData().getReviews().get(position).getReview());
        if (modelArrayList.getData().getReviews().get(position).getGetUserInfo() != null) {

            holder.tvwallet.setText(modelArrayList.getData().getReviews().get(position).getGetUserInfo().getName());
        }

        if ((modelArrayList.getData().getReviews().get(position).getGetUserInfo().getProfilePhotoPath()!= null)) {
            Picasso.get().load(modelArrayList.getData().getReviews().get(position).getGetUserInfo().getProfilePhotoPath()).into(holder.PartnerImage);
        }


    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().getReviews().size();

    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView tvwallet, tvdate,tvPublishDate;

        SimpleRatingBar text_rating;
        ImageView PartnerImage;

        //getLifecycle().addObserver(youTubePlayerView);

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            PartnerImage= itemView.findViewById(R.id.PartnerImage);
            tvdate = itemView.findViewById(R.id.tvdate);
            tvPublishDate= itemView.findViewById(R.id.tvPublishDate);
            text_rating = itemView.findViewById(R.id.text_rating);
            tvwallet = itemView.findViewById(R.id.tvwallet);

            // ( context).addLifeCycleCallBack(youTubePlayerView);

            // context. getLifecycle().addObserver(youTubePlayerView);

        }
    }


}
