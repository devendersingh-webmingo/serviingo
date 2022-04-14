package com.serviingo.serviingo.Adapterr.FinancialAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.text.HtmlCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.serviingo.serviingo.R;
import com.serviingo.serviingo.modelrepo.Responsee.Finacial.FinacialServicesRepo;
import com.squareup.picasso.Picasso;


public class FinanceServiceAdapter extends RecyclerView.Adapter<FinanceServiceAdapter.myViewHolder> {

    FinacialServicesRepo modelArrayList;
    Context context;
    private HomeAdapterClick itemClickListenerr;

     public FinanceServiceAdapter(FinacialServicesRepo modelArrayList, Context context, HomeAdapterClick itemClickListenerr) {
          this.modelArrayList = modelArrayList;
          this.context = context;
          this.itemClickListenerr = itemClickListenerr;
      }

   /* public HomeAdapter(FinacialServicesRepo modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }
*/
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fanicalcategoryadapter, parent, false);

        return new FinanceServiceAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.title.setText(modelArrayList.getData().getServices().get(position).getName());
        Picasso.get().load(modelArrayList.getData().getServices().get(position).getImage()).into(holder.ivimageone);

        holder.rupessTv.setText("\u20B9"+modelArrayList.getData().getServices().get(position).getEmiPerLakh());
        holder.ROI_percantage.setText(String.valueOf(modelArrayList.getData().getServices().get(position).getInterest()));
        holder.title.setText(modelArrayList.getData().getServices().get(position).getName());
        holder.title.setText(modelArrayList.getData().getServices().get(position).getName());
        holder.eligibletv.setText(HtmlCompat.fromHtml(modelArrayList.getData().getServices().get(position).getEligibility(),0));


        holder.btn_moreDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListenerr.HomeAdapterClickk(modelArrayList,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().getServices().size();


    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        ImageView ivimageone;
        TextView rupessTv,ROI_percantage,excellent,title,eligibletv;
        CardView btn_moreDetails;



        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            ivimageone = itemView.findViewById(R.id.ivimageone);
            rupessTv = itemView.findViewById(R.id.rupessTv);
            ROI_percantage = itemView.findViewById(R.id.ROI_percantage);
            excellent= itemView.findViewById(R.id.excellent);
            btn_moreDetails= itemView.findViewById(R.id.btn_moreDetails);
            eligibletv= itemView.findViewById(R.id.eligibletv);
        }
    }
    public interface HomeAdapterClick {

        void HomeAdapterClickk(FinacialServicesRepo repo,int pos);


    }
}
