package com.serviingo.serviingo.Fragments;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
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
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.Adapterr.FinancialAdapter.FinanceCaetegoryAdapter;
import com.serviingo.serviingo.Adapterr.IncompltedBookingAdapter;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.ViewPresenter.ManageOrderListingPresenter;
import com.serviingo.serviingo.ViewPresenter.TempCart.GetTempcartPresenter;
import com.serviingo.serviingo.modelrepo.Responsee.IncompletedBookingRepo;
import com.serviingo.serviingo.storage.SharedPrefManager;
import com.serviingo.serviingo.utils.AppUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.ResponseBody;

import static com.serviingo.serviingo.R.drawable.globalloader;

public class IncompleteBookingFragment extends Fragment implements View.OnClickListener, GetTempcartPresenter.GetTempcartView, IncompltedBookingAdapter.IncompltedBooking {

    TextView tv_dashboardd, tv_Membership, tv_Financial, MymembershipTv, tvCall,
            tv_myBooking, tv_myProfile, tv_myWallet, tv_changePassword, tv_myReviews, tv_myAddressbook, tv_mySupport, tv_referralDashboard, IncompleteBooking_Tv;

    ImageView arrowIvv;
    public static ScrollView scrollView;
    SwipeRefreshLayout refreshLayout;
    RecyclerView recyclerbookingrecyclerbooking;
    GetTempcartPresenter getTempcartPresenter;
    DeleteAddressViewDialog deleteAddressViewDialog;

    public IncompleteBookingFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_incomplete_booking, container, false);
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
        deleteAddressViewDialog = new DeleteAddressViewDialog();

        scrollView = view.findViewById(R.id.scroll_side_menu);
        scrollView.setVisibility(View.GONE);
        tvCall = view.findViewById(R.id.tvCall);
        tv_dashboardd = view.findViewById(R.id.tv_dashboardd);
        tv_myBooking = view.findViewById(R.id.tv_myBooking);
        tv_myProfile = view.findViewById(R.id.tv_myProfile);
        tv_Financial = view.findViewById(R.id.tv_Financial);
        MymembershipTv = view.findViewById(R.id.MymembershipTv);
        tv_Membership = view.findViewById(R.id.tv_Membership);
        tv_myWallet = view.findViewById(R.id.tv_myWallet);
        arrowIvv = view.findViewById(R.id.arrowIvv);

        tv_changePassword = view.findViewById(R.id.tv_changePassword);
        tv_myReviews = view.findViewById(R.id.tv_myReviews);
        tv_myAddressbook = view.findViewById(R.id.tv_myAddressbook);
        tv_mySupport = view.findViewById(R.id.tv_mySupport);
        tv_referralDashboard = view.findViewById(R.id.tv_referralDashboard);
        IncompleteBooking_Tv = view.findViewById(R.id.IncompleteBooking_Tv);

        recyclerbookingrecyclerbooking = view.findViewById(R.id.recyclerbooking);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1, LinearLayoutManager.VERTICAL, false);
        recyclerbookingrecyclerbooking.setLayoutManager(gridLayoutManager);
        recyclerbookingrecyclerbooking.setHasFixedSize(true);
        getTempcartPresenter = new GetTempcartPresenter(this);
        getTempcartPresenter.GetTempcartRepo(getContext());
        tv_dashboardd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (arrowIvv.getRotation() == 0) {
                    arrowIvv.setRotation(-90);

                    scrollView.setVisibility(View.GONE);
                    AppUtils.collapse(scrollView);

                /*    if (scrollView.getVisibility() == View.VISIBLE) {
                        AppUtils.collapse(scrollView);
                    } else {
                        AppUtils.expand(scrollView);

                    }*/
                } else {
                    arrowIvv.setRotation(0);

                    scrollView.setVisibility(View.VISIBLE);
                    AppUtils.expand(scrollView);

                }
            }
        });

        clickListner();
    }

    private void clickListner() {


        tv_myBooking.setOnClickListener(this);
        tv_myProfile.setOnClickListener(this);
        tv_myWallet.setOnClickListener(this);
        tv_changePassword.setOnClickListener(this);
        tv_myReviews.setOnClickListener(this);
        tv_myAddressbook.setOnClickListener(this);
        tv_mySupport.setOnClickListener(this);
        tv_referralDashboard.setOnClickListener(this);
        tv_Membership.setOnClickListener(this);
        tv_Financial.setOnClickListener(this);
        MymembershipTv.setOnClickListener(this);

        IncompleteBooking_Tv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch (v.getId()) {

            case R.id.tv_Dashboard:
                // onBackPressed();


                Fragment homeFragment = new HomeFragment();
                fragmentTransaction.replace(R.id.fragment_Container, homeFragment);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
                break;
            case R.id.tv_myProfile:
                // onBackPressed();


                Fragment profileFragment = new ProfileFragment();
                fragmentTransaction.replace(R.id.fragment_Container, profileFragment);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
                break;
            case R.id.tv_myBooking:
                // onBackPressed();
               /* Fragment profileFragment = new ProfileFragment();
                fragmentTransaction.replace(R.id.fragment_Container,profileFragment);
                fragmentTransaction.commit();*/
                Fragment RecentBookingFragment = new RecentBookingFragment();
                fragmentTransaction.replace(R.id.fragment_Container, RecentBookingFragment);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();

                break;
            case R.id.tv_myWallet:
                // onBackPressed();
                Fragment myWalletFragment = new MyWalletFragment();
                fragmentTransaction.replace(R.id.fragment_Container, myWalletFragment);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
                break;
            case R.id.tv_changePassword:
                // onBackPressed();
                Fragment changePasswordFragment = new ChangePasswordFragment();
                fragmentTransaction.replace(R.id.fragment_Container, changePasswordFragment);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
                break;
            case R.id.tv_myReviews:
                // onBackPressed();

                Fragment reviewRatingFragment = new ReviewRatingFragment();
                fragmentTransaction.replace(R.id.fragment_Container, reviewRatingFragment);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
                break;
            case R.id.tv_myAddressbook:
                // onBackPressed();

                Fragment addressFragment = new AddressFragment();
                fragmentTransaction.replace(R.id.fragment_Container, addressFragment);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
                break;
            case R.id.tv_mySupport:
                // onBackPressed();


                Fragment tabs = new SupportTicketsFragment();
                fragmentTransaction.replace(R.id.fragment_Container, tabs);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
                break;
            case R.id.tv_referralDashboard:
                // onBackPressed();

                Fragment ReferralUser = new ReferralUserFragment();
                fragmentTransaction.replace(R.id.fragment_Container, ReferralUser);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
                break;
            case R.id.tv_Membership:
                // onBackPressed();

                Fragment HistoryFragment = new MemberShipPaymentHistoryFragment();
                fragmentTransaction.replace(R.id.fragment_Container, HistoryFragment);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
                break;

            case R.id.tv_Financial:
                // onBackPressed();

                Fragment Membership = new MyMemberShipFragment();
                fragmentTransaction.replace(R.id.fragment_Container, Membership);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
                break;
            case R.id.MymembershipTv:
                // onBackPressed();

                Fragment MymembershipTv = new MyMemberShipFragment();
                fragmentTransaction.replace(R.id.fragment_Container, MymembershipTv);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
                break;


            case R.id.IncompleteBooking_Tv:
                // onBackPressed();

                Fragment IncompleteBookingFragment = new IncompleteBookingFragment();
                fragmentTransaction.replace(R.id.fragment_Container, IncompleteBookingFragment);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
                break;

        }


    }

    @Override
    public void onGetTempcartRepoError(String message) {
        Sneaker.with(getActivity())
                .setTitle(message)
                .setMessage("")
                .sneakError();
    }

    @Override
    public void onGetTempcartRepoSuccess(IncompletedBookingRepo response, String message) {
        if (message.equalsIgnoreCase("ok")) {
            if (response.getData().getIncompleteOrders().getData().size() > 0) {
                recyclerbookingrecyclerbooking.setVisibility(View.VISIBLE);
                tvCall.setVisibility(View.GONE);
                IncompltedBookingAdapter incompltedBookingAdapter = new IncompltedBookingAdapter(response, getContext(), this);
                recyclerbookingrecyclerbooking.setAdapter(incompltedBookingAdapter);


               /* FinanceCaetegoryAdapter homeAdapter = new FinanceCaetegoryAdapter(response, getContext().getApplicationContext(), this::HomeAdapterClickk);
                financialcategory.setAdapter(homeAdapter);*/
            } else {
                tvCall.setVisibility(View.VISIBLE);
                tvCall.setText("No Data Found");

                recyclerbookingrecyclerbooking.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void onDeleteTempcartRepoSuccess(ResponseBody response, String message) {
        if (message.equalsIgnoreCase("ok")) {
            Sneaker.with(getActivity())
                    .setTitle("Temp Cart Data Deleted Successfully.")
                    .setMessage("")
                    .sneakSuccess();

            getTempcartPresenter.GetTempcartRepo(getContext());


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
    public void onGetTempcartRepoFailure(Throwable t) {
        Sneaker.with(getActivity())
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();
    }

    @Override
    public void EditClickk(IncompletedBookingRepo repo, int pos) {
      /*  Sneaker.with(getActivity())
                .setTitle(String.valueOf(pos))
                .setMessage("")
                .sneakError();*/


        String csv = repo.getData().getIncompleteOrders().getData().get(pos).getAddons();
        // step one : converting comma separate String to array of String
        String[] elements = csv.split(",");
        // step two : convert String array to list of String
        List<String> fixedLenghtList = Arrays.asList(elements); //
        // step three : copy fixed list to an ArrayList
        ArrayList<String> listOfString = new ArrayList<String>(fixedLenghtList);


        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment appliencesCareServicesFragment = new AppliencesCareServicesFragment();
        Bundle args = new Bundle();
        args.putString("id", String.valueOf(repo.getData().getIncompleteOrders().getData().get(pos).getPackageId()));
        args.putStringArrayList("arrayList",listOfString);
        args.putString("checkTempcart", "1");
        args.putString("csv", csv);


        args.putString("Quentiy", "1");
        appliencesCareServicesFragment.setArguments(args);
        fragmentTransaction.replace(R.id.fragment_Container, appliencesCareServicesFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void Deletelclick(String id, int pos) {
       /* Sneaker.with(getActivity())
                .setTitle(String.valueOf(id))
                .setMessage("")
                .sneakError();*/
        deleteAddressViewDialog.showDialog(getActivity(), id);


    }

    public class DeleteAddressViewDialog {

        TextView tvDelete, tvCancel, descTv;
        AlertDialog alertDialog;

        public void showDialog(Activity activity, String id) {

            LayoutInflater inflater = LayoutInflater.from(activity);
            View view = inflater.inflate(R.layout.rating_delete_alertbox, null);
            alertDialog = new AlertDialog.Builder(activity)
                    .setView(view)
                    .setCancelable(false)
                    .create();


            ImageView close = view.findViewById(R.id.close);
            tvDelete = view.findViewById(R.id.tvDelete);
            tvCancel = view.findViewById(R.id.tvCancel);
            descTv = view.findViewById(R.id.descTv);
            //
            descTv.setText("Delete This Data.");

            close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss();
                }
            });
            tvDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    alertDialog.dismiss();
                    getTempcartPresenter.DeleteTempcart(activity, id);
                }
            });
            tvCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss();
                }
            });

            alertDialog.show();
        }


    }
}