package com.serviingo.serviingo.Activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.Adapterr.FAQAdapter;
import com.serviingo.serviingo.Adapterr.ReviewAdapter;
import com.serviingo.serviingo.Common.Preferences;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.ViewPresenter.CategoryDetailsPresenter;
import com.serviingo.serviingo.modelrepo.Responsee.CategoriesDetailsRepo;
import com.serviingo.serviingo.storage.SharedPrefManager;
import com.serviingo.serviingo.view.BaseFragment;

import static com.serviingo.serviingo.R.drawable.globalloader;

public class fragFAQ extends BaseFragment implements CategoryDetailsPresenter.CategoryDetailsView{
    View rootView;
    CategoryDetailsPresenter presenter;
    RecyclerView icrecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate( R.layout.fragfaqui, container, false );
        presenter=new CategoryDetailsPresenter(this);
        presenter.CategoryDetails(getContext(), SharedPrefManager.getInstance(getContext()).getcategoriesID());
      //  Toast.makeText(mActivity, SharedPrefManager.getInstance(getContext()).getcategoriesID()+"", Toast.LENGTH_SHORT).show();

        setUi();
        return  rootView;
    }

    private void setUi() {

       icrecyclerView=rootView.findViewById(R.id.icrecyclerView);
        LinearLayoutManager linearLayoutManager = (new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        icrecyclerView.setLayoutManager(linearLayoutManager);
        icrecyclerView.setHasFixedSize(true);


    }
    @Override
    public void onCategoryDetailsError(String message) {
        Sneaker.with(getActivity())
                .setTitle(message)
                .setMessage("")
                .sneakError();
    }

    @Override
    public void onCategoryDetailsSuccess(CategoriesDetailsRepo response, String message) {
    /*    Sneaker.with(getActivity())
                .setTitle(message)
                .setMessage("")
                .sneakError();*/

        if (message.equalsIgnoreCase("ok"))
        {
            FAQAdapter faqAdapter=new FAQAdapter(response,getContext());
            icrecyclerView.setAdapter(faqAdapter);
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
    public void onCategoryDetailsFailure(Throwable t) {
        Sneaker.with(getActivity())
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();
    }

}
