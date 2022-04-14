package com.serviingo.serviingo.Fragments.FinancialService;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.Adapterr.FinancialAdapter.FinanceCaetegoryAdapter;
import com.serviingo.serviingo.Adapterr.HomeAdapter;
import com.serviingo.serviingo.Adapterr.MembershipPlansAdapter;
import com.serviingo.serviingo.Fragments.MakePakageFragment;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.ViewPresenter.FinacialPresenter.FinacialCategoryPresenter;
import com.serviingo.serviingo.ViewPresenter.MembershipPresenter;
import com.serviingo.serviingo.modelrepo.Responsee.Finacial.FinacialCategoryRepo;
import com.serviingo.serviingo.utils.AppUtils;

import static com.serviingo.serviingo.R.drawable.globalloader;

public class FinacialFragment extends Fragment implements View.OnClickListener, FinanceCaetegoryAdapter.HomeAdapterClick, FinacialCategoryPresenter.FinacialCategoryView {

    RecyclerView financialcategory;

    LinearLayoutManager linearLayoutManager;
    FinacialCategoryPresenter presenter;
    TextView tvCall;
    SwipeRefreshLayout refreshLayout;


    // TODO: Rename parameter arguments, choose names that match

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_finacial, container, false);
        refreshLayout = view.findViewById(R.id.refreshLayout);

        setui(view);

        refreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {

                        // Your code goes here
                        // In this code, we are just
                        // changing the text in the textbox

                        setui(view);


                        // This line is important as it explicitly
                        // refreshes only once
                        // If "true" it implicitly refreshes forever
                        refreshLayout.setRefreshing(false);
                    }
                }
        );
        return view;
    }

    private void setui(View view) {
        financialcategory = view.findViewById(R.id.financialcategory);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, LinearLayoutManager.VERTICAL, false);
        financialcategory.setLayoutManager(gridLayoutManager);
        financialcategory.setHasFixedSize(true);
        tvCall= view.findViewById(R.id.tvCall);
        presenter = new FinacialCategoryPresenter(this);
        presenter.FinacialCategoryRepo(getContext());
      /*  HomeAdapter homeAdapter = new HomeAdapter(response, getContext().getApplicationContext(),this::HomeAdapterClickk);
        rcv.setAdapter(homeAdapter);*/


    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onFinacialCategoryRepoError(String message) {
        Sneaker.with(getActivity())
                .setTitle(message)
                .setMessage("")
                .sneakError();
    }

    @Override
    public void onFinacialCategoryRepoSuccess(FinacialCategoryRepo response, String message) {
        if (message.equalsIgnoreCase("ok")) {
            if (response.getData().getCategories().size()>0)
            {

                FinanceCaetegoryAdapter homeAdapter = new FinanceCaetegoryAdapter(response, getContext().getApplicationContext(), this::HomeAdapterClickk);
                financialcategory.setAdapter(homeAdapter);
            }
            else {
                tvCall.setVisibility(View.VISIBLE);
                tvCall.setText("No Data Found");

                financialcategory.setVisibility(View.GONE);
            }
        }
      /*  Sneaker.with(getActivity())
                .setTitle(message)
                .setMessage("")
                .sneakError();*/
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
    public void onFinacialCategoryRepoFailure(Throwable t) {
        Sneaker.with(getActivity())
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();
    }

    @Override
    public void HomeAdapterClickk(FinacialCategoryRepo repo, int pos) {
      //  Toast.makeText(getContext(), repo.getData().getCategories().get(pos).getId() + "", Toast.LENGTH_SHORT).show();


        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment addonesFragment = new FinanceSubCategoriesFragment();
        Bundle args = new Bundle();
        args.putString("id", String.valueOf(repo.getData().getCategories().get(pos).getId()));
        args.putString("getName", String.valueOf(repo.getData().getCategories().get(pos).getName()));

        addonesFragment.setArguments(args);
        fragmentTransaction.replace(R.id.fragment_Container, addonesFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
}