package com.serviingo.serviingo.Adapterr.Homepage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.serviingo.serviingo.R;
import com.serviingo.serviingo.modelrepo.Responsee.Finacial.FinacialCategoryRepo;
import com.serviingo.serviingo.modelrepo.Responsee.HomePageRepo;
import com.squareup.picasso.Picasso;


public class CustomizedGalleryAdapterr extends RecyclerView.Adapter<CustomizedGalleryAdapterr.myViewHolder> {

    HomePageRepo modelArrayList;
    Context context;
    private CustomizedGalleryClick itemClickListenerr;

    public CustomizedGalleryAdapterr(HomePageRepo modelArrayList, Context context, CustomizedGalleryClick itemClickListenerr) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.itemClickListenerr = itemClickListenerr;
    }

    /* public HomeAdapter(FinacialCategoryRepo modelArrayList, Context context) {
         this.modelArrayList = modelArrayList;
         this.context = context;
     }
 */
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.galleryadapter, parent, false);

        return new CustomizedGalleryAdapterr.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.tvSend.setText(modelArrayList.getData().getGalleryImages().get(position).getTitle());
        Picasso.get().load(modelArrayList.getData().getGalleryImages().get(position).getImages()).into(holder.ivimageone);

        if (modelArrayList.getData().getGalleryImages().get(position).getRedirectionType().getId() != null) {
            holder.ivimageone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListenerr.CustomizedGalleryClickk(modelArrayList, position);
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().getGalleryImages().size();


    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        ImageView ivimageone;
        TextView tvSend;
        CardView cardView;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            ivimageone = itemView.findViewById(R.id.ivimageone);
            tvSend = itemView.findViewById(R.id.tvSend);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }

    public interface CustomizedGalleryClick {

        void CustomizedGalleryClickk(HomePageRepo repo, int pos);


    }
}
