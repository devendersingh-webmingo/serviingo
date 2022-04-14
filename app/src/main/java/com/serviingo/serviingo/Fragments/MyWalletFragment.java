package com.serviingo.serviingo.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.Activity.AboutUs;
import com.serviingo.serviingo.Activity.ContactUsActivity;
import com.serviingo.serviingo.Activity.MainActivity;
import com.serviingo.serviingo.Activity.MyBookingActivity;
import com.serviingo.serviingo.Activity.MyWalletActivity;
import com.serviingo.serviingo.Activity.ProfileActivity;
import com.serviingo.serviingo.Adapterr.MyWalletAdapter;
import com.serviingo.serviingo.Common.Preferences;
import com.serviingo.serviingo.Database.AppSettings;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.ViewPresenter.DoLogoutPresenter;
import com.serviingo.serviingo.ViewPresenter.DoMyWalletPresenter;
import com.serviingo.serviingo.dialogue.AddMoneyOnlineWallet_BottomSheet;
import com.serviingo.serviingo.dialogue.AddMoneyWallet_BottomSheet;
import com.serviingo.serviingo.modelrepo.Responsee.MywalletRespo;
import com.serviingo.serviingo.utils.AppUtils;
import com.serviingo.serviingo.utils.CheckInternetConnection;
import com.serviingo.serviingo.utils.util;

import static com.serviingo.serviingo.R.drawable.globalloader;

public class MyWalletFragment extends Fragment implements View.OnClickListener, DoMyWalletPresenter.DoMyWalletView {

    RecyclerView recyclerView;

    LinearLayoutManager linearLayoutManager;
    MyWalletAdapter walletAdapter;
    String pinterest_linklink, facebook_linklink, linkedin_linklink, youtube_linklink, insta_linklink;
    TextView tv_home, tvgreen, tvwallet;

    DoMyWalletPresenter doMyWalletPresenter;


    TextView tv_dashboardd,
            tv_myBooking, tv_myProfile, tv_myWallet,tv_Financial, tv_changePassword, tv_myReviews, tv_myAddressbook, tv_mySupport, tv_referralDashboard;
    ImageView arrowIvv;
    public static ScrollView scrollView;
    SwipeRefreshLayout refreshLayout;


    public MyWalletFragment() {
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

        View view = inflater.inflate(R.layout.fragment_my_wallet, container, false);
        if (util.isOnline(getActivity().getApplicationContext())) {

            refreshLayout = view.findViewById(R.id.refreshLayout);


            findViewById(view);
            setOnclickistener();

            refreshLayout.setOnRefreshListener(
                    new SwipeRefreshLayout.OnRefreshListener() {
                        @Override
                        public void onRefresh() {

                            // Your code goes here
                            // In this code, we are just
                            // changing the text in the textbox


                            findViewById(view);
                            setOnclickistener();


                            // This line is important as it explicitly
                            // refreshes only once
                            // If "true" it implicitly refreshes forever
                            refreshLayout.setRefreshing(false);
                        }
                    }
            );

        } else {
            new CheckInternetConnection(getContext()).checkConnection();

            Sneaker.with(this)
                    .setTitle(getResources().getString(R.string.noconnection))
                    .setMessage("")
                    .sneakError();
        }


        // getActivity().getSupportActionBar().setTitle();


   /*  setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" "); */
        return view;
    }

    private void findViewById(View view) {
        AppTools.showRequestDialog(getActivity());

        tv_home = view.findViewById(R.id.tv_home);

        tvgreen = view.findViewById(R.id.tvgreen);
        tvwallet = view.findViewById(R.id.tvwallet);
        doMyWalletPresenter = new DoMyWalletPresenter(this);
        doMyWalletPresenter.DoMyprofil(getContext().getApplicationContext());

        recyclerView = view.findViewById(R.id.recyclerView);


        scrollView = view.findViewById(R.id.scroll_side_menu);
        tv_dashboardd = view.findViewById(R.id.tv_dashboardd);
        tv_myBooking = view.findViewById(R.id.tv_myBooking);
        tv_myProfile = view.findViewById(R.id.tv_myProfile);
        tv_myWallet = view.findViewById(R.id.tv_myWallet);
        tv_Financial   = view.findViewById(R.id.tv_Financial);
        tv_changePassword = view.findViewById(R.id.tv_changePassword);
        tv_myReviews = view.findViewById(R.id.tv_myReviews);
        tv_myAddressbook = view.findViewById(R.id.tv_myAddressbook);
        tv_mySupport = view.findViewById(R.id.tv_mySupport);
        tv_referralDashboard = view.findViewById(R.id.tv_referralDashboard);
        arrowIvv = view.findViewById(R.id.arrowIvv);
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
    }

    private void setOnclickistener() {

        tv_home.setOnClickListener(this);
        tvgreen.setOnClickListener(this);

        tv_myBooking.setOnClickListener(this);
        tv_myProfile.setOnClickListener(this);
        tv_myWallet.setOnClickListener(this);
        tv_Financial.setOnClickListener(this);
        tv_changePassword.setOnClickListener(this);
        tv_myReviews.setOnClickListener(this);
        tv_myAddressbook.setOnClickListener(this);
        tv_mySupport.setOnClickListener(this);
        tv_referralDashboard.setOnClickListener(this);

    }

    public void ONClick_Add_Money() {

        AddMoneyOnlineWallet_BottomSheet addMoneyWallet_bottomSheet = new AddMoneyOnlineWallet_BottomSheet();
        addMoneyWallet_bottomSheet.show(getActivity().getSupportFragmentManager(), addMoneyWallet_bottomSheet.getTag());


    }

    @Override
    public void onDoMyWalleteError(String message) {
        AppTools.hideDialog();
        Sneaker.with(this)
                .setTitle(message)
                .setMessage("")
                .sneakError();

    }

    @Override
    public void onDoMyWalletSuccess(MywalletRespo response, String message) {

        if (message.equalsIgnoreCase("ok")) {

            tvwallet.setText(response.getData().getAvailableWalletAmount());
            walletAdapter = new MyWalletAdapter(response, getContext().getApplicationContext());
            recyclerView.setAdapter(walletAdapter);
            linearLayoutManager = (new LinearLayoutManager(getContext().getApplicationContext(), LinearLayoutManager.VERTICAL, true));
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setHasFixedSize(true);
            AppTools.hideDialog();

        } else {
            AppTools.hideDialog();

        }

    }

    @Override
    public void onDoMyWalletFailure(Throwable t) {
        AppTools.hideDialog();
        Sneaker.with(this)
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();
    }


    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        switch (v.getId()) {

            case R.id.tvgreen:
                ONClick_Add_Money();
                //  startActivity(new Intent(this, SignUpActivity.class));
                break;
          /*  case R.id.rrsignin:
                startActivity(new Intent(this, LoginActivity.class));
                break;
*/
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

            case R.id.tv_Financial:
                // onBackPressed();

                Fragment Membership = new MyMemberShipFragment();
                fragmentTransaction.replace(R.id.fragment_Container, Membership);
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


        }


    }


}