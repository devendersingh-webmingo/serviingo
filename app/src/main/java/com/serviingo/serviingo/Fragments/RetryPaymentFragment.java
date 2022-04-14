package com.serviingo.serviingo.Fragments;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.Activity.RazorPay.RazorPaymentActivity;
import com.serviingo.serviingo.Adapterr.AdonseorderDetailsAdapter;
import com.serviingo.serviingo.Adapterr.Included_servicesDetaisAdapter;
import com.serviingo.serviingo.Adapterr.TimeSlotAdapter.DatelistslotAdapterr;
import com.serviingo.serviingo.Adapterr.TimeSlotAdapter.timelistslotAdapterr;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.ViewPresenter.CreateOrderPresenter;
import com.serviingo.serviingo.ViewPresenter.ManageOrderListingPresenter;
import com.serviingo.serviingo.ViewPresenter.TempCart.RetryPaymentPresenterr;
import com.serviingo.serviingo.ViewPresenter.TimeSlotPresenter;
import com.serviingo.serviingo.model.Timeslots;
import com.serviingo.serviingo.modelrepo.Responsee.CreateOrderRepo;
import com.serviingo.serviingo.modelrepo.Responsee.DateSlotRepo;
import com.serviingo.serviingo.modelrepo.Responsee.GetOrderDetailRepo;
import com.serviingo.serviingo.modelrepo.Responsee.ManageOrderListingRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Profile_Repo;
import com.serviingo.serviingo.modelrepo.Responsee.Razorpay.RazorpayRepo;
import com.serviingo.serviingo.modelrepo.Responsee.ServetimeSlotRepo;
import com.serviingo.serviingo.modelrepo.request.CreateOrderRequest;
import com.serviingo.serviingo.modelrepo.request.RetryPaymentRequest;
import com.serviingo.serviingo.storage.SharedPrefManager;

import java.util.ArrayList;

import okhttp3.ResponseBody;

public class RetryPaymentFragment extends Fragment implements ManageOrderListingPresenter.ManageOrderListingView, CreateOrderPresenter.CreateOrderPresenterView, RetryPaymentPresenterr.RetryPaymentView {


    Included_servicesDetaisAdapter included_servicesDetaisAdapter;
    ManageOrderListingPresenter manageOrderListingPresenter;
    RecyclerView recyclerViewPackage, recyclerView;
    TextView tvsubmoney, tvrs, tvrus, tvvaluue, tvHeading, tvSubHeading, MembershipDiscountAmountTV, ServiceDiscountprice, MembershipTv, safety_hygieneTV, SubTotalTv,
            ServiceDiscounttitle,
            tvDiscount,
            MembershipFeesTv,

    ChooseTimeSlotsTV;

    RelativeLayout safety_hygiene_feeRl, couponrl;
    LinearLayout WebViewLayoutLL, billingTV;

    Bundle extras;
    String Id, Quentiy, PaymentOption;
    LinearLayout slottimeLL;
    TextView dateSlot, timeslott, TV_Payment, choosefile, couponTv;
    String Subcategory, serve_date, serve_time;
    ViewDialog alert;
    ImageView openSlotBox;
    RadioButton rdwallet, rdallet, rdOnline;
    String payment_method;
    String order_id, OrderNumber, total_amount;
    CreateOrderPresenter Getrazorpaykey;

    RetryPaymentPresenterr retryPaymentPresenterr;
    ArrayList<String> arrayList;

    public RetryPaymentFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_retry_payment, container, false);
        setui(view);

        return view;
    }

    private void setui(View view) {
        Getrazorpaykey = new CreateOrderPresenter(this);
        manageOrderListingPresenter = new ManageOrderListingPresenter(this);
        retryPaymentPresenterr = new RetryPaymentPresenterr(this);
        extras = getArguments();

        if (extras != null) {
            Id = getArguments().getString("id");
            PaymentOption = getArguments().getString("PaymentOption");
            manageOrderListingPresenter.GetOrderDetail(getContext(), Id);
            // Toast.makeText(getActivity(), Id+"", Toast.LENGTH_SHORT).show();
        }
        alert = new ViewDialog();
        openSlotBox = view.findViewById(R.id.openSlotBox);
        WebViewLayoutLL = view.findViewById(R.id.WebViewLayoutLL);
        slottimeLL = view.findViewById(R.id.slottimeLL);
        dateSlot = view.findViewById(R.id.dateSlot);
        timeslott = view.findViewById(R.id.timeslott);
        billingTV = view.findViewById(R.id.billingTV);
        recyclerViewPackage = view.findViewById(R.id.recyclerViewPackage);
        tvsubmoney = view.findViewById(R.id.tvsubmoney);
        tvrs = view.findViewById(R.id.tvrs);
        tvrus = view.findViewById(R.id.tvrus);
        ServiceDiscounttitle = view.findViewById(R.id.ServiceDiscounttitle);
        tvDiscount = view.findViewById(R.id.tvDiscount);
        safety_hygieneTV = view.findViewById(R.id.safety_hygieneTV);
        SubTotalTv = view.findViewById(R.id.SubTotalTv);
        safety_hygiene_feeRl = view.findViewById(R.id.safety_hygiene_feeRl);
        couponrl = view.findViewById(R.id.couponrl);

        tvHeading = view.findViewById(R.id.tvHeading);
        ChooseTimeSlotsTV = view.findViewById(R.id.ChooseTimeSlotsTV);
        MembershipFeesTv = view.findViewById(R.id.MembershipFeesTv);
        tvSubHeading = view.findViewById(R.id.tvSubHeading);
        tvvaluue = view.findViewById(R.id.tvvaluue);
        recyclerView = view.findViewById(R.id.recyclerView);
        ServiceDiscountprice = view.findViewById(R.id.ServiceDiscountprice);
        MembershipTv = view.findViewById(R.id.MembershipTv);
        MembershipDiscountAmountTV = view.findViewById(R.id.MembershipDiscountAmountTV);
        rdwallet = view.findViewById(R.id.rdwallet);
        rdallet = view.findViewById(R.id.rdallet);
        rdOnline = view.findViewById(R.id.rdOnline);
        TV_Payment = view.findViewById(R.id.TV_Payment);
        choosefile = view.findViewById(R.id.choosefile);
        couponTv = view.findViewById(R.id.couponTv);

        ChooseTimeSlotsTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert.showDialog(Subcategory);

                // Subcategory= String.valueOf(modelArrayList.getData().getData().get(position).get_package().getSubCategoryId());

            }
        });
        TV_Payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                payment();
            }
        });

        openSlotBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert.showDialog(Subcategory);

                // Subcategory= String.valueOf(modelArrayList.getData().getData().get(position).get_package().getSubCategoryId());

            }
        });


    }

    @Override
    public void onManageOrderListingError(String message) {

    }

    @Override
    public void onManageOrderListingSuccess(ManageOrderListingRepo response, String message) {

    }

    @Override
    public void onCancelOrderSuccess(ResponseBody response, String message) {

    }

    @Override
    public void onGetOrderDetailSuccess(GetOrderDetailRepo response, String message) {

        if (message.equalsIgnoreCase("ok")) {
            billingTV.setVisibility(View.VISIBLE);


            if (PaymentOption.equalsIgnoreCase("PayNow")) {
                dateSlot.setVisibility(View.GONE);
                choosefile.setVisibility(View.GONE);
                timeslott.setVisibility(View.GONE);
                openSlotBox.setVisibility(View.GONE);
                ChooseTimeSlotsTV.setVisibility(View.GONE);
                slottimeLL.setVisibility(View.VISIBLE);
                rdallet.setVisibility(View.GONE);
            }

            order_id = String.valueOf(response.getData().getOrderInfo().getId());
            included_servicesDetaisAdapter = new Included_servicesDetaisAdapter(response, getContext());

            Subcategory = String.valueOf(response.getData().getOrderInfo().getPackage().getSubCategoryId());
            //Toast.makeText(getActivity(), Subcategory+"", Toast.LENGTH_SHORT).show();

            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1, LinearLayoutManager.VERTICAL, false);
            recyclerViewPackage.setLayoutManager(gridLayoutManager);
            recyclerViewPackage.setHasFixedSize(true);

            GridLayoutManager gridLayoutManagerr = new GridLayoutManager(getContext(), 1, LinearLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(gridLayoutManagerr);
            recyclerView.setHasFixedSize(true);

            if (response.getData().getIncludedServices().size() > 0) {
                recyclerViewPackage.setAdapter(included_servicesDetaisAdapter);
                tvHeading.setVisibility(View.VISIBLE);
            }
            if (response.getData().getOrderInfo().getAddons().size() > 0) {
                AdonseorderDetailsAdapter adonseorderDetailsAdapter = new AdonseorderDetailsAdapter(response, getContext());
                recyclerView.setAdapter(adonseorderDetailsAdapter);
                //tvSubHeading.setVisibility(View.VISIBLE);
            }

            if (response.getData().getOrderInfo().getCoupon_discount_amount() != null) {


                couponrl.setVisibility(View.VISIBLE);

                couponTv.setText("\u20B9" + response.getData().getOrderInfo().getCoupon_discount_amount());
            }

            if (response.getData().getAddonAmount() != 0) {
                ServiceDiscountprice.setVisibility(View.VISIBLE);
                ServiceDiscounttitle.setVisibility(View.VISIBLE);
                ServiceDiscountprice.setText("₹" + response.getData().getAddonAmount());


            }


            if (response.getData().getMembershipFees() != 0) {
                MembershipFeesTv.setVisibility(View.VISIBLE);

                MembershipTv.setVisibility(View.VISIBLE);
                MembershipTv.setText(String.format("₹%d", response.getData().getMembershipFees()));


            }

            if (response.getData().getHygieneFees() != 0) {
                safety_hygiene_feeRl.setVisibility(View.VISIBLE);
                safety_hygieneTV.setText(String.format("₹%d", response.getData().getHygieneFees()));
            }
            SubTotalTv.setText(String.format("₹%d", response.getData().getSubTotal()));


            tvsubmoney.setText(String.format("₹%d", response.getData().getServiceAmount()));

            if (response.getData().getMembershipDiscount() != 0) {

                tvDiscount.setVisibility(View.VISIBLE);
                tvrs.setVisibility(View.VISIBLE);
                tvrs.setText(String.format("₹%d", response.getData().getMembershipDiscount()));

            }

            tvrus.setText("\u20B9" + response.getData().getTotalDiscount());
            tvvaluue.setText(" \u20B9" + response.getData().getOrderInfo().getTotalAmount());
            total_amount = response.getData().getOrderInfo().getTotalAmount();
            tvHeading.setText(response.getData().getOrderInfo().getPackage().getName());
            MembershipDiscountAmountTV.setText(String.format("₹%d", response.getData().getServiceDiscount()));
/*
            if (orderDetailRepo.getData().getOrderInfo().getOrderStatus().equalsIgnoreCase("Ongoing") ||
                    orderDetailRepo.getData().getOrderInfo().getOrderStatus().equalsIgnoreCase("Processing")
                    || orderDetailRepo.getData().getOrderInfo().getOrderStatus().equalsIgnoreCase("Completed")) {
                if (orderDetailRepo.getData().getOrderInfo().getPaymentStatus().equalsIgnoreCase("Completed")) {
                    viewInvoiceTv.setVisibility(View.VISIBLE);
                }
            }*/

        }

    }

    @Override
    public void onManageOrderListingFailure(Throwable t) {

    }

    @Override
    public void CreateOrderError(String message) {

    }

    @Override
    public void RetryPaymentReqError(String message) {
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
    public void RetryPaymentReqSuccess(ResponseBody response, String message) {
        if (message.equalsIgnoreCase("ok")) {

            Toast.makeText(getContext(), "Payment Completed Successfully ", Toast.LENGTH_LONG).show();
            SharedPrefManager.getInstans(getContext().getApplicationContext()).MembsershipClear();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Fragment recentBookingFragment = new RecentBookingFragment();
            fragmentTransaction.replace(R.id.fragment_Container, recentBookingFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        }

    }

    @Override
    public void RetryPaymentReqFailure(Throwable t) {

    }

    @Override
    public void TempCartSuccess(ResponseBody response, String message) {

    }

    @Override
    public void GetRazorPayKeySuccess(RazorpayRepo response, String message) {

        if (message.equalsIgnoreCase("ok")) {
            //startPayment(response.getData().getPaymentMethod().getApiKey(), total_amount);

            Intent intent = new Intent(getContext(), RazorPaymentActivity.class);// New activity
            intent.putExtra("ApiKey", response.getData().getPaymentMethod().getApiKey());
            intent.putExtra("order_id", order_id);
            intent.putExtra("OrderNumber", "RetryPayment");
            intent.putExtra("total_amount", total_amount);

            /*intent.putExtra("serve_date", serve_date);
            intent.putExtra("serve_time", serve_time);
*/

            // Log.e("CODDDDDDD", serve_date + "\n" + serve_time);


            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            Log.e("detailsss", order_id + OrderNumber + total_amount);


        }

    }

    @Override
    public void PaymentSignatureVerifyReqSuccess(ResponseBody response, String message) {

    }

    @Override
    public void CreateOrderSuccess(CreateOrderRepo response, String message) {

    }

    @Override
    public void onDoMyprofileSuccess(Profile_Repo response, String message) {

    }

    @Override
    public void CreateOrderFailure(Throwable t) {
        Sneaker.with(getActivity())
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();
    }


    public class ViewDialog implements TimeSlotPresenter.TimeSlotView, DatelistslotAdapterr.DateClick, timelistslotAdapterr.CustomizedClick {
        timelistslotAdapterr t;

        Dialog dialog;

        RecyclerView dateRV, timeRV;
        TimeSlotPresenter presenter;

        ArrayList<CreateOrderRequest.AddonService> addonServices;

        CardView btn_moreDetails;

        ImageView exit;

        public void showDialog(String id) {
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

            btn_moreDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    ChooseTimeSlotsTV.setVisibility(View.GONE);
                    slottimeLL.setVisibility(View.VISIBLE);
                    timeslott.setText("Timing: " + serve_time);
                    dateSlot.setText("Date: " + serve_date);
                    if (PaymentOption.equalsIgnoreCase("PayNow")) {
                        rdallet.setVisibility(View.GONE);
                    }


                }
            });

            exit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();

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
                    presenter.TimeSlotRepo(getContext(), Subcategory, response.getData().getTodayDate());

                    serve_date = response.getData().getTodayDate();
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


                if (response.getData().getSlots().size() > 0) {


                    arrayList = new ArrayList<>();
                    arrayList.clear();

                    for (int i = 0; i < response.getData().getSlots().size(); i++) {
                        if (response.getData().getSlots().get(i).getBookedStatus() == true) {
                            arrayList.add(response.getData().getSlots().get(i).getTime());
                        }
                    }
                    if (arrayList.size() > 0) {
                        timeRV.setVisibility(View.VISIBLE);

                        t = new timelistslotAdapterr(arrayList, getContext(), this);
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
            serve_date = String.valueOf(repo.getData().getSlotDates().get(pos).getValue());
            //   Toast.makeText(getContext(), serve_date + "", Toast.LENGTH_SHORT).show();

            presenter.TimeSlotRepo(getContext(), Subcategory, String.valueOf(repo.getData().getSlotDates().get(pos).getValue()));


        }

        @Override
        public void CustomizedTimeClickk(String repo, int pos) {
            // Toast.makeText(getContext(), pos + "", Toast.LENGTH_SHORT).show();


            serve_time = repo;
            SharedPrefManager.getInstance(getActivity())
                    .SlotTimeDate(serve_date, serve_time);

            // Toast.makeText(getContext(), serve_time + "", Toast.LENGTH_SHORT).show();

        }
    }

    public void payment() {

        if (rdwallet.isChecked()) {

            payment_method = "wallet";
        } else if (rdallet.isChecked()) {
            payment_method = "cod";
        } else if (rdOnline.isChecked()) {
            payment_method = "online";

        }

        if (payment_method != null) {

            if (payment_method.equalsIgnoreCase("wallet")) {
                RetryPaymentRequest retryPaymentRequest = new RetryPaymentRequest(order_id, "wallet", serve_date, serve_time);
                retryPaymentPresenterr.RetryPaymentReq(getContext(), retryPaymentRequest);


            } else if (payment_method.equalsIgnoreCase("cod")) {

                Log.e("CODDDDDDD", serve_date + "\n" + serve_time);


                RetryPaymentRequest retryPaymentRequest = new RetryPaymentRequest(order_id, "cod", serve_date, serve_time);
                retryPaymentPresenterr.RetryPaymentReq(getContext(), retryPaymentRequest);

            } else {
                Getrazorpaykey.GetRazorPayKey(getContext());

            }

        } else {
            Sneaker.with(getActivity())
                    .setTitle("Choose Payment Method")
                    .setMessage(" ")
                    .sneakError();
        }


    }

}