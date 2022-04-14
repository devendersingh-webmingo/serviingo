package com.serviingo.serviingo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.airbnb.lottie.LottieAnimationView;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.serviingo.serviingo.Activity.Auth.LoginActivity;
import com.serviingo.serviingo.Activity.Auth.OtpVerifyActivity;
import com.serviingo.serviingo.Activity.Rating.RatingActivity;
import com.serviingo.serviingo.Common.Preferences;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.storage.SharedPrefManager;
import com.serviingo.serviingo.utils.CheckInternetConnection;
import com.serviingo.serviingo.utils.util;
import com.serviingo.serviingo.view.BaseActivity;

public class SplashScreen extends BaseActivity {
    Preferences pref;
    private static int SPLASH_TIME_OUT = 2700;
    ImageView LinnearLayoutLogo;
    LottieAnimationView animationView;
    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        setContentView(R.layout.splashscreen);
        pref = new Preferences(mActivity);
        LinnearLayoutLogo = findViewById(R.id.LinnearLayoutLogo);
        animationView = findViewById(R.id.animation_view);
        if (SharedPrefManager.getInstance(SplashScreen.this).getFirebaseToken() != null) {
            Log.e("SharedPrefManagedff", SharedPrefManager.getInstance(SplashScreen.this).getFirebaseToken());
        }


        if (util.isOnline(getApplicationContext())) {

            notification();
        } else {

            new CheckInternetConnection(this).checkConnection();


        }


    }

    public void splesh() {

        YoYo.with(Techniques.Bounce)
                .duration(7000)
                .playOn(LinnearLayoutLogo);
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity


                startActivity(new Intent(SplashScreen.this, LoginActivity.class));
                finish();
            }
        }, SPLASH_TIME_OUT);



/*

        new Handler().postDelayed(new Runnable() {

            *//*
         * Showing splash screen with a timer. This will be useful when you
         * want to show case your app logo / company
         *//*

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                startActivity(new Intent(SplashScreen.this, LoginActivity.class));
                finish();
            }
        }, SPLASH_TIME_OUT);*/
    }

    public void notification() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {

            for (String key : bundle.keySet()) {
                String value = "key:- " + key + ", Value:-  " + bundle.get(key) + "";
                Log.e("SplashActivity ", " >> " + value + " <<");


            }

            Intent intent;
            type = bundle.getString("type");
            String id = bundle.getString("id");
            if (type != null) {


                if (type.equals("order-complete")) {
                    // Toast.makeText(this, "Your Trips is Cancel By Driver !!!", Toast.LENGTH_SHORT).show();

                    intent = new Intent(this, RatingActivity.class);
                    intent.putExtra("id", id);
                    startActivity(intent);
                }
           /* else if (type.equals("DRIVER_ACCEPTED_RIDE")) {
                //Toast.makeText(this, "Your Request is Accepted By Driver !!!", Toast.LENGTH_SHORT).show();
                intent = new Intent(this, TripsActivity.class);
                startActivity(intent);
            }
            else if (type.equals("DRIVER_ARRIVED")) {
                //Toast.makeText(this, "Driver Arrived Your Location !!!", Toast.LENGTH_SHORT).show();
                intent = new Intent(this, TripsActivity.class);
                startActivity(intent);
            }*/
                else {
                    splesh();
                }
            } else {
                splesh();
            }


        } else {

            splesh();

        }
    }


}