package com.serviingo.serviingo.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.Activity.Auth.LoginActivity;
import com.serviingo.serviingo.Adapterr.MyWalletAdapter;
import com.serviingo.serviingo.Common.Preferences;
import com.serviingo.serviingo.ViewPresenter.DoLogoutPresenter;
import com.serviingo.serviingo.ViewPresenter.DoMyWalletPresenter;
import com.serviingo.serviingo.Database.AppSettings;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.dialogue.AddMoneyWallet_BottomSheet;
import com.serviingo.serviingo.modelrepo.Responsee.MywalletRespo;
import com.serviingo.serviingo.storage.SharedPrefManager;
import com.serviingo.serviingo.utils.AppUtils;
import com.serviingo.serviingo.view.BaseActivity;

import okhttp3.ResponseBody;

import static com.serviingo.serviingo.R.drawable.globalloader;

public class MyWalletActivity extends BaseActivity implements View.OnClickListener, DoMyWalletPresenter.DoMyWalletView, DoLogoutPresenter.DoLogoutView {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    MyWalletAdapter walletAdapter;
    ImageView ivback, ivNav, referImageview;
    String pinterest_linklink, facebook_linklink, linkedin_linklink, youtube_linklink, insta_linklink;
    public static ScrollView scrollView;
    TextView tv_home;
    RelativeLayout rlDashBoard, rr_home, rr_category, rr_recharge, rrInsurance,
            rr_About, rr_Contact;
    DoMyWalletPresenter doMyWalletPresenter;
    private DoLogoutPresenter doLogoutPresenter;
    Preferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mywalletactivity);
        findViewById();
        setOnclickistener();

    }

    private void findViewById() {
        AppTools.showGifDialog(mActivity, globalloader);
        doLogoutPresenter = new DoLogoutPresenter(this);
        pref = new Preferences(mActivity);

        tv_home = findViewById(R.id.tv_home);
        ivback = findViewById(R.id.ivBack);
        ivNav = findViewById(R.id.ivNav);
        scrollView = findViewById(R.id.scroll_side_menu);
        rlDashBoard = findViewById(R.id.rlDashBoard);
        rr_home = findViewById(R.id.rr_home);
        rr_category = findViewById(R.id.rr_category);
        rr_recharge = findViewById(R.id.rr_recharge);
        rrInsurance = findViewById(R.id.rrInsurance);
        rr_About = findViewById(R.id.rr_About);
        rr_Contact = findViewById(R.id.rr_Contact);
        doMyWalletPresenter = new DoMyWalletPresenter(this);
        doMyWalletPresenter.DoMyprofil(getApplicationContext());

        recyclerView = findViewById(R.id.recyclerView);

    }

    private void setOnclickistener() {

        tv_home.setOnClickListener(this);
        ivNav.setOnClickListener(this);
        rlDashBoard.setOnClickListener(this);
        rr_home.setOnClickListener(this);
        rr_category.setOnClickListener(this);
        rr_recharge.setOnClickListener(this);
        rrInsurance.setOnClickListener(this);
        rr_About.setOnClickListener(this);
        rr_Contact.setOnClickListener(this);
        ivback.setOnClickListener(this);
    }

    public void ONClick_Add_Money(View view) {
        AddMoneyWallet_BottomSheet addMoneyWallet_bottomSheet = new AddMoneyWallet_BottomSheet();
        addMoneyWallet_bottomSheet.show(getSupportFragmentManager(), addMoneyWallet_bottomSheet.getTag());


    }

    @Override
    public void onDoMyWalleteError(String message) {
        AppTools.hideGifDialog();
        Sneaker.with(this)
                .setTitle(message)
                .setMessage("")
                .sneakError();

    }

    @Override
    public void onDoMyWalletSuccess(MywalletRespo response, String message) {
        AppTools.hideGifDialog();

        if (message.equalsIgnoreCase("ok")) {
            walletAdapter = new MyWalletAdapter(response, getApplicationContext());
            recyclerView.setAdapter(walletAdapter);
            linearLayoutManager = (new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, true));
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setHasFixedSize(true);
        }

    }

    @Override
    public void onDoMyWalletFailure(Throwable t) {
        AppTools.hideGifDialog();
        Sneaker.with(this)
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivNav:
                if (AppSettings.getString(AppSettings.id).isEmpty()) {
                    if (scrollView.getVisibility() == View.VISIBLE) {
                        AppUtils.collapse(scrollView);
                        break;
                    }
                    AppUtils.expand(scrollView);
                } else {
                    if (scrollView.getVisibility() == View.VISIBLE) {
       /*  ivDrop.setVisibility( View.GONE );//scrollView.setVisibility(View.GONE);
         view.setVisibility( View.GONE );*/
                        AppUtils.collapse(scrollView);
                        break;
                    }
    /* ivDrop.setVisibility( View.VISIBLE );
     view.setVisibility( View.VISIBLE );*/
                    AppUtils.expand(scrollView);
                }

                break;
            case R.id.ivBack:
                onBackPressed();
                break;
            case R.id.rlDashBoard:
                //samepage
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.rr_home:
                //My Booking
                startActivity(new Intent(this, MyBookingActivity.class));
                break;
            case R.id.rr_category:
                //My Profile
                startActivity(new Intent(this, ProfileActivity.class));
                break;
            case R.id.rr_recharge:
                //My Wallet
                startActivity(new Intent(this, MyWalletActivity.class));
                break;
            case R.id.rrInsurance:
                //Logout
                AlertDialogBox();

                break;
            case R.id.rr_About:
                startActivity(new Intent(this, AboutUs.class));
                break;
            case R.id.rr_Contact:
                startActivity(new Intent(this, ContactUsActivity.class));
                break;
          /*  case R.id.rr_register:
                startActivity(new Intent(this, SignUpActivity.class));
                break;
            case R.id.rrsignin:
                startActivity(new Intent(this, LoginActivity.class));
                break;*/


        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    public void AlertDialogBox() {

        //Logout
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MyWalletActivity.this);

        // set title
        alertDialogBuilder.setTitle("SERVIINGO");

        // set dialog message
        alertDialogBuilder.setIcon(R.mipmap.logo);
        alertDialogBuilder
                .setMessage("Are you sure to Logout !!!!!")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        doLogoutPresenter.DoLogout(MyWalletActivity.this);

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();

                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }

    @Override
    public void onDoLogoutError(String message) {
        AppTools.hideGifDialog();
        Sneaker.with(this)
                .setTitle(message)
                .setMessage("")
                .sneakError();

    }

    @Override
    public void onDoLogoutSuccess(ResponseBody response, String message) {
        if (message.equalsIgnoreCase("ok")) {
            Toast.makeText(this, "User Logout Successfully.", Toast.LENGTH_SHORT).show();

            SharedPrefManager.getInstans(getApplicationContext()).clear();
            AppSettings.putString(AppSettings.mobile, "");
            AppSettings.putString(AppSettings.loginCheck, "");

            //userprofile data
            AppSettings.putString(AppSettings.id, "");
            AppSettings.putString(AppSettings.name, "");
            AppSettings.putString(AppSettings.email, "");
            AppSettings.putString(AppSettings.gender, "");
            AppSettings.putString(AppSettings.mobile, "");
            AppSettings.putString(AppSettings.wallet, "");
            AppSettings.putString(AppSettings.dob, "");
            AppSettings.putString(AppSettings.user_pic, "");
            AppSettings.putString(AppSettings.referralId, "");
            AppSettings.putString(AppSettings.profilePic, "");

            AppSettings.putString(AppSettings.googleName, "");
            AppSettings.putString(AppSettings.googleEmail, "");
            AppSettings.putString(AppSettings.googledob, "");
            AppSettings.putString(AppSettings.googleId, "");

            AppSettings.putString(AppSettings.fbname, "");
            AppSettings.putString(AppSettings.fbId, "");
            pref.set(AppSettings.loginCheck, "false");
            pref.commit();
            AppTools.hideGifDialog();

            startActivity(new Intent(this, LoginActivity.class));
        }


    }

    @Override
    public void onDoLogoutFailure(Throwable t) {
        AppTools.hideGifDialog();
        Sneaker.with(this)
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();


    }
}
