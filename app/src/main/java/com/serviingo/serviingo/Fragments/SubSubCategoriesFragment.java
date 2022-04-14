package com.serviingo.serviingo.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.Adapterr.SubSubCategoriesAdapter;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.ViewPresenter.GetSubSubCategoriesPresenter;
import com.serviingo.serviingo.modelrepo.Responsee.SubSubcateogriesResponse;

public class SubSubCategoriesFragment extends Fragment implements GetSubSubCategoriesPresenter.GetSubSubCategoriesView, SubSubCategoriesAdapter.SubSubCategoriesClick {

    GetSubSubCategoriesPresenter presenter;
    RecyclerView SubSubCategoriesRV;
    SwipeRefreshLayout refreshLayout;
    GridLayoutManager gridLayoutManager;

    Bundle extras;
    String Id, name, short_description, check;

    public SubSubCategoriesFragment() {
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


        View view = inflater.inflate(R.layout.fragment_sub_sub_categories, container, false);

        initview(view);

        refreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {

                        // Your code goes here
                        // In this code, we are just
                        // changing the text in the textbox

                        initview(view);

                        // This line is important as it explicitly
                        // refreshes only once
                        // If "true" it implicitly refreshes forever

                        refreshLayout.setRefreshing(false);
                    }
                }
        );


        return view;

    }

    private void initview(View view) {


        SubSubCategoriesRV = view.findViewById(R.id.SubSubCategoriesRV);
        presenter = new GetSubSubCategoriesPresenter(this);
        refreshLayout = view.findViewById(R.id.refreshLayout);

        SubSubCategoriesRV.setHasFixedSize(true);
        gridLayoutManager = new GridLayoutManager(getContext(), 3);
        SubSubCategoriesRV.setLayoutManager(gridLayoutManager);
        extras = getArguments();

        if (extras != null) {
            Id = getArguments().getString("id");
            check = getArguments().getString("sub");
            short_description = getArguments().getString("short_description");
            name = getArguments().getString("name");
            presenter.GetSubSubCategoriesView(getContext(), Id);
        }


    }

    @Override
    public void onGetSubSubCategoriesError(String message) {
        Sneaker.with(getActivity())
                .setTitle(message)
                .setMessage("")
                .sneakError();
    }

    @Override
    public void GetSubSubCategoriesuccess(SubSubcateogriesResponse response, String message) {

        if (message.equalsIgnoreCase("ok")) {
            if (response.getData().getSubsubCategory().size() > 0) {
                SubSubCategoriesAdapter subSubCategoriesAdapter = new SubSubCategoriesAdapter(response, getContext(), this);
                SubSubCategoriesRV.setAdapter(subSubCategoriesAdapter);
            } else if (check.equalsIgnoreCase("sub")){
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment lowcontactFragment = new LowcontactFragment();
                Bundle args = new Bundle();
                args.putString("id", Id);
                args.putString("sub", "sub");
                args.putString("name", name);
                args.putString("short_description", short_description);
                lowcontactFragment.setArguments(args);
                fragmentTransaction.replace(R.id.fragment_Container, lowcontactFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }

        }
    }

    @Override
    public void onGetSubSubCategoriesFailure(Throwable t) {
        Sneaker.with(getActivity())
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();
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
    public void Click(SubSubcateogriesResponse SubSubcateogriesResponse, int position) {


        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment lowcontactFragment = new LowcontactFragment();
        Bundle args = new Bundle();
        args.putString("id", String.valueOf(SubSubcateogriesResponse.getData().getSubsubCategory().get(position).getId()));
        args.putString("sub", "subsub");
        args.putString("name", name);
        args.putString("short_description", short_description);
        lowcontactFragment.setArguments(args);
        fragmentTransaction.replace(R.id.fragment_Container, lowcontactFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
}