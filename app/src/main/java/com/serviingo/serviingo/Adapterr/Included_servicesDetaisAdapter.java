package com.serviingo.serviingo.Adapterr;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.serviingo.serviingo.R;
import com.serviingo.serviingo.modelrepo.Responsee.GetOrderDetailRepo;


public class Included_servicesDetaisAdapter extends RecyclerView.Adapter<Included_servicesDetaisAdapter.myViewHolder> {

    GetOrderDetailRepo modelArrayList;
    Context context;

    public Included_servicesDetaisAdapter(GetOrderDetailRepo modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }

    /* public AddonseAdapter(AddonseRepo modelArrayList, Context context) {
         this.modelArrayList = modelArrayList;
         this.context = context;
     }
 */
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.orderpackage_rv, parent, false);

        return new Included_servicesDetaisAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {



        holder.tvAc.setText(modelArrayList.getData().getIncludedServices().get(position).getName());
        holder.quentityTv.setText(modelArrayList.getData().getOrderInfo().getIgst());


        if (modelArrayList.getData().getIncludedServices().get(position).getAfterDiscount() != null) {
            holder.tv.setText("\u20B9 " + modelArrayList.getData().getIncludedServices().get(position).getAfterDiscount());
            holder.tvdata.setText("\u20B9 " + modelArrayList.getData().getIncludedServices().get(position).getAmount());
            holder.tvdata.setPaintFlags(holder.tvdata.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            holder.tvv.setText(modelArrayList.getData().getIncludedServices().get(position).getDiscount() + "% OFF");

        } else {
            holder.tvdata.setVisibility(View.INVISIBLE);
            holder.tv.setText("\u20B9 " + modelArrayList.getData().getIncludedServices().get(position).getAmount());
            holder.tvv.setText(modelArrayList.getData().getIncludedServices().get(position).getDiscount() + "% OFF");

        }


        if (modelArrayList.getData().getIncludedServices().get(position).getDiscount().equalsIgnoreCase("0"))
        {
            holder.fl.setVisibility(View.INVISIBLE);
            holder.tvv.setVisibility(View.INVISIBLE);
        }


    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().getIncludedServices().size();
        // return 2;
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView tvAc, tv, tvdata, tvv,quentityTv;
        FrameLayout fl;



        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAc = itemView.findViewById(R.id.tvAc);
            tv = itemView.findViewById(R.id.tv);
            tvdata = itemView.findViewById(R.id.tvdata);
            tvv = itemView.findViewById(R.id.tvv);
            quentityTv= itemView.findViewById(R.id.quentityTv);
            fl= itemView.findViewById(R.id.fl);
        }
    }


}
