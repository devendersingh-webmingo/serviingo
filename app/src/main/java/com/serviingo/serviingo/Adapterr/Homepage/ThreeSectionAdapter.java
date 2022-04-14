package com.serviingo.serviingo.Adapterr.Homepage;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.serviingo.serviingo.R;
import com.serviingo.serviingo.model.ThreeSectionModel;
import com.serviingo.serviingo.modelrepo.Responsee.HomePageRepo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class ThreeSectionAdapter extends RecyclerView.Adapter<ThreeSectionAdapter.myViewHolder> {

   // HomePageRepo modelArrayList;
    Context context;
    private HomeAdapterClick itemClickListenerr;
    private ArrayList<String> elements;
    ArrayList<ThreeSectionModel> arrayListmodel;
  /*  public ThreeSectionAdapter(ArrayList<String> elements, HomePageRepo modelArrayList, Context context, HomeAdapterClick itemClickListenerr) {
        this.elements = elements;

        this.modelArrayList = modelArrayList;
        this.context = context;
        this.itemClickListenerr = itemClickListenerr;
    }*/
      public ThreeSectionAdapter(ArrayList<ThreeSectionModel> arrayListmodel, Context context, HomeAdapterClick itemClickListenerr) {

        this.arrayListmodel = arrayListmodel;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.thirdsectionadapter, parent, false);

        return new ThreeSectionAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.CateName.setText(arrayListmodel.get(position).name);
        holder.CateNamee.setText(Html.fromHtml(arrayListmodel.get(position).descirption));

        Picasso.get().load(arrayListmodel.get(position).image).into(holder.iv_Imageview);


        holder.clickLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             itemClickListenerr.HomeAdapterthirdsecotionClickk(arrayListmodel.get(position).id);
            }
        });

       /* String id = String.valueOf(arrayListmodel.getData().getAllCategories().get(position).getId());

        for (int i = 0; i < elements.size(); i++) {
            System.out.println("elementselements" + elements.get(i));
            System.out.println("elementselements" + modelArrayList.getData().getAllCategories().get(position).getId());


            if (id.equalsIgnoreCase(elements.get(i))) {
                holder. cardView.setVisibility(View.VISIBLE);

                holder.CateName.setText(modelArrayList.getData().getAllCategories().get(position).getName());
                holder.CateNamee.setText(Html.fromHtml(modelArrayList.getData().getAllCategories().get(position).getAboutCategory()));

                Picasso.get().load(modelArrayList.getData().getCategoryImagePath() + modelArrayList.getData().getAllCategories().get(position).getIcon()).into(holder.iv_Imageview);


                holder.clickLL.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        itemClickListenerr.HomeAdapterthirdsecotionClickk(modelArrayList, position);
                    }
                });
            }
*/
      //  }
    }

    @Override
    public int getItemCount() {
        return arrayListmodel.size();


    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_Imageview;
        TextView CateName, CateNamee;
        LinearLayout clickLL;
        CardView cardView;



        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            iv_Imageview = itemView.findViewById(R.id.ivimageone);
            CateName = itemView.findViewById(R.id.CateName);
            clickLL = itemView.findViewById(R.id.clickLL);
            CateNamee = itemView.findViewById(R.id.CateNamee);
            cardView= itemView.findViewById(R.id.cardView);
        }
    }

    public interface HomeAdapterClick {

        void HomeAdapterthirdsecotionClickk(String id);


    }
}
