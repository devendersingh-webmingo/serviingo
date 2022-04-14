package com.serviingo.serviingo.Adapterr.TimeSlotAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.serviingo.serviingo.R;
import com.serviingo.serviingo.modelrepo.Responsee.CartRepo;


public class Package_servicesAdapterr extends RecyclerView.Adapter<Package_servicesAdapterr.myViewHolder> {

    CartRepo modelArrayList;
    Context context;


    public Package_servicesAdapterr(CartRepo modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;

    }


   /* public DatelistslotAdapterr(Context context) {
        this.context = context;
    }*/

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.package_servicesrc, parent, false);

        return new Package_servicesAdapterr.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        if (position == 0) {
            holder.tvwallet.setVisibility(View.VISIBLE);
        }
        holder.tvwalletpackage.setText(" ."+String.valueOf(modelArrayList.getData().getPackageServices().get(position).getName()));

    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().getPackageServices().size();// modelArrayList.getData().getGalleryImages().size();


    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView tvwallet, tvwalletpackage;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            tvwallet = itemView.findViewById(R.id.tvwallet);
            tvwalletpackage = itemView.findViewById(R.id.tvwalletpackage);


        }
    }
}
