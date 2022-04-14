package com.serviingo.serviingo.Adapterr.TimeSlotAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.serviingo.serviingo.R;
import com.serviingo.serviingo.modelrepo.Responsee.DateSlotRepo;

import de.hdodenhof.circleimageview.CircleImageView;


public class DatelistslotAdapterr extends RecyclerView.Adapter<DatelistslotAdapterr.myViewHolder> {

    DateSlotRepo modelArrayList;
    Context context;
    private DateClick itemClickListenerr;
    String selectedId = "dfdffd";


    public DatelistslotAdapterr(DateSlotRepo modelArrayList, Context context, DateClick itemClickListenerr) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.itemClickListenerr = itemClickListenerr;
    }


   /* public DatelistslotAdapterr(Context context) {
        this.context = context;
    }*/

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.timedateadapter, parent, false);

        return new DatelistslotAdapterr.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.number.setText(String.valueOf(modelArrayList.getData().getSlotDates().get(position).getDay()));
        holder.day.setText(String.valueOf(modelArrayList.getData().getSlotDates().get(position).getName()));

        if (selectedId.equalsIgnoreCase("dfdffd")) {
            selectedId = String.valueOf(modelArrayList.getData().getSlotDates().get(0).getDay());
        }


        ///
        if (selectedId.equalsIgnoreCase(modelArrayList.getData().getSlotDates().get(position).getDay())) {

            itemClickListenerr.CustomizeddateClickk(modelArrayList, position);

            holder.ivProfilePic.setBackground(context.getResources().getDrawable(R.drawable.circleblue));
            holder.number.setTextColor(context.getResources().getColor(R.color.white));;


        } else {
            holder.ivProfilePic.setBackground(context.getResources().getDrawable(R.drawable.circle_gray));
            holder.number.setTextColor(context.getResources().getColor(R.color.black));;

        }


        //Picasso.get().load(modelArrayList.getData().getGalleryImages().get(position).getImages()).into(holder.ivimageone);

        holder.ivProfilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedId = modelArrayList.getData().getSlotDates().get(position).getDay();

                itemClickListenerr.CustomizeddateClickk(modelArrayList, position);

                holder.ivProfilePic.setBackground(context.getResources().getDrawable(R.drawable.circleblue));
                holder.number.setTextColor(context.getResources().getColor(R.color.white));;

                notifyDataSetChanged();

            }
        });
    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().getSlotDates().size();// modelArrayList.getData().getGalleryImages().size();


    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        CircleImageView ivProfilePic;
        TextView number, day;
        LinearLayout linnearLayout;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            number = itemView.findViewById(R.id.number);
            day = itemView.findViewById(R.id.day);
            ivProfilePic = itemView.findViewById(R.id.ivProfilePic);


        }
    }

    public interface DateClick {

        void CustomizeddateClickk(DateSlotRepo repo, int pos);


    }
}
