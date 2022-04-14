package com.serviingo.serviingo.Adapterr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.serviingo.serviingo.R;
import com.serviingo.serviingo.model.CartModel;
import com.serviingo.serviingo.modelrepo.Responsee.CartRepo;

import java.util.ArrayList;


public class CartAdapter extends RecyclerView.Adapter<CartAdapter.myViewHolder> {

    CartRepo modelArrayList;
    Context context;
    private CartListener itemClickListenerr;


    int quantity;


    public CartAdapter(CartRepo modelArrayList, Context context, CartListener itemClickListenerr) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.itemClickListenerr = itemClickListenerr;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cartlist, parent, false);

        return new CartAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

       /* if (modelArrayList.getData().getAddonServices().size() > 0) {
            cartModel=new CartModel(String.valueOf(modelArrayList.getData().getAddonServices().get(position).getId()),modelArrayList.getData().getAddonServices().get(position).getQuantity());
            arrayList.add(cartModel);
            itemClickListenerr.Adonsedata(arrayList,position);


        }*/

        if (modelArrayList.getData().getAddonServices().get(position).getDiscount().equalsIgnoreCase("0")) {
            holder.tvv.setVisibility(View.GONE);
            holder.fl.setVisibility(View.GONE);


        }
        holder.tvv.setText(modelArrayList.getData().getAddonServices().get(position).getDiscount() + "% OFF");


        if (modelArrayList.getData().getAddonServices().get(position).getDiscountedAmount() != null) {
            holder.text.setText(" \u20B9 " + modelArrayList.getData().getAddonServices().get(position).getDiscountedAmount());
            holder.tvdata.setText(" \u20B9 " + modelArrayList.getData().getAddonServices().get(position).getAmount());


        } else {
            holder.text.setVisibility(View.GONE);
            holder.tvdata.setText(" \u20B9 " + modelArrayList.getData().getAddonServices().get(position).getAmount());

        }
        holder.quentityTv.setText(String.valueOf(modelArrayList.getData().getAddonServices().get(position).getQuantity()));

        holder.tvwallet.setText(modelArrayList.getData().getAddonServices().get(position).getName());


        holder.updateCartDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity = modelArrayList.getData().getAddonServices().get(position).getQuantity();

                if (quantity > 1) {
                    quantity--;

                    // holder.quentityTv.setText(String.valueOf(quantity));

                    itemClickListenerr.DecressQuentity(String.valueOf(quantity), position, modelArrayList);

                }


            }
        });
        holder.updateCartIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                quantity = Integer.parseInt(holder.quentityTv.getText().toString());
                quantity++;
                //  holder.quentityTv.setText(String.valueOf(quantity));

                itemClickListenerr.IncreaseQuentity(String.valueOf(quantity), position, modelArrayList);


            }
        });
        holder.deleteAdonse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                itemClickListenerr.DeleteAddonse(String.valueOf(quantity), position, modelArrayList);


            }
        });


    }

    @Override
    public int getItemCount() {
//        Toast.makeText(context, modelArrayList.getData().getAddonServices().size()+"", Toast.LENGTH_SHORT).show();
        return modelArrayList.getData().getAddonServices().size();


    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView text, tvwallet, quentityTv, tvdata, tvv;
        LinearLayout ll;
        ImageView updateCartDecrease, updateCartIncrease, deleteAdonse;
        FrameLayout fl;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            tvwallet = itemView.findViewById(R.id.tvwallet);
            text = itemView.findViewById(R.id.text);
            quentityTv = itemView.findViewById(R.id.quentityTv);
            tvdata = itemView.findViewById(R.id.tvdata);
            ll = itemView.findViewById(R.id.ll);
            tvv = itemView.findViewById(R.id.tvv);
            fl = itemView.findViewById(R.id.fl);
            deleteAdonse = itemView.findViewById(R.id.deleteAdonse);
            updateCartDecrease = itemView.findViewById(R.id.updateCartDecrease);
            updateCartIncrease = itemView.findViewById(R.id.updateCartIncrease);
        }
    }


    public interface CartListener {

        void IncreaseQuentity(String Quentity, int position, CartRepo cartRepo);

        void DecressQuentity(String Quentity, int position, CartRepo cartRepo);

        void DeleteAddonse(String Quentity, int position, CartRepo cartRepo);


    }


}
