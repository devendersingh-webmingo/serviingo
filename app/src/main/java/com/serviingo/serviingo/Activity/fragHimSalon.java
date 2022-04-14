package com.serviingo.serviingo.Activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.Adapterr.ReviewAdapter;
import com.serviingo.serviingo.Common.Preferences;
import com.serviingo.serviingo.Database.AppSettings;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.ViewPresenter.CategoryDetailsPresenter;
import com.serviingo.serviingo.modelrepo.Responsee.CategoriesDetailsRepo;
import com.serviingo.serviingo.storage.SharedPrefManager;
import com.serviingo.serviingo.view.BaseFragment;

import static com.serviingo.serviingo.R.drawable.globalloader;

public class fragHimSalon extends BaseFragment implements CategoryDetailsPresenter.CategoryDetailsView{
    RatingBar rating;
    TextView tvRatings,tvRatingsValue,tvSaloonReview,reviews_title,BookingnumberTV,tvdate,addressTV,reviews_heading;
    View rootView;
    Preferences preferences;
    CategoryDetailsPresenter presenter;
    RecyclerView icrecyclerView;
    LinearLayout llBookingCount;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate( R.layout.himsaloonui, container, false );

        setUi();
        return  rootView;
    }

    private void setUi() {
        presenter=new CategoryDetailsPresenter(this);
        tvRatings=rootView.findViewById(R.id.tvRatings);
        tvSaloonReview=rootView.findViewById(R.id.tvSaloonReview);
        rating=rootView.findViewById(R.id.rating);
        preferences=new Preferences(mActivity);
          icrecyclerView=rootView.findViewById(R.id.icrecyclerView);
        llBookingCount=rootView.findViewById(R.id.llBookingCount);


        BookingnumberTV=rootView.findViewById(R.id.BookingnumberTV);


        tvdate=rootView.findViewById(R.id.tvdate);
        addressTV=rootView.findViewById(R.id.addressTV);
        reviews_heading=rootView.findViewById(R.id.reviews_heading);
        reviews_title=rootView.findViewById(R.id.reviews_title);

        LinearLayoutManager linearLayoutManager = (new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        icrecyclerView.setLayoutManager(linearLayoutManager);
        icrecyclerView.setHasFixedSize(true);


        SharedPrefManager.getInstance(getContext()).getcategoriesID();
        presenter.CategoryDetails(getContext(), SharedPrefManager.getInstance(getContext()).getcategoriesID());
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

            ReviewAdapter reviewAdapter=new ReviewAdapter(response,getContext());
            icrecyclerView.setAdapter(reviewAdapter);
            if (response.getData().getCategory().getCategoryRating().getTotalBooking()>0)
            {
                llBookingCount.setVisibility(View.VISIBLE);
                BookingnumberTV.setText(String.valueOf(response.getData().getCategory().getCategoryRating().getTotalBooking()));
            }

            tvdate.setText(String.valueOf(response.getData().getCategory().getCategoryRating().getAvgRating())+"/5");
            addressTV.setText(" Based on "+String.valueOf(response.getData().getCategory().getCategoryRating().getTotalRate())+" ratings");
            reviews_heading.setText(response.getData().getCategory().getReviewsHeading());
            reviews_title.setText(response.getData().getCategory().getReviewsTitle());



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
