package com.serviingo.serviingo.Fragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.Adapterr.MyAddressAdapter;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.ViewPresenter.MyAddressPresenter;
import com.serviingo.serviingo.modelrepo.Responsee.MyAddressRepoo;
import com.serviingo.serviingo.utils.AppUtils;

import okhttp3.ResponseBody;

public class AddressFragment extends Fragment implements View.OnClickListener, MyAddressPresenter.MyAddressView, MyAddressAdapter.OnAddressItemListener {

    RecyclerView icrecyclerView;
    TextView addadress;
    TextView tv_home, tvreferdesc;
    MyAddressPresenter myAddressPresenter;
    MyAddressAdapter myAddressAdapter;
    DeleteAddressViewDialog deleteAddressViewDialog;


    TextView tv_dashboardd,
            tv_myBooking, tv_myProfile, tv_myWallet, tv_Financial, tv_changePassword, tv_myReviews, tv_myAddressbook, tv_mySupport, tv_referralDashboard;
    ImageView arrowIvv;
    public static ScrollView scrollView;

    SwipeRefreshLayout refreshLayout;

    public AddressFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_address, container, false);
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


        // getActivity().getSupportActionBar().setTitle();


   /*  setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" "); */
        return view;

    }

    private void setui(View view) {
        AppTools.showRequestDialog(getActivity());

        tv_home = view.findViewById(R.id.tv_home);

        myAddressPresenter = new MyAddressPresenter(this);
        myAddressPresenter.MyAddressList(getContext());

        icrecyclerView = view.findViewById(R.id.icrecyclerView);
        addadress = view.findViewById(R.id.addadress);
        deleteAddressViewDialog = new DeleteAddressViewDialog();

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

        LinearLayoutManager linearLayoutManager = (new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, true));
        icrecyclerView.setLayoutManager(linearLayoutManager);
        icrecyclerView.setHasFixedSize(true);

        addadress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment addressbookFragment = new AddressbookFragment();
                fragmentTransaction.replace(R.id.fragment_Container, addressbookFragment);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
                // showPictureialog();
            }
        });

        setOnclickistener();

    }

    @Override
    public void onMyAddressError(String message) {

        AppTools.hideDialog();

        Sneaker.with(this)
                .setTitle(message)
                .setMessage("")
                .sneakError();
    }

    @Override
    public void onMyAddressSuccess(MyAddressRepoo response, String message) {

        AppTools.hideDialog();
        Log.e("response", response.getData().toString());


        if (message.equalsIgnoreCase("ok")) {


            myAddressAdapter = new MyAddressAdapter(response, getContext(), this);
            icrecyclerView.setAdapter(myAddressAdapter);

            if (response.getData().getServeCities() != null) {
                AlertDialogBox(response.getData().getServeCities());
            }


            /*linearLayoutManager = (new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, true));
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setHasFixedSize(true);
*/

        }
    }

    @Override
    public void onDeleteAddressSuccess(ResponseBody response, String message) {
        /// Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
        if (message.equalsIgnoreCase("ok")) {
            Sneaker.with(getActivity())
                    .setTitle("Address Deleted Successfully.")
                    .setMessage("")
                    .sneakSuccess();
            //    AppTools.showGifDialog(getActivity(), globalloader);

            myAddressPresenter.MyAddressList(getContext());


        }
    }

    @Override
    public void onMyAddressFailure(Throwable t) {

        AppTools.hideDialog();

        Sneaker.with(this)
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();

    }

    private void showPictureialog() {
        final Dialog dialog = new Dialog(getContext(),
                android.R.style.Theme_DeviceDefault_Light_NoActionBar);
        // Setting dialogview
        Window window = dialog.getWindow();
        window.setGravity(Gravity.CENTER);
        window.setLayout(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
        dialog.setTitle(null);
        dialog.setContentView(R.layout.alertbox);
        dialog.setCancelable(true);
        dialog.dismiss();
        dialog.show();
    }

    private void setOnclickistener() {

        tv_home.setOnClickListener(this);
        //  ivNav.setOnClickListener(this);

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

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch (v.getId()) {

/*
            case R.id.tv_home:
//                finish();
//                startActivity(new Intent(this, MainActivity.class));
                break;*/


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


    @Override
    public void EditAddressOnClick(MyAddressRepoo data, int position) {


        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment addressbookFragment = new AddressbookFragment();
        Bundle args = new Bundle();
        // args.putSerializable(ARG_ANIMALS, animals as Serializable)
        args.putSerializable("data", data.getData().getAddress().get(position));
        addressbookFragment.setArguments(args);
        fragmentTransaction.replace(R.id.fragment_Container, addressbookFragment);
        fragmentTransaction.addToBackStack(null);

        fragmentTransaction.commit();


//Inflate the fragment
        //  Toast.makeText(getContext(), data.getData().getAddress().get(position)+"EditAddressOnClick", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void DeleteAddressOnClick(MyAddressRepoo data, int position) {

        //  Toast.makeText(getContext(), data.getData().getAddress().get(position).getAddressType()+"DeleteAddressOnClick", Toast.LENGTH_SHORT).show();

        deleteAddressViewDialog.showDialog(getActivity(), String.valueOf(data.getData().getAddress().get(position).getId()));

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
            descTv.setText("Delete this Address.");

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
            AppTools.showRequestDialog(getActivity());

            // Toast.makeText(getContext(), id+"", Toast.LENGTH_SHORT).show();

            alertDialog.dismiss();
            myAddressPresenter.DeleteAddress(getContext(), id);

      /*  AppTools.showGifDialog(getActivity(), globalloader);
        Toast.makeText(getContext(), id+"", Toast.LENGTH_SHORT).show();
        updateReviewPresenter.DeleteReview(getContext(), id);*/

        }


    }

    public void AlertDialogBox(String msg) {

        //Logout
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());

        // set title
        alertDialogBuilder.setTitle(" ");

        // set dialog message
        // alertDialogBuilder.setIcon(R.drawable.logoo1);
        alertDialogBuilder
                .setMessage(msg)
                .setCancelable(false)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();

                    }
                });
        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }
}
