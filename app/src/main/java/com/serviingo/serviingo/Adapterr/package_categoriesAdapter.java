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
import androidx.recyclerview.widget.RecyclerView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.modelrepo.Responsee.Subcategory_detailsRepo;
import com.serviingo.serviingo.modelrepo.Responsee.subsubcategory_detailsRepo;


public class package_categoriesAdapter extends RecyclerView.Adapter<package_categoriesAdapter.myViewHolder> {

    subsubcategory_detailsRepo modelArrayList;
    Context context;

    private AddPackageCategoriesListener itemClickListenerr;
    int selectedId = 1000000;


    public package_categoriesAdapter(subsubcategory_detailsRepo modelArrayList, Context context, AddPackageCategoriesListener itemClickListenerr) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.itemClickListenerr = itemClickListenerr;
    }


   /* public package_categoriesAdapter(subsubcategory_detailsRepo modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }*/

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_packages, parent, false);

        return new package_categoriesAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        try {

            holder.data.setText(modelArrayList.getData().getPackageCategories().get(position).getName());

            if (selectedId == 1000000) {
                selectedId = modelArrayList.getData().getPackageCategories().get(0).getId();
            }


            ///
            if (selectedId == (modelArrayList.getData().getPackageCategories().get(position).getId())) {
                itemClickListenerr.PackageCategoriesClick(modelArrayList, position, selectedId);

                holder.data.setTextColor(context.getResources().getColor(R.color.white));
                holder.data.setBackground(context.getResources().getDrawable(R.drawable.recentbookingui));
            } else {
                holder.data.setTextColor(context.getResources().getColor(R.color.black));
                holder.data.setBackground(context.getResources().getDrawable(R.drawable.allsideborder));
            }

            holder.data.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    selectedId = modelArrayList.getData().getPackageCategories().get(position).getId();

                    itemClickListenerr.PackageCategoriesClick(modelArrayList, position, selectedId);
                    notifyDataSetChanged();


                }
            });

        } catch (Exception e) {

        }
    }


    @Override
    public int getItemCount() {
        return modelArrayList.getData().getPackageCategories().size();

    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView data;
        //getLifecycle().addObserver(youTubePlayerView);

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            data = itemView.findViewById(R.id.data);

            // ( context).addLifeCycleCallBack(youTubePlayerView);

            // context. getLifecycle().addObserver(youTubePlayerView);

        }
    }

    public interface AddPackageCategoriesListener {

        void PackageCategoriesClick(subsubcategory_detailsRepo subcategory_detailsRepo, int position, int packagecategoriesId);


    }

}
