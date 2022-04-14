package com.serviingo.serviingo.Fragments;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.iarcuschin.simpleratingbar.SimpleRatingBar;
import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.Activity.ReviewRatingActivity;
import com.serviingo.serviingo.Adapterr.AdonseorderDetailsAdapter;
import com.serviingo.serviingo.Adapterr.Included_servicesDetaisAdapter;
import com.serviingo.serviingo.Adapterr.MyAddressAdapter;
import com.serviingo.serviingo.Adapterr.MyRatingReviewAdapter;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.ViewPresenter.AddReviewPresenter;
import com.serviingo.serviingo.ViewPresenter.MyAddressPresenter;
import com.serviingo.serviingo.ViewPresenter.MyRatingReviewPresenter;
import com.serviingo.serviingo.ViewPresenter.UpdateReviewPresenter;
import com.serviingo.serviingo.modelrepo.Responsee.GetOrderDetailRepo;
import com.serviingo.serviingo.modelrepo.Responsee.MyRatingAndReviewRespo;
import com.serviingo.serviingo.modelrepo.Responsee.MyRatingAndReviewRespooo;
import com.serviingo.serviingo.modelrepo.request.Changepassword_request;
import com.serviingo.serviingo.modelrepo.request.EditReviewRequest;
import com.serviingo.serviingo.modelrepo.request.ReviewRequest;
import com.serviingo.serviingo.utils.AppUtils;

import okhttp3.ResponseBody;

import static com.serviingo.serviingo.R.drawable.globalloader;

