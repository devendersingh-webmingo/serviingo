package com.serviingo.serviingo.Adapterr.FinancialAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.serviingo.serviingo.R;
import com.serviingo.serviingo.modelrepo.Responsee.Finacial.FinacialSubcategoryRepo;
import com.squareup.picasso.Picasso;


public class FinanceSubCaetegoryAdapter extends RecyclerView.Adapter<FinanceSubCaetegoryAdapter.myViewHolder> {

    FinacialSubcategoryRepo modelArrayList;
    Context context;
    private HomeAdapterClick itemClickListenerr;

     public FinanceSubCaetegoryAdapter(FinacialSubcategoryRepo modelArrayList, Context context, HomeAdapterClick itemClickListenerr) {
          this.modelArrayList = modelArrayList;
          this.context = context;
          this.itemClickListenerr = itemClickListenerr;
      }

   /* public HomeAdapter(FinacialSubcategoryRepo modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }
*/
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.financialadapter, parent, false);

        return new FinanceSubCaetegoryAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.tvSend.setText(modelArrayList.getData().getSubCategories().get(position).getName());
        Picasso.get().load(modelArrayList.getData().getSubCategories().get(position).getImage()).into(holder.ivimageone);

        holder.clickRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListenerr.HomeAdapterClickk(modelArrayList,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().getSubCategories().size();


    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        ImageView ivimageone;
        TextView tvSend;
        RelativeLayout clickRL;



        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            ivimageone = itemView.findViewById(R.id.ivimageone);
            tvSend = itemView.findViewById(R.id.tvSend);
            clickRL = itemView.findViewById(R.id.clickRL);
        }
    }
    public interface HomeAdapterClick {

        void HomeAdapterClickk(FinacialSubcategoryRepo repo,int pos);


    }
}
