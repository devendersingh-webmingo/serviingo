package com.serviingo.serviingo.Adapterr;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.serviingo.serviingo.R;
import com.serviingo.serviingo.modelrepo.Responsee.MywalletRespo;
import com.serviingo.serviingo.utils.util;

import java.util.ArrayList;


public class MyWalletAdapter extends RecyclerView.Adapter<MyWalletAdapter.myViewHolder> {

    MywalletRespo modelArrayList;
    Context context;
    // private ItemClickListenerr itemClickListenerr;

    public MyWalletAdapter(MywalletRespo modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adaptermywallet, parent, false);

        return new MyWalletAdapter.myViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {


        if (modelArrayList.getData().getHistories().get(position).getCreatedBy().equalsIgnoreCase("Refund")) {
            holder.tv_name.setText("Service Refund");
            holder.withdrawalTv.setText(modelArrayList.getData().getHistories().get(position).getAmount());


        } else {
            holder.tv_name.setText(modelArrayList.getData().getHistories().get(position).getTitle());
            holder.withdrawalTv.setText(modelArrayList.getData().getHistories().get(position).getWithdrawal());
            holder.tvWithdrawlMoney.setText(modelArrayList.getData().getHistories().get(position).getDeposit());

        }


        holder.tvTranscationid.setText("Transaction Id :" + modelArrayList.getData().getHistories().get(position).getTransactionId());

        //   holder.tvdateTime.setText(modelArrayList.getData().getHistories().get(position).getCreatedAt());
     /*   holder.tvTranscationid.setText(modelArrayList.get(position).getData().getHistories().get(position).getTransactionId());
        holder.tvTranscationid.setText(modelArrayList.get(position).getData().getHistories().get(position).getTransactionId());
*/
        String dateAndTime = modelArrayList.getData().getHistories().get(position).getCreatedAt();
        holder.tvdateTime.setText(util.getDate(dateAndTime) + " " + util.getTime(dateAndTime));








        if (modelArrayList.getData().getHistories().get(position).getType().equalsIgnoreCase("Debited")) {

            holder.tv_cancelOrder.setBackground(context.getResources().getDrawable(R.drawable.reddrawable));
            holder.tv_cancelOrder.setText("Debited");
        }

        if (modelArrayList.getData().getHistories().get(position).getApproval().equalsIgnoreCase("Pending")) {
            holder.imageView.setBackgroundResource(R.drawable.ic_pending);

            holder.tvtextdeposit.setText(modelArrayList.getData().getHistories().get(position).getApproval());
            holder.tvtextdeposit.setTextColor(R.color.blue);

        }
        if (modelArrayList.getData().getHistories().get(position).getRemark() != null) {


            if (modelArrayList.getData().getHistories().get(position).getTitle().equalsIgnoreCase("Purchase Membership")) {
                holder.remarkTv.setText(modelArrayList.getData().getHistories().get(position).getPaymentRemark());

            } else {
                holder.remarkTv.setText(modelArrayList.getData().getHistories().get(position).getRemark());

            }


        }
        // holder.transaction_time.setText(time);

    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().getHistories().size();

    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tvTranscationid, tvdateTime, remarkTv, tvtextdeposit, tvWithdrawlMoney, tv_cancelOrder, tv_name, withdrawalTv;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tvWithdrawlMoney = itemView.findViewById(R.id.tvWithdrawlMoney);
            tvTranscationid = itemView.findViewById(R.id.tv_itemName);
            tv_cancelOrder = itemView.findViewById(R.id.tv_cancelOrder);
            tvdateTime = itemView.findViewById(R.id.dateandtimeTv);
            withdrawalTv = itemView.findViewById(R.id.withdrawalTv);
            remarkTv = itemView.findViewById(R.id.remarkTv);
            tvtextdeposit = itemView.findViewById(R.id.tvtextdeposit);

        }
    }
}
