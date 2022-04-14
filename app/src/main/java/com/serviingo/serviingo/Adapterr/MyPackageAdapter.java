package com.serviingo.serviingo.Adapterr;

import android.app.Activity;
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
import com.serviingo.serviingo.Activity.HomeActivity;
import com.serviingo.serviingo.Activity.MainActivity;
import com.serviingo.serviingo.Fragments.LowcontactFragment;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.modelrepo.Responsee.CartRepo;
import com.serviingo.serviingo.modelrepo.Responsee.MyRatingAndReviewRespooo;
import com.serviingo.serviingo.modelrepo.Responsee.MywalletRespo;
import com.serviingo.serviingo.modelrepo.Responsee.PackagesRepo;
import com.serviingo.serviingo.modelrepo.Responsee.subsubcategory_detailsRepo;
import com.serviingo.serviingo.storage.SharedPrefManager;
import com.serviingo.serviingo.utils.AppUrls;
import com.serviingo.serviingo.utils.util;
import com.squareup.picasso.Picasso;


public class MyPackageAdapter extends RecyclerView.Adapter<MyPackageAdapter.myViewHolder> {

    PackagesRepo modelArrayList;
    Context context;
    int quantity;
    private AddToCartListener itemClickListenerr;

    public MyPackageAdapter(PackagesRepo modelArrayList, Context context, AddToCartListener itemClickListenerr) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.itemClickListenerr = itemClickListenerr;
    }

  /*  public MyPackageAdapter(subsubcategory_detailsRepo modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }*/

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_vieww, parent, false);

        return new MyPackageAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
      /*  if (modelArrayList.getData().getPackages().get(position).getName()==null)
        {
            holder.cardView.setVisibility(View.GONE);
        }
*/
        /*  try {*/
        holder.time.setText(modelArrayList.getData().getPackages().get(position).getTimer() + "min");


        holder.tvCutPrice.setPaintFlags(holder.tvCutPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        if (modelArrayList.getData().getPackages().get(position).getDiscount() == null) {

            holder.tvPrice.setText(" \u20B9 " + modelArrayList.getData().getPackages().get(position).getAmount());
            holder.tvCutPrice.setVisibility(View.GONE);
            holder.tvMainPrice.setVisibility(View.GONE);

        } else if (!modelArrayList.getData().getPackages().get(position).getDiscount().equalsIgnoreCase("0")) {
            holder.tvPrice.setText(" \u20B9 " + modelArrayList.getData().getPackages().get(position).getAfterDiscount());
            holder.tvCutPrice.setText(" \u20B9 " + modelArrayList.getData().getPackages().get(position).getAmount());
            holder.tvMainPrice.setText(modelArrayList.getData().getPackages().get(position).getDiscount() + "% off");

        } else {
            holder.tvPrice.setText(" \u20B9 " + modelArrayList.getData().getPackages().get(position).getAmount());
            holder.tvCutPrice.setVisibility(View.GONE);
            holder.tvMainPrice.setVisibility(View.GONE);


        }
        holder.tvwallet.setText(modelArrayList.getData().getPackages().get(position).getName());
        if (modelArrayList.getData().getPackages().get(position).getAboutPackage() != null) {
            holder.text.setText(Html.fromHtml(modelArrayList.getData().getPackages().get(position).getAboutPackage()));

        }


        if (modelArrayList.getData().getPackages().get(position).getVideo() != null) {

            holder.imageView.setVisibility(View.GONE);
            holder.youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                @Override
                public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                    String videoId = (String) modelArrayList.getData().getPackages().get(position).getVideo();
                    //  youTubePlayer.loadVideo(videoId, 0);
                }
            });

        } else {
            //  holder.tvPrice.setText(" \u20B9 " + data.get(position).get("after_discount"));
            holder.imageView.setVisibility(View.VISIBLE);

            holder.youTubePlayerView.setVisibility(View.GONE);
        }
        if (modelArrayList.getData().getPackages().get(position).getGetOneRelatedImage().size() > 0) {
            Picasso.get().load(modelArrayList.getData().getImageBaseUrl() + modelArrayList.getData().getPackages().get(position).getGetOneRelatedImage().get(0).getImage()).into(holder.imageView);

        }
//   AppTools.setImgPicasso(AppUrls.BASEServicesimagepath + data.get(position).get("icon"),mActivity,holder.imageView);





/*
        } catch (Exception e) {

        }*/

        holder.tvgreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPrefManager.getInstance(context)
                        .SetSerivceID(modelArrayList.getData().getPackages().get(position).getServiceId());
                itemClickListenerr.AddToCartClick(String.valueOf(modelArrayList.getData().getPackages().get(position).getId()), position,
                        holder.quentityTv.getText().toString());
                // Toast.makeText(context, "Add to cart Package Adapter", Toast.LENGTH_SHORT).show();

            }
        });

        holder.updateCartDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (quantity > 1) {
                    quantity--;

                    holder.quentityTv.setText(String.valueOf(quantity));

                    itemClickListenerr.DecressQuentity(String.valueOf(quantity), position, modelArrayList);

                }


            }
        });
        holder.updateCartIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                quantity = Integer.parseInt(holder.quentityTv.getText().toString());
                quantity++;
                holder.quentityTv.setText(String.valueOf(quantity));

                itemClickListenerr.IncreaseQuentity(String.valueOf(quantity), position, modelArrayList);


            }
        });
        // if (modelArrayList.getData().getPackages().get(position).ge)
        holder.tv_viewDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListenerr.ViewDetails(String.valueOf(modelArrayList.getData().getPackages().get(position).getId()), position);
                //     Toast.makeText(context, "Package Adapter", Toast.LENGTH_SHORT).show();

            }
        });
        if (modelArrayList.getData().getPackages().get(position).getGetRating().getRating() > 0) {

            holder.text_rating.setRating(Float.parseFloat(String.valueOf(modelArrayList.getData().getPackages().get(position).getGetRating().getRating())));
            holder.tvdate.setText(String.valueOf(modelArrayList.getData().getPackages().get(position).getGetRating().getUserCount()) + " ratings");
            holder.iconinfoIV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    itemClickListenerr.ReviewClickDetails(String.valueOf(modelArrayList.getData().getPackages().get(position).getId()), position);


                }
            });

        } else {

            holder.text_rating.setVisibility(View.GONE);
            holder.iconinfoIV.setVisibility(View.GONE);

            holder.tvdate.setVisibility(View.GONE);
        }


    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().getPackages().size();

    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView tvwallet, tv_viewDetail, tvdate, tvPrice, tvCutPrice, tvMainPrice, text, quentityTv, time;
        ImageView imageView, iconinfoIV;
        YouTubePlayerView youTubePlayerView;
        TextView tvgreen;

        ImageView updateCartDecrease, updateCartIncrease;
        SimpleRatingBar text_rating;
        CardView cardView;

        //getLifecycle().addObserver(youTubePlayerView);

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            quentityTv = itemView.findViewById(R.id.quentityTv);
            updateCartDecrease = itemView.findViewById(R.id.updateCartDecrease);
            updateCartIncrease = itemView.findViewById(R.id.updateCartIncrease);
            imageView = itemView.findViewById(R.id.imageView);
            iconinfoIV = itemView.findViewById(R.id.iconinfoIV);
            text_rating = itemView.findViewById(R.id.text_rating);
            tvwallet = itemView.findViewById(R.id.tvwallet);
            time = itemView.findViewById(R.id.time);
            tvdate = itemView.findViewById(R.id.tvdate);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvCutPrice = itemView.findViewById(R.id.tvCutPrice);
            tvMainPrice = itemView.findViewById(R.id.tvMainPrice);
            tvgreen = itemView.findViewById(R.id.tvgreen);
            text = itemView.findViewById(R.id.text);
            tv_viewDetail = itemView.findViewById(R.id.tv_viewDetail);
            youTubePlayerView = itemView.findViewById(R.id.youtube_player_view);

            youTubePlayerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListenerr.addLifeCycleCallBack(youTubePlayerView);

                }
            });

            // ( context).addLifeCycleCallBack(youTubePlayerView);

            // context. getLifecycle().addObserver(youTubePlayerView);

        }
    }

    public interface AddToCartListener {

        void AddToCartClick(String id, int position, String Quentiy);

        void addLifeCycleCallBack(YouTubePlayerView youTubePlayerView);

        void IncreaseQuentity(String Quentity, int position, PackagesRepo packagesRepo);

        void DecressQuentity(String Quentity, int position, PackagesRepo packagesRepo);

        void ViewDetails(String id, int position);

        void ReviewClickDetails(String id, int position);


    }

}
