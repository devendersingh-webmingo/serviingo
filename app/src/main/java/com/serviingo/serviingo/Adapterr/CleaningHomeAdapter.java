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
import com.serviingo.serviingo.modelrepo.Responsee.HomePageRepo;
import com.squareup.picasso.Picasso;


public class CleaningHomeAdapter extends RecyclerView.Adapter<CleaningHomeAdapter.myViewHolder> {

    HomePageRepo modelArrayList;
    Context context;
    private HomeClick itemClickListenerr;

    public CleaningHomeAdapter(HomePageRepo modelArrayList, Context context, HomeClick itemClickListenerr) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.itemClickListenerr = itemClickListenerr;
    }

    /*public CleaningHomeAdapter(HomePageRepo modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }*/

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_category_ui, parent, false);

        return new CleaningHomeAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.tvCategoriesNamee.setText(modelArrayList.getData().getLatestServices().get(position).getName());
        holder. cleaningLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListenerr.CleaningHomeClick(modelArrayList,position);
            }
        });
        //Picasso.get().load(modelArrayList.getData().getCategoryImagePath() + modelArrayList.getData().getLatestServices().get(position).getIcon()).into(holder.iv_Imageview);;


    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().getLatestServices().size();


    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_Imageview;
        TextView tvCategoriesNamee;
        LinearLayout cleaningLL;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            cleaningLL = itemView.findViewById(R.id.cleaningLL);
            iv_Imageview = itemView.findViewById(R.id.iv_Imageview);
            tvCategoriesNamee = itemView.findViewById(R.id.tvCategoriesNamee);
        }
    }

    public interface HomeClick {

        void CleaningHomeClick(HomePageRepo repo, int pos);


    }
}
