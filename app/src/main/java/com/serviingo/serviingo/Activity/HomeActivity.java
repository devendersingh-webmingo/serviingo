package com.serviingo.serviingo.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.Activity.Auth.LoginActivity;
import com.serviingo.serviingo.Database.AppSettings;
import com.serviingo.serviingo.Fragments.AboutUsFragment;
import com.serviingo.serviingo.Fragments.AddonesFragment;
import com.serviingo.serviingo.Fragments.AppliencesCareServicesFragment;
import com.serviingo.serviingo.Fragments.ContactUsFragment;
import com.serviingo.serviingo.Fragments.FinancialService.FinacialFragment;
import com.serviingo.serviingo.Fragments.HomeFragment;
import com.serviingo.serviingo.Fragments.MyMemberShipFragment;
import com.serviingo.serviingo.Fragments.MyWalletFragment;
import com.serviingo.serviingo.Fragments.ProfileFragment;
import com.serviingo.serviingo.Fragments.RecentBookingFragment;
import com.serviingo.serviingo.Fragments.SearchFragment;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.ViewPresenter.DoLogoutPresenter;
import com.serviingo.serviingo.storage.SharedPrefManager;
import com.serviingo.serviingo.utils.AppUpdateChecker;
import com.serviingo.serviingo.utils.AppUtils;
import com.serviingo.serviingo.view.BaseActivity;

import okhttp3.ResponseBody;

public class HomeActivity extends BaseActivity implements View.OnClickListener, DoLogoutPresenter.DoLogoutView {
    ImageView logo_Image, iv_menu, ivBack;
    public static ScrollView scrollView;

    RelativeLayout rlDashBoard, rr_home, rr_category, rr_recharge, rrInsurance,
            rr_About, rr_Contact, rr_register, rrsignin, rr_homee;
    LinearLayout beforlogin_LL, afterLogin_LL;
    TextView finacialTV, cartnumbertv;
    ImageView searchIv;


    private DoLogoutPresenter doLogoutPresenter;
    RelativeLayout my_cart;

    String OrderNumber, payment_mode = "check";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        findViewById();

        setOnClickListener();
        if (null == savedInstanceState) {
            if (getIntent().getExtras() == null) {

                if (SharedPrefManager.getInstance(this).isPacakgein() != null) {

                    cartnumbertv.setVisibility(View.VISIBLE);

                    getSupportFragmentManager().beginTransaction()
                            .addToBackStack("AppliencesCareServicesFragment")
                            .replace(R.id.fragment_Container, new AppliencesCareServicesFragment(), "AppliencesCareServicesFragment")
                            .commit();
                }
                else {
                    if (SharedPrefManager.getInstance(this).isLoggedin()) {




                        //code for RecentBookingFragment
                       /* getSupportFragmentManager().beginTransaction()
                                .addToBackStack("RecentBookingFragment")
                                .replace(R.id.fragment_Container, new RecentBookingFragment(), "RecentBookingFragment")
                                .commit();

                        if (SharedPrefManager.getInstance(this).isPacakgein() != null) {

                            cartnumbertv.setVisibility(View.VISIBLE);
                        }*/



                        getSupportFragmentManager().beginTransaction()
                                .addToBackStack("HomeFragment")
                                .replace(R.id.fragment_Container, new HomeFragment(), "HomeFragment")
                                .commit();

                        if (SharedPrefManager.getInstance(this).isPacakgein() != null) {

                            cartnumbertv.setVisibility(View.VISIBLE);
                        }


                    } else {
                        getSupportFragmentManager().beginTransaction()
                                .addToBackStack("HomeFragment")
                                .replace(R.id.fragment_Container, new HomeFragment(), "HomeFragment")
                                .commit();

                        if (SharedPrefManager.getInstance(this).isPacakgein() != null) {

                            cartnumbertv.setVisibility(View.VISIBLE);
                        }

                    }

                }


            } else if (getIntent().getExtras() != null) {
                OrderNumber = getIntent().getStringExtra("OrderNumber");
                payment_mode = getIntent().getStringExtra("payment_mode");
                if (OrderNumber.equalsIgnoreCase("1")) {

                    if (payment_mode.equalsIgnoreCase("BuyMembership")) {
                        getSupportFragmentManager().beginTransaction()
                                .addToBackStack("MyMemberShipFragment")
                                .replace(R.id.fragment_Container, new MyMemberShipFragment(), "MyMemberShipFragment")
                                .commit();
                    } else if (payment_mode.equalsIgnoreCase("AddmoneyWallet")){
                        getSupportFragmentManager().beginTransaction()
                                .addToBackStack("MyWalletFragment")
                                .replace(R.id.fragment_Container, new MyWalletFragment(), "MyWalletFragment")
                                .commit();
                    }

                    if (SharedPrefManager.getInstance(this).isPacakgein() != null) {

                        cartnumbertv.setVisibility(View.VISIBLE);
                    }
                } else if (OrderNumber.equalsIgnoreCase("key")) {
                    getSupportFragmentManager().beginTransaction()
                            .addToBackStack("AppliencesCareServicesFragment")
                            .replace(R.id.fragment_Container, new AppliencesCareServicesFragment(), "AppliencesCareServicesFragment")
                            .commit();
                    if (SharedPrefManager.getInstance(this).isPacakgein() != null) {

                        cartnumbertv.setVisibility(View.VISIBLE);
                    }

                } else {

                    getSupportFragmentManager().beginTransaction()
                            .addToBackStack("AppliencesCareServicesFragment")
                            .replace(R.id.fragment_Container, new AppliencesCareServicesFragment(), "AppliencesCareServicesFragment")
                            .commit();
                    if (SharedPrefManager.getInstance(this).isPacakgein() != null) {

                        cartnumbertv.setVisibility(View.VISIBLE);
                    }

                }
            }

        }

