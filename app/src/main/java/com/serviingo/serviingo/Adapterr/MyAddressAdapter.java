package com.serviingo.serviingo.Adapterr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.serviingo.serviingo.R;
import com.serviingo.serviingo.modelrepo.Responsee.MyAddressRepo;
import com.serviingo.serviingo.modelrepo.Responsee.MyAddressRepoo;
import com.serviingo.serviingo.modelrepo.Responsee.MyRatingAndReviewRespooo;
import com.serviingo.serviingo.modelrepo.Responsee.MywalletRespo;
import com.serviingo.serviingo.utils.util;


public class MyAddressAdapter extends RecyclerView.Adapter<MyAddressAdapter.myViewHolder> {

    MyAddressRepoo modelArrayList;
    Context context;
    // private ItemClickListenerr itemClickListenerr;
  OnAddressItemListener onAddressItemListener;

    public MyAddressAdapter(MyAddressRepoo modelArrayList, Context context, OnAddressItemListener onAddressItemListener) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.onAddressItemListener = onAddressItemListener;
    }

    public MyAddressAdapter(MyAddressRepoo modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.addressadapter, parent, false);

        return new MyAddressAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        if (modelArrayList.getData().getAddress().get(position).getGetState() == null) {

        } else {
            holder.tvaddress.setText(modelArrayList.getData().getAddress().get(position).getAddress() + "," + modelArrayList.getData().getAddress().get(position).getLandmark() + " ," + modelArrayList.getData().getAddress().get(position).getGetCity().getName() + " ,"
                    + modelArrayList.getData().getAddress().get(position).getGetState().getName() + " ," +


                    modelArrayList.getData().getAddress().get(position).getPincode());

        }
        holder.tvAddressType.setText(modelArrayList.getData().getAddress().get(position).getAddressType());
        holder.ivgreensEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAddressItemListener.EditAddressOnClick(modelArrayList,position);
            }
        });

        holder.ivgreenDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAddressItemListener.DeleteAddressOnClick(modelArrayList,position);
            }
        });

        //holder.tvaddress.setText( modelArrayList.getData().getAddress().get(position).getGetState().getName();


    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().getAddress().size();

    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView tvAddressType, tvaddress;
        ImageView ivgreensEdit,ivgreenDelete;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);


            tvAddressType = itemView.findViewById(R.id.tvAddressType);

            tvaddress = itemView.findViewById(R.id.tvaddress);
            ivgreensEdit = itemView.findViewById(R.id.ivgreensEdit);
            ivgreenDelete = itemView.findViewById(R.id.ivgreenDelete);


        }
    }


    public interface OnAddressItemListener {


        void EditAddressOnClick(MyAddressRepoo data, int position);

        void DeleteAddressOnClick(MyAddressRepoo data, int position);
    }
}
