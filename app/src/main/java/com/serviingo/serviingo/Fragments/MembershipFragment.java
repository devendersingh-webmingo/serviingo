package com.serviingo.serviingo.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.Adapterr.MembershipContentAdapter;
import com.serviingo.serviingo.Adapterr.MembershipPlansAdapter;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.ViewPresenter.MembershipPresenter;
import com.serviingo.serviingo.ViewPresenter.MyMembershipPresenter;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.BuyMembershipRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.MembershipContentRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.MembershipPlansRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.MyMembershipRepo;
import com.serviingo.serviingo.utils.AppUtils;

import okhttp3.ResponseBody;

import static com.serviingo.serviingo.R.drawable.globalloader;

public class MembershipFragment extends Fragment  implements View.OnClickListener, MembershipPresenter.MembershipView ,MembershipPlansAdapter.MembershipPlansclick{

    TextView AmountTv, purchecdateTV, membershipTv, validTv, daysTV, expirydateTv, joinnowTv, price, Benifittv, tv_cancelOrder;


    RecyclerView recyclerViewJoin, recyclerViewPlan;
    LinearLayoutManager linearLayoutManager, linearLayoutManager2;
    MembershipPresenter membershipPresenter;

    TextView tv_dashboardd,tv_Membership,tv_Financial,MymembershipTv,
            tv_myBooking, tv_myProfile, tv_myWallet, tv_changePassword, tv_myReviews, tv_myAddressbook, tv_mySupport, tv_referralDashboard;
    ImageView arrowIvv;
    public static ScrollView scrollView;
  LinearLayout JoinmemberShipLL,alredyMembershipLL;

    public MembershipFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_membership, container, false);
        setui(view);
        return view;
    }

    private void setui(View view) {
        JoinmemberShipLL=view.findViewById(R.id.JoinmemberShipLL);
        alredyMembershipLL=view.findViewById(R.id.alredyMembershipLL);
        recyclerViewJoin = view.findViewById(R.id.recyclerViewJoin);
        recyclerViewPlan = view.findViewById(R.id.recyclerViewPlan);
        linearLayoutManager = (new LinearLayoutManager(getContext().getApplicationContext(), LinearLayoutManager.VERTICAL, true));

        recyclerViewJoin.setLayoutManager(linearLayoutManager);
        recyclerViewJoin.setHasFixedSize(true);
        linearLayoutManager2 = (new LinearLayoutManager(getContext().getApplicationContext(), LinearLayoutManager.VERTICAL, true));


        recyclerViewPlan.setLayoutManager(linearLayoutManager2);
        recyclerViewPlan.setHasFixedSize(true);
        membershipPresenter = new MembershipPresenter(this);
        membershipPresenter.MembershipContent(getContext());
        membershipPresenter.MembershipPlan(getContext());



        AmountTv = view.findViewById(R.id.AmountTv);
        validTv = view.findViewById(R.id.validTv);
        membershipTv = view.findViewById(R.id.membershipTv);
        price = view.findViewById(R.id.price);
        expirydateTv = view.findViewById(R.id.expirydateTv);
        purchecdateTV = view.findViewById(R.id.purchecdateTV);
        daysTV = view.findViewById(R.id.daysTV);
        Benifittv = view.findViewById(R.id.Benifittv);
        joinnowTv = view.findViewById(R.id.joinnowTv);
        tv_cancelOrder = view.findViewById(R.id.tv_cancelOrder);



        scrollView = view.findViewById(R.id.scroll_side_menu);
        tv_dashboardd = view.findViewById(R.id.tv_dashboardd);
        tv_myBooking = view.findViewById(R.id.tv_myBooking);
        tv_myProfile = view.findViewById(R.id.tv_myProfile);
        tv_myWallet = view.findViewById(R.id.tv_myWallet);
        tv_changePassword = view.findViewById(R.id.tv_changePassword);
        tv_myReviews = view.findViewById(R.id.tv_myReviews);
        tv_myAddressbook = view.findViewById(R.id.tv_myAddressbook);
        tv_mySupport = view.findViewById(R.id.tv_mySupport);
        tv_referralDashboard = view.findViewById(R.id.tv_referralDashboard);
        arrowIvv = view.findViewById(R.id.arrowIvv);
        tv_Financial= view.findViewById(R.id.tv_Financial);
        MymembershipTv= view.findViewById(R.id.MymembershipTv);

        tv_Membership= view.findViewById(R.id.tv_Membership);
        membershipPresenter.MyMembership(getContext());

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

        setOnclickistener();

    }
    private void setOnclickistener() {



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

    }
    @Override
    public void onMembershipError(String message) {

        Sneaker.with(getActivity())
                .setTitle(message)
                .setMessage("")
                .sneakError();
    }

    @Override
    public void GetMembershipSuccess(MembershipContentRepo response, String message) {
        if (message.equalsIgnoreCase("ok")) {

            MembershipContentAdapter membershipContentAdapter = new MembershipContentAdapter(response, getContext());
            recyclerViewJoin.setAdapter(membershipContentAdapter);

        }
       /* Sneaker.with(getActivity())
                .setTitle(message)
                .setMessage("")
                .sneakError();*/
    }

    @Override
    public void GetMembershipPlanSuccess(MembershipPlansRepo response, String message) {
        if (message.equalsIgnoreCase("ok"))
        {


            MembershipPlansAdapter membershipContentAdapter = new MembershipPlansAdapter(response, getContext(),this);
            recyclerViewPlan.setAdapter(membershipContentAdapter);

        }
     /*   Sneaker.with(getActivity())
                .setTitle(String.valueOf(response.getData().size()))
                .setMessage("")
                .sneakError();*/
    }

    @Override
    public void BuyMembershipPlanSuccess(BuyMembershipRepo response, String message) {

        if (message.equalsIgnoreCase("ok"))
        {

            Sneaker.with(getActivity())
                    .setTitle(response.getMessage())
                    .setMessage("")
                    .sneakSuccess();

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            Fragment homeFragment = new HomeFragment();
            fragmentTransaction.replace(R.id.fragment_Container, homeFragment);
            fragmentTransaction.addToBackStack(null);

            fragmentTransaction.commit();


        }
      /*  Sneaker.with(getActivity())
                .setTitle(message)
                .setMessage("")
                .sneakError();*/
    }

    @Override
    public void GetMembershipSuccess(MyMembershipRepo response, String message) {
       // Toast.makeText(getContext(), response.getData().getMyMembership()+"", Toast.LENGTH_SHORT).show();
        if (message.equalsIgnoreCase("ok")) {

            if (response.getData().getMyMembership()!=null)
            {

                JoinmemberShipLL.setVisibility(View.GONE);
                alredyMembershipLL.setVisibility(View.VISIBLE);
                purchecdateTV.setText(response.getData().getMyMembership().getStartDate());
                AmountTv.setText("\u20B9 " + response.getData().getMyMembership().getAmount());
                validTv.setText(response.getData().getValidity());
                expirydateTv.setText(response.getData().getMyMembership().getEndDate());
                if (!response.getData().getMyMembership().getActiveTypeStatus().equalsIgnoreCase("Active"))
                {
                    tv_cancelOrder.setText("Unactive");
                }

            }else {

            }
        }
    }

    @Override
    public void onMembershipFailure(Throwable t) {
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
    public void CheckedClick(MembershipPlansRepo repo, int position) {
        membershipPresenter.BuyMembershipPlan(getContext(),repo.getData().get(position).getId());
    /*    Sneaker.with(getActivity())
                .setTitle(repo.getData().get(position).getId())
                .setMessage("")
                .sneakError();*/
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

                Fragment Membership = new MembershipFragment();
                fragmentTransaction.replace(R.id.fragment_Container, Membership);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
                break;
            case R.id.MymembershipTv:
                // onBackPressed();

                Fragment MyMembership = new MyMemberShipFragment();
                fragmentTransaction.replace(R.id.fragment_Container, MyMembership);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
                break;
        }


    }
}