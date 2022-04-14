package com.serviingo.serviingo.Fragments.FinancialService;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.Adapterr.FinancialAdapter.FinanceCaetegoryAdapter;
import com.serviingo.serviingo.Adapterr.FinancialAdapter.FinanceServiceAdapter;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.ViewPresenter.FinacialPresenter.FinacialServicesPresenter;
import com.serviingo.serviingo.modelrepo.Responsee.Finacial.FinacialServicesRepo;

import static com.serviingo.serviingo.R.drawable.globalloader;

public class FinanceServicesFragment extends Fragment implements FinacialServicesPresenter.FinacialServicesView , FinanceServiceAdapter.HomeAdapterClick{
    RecyclerView FinanceServicesRV;
    FinacialServicesPresenter presenter;

    String Id,getName;
    Bundle extras;
    TextView tv_dashboardd,tvCall;


    public FinanceServicesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_finance_services, container, false);
        setui(view);
        return view;
    }

    private void setui(View view) {
        presenter=new FinacialServicesPresenter(this);
        FinanceServicesRV = view.findViewById(R.id.FinanceServicesRV);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1, LinearLayoutManager.VERTICAL, false);
        FinanceServicesRV.setLayoutManager(gridLayoutManager);
        FinanceServicesRV.setHasFixedSize(true);
        tv_dashboardd=view.findViewById(R.id.tv_dashboardd);
        tvCall=view.findViewById(R.id.tvCall);

        extras = getArguments();

        if (extras != null) {
            Id = getArguments().getString("id");
            getName= getArguments().getString("getName");
            presenter.FinacialServicesRepo(getContext(),Id);
            tv_dashboardd.setText("Home > "+getName);


        }


    }

    @Override
    public void onFinacialServicesRepoError(String message) {
        Sneaker.with(getActivity())
                .setTitle(message)
                .setMessage("")
                .sneakError();
    }

    @Override
    public void onFinacialServicesRepoSuccess(FinacialServicesRepo response, String message) {
        /*Sneaker.with(getActivity())
                .setTitle(message)
                .setMessage("")
                .sneakError();*/

        if (message.equalsIgnoreCase("ok")) {
            if (response.getData().getServices().size()>0)
            {
                FinanceServiceAdapter homeAdapter = new FinanceServiceAdapter(response, getContext().getApplicationContext(), this::HomeAdapterClickk);
                FinanceServicesRV.setAdapter(homeAdapter);
            }else {
                tvCall.setVisibility(View.VISIBLE);
                FinanceServicesRV.setVisibility(View.GONE);
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
    public void onFinacialServicesRepoFailure(Throwable t) {
        Sneaker.with(getActivity())
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();
    }

    @Override
    public void HomeAdapterClickk(FinacialServicesRepo repo, int pos) {
      //  Toast.makeText(getContext(), repo.getData().getServices().get(pos).getName()+"", Toast.LENGTH_SHORT).show();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment addonesFragment = new FinanceServiceDetailFragment();
        Bundle args = new Bundle();
        args.putString("id", String.valueOf(repo.getData().getServices().get(pos).getId()));
        args.putString("getName", String.valueOf(repo.getData().getServices().get(pos).getName()));

        addonesFragment.setArguments(args);
        fragmentTransaction.replace(R.id.fragment_Container, addonesFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}