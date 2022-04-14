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
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.serviingo.serviingo.R;
import com.serviingo.serviingo.modelrepo.Responsee.SubSubcateogriesResponse;
import com.squareup.picasso.Picasso;


public class SubSubCategoriesAdapter extends RecyclerView.Adapter<SubSubCategoriesAdapter.myViewHolder> {

    SubSubcateogriesResponse modelArrayList;
    Context context;
    private SubSubCategoriesClick itemClickListenerr;

    public SubSubCategoriesAdapter(SubSubcateogriesResponse modelArrayList, Context context, SubSubCategoriesClick itemClickListenerr) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.itemClickListenerr = itemClickListenerr;
    }

    /* public AddonseAdapter(SubSubcateogriesResponse modelArrayList, Context context) {
         this.modelArrayList = modelArrayList;
         this.context = context;
     }
 */
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subsubadapter, parent, false);

        return new SubSubCategoriesAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.CateName.setText(modelArrayList.getData().getSubsubCategory().get(position).getName());

        Picasso.get().load(modelArrayList.getData().getImagePath() + modelArrayList.getData().getSubsubCategory().get(position).getIcon()).into(holder.iv_Imageview);
        holder.cv_View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListenerr.Click(modelArrayList,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().getSubsubCategory().size();

    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView CateName;

        ImageView iv_Imageview;
        CardView cv_View;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_Imageview = itemView.findViewById(R.id.iv_Imageview);
            CateName = itemView.findViewById(R.id.CateName);
            cv_View = itemView.findViewById(R.id.cv_View);

        }
    }

    public interface SubSubCategoriesClick {
        void Click(SubSubcateogriesResponse subSubcateogriesResponse, int position);


    }
}