        if (SharedPrefManager.getInstance(this).isLoggedin()) {

            afterLogin_LL.setVisibility(View.VISIBLE);
            rrInsurance.setVisibility(View.VISIBLE);
            beforlogin_LL.setVisibility(View.GONE);

        }

        /*    getSupportFragmentManager().beginTransaction()
                    .addToBackStack("Home")
                    .replace(R.id.fragment_Container, new TimeSlotFragment(), "Home")
                    .commit();
*/

    }


    private void setOnClickListener() {
        iv_menu.setOnClickListener(this);

        rlDashBoard.setOnClickListener(this);
        rr_home.setOnClickListener(this);
        rr_category.setOnClickListener(this);
        rr_recharge.setOnClickListener(this);
        rrInsurance.setOnClickListener(this);
        rr_About.setOnClickListener(this);
        rr_Contact.setOnClickListener(this);
        rr_register.setOnClickListener(this);
        rrsignin.setOnClickListener(this);
        rr_homee.setOnClickListener(this);
        finacialTV.setOnClickListener(this);
        logo_Image.setOnClickListener(this);
        my_cart.setOnClickListener(this);
    }

    private void findViewById() {


        AppUpdateChecker appUpdateChecker = new AppUpdateChecker(this);  //pass the activity in constructure
        appUpdateChecker.checkForUpdate(false); //mannual check false here

        doLogoutPresenter = new DoLogoutPresenter(this);
        logo_Image = findViewById(R.id.iv_menu);
        iv_menu = findViewById(R.id.logo_Image);
        scrollView = findViewById(R.id.scroll_side_menu);
        ivBack = findViewById(R.id.ivBack);
        //ivBack.setVisibility(View.GONE);
        my_cart = findViewById(R.id.my_cart);
        cartnumbertv = findViewById(R.id.cartnumbertv);
        finacialTV = findViewById(R.id.finacialTV);
        searchIv = findViewById(R.id.searchIv);
        rlDashBoard = findViewById(R.id.rlDashBoard);
        rr_home = findViewById(R.id.rr_home);
        rr_category = findViewById(R.id.rr_category);
        rr_recharge = findViewById(R.id.rr_recharge);
        rrInsurance = findViewById(R.id.rrInsurance);
        rr_About = findViewById(R.id.rr_About);
        rr_Contact = findViewById(R.id.rr_Contact);
        rr_register = findViewById(R.id.rr_register);
        rrsignin = findViewById(R.id.rrsignin);
        rr_homee = findViewById(R.id.rr_homee);
        scrollView.setVisibility(View.GONE);
        beforlogin_LL = findViewById(R.id.beforlogin_LL);
        afterLogin_LL = findViewById(R.id.afterLogin_LL);
        searchIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment SearchFragment = new SearchFragment();
                fragmentTransaction.replace(R.id.fragment_Container, SearchFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    @Override
    public void onClick(View v) {
        //  Fragment fragment;
        switch (v.getId()) {
            case R.id.btn_addresssDetails:
                //   updateProfile();

                break;

            case R.id.iv_menu:
                if (AppSettings.getString(AppSettings.id).isEmpty()) {
                    if (scrollView.getVisibility() == View.VISIBLE) {
                        AppUtils.collapse(scrollView);
                        break;
                    }
                    AppUtils.expand(scrollView);
                } else {
                    if (scrollView.getVisibility() == View.VISIBLE) {

                        AppUtils.collapse(scrollView);
                        break;
                    }
                    AppUtils.expand(scrollView);
                }

                break;

            case R.id.rr_homee:
                scrollView.setVisibility(View.GONE);

                Fragment homeFragment = new HomeFragment();
                replaceFragment(homeFragment, "homeFragment");
                //samepage
                //  Toast.makeText(this, "MainActivity", Toast.LENGTH_SHORT).show();
                //startActivity(new Intent(this, MainActivity.class));
                break;

            case R.id.logo_Image:
                scrollView.setVisibility(View.GONE);

                Fragment homeFragmentt = new HomeFragment();
                replaceFragment(homeFragmentt, "homeFragment");
                break;


            case R.id.ivBack:
                // scrollView.setVisibility(View.GONE);
                Fragment homeFragment1 = new HomeFragment();
                replaceFragment(homeFragment1, "homeFragment");

               /* ivBack.setVisibility(View.GONE);
                onBackPressed();*/
                break;
            case R.id.rlDashBoard:
                scrollView.setVisibility(View.GONE);

                Fragment dashboardFragment = new RecentBookingFragment();
                replaceFragment(dashboardFragment, "dashboardFragment");
                //samepage
                //  Toast.makeText(this, "MainActivity", Toast.LENGTH_SHORT).show();
                //startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.rr_home:
                scrollView.setVisibility(View.GONE);

                //My Booking
                Fragment myBooking = new myBooking();
                // Fragment profileFragment = new AddressbookFragment();

                replaceFragment(myBooking, "ProfileFragment");
                scrollView.setVisibility(View.GONE);

                Toast.makeText(this, "MyBookingActivity", Toast.LENGTH_SHORT).show();

                // startActivity(new Intent(this, MyBookingActivity.class));
                break;
            case R.id.rr_category:
                //My Profile
                //Toast.makeText(this, "ProfileActivity", Toast.LENGTH_SHORT).show();

                Fragment profileFragment = new ProfileFragment();
                // Fragment profileFragment = new AddressbookFragment();

                replaceFragment(profileFragment, "ProfileFragment");
                scrollView.setVisibility(View.GONE);

                //  startActivity(new Intent(this, ProfileActivity.class));
                break;
            case R.id.rr_recharge:
                //My Wallet
                scrollView.setVisibility(View.GONE);

                Fragment myWalletFragment = new MyWalletFragment();
                // Fragment myWalletFragment = new ChangePasswordFragment();

                replaceFragment(myWalletFragment, "myWalletFragment");

                // Toast.makeText(this, "MyWalletActivity", Toast.LENGTH_SHORT).show();

                //  startActivity(new Intent(this, MyWalletActivity.class));
                break;
            case R.id.rrInsurance:
                //Logout
                AlertDialogBox();

                break;
            case R.id.rr_About:
                scrollView.setVisibility(View.GONE);

                Fragment aboutUsFragment = new AboutUsFragment();
                replaceFragment(aboutUsFragment, "myWalletFragment");
                break;
            case R.id.rr_Contact:
                scrollView.setVisibility(View.GONE);

                Fragment contactUsFragment = new ContactUsFragment();
                replaceFragment(contactUsFragment, "contactUsFragment");
                // startActivity(new Intent(this, ContactUsActivity.class));
                break;
            case R.id.my_cart:

                if (SharedPrefManager.getInstance(this).isPacakgein() != null) {
                    Fragment appliencesCareServicesFragment = new AppliencesCareServicesFragment();
                    replaceFragment(appliencesCareServicesFragment, "appliencesCareServicesFragment");

                } else {
                    Sneaker.with(this)
                            .setTitle("Your Cart is currently empty.")
                            .setMessage("")
                            .sneakWarning();
                }
                /* scrollView.setVisibility(View.GONE);

                Fragment venderRegFragment = new VenderRegFragment();
                replaceFragment(venderRegFragment, "venderRegFragment");
*/

                break;
            case R.id.rrsignin:
                startActivity(new Intent(this, LoginActivity.class));
                break;

            case R.id.finacialTV:


                scrollView.setVisibility(View.GONE);

                Fragment finacial = new FinacialFragment();
                replaceFragment(finacial, "finacial");


                break;


        }
    }

    public void replaceFragment(Fragment fragment, String tag) {
        //Get current fragment placed in container
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.fragment_Container);

        //Prevent adding same fragment on top
        if (currentFragment.getClass() == fragment.getClass()) {
            return;
        }

        //If fragment is already on stack, we can pop back stack to prevent stack infinite growth
        if (getSupportFragmentManager().findFragmentByTag(tag) != null) {
            getSupportFragmentManager().popBackStack(tag, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }

        //Otherwise, just replace fragment
        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(tag)
                .replace(R.id.fragment_Container, fragment, tag)
                .commit();
    }

    @Override
    public void onBackPressed() {


        int fragmentsInStack = getSupportFragmentManager().getBackStackEntryCount();
        Fragment fr = getSupportFragmentManager().findFragmentById(R.id.fragment_Container);
        String fragmentName = fr.getClass().getSimpleName();
        // Toast.makeText(this, fragmentName+"", Toast.LENGTH_SHORT).show();

        if (fragmentName.equalsIgnoreCase("DashboardFragment")) {

            getSupportFragmentManager().beginTransaction()
                    .addToBackStack("Home")
                    .replace(R.id.fragment_Container, new HomeFragment(), "Home")
                    .commit();

            // Finish activity, if only one fragment left, to prevent leaving empty screen
            //  finish();
        }



        /*else if (fragmentName.equalsIgnoreCase("AppliencesCareServicesFragment")) {

            getSupportFragmentManager().beginTransaction()
                    .addToBackStack("Addones")
                    .replace(R.id.fragment_Container, new AddonesFragment(), "Addones")
                    .commit();

            // Finish activity, if only one fragment left, to prevent leaving empty screen
            //  finish();
        } else if (fragmentName.equalsIgnoreCase("AddonesFragment")) {

            getSupportFragmentManager().beginTransaction()
                    .addToBackStack("HomeFragment")
                    .replace(R.id.fragment_Container, new HomeFragment(), "HomeFragment")
                    .commit();

            // Finish activity, if only one fragment left, to prevent leaving empty screen
            //  finish();
        }*/

        else if (fragmentName.equalsIgnoreCase("CheckOutFragment")) {
            getSupportFragmentManager().beginTransaction()
                    .addToBackStack("HomeFragment")
                    .replace(R.id.fragment_Container, new HomeFragment(), "HomeFragment")
                    .commit();

            // Finish activity, if only one fragment left, to prevent leaving empty screen
            //  finish();
        }

        else if (fragmentName.equalsIgnoreCase("RecentBookingFragment")) {

            getSupportFragmentManager().beginTransaction()
                    .addToBackStack("HomeFragment")
                    .replace(R.id.fragment_Container, new HomeFragment(), "HomeFragment")
                    .commit();

            // Finish activity, if only one fragment left, to prevent leaving empty screen
            //  finish();
        } else if (fragmentsInStack > 1) {

          /*   Fragment homeFragment = new HomeFragment();
             replaceFragment(homeFragment,"homeFragment");*/

            // If we have more than one fragment, pop back stack
            getSupportFragmentManager().popBackStack();

        } else if (fragmentsInStack == 1) {

            // Finish activity, if only one fragment left, to prevent leaving empty screen
            finish();
        } else {
            super.onBackPressed();
        }
    }

    public void AlertDialogBox() {

        //Logout
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        // set title
        alertDialogBuilder.setTitle("SERVIINGO");

        // set dialog message
        alertDialogBuilder.setIcon(R.mipmap.logo);
        alertDialogBuilder
                .setMessage("Are you sure to Logout !!!!!")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        AppUtils.showRequestDialog(HomeActivity.this);

                        doLogoutPresenter.DoLogout(HomeActivity.this);

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
        AppTools.hideDialog();
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
            SharedPrefManager.getInstans(getApplicationContext()).pacakgeClear();
            SharedPrefManager.getInstans(getApplicationContext()).MembsershipClear();
            SharedPrefManager.getInstans(getApplicationContext()).AddonseClear();


            AppTools.hideDialog();

            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }


    }

    @Override
    public void onDoLogoutFailure(Throwable t) {
        AppTools.hideDialog();
        Sneaker.with(this)
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();


    }
}