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
import com.serviingo.serviingo.modelrepo.Responsee.SearchResponse;

import java.util.ArrayList;

public class SearchAdapter  extends RecyclerView.Adapter<SearchAdapter.myViewHolder>{
    SearchResponse arrayList;
    Context context;
    SearchListener clicklistener;

    public SearchAdapter(SearchResponse arrayList, Context context, SearchListener clicklistener) {
        this.arrayList = arrayList;
        this.context = context;
        this.clicklistener = clicklistener;
    }
/*
    public SearchAdapter(SearchResponse arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }*/

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.state_layout, parent, false);

        return new SearchAdapter.myViewHolder(view);
    }

    @Override

    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.text_search.setText(arrayList.getData().getSuggestion().get(position).getLabel());

        if (arrayList.getData().getSuggestion().get(position).getId()!=null)
        {

        holder.text_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clicklistener.onSearchclick(arrayList,position);

            }
        });

        }

    }

    @Override
    public int getItemCount() {
        return arrayList.getData().getSuggestion().size();


    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView text_search;
      
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            text_search= itemView.findViewById(R.id.coinName);
           

        }
    }
    public interface SearchListener {

        void onSearchclick(SearchResponse searchResponse,int pos);


    }
}
