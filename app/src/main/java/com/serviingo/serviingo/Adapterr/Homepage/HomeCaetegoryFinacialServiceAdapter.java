package com.serviingo.serviingo.Adapterr.Homepage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.serviingo.serviingo.R;
import com.serviingo.serviingo.model.HomePagecategoresFinacialsModel;
import com.serviingo.serviingo.model.ThreeSectionModel;
import com.serviingo.serviingo.modelrepo.Responsee.HomePageRepo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HomeCaetegoryFinacialServiceAdapter extends RecyclerView.Adapter<HomeCaetegoryFinacialServiceAdapter.myViewHolder> {

    List<HomePagecategoresFinacialsModel> list;
    Context context;
    private HomeAdapterFinacialClick itemClickListenerr;

    public HomeCaetegoryFinacialServiceAdapter(  List<HomePagecategoresFinacialsModel> list, Context context, HomeAdapterFinacialClick itemClickListenerr) {
        this.list = list;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_layout, parent, false);

        return new HomeCaetegoryFinacialServiceAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {


        if (list.get(position).id.equalsIgnoreCase("00110"))
        {
            holder.CateName.setText(list.get(position).name);
           holder.iv_Imageview.setImageResource(R.drawable.finacialimage);


        }else {



        Picasso.get().load(list.get(position).image).into(holder.iv_Imageview);

        holder.CateName.setText(list.get(position).name);
    }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListenerr.HomeAdapterClickk(list.get(position).id);
            }
        });








    }

    @Override
    public int getItemCount() {
        return list.size();


    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView CateName;
        CardView cardView;
        ImageView iv_Imageview;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            // tvCategory = itemView.findViewById(R.id.tv_Category);
            cardView = itemView.findViewById(R.id.cv_View);
            iv_Imageview = itemView.findViewById(R.id.iv_Imageview);
            CateName = itemView.findViewById(R.id.CateName);
        }
    }

    public interface HomeAdapterFinacialClick {

        void HomeAdapterClickk(String id);

    }
}
