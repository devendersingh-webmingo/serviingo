package com.serviingo.serviingo.Adapterr;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.serviingo.serviingo.R;
import com.serviingo.serviingo.modelrepo.Responsee.AddonseRepo;
import com.serviingo.serviingo.modelrepo.Responsee.ManageOrderListingRepo;
import com.serviingo.serviingo.utils.util;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class AddonseorderAdapter extends RecyclerView.Adapter<AddonseorderAdapter.myViewHolder> {
    ArrayList<String> arrayList=new ArrayList<>();
    Context context;
    int size;

    public AddonseorderAdapter(ArrayList<String> arrayList, Context context, int size) {
        this.arrayList = arrayList;
        this.context = context;
        this.size = size;
    }

    @NonNull
    @Override
    public AddonseorderAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutadonseorder, parent, false);

        return new AddonseorderAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddonseorderAdapter.myViewHolder holder, int position) {

       // Toast.makeText(context, arrayList.size()+"", Toast.LENGTH_SHORT).show();


         holder.tv_name.setText(arrayList.get(position));

        // holder.tvtext.setText(Html.fromHtmal(String.valueOf(arrayList.getData().get(position).getPackage().getAboutPackage())));


    }

    @Override
    public int getItemCount() {
        return arrayList.size();// arrayList.size();//get(Position).getAddons().size();

    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_itemName);


        }
    }

}
