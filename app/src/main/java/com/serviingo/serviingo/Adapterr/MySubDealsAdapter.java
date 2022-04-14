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
import com.serviingo.serviingo.storage.SharedPrefManager;


public class MySubDealsAdapter extends RecyclerView.Adapter<MySubDealsAdapter.myViewHolder> {

    Subcategory_detailsRepo modelArrayList;
    Context context;
    int quantity;
    private AddToCartListener itemClickListenerr;

    public MySubDealsAdapter(Subcategory_detailsRepo modelArrayList, Context context, AddToCartListener itemClickListenerr) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.itemClickListenerr = itemClickListenerr;
    }

  /*  public MyPackageAdapter(subSubcategory_detailsRepo modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }*/

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_vieww, parent, false);

        return new MySubDealsAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

            holder.tvCutPrice.setText(" \u20B9 " + modelArrayList.getData().getDeals().get(position).getAmount());
            holder.time.setText( modelArrayList.getData().getDeals().get(position).getTimer()+"min");


            holder.tvCutPrice.setPaintFlags(holder.tvCutPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            holder.tvMainPrice.setText(modelArrayList.getData().getDeals().get(position).getDiscount() + "% off");
            holder.tvPrice.setText(" \u20B9 " + modelArrayList.getData().getDeals().get(position).getAfterDiscount());
            holder.tvwallet.setText(modelArrayList.getData().getDeals().get(position).getName());
            holder.text.setText(Html.fromHtml(modelArrayList.getData().getDeals().get(position).getAboutPackage()));
            //  holder.tvdate.setText(modelArrayList.getData().t);


            if(modelArrayList.getData().getDeals().get(position).getVideo()!=null){

                holder.imageView.setVisibility(View.GONE);
                holder.youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                        String videoId = (String) modelArrayList.getData().getDeals().get(position).getVideo();
                        //  youTubePlayer.loadVideo(videoId, 0);
                    }
                });

            }else{
                //  holder.tvPrice.setText(" \u20B9 " + data.get(position).get("after_discount"));
                holder.imageView.setVisibility(View.VISIBLE);

                holder.youTubePlayerView.setVisibility(View.GONE);
            }
           /* if ( modelArrayList.getData().getDeals().get(position).getGetOneRelatedImage().size()>0)
            {
                Picasso.get().load(modelArrayList.getData().getImageBaseUrl() + modelArrayList.getData().getDeals().get(position).getGetOneRelatedImage().get(0).getImage()).into(holder.imageView);

            }*/
//   AppTools.setImgPicasso(AppUrls.BASEServicesimagepath + data.get(position).get("icon"),mActivity,holder.imageView);


            holder.tvgreen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPrefManager.getInstance(context)
                            .SetSerivceID(modelArrayList.getData().getDeals().get(position).getServiceId());

                    itemClickListenerr.AddToCartClick(String.valueOf(modelArrayList.getData().getDeals().get(position).getId()), position,
                            holder.quentityTv.getText().toString());

                }
            });

            holder. updateCartDecrease.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (quantity > 1) {
                        quantity--;

                        holder.quentityTv.setText(String.valueOf(quantity));

                        itemClickListenerr.DecressQuentity(String.valueOf(quantity),position,modelArrayList);

                    }





                }
            });
            holder. updateCartIncrease.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    quantity = Integer.parseInt(holder.quentityTv.getText().toString());
                    quantity++;
                    holder.quentityTv.setText(String.valueOf(quantity));

                    itemClickListenerr.IncreaseQuentity(String.valueOf(quantity),position,modelArrayList);


             /*   quantity = Integer.parseInt(holder.quentityTv.getText().toString());
                quantity++;
                holder.quentityTv.setText(String.valueOf(quantity));
                finalprice = price + finalprice;
              //  tv.setText(String.valueOf(finalprice));

                Toast.makeText(context,

                        finalprice + "", Toast.LENGTH_SHORT).show();



*/




                }
            });

            holder.tv_viewDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListenerr.ViewDetails(String.valueOf(modelArrayList.getData().getDeals().get(position).getId()),position);


                }
            });



    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().getDeals().size();

    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView tvwallet,tv_viewDetail, tvdate, tvPrice, tvCutPrice, tvMainPrice, text,quentityTv,time;
        ImageView imageView;
        YouTubePlayerView youTubePlayerView;
        CardView tvgreen;

        ImageView updateCartDecrease, updateCartIncrease;
        //getLifecycle().addObserver(youTubePlayerView);

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            quentityTv = itemView.findViewById(R.id.quentityTv);
            updateCartDecrease = itemView.findViewById(R.id.updateCartDecrease);
            updateCartIncrease = itemView.findViewById(R.id.updateCartIncrease);
            imageView = itemView.findViewById(R.id.imageView);
            tvwallet = itemView.findViewById(R.id.tvwallet);
            time= itemView.findViewById(R.id.time);
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

        void AddToCartClick(String id, int position,String Quentiy);

        void addLifeCycleCallBack(YouTubePlayerView youTubePlayerView);
        void IncreaseQuentity(String Quentity, int position, Subcategory_detailsRepo Subcategory_detailsRepo);
        void DecressQuentity(String Quentity, int position,Subcategory_detailsRepo Subcategory_detailsRepo);
        void ViewDetails(String id, int position);



    }

}
