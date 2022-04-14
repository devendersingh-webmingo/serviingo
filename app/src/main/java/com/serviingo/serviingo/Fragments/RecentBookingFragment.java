package com.serviingo.serviingo.Fragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.Adapterr.AdonseorderDetailsAdapter;
import com.serviingo.serviingo.Adapterr.CancelorderQuestionAdapter;
import com.serviingo.serviingo.Adapterr.Included_servicesDetaisAdapter;
import com.serviingo.serviingo.Adapterr.ManageOrderListingAdapter;
import com.serviingo.serviingo.Adapterr.TimeSlotAdapter.DatelistslotAdapterr;
import com.serviingo.serviingo.Adapterr.TimeSlotAdapter.timelistslotAdapterr;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.ViewPresenter.CancelOrderQuestionsPresenter;
import com.serviingo.serviingo.ViewPresenter.ManageOrderListingPresenter;
import com.serviingo.serviingo.ViewPresenter.TimeSlotPresenter;
import com.serviingo.serviingo.model.CancelOrderQuestionmodel;
import com.serviingo.serviingo.modelrepo.Responsee.CancelOrderQuestionsRepo;
import com.serviingo.serviingo.modelrepo.Responsee.DateSlotRepo;
import com.serviingo.serviingo.modelrepo.Responsee.GetOrderDetailRepo;
import com.serviingo.serviingo.modelrepo.Responsee.ManageOrderListingRepo;
import com.serviingo.serviingo.modelrepo.Responsee.ServetimeSlotRepo;
import com.serviingo.serviingo.modelrepo.request.CreateOrderRequest;
import com.serviingo.serviingo.modelrepo.request.Reschedule_request;
import com.serviingo.serviingo.storage.SharedPrefManager;
import com.serviingo.serviingo.utils.AppUtils;

import org.w3c.dom.Text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.ResponseBody;

import static com.serviingo.serviingo.R.drawable.globalloader;

public class RecentBookingFragment extends Fragment implements View.OnClickListener, ManageOrderListingPresenter.ManageOrderListingView, ManageOrderListingAdapter.orderClick {

    TextView tv_new, tv_ongoing, tv_completed, tv_cancelled, tvCall, UNDERCANCELLATION;

    TextView tv_dashboardd, tv_Membership, tv_Financial, MymembershipTv,
            tv_myBooking, tv_myProfile, tv_myWallet, tv_changePassword, tv_myReviews, tv_myAddressbook, tv_mySupport, tv_referralDashboard, IncompleteBooking_Tv;
    RecyclerView recyclerbooking;
    ManageOrderListingPresenter manageOrderListingPresenter;
    DeleteOrderDialog deleteOrderDialog;
    RefundProcessDetailsDialog refundProcessDetailsDialog;

    OrderComments orderComments;
    OrderDetailsDialog orderDetailsDialog;
    ImageView arrowIvv;
    public static ScrollView scrollView;
    CancelOrderViewDialog cancelOrderViewDialog;
    SwipeRefreshLayout refreshLayout;
    String Subcategory, serve_date, serve_time;
    Boolean servedateui = false;

    ArrayList<String> arrayList = new ArrayList<>();

    String servedate, servetime;
    ViewDialog alert;
    TextView dateSlot, timeslott, RescheduleTV;
    String time, date;
    int query_type;

    String ordernumber;


    public RecentBookingFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_recent_booking, container, false);
        refreshLayout = view.findViewById(R.id.refreshLayout);

        setui(view);
        refreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {

                        // Your code goes here
                        // In this code, we are just
                        // changing the text in the textbox

                        //   setui(view);

                        tv_new.setTextColor(getActivity().getResources().getColor(R.color.white));
                        tv_new.setBackground(getActivity().getResources().getDrawable(R.drawable.recentbookingui));


                        UNDERCANCELLATION.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                        UNDERCANCELLATION.setTextColor(getActivity().getResources().getColor(R.color.black_text));


                        tv_ongoing.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                        tv_ongoing.setTextColor(getActivity().getResources().getColor(R.color.black_text));

                        tv_completed.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                        tv_completed.setTextColor(getActivity().getResources().getColor(R.color.black_text));
                        tv_cancelled.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                        tv_cancelled.setTextColor(getActivity().getResources().getColor(R.color.black_text));

                        manageOrderListingPresenter.ManageOrderListing(getContext(), "Pending");


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
        alert = new ViewDialog();
        cancelOrderViewDialog = new CancelOrderViewDialog();
        tv_new = view.findViewById(R.id.tv_new);
        tvCall = view.findViewById(R.id.tvCall);
        tv_ongoing = view.findViewById(R.id.tv_ongoing);
        tv_completed = view.findViewById(R.id.tv_completed);
        tv_cancelled = view.findViewById(R.id.tv_cancelled);
        UNDERCANCELLATION = view.findViewById(R.id.UNDERCANCELLATION);

        tv_dashboardd = view.findViewById(R.id.tv_dashboardd);
        tv_myBooking = view.findViewById(R.id.tv_myBooking);
        tv_myProfile = view.findViewById(R.id.tv_myProfile);
        tv_Financial = view.findViewById(R.id.tv_Financial);
        MymembershipTv = view.findViewById(R.id.MymembershipTv);
        tv_Membership = view.findViewById(R.id.tv_Membership);
        tv_myWallet = view.findViewById(R.id.tv_myWallet);

        tv_changePassword = view.findViewById(R.id.tv_changePassword);
        tv_myReviews = view.findViewById(R.id.tv_myReviews);
        tv_myAddressbook = view.findViewById(R.id.tv_myAddressbook);
        tv_mySupport = view.findViewById(R.id.tv_mySupport);
        tv_referralDashboard = view.findViewById(R.id.tv_referralDashboard);
        IncompleteBooking_Tv = view.findViewById(R.id.IncompleteBooking_Tv);

        recyclerbooking = view.findViewById(R.id.recyclerbooking);
        scrollView = view.findViewById(R.id.scroll_side_menu);
        scrollView.setVisibility(View.GONE);
        arrowIvv = view.findViewById(R.id.arrowIvv);
        tv_new.setOnClickListener(this);
        tv_ongoing.setOnClickListener(this);
        tv_completed.setOnClickListener(this);
        tv_cancelled.setOnClickListener(this);
        deleteOrderDialog = new DeleteOrderDialog();
        orderComments = new OrderComments();
        orderDetailsDialog = new OrderDetailsDialog();
        manageOrderListingPresenter = new ManageOrderListingPresenter(this);
        manageOrderListingPresenter.ManageOrderListing(getContext(), "Pending");
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
        UNDERCANCELLATION.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch (v.getId()) {
            case R.id.tv_new:
                //     Toast.makeText(getContext(), tv_new.getText().toString() + "", Toast.LENGTH_SHORT).show();
                // tv_new.setTextColor(Color.head_lightBlue);
                /*tv_new.setTextColor(Color.parseColor("#0069b2"));
                tv_new.setTextColor(Color.parseColor("#0069b2"));
*/
                tv_new.setTextColor(getActivity().getResources().getColor(R.color.white));
                tv_new.setBackground(getActivity().getResources().getDrawable(R.drawable.recentbookingui));


                UNDERCANCELLATION.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                UNDERCANCELLATION.setTextColor(getActivity().getResources().getColor(R.color.black_text));


                tv_ongoing.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                tv_ongoing.setTextColor(getActivity().getResources().getColor(R.color.black_text));

                tv_completed.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                tv_completed.setTextColor(getActivity().getResources().getColor(R.color.black_text));
                tv_cancelled.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                tv_cancelled.setTextColor(getActivity().getResources().getColor(R.color.black_text));
                AppTools.hideDialog();

                manageOrderListingPresenter.ManageOrderListing(getContext(), "Pending");


                break;
            case R.id.tv_ongoing:
                //  Toast.makeText(getContext(), tv_ongoing.getText().toString() + "", Toast.LENGTH_SHORT).show();
                //   tv_ongoing.setTextColor(Color.parseColor("#0069b2"));

                tv_ongoing.setTextColor(getActivity().getResources().getColor(R.color.white));
                tv_ongoing.setBackground(getActivity().getResources().getDrawable(R.drawable.recentbookingui));


                tv_new.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                tv_new.setTextColor(getActivity().getResources().getColor(R.color.black_text));

                UNDERCANCELLATION.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                UNDERCANCELLATION.setTextColor(getActivity().getResources().getColor(R.color.black_text));


                tv_completed.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                tv_completed.setTextColor(getActivity().getResources().getColor(R.color.black_text));
                tv_cancelled.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                tv_cancelled.setTextColor(getActivity().getResources().getColor(R.color.black_text));
                AppTools.hideDialog();

                manageOrderListingPresenter.ManageOrderListing(getContext(), "Ongoing");

                break;
            case R.id.tv_completed:
                //Toast.makeText(getContext(), tv_completed.getText().toString() + "", Toast.LENGTH_SHORT).show();
                //  tv_completed.setTextColor(Color.parseColor("#0069b2"));
                tv_completed.setTextColor(getActivity().getResources().getColor(R.color.white));
                tv_completed.setBackground(getActivity().getResources().getDrawable(R.drawable.recentbookingui));

                tv_new.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                tv_new.setTextColor(getActivity().getResources().getColor(R.color.black_text));

                tv_ongoing.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                tv_ongoing.setTextColor(getActivity().getResources().getColor(R.color.black_text));
                tv_cancelled.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                tv_cancelled.setTextColor(getActivity().getResources().getColor(R.color.black_text));
                AppTools.hideDialog();

                UNDERCANCELLATION.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                UNDERCANCELLATION.setTextColor(getActivity().getResources().getColor(R.color.black_text));
                manageOrderListingPresenter.ManageOrderListing(getContext(), "Completed");

                break;


            case R.id.UNDERCANCELLATION:
                //Toast.makeText(getContext(), tv_completed.getText().toString() + "", Toast.LENGTH_SHORT).show();
                //  tv_completed.setTextColor(Color.parseColor("#0069b2"));


                UNDERCANCELLATION.setTextColor(getActivity().getResources().getColor(R.color.white));
                UNDERCANCELLATION.setBackground(getActivity().getResources().getDrawable(R.drawable.recentbookingui));

                tv_completed.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                tv_completed.setTextColor(getActivity().getResources().getColor(R.color.black_text));

                tv_new.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                tv_new.setTextColor(getActivity().getResources().getColor(R.color.black_text));

                tv_ongoing.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                tv_ongoing.setTextColor(getActivity().getResources().getColor(R.color.black_text));
                tv_cancelled.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                tv_cancelled.setTextColor(getActivity().getResources().getColor(R.color.black_text));
                AppTools.hideDialog();

                manageOrderListingPresenter.ManageOrderListing(getContext(), "Under-Cancellation");

                break;


            case R.id.tv_cancelled:
                //Toast.makeText(getContext(), tv_cancelled.getText().toString() + "", Toast.LENGTH_SHORT).show();
                //  tv_cancelled.setTextColor(Color.parseColor("#0069b2"));
                tv_cancelled.setTextColor(getActivity().getResources().getColor(R.color.white));
                tv_cancelled.setBackground(getActivity().getResources().getDrawable(R.drawable.recentbookingui));

                UNDERCANCELLATION.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                UNDERCANCELLATION.setTextColor(getActivity().getResources().getColor(R.color.black_text));


                tv_new.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                tv_new.setTextColor(getActivity().getResources().getColor(R.color.black_text));

                tv_ongoing.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                tv_ongoing.setTextColor(getActivity().getResources().getColor(R.color.black_text));
                tv_completed.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                tv_completed.setTextColor(getActivity().getResources().getColor(R.color.black_text));
                AppTools.hideDialog();

                manageOrderListingPresenter.ManageOrderListing(getContext(), "Cancelled");

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
    public void onManageOrderListingError(String message) {
        Sneaker.with(getActivity())
                .setTitle(message)
                .setMessage("")
                .sneakError();
    }

    @Override
    public void onManageOrderListingSuccess(ManageOrderListingRepo response, String message) {
        if (message.equalsIgnoreCase("ok")) {


            if (response.getData().getData().size() > 0) {
                recyclerbooking.setVisibility(View.VISIBLE);
                tvCall.setVisibility(View.GONE);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1, LinearLayoutManager.VERTICAL, false);
                recyclerbooking.setLayoutManager(gridLayoutManager);
                recyclerbooking.setHasFixedSize(true);
                ManageOrderListingAdapter ListingAdapter = new ManageOrderListingAdapter(response, getContext(), this);
                recyclerbooking.setAdapter(ListingAdapter);

            } else {
                recyclerbooking.setVisibility(View.GONE);
                tvCall.setVisibility(View.VISIBLE);
            }


        }

    }

    @Override
    public void onCancelOrderSuccess(ResponseBody response, String message) {
    /*    Sneaker.with(getActivity())
                .setTitle(message)
                .setMessage("")
                .sneakError();*/
        // AppTools.hideGifDialog();

        cancelOrderViewDialog.showDialog(getActivity(), " ");
        AppTools.hideDialog();


        manageOrderListingPresenter.ManageOrderListing(getContext(), "Pending");
        tv_new.setTextColor(getActivity().getResources().getColor(R.color.white));
        tv_new.setBackground(getActivity().getResources().getDrawable(R.drawable.recentbookingui));


        tv_ongoing.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
        tv_ongoing.setTextColor(getActivity().getResources().getColor(R.color.black_text));

        tv_completed.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
        tv_completed.setTextColor(getActivity().getResources().getColor(R.color.black_text));
        tv_cancelled.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
        tv_cancelled.setTextColor(getActivity().getResources().getColor(R.color.black_text));


    }

    @Override
    public void onGetOrderDetailSuccess(GetOrderDetailRepo response, String message) {
        if (message.equalsIgnoreCase("ok")) {

            orderDetailsDialog.showDialog(getActivity(), response);


        }

    }

    @Override
    public void onManageOrderListingFailure(Throwable t) {
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
    public void OrderDetailsClick(String id) {

        //  Toast.makeText(getContext(), "OrderDetailsClick \n" + id, Toast.LENGTH_SHORT).show();
        manageOrderListingPresenter.GetOrderDetail(getContext(), id);

    }

    @Override
    public void PayNowClick(ManageOrderListingRepo modelArrayList, int position) {

        //  Toast.makeText(getContext(), "Pay Now", Toast.LENGTH_SHORT).show();
        Subcategory = String.valueOf(modelArrayList.getData().getData().get(position).get_package().getSubCategoryId());
        SharedPrefManager.getInstans(getContext().getApplicationContext()).MembsershipClear();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment retryPaymentFragment = new RetryPaymentFragment();
        Bundle args = new Bundle();
        args.putString("id", String.valueOf(modelArrayList.getData().getData().get(position).getId()));
        args.putString("PaymentOption", "PayNow");

        retryPaymentFragment.setArguments(args);
        fragmentTransaction.replace(R.id.fragment_Container, retryPaymentFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


    }

    @Override
    public void RePaymentTV(ManageOrderListingRepo modelArrayList, int position) {

        Subcategory = String.valueOf(modelArrayList.getData().getData().get(position).get_package().getSubCategoryId());

        SharedPrefManager.getInstans(getContext().getApplicationContext()).MembsershipClear();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment retryPaymentFragment = new RetryPaymentFragment();
        Bundle args = new Bundle();
        args.putString("id", String.valueOf(modelArrayList.getData().getData().get(position).getId()));
        args.putString("PaymentOption", "RePayment");

        retryPaymentFragment.setArguments(args);
        fragmentTransaction.replace(R.id.fragment_Container, retryPaymentFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


        //  alert.showDialog(Subcategory);


    }

    @Override
    public void CancelDetailsClick(String id,ManageOrderListingRepo manageOrderListingRepo, int Position) {
        // Toast.makeText(getContext(), "CancelDetailsClick \n" + id, Toast.LENGTH_SHORT).show();

        deleteOrderDialog.showDialog(getActivity(), id);

         ordernumber=manageOrderListingRepo.getData().getData().get(Position).getOrderNumber();

    }

    @Override
    public void RefundProcessDetails(ManageOrderListingRepo manageOrderListingRepo, int pos) {

        refundProcessDetailsDialog = new RefundProcessDetailsDialog();


        refundProcessDetailsDialog.showDialog(getActivity(), manageOrderListingRepo, pos);
    }


    public class DeleteOrderDialog {

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
            descTv.setText("Cancel /Reschedule this Order");
            close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss();
                }
            });
            tvDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getdata(id);
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

        public void getdata(String id) {


            //  alertDialog.dismiss();
            //  AppTools.showGifDialog(getActivity(), globalloader);
            // Toast.makeText(getContext(), id + "", Toast.LENGTH_SHORT).show();
            alertDialog.dismiss();

            orderComments.showDialog(getActivity(), id);
            // updateReviewPresenter.DeleteReview(getContext(), id);

        }
    }

    public class RefundProcessDetailsDialog {

        TextView remarkTv, tvWithdrawlMoney, withdrawalTv, tv_cancelOrder, utrText;
        AlertDialog alertDialog;

        public void showDialog(Activity activity, ManageOrderListingRepo manageOrderListingRepo, int Position) {

            LayoutInflater inflater = LayoutInflater.from(activity);
            View view = inflater.inflate(R.layout.refundprocessdetails, null);
            alertDialog = new AlertDialog.Builder(activity)
                    .setView(view)
                    .setCancelable(false)
                    .create();

            ImageView close = view.findViewById(R.id.close);
            remarkTv = view.findViewById(R.id.remarkTv);
            tvWithdrawlMoney = view.findViewById(R.id.tvWithdrawlMoney);
            withdrawalTv = view.findViewById(R.id.withdrawalTv);
            tv_cancelOrder = view.findViewById(R.id.tv_cancelOrder);
            utrText = view.findViewById(R.id.utrText);
            remarkTv.setText(manageOrderListingRepo.getData().getData().get(Position).getoRefundMethod());

            tvWithdrawlMoney.setText(manageOrderListingRepo.getData().getData().get(Position).getOnline_refund_date());

            withdrawalTv.setText(manageOrderListingRepo.getData().getData().get(Position).getoRefundNumber());
            if (!manageOrderListingRepo.getData().getData().get(Position).getoRefundMethod().equalsIgnoreCase("Net-Banking")) {

                utrText.setText("Reference Numbe");
            }


            close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss();
                }
            });
            tv_cancelOrder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //  getdata(id);
                    Toast.makeText(activity, "Pdf Downloading ", Toast.LENGTH_SHORT).show();


                    String urll = manageOrderListingRepo.getData().getData().get(Position).getoRefundReceipt();
                    Log.e("urlllllllll", urll);


                    Intent intentt = new Intent(Intent.ACTION_VIEW, Uri.parse(urll));
                    intentt.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intentt.setPackage("com.android.chrome");
                    try {
                        startActivity(intentt);
                    } catch (ActivityNotFoundException ex) {
                        // Chrome browser presumably not installed so allow user to choose instead
                        intentt.setPackage(null);
                        startActivity(intentt);
                    }

                }
            });


            alertDialog.show();
        }


    }

    public class OrderComments implements CancelOrderQuestionsPresenter

            .CancelOrderQuestionsView {

        TextView tvDelete, CancleTV, Reschedule;
        EditText descTv;

        AlertDialog alertDialog;
        Spinner spinner_reason;
        LinearLayout llrehedule;

        CancelOrderQuestionsPresenter presenter;


        public void showDialog(Activity activity, String id) {

            LayoutInflater inflater = LayoutInflater.from(activity);
            View view = inflater.inflate(R.layout.commentorder, null);
            alertDialog = new AlertDialog.Builder(activity)
                    .setView(view)
                    .setCancelable(false)
                    .create();

            llrehedule = view.findViewById(R.id.llrehedule);
            ImageView close = view.findViewById(R.id.close);
            tvDelete = view.findViewById(R.id.tvDelete);
            CancleTV = view.findViewById(R.id.CancleTV);
            Reschedule = view.findViewById(R.id.Reschedule);

            spinner_reason = view.findViewById(R.id.spinner_reason);
            descTv = view.findViewById(R.id.descTv);
            presenter = new CancelOrderQuestionsPresenter(this);
            presenter.CancelOrderQuestions(activity);
            close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss();
                }
            });
            tvDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (descTv.getText().toString().trim().isEmpty()) {
                        Toast.makeText(getContext(), "Enter Cancellation Region", Toast.LENGTH_SHORT).show();
                    } else {
                        alertDialog.dismiss();

                        manageOrderListingPresenter.CancelOrder(getContext(), id, descTv.getText().toString().trim(), query_type);


                    }


                }
            });

            CancleTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    llrehedule.setVisibility(View.GONE);
                    tvDelete.setVisibility(View.VISIBLE);
                    descTv.setVisibility(View.VISIBLE);


                }
            });


            Reschedule.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    manageOrderListingPresenter.GetOrderDetail(getContext(), id);
                    servedateui = true;
                    alertDialog.dismiss();


                }
            });


            alertDialog.show();
        }


        @Override
        public void onaboutPageeError(String message) {
            Toast.makeText(getContext(), message + "", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void AboutPageeSuccess(CancelOrderQuestionsRepo response, String message) {
            if (message.equalsIgnoreCase("ok")) {
                if (response.getData().getQuestions().size() > 0) {
                    List<CancelOrderQuestionmodel> list = new ArrayList<>();
                    list.add(new CancelOrderQuestionmodel("Select Query Type", 0000));
                    for (int i = 0; i < response.getData().getQuestions().size(); i++) {

                        CancelOrderQuestionmodel itemData = new CancelOrderQuestionmodel(response.getData().getQuestions().get(i).getQueries(),
                                response.getData().getQuestions().get(i).getId());

                        list.add(itemData);

                    }


                    CancelorderQuestionAdapter countrySpinnerAdapter = new CancelorderQuestionAdapter(getContext(), R.id.coinName, list);
                    spinner_reason.setAdapter(countrySpinnerAdapter);
                    spinner_reason.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            query_type = list.get(position).getId();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });

                }
            }

        }

        @Override
        public void ReScheduleSuccess(ResponseBody response, String message) {

        }


        @Override
        public void onaboutPageFailure(Throwable t) {
            Toast.makeText(getContext(), t.getLocalizedMessage() + "", Toast.LENGTH_SHORT).show();

        }
    }

    public class OrderDetailsDialog implements CancelOrderQuestionsPresenter

            .CancelOrderQuestionsView {
        Included_servicesDetaisAdapter included_servicesDetaisAdapter;

        AlertDialog alertDialog;

        RecyclerView recyclerViewPackage, recyclerView;
        TextView tvsubmoney, tvrs, tvrus, tvvaluue, tvHeading, tvSubHeading, MembershipDiscountAmountTV, ServiceDiscountprice, MembershipTv, safety_hygieneTV, SubTotalTv,
                ServiceDiscounttitle, tvDiscount, MembershipFeesTv,
                viewInvoiceTv,couponTv;
        RelativeLayout safety_hygiene_feeRl,couponrl;
        WebView simpleWebView;
        LinearLayout WebViewLayoutLL, billingTV, slottimeLL;
        ImageView openSlotBox;
        CancelOrderQuestionsPresenter presenter;
        FrameLayout fl;




        public void showDialog(Activity activity, GetOrderDetailRepo orderDetailRepo) {

            LayoutInflater inflater = LayoutInflater.from(activity);
            View view = inflater.inflate(R.layout.orderdetailsdialog, null);
            alertDialog = new AlertDialog.Builder(activity)
                    .setView(view)
                    .setCancelable(false)
                    .create();
            ImageView close = view.findViewById(R.id.close);
            ImageView closeWebViewLayout = view.findViewById(R.id.closeWebViewLayout);

            presenter = new CancelOrderQuestionsPresenter(this);
            simpleWebView = view.findViewById(R.id.simpleWebView);
            WebViewLayoutLL = view.findViewById(R.id.WebViewLayoutLL);
            billingTV = view.findViewById(R.id.billingTV);
            recyclerViewPackage = view.findViewById(R.id.recyclerViewPackage);
            tvsubmoney = view.findViewById(R.id.tvsubmoney);
            tvrs = view.findViewById(R.id.tvrs);
            fl= view.findViewById(R.id.fl);
            tvrus = view.findViewById(R.id.tvrus);
            ServiceDiscounttitle = view.findViewById(R.id.ServiceDiscounttitle);
            tvDiscount = view.findViewById(R.id.tvDiscount);
            safety_hygieneTV = view.findViewById(R.id.safety_hygieneTV);
            SubTotalTv = view.findViewById(R.id.SubTotalTv);
            safety_hygiene_feeRl = view.findViewById(R.id.safety_hygiene_feeRl);
            couponrl= view.findViewById(R.id.couponrl);
            RescheduleTV = view.findViewById(R.id.RescheduleTV);
            couponTv= view.findViewById(R.id.couponTv);
            tvHeading = view.findViewById(R.id.tvHeading);
            viewInvoiceTv = view.findViewById(R.id.viewInvoiceTv);
            MembershipFeesTv = view.findViewById(R.id.MembershipFeesTv);
            tvSubHeading = view.findViewById(R.id.tvSubHeading);
            tvvaluue = view.findViewById(R.id.tvvaluue);
            recyclerView = view.findViewById(R.id.recyclerView);
            ServiceDiscountprice = view.findViewById(R.id.ServiceDiscountprice);
            MembershipTv = view.findViewById(R.id.MembershipTv);
            MembershipDiscountAmountTV = view.findViewById(R.id.MembershipDiscountAmountTV);

            slottimeLL = view.findViewById(R.id.slottimeLL);
            openSlotBox = view.findViewById(R.id.openSlotBox);

            dateSlot = view.findViewById(R.id.dateSlot);
            timeslott = view.findViewById(R.id.timeslott);
            if (servedateui == true) {
                slottimeLL.setVisibility(View.VISIBLE);
                dateSlot.setText(orderDetailRepo.getData().getOrderInfo().getServing_datetime());
                openSlotBox.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        alert.showDialog(String.valueOf(orderDetailRepo.getData().getOrderInfo().getPackage().getSubCategoryId()));


                    }
                });


                RescheduleTV.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Reschedule_request reschedule_request=new Reschedule_request(String.valueOf(orderDetailRepo.getData().getOrderInfo().getId()),date,time,String.valueOf(query_type));
                        presenter.ReSchedule(getContext(),reschedule_request);
                        alertDialog.dismiss();
                        servedateui = false;



                    }
                });




            }


            included_servicesDetaisAdapter = new Included_servicesDetaisAdapter(orderDetailRepo, activity);


            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1, LinearLayoutManager.VERTICAL, false);
            recyclerViewPackage.setLayoutManager(gridLayoutManager);
            recyclerViewPackage.setHasFixedSize(true);

            GridLayoutManager gridLayoutManagerr = new GridLayoutManager(getContext(), 1, LinearLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(gridLayoutManagerr);
            recyclerView.setHasFixedSize(true);

            if (orderDetailRepo.getData().getIncludedServices().size() > 0) {
                recyclerViewPackage.setAdapter(included_servicesDetaisAdapter);
                tvHeading.setVisibility(View.VISIBLE);
            }
            if (orderDetailRepo.getData().getOrderInfo().getAddons().size() > 0) {
                AdonseorderDetailsAdapter adonseorderDetailsAdapter = new AdonseorderDetailsAdapter(orderDetailRepo, getContext());
                recyclerView.setAdapter(adonseorderDetailsAdapter);
                //tvSubHeading.setVisibility(View.VISIBLE);
            }


            if (orderDetailRepo.getData().getAddonAmount() != 0) {
                ServiceDiscountprice.setVisibility(View.VISIBLE);
                ServiceDiscounttitle.setVisibility(View.VISIBLE);
                ServiceDiscountprice.setText("₹" + orderDetailRepo.getData().getAddonAmount());


            }


            if (orderDetailRepo.getData().getMembershipFees() != 0) {
                MembershipFeesTv.setVisibility(View.VISIBLE);

                MembershipTv.setVisibility(View.VISIBLE);
                MembershipTv.setText(String.format("₹%d", orderDetailRepo.getData().getMembershipFees()));


            }

            if (orderDetailRepo.getData().getOrderInfo().getCoupon_discount_amount() !=null) {


                couponrl.setVisibility(View.VISIBLE);

                couponTv.setText("\u20B9" + orderDetailRepo.getData().getOrderInfo().getCoupon_discount_amount());
            }

            if (orderDetailRepo.getData().getHygieneFees() != 0) {
                safety_hygiene_feeRl.setVisibility(View.VISIBLE);
                safety_hygieneTV.setText(String.format("₹%d", orderDetailRepo.getData().getHygieneFees()));
            }
            SubTotalTv.setText(String.format("₹%d", orderDetailRepo.getData().getSubTotal()));


            tvsubmoney.setText(String.format("₹%d", orderDetailRepo.getData().getServiceAmount()));

            if (orderDetailRepo.getData().getMembershipDiscount() != 0) {

                tvDiscount.setVisibility(View.VISIBLE);
                tvrs.setVisibility(View.VISIBLE);
                tvrs.setText(String.format("₹%d", orderDetailRepo.getData().getMembershipDiscount()));

            }

            tvrus.setText("\u20B9" + orderDetailRepo.getData().getTotalDiscount());
            tvvaluue.setText(" \u20B9" + orderDetailRepo.getData().getOrderInfo().getTotalAmount());
            tvHeading.setText(orderDetailRepo.getData().getOrderInfo().getPackage().getName());
            MembershipDiscountAmountTV.setText(String.format("₹%d", orderDetailRepo.getData().getServiceDiscount()));
            simpleWebView.loadUrl(orderDetailRepo.getData().getInvoice_url());

/*

            if (orderDetailRepo.getData().getOrderInfo().getOrderStatus().equalsIgnoreCase("Ongoing") ||
                    orderDetailRepo.getData().getOrderInfo().getOrderStatus().equalsIgnoreCase("Processing")
                    || orderDetailRepo.getData().getOrderInfo().getOrderStatus().equalsIgnoreCase("Completed")) {
                if (orderDetailRepo.getData().getOrderInfo().getPaymentStatus().equalsIgnoreCase("Completed")||orderDetailRepo.getData().getOrderInfo().getPaymentStatus().equalsIgnoreCase("Collected")) {
                    viewInvoiceTv.setVisibility(View.VISIBLE);
                }
            }
*/
            if (orderDetailRepo.getData().getOrderInfo().getOrderStatus().equalsIgnoreCase("Completed")) {
                viewInvoiceTv.setVisibility(View.VISIBLE);


            }


            close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss();
                    servedateui = false;
                }
            });


            closeWebViewLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    WebViewLayoutLL.setVisibility(View.GONE);
                    billingTV.setVisibility(View.VISIBLE);


                }
            });

            viewInvoiceTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    WebViewLayoutLL.setVisibility(View.VISIBLE);
                    billingTV.setVisibility(View.GONE);

                }
            });

            alertDialog.show();
        }


        @Override
        public void onaboutPageeError(String message) {
            Toast.makeText(getContext(), message + "", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void AboutPageeSuccess(CancelOrderQuestionsRepo response, String message) {


        }

        @Override
        public void ReScheduleSuccess(ResponseBody response, String message) {
            if (message.equalsIgnoreCase("ok")) {
                manageOrderListingPresenter.ManageOrderListing(getContext(), "Pending");
            }

        }


        @Override
        public void onaboutPageFailure(Throwable t) {
            Toast.makeText(getContext(), t.getLocalizedMessage() + "", Toast.LENGTH_SHORT).show();

        }
    }


    public class CancelOrderViewDialog {

        private TextView success, tvsubmoney, tvordernumber;

        // Dialog dialog=new Dialog(this,android.R.style.Theme_Black_NoTitleBar_Fullscreen)


        public void showDialog(Activity activity, String Ordernumber) {


            Dialog dialog = new Dialog(getContext(), android.R.style.Theme_Black_NoTitleBar_Fullscreen);
            dialog.setContentView(R.layout.cancel);
            dialog.setCancelable(false);

            dialog.show();


            success = dialog.findViewById(R.id.success);
            tvsubmoney = dialog.findViewById(R.id.tvsubmoney);
            tvordernumber = dialog.findViewById(R.id.tvordernumber);
              tvordernumber.setText(" Order ID is  "+ ordernumber);


            success.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //  dialog.dismiss();


                    dialog.dismiss();
                }
            });

        }


    }

    public class ViewDialog implements TimeSlotPresenter.TimeSlotView, DatelistslotAdapterr.DateClick, timelistslotAdapterr.CustomizedClick {


        Dialog dialog;

        RecyclerView dateRV, timeRV;
        TimeSlotPresenter presenter;

        ArrayList<CreateOrderRequest.AddonService> addonServices;

        CardView btn_moreDetails;
        ImageView exit;
        String Showdate;
        String idd;


        public void showDialog(String id) {
            idd = id;

            dialog = new Dialog(getContext());
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.fragment_time_slot);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            WindowManager.LayoutParams wmlp = dialog.getWindow().getAttributes();
//            wmlp.x = 30;   //x position
            wmlp.y = 300;   //y position

            wmlp.gravity = Gravity.TOP;
            findViewById(dialog, id);

            dialog.show();
        }


        private void findViewById(Dialog view, String id) {
            //extras = getArguments();

          /*  if (extras != null) {

                Subcategory = getArguments().getString("Subcategory");

         *//*   package_id = getArguments().getString("id");
            payment_method = getArguments().getString("payment");
            total_amount = getArguments().getString("Total");

            addon_service_ids = getArguments().getString("addon_service_ids");
            SafetyAndHygieneFee = getArguments().getString("SafetyAndHygieneFee");
            pack_quantity = getArguments().getString("pack_quantity");
            Subtoal = getArguments().getString("Subtoal");
            discount_amount = getArguments().getString("discount_amount");
            addonServices = (ArrayList<CreateOrderRequest.AddonService>) getArguments().getSerializable("addonServices");
*//*
             *//*

            Log.e("addonServices", package_id + "\n" + payment_method + "\n"
                    + total_amount + "\n" + addon_service_ids + "\n"
                    + SafetyAndHygieneFee + "\n" + addonServices.size());

*//*

                // Toast.makeText(getContext(), Subcategory+"", Toast.LENGTH_SHORT).show();
            }*/


            dateRV = view.findViewById(R.id.dateRV);
            LinearLayoutManager linearLayoutManager2 = (new LinearLayoutManager(getContext().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
            dateRV.setLayoutManager(linearLayoutManager2);
            dateRV.setHasFixedSize(true);
            btn_moreDetails = view.findViewById(R.id.btn_moreDetails);
            exit = view.findViewById(R.id.exit);
            timeRV = view.findViewById(R.id.timeRV);
            LinearLayoutManager linearLayoutManager3 = (new LinearLayoutManager(getContext().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
            timeRV.setLayoutManager(linearLayoutManager3);
            timeRV.setHasFixedSize(true);
            presenter = new TimeSlotPresenter(this);

            presenter.DateSlotRepo(getContext(), id);
            // presenter.TimeSlotRepo(getContext(),"1","2021-08-24");


            exit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            btn_moreDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    serve_time = time;
                    serve_date = date;
                    servedate = "Date: " + Showdate;

                    dateSlot.setText(servedate);
                    String _24HourTime = serve_time;
                    SimpleDateFormat _24HourSDF = new SimpleDateFormat("HH:mm");
                    SimpleDateFormat _12HourSDF = new SimpleDateFormat("hh:mm a");
                    try {
                        Date _24HourDt = _24HourSDF.parse(_24HourTime);
                        servetime = "Timing: " + _12HourSDF.format(_24HourDt);
                        timeslott.setText("Timing: " + _12HourSDF.format(_24HourDt));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    Log.e("servedateand time", servedate + " " + servetime);
                    RescheduleTV.setVisibility(View.VISIBLE);


                    //   timeslott.setText("Timing: " + serve_time);

                  /*  FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    Fragment fragment = new AppliencesCareServicesFragment();
                    Bundle args = new Bundle();
                    args.putString("serve_time", serve_time);
                    args.putString("serve_date", serve_date);


                    // args.putParcelableArrayList("arraylist", addonServices);

                    fragment.setArguments(args);

                    fragmentTransaction.replace(R.id.fragment_Container, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();

*/
                }
            });


        }


        @Override
        public void onDateSlotRepoError(String message) {
            Sneaker.with(getActivity())
                    .setTitle(message)
                    .setMessage("")
                    .sneakError();
        }

        @Override
        public void onDateSlotRepoSuccess(DateSlotRepo response, String message) {

            if (message.equalsIgnoreCase("ok")) {
                if (response.getData().getSlotDates().size() > 0) {
                    DatelistslotAdapterr datelistslotAdapterr = new DatelistslotAdapterr(response, getContext(), this);
                    dateRV.setAdapter(datelistslotAdapterr);
                    presenter.TimeSlotRepo(getContext(), idd, response.getData().getTodayDate());
                    // serve_date = response.getData().getTodayDate();
                } else {

                    btn_moreDetails.setVisibility(View.GONE);
                    dialog.dismiss();

                    Sneaker.with(getActivity())
                            .setTitle("No any slots available for this date, please try after some time")
                            .setMessage("")
                            .sneakWarning();
                }
            }
      /*  Sneaker.with(getActivity())
                .setTitle(message)
                .setMessage("")
                .sneakError();
*/

        }

        @Override
        public void onTimeSlotRepoSuccess(ServetimeSlotRepo response, String message) {
            if (message.equalsIgnoreCase("ok")) {
                arrayList.clear();
                if (response.getData().getSlots().size() > 0) {
                    for (int i = 0; i < response.getData().getSlots().size(); i++) {
                        if (response.getData().getSlots().get(i).getBookedStatus() == true) {
                            arrayList.add(response.getData().getSlots().get(i).getTime());
                        }
                    }
                    if (arrayList.size() > 0) {
                        timeRV.setVisibility(View.VISIBLE);

                        timelistslotAdapterr t = new timelistslotAdapterr(arrayList, getContext(), this);
                        timeRV.setAdapter(t);
                    } else {
                        timeRV.setVisibility(View.GONE);
                    }



/*
                DatelistslotAdapterr datelistslotAdapterr=new DatelistslotAdapterr(response,getContext(),this);
                dateRV.setAdapter(datelistslotAdapterr);*/
                } else {
                    timeRV.setVisibility(View.GONE);
                }
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
        public void onDateSlotRepoFailure(Throwable t) {
            Sneaker.with(getActivity())
                    .setTitle(t.getLocalizedMessage())
                    .setMessage("")
                    .sneakError();
        }

        @Override
        public void CustomizeddateClickk(DateSlotRepo repo, int pos) {
            date = String.valueOf(repo.getData().getSlotDates().get(pos).getValue());
            Showdate = String.valueOf(repo.getData().getSlotDates().get(pos).getDate());
            Log.e("datedate", date);

            presenter.TimeSlotRepo(getContext(), idd, String.valueOf(repo.getData().getSlotDates().get(pos).getValue()));

        }

        @Override
        public void CustomizedTimeClickk(String repo, int pos) {
            // Toast.makeText(getContext(), pos + "", Toast.LENGTH_SHORT).show();


            time = repo;


        }
    }
}