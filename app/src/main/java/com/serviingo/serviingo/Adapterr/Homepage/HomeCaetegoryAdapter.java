package com.serviingo.serviingo.Adapterr.Homepage;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.serviingo.serviingo.R;
import com.serviingo.serviingo.model.ThreeSectionModel;
import com.serviingo.serviingo.modelrepo.Responsee.HomePageRepo;
import com.serviingo.serviingo.utils.AppUrls;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;


public class HomeCaetegoryAdapter extends RecyclerView.Adapter<HomeCaetegoryAdapter.myViewHolder> {

    HomePageRepo modelArrayList;
    Context context;
    private HomeAdapterClick itemClickListenerr;
    ArrayList<ThreeSectionModel> arrayListmodel = new ArrayList<>();
    ArrayList<ThreeSectionModel> twosectionlist = new ArrayList<>();
    ArrayList<ThreeSectionModel> Foursectionlist = new ArrayList<>();
    ArrayList<ThreeSectionModel> CategoriesList = new ArrayList<>();

    public HomeCaetegoryAdapter(HomePageRepo modelArrayList, Context context, HomeAdapterClick itemClickListenerr) {
        this.modelArrayList = modelArrayList;
        this.context = context;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_layout, parent, false);

        return new HomeCaetegoryAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        String id = String.valueOf(modelArrayList.getData().getAllCategories().get(position).getId());

        Picasso.get().load(modelArrayList.getData().getCategoryImagePath() + modelArrayList.getData().getAllCategories().get(position).getIcon()).into(holder.iv_Imageview);
        holder.CateName.setText(modelArrayList.getData().getAllCategories().get(position).getName());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListenerr.HomeAdapterClickk(modelArrayList, position);
            }
        });


        String categories_ids = String.valueOf(modelArrayList.getData().getMainSection().getCategoriesIds());
        Log.e("categories_ids", categories_ids);

        ArrayList<String> categories_idsList = new ArrayList(Arrays.asList(categories_ids.split(",")));
        for (int i = 0; i < categories_idsList.size(); i++) {
            if (id.equalsIgnoreCase(categories_idsList.get(i))) {

                Log.e("categories_idsdf", String.valueOf(categories_idsList.get(i)));

                ThreeSectionModel threeSectionModel = new ThreeSectionModel(String.valueOf(modelArrayList.getData().getAllCategories().get(position).getId())
                        , modelArrayList.getData().getAllCategories().get(position).getName(),
                        modelArrayList.getData().getAllCategories().get(position).getAboutCategory()
                        , modelArrayList.getData().getCategoryImagePath() + modelArrayList.getData().getAllCategories().get(position).getIcon());
                CategoriesList.add(threeSectionModel);
            }

        }
        itemClickListenerr.CategoriesList(CategoriesList);



        String ThreeSection = modelArrayList.getData().getThreeSection().getCategoriesIds();
        ArrayList<String> ThreeSectionList = new ArrayList(Arrays.asList(ThreeSection.split(",")));
        for (int i = 0; i < ThreeSectionList.size(); i++) {
            if (id.equalsIgnoreCase(ThreeSectionList.get(i))) {
                ThreeSectionModel threeSectionModel = new ThreeSectionModel(String.valueOf(modelArrayList.getData().getAllCategories().get(position).getId())
                        , modelArrayList.getData().getAllCategories().get(position).getName(),
                        modelArrayList.getData().getAllCategories().get(position).getAboutCategory()
                        , modelArrayList.getData().getCategoryImagePath() + modelArrayList.getData().getAllCategories().get(position).getDetail_image());
                arrayListmodel.add(threeSectionModel);
            }
        }
        itemClickListenerr.threeSecotion(arrayListmodel);

        String twoSection = modelArrayList.getData().getTwoSection().getCategoriesIds();
        ArrayList<String> twoSectionList = new ArrayList(Arrays.asList(twoSection.split(",")));
        for (int i = 0; i < twoSectionList.size(); i++) {
            if (id.equalsIgnoreCase(twoSectionList.get(i))) {
                ThreeSectionModel threeSectionModel = new ThreeSectionModel(String.valueOf(modelArrayList.getData().getAllCategories().get(position).getId())
                        , modelArrayList.getData().getAllCategories().get(position).getName(),
                        modelArrayList.getData().getAllCategories().get(position).getAboutCategory()
                        , modelArrayList.getData().getCategoryImagePath() + modelArrayList.getData().getAllCategories().get(position).getDetail_image());
                twosectionlist.add(threeSectionModel);
            }
        }
        itemClickListenerr.twoSecotion(twosectionlist);


        String fourSection = modelArrayList.getData().getFourSection().getCategoriesIds();
        ArrayList<String> fourSectionList = new ArrayList(Arrays.asList(fourSection.split(",")));

        for (int i = 0; i < fourSectionList.size(); i++) {

           // Log.e("fourSectionfourSection", fourSectionList.get(i));



            if (id.equalsIgnoreCase(fourSectionList.get(i))) {

                ThreeSectionModel threeSectionModel = new ThreeSectionModel(String.valueOf(modelArrayList.getData().getAllCategories().get(position).getId())
                        , modelArrayList.getData().getAllCategories().get(position).getName(),
                        modelArrayList.getData().getAllCategories().get(position).getAboutCategory()
                        , modelArrayList.getData().getCategoryImagePath() + modelArrayList.getData().getAllCategories().get(position).getDetail_image());
                Foursectionlist.add(threeSectionModel);
            }
        }

        itemClickListenerr.FourSecotion(Foursectionlist);






    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().getAllCategories().size();


    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView CateName;
        CardView cardView;
        ImageView iv_Imageview;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            // tvCategory = itemView.findViewById(R.id.tv_Category);
            cardView = itemView.findViewById(R.id.cv_View);
            iv_Imageview = itemView.findViewById(R.id.iv_Imageview);
            CateName = itemView.findViewById(R.id.CateName);
        }
    }

    public interface HomeAdapterClick {

        void HomeAdapterClickk(HomePageRepo repo, int pos);
        void threeSecotion(ArrayList<ThreeSectionModel> arrayListmodel );
        void CategoriesList(ArrayList<ThreeSectionModel> arrayListmodel );

        void twoSecotion(ArrayList<ThreeSectionModel> arrayListmodel );

        void FourSecotion(ArrayList<ThreeSectionModel> foursectionlist);
    }
}
