package com.serviingo.serviingo.Fragments;

import android.graphics.Paint;
import android.os.Bundle;

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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.Adapterr.AddonseAdapter;
import com.serviingo.serviingo.Adapterr.ShowListPackageAdapter;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.ViewPresenter.MakePackagePresenter;
import com.serviingo.serviingo.modelrepo.Responsee.CustomPackageRepo;
import com.serviingo.serviingo.modelrepo.Responsee.DiscountRepo;
import com.serviingo.serviingo.modelrepo.Responsee.ShowListPackageRepo;
import com.serviingo.serviingo.modelrepo.request.CustomPackageSUBSub_request;
import com.serviingo.serviingo.modelrepo.request.CustomPackage_request;

import java.util.ArrayList;

import static com.serviingo.serviingo.R.drawable.globalloader;

public class MakePakageFragment extends Fragment implements MakePackagePresenter.MakePackageListView, ShowListPackageAdapter.CheckBoxListener {
    RecyclerView recyclerView;
    Bundle extras;
    String Id, name, sub_category_id, Quentiy;
    MakePackagePresenter packagePresenter;
    ShowListPackageAdapter adapter;
    TextView note, btn, tvPrice, tvdata;
    double discountPrice = 0, t = 0;
    RelativeLayout RL_AddTocart;
    double TotalPrice;
    ArrayList<String> arrayList = new ArrayList<>();
    String offer_discount, check;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.makepackagelayout, container, false);

        setui(view);


        return view;
    }

    private void setui(View view) {
        note = view.findViewById(R.id.note);

        extras = getArguments();
        if (extras != null) {

            check = getArguments().getString("sub");

            Id = getArguments().getString("id");
            name = getArguments().getString("name");
            sub_category_id = getArguments().getString("sub_category_id");
            Quentiy = getArguments().getString("Quentiy");


            note.setText("Make Your Package -" + name);
            //   Toast.makeText(getContext(), sub_category_id + "", Toast.LENGTH_SHORT).show();

        }
        AppTools.showRequestDialog(getActivity());
        recyclerView = view.findViewById(R.id.recyclerView);
        btn = view.findViewById(R.id.btn);
        tvPrice = view.findViewById(R.id.tvPrice);
        tvdata = view.findViewById(R.id.tvdata);
        packagePresenter = new MakePackagePresenter(this);
        // Toast.makeText(getContext(), Id + "", Toast.LENGTH_SHORT).show();
        packagePresenter.GetPackage(getContext(), Id);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
        RL_AddTocart = view.findViewById(R.id.RL_AddTocart);
        RL_AddTocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TotalPrice > 0) {
                    AppTools.showRequestDialog(getActivity());


                    if (check.equalsIgnoreCase("sub")) {

                        CustomPackage_request customPackage_request = new CustomPackage_request(arrayList, String.valueOf(TotalPrice), sub_category_id, offer_discount, String.valueOf(t));
                        packagePresenter.CustomPackage(getContext(), customPackage_request);


                    } else if (check.equalsIgnoreCase("subsub")) {

                        CustomPackageSUBSub_request customPackage_request = new CustomPackageSUBSub_request(arrayList, String.valueOf(TotalPrice), sub_category_id, offer_discount, String.valueOf(t));
                        packagePresenter.CustomPackageSUBSub_request(getContext(), customPackage_request);

                    }


                } else {

                    Sneaker.with(getActivity())
                            .setTitle("")
                            .setMessage("Make your Package !")
                            .sneakError();
                }
            }
        });

    }

    @Override
    public void onMakePackagelistError(String message) {
        AppTools.hideDialog();

        Sneaker.with(this)
                .setTitle(message)
                .setMessage("")
                .sneakError();
    }

    @Override
    public void onMakePackagelistSuccess(ShowListPackageRepo repo, String message) {
        AppTools.hideDialog();

        if (repo.getData().getServices().size() > 0) {
            AppTools.hideDialog();


            adapter = new ShowListPackageAdapter(repo, getContext().getApplicationContext(), this);
            recyclerView.setAdapter(adapter);
        }

    }

    @Override
    public void onDiscoutSuccess(DiscountRepo repo, String message) {
        AppTools.hideDialog();


        if (message.equalsIgnoreCase("ok")) {
            offer_discount = String.valueOf(repo.getData().getDiscount().getDiscount());

            discountPrice = Double.parseDouble(String.valueOf(repo.getData().getDiscountAmount()));

            String string_temp = new Double(discountPrice).toString();
            String string_form = string_temp.substring(0, string_temp.indexOf('.'));
            t = Double.valueOf(string_form);


            btn.setText("\u20B9" + t);


            tvPrice.setText("Hurray! " + repo.getData().getDiscount().getOfferName() + " , offer successfully applid on total amount, you got " + repo.getData().getDiscount().getDiscount() + "% discount.");
            //  Log.e("Pricdddde", String.valueOf(Price));

        }


    }

    @Override
    public void onCustomPackageSuccess(CustomPackageRepo repo, String message) {
        AppTools.hideDialog();

        if (message.equalsIgnoreCase("ok")) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Fragment addonesFragment = new AddonesFragment();
            Bundle args = new Bundle();
            args.putString("id", String.valueOf(repo.getData().getId()));
            args.putString("Quentiy", Quentiy);


            addonesFragment.setArguments(args);
            fragmentTransaction.replace(R.id.fragment_Container, addonesFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

    }

    @Override
    public void onMakePackagelistFailure(Throwable t) {
        AppTools.hideDialog();

        Sneaker.with(this)
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();
    }


    @Override
    public void CheckedClick(ShowListPackageRepo showListPackageRepo, int position, Boolean bb) {
        if (bb == true) {
            AppTools.showRequestDialog(getActivity());
            arrayList.add(String.valueOf(showListPackageRepo.getData().getServices().get(position).getId()));

            if (showListPackageRepo.getData().getServices().get(position).getAfterDiscount() != null) {
                TotalPrice = TotalPrice + Double.parseDouble(showListPackageRepo.getData().getServices().get(position).getAfterDiscount());
                packagePresenter.Discount(getContext(), String.valueOf(TotalPrice));
                tvdata.setText(String.valueOf(TotalPrice));
                tvdata.setPaintFlags(tvdata.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

            } else {

                TotalPrice = TotalPrice + Double.parseDouble(showListPackageRepo.getData().getServices().get(position).getAmount());
                packagePresenter.Discount(getContext(), String.valueOf(TotalPrice));
                tvdata.setText(String.valueOf(TotalPrice));
                tvdata.setPaintFlags(tvdata.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            }


        } else {

            AppTools.showRequestDialog(getActivity());
            arrayList.remove(String.valueOf(showListPackageRepo.getData().getServices().get(position).getId()));

            if (showListPackageRepo.getData().getServices().get(position).getAfterDiscount() != null) {
                TotalPrice = TotalPrice - Double.parseDouble(showListPackageRepo.getData().getServices().get(position).getAfterDiscount());
                packagePresenter.Discount(getContext(), String.valueOf(TotalPrice));
                tvdata.setText(String.valueOf(TotalPrice));
                tvdata.setPaintFlags(tvdata.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

            } else {
                TotalPrice = TotalPrice - Double.parseDouble(showListPackageRepo.getData().getServices().get(position).getAmount());

                packagePresenter.Discount(getContext(), String.valueOf(TotalPrice));
                tvdata.setText(String.valueOf(TotalPrice));
                tvdata.setPaintFlags(tvdata.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

            }
        }
        //  Toast.makeText(getContext(), arrayList.toString() + "", Toast.LENGTH_SHORT).show();

    }
}