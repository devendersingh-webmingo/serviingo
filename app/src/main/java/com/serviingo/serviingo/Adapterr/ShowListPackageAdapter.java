package com.serviingo.serviingo.Adapterr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.serviingo.serviingo.R;
import com.serviingo.serviingo.modelrepo.Responsee.ShowListPackageRepo;
import com.squareup.picasso.Picasso;


public class ShowListPackageAdapter extends RecyclerView.Adapter<ShowListPackageAdapter.myViewHolder> {

    ShowListPackageRepo modelArrayList;
    Context context;
    private CheckBoxListener itemClickListenerr;

    public ShowListPackageAdapter(ShowListPackageRepo modelArrayList, Context context, CheckBoxListener itemClickListenerr) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.itemClickListenerr = itemClickListenerr;
    }

    /* public AddonseAdapter(ShowListPackageRepo modelArrayList, Context context) {
         this.modelArrayList = modelArrayList;
         this.context = context;
     }
 */
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.packageitem, parent, false);

        return new ShowListPackageAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        if (modelArrayList.getData().getServices().get(position).getAfterDiscount()!=null)
        {
            holder.tvSend.setText( modelArrayList.getData().getServices().get(position).getName()+"( \u20B9 "+modelArrayList.getData().getServices().get(position).getAfterDiscount()+")");

        }else {
            holder.tvSend.setText( modelArrayList.getData().getServices().get(position).getName()+"( \u20B9 "+modelArrayList.getData().getServices().get(position).getAmount()+")");

        }

        //  Picasso.get().load(modelArrayList.getData().getImageBasePath()+ modelArrayList.getData().getServices().get(position).getIcon()).into(holder.ivimageone);

        holder.simpleCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    itemClickListenerr. CheckedClick(modelArrayList,position,isChecked);




            }
        });
    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().getServices().size();

    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView tvSend;
        CheckBox simpleCheckBox;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            tvSend=itemView.findViewById(R.id.tvSend);
            simpleCheckBox=itemView.findViewById(R.id.simpleCheckBox);

        }
    }

    public interface CheckBoxListener {

        void CheckedClick(ShowListPackageRepo showListPackageRepo, int position, Boolean bb);


    }
}