public class ReviewRatingFragment extends Fragment implements View.OnClickListener, MyRatingReviewPresenter.MyRatingReviewView,
        MyRatingReviewAdapter.OnReviewItemListener, AddReviewPresenter.AddReviewView,
        UpdateReviewPresenter.UpdateReviewView {


    MyRatingReviewPresenter presenter;

    RecyclerView icrecyclerView;
    MyRatingReviewAdapter myRatingReviewAdapter;
    ViewDialog alert;
    DeleteReviewViewDialog deleteReviewViewDialog;

    AddReviewPresenter addReviewPresenter;
    UpdateReviewPresenter updateReviewPresenter;


    TextView tv_dashboardd,
            tv_myBooking, tv_myProfile, tv_myWallet, tv_Financial, tv_changePassword, tv_myReviews, tv_myAddressbook, tv_mySupport, tv_referralDashboard;
    ImageView arrowIvv;
    public static ScrollView scrollView;
    SwipeRefreshLayout refreshLayout;
    OrderDetailsDialog orderDetailsDialog;

    public ReviewRatingFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_review_rating, container, false);
        //refreshLayout = view.findViewById(R.id.refreshLayout);

        setui(view);

       /* refreshLayout.setOnRefreshListener(
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
        );*/
        return view;

    }

    private void setui(View view) {
        presenter = new MyRatingReviewPresenter(this);
        presenter.MyRatingReview(getContext());
        addReviewPresenter = new AddReviewPresenter(this);
        updateReviewPresenter = new UpdateReviewPresenter(this);
        icrecyclerView = view.findViewById(R.id.icrecyclerView);

        alert = new ViewDialog();
        AppTools.showRequestDialog(getActivity());

        deleteReviewViewDialog = new DeleteReviewViewDialog();


        orderDetailsDialog = new OrderDetailsDialog();



     /*   LinearLayoutManager linearLayoutManager = (new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        icrecyclerView.setLayoutManager(linearLayoutManager);*/
        //  icrecyclerView.setHasFixedSize(true);

        scrollView = view.findViewById(R.id.scroll_side_menu);
        tv_dashboardd = view.findViewById(R.id.tv_dashboardd);
        tv_myBooking = view.findViewById(R.id.tv_myBooking);
        tv_myProfile = view.findViewById(R.id.tv_myProfile);
        tv_myWallet = view.findViewById(R.id.tv_myWallet);
        tv_Financial = view.findViewById(R.id.tv_Financial);
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
        setOnClickListener();
    }

    @Override
    public void onMyRatingReviewError(String message) {

        AppTools.hideDialog();

        Sneaker.with(this)
                .setTitle(message)
                .setMessage("")
                .sneakError();
    }

    @Override
    public void onMyRatingReviewSuccess(MyRatingAndReviewRespooo response, String message) {

        AppTools.hideDialog();
/*
        Sneaker.with(this)
                .setTitle(message)
                .setMessage("")
                .sneakError();*/

        if (message.equalsIgnoreCase("ok")) {


        /*    MyRatingReviewAdapter  myRatingReviewAdapter = new MyRatingReviewAdapter(response, getContext(), this);
            RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
            icrecyclerView.setLayoutManager(mLayoutManager1);
            icrecyclerView.setItemAnimator(new DefaultItemAnimator());
            icrecyclerView.setAdapter(myRatingReviewAdapter);


            */


            MyRatingReviewAdapter myRatingReviewAdapter = new MyRatingReviewAdapter(response, getContext(), this);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1, LinearLayoutManager.VERTICAL, false);
            icrecyclerView.setLayoutManager(gridLayoutManager);
            icrecyclerView.setHasFixedSize(true);
            icrecyclerView.setAdapter(myRatingReviewAdapter);

            /*linearLayoutManager = (new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, true));
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setHasFixedSize(true);
*/

        }
    }

    @Override
    public void onMyRatingReviewFailure(Throwable t) {
        AppTools.hideDialog();

        Sneaker.with(this)
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();
    }


    @Override
    public void AddReviewonClick(MyRatingAndReviewRespooo data, int position) {

        alert.showDialog(position, data, getActivity(), String.valueOf(data.getData().get(position).getId()), "add");

        // Toast.makeText(getContext(), data.getData().get(position).getId() + "", Toast.LENGTH_SHORT).show();

        //Toast.makeText(getContext(), position+"AddReviewonClick", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void EditReviewonClick(MyRatingAndReviewRespooo data, int position) {

        alert.showDialog(position, data, getActivity(), String.valueOf(data.getData().get(position).getRatingReviews().getId()), "update");


        //  Toast.makeText(getContext(), position+"EditReviewonClick", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void DeleteReviewonClick(MyRatingAndReviewRespooo data, int position) {
        // Toast.makeText(getContext(), position+"DeleteReviewonClick", Toast.LENGTH_SHORT).show();
        // Toast.makeText(getContext(), data.getData().get(position).getRatingReviews().getId() + "", Toast.LENGTH_SHORT).show();
        deleteReviewViewDialog.showDialog(getActivity(), String.valueOf(data.getData().get(position).getRatingReviews().getId()));

    }


    @Override
    public void imagenextClick(MyRatingAndReviewRespooo data, int position) {

        updateReviewPresenter.GetOrderDetail(getContext(), String.valueOf(data.getData().get(position).getId()));

    }

    @Override
    public void onAddReviewError(String message) {
        AppTools.hideDialog();

        Sneaker.with(getActivity())
                .setTitle(message)
                .setMessage("")
                .sneakError();

    }

    @Override
    public void onAddReviewSuccess(ResponseBody response, String message) {


        AppTools.hideDialog();

        Sneaker.with(getActivity())
                .setTitle("Your Rating & Reviews Submitted successfully.")
                .setMessage("")
                .sneakSuccess();

        if (message.equalsIgnoreCase("ok")) {

            presenter.MyRatingReview(getContext());


        }
    }

    @Override
    public void onAddReviewFailure(Throwable t) {
        AppTools.hideDialog();

        Sneaker.with(getActivity())
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();
    }

    @Override
    public void onUpdateReviewError(String message) {
        AppTools.hideDialog();

        Sneaker.with(getActivity())
                .setTitle(message)
                .setMessage("")
                .sneakError();
    }

    @Override
    public void onUpdateReviewSuccess(ResponseBody response, String message) {

        AppTools.hideDialog();

        Sneaker.with(getActivity())
                .setTitle("Your Rating & Reviews Updated successfully.")
                .setMessage("")
                .sneakSuccess();

        if (message.equalsIgnoreCase("ok")) {

            presenter.MyRatingReview(getContext());


        }
    }

    @Override
    public void onDeleteReviewSuccess(ResponseBody response, String message) {
        AppTools.hideDialog();

        Sneaker.with(getActivity())
                .setTitle("Rating & Review Successfully Deleted.")
                .setMessage("")
                .sneakSuccess();

        if (message.equalsIgnoreCase("ok")) {

            presenter.MyRatingReview(getContext());


        }
    }

    @Override
    public void onUpdateReviewFailure(Throwable t) {
        AppTools.hideDialog();

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
    public void onGetOrderDetailSuccess(GetOrderDetailRepo body, String message) {

        if (message.equalsIgnoreCase("ok")) {

            orderDetailsDialog.showDialog(getActivity(), body);


        }

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

    private void setOnClickListener() {


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

    public class ViewDialog {

        EditText Ed_comment;
        //  RadioButton rb1, rb2, rb3, rb4, rb5;
        TextView btn, editreviewsbtn,textt,texttttt;
        String rating = " ";
        Dialog dialog;
        SimpleRatingBar text_rating;
        String ratingg;


        public void showDialog(int position, MyRatingAndReviewRespooo data, Activity activity, String id, String key) {
            dialog = new Dialog(activity);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.rating_alertbox);

            WindowManager.LayoutParams lp = new WindowManager.LayoutParams();


            lp.copyFrom(dialog.getWindow().getAttributes());
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            dialog.getWindow().setAttributes(lp);

            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            /*WindowManager.LayoutParams wmlp = dialog.getWindow().getAttributes();
//            wmlp.x = 30;   //x position
            //wmlp.y = 300;   //y position

           // wmlp.gravity = Gravity.TOP;

            */

            ImageView close = dialog.findViewById(R.id.close);
            Ed_comment = dialog.findViewById(R.id.Ed_comment);
            btn = dialog.findViewById(R.id.btn);
            editreviewsbtn = dialog.findViewById(R.id.editreviewsbtn);
            textt= dialog.findViewById(R.id.textt);
            texttttt= dialog.findViewById(R.id.texttttt);
            text_rating = dialog.findViewById(R.id.text_rating);
            text_rating.setOnRatingBarChangeListener(new SimpleRatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(SimpleRatingBar simpleRatingBar, float rating, boolean fromUser) {

                    //char first = String.valueOf(rating).charAt(0);

                    ratingg = String.valueOf(rating);
                    //    Toast.makeText(activity, ratingg+"", Toast.LENGTH_SHORT).show();
                }
            });

            if (key.equalsIgnoreCase("update")) {
                Ed_comment.setEnabled(false);
                //text_rating.setEnabled(false);
                text_rating.setIndicator(true);

                editreviewsbtn.setVisibility(View.VISIBLE);
                btn.setVisibility(View.GONE);
                Ed_comment.setBackground(null);
                textt.setVisibility(View.GONE);
                texttttt.setVisibility(View.GONE);

                Ed_comment.setText(data.getData().get(position).getRatingReviews().getReview());
                text_rating.setRating(Float.parseFloat(String.valueOf(data.getData().get(position).getRatingReviews().getRating())));
                editreviewsbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Ed_comment.setBackground(getActivity().getResources().getDrawable(R.drawable.border_rectangle));

                        textt.setVisibility(View.VISIBLE);
                        texttttt.setVisibility(View.VISIBLE);
                        btn.setVisibility(View.VISIBLE);
                        editreviewsbtn.setVisibility(View.GONE);
                        Ed_comment.setEnabled(true);
                        //text_rating.setEnabled(false);
                        text_rating.setIndicator(false);


                    }
                });


                //Toast.makeText(activity, Float.parseFloat(String.valueOf(data.getData().get(position).getRatingReviews().getRating()))+"", Toast.LENGTH_SHORT).show();



                /*
                Ed_comment.setText(data.getData().get(position).getRatingReviews().getReview());
                if (data.getData().get(position).getRatingReviews().getRating() == 1) {
                    rb1.setChecked(true);

                } else if (data.getData().get(position).getRatingReviews().getRating() == 2) {

                    rb2.setChecked(true);

                } else if (data.getData().get(position).getRatingReviews().getRating() == 3) {

                    rb3.setChecked(true);

                } else if (data.getData().get(position).getRatingReviews().getRating() == 4) {

                    rb4.setChecked(true);

                } else if (data.getData().get(position).getRatingReviews().getRating() == 5) {

                    rb5.setChecked(true);

                }*/
            }


            close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getdata(data, id, key);
                }
            });


            dialog.show();
        }

        public void getdata(MyRatingAndReviewRespooo data, String id, String key) {

          /*  if (rb1.isChecked()) {

                rating = "1";
            } else if (rb2.isChecked()) {
                rating = "2";
            } else if (rb3.isChecked()) {
                rating = "3";
            } else if (rb4.isChecked()) {
                rating = "4";
            } else if (rb5.isChecked()) {
                rating = "5";
            }*/


            if (Ed_comment.getText().toString().trim().isEmpty()) {
                Sneaker.with(getActivity())
                        .setTitle("The review Comment is required")
                        .setMessage("")
                        .sneakError();
            } else {

                if (key.equalsIgnoreCase("add")) {

                    dialog.dismiss();
                    AppTools.showRequestDialog(getActivity());


                    ReviewRequest reviewRequest = new ReviewRequest(id, Ed_comment.getText().toString().trim(), ratingg);
                    addReviewPresenter.AddReview(getContext(), reviewRequest);


                } else {
                    dialog.dismiss();

                    AppTools.showRequestDialog(getActivity());


                    EditReviewRequest editReviewRequest = new EditReviewRequest(Ed_comment.getText().toString().trim(), ratingg, id);
                    dialog.dismiss();
                    updateReviewPresenter.UpdateReview(getContext(), editReviewRequest);

                }


            }


        }
    }

    public class DeleteReviewViewDialog {

        TextView tvDelete, tvCancel;
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


            alertDialog.dismiss();
            AppTools.showRequestDialog(getActivity());
            // Toast.makeText(getContext(), id + "", Toast.LENGTH_SHORT).show();
            updateReviewPresenter.DeleteReview(getContext(), id);

        }


    }


    public class OrderDetailsDialog {
        Included_servicesDetaisAdapter included_servicesDetaisAdapter;

        AlertDialog alertDialog;

        RecyclerView recyclerViewPackage, recyclerView;
        TextView tvsubmoney, tvrs, tvrus, tvvaluue, tvHeading, tvSubHeading, MembershipDiscountAmountTV, ServiceDiscountprice, MembershipTv, safety_hygieneTV, SubTotalTv,
                ServiceDiscounttitle, tvDiscount, MembershipFeesTv,
                viewInvoiceTv,couponTv;
        RelativeLayout safety_hygiene_feeRl,couponrl;;
        WebView simpleWebView;
        LinearLayout WebViewLayoutLL, billingTV;


        public void showDialog(Activity activity, GetOrderDetailRepo orderDetailRepo) {

            LayoutInflater inflater = LayoutInflater.from(activity);
            View view = inflater.inflate(R.layout.orderdetailsdialog, null);
            alertDialog = new AlertDialog.Builder(activity)
                    .setView(view)
                    .setCancelable(false)
                    .create();
            ImageView close = view.findViewById(R.id.close);
            ImageView closeWebViewLayout = view.findViewById(R.id.closeWebViewLayout);
            couponrl= view.findViewById(R.id.couponrl);
            simpleWebView = view.findViewById(R.id.simpleWebView);
            WebViewLayoutLL = view.findViewById(R.id.WebViewLayoutLL);
            billingTV = view.findViewById(R.id.billingTV);
            recyclerViewPackage = view.findViewById(R.id.recyclerViewPackage);
            tvsubmoney = view.findViewById(R.id.tvsubmoney);
            tvrs = view.findViewById(R.id.tvrs);
            tvrus = view.findViewById(R.id.tvrus);
            ServiceDiscounttitle = view.findViewById(R.id.ServiceDiscounttitle);
            couponTv= view.findViewById(R.id.couponTv);
            tvDiscount = view.findViewById(R.id.tvDiscount);
            safety_hygieneTV = view.findViewById(R.id.safety_hygieneTV);
            SubTotalTv = view.findViewById(R.id.SubTotalTv);
            safety_hygiene_feeRl = view.findViewById(R.id.safety_hygiene_feeRl);

            tvHeading = view.findViewById(R.id.tvHeading);
            viewInvoiceTv = view.findViewById(R.id.viewInvoiceTv);
            MembershipFeesTv = view.findViewById(R.id.MembershipFeesTv);
            tvSubHeading = view.findViewById(R.id.tvSubHeading);
            tvvaluue = view.findViewById(R.id.tvvaluue);
            recyclerView = view.findViewById(R.id.recyclerView);
            ServiceDiscountprice = view.findViewById(R.id.ServiceDiscountprice);
            MembershipTv = view.findViewById(R.id.MembershipTv);
            MembershipDiscountAmountTV = view.findViewById(R.id.MembershipDiscountAmountTV);

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


            if (orderDetailRepo.getData().getOrderInfo().getCoupon_discount_amount() !=null) {


                couponrl.setVisibility(View.VISIBLE);

                couponTv.setText("\u20B9" + orderDetailRepo.getData().getOrderInfo().getCoupon_discount_amount());
            }


            if (orderDetailRepo.getData().getMembershipFees() != 0) {
                MembershipFeesTv.setVisibility(View.VISIBLE);

                MembershipTv.setVisibility(View.VISIBLE);
                MembershipTv.setText(String.format("₹%d", orderDetailRepo.getData().getMembershipFees()));


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


    }
}

