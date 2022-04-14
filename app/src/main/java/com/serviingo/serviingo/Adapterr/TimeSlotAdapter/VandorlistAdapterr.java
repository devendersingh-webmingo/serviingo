package com.serviingo.serviingo.Adapterr.TimeSlotAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.serviingo.serviingo.R;
import com.serviingo.serviingo.modelrepo.Responsee.HomePageRepo;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;


public class VandorlistAdapterr extends RecyclerView.Adapter<VandorlistAdapterr.myViewHolder> {

    HomePageRepo modelArrayList;
    Context context;
    private CustomizedGalleryClick itemClickListenerr;

    /*  public VandorlistAdapterr(HomePageRepo modelArrayList, Context context, CustomizedGalleryClick itemClickListenerr) {
           this.modelArrayList = modelArrayList;
           this.context = context;
           this.itemClickListenerr = itemClickListenerr;
       }
 */
    public VandorlistAdapterr(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vandortimeslotadapter, parent, false);

        return new VandorlistAdapterr.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        /*holder.tvSend.setText(modelArrayList.getData().getGalleryImages().get(position).getTitle());
        Picasso.get().load(modelArrayList.getData().getGalleryImages().get(position).getImages()).into(holder.ivimageone);

        holder.clickRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListenerr.CustomizedGalleryClickk(modelArrayList,position);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return 3;// modelArrayList.getData().getGalleryImages().size();


    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imageViewusr;
        TextView nameTV, descTv;
        LinearLayout linnearLayout;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewusr = itemView.findViewById(R.id.imageViewusr);
            nameTV = itemView.findViewById(R.id.nameTV);
            linnearLayout = itemView.findViewById(R.id.linnearLayout);
            descTv = itemView.findViewById(R.id.descTv);
        }
    }

    public interface CustomizedGalleryClick {

        void CustomizedGalleryClickk(HomePageRepo repo, int pos);


    }
}
