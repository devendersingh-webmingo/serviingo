package com.serviingo.serviingo.Activity.Auth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.chaos.view.PinView;
import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.ViewPresenter.NewLoginProcess.OTPVeriviedPresenter;
import com.serviingo.serviingo.ViewPresenter.UserRegisterPresenter;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.modelrepo.request.UserReg_Request;
import com.serviingo.serviingo.utils.CheckInternetConnection;
import com.serviingo.serviingo.utils.util;
import com.serviingo.serviingo.view.BaseActivity;

import okhttp3.ResponseBody;

import static com.serviingo.serviingo.R.drawable.globalloader;

public class SignUpActivity extends BaseActivity implements View.OnClickListener, UserRegisterPresenter.UserRegisterView {

    private ViewFlipper viewFlipper;

    TextView tvSignup, withhsendnewotpTv, passwordtv;
    EditText etName, etEmail, etPhoneNumber, etPassword, etConfirmPassword, etReferralId, numberEd;
    UserRegisterPresenter userRegisterPresenter;


    PinView pinView;
    TextView otpverifying, passwordlogin, withSignin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signupactivity);
        setui();

    }

    private void setui() {

        pinView = findViewById(R.id.pinview);
        otpverifying = findViewById(R.id.otpverifying);
        passwordlogin = findViewById(R.id.passwordlogin);
        withSignin = findViewById(R.id.withSignin);
        passwordtv = findViewById(R.id.passwordtv);
        viewFlipper = findViewById(R.id.viewflipper_registration);
        viewFlipper.setDisplayedChild(0);
        withhsendnewotpTv = findViewById(R.id.withhsendnewotpTv);
        tvSignup = findViewById(R.id.tvSignup);
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        etPhoneNumber.setEnabled(false);

        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        etReferralId = findViewById(R.id.etReferralId);
        numberEd = findViewById(R.id.numberEd);
        userRegisterPresenter = new UserRegisterPresenter(this);
        onClickListener();


    }

    private void onClickListener() {

        tvSignup.setOnClickListener(this);
        withhsendnewotpTv.setOnClickListener(this);
        withSignin.setOnClickListener(this);
        otpverifying.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvSignup:
                if (etName.getText().toString().trim().isEmpty()) {
                    Sneaker.with(this)
                            .setTitle("Enter your  name!")
                            .setMessage("")
                            .sneakError();
                } else if (etEmail.getText().toString().trim().isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(etEmail.getText().toString().trim()).matches()) {
                    Sneaker.with(this)
                            .setTitle("Enter your email!")
                            .setMessage("")
                            .sneakError();
                } else if (etPhoneNumber.getText().toString().length() != 10) {
                    Sneaker.with(this)
                            .setTitle("Please enter your 10 digit of mobile!")
                            .setMessage("")
                            .sneakError();
                } else if (etPassword.getText().toString().trim().isEmpty()) {
                    Sneaker.with(this)
                            .setTitle("Enter your password!")
                            .setMessage("")
                            .sneakError();
                } else if (etPassword.getText().toString().trim().length() < 6) {
                    Sneaker.with(this)
                            .setTitle("The password must be at least 6 characters!")
                            .setMessage("")
                            .sneakError();
                } else if (!etConfirmPassword.getText().toString().trim().equals(etPassword.getText().toString().trim())) {
                    Sneaker.with(this)
                            .setTitle("confirm password not match!")
                            .setMessage("")
                            .sneakError();
                } else {


                    if (util.isOnline(getApplicationContext())) {
                        // Success

                        UserReg_Request userReg_request = new UserReg_Request(etReferralId.getText().toString().trim(), etName.getText().toString().trim(), etEmail.getText().toString().trim(),
                                etPhoneNumber.getText().toString().trim(), etPassword.getText().toString().trim(),
                                etConfirmPassword.getText().toString().trim());
                        userRegisterPresenter.UserRegisterPresenter(userReg_request);

                    } else {

                        Sneaker.with(this)
                                .setTitle(getResources().getString(R.string.noconnection))
                                .setMessage("")
                                .sneakError();
                        // Display Toast
                    }

                    ///
                }
                break;


            case R.id.withhsendnewotpTv:


                if (!util.isNetworkConnected(this.getApplicationContext())) {
                    Sneaker.with(this)
                            .setTitle("No Internet, Reconnect and Retry !")
                            .setMessage("")
                            .sneakWarning();

                } else {
                    DoLoginWithOTP();
                }


                break;
            case R.id.withSignin:

                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                finishAffinity();
                break;
            case R.id.otpverifying:

                String otp = pinView.getText().toString();
                if (otp.length() < 4) {
                    Sneaker.with(SignUpActivity.this)
                            .setTitle("Enter OTP!")
                            .setMessage("")
                            .sneakError();


                } else {


                    if (!util.isNetworkConnected(this.getApplicationContext())) {
                        Sneaker.with(this)
                                .setTitle("No Internet, Reconnect and Retry !")
                                .setMessage("")
                                .sneakWarning();

                    } else {
                        userRegisterPresenter.OTPVerivied(SignUpActivity.this, otp);

                    }


                }
                break;

            case R.id.passwordtv:

                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                finishAffinity();
                break;

        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View view = getCurrentFocus();
        if (view != null && (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE) && view instanceof EditText && !view.getClass().getName().startsWith("android.webkit.")) {
            int scrcoords[] = new int[2];
            view.getLocationOnScreen(scrcoords);
            float x = ev.getRawX() + view.getLeft() - scrcoords[0];
            float y = ev.getRawY() + view.getTop() - scrcoords[1];
            if (x < view.getLeft() || x > view.getRight() || y < view.getTop() || y > view.getBottom())
                ((InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow((this.getWindow().getDecorView().getApplicationWindowToken()), 0);
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //check Internet Connection

        new CheckInternetConnection(this).checkConnection();
    }

    @Override
    public void onUserRegisterError(String message) {

        Sneaker.with(this)
                .setTitle(message)
                .setMessage("")
                .sneakError();

    }

    @Override
    public void onUserRegisterSuccess(ResponseBody response, String message) {
        if (message.equalsIgnoreCase("ok")) {
            Log.e("onUserRegisterSuccess", message);
            Intent in = new Intent(SignUpActivity.this, LoginActivity.class);
            startActivity(in);
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
    public void onUserWithsenotpSuccess(ResponseBody response, String message) {

        if (message.equalsIgnoreCase("ok")) {
            Sneaker.with(this)
                    .setTitle("OTP Successfully Send On Your Registered Mobile Number.")
                    .setMessage("")
                    .sneakSuccess();
            Toast.makeText(this, "OTP Successfully Send On Your Registered Mobile Number.", Toast.LENGTH_LONG).show();
            viewFlipper.setDisplayedChild(1);

        }


    }

    @Override
    public void onOTPVeriviedNewuserSuccess(ResponseBody response, String message) {
        if (message.equalsIgnoreCase("ok")) {
            Sneaker.with(this)
                    .setTitle("Your Mobile Number Successfully Verified.")
                    .setMessage("")
                    .sneakSuccess();
            Toast.makeText(this, "Your Mobile Number Successfully Verified.", Toast.LENGTH_LONG).show();
            viewFlipper.setDisplayedChild(2);

        }

    }

    @Override
    public void onUserRegisterFailure(Throwable t) {
        Log.e("onUserRegisterFailure", t.getLocalizedMessage());

        Sneaker.with(this)
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();
    }

    public void OnClick_Login(View view) {

        startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
    }

    public void DoLoginWithOTP() {
        String phone = numberEd.getText().toString().trim();
        if (phone.isEmpty()) {

            Sneaker.with(this)
                    .setTitle("Enter  Mobile Number!")
                    .setMessage("")
                    .sneakError();
        } else {
            etPhoneNumber.setText(phone);
            userRegisterPresenter.UserLoginWithnewNumberSendOTP(SignUpActivity.this, phone);


        }

    }



}
