package com.serviingo.serviingo.Adapterr.Homepage;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.model.ThreeSectionModel;
import com.serviingo.serviingo.modelrepo.Responsee.HomePageRepo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;


public class HomeSubsubCategoryAdapter extends RecyclerView.Adapter<HomeSubsubCategoryAdapter.myViewHolder> {

    HomePageRepo modelArrayList;
    Context context;
    private HomeAdapterSubsubCategoryClick itemClickListenerr;

    public HomeSubsubCategoryAdapter(HomePageRepo modelArrayList, Context context, HomeAdapterSubsubCategoryClick itemClickListenerr) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.itemClickListenerr = itemClickListenerr;
    }

    /* public HomeAdapter(HomePageRepo modelArrayList, Context context) {
         this.modelArrayList = modelArrayList;
         this.context = context;
     }
 */
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.thirdsectionadapter, parent, false);

        return new HomeSubsubCategoryAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.CateNamee.setVisibility(View.GONE);
        holder.CateName.setText(modelArrayList.getData().getHomeSubsubCategories().get(position).getName());
        // holder.CateNamee.setText(Html.fromHtml(modelArrayList.getData().getAllCategories().get(position).getAboutCategory()));

       // Picasso.get().load(modelArrayList.getData().getSubsubCategoryImagePath()+modelArrayList.getData().getHomeSubsubCategories().get(position).getDetailImage()).into(holder.iv_Imageview);;

        if (modelArrayList.getData().getHomeSubsubCategories().get(position).getDetailImage()!=null)
        {
            Glide.with(context)
                    .load(modelArrayList.getData().getSubsubCategoryImagePath()+modelArrayList.getData().getHomeSubsubCategories().get(position).getDetailImage())
                    .into(holder.iv_Imageview);
        }


        //   foursectionlist


        holder.clickLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListenerr.SubsubCategoryClickk(modelArrayList,position);
            }
        });



    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().getHomeSubsubCategories().size();


    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_Imageview;
        TextView CateName,CateNamee;
        LinearLayout clickLL;
        CardView cardView;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            // tvCategory = itemView.findViewById(R.id.tv_Category);
            iv_Imageview = itemView.findViewById(R.id.ivimageone);
            CateName = itemView.findViewById(R.id.CateName);
            clickLL = itemView.findViewById(R.id.clickLL);
            CateNamee= itemView.findViewById(R.id.CateNamee);
            cardView= itemView.findViewById(R.id.cardView);
        }
    }

    public interface HomeAdapterSubsubCategoryClick {

        void SubsubCategoryClickk(HomePageRepo repo, int pos);
    }
}
