package com.serviingo.serviingo.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.ViewPresenter.ChangePasswordPresenter;
import com.serviingo.serviingo.modelrepo.request.Changepassword_request;
import com.serviingo.serviingo.utils.AppUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;

public class ChangePasswordFragment extends Fragment implements View.OnClickListener, ChangePasswordPresenter.ChangePasswordView {

    EditText etoldPassword, etnewPassword, etconfirmMnewPassword;
    TextView tvUpdate;


    ChangePasswordPresenter passwordPresenter;

    TextView tv_dashboardd,
            tv_myBooking, tv_myProfile, tv_myWallet, tv_Financial,tv_changePassword, tv_myReviews, tv_myAddressbook, tv_mySupport, tv_referralDashboard;
    ImageView arrowIvv;
    public static ScrollView scrollView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_change_password, container, false);


        setui(view);
        return view;

    }

    private void setui(View view) {
        etoldPassword = view.findViewById(R.id.etoldPassword);
        etnewPassword = view.findViewById(R.id.etnewPassword);
        tvUpdate = view.findViewById(R.id.tvUpdate);
        etconfirmMnewPassword = view.findViewById(R.id.etconfirmMnewPassword);

        scrollView = view.findViewById(R.id.scroll_side_menu);
        tv_dashboardd = view.findViewById(R.id.tv_dashboardd);
        tv_myBooking = view.findViewById(R.id.tv_myBooking);
        tv_myProfile = view.findViewById(R.id.tv_myProfile);
        tv_myWallet = view.findViewById(R.id.tv_myWallet);
        tv_Financial= view.findViewById(R.id.tv_Financial);
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
        passwordPresenter = new ChangePasswordPresenter(this);

        setOnClickListener();


    }

    private void setOnClickListener() {
        tvUpdate.setOnClickListener(this);


        tv_myBooking.setOnClickListener(this);
        tv_myProfile.setOnClickListener(this);
        tv_Financial.setOnClickListener(this);
        tv_myWallet.setOnClickListener(this);
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
            case R.id.tvUpdate:
                if (etoldPassword.getText().toString().trim().isEmpty()) {
                    Sneaker.with(this)
                            .setTitle("Enter old Password")
                            .setMessage("")
                            .sneakError();
                } else if (etnewPassword.getText().toString().trim().length() < 4) {
                    Sneaker.with(this)
                            .setTitle("The password must be at least 4 characters.")
                            .setMessage("")
                            .sneakError();
                } else if (!etconfirmMnewPassword.getText().toString().trim().equals(etnewPassword.getText().toString().trim())) {
                    Sneaker.with(this)
                            .setTitle("Confirm password not match")
                            .setMessage("")
                            .sneakError();
                } else {

                    AppTools.showRequestDialog(getActivity());


                    Changepassword_request changepassword_request = new Changepassword_request(etoldPassword.getText().toString().trim(),
                            etnewPassword.getText().toString().trim(),
                            etconfirmMnewPassword.getText().toString().trim());
                    passwordPresenter.ChangePassword(getContext(), changepassword_request);

                 /*   if (SimpleHTTPConnection.isNetworkAvailable(mActivity)) {
                        PostUpdatePassword();
                    } else {
                        AppUtils.showErrorMessage(tvUpdate, "Please check your internet connection.", mActivity);
                    }*/
                }
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
            case R.id.tv_Financial:
                // onBackPressed();

                Fragment Membership = new MyMemberShipFragment();
                fragmentTransaction.replace(R.id.fragment_Container, Membership);
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
    public void onChangePasswordError(String message) {
        AppTools.hideDialog();

        Sneaker.with(this)
                .setTitle(message)
                .setMessage("")
                .sneakError();

    }

    @Override
    public void onChangePasswordSuccess(ResponseBody response, String message) {


        if (message.equalsIgnoreCase("ok")) {

            try {
                String s = response.string();
                JSONObject jsonObject = new JSONObject(s);
                Toast.makeText(getContext(), jsonObject.getString("message") + "", Toast.LENGTH_SHORT).show();
                AppTools.hideDialog();
                Sneaker.with(this)
                        .setTitle(jsonObject.getString("message"))
                        .setMessage("")
                        .sneakSuccess();

              /*  startActivity(new Intent(getContext(), HomeActivity.class));
                  getActivity().finish();*/
/*


                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


                Fragment dashboardFragment = new HomeFragment();
                fragmentTransaction.replace(R.id.fragment_Container, dashboardFragment);
                fragmentTransaction.commit();
*/


            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }


        }

    }

    @Override
    public void onChangePasswordFailure(Throwable t) {
        AppTools.hideDialog();

        Sneaker.with(this)
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();
    }

}