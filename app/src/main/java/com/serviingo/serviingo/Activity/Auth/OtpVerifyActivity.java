package com.serviingo.serviingo.Activity.Auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.Activity.Forgetpassword.CratePasswordActivity;
import com.serviingo.serviingo.Activity.Forgetpassword.OTP_VerificationActivity;
import com.serviingo.serviingo.Activity.HomeActivity;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.ViewPresenter.ForgetPasword.VerifyOtpPresenter;
import com.serviingo.serviingo.ViewPresenter.NewLoginProcess.OTPVeriviedPresenter;
import com.serviingo.serviingo.modelrepo.Responsee.LoginRepo;
import com.serviingo.serviingo.storage.SharedPrefManager;
import com.serviingo.serviingo.storage.User_login;
import com.serviingo.serviingo.utils.util;

import static com.serviingo.serviingo.R.drawable.globalloader;

import okhttp3.ResponseBody;

public class OtpVerifyActivity extends AppCompatActivity implements OTPVeriviedPresenter.OTPVeriviedView {
    PinView pinView;
    TextView otpverifying, passwordlogin,resendotp;
    OTPVeriviedPresenter presenter;
    String phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verify);
        findView();
    }

    private void findView() {
        presenter = new OTPVeriviedPresenter(this);
        pinView = findViewById(R.id.pinview);
        otpverifying = findViewById(R.id.otpverifying);
        passwordlogin = findViewById(R.id.passwordlogin);
        resendotp= findViewById(R.id.resendotp);


        if (getIntent() != null) {

            phone = getIntent().getStringExtra("phone");


        }

        if (SharedPrefManager.getInstance(OtpVerifyActivity.this).getFirebaseToken() == null) {
            FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
                @Override
                public void onComplete(@NonNull Task<String> task) {
                    if (task.isSuccessful()) {

                        SharedPrefManager.getInstance(OtpVerifyActivity.this).StoreFirebaseToken(task.getResult());

                        // SharedPrefManager.getInstance(getActivity()).storeToken(Devicetoken);

                        // Toast.makeText(getActivity(), Devicetoken + "", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(OtpVerifyActivity.this, "Devicetoken is not generated", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }


        passwordlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent in = new Intent(OtpVerifyActivity.this, LoginActivity.class);
                in.putExtra("Key", "LoginWithPassword");
                startActivity(in);
                finish();

            }
        });



        resendotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!util.isNetworkConnected(OtpVerifyActivity.this)) {

                    Sneaker.with(OtpVerifyActivity.this)
                            .setTitle("No Internet, Reconnect and Retry !")
                            .setMessage("")
                            .sneakWarning();

                } else {
                    presenter.UserLoginWithNumberSendOTP(OtpVerifyActivity.this,phone);

                }




            }
        });
        otpverifying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String otp = pinView.getText().toString();
                if (otp.length() < 4) {
                    Sneaker.with(OtpVerifyActivity.this)
                            .setTitle("Enter OTP!")
                            .setMessage("")
                            .sneakError();


                } else {

                    if (!util.isNetworkConnected(OtpVerifyActivity.this)) {

                        Sneaker.with(OtpVerifyActivity.this)
                                .setTitle("No Internet, Reconnect and Retry !")
                                .setMessage("")
                                .sneakWarning();

                    } else {
                        presenter.OTPVerivied(OtpVerifyActivity.this, otp, SharedPrefManager.getInstance(OtpVerifyActivity.this).getFirebaseToken());

                    }


                }

            }
        });

    }

    @Override
    public void onOTPVeriviedError(Context context, String message) {
        Sneaker.with((Activity) context)
                .setTitle(message)
                .setMessage("")
                .sneakError();
    }

    @Override
    public void onOTPVeriviedSuccess(LoginRepo response, String message) {
        if (message.equalsIgnoreCase("ok")) {
            User_login user_login = new User_login(1, String.valueOf(response.data.user.id), response.data.user.name, response.data.user.mobileNumber, response.data.user.email, response.data.user.role, response.data.accessToken);

            SharedPrefManager.getInstance(this)
                    .saveuser(user_login);

            startActivity(new Intent(OtpVerifyActivity.this, HomeActivity.class));
            finish();


            // startActivity(new Intent(getActivity(), AppliencesCareServicesFragment.class));
        }
    }

    @Override
    public void showHideProgress(boolean isShow) {
        if (isShow) {
            AppTools.showRequestDialog(this);


        } else {
            AppTools.hideDialog();

        }
    }

    @Override
    public void onUserLoginWithTOPSuccess(ResponseBody response, String message) {
        if (message.equalsIgnoreCase("ok")) {
            Sneaker.with(this)
                    .setTitle("OTP Successfully Send On Your Registered Mobile Number.")
                    .setMessage("")
                    .sneakSuccess();
            Toast.makeText(this, "OTP Successfully Send On Your Registered Mobile Number.", Toast.LENGTH_LONG).show();

        }
    }

    @Override
    public void onOTPVeriviedFailure(Throwable t) {
        Sneaker.with(this)
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();
    }
}