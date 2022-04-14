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
import com.serviingo.serviingo.Adapterr.FinancialAdapter.FinanceSubCaetegoryAdapter;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.ViewPresenter.FinacialPresenter.FinacialCategoryPresenter;
import com.serviingo.serviingo.ViewPresenter.FinacialPresenter.FinacialSubCategoryPresenter;
import com.serviingo.serviingo.modelrepo.Responsee.Finacial.FinacialSubcategoryRepo;

import static com.serviingo.serviingo.R.drawable.globalloader;

public class FinanceSubCategoriesFragment extends Fragment implements FinacialSubCategoryPresenter.FinacialSubCategoryView ,FinanceSubCaetegoryAdapter.HomeAdapterClick{

    RecyclerView financialcategory;

    FinacialSubCategoryPresenter presenter;
    String Id,getName;
    Bundle extras;
    TextView tv_dashboardd,tvCall;


    public FinanceSubCategoriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_finance_sub_categories, container, false);
        setui(view);
        return view;
    }

    private void setui(View view) {
        tv_dashboardd=view.findViewById(R.id.tv_dashboardd);
        tvCall=view.findViewById(R.id.tvCall);
        presenter = new FinacialSubCategoryPresenter(this);
        financialcategory = view.findViewById(R.id.financialcategory);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, LinearLayoutManager.VERTICAL, false);
        financialcategory.setLayoutManager(gridLayoutManager);
        financialcategory.setHasFixedSize(true);
        extras = getArguments();

        if (extras != null) {
            Id = getArguments().getString("id");
            getName= getArguments().getString("getName");
            tv_dashboardd.setText("Home  > "+getName);

          //  Toast.makeText(getContext(), Id+"", Toast.LENGTH_SHORT).show();
            presenter.FinacialSubcategoryRepo(getContext(),getArguments().getString("id"));

        }



      /*  HomeAdapter homeAdapter = new HomeAdapter(response, getContext().getApplicationContext(),this::HomeAdapterClickk);
        rcv.setAdapter(homeAdapter);*/


    }

    @Override
    public void onFinacialSubcategoryRepoError(String message) {
        Sneaker.with(getActivity())
                .setTitle(message)
                .setMessage("")
                .sneakError();
    }

    @Override
    public void onFinacialSubcategoryRepoSuccess(FinacialSubcategoryRepo response, String message) {
        /*Sneaker.with(getActivity())
                .setTitle(message)
                .setMessage("")
                .sneakError();*/
        if (message.equalsIgnoreCase("ok")) {
            if (response.getData().getSubCategories().size()>0)
            {

                FinanceSubCaetegoryAdapter homeAdapter = new FinanceSubCaetegoryAdapter(response, getContext(), this::HomeAdapterClickk);
                financialcategory.setAdapter(homeAdapter);
            }
            else {
                tvCall.setVisibility(View.VISIBLE);
                financialcategory.setVisibility(View.GONE);
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
    public void onFinacialSubcategoryRepoFailure(Throwable t) {
        Sneaker.with(getActivity())
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();
    }

    @Override
    public void HomeAdapterClickk(FinacialSubcategoryRepo repo, int pos) {
      //  Toast.makeText(getContext(), repo.getData().getSubCategories().get(pos).getName()+"", Toast.LENGTH_SHORT).show();


        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment addonesFragment = new FinanceServicesFragment();
        Bundle args = new Bundle();
        args.putString("id", String.valueOf(repo.getData().getSubCategories().get(pos).getId()));
        args.putString("getName", String.valueOf(repo.getData().getSubCategories().get(pos).getName()));

        addonesFragment.setArguments(args);
        fragmentTransaction.replace(R.id.fragment_Container, addonesFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}