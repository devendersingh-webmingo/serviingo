package com.serviingo.serviingo.Adapterr.TimeSlotAdapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.serviingo.serviingo.R;
import com.serviingo.serviingo.modelrepo.Responsee.ServetimeSlotRepo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import de.hdodenhof.circleimageview.CircleImageView;


public class timelistslotAdapterr extends RecyclerView.Adapter<timelistslotAdapterr.myViewHolder> {
    ArrayList<String > modelArrayList=new ArrayList<>();
   // ServetimeSlotRepo modelArrayList;
    Context context;
    private CustomizedClick itemClickListenerr;

    String selectedId = "dfdffd";

    public timelistslotAdapterr( ArrayList<String > modelArrayList, Context context, CustomizedClick itemClickListenerr) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.itemClickListenerr = itemClickListenerr;
    }
   /* public timelistslotAdapterr(Context context) {
        this.context = context;
    }*/

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.timeadapterslot, parent, false);

        return new timelistslotAdapterr.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {


            holder.cv_Viewl.setVisibility(View.VISIBLE);

            try {

                String _24HourTime = modelArrayList.get(position);

                Log.e("_24HourTime",_24HourTime);
                SimpleDateFormat _24HourSDF = new SimpleDateFormat("HH:mm");
                SimpleDateFormat _12HourSDF = new SimpleDateFormat("hh:mm a");
                Date _24HourDt = _24HourSDF.parse(_24HourTime);

                holder.timeTv.setText(_12HourSDF.format(_24HourDt));
                if (selectedId.equalsIgnoreCase("dfdffd")) {
                    selectedId = String.valueOf(modelArrayList.get(position));
                }

                if (selectedId.equalsIgnoreCase(modelArrayList.get(position))) {

                    itemClickListenerr.CustomizedTimeClickk(modelArrayList.get(position), position);


                    holder.cv_Viewl.setBackgroundColor(context.getResources().getColor(R.color.time));
                    holder.timeTv.setTextColor(context.getResources().getColor(R.color.white));


                } else {

                    holder.cv_Viewl.setBackgroundColor(context.getResources().getColor(R.color.Cornsilk));
                    holder.timeTv.setTextColor(context.getResources().getColor(R.color.black));


                }


                holder.cv_Viewl.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        selectedId = modelArrayList.get(position);

                        itemClickListenerr.CustomizedTimeClickk(modelArrayList.get(position), position);

                        holder.cv_Viewl.setBackgroundColor(context.getResources().getColor(R.color.time));
                        holder.timeTv.setTextColor(context.getResources().getColor(R.color.white));

                        notifyDataSetChanged();
                    }
                });

            } catch (final ParseException e) {
                e.printStackTrace();
            }


        }




    @Override
    public int getItemCount() {
        return modelArrayList.size();


    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        CardView cv_Viewl;
        TextView timeTv;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            timeTv = itemView.findViewById(R.id.timeTv);
            cv_Viewl = itemView.findViewById(R.id.cv_View);
        }
    }

    public interface CustomizedClick {

        void CustomizedTimeClickk(String repo, int pos);


    }
}
