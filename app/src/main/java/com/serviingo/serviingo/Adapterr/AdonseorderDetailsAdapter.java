package com.serviingo.serviingo.Adapterr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.serviingo.serviingo.R;
import com.serviingo.serviingo.modelrepo.Responsee.CartRepo;
import com.serviingo.serviingo.modelrepo.Responsee.GetOrderDetailRepo;


public class AdonseorderDetailsAdapter extends RecyclerView.Adapter<AdonseorderDetailsAdapter.myViewHolder> {

    GetOrderDetailRepo modelArrayList;
    Context context;
// private CheckBoxListener itemClickListenerr;

    /*  public CartAdapter(AddonseRepo modelArrayList, Context context, CheckBoxListener itemClickListenerr) {
          this.modelArrayList = modelArrayList;
          this.context = context;
          this.itemClickListenerr = itemClickListenerr;
      }
  */
    public AdonseorderDetailsAdapter(GetOrderDetailRepo modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cartlist, parent, false);

        return new AdonseorderDetailsAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        // holder.ll.setVisibility(View.GONE);
        holder.deleteAdonse.setVisibility(View.GONE);
        holder.updateCartDecrease.setVisibility(View.INVISIBLE);
        holder.updateCartIncrease.setVisibility(View.INVISIBLE);


        if (modelArrayList.getData().getOrderInfo().getAddons().get(position).getAfterDiscount() != null) {
            holder.text.setText(" \u20B9 " + modelArrayList.getData().getOrderInfo().getAddons().get(position).getAfterDiscount());

        } else {
            holder.text.setText(" \u20B9 " + modelArrayList.getData().getOrderInfo().getAddons().get(position).getAmount());

        }

        holder.tvwallet.setText(modelArrayList.getData().getOrderInfo().getAddons().get(position).getName());
        holder.quentityTv.setText(modelArrayList.getData().getOrderInfo().getAddons().get(position).getQuantity());

        holder.tvv.setText(modelArrayList.getData().getOrderInfo().getAddons().get(position).getDiscount() + "%OFF");
        holder.tvdata.setText(" \u20B9 " + modelArrayList.getData().getOrderInfo().getAddons().get(position).getAmount());

        if (modelArrayList.getData().getOrderInfo().getAddons().get(position).getDiscount() .equalsIgnoreCase("0"))
        {
            holder.fl.setVisibility(View.INVISIBLE);
            holder.tvv.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().getOrderInfo().getAddons().size();

    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView text, tvwallet, tvv, tvdata, quentityTv;
        LinearLayout ll;
        ImageView deleteAdonse, updateCartIncrease, updateCartDecrease;
        FrameLayout fl;



        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            tvwallet = itemView.findViewById(R.id.tvwallet);
            text = itemView.findViewById(R.id.text);
            ll = itemView.findViewById(R.id.ll);
            tvv = itemView.findViewById(R.id.tvv);
            updateCartDecrease = itemView.findViewById(R.id.updateCartDecrease);
            updateCartIncrease = itemView.findViewById(R.id.updateCartIncrease);
            tvdata = itemView.findViewById(R.id.tvdata);
            deleteAdonse = itemView.findViewById(R.id.deleteAdonse);
            quentityTv = itemView.findViewById(R.id.quentityTv);
            fl= itemView.findViewById(R.id.fl);

        }
    }
   /* public interface CheckBoxListener {

        void CheckedClick(String id, int position,Boolean bb);


    }*/
}
