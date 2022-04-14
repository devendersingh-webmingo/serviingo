package com.serviingo.serviingo.Adapterr.Homepage;

import android.content.Context;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.serviingo.serviingo.Fragments.HomeFragment;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.model.ThreeSectionModel;
import com.serviingo.serviingo.modelrepo.Responsee.HomePageRepo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class FourSectionAdapter extends RecyclerView.Adapter<FourSectionAdapter.myViewHolder> {

   // HomePageRepo modelArrayList;
    Context context;
    private HomeAdapterClick itemClickListenerr;
    ArrayList<ThreeSectionModel> foursectionlist;
   // ArrayList<String> fourSectionList;
     public FourSectionAdapter( ArrayList<ThreeSectionModel> foursectionlist, Context context, HomeAdapterClick itemClickListenerr) {
          this.foursectionlist = foursectionlist;
          this.context = context;

         this.itemClickListenerr = itemClickListenerr;


      }
   /* public FourSectionAdapter(ArrayList<String> fourSectionList, HomePageRepo response, Context context, HomeFragment homeFragment) {
        this.modelArrayList = response;
        this.context = context;
        this.fourSectionList=fourSectionList;
        this.itemClickListenerr = itemClickListenerr;
    }
*/
    /* public HomeAdapter(HomePageRepo modelArrayList, Context context) {
         this.modelArrayList = modelArrayList;
         this.context = context;
     }
 */
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.thirdsectionadapter, parent, false);

        return new FourSectionAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.CateNamee.setVisibility(View.GONE);
        holder.CateName.setText(foursectionlist.get(position).name);
        // holder.CateNamee.setText(Html.fromHtml(modelArrayList.getData().getAllCategories().get(position).getAboutCategory()));

        Picasso.get().load(foursectionlist.get(position).image).into(holder.iv_Imageview);;


     //   foursectionlist


        holder.clickLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListenerr.HomeAdapterFoursecotionClickk(foursectionlist.get(position).id);
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.e("fourSectionSize", String.valueOf(foursectionlist.size()));

        return foursectionlist.size();


    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_Imageview;
        TextView CateName,CateNamee;
        LinearLayout clickLL;
        CardView cardView;



        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            iv_Imageview = itemView.findViewById(R.id.ivimageone);
            CateName = itemView.findViewById(R.id.CateName);
            clickLL = itemView.findViewById(R.id.clickLL);
            CateNamee= itemView.findViewById(R.id.CateNamee);
            cardView= itemView.findViewById(R.id.cardView);
        }
    }
    public interface HomeAdapterClick {

        void HomeAdapterFoursecotionClickk(String id);


    }
}
