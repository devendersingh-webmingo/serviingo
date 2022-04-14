package com.serviingo.serviingo.Adapterr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.serviingo.serviingo.R;
import com.serviingo.serviingo.modelrepo.Responsee.Subcategory_detailsRepo;


public class package_categoriesSubAdapter extends RecyclerView.Adapter<package_categoriesSubAdapter.myViewHolder> {

    Subcategory_detailsRepo modelArrayList;
    Context context;

    private AddPackageCategoriesSubListener itemClickListenerr;
    int selectedId=1000000;


    public package_categoriesSubAdapter(Subcategory_detailsRepo modelArrayList, Context context, AddPackageCategoriesSubListener itemClickListenerr) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.itemClickListenerr = itemClickListenerr;
    }
    

   /* public package_categoriesAdapter(Subcategory_detailsRepo modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }*/

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_packages, parent, false);

        return new package_categoriesSubAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.data.setText(modelArrayList.getData().getPackageCategories().get(position).getName());
        if (selectedId == 1000000) {
            selectedId = modelArrayList.getData().getPackageCategories().get(0).getId();
        }


        ///
        if (selectedId == (modelArrayList.getData().getPackageCategories().get(position).getId())) {
            itemClickListenerr.PackageCategoriesSubClick(modelArrayList, position, selectedId);

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

                itemClickListenerr.PackageCategoriesSubClick(modelArrayList, position, selectedId);
                notifyDataSetChanged();


            }
        });
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

    public interface AddPackageCategoriesSubListener {

        void PackageCategoriesSubClick(Subcategory_detailsRepo subcategory_detailsRepo, int position, int packagecategoriesId);


    }

}
