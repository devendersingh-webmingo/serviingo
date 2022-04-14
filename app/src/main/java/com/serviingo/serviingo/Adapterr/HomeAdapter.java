package com.serviingo.serviingo.Adapterr;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.serviingo.serviingo.R;
import com.serviingo.serviingo.model.ThreeSectionModel;
import com.serviingo.serviingo.modelrepo.Responsee.AddonseRepo;
import com.serviingo.serviingo.modelrepo.Responsee.HomePageRepo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.myViewHolder> {
    HomePageRepo homePageRepo;
    Context context;
    private HomeAdapterClick itemClickListenerr;
   // private ArrayList<String> elements;
   //ArrayList<ThreeSectionModel> arrayListmodel;
    public HomeAdapter(HomePageRepo homePageRepo, Context context, HomeAdapterClick itemClickListenerr) {
        this. homePageRepo=homePageRepo;
        this.context = context;
      //  this.elements = elements;

        this.itemClickListenerr = itemClickListenerr;
    }

    /* public HomeAdapter(HomePageRepo modelArrayList, Context context) {
         this.modelArrayList = modelArrayList;
         this.context = context;
     }
 */
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recent_grid, parent, false);

        return new HomeAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
      /*  String id = String.valueOf(modelArrayList.getData().getAllCategories().get(position).getId());
        for (int i = 0; i < elements.size(); i++) {
            System.out.println("elementselements" + elements.get(i));
            System.out.println("elementselements" + modelArrayList.getData().getAllCategories().get(position).getId());
            if (id.equalsIgnoreCase(elements.get(i))) {
                holder.CateName.setText(modelArrayList.getData().getAllCategories().get(position).getName());
                holder.CateNamee.setText(Html.fromHtml(modelArrayList.getData().getAllCategories().get(position).getAboutCategory()));


                Picasso.get().load(modelArrayList.getData().getCategoryImagePath() + modelArrayList.getData().getAllCategories().get(position).getIcon()).into(holder.iv_Imageview);

            }
        }
*/
        holder.CateName.setText(homePageRepo.getData().getSubCategories().get(position).getSubCategoryName());
        holder.CateNamee.setText(Html.fromHtml(homePageRepo.getData().getSubCategories().get(position).getShortDescription()));

        Picasso.get().load(homePageRepo.getData().getSubCategoryImagePath()+homePageRepo.getData().getSubCategories().get(position).getDetail_image()).into(holder.iv_Imageview);


        holder.clickLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              //  itemClickListenerr.HomeAdaptertwosecotionClickk(String.valueOf(homePageRepo.getData().getSubCategories().get(position).getId()));

                itemClickListenerr.HomeAdaptertwosecotionClickk(homePageRepo,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return homePageRepo.getData().getSubCategories().size();


    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_Imageview;
        TextView CateName, CateNamee;
        FrameLayout clickLL;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            iv_Imageview = itemView.findViewById(R.id.iv_Imageview);
            CateName = itemView.findViewById(R.id.CateName);
            clickLL = itemView.findViewById(R.id.clickLL);
            CateNamee = itemView.findViewById(R.id.CateNamee);
        }
    }

    public interface HomeAdapterClick {

        void HomeAdaptertwosecotionClickk(HomePageRepo homePageRepo,int position);


    }
}
