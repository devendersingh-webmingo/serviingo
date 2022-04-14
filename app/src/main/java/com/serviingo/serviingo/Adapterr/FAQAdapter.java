package com.serviingo.serviingo.Adapterr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.serviingo.serviingo.R;
import com.serviingo.serviingo.modelrepo.Responsee.CategoriesDetailsRepo;


public class FAQAdapter extends RecyclerView.Adapter<FAQAdapter.myViewHolder> {

    CategoriesDetailsRepo modelArrayList;
    Context context;
    public FAQAdapter(CategoriesDetailsRepo modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapterfaq, parent, false);

        return new FAQAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.desc.setText(modelArrayList.getData().getFaqs().get(position).getAnswer());

        holder.heading.setText(modelArrayList.getData().getFaqs().get(position).getQuestion());


    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().getFaqs().size();


    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView heading,desc;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            desc= itemView.findViewById(R.id.desc);
            heading = itemView.findViewById(R.id.heading);

        }
    }
   /* public interface CheckBoxListener {

        void CheckedClick(String id, int position,Boolean bb);


    }*/
}
