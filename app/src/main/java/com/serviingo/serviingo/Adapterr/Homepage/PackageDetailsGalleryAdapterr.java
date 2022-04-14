package com.serviingo.serviingo.Adapterr.Homepage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.serviingo.serviingo.R;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.PackageviewDetailsRepo;
import com.squareup.picasso.Picasso;


public class PackageDetailsGalleryAdapterr extends RecyclerView.Adapter<PackageDetailsGalleryAdapterr.myViewHolder> {

    PackageviewDetailsRepo modelArrayList;
    Context context;

     public PackageDetailsGalleryAdapterr(PackageviewDetailsRepo modelArrayList, Context context) {
          this.modelArrayList = modelArrayList;
          this.context = context;
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

        return new PackageDetailsGalleryAdapterr.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.tvSend.setVisibility(View.GONE);

        Picasso.get().load(modelArrayList.getData().getGalleryImagePath()+modelArrayList.getData().getGalleries().get(position).getImage()).into(holder.ivimageone);


    }

    @Override
    public int getItemCount() {

       // Toast.makeText(context, modelArrayList.getData().getGalleries().size()+"", Toast.LENGTH_SHORT).show();
        return modelArrayList.getData().getGalleries().size();


    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        ImageView ivimageone;
        TextView tvSend;
        LinearLayout clickRL;



        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            ivimageone = itemView.findViewById(R.id.ivimageone);
            tvSend = itemView.findViewById(R.id.tvSend);
            clickRL = itemView.findViewById(R.id.clickRL);
        }
    }
}
