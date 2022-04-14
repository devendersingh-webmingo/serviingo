package com.serviingo.serviingo.Fragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.Activity.RazorPay.RazorPaymentActivity;
import com.serviingo.serviingo.Adapterr.MembershipContentAdapter;
import com.serviingo.serviingo.Adapterr.MembershipHistoryAdapter;
import com.serviingo.serviingo.Adapterr.MembershipPlansAdapter;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.ViewPresenter.MembershipHistoryPresenter;
import com.serviingo.serviingo.ViewPresenter.MembershipPresenter;
import com.serviingo.serviingo.ViewPresenter.MyMembershipPresenter;
import com.serviingo.serviingo.ViewPresenter.TempCart.AddMoneyGetKeyPresenter;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.BuyMembershipRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.MembershipContentRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.MembershipHistoryRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.MembershipPlansRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.MyMembershipRepo;
import com.serviingo.serviingo.modelrepo.Responsee.MyRatingAndReviewRespooo;
import com.serviingo.serviingo.modelrepo.Responsee.Razorpay.RazorpayRepo;
import com.serviingo.serviingo.modelrepo.request.EditReviewRequest;
import com.serviingo.serviingo.modelrepo.request.ReviewRequest;
import com.serviingo.serviingo.storage.SharedPrefManager;
import com.serviingo.serviingo.utils.AppUtils;

import okhttp3.ResponseBody;

import static com.serviingo.serviingo.R.drawable.globalloader;

public class MyMemberShipFragment extends Fragment implements View.OnClickListener, MyMembershipPresenter.MyMembershipView, MembershipPresenter.MembershipView, MembershipPlansAdapter.MembershipPlansclick, AddMoneyGetKeyPresenter.AddMoneyGetKeyView {
    TextView AmountTv, purchecdateTV, membershipTv, validTv, daysTV, expirydateTv, joinnowTv, price, Benifittv, tv_cancelOrder;


    TextView tv_dashboardd, tv_Membership, tv_Financial, MymembershipTv,
            tv_myBooking, tv_myProfile, tv_myWallet, tv_changePassword, tv_myReviews, tv_myAddressbook, tv_mySupport, tv_referralDashboard;
    ImageView arrowIvv;
    public static ScrollView scrollView;
    MyMembershipPresenter myMembershipPresenter;

    RecyclerView recyclerViewJoin, recyclerViewPlan;


    TextView tv_new, tv_ongoing, tv_completed;
    CardView Currentmembership;
    //  NestedScrollView ;
    LinearLayout historyNSV, JoinmemberShipLL;
    RecyclerView recyclerViewhistory;

    LinearLayoutManager linearLayoutManager, linearLayoutManagerr, linearLayoutManager2;
    MembershipPresenter membershipPresenter;
    AddMoneyGetKeyPresenter presenter;
    String Amount, membership_id;


    public MyMemberShipFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_member_ship, container, false);
        setui(view);
        return view;
    }

    private void setui(View view) {

        recyclerViewhistory = view.findViewById(R.id.recyclerViewhistory);
        linearLayoutManager = (new LinearLayoutManager(getContext().getApplicationContext(), LinearLayoutManager.VERTICAL, true));

        recyclerViewhistory.setLayoutManager(linearLayoutManager);
        recyclerViewhistory.setHasFixedSize(true);

        myMembershipPresenter = new MyMembershipPresenter(this);
        myMembershipPresenter.MyMembership(getContext());

        membershipPresenter = new MembershipPresenter(this);
        presenter = new AddMoneyGetKeyPresenter(this);
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

        historyNSV = view.findViewById(R.id.historyNSV);
        historyNSV.setVisibility(View.GONE);
        Currentmembership = view.findViewById(R.id.Currentmembership);
        Currentmembership.setVisibility(View.GONE);
        tv_new = view.findViewById(R.id.tv_new);
        tv_ongoing = view.findViewById(R.id.tv_ongoing);
        tv_completed = view.findViewById(R.id.tv_completed);

        JoinmemberShipLL = view.findViewById(R.id.JoinmemberShipLL);
        recyclerViewJoin = view.findViewById(R.id.recyclerViewJoin);
        recyclerViewPlan = view.findViewById(R.id.recyclerViewPlan);
        linearLayoutManagerr = (new LinearLayoutManager(getContext().getApplicationContext(), LinearLayoutManager.VERTICAL, true));

        recyclerViewJoin.setLayoutManager(linearLayoutManagerr);
        recyclerViewJoin.setHasFixedSize(true);
        linearLayoutManager2 = (new LinearLayoutManager(getContext().getApplicationContext(), LinearLayoutManager.VERTICAL, true));

        JoinmemberShipLL.setVisibility(View.GONE);

        recyclerViewPlan.setLayoutManager(linearLayoutManager2);
        recyclerViewPlan.setHasFixedSize(true);


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
        tv_Financial = view.findViewById(R.id.tv_Financial);
        MymembershipTv = view.findViewById(R.id.MymembershipTv);
        tv_Membership = view.findViewById(R.id.tv_Membership);
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

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        switch (v.getId()) {

            case R.id.tv_new:
                // Toast.makeText(getContext(), tv_new.getText().toString() + "", Toast.LENGTH_SHORT).show();
                // tv_new.setTextColor(Color.head_lightBlue);
                /*tv_new.setTextColor(Color.parseColor("#0069b2"));
                tv_new.setTextColor(Color.parseColor("#0069b2"));
*/
                tv_new.setTextColor(getActivity().getResources().getColor(R.color.white));
                tv_new.setBackground(getActivity().getResources().getDrawable(R.drawable.back_select));


                tv_ongoing.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                tv_ongoing.setTextColor(getActivity().getResources().getColor(R.color.black_text));

                tv_completed.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                tv_completed.setTextColor(getActivity().getResources().getColor(R.color.black_text));

                historyNSV.setVisibility(View.GONE);
                Currentmembership.setVisibility(View.VISIBLE);
                JoinmemberShipLL.setVisibility(View.GONE);
                break;
            case R.id.tv_ongoing:
                //   Toast.makeText(getContext(), tv_ongoing.getText().toString() + "", Toast.LENGTH_SHORT).show();
                //   tv_ongoing.setTextColor(Color.parseColor("#0069b2"));

                tv_ongoing.setTextColor(getActivity().getResources().getColor(R.color.white));
                tv_ongoing.setBackground(getActivity().getResources().getDrawable(R.drawable.back_select));


                tv_new.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                tv_new.setTextColor(getActivity().getResources().getColor(R.color.black_text));

                tv_completed.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                tv_completed.setTextColor(getActivity().getResources().getColor(R.color.black_text));

                historyNSV.setVisibility(View.VISIBLE);
                Currentmembership.setVisibility(View.GONE);
                JoinmemberShipLL.setVisibility(View.GONE);

                myMembershipPresenter.MembershipHistory(getContext());
                break;
            case R.id.tv_completed:
                //  Toast.makeText(getContext(), tv_completed.getText().toString() + "", Toast.LENGTH_SHORT).show();
                //  tv_completed.setTextColor(Color.parseColor("#0069b2"));
                tv_completed.setTextColor(getActivity().getResources().getColor(R.color.white));
                tv_completed.setBackground(getActivity().getResources().getDrawable(R.drawable.back_select));

                tv_new.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                tv_new.setTextColor(getActivity().getResources().getColor(R.color.black_text));

                tv_ongoing.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                tv_ongoing.setTextColor(getActivity().getResources().getColor(R.color.black_text));

                historyNSV.setVisibility(View.GONE);
                Currentmembership.setVisibility(View.GONE);
                JoinmemberShipLL.setVisibility(View.VISIBLE);


                break;

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

        tv_new.setOnClickListener(this);
        tv_ongoing.setOnClickListener(this);
        tv_completed.setOnClickListener(this);

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

    }

    @Override
    public void GetMembershipPlanSuccess(MembershipPlansRepo response, String message) {
        if (message.equalsIgnoreCase("ok")) {


            MembershipPlansAdapter membershipContentAdapter = new MembershipPlansAdapter(response, getContext(), this);
            recyclerViewPlan.setAdapter(membershipContentAdapter);

        }
     /*   Sneaker.with(getActivity())
                .setTitle(String.valueOf(response.getData().size()))
                .setMessage("")
                .sneakError();*/
    }

    @Override
    public void BuyMembershipPlanSuccess(BuyMembershipRepo response, String message) {

        if (message.equalsIgnoreCase("ok")) {

            Sneaker.with(getActivity())
                    .setTitle(response.getMessage())
                    .setMessage("")
                    .sneakSuccess();


            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Fragment homeFragment = new MyMemberShipFragment();
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
        if (message.equalsIgnoreCase("ok")) {

            if (response.getData().getMyMembership() != null) {
                if (response.getData().getMyMembership().getActiveTypeStatus().equalsIgnoreCase("Active")) {
                    Currentmembership.setVisibility(View.VISIBLE);
                    historyNSV.setVisibility(View.VISIBLE);
                    tv_completed.setVisibility(View.GONE);

                    purchecdateTV.setText(response.getData().getMembershipStartDate());
                    AmountTv.setText("\u20B9" + response.getData().getMyMembership().getAmount());
                    expirydateTv.setText(response.getData().getMembershipEndDate());
                    membershipTv.setText(response.getData().getMyMembership().getGetMembership().getName());
                    if (response.getData().getMyMembership().getExtend_end()!=null){
                        Benifittv.setVisibility(View.VISIBLE);

                    }

                    validTv.setText(response.getData().getMyMembership().getGetMembership().getValidity()+" Months");

                  //  validTv .setText(String.valueOf(response.getData().getValidity()) + "Days");

                } else {
                    tv_new.setVisibility(View.GONE);
                    tv_ongoing.setVisibility(View.GONE);

                    Currentmembership.setVisibility(View.GONE);
                    historyNSV.setVisibility(View.GONE);
                    JoinmemberShipLL.setVisibility(View.VISIBLE);
                    tv_completed.setTextColor(getActivity().getResources().getColor(R.color.white));
                    tv_completed.setBackground(getActivity().getResources().getDrawable(R.drawable.back_select));


                }
            } else {
                tv_completed.setTextColor(getActivity().getResources().getColor(R.color.white));
                tv_completed.setBackground(getActivity().getResources().getDrawable(R.drawable.back_select));

                tv_new.setVisibility(View.GONE);
                tv_ongoing.setVisibility(View.GONE);

                Currentmembership.setVisibility(View.GONE);
                historyNSV.setVisibility(View.GONE);
                JoinmemberShipLL.setVisibility(View.VISIBLE);


            }


        }
       /* Sneaker.with(getActivity())
                .setTitle(message)
                .setMessage("")
                .sneakError();*/
    }

    @Override
    public void GetMembershipHistorySuccess(MembershipHistoryRepo response, String message) {

        if (message.equalsIgnoreCase("ok")) {
            MembershipHistoryAdapter adapter = new MembershipHistoryAdapter(response, getContext());
            recyclerViewhistory.setAdapter(adapter);

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
    public void AddMoneyGetKeyError(String message) {

        Sneaker.with(getActivity())
                .setTitle(message)
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
    public void GetRazorPayKeySuccess(RazorpayRepo response, String message) {
        if (message.equalsIgnoreCase("ok")) {
            //startPayment(response.getData().getPaymentMethod().getApiKey(), total_amount);
            Intent intent = new Intent(getContext(), RazorPaymentActivity.class);// New activity
            intent.putExtra("ApiKey", response.getData().getPaymentMethod().getApiKey());
            intent.putExtra("order_id", "1");
            intent.putExtra("membership_id", membership_id);
            intent.putExtra("OrderNumber", "1");

            intent.putExtra("payment_mode", "BuyMembership");
            intent.putExtra("total_amount", Amount);

            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            // bottomSheet.dismiss();


        }

    }

    @Override
    public void AddMoneyGetKeyFailure(Throwable t) {
        Sneaker.with(getActivity())
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();
    }

    @Override
    public void CheckedClick(MembershipPlansRepo repo, int position) {

        Amount = repo.getData().get(position).getFinalCost();
        membership_id = repo.getData().get(position).getId();
        showDialog(repo.getData().get(position).getId());

    }

    public void showDialog(String id) {

        TextView tvDelete, tvCancel, descTv;
        AlertDialog alertDialog;

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.rating_delete_alertbox, null);
        alertDialog = new AlertDialog.Builder(getContext())
                .setView(view)
                .setCancelable(false)
                .create();


        ImageView close = view.findViewById(R.id.close);
        tvDelete = view.findViewById(R.id.tvDelete);
        tvCancel = view.findViewById(R.id.tvCancel);
        descTv = view.findViewById(R.id.descTv);
        descTv.setText("Add This Membership Plan");
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

                PaymentModeConfirmDialog(id);


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


    public void PaymentModeConfirmDialog(String id) {

        AlertDialog alertDialog;
        RadioButton rb_Wallet, rb_OnlinePayment;
        TextView btn;
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.addwalletamount_dialog, null);
        alertDialog = new AlertDialog.Builder(getContext())
                .setView(view)
                .setCancelable(false)
                .create();
        ImageView close = view.findViewById(R.id.close);
        rb_Wallet = view.findViewById(R.id.rb_Wallet);
        rb_OnlinePayment = view.findViewById(R.id.rb_OnlinePayment);
        btn = view.findViewById(R.id.btn);


        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rb_Wallet.isChecked()) {
                    membershipPresenter.BuyMembershipPlan(getContext(), id);

                    alertDialog.dismiss();

                } else if (rb_OnlinePayment.isChecked()) {
                    presenter.GetRazorPayKey(getContext());
                    alertDialog.dismiss();


                }

            }
        });
        alertDialog.show();
    }


}