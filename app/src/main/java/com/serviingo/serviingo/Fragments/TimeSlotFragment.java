package com.serviingo.serviingo.Fragments;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.Adapterr.TimeSlotAdapter.DatelistslotAdapterr;
import com.serviingo.serviingo.Adapterr.TimeSlotAdapter.VandorlistAdapterr;
import com.serviingo.serviingo.Adapterr.TimeSlotAdapter.timelistslotAdapterr;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.ViewPresenter.TimeSlotPresenter;
import com.serviingo.serviingo.modelrepo.Responsee.DateSlotRepo;
import com.serviingo.serviingo.modelrepo.Responsee.ServetimeSlotRepo;
import com.serviingo.serviingo.modelrepo.request.CreateOrderRequest;

import org.w3c.dom.Text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.serviingo.serviingo.R.drawable.globalloader;

public class TimeSlotFragment extends Fragment implements TimeSlotPresenter.TimeSlotView, DatelistslotAdapterr.DateClick, timelistslotAdapterr.CustomizedClick {
    //    TextView heading;
    RecyclerView dateRV, timeRV;
    TimeSlotPresenter presenter;
    Bundle extras;
    String package_id, payment_method, total_amount, addon_service_ids, SafetyAndHygieneFee, pack_quantity, Subtoal, discount_amount,
            membership_cost, membership_id, membership_discount;

    ArrayList<CreateOrderRequest.AddonService> addonServices;

    CardView btn_moreDetails;
    String Subcategory, serve_time = " 2021-08-24", serve_date = " 17:10";


    public TimeSlotFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_time_slot, container, false);
        findViewById(view);


        return view;
    }

    private void findViewById(View view) {
        extras = getArguments();

        if (extras != null) {

            Subcategory = getArguments().getString("Subcategory");

         /*   package_id = getArguments().getString("id");
            payment_method = getArguments().getString("payment");
            total_amount = getArguments().getString("Total");

            addon_service_ids = getArguments().getString("addon_service_ids");
            SafetyAndHygieneFee = getArguments().getString("SafetyAndHygieneFee");
            pack_quantity = getArguments().getString("pack_quantity");
            Subtoal = getArguments().getString("Subtoal");
            discount_amount = getArguments().getString("discount_amount");
            addonServices = (ArrayList<CreateOrderRequest.AddonService>) getArguments().getSerializable("addonServices");
*/
/*

            Log.e("addonServices", package_id + "\n" + payment_method + "\n"
                    + total_amount + "\n" + addon_service_ids + "\n"
                    + SafetyAndHygieneFee + "\n" + addonServices.size());

*/

            // Toast.makeText(getContext(), Subcategory+"", Toast.LENGTH_SHORT).show();
        }


        dateRV = view.findViewById(R.id.dateRV);
        LinearLayoutManager linearLayoutManager2 = (new LinearLayoutManager(getContext().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        dateRV.setLayoutManager(linearLayoutManager2);
        dateRV.setHasFixedSize(true);
        btn_moreDetails = view.findViewById(R.id.btn_moreDetails);
        timeRV = view.findViewById(R.id.timeRV);
        LinearLayoutManager linearLayoutManager3 = (new LinearLayoutManager(getContext().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        timeRV.setLayoutManager(linearLayoutManager3);
        timeRV.setHasFixedSize(true);
        presenter = new TimeSlotPresenter(this);

        presenter.DateSlotRepo(getContext(), Subcategory);
        // presenter.TimeSlotRepo(getContext(),"1","2021-08-24");

        btn_moreDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment fragment = new AppliencesCareServicesFragment();
                Bundle args = new Bundle();
                args.putString("serve_time", serve_time);
                args.putString("serve_date", serve_date);


                // args.putParcelableArrayList("arraylist", addonServices);

                fragment.setArguments(args);

                fragmentTransaction.replace(R.id.fragment_Container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


            }
        });


    }

    @Override
    public void onDateSlotRepoError(String message) {
        Sneaker.with(getActivity())
                .setTitle(message)
                .setMessage("")
                .sneakError();
    }

    @Override
    public void onDateSlotRepoSuccess(DateSlotRepo response, String message) {

        if (message.equalsIgnoreCase("ok")) {
            if (response.getData().getSlotDates().size() > 0) {
                DatelistslotAdapterr datelistslotAdapterr = new DatelistslotAdapterr(response, getContext(), this);
                dateRV.setAdapter(datelistslotAdapterr);
                presenter.TimeSlotRepo(getContext(), Subcategory, response.getData().getTodayDate());
                serve_date = response.getData().getTodayDate();
            } else {
                btn_moreDetails.setVisibility(View.GONE);
                Sneaker.with(getActivity())
                        .setTitle("No any slots available for this date, please try after some time")
                        .setMessage("")
                        .sneakWarning();
            }
        }
      /*  Sneaker.with(getActivity())
                .setTitle(message)
                .setMessage("")
                .sneakError();
*/

    }

    @Override
    public void onTimeSlotRepoSuccess(ServetimeSlotRepo response, String message) {
        if (message.equalsIgnoreCase("ok")) {
            if (response.getData().getSlots().size() > 0) {
              /*  timelistslotAdapterr t = new timelistslotAdapterr(response, getContext(), this);
                timeRV.setAdapter(t);
*/
/*
                DatelistslotAdapterr datelistslotAdapterr=new DatelistslotAdapterr(response,getContext(),this);
                dateRV.setAdapter(datelistslotAdapterr);*/
            }
        }
    }

    @Override
    public void showHideProgress(boolean isShow) {
        if (isShow) {
            AppTools.showRequestDialog(getActivity());

        } else {
            AppTools.hideDialog();

        }
    }

    @Override
    public void onDateSlotRepoFailure(Throwable t) {
        Sneaker.with(getActivity())
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();
    }

    @Override
    public void CustomizeddateClickk(DateSlotRepo repo, int pos) {
        serve_date = String.valueOf(repo.getData().getSlotDates().get(pos).getDate());
        presenter.TimeSlotRepo(getContext(), Subcategory, String.valueOf(repo.getData().getSlotDates().get(pos).getDate()));

    }

    @Override
    public void CustomizedTimeClickk(String  repo, int pos) {
        // Toast.makeText(getContext(), pos + "", Toast.LENGTH_SHORT).show();


        serve_time =repo;// String.valueOf(repo.getData().getSlots().get(pos).getTime());


    }
}