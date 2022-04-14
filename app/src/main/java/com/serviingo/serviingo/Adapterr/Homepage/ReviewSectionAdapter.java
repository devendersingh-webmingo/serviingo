        package com.serviingo.serviingo.Adapterr.Homepage;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.serviingo.serviingo.R;
import com.serviingo.serviingo.model.CityModel;
import com.serviingo.serviingo.modelrepo.Responsee.HomePageRepo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class ReviewSectionAdapter extends RecyclerView.Adapter<ReviewSectionAdapter.myViewHolder> {

    ArrayList<CityModel> cityModelArrayList = new ArrayList<>();
    Context context;

    public ReviewSectionAdapter(ArrayList<CityModel> cityModelArrayList, Context context) {
        this.cityModelArrayList = cityModelArrayList;
        this.context = context;
    }

   /* public ReviewSectionAdapter(HomePageRepo modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }*/

    /* public HomeAdapter(HomePageRepo modelArrayList, Context context) {
         this.modelArrayList = modelArrayList;
         this.context = context;
     }
 */
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemviewpagerservice, parent, false);

        return new ReviewSectionAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        //    holder.CateName.setText(modelArrayList.getData().getReviews().get(position).getGetUserInfo().getName());




        holder.CateNamee.setText(Html.fromHtml(cityModelArrayList.get(position).getId()));
        holder.CateName.setText(cityModelArrayList.get(position).getName());




        if (cityModelArrayList.get(position).getState_id()!= null) {
            Picasso.get().load(String.valueOf(cityModelArrayList.get(position).getState_id())).into(holder.imageViewusr);
        }else
        {
            holder.imageViewusr.setImageDrawable(context.getResources().getDrawable(R.drawable.usr));

        }

    }

    /*

        holder.CateNamee.setText(Html.fromHtml(modelArrayList.getData().getReviews().get(position).getReview()));


        if (modelArrayList.getData().getReviews().get(position).getGetUserInfo() != null) {
            holder.CateName.setText(modelArrayList.getData().getReviews().get(position).getGetUserInfo().getName());

            if (modelArrayList.getData().getReviews().get(position).getGetUserInfo().getProfilePhotoPath() != null) {
                Picasso.get().load(String.valueOf(modelArrayList.getData().getReviews().get(position).getGetUserInfo().getProfilePhotoPath())).into(holder.imageViewusr);;


            }else
            {
                holder.imageViewusr.setImageDrawable(context.getResources().getDrawable(R.drawable.usr));

            }

        }
*/

      /*  if (modelArrayList.getData().getReviews().get(position).getGetUserInfo().getProfilePhotoPath()!=null)
        {
            Picasso.get().load(String.valueOf(modelArrayList.getData().getReviews().get(position).getGetUserInfo().getProfilePhotoPath())).into(holder.imageViewusr);;

        }
*/




    @Override
    public int getItemCount() {
        return cityModelArrayList.size();


    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imageViewusr;
        TextView CateName, CateNamee;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewusr = itemView.findViewById(R.id.imageViewusr);
            CateName = itemView.findViewById(R.id.nameTV);
            CateNamee = itemView.findViewById(R.id.descTv);
        }
    }

}
