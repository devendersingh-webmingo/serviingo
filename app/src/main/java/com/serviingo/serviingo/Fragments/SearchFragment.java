package com.serviingo.serviingo.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.Adapterr.SearchAdapter;
import com.serviingo.serviingo.Adapterr.SearchAdapter.SearchListener;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.ViewPresenter.SearchPresenter;
import com.serviingo.serviingo.modelrepo.Responsee.SearchResponse;
import com.serviingo.serviingo.storage.SharedPrefManager;

import static com.serviingo.serviingo.R.drawable.globalloader;


public class SearchFragment extends Fragment implements SearchPresenter.SearchPresenterView, SearchAdapter.SearchListener {
    SearchPresenter presenter;

    RecyclerView recyclerView;
    EditText ed_search;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = (new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        ed_search = view.findViewById(R.id.ed_search);
        presenter = new SearchPresenter(this);


        ed_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String text = s.toString();
                presenter.Search(getContext(), text, SharedPrefManager.getInstance(getContext()).GetCityid());
                recyclerView.setVisibility(View.GONE);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        return view;
    }

    @Override
    public void onSerachError(String message) {
        Sneaker.with(getActivity())
                .setTitle(message)
                .setMessage("")
                .sneakError();

    }


    @Override
    public void onSerachSuccess(SearchResponse response, String message) {
        if (message.equalsIgnoreCase("ok")) {
            SearchAdapter searchAdapter = new SearchAdapter(response, getContext(), this);
            recyclerView.setAdapter(searchAdapter);
            recyclerView.setVisibility(View.VISIBLE);


        }
    }

 /*   @Override
    public void showHideProgress(boolean isShow) {
        if (isShow) {
            AppTools.showRequestDialog(getActivity());

        } else {
            AppTools.hideDialog();

        }
    }*/

    @Override
    public void onSerachFailure(Throwable t) {
        Sneaker.with(getActivity())
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();
    }

    @Override
    public void onSearchclick(SearchResponse searchResponse, int pos) {

        if (searchResponse.getData().getSuggestion().get(pos).getType().equalsIgnoreCase("sub-category")) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Fragment subCategoryFragment = new SubCategoryFragment();
            Bundle args = new Bundle();
            // args.putSerializable(ARG_ANIMALS, animals as Serializable)
            args.putString("id", searchResponse.getData().getSuggestion().get(pos).getId());
            args.putString("sub", "sub");
            subCategoryFragment.setArguments(args);
            fragmentTransaction.replace(R.id.fragment_Container, subCategoryFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        else if (searchResponse.getData().getSuggestion().get(pos).getType().equalsIgnoreCase("sub-category-detail")) {





            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Fragment subCategoryFragment = new LowcontactFragment();
            Bundle args = new Bundle();
            // args.putSerializable(ARG_ANIMALS, animals as Serializable)
            args.putString("id", searchResponse.getData().getSuggestion().get(pos).getId());
            args.putString("sub", "subsub");
            subCategoryFragment.setArguments(args);
            fragmentTransaction.replace(R.id.fragment_Container, subCategoryFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        }


    }
}