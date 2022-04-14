package com.serviingo.serviingo.Adapterr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.serviingo.serviingo.R;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.MembershipHistoryRepo;


public class MembershipHistoryAdapter extends RecyclerView.Adapter<MembershipHistoryAdapter.myViewHolder> {

    MembershipHistoryRepo modelArrayList;
    Context context;

    /*  public MembershipHistoryAdapter(MembershipHistoryRepo modelArrayList, Context context, MembershipPlansclick itemClickListenerr) {
          this.modelArrayList = modelArrayList;
          this.context = context;
          this.itemClickListenerr = itemClickListenerr;
      }*/

    public MembershipHistoryAdapter(MembershipHistoryRepo modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.membershiphistoryadapter, parent, false);

        return new MembershipHistoryAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        if (position==0)
        {
            holder.textheading.setVisibility(View.VISIBLE);
        }else {
            holder.textheading.setVisibility(View.GONE);
        }

        holder.purchecdateTV.setText(modelArrayList.data.histories.get(position).startDate);


        holder.AmountTv.setText("\u20B9" + modelArrayList.data.histories.get(position).amount);
        holder.membershipTv.setText(modelArrayList.data.histories.get(position).getMembership.name);

        holder.validTv.setText(modelArrayList.data.histories.get(position).getMembership.validity + " Months");

        holder.expirydateTv.setText(modelArrayList.data.histories.get(position).endDate);

        holder.Benifittv.setText("\u20B9" + modelArrayList.data.histories.get(position).getMembership.benefit);
        if (!modelArrayList.data.histories.get(position).activeTypeStatus.equalsIgnoreCase("Active")) {
            holder.tv_cancelOrder.setVisibility(View.GONE);

        }


    }

    @Override
    public int getItemCount() {
        //  return 1;
        return modelArrayList.data.histories.size();

    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView AmountTv, purchecdateTV, membershipTv, validTv, daysTV, expirydateTv, joinnowTv, price, Benifittv, tv_cancelOrder,textheading;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            AmountTv = itemView.findViewById(R.id.AmountTv);
            textheading= itemView.findViewById(R.id.textheading);
            validTv = itemView.findViewById(R.id.validTv);
            membershipTv = itemView.findViewById(R.id.membershipTv);
            price = itemView.findViewById(R.id.price);
            expirydateTv = itemView.findViewById(R.id.expirydateTv);
            purchecdateTV = itemView.findViewById(R.id.purchecdateTV);
            daysTV = itemView.findViewById(R.id.daysTV);
            Benifittv = itemView.findViewById(R.id.Benifittv);
            joinnowTv = itemView.findViewById(R.id.joinnowTv);
            tv_cancelOrder = itemView.findViewById(R.id.tv_cancelOrder);
        }
    }
}
