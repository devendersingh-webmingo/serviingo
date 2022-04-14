package com.serviingo.serviingo.Adapterr;

import android.content.Context;
import android.graphics.Paint;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.serviingo.serviingo.R;
import com.serviingo.serviingo.modelrepo.Responsee.AddonseRepo;
import com.serviingo.serviingo.modelrepo.Responsee.subsubcategory_detailsRepo;
import com.squareup.picasso.Picasso;


public class AddonseAdapter extends RecyclerView.Adapter<AddonseAdapter.myViewHolder> {

    AddonseRepo modelArrayList;
    Context context;
    private CheckBoxListener itemClickListenerr;

    public AddonseAdapter(AddonseRepo modelArrayList, Context context, CheckBoxListener itemClickListenerr) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.itemClickListenerr = itemClickListenerr;
    }

    /* public AddonseAdapter(AddonseRepo modelArrayList, Context context) {
         this.modelArrayList = modelArrayList;
         this.context = context;
     }
 */
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gridui, parent, false);

        return new AddonseAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {


        Log.e("TAGTAGTAG", "onBindViewHolder: "+modelArrayList.getData().getServices().get(position).getDiscount());




        if (modelArrayList.getData().getServices().get(position).getDiscount().equalsIgnoreCase("0")) {
           // holder.tvSendd.setVisibility(View.GONE);
            holder.fl.setVisibility(View.GONE);
        }



        if (modelArrayList.getData().getServices().get(position).getAfterDiscount() != null) {
            holder.tvSend.setText(modelArrayList.getData().getServices().get(position).getName() );

            holder.tvdata.setText( " \u20B9 " + modelArrayList.getData().getServices().get(position).getAmount());
            holder.tvSendd.setText(" \u20B9 " + modelArrayList.getData().getServices().get(position).getAfterDiscount());


        } else {
            holder.tvSend.setText(modelArrayList.getData().getServices().get(position).getName() );

            holder.tvdata.setText( "-\u20B9" + modelArrayList.getData().getServices().get(position).getAmount());

            holder.tvSendd.setText("\u20B9" +modelArrayList.getData().getServices().get(position).getAmount());

        }
        if (modelArrayList.getData().getServices().get(position).getUsedIn().trim().equalsIgnoreCase("Yes"))
        {
            holder.simpleCheckBox.setChecked(true);
            if (holder.simpleCheckBox.isChecked())
            {
                itemClickListenerr.CheckedClick(String.valueOf(modelArrayList.getData().getServices().get(position).getId()), position, true);

            }

        }

//    holder.tvSend.setText( modelArrayList.getData().getServices().get(position).getName()+"- \u20B9 " + modelArrayList.getData().getServices().get(position).getAmount());
        Picasso.get().load(modelArrayList.getData().getImageBasePath() + modelArrayList.getData().getServices().get(position).getIcon()).into(holder.ivimageone);

        holder.simpleCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                itemClickListenerr.CheckedClick(String.valueOf(modelArrayList.getData().getServices().get(position).getId()), position, isChecked);


            }
        });
    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().getServices().size();

    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView tvSend,tvdata,tvSendd;
        CheckBox simpleCheckBox;
        ImageView ivimageone;
        FrameLayout fl;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            simpleCheckBox = itemView.findViewById(R.id.simpleCheckBox);
            tvdata= itemView.findViewById(R.id.tvdata);
            ivimageone = itemView.findViewById(R.id.ivimageone);
            tvSend = itemView.findViewById(R.id.tvSend);
            tvSendd= itemView.findViewById(R.id.tvSendd);
            fl= itemView.findViewById(R.id.fl);
        }
    }

    public interface CheckBoxListener {

        void CheckedClick(String id, int position, Boolean bb);


    }
}
