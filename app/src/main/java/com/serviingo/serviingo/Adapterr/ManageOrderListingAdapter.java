package com.serviingo.serviingo.Adapterr;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.serviingo.serviingo.R;
import com.serviingo.serviingo.modelrepo.Responsee.ManageOrderListingRepo;
import com.serviingo.serviingo.utils.util;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class ManageOrderListingAdapter extends RecyclerView.Adapter<ManageOrderListingAdapter.myViewHolder> {
    AddonseorderAdapter addonseorderAdapter;

    ManageOrderListingRepo modelArrayList;
    Context context;
    private orderClick itemClickListenerr;
    ArrayList<String> arrayList = new ArrayList<>();
    GridLayoutManager gridLayoutManager;

    public ManageOrderListingAdapter(ManageOrderListingRepo modelArrayList, Context context, orderClick itemClickListenerr) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.itemClickListenerr = itemClickListenerr;
    }

 /*   public ManageOrderListingAdapter(ManageOrderListingRepo modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }*/

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dashboard_items, parent, false);

        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {


        int size = modelArrayList.getData().getData().get(position).getAddons().size();
        //    Toast.makeText(context, size+"", Toast.LENGTH_SHORT).show();
        int number = 0;

        if (size > 0) {

            arrayList.clear();
            for (int i = 0; i < size; i++) {
                number = number + 1;
                arrayList.add("." + modelArrayList.getData().getData().get(position).getAddons().get(i).getName());

            }

            gridLayoutManager = new GridLayoutManager(context, 1);
            AddonseorderAdapter addonseorderAdapter = new AddonseorderAdapter(arrayList, context, size);

            holder.recyclerView.setHasFixedSize(true);
            holder.recyclerView.setLayoutManager(gridLayoutManager);
            holder.recyclerView.setAdapter(addonseorderAdapter);

        } else {
        }


        holder.tv_name.setText(modelArrayList.getData().getData().get(position).get_package().getName());
        holder.tv_datee.setText("Order Number: " + modelArrayList.getData().getData().get(position).getOrderNumber());
        holder.paynowTv.setText("\u20B9" + modelArrayList.getData().getData().get(position).getTotalAmount()+" Pay Now");
        // holder.tvtext.setText(Html.fromHtml(String.valueOf(modelArrayList.getData().get(position).getPackage().getAboutPackage())));

        if (modelArrayList.getData().getData().get(position).get_package().getAboutPackage() != null) {
            holder.tv_itemName.setText((Html.fromHtml(modelArrayList.getData().getData().get(position).get_package().getAboutPackage())));

        }
        if (modelArrayList.getData().getData().get(position).getPaymentMethod().equalsIgnoreCase("online") && modelArrayList.getData().getData().get(position).getPaymentStatus().equalsIgnoreCase("Refunded")) {
            holder.paymenticonIV.setVisibility(View.VISIBLE);
            holder.paymenticonIV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(context, "check", Toast.LENGTH_SHORT).show();

                    itemClickListenerr.RefundProcessDetails(modelArrayList, position);

                }
            });
        }

        holder.tv_rating.setText("Order Value: \u20B9" + modelArrayList.getData().getData().get(position).getTotalAmount());

        if (modelArrayList.getData().getData().get(position).getPaymentMethod().equalsIgnoreCase("cod")) {
            holder.pymtnymethod.setText("Payment Method: COD( Cash On Delivery )");

            if (modelArrayList.getData().getData().get(position).getPaymentStatus().equalsIgnoreCase("Failed")
                    || modelArrayList.getData().getData().get(position).getPaymentStatus().equalsIgnoreCase("Pending")) {
                holder.paynowTv.setVisibility(View.VISIBLE);


            }


        } else if (modelArrayList.getData().getData().get(position).getPaymentMethod().equalsIgnoreCase("online")) {
            holder.pymtnymethod.setText("Payment Method: Online Payment");

        } else if (modelArrayList.getData().getData().get(position).getPaymentMethod().equalsIgnoreCase("wallet")) {
            holder.pymtnymethod.setText("Payment Method : Wallet ");

        }


        if (modelArrayList.getData().getData().get(position).getPaymentMethod().equalsIgnoreCase("online")) {

            Log.e("sjlksdlsk",modelArrayList.getData().getData().get(position).getPaymentStatus());

            if (modelArrayList.getData().getData().get(position).getPaymentStatus().equalsIgnoreCase("Failed")
                    || modelArrayList.getData().getData().get(position).getPaymentStatus().equalsIgnoreCase("Pending") || modelArrayList.getData().getData().get(position).getPaymentStatus().equalsIgnoreCase("Not-Initiated")) {
                holder.RePaymentTV.setVisibility(View.VISIBLE);
                holder.pymtnystaus.setText(modelArrayList.getData().getData().get(position).getPaymentStatus());
            } else {
                holder.pymtnystaus.setText(modelArrayList.getData().getData().get(position).getPaymentStatus());

            }


        }


        if (modelArrayList.getData().getData().get(position).getPaymentStatus().equalsIgnoreCase("Pending")) {
            if (modelArrayList.getData().getData().get(position).getPaymentMethod().equalsIgnoreCase("cod")) {
                holder.paynowTv.setVisibility(View.VISIBLE);
                holder.pymtnystaus.setText("Payment Status: Pending");

            } else {
                holder.pymtnystaus.setText("Payment Status: " + modelArrayList.getData().getData().get(position).getPaymentStatus());

            }


        } else {
            holder.pymtnystaus.setText("Payment Status: " + modelArrayList.getData().getData().get(position).getPaymentStatus());
            if (modelArrayList.getData().getData().get(position).getPaymentStatus().equalsIgnoreCase("Completed")) {

                holder.paynowTv.setVisibility(View.GONE);

            }

        }

        String dateAndTime = modelArrayList.getData().getData().get(position).getCreatedAt();

        holder.tv_date.setText("Order Date: " + util.getDate(dateAndTime));

        holder.tv_pending.setText(modelArrayList.getData().getData().get(position).getOrderStatus());
        String _24HourTime = modelArrayList.getData().getData().get(position).getServeTime();
        SimpleDateFormat _24HourSDF = new SimpleDateFormat("HH:mm");
        SimpleDateFormat _12HourSDF = new SimpleDateFormat("hh:mm a");
        try {
            Date _24HourDt = _24HourSDF.parse(_24HourTime);
            holder.Serve_time.setText(_12HourSDF.format(_24HourDt));
        } catch (Exception e) {

        }

        if (modelArrayList.getData().getData().get(position).getServing_datetime() != null) {
            holder.serve_date.setText(modelArrayList.getData().getData().get(position).getServing_datetime());

        }


        if (modelArrayList.getData().getData().get(position).getOrderStatus().equalsIgnoreCase("Completed")) {
            holder.paymentstatusLL.setVisibility(View.VISIBLE);
            holder.tv_pending.setVisibility(View.VISIBLE);
            holder.tv_cancelOrder.setVisibility(View.GONE);

            holder.tv_pending.setText("Completed");
            holder.tv_pending.setTextColor(Color.parseColor("#299b00"));


        } else if (modelArrayList.getData().getData().get(position).getOrderStatus().equalsIgnoreCase("Cancelled")) {
            holder.tv_cancelOrder.setVisibility(View.GONE);

            //  holder.tv_pending.setBackground(context.getResources().getDrawable(R.drawable.reddrawable));
            holder.tv_pending.setVisibility(View.VISIBLE);
            holder.RePaymentTV.setVisibility(View.GONE);
            holder.paymentstatusLL.setVisibility(View.VISIBLE);
            holder.paynowTv.setVisibility(View.GONE);


            holder.tv_pending.setText("Cancelled");

        } else if (modelArrayList.getData().getData().get(position).getOrderStatus().equalsIgnoreCase("Ongoing")) {
            holder.tv_pending.setVisibility(View.VISIBLE);
            holder.tv_pending.setText("Ongoing");

            holder.tv_cancelOrder.setVisibility(View.GONE);
            holder.paymentstatusLL.setVisibility(View.VISIBLE);
           /* holder.tv_pending.setBackground(context.getResources().getDrawable(R.drawable.reddrawable));
            holder.tv_pending.setText("Cancelled");
*/
        } else if (modelArrayList.getData().getData().get(position).getOrderStatus().equalsIgnoreCase("Processing")) {
            holder.tv_pending.setVisibility(View.VISIBLE);
            holder.paymentstatusLL.setVisibility(View.VISIBLE);
            holder.tv_pending.setText("Processing");

           /* holder.tv_pending.setBackground(context.getResources().getDrawable(R.drawable.reddrawable));
            holder.tv_pending.setText("Cancelled");
*/
        } else if (modelArrayList.getData().getData().get(position).getOrderStatus().equalsIgnoreCase("Pending")) {
            //  holder.tv_pending.setBackground(context.getResources().getDrawable(R.drawable.reddrawable));
            holder.tv_cancelOrder.setVisibility(View.VISIBLE);



           /* holder.tv_pending.setBackground(context.getResources().getDrawable(R.drawable.reddrawable));
            holder.tv_pending.setText("Cancelled");
*/
        }
      /*  if (!modelArrayList.getData().getData().get(position).getOrderStatus().equalsIgnoreCase("Pending")) {
            holder.tv_pending.setVisibility(View.VISIBLE);

            holder.tv_cancelOrder.setVisibility(View.GONE);
            holder.tv_pending.setText(modelArrayList.getData().getData().get(position).getOrderStatus());


        }*/

        holder.tv_orderDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListenerr.OrderDetailsClick(String.valueOf(modelArrayList.getData().getData().get(position).getId()));

            }
        });


        if (modelArrayList.getData().getData().get(position).getFindRelatedvendorInfo() != null) {
            holder.PartnerLL.setVisibility(View.VISIBLE);
            holder.PartnerNameTv.setText(modelArrayList.getData().getData().get(position).getFindRelatedvendorInfo().getFirstName() +
                    modelArrayList.getData().getData().get(position).getFindRelatedvendorInfo().getLastName() +
                    " | " + modelArrayList.getData().getData().get(position).getFindRelatedvendorInfo().getMobileNumber()
            );
            holder.VaccinatedTv.setText("Vaccinated " + modelArrayList.getData().getData().get(position).getFindRelatedvendorInfo().getVaccinated());

            if (modelArrayList.getData().getData().get(position).getFindRelatedvendorInfo().getProfilePhotoPath() != null) {
                Picasso.get().load(modelArrayList.getData().getData().get(position).getFindRelatedvendorInfo().getProfile_image_url() + modelArrayList.getData().getData().get(position).getFindRelatedvendorInfo().getProfilePhotoPath()).into(holder.PartnerImage);

            }

            holder.PartnerNameTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:" + Uri.encode(modelArrayList.getData().getData().get(position).getFindRelatedvendorInfo().getMobileNumber())));
                    callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(callIntent);
                }
            });
        }
        holder.paynowTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                itemClickListenerr.PayNowClick(modelArrayList, position);

            }
        });
        holder.RePaymentTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                itemClickListenerr.RePaymentTV(modelArrayList, position);


            }
        });


        holder.tv_cancelOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                itemClickListenerr.CancelDetailsClick(String.valueOf(modelArrayList.getData().getData().get(position).getId()),modelArrayList,position);


            }
        });


    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().getData().size();

    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name, tv_date, tv_datee, tv_itemName, tv_orderDetail, tv_cancelOrder, tv_rating, tv_pending, tv_addOn, tv_addOnDetail,
                serve_date, Serve_time, PartnerNameTv, VaccinatedTv, pymtnymethod, pymtnystaus, paynowTv, RePaymentTV;
        RecyclerView recyclerView;
        LinearLayout PartnerLL, paymentstatusLL;
        ImageView PartnerImage, paymenticonIV;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            RePaymentTV = itemView.findViewById(R.id.RePaymentTV);
            pymtnymethod = itemView.findViewById(R.id.pymtnymethod);
            pymtnystaus = itemView.findViewById(R.id.pymtnystaus);
            paynowTv = itemView.findViewById(R.id.paynowTv);
            tv_date = itemView.findViewById(R.id.tv_date);
            tv_itemName = itemView.findViewById(R.id.tv_itemName);
            recyclerView = itemView.findViewById(R.id.recyclerbooking);
            paymenticonIV = itemView.findViewById(R.id.paymenticonIV);
            tv_datee = itemView.findViewById(R.id.tv_datee);

            tv_orderDetail = itemView.findViewById(R.id.tv_orderDetail);
            tv_cancelOrder = itemView.findViewById(R.id.tv_cancelOrder);
            tv_rating = itemView.findViewById(R.id.tv_rating);
            tv_pending = itemView.findViewById(R.id.tv_pending);
            //tv_addOnDetail = itemView.findViewById(R.id.tv_addOnDetail);
            tv_addOn = itemView.findViewById(R.id.tv_addOn);
            serve_date = itemView.findViewById(R.id.serve_date);
            Serve_time = itemView.findViewById(R.id.Serve_time);
            PartnerLL = itemView.findViewById(R.id.PartnerLL);
            paymentstatusLL = itemView.findViewById(R.id.paymentstatusLL);
            PartnerNameTv = itemView.findViewById(R.id.PartnerNameTv);
            VaccinatedTv = itemView.findViewById(R.id.VaccinatedTv);
            PartnerImage = itemView.findViewById(R.id.PartnerImage);
        }
    }

    public interface orderClick {

        void OrderDetailsClick(String id);

        void PayNowClick(ManageOrderListingRepo manageOrderListingRepo, int Position);

        void RePaymentTV(ManageOrderListingRepo manageOrderListingRepo, int Position);


        void CancelDetailsClick(String id,ManageOrderListingRepo manageOrderListingRepo, int Position);

        void RefundProcessDetails(ManageOrderListingRepo manageOrderListingRepo, int Position);


    }
}
