package com.serviingo.serviingo.Fragments.FinancialService;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.core.text.HtmlCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.ViewPresenter.FinacialPresenter.FinacialServicesDetailsPresenter;
import com.serviingo.serviingo.dialogue.FinanceServiceEnquiryBottomSheet;
import com.serviingo.serviingo.modelrepo.Responsee.Finacial.FinanceServiceDetailRepo;
import com.squareup.picasso.Picasso;

import static com.serviingo.serviingo.R.drawable.globalloader;

public class FinanceServiceDetailFragment extends Fragment implements FinacialServicesDetailsPresenter.FinacialServicesDetailsView {
    String Id,getName;
    Bundle extras;
    TextView tv_dashboardd,tvName,descTv;
    ImageView image;

    FinacialServicesDetailsPresenter presenter;
    CardView btn_moreDetails;



    public FinanceServiceDetailFragment() {
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

        View view = inflater.inflate(R.layout.fragment_finance_service_detail, container, false);
        setui(view);
        return view;
    }

    private void setui(View view) {
        presenter=new FinacialServicesDetailsPresenter(this);
        tv_dashboardd=view.findViewById(R.id.tv_dashboardd);
        image=view.findViewById(R.id.image);
        tvName=view.findViewById(R.id.tvName);
        descTv=view.findViewById(R.id.descTv);
        btn_moreDetails=view.findViewById(R.id.btn_moreDetails);
        extras = getArguments();

        if (extras != null) {
            Id = getArguments().getString("id");
            getName= getArguments().getString("getName");
          //  tv_dashboardd.setText(getName);
            presenter.FinacialServicesDetailsRepo(getContext(),Id);
          //  tv_dashboardd.setText("Home > "+getName);


        }
        btn_moreDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FinanceServiceEnquiryBottomSheet bottomSheet=new FinanceServiceEnquiryBottomSheet(Id,getContext());
                bottomSheet.show(getActivity().getSupportFragmentManager(), bottomSheet.getTag());

            }
        });

    }

    @Override
    public void onFinacialServicesDetailsRepoError(String message) {
        Sneaker.with(getActivity())
                .setTitle(message)
                .setMessage("")
                .sneakError();
    }

    @Override
    public void onFinacialServicesDetailsRepoSuccess(FinanceServiceDetailRepo response, String message) {
        if (message.equalsIgnoreCase("ok"))
        {


            tvName.setText(response.getData().getServiceDetail().getName());
            descTv.setText(HtmlCompat.fromHtml(response.getData().getServiceDetail().getDescription(), 0));
            Picasso.get().load(response.getData().getServiceDetail().getImage()).into(image);


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
    public void onFinacialServicesDetailsRepoFailure(Throwable t) {
        Sneaker.with(getActivity())
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();
    }
}