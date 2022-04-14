package com.serviingo.serviingo.Fragments;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
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
import com.serviingo.serviingo.Adapterr.AddonseAdapter;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.ViewPresenter.AddonsePresenter;
import com.serviingo.serviingo.modelrepo.Responsee.AddonseRepo;
import com.serviingo.serviingo.storage.SharedPrefManager;

import java.util.ArrayList;

public class AddonesFragment extends Fragment implements View.OnClickListener, AddonsePresenter.AddonseListView, AddonseAdapter.CheckBoxListener {

    RecyclerView recyclerView;
    TextView tv_home, tvSend;
    Bundle extras;
    String Id, Quentiy;
    AddonsePresenter addonsePresenter;
    AddonseAdapter addonseAdapter;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayList<String> addons = new ArrayList<>();


    public AddonesFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_addones, container, false);
        setui(view);

        return view;
    }

    private void setui(View view) {
        AppTools.showRequestDialog(getActivity());

        addonsePresenter = new AddonsePresenter(this);

        extras = getArguments();
        if (extras != null) {
            Id = getArguments().getString("id");
            Quentiy = getArguments().getString("Quentiy");

            addons = getArguments().getStringArrayList("arrayList");

            addonsePresenter.GetAddonse(getContext(), Id, addons);
            SharedPrefManager.getInstance(getActivity())
                    .PacckageDetails(Id, Quentiy);

        } else {
            addonsePresenter.GetAddonse(getContext(), SharedPrefManager.getInstance(getContext()).Addonsegetpackage_id(), addons);


        }

        tv_home = view.findViewById(R.id.tv_home);


        recyclerView = view.findViewById(R.id.recyclerView);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);


        tvSend = view.findViewById(R.id.tvSend);


        tvSend.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {

                if (arrayList.size() > 0) {
                 //   Toast.makeText(getContext(), arrayList.size()+"", Toast.LENGTH_SHORT).show();
                    String addon_service_Array_Id = String.join(",", arrayList);
                    SharedPrefManager.getInstance(getActivity())
                            .addon_service_Array_Id(addon_service_Array_Id.trim());
                }


                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment safeHealthFragment = new SafeHealthFragment();
                Bundle args = new Bundle();
                args.putString("id", SharedPrefManager.getInstance(getContext()).Addonsegetpackage_id());
                args.putStringArrayList("arrayList", arrayList);
                args.putString("Quentiy", SharedPrefManager.getInstance(getContext()).Addonsequantityid());

                safeHealthFragment.setArguments(args);
                fragmentTransaction.replace(R.id.fragment_Container, safeHealthFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


                // Toast.makeText(getContext(), arrayList.toString() + "", Toast.LENGTH_SHORT).show();
                //startActivity(new Intent(Addones.this, covidTest.class));
            }
        });

        setOnClickListener();
        //  Toast.makeText(getContext(), Id + "", Toast.LENGTH_SHORT).show();
    }

    private void setOnClickListener() {


        tv_home.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
/*

            case R.id.rrsignin:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.tv_home:
//                finish();
//                startActivity(new Intent(this, MainActivity.class));
                break;
*/

        }
    }

    @Override
    public void onAddonseError(String message) {
        AppTools.hideDialog();

        Sneaker.with(this)
                .setTitle(message)
                .setMessage("")
                .sneakError();
        //   Toast.makeText(getContext(), message + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAddonseSuccess(AddonseRepo response, String message) {
        AppTools.hideDialog();


        if (message.equalsIgnoreCase("ok")) {

            if (response.getData().getServices().size() > 0) {
                AppTools.hideDialog();


                addonseAdapter = new AddonseAdapter(response, getContext().getApplicationContext(), this);
                recyclerView.setAdapter(addonseAdapter);
            } else {

                AppTools.hideDialog();

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment safeHealthFragment = new SafeHealthFragment();
                Bundle args = new Bundle();
                args.putString("id", SharedPrefManager.getInstance(getContext()).Addonsegetpackage_id());
                args.putStringArrayList("arrayList", arrayList);
                args.putString("Quentiy", SharedPrefManager.getInstance(getContext()).Addonsequantityid());
                safeHealthFragment.setArguments(args);
                fragmentTransaction.replace(R.id.fragment_Container, safeHealthFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


            }
        }

        // Toast.makeText(getContext(), message + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAddonseFailure(Throwable t) {
        AppTools.hideDialog();

        Sneaker.with(this)
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();

        // Toast.makeText(getContext(), t.getLocalizedMessage() + "", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void CheckedClick(String id, int position, Boolean bb) {
        if (bb == true) {
            arrayList.add(id);

        } else {
            arrayList.remove(id);
        }

//      Toast.makeText(getContext(), bb + "\n" + id, Toast.LENGTH_SHORT).show();

    }
}