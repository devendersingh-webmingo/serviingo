package com.serviingo.serviingo.Adapterr;

import android.content.Context;
import android.graphics.Paint;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.modelrepo.Responsee.Subcategory_detailsRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Subcategory_detailsRepo;
import com.squareup.picasso.Picasso;


public class SubcategoryAdapter extends RecyclerView.Adapter<SubcategoryAdapter.myViewHolder> {

    Subcategory_detailsRepo modelArrayList;
    Context context;

    private AddToCartListener itemClickListenerr;

    public SubcategoryAdapter(Subcategory_detailsRepo modelArrayList, Context context, AddToCartListener itemClickListenerr) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.itemClickListenerr = itemClickListenerr;
    }

  /*  public MyPackageAdapter(Subcategory_detailsRepo modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }*/

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_view, parent, false);

        return new SubcategoryAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.tvCutPrice.setText(" \u20B9 " + modelArrayList.getData().getPackages().get(position).getAmount());
        holder.tvCutPrice.setPaintFlags(holder.tvCutPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        holder.tvMainPrice.setText(modelArrayList.getData().getPackages().get(position).getDiscount() + "% off");
        holder.tvPrice.setText(" \u20B9 " + modelArrayList.getData().getPackages().get(position).getAfterDiscount());
        holder.tvwallet.setText(modelArrayList.getData().getPackages().get(position).getName());
        holder.text.setText(Html.fromHtml(modelArrayList.getData().getPackages().get(position).getAboutPackage()));

        if(modelArrayList.getData().getPackages().get(position).getVideo()!=null){

            holder.imageView.setVisibility(View.GONE);
            holder.youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                @Override
                public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                    String videoId = (String) modelArrayList.getData().getPackages().get(position).getVideo();
                    youTubePlayer.loadVideo(videoId, 0);
                }
            });

        }else{
          //  holder.tvPrice.setText(" \u20B9 " + data.get(position).get("after_discount"));
            holder.imageView.setVisibility(View.VISIBLE);

            holder.youTubePlayerView.setVisibility(View.GONE);
        }
       // Picasso.get().load(modelArrayList.getData().getSubsubCategoryImagePath() + modelArrayList.getData().getSubsubCategory().getIcon()).into(holder.imageView);
//   AppTools.setImgPicasso(AppUrls.BASEServicesimagepath + data.get(position).get("icon"),mActivity,holder.imageView);


        holder.tvgreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListenerr.AddToCartClick(String.valueOf(modelArrayList.getData().getPackages().get(position).getId()), position);

            }
        });


    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().getPackages().size();

    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView tvwallet, tvdate, tvPrice, tvCutPrice, tvMainPrice, text;
        CardView tvgreen;

        ImageView imageView;
        YouTubePlayerView youTubePlayerView;
        //getLifecycle().addObserver(youTubePlayerView);

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            tvwallet = itemView.findViewById(R.id.tvwallet);
           // tvdate = itemView.findViewById(R.id.tvdate);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvCutPrice = itemView.findViewById(R.id.tvCutPrice);
            tvMainPrice = itemView.findViewById(R.id.tvMainPrice);
            tvgreen = itemView.findViewById(R.id.tvgreen);
            text = itemView.findViewById(R.id.text);
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

        void AddToCartClick(String id, int position);

        void addLifeCycleCallBack(YouTubePlayerView youTubePlayerView);

    }

}
