package com.serviingo.serviingo.Activity.Auth;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.messaging.FirebaseMessaging;
import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.Activity.Forgetpassword.SendOTP;
import com.serviingo.serviingo.Activity.HomeActivity;
import com.serviingo.serviingo.Common.Preferences;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.ViewPresenter.NewLoginProcess.NewUserLoginPresenter;
import com.serviingo.serviingo.ViewPresenter.UserLoginPresenter;
import com.serviingo.serviingo.modelrepo.Responsee.LoginRepo;
import com.serviingo.serviingo.storage.SharedPrefManager;
import com.serviingo.serviingo.storage.User_login;
import com.serviingo.serviingo.utils.CheckInternetConnection;
import com.serviingo.serviingo.utils.util;
import com.serviingo.serviingo.view.BaseActivity;

import okhttp3.ResponseBody;

import static com.rjesture.startupkit.AppTools.getTextInputEditTextData;
import static com.serviingo.serviingo.R.drawable.globalloader;

public class LoginActivity extends BaseActivity implements View.OnClickListener, NewUserLoginPresenter.UserLoginView {
    private static final int RC_SIGN_IN = 1001;
    public static TextView tvMessage;
    GoogleSignInClient googleSignInClient;
    EditText etPassword, etEmail;
    LinearLayout tvgoogleplus;
    TextView tvskip, sendotptv, passwordtv, loginwithemailtv, withhPasswordTv, withotp, signupTv;
    private FirebaseAuth firebaseAuth;
    Preferences pref;
    NewUserLoginPresenter userLoginPresenter;

    private ViewFlipper viewFlipper;
    EditText ET_Mobile;
    TextView tvForgetPassword, tv_termsCond, tv_policy;
    String Devicetoken;
    String key="",phone;

    // private CallbackManager callbackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivity);
        //callbackManager = CallbackManager.Factory.create();

        setui();
        util.checkDexter(LoginActivity.this);





/*
        User_login user_login = new User_login(1, id, name, mobile_number, email, role, access_token);

        SharedPrefManager.getInstance(this)
                .saveuser(user_login);
        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
*/

    }


    private void setui() {
        userLoginPresenter = new NewUserLoginPresenter(this);
        tvskip = findViewById(R.id.tvskip);
        sendotptv = findViewById(R.id.sendotptv);
        tvForgetPassword = findViewById(R.id.tvForgetPassword);
        passwordtv = findViewById(R.id.passwordtv);
        loginwithemailtv = findViewById(R.id.loginwithemailtv);
        withhPasswordTv = findViewById(R.id.withhPasswordTv);
        ET_Mobile = findViewById(R.id.ET_Mobile);
        withotp = findViewById(R.id.withotp);
        signupTv = findViewById(R.id.signupTv);
        etEmail = findViewById(R.id.etEmail);
        tv_termsCond = findViewById(R.id.tv_termsCond);
        etPassword = findViewById(R.id.etPassword);
        tv_policy = findViewById(R.id.tv_policy);
        viewFlipper = findViewById(R.id.viewflipper_registration);
        viewFlipper.setDisplayedChild(0);


        //  setOnClickListener();
        pref = new Preferences(mActivity);
        setOnClickListener();

        if (getIntent() != null) {

             key = getIntent().getStringExtra("Key");
           // Toast.makeText(this, key + "", Toast.LENGTH_SHORT).show();
            if (key!=null)
            {
                viewFlipper.setDisplayedChild(1);

            }

        }

        if (SharedPrefManager.getInstance(this).getFirebaseToken() == null) {
            FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
                @Override
                public void onComplete(@NonNull Task<String> task) {
                    if (task.isSuccessful()) {

                        Devicetoken = task.getResult();
                        SharedPrefManager.getInstance(LoginActivity.this).StoreFirebaseToken(Devicetoken);

                        // SharedPrefManager.getInstance(getActivity()).storeToken(Devicetoken);
                        Log.d("Devicetoken", Devicetoken);

                        // Toast.makeText(getActivity(), Devicetoken + "", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(LoginActivity.this, "Devicetoken is not generated", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }


     /*   if (SharedPrefManager.getInstance(this).getFirebaseToken()==null) {
            FirebaseInstanceId.getInstance().getInstanceId()
                    .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                        @Override
                        public void onComplete(@NonNull Task<InstanceIdResult> task) {
                            if (task.isSuccessful()) {

                               String Devicetoken = task.getResult().getToken();
                                SharedPrefManager.getInstance(LoginActivity.this).StoreFirebaseToken(Devicetoken);
                                Log.d("Devicetoken", Devicetoken);
                             //   performLogin(Devicetoken);

                                // Toast.makeText(getActivity(), Devicetoken + "", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(LoginActivity.this, "Devicetoken is not generated", Toast.LENGTH_SHORT).show();
                            }


                        }
                    });
        }else {
            //   performLogin(SharedPrefManager.getInstance(getActivity()).getAccess_Token());

        }
*/

    }


    private void setOnClickListener() {
//        tvgoogleplus.setOnClickListener(this);

        tvskip.setOnClickListener(this);
        sendotptv.setOnClickListener(this);
        passwordtv.setOnClickListener(this);
        loginwithemailtv.setOnClickListener(this);
        withhPasswordTv.setOnClickListener(this);
        withotp.setOnClickListener(this);
        signupTv.setOnClickListener(this);
        tvForgetPassword.setOnClickListener(this);
        tv_termsCond.setOnClickListener(this);

        tv_policy.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sendotptv:


                if (!util.isNetworkConnected(this.getApplicationContext())) {

                    Sneaker.with(this)
                            .setTitle("No Internet, Reconnect and Retry !")
                            .setMessage("")
                            .sneakWarning();


                } else {
                    DoLoginWithOTP();
                }


                break;

            case R.id.passwordtv:
                viewFlipper.setDisplayedChild(1);

                break;
            case R.id.tvskip:
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));

                break;
            case R.id.loginwithemailtv:
                viewFlipper.setDisplayedChild(1);
                break;
            case R.id.withhPasswordTv:

                if (!util.isNetworkConnected(this.getApplicationContext())) {
                    Sneaker.with(this)
                            .setTitle("No Internet, Reconnect and Retry !")
                            .setMessage("")
                            .sneakWarning();

                } else {
                    DoLogin();
                }

                break;
            case R.id.withotp:

                viewFlipper.setDisplayedChild(0);
                break;
            case R.id.signupTv:
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));

                break;
            case R.id.tvForgetPassword:
                startActivity(new Intent(LoginActivity.this, SendOTP.class));

                break;
            case R.id.tv_termsCond:


                String url = "https://www.serviingo.com/home/terms";
             /*   Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                // Verify that the intent will resolve to an activity
                if (intent.resolveActivity(getPackageManager()) != null) {
                    // Here we use an intent without a Chooser unlike the next example
                    startActivity(intent);
                }

*/



     /*   Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        // Verify that the intent will resolve to an activity
        if (intent.resolveActivity(getContext().getPackageManager()) != null) {
            // Here we use an intent without a Chooser unlike the next example
            startActivity(intent);
        }
*/

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setPackage("com.android.chrome");
                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException ex) {
                    // Chrome browser presumably not installed so allow user to choose instead
                    intent.setPackage(null);
                    startActivity(intent);
                }


                break;

            case R.id.tv_policy:
                String urll = "https://www.serviingo.com/home/privacy";


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


/*
                Uri urii = Uri.parse(urll);
                Intent intentt = new Intent(Intent.ACTION_VIEW, urii);
                // Verify that the intent will resolve to an activity
                if (intentt.resolveActivity(getPackageManager()) != null) {
                    // Here we use an intent without a Chooser unlike the next example
                    startActivity(intentt);
                }*/


                break;
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        if (SharedPrefManager.getInstance(this).isLoggedin()) {
            Intent intent = new Intent(this, HomeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        //check Internet Connection

        new CheckInternetConnection(this).checkConnection();
    }


    @Override
    public void onUserLoginError(Context context, String message) {
        Sneaker.with((Activity) context)
                .setTitle(message)
                .setMessage("")
                .sneakError();
    }

    @Override
    public void onUserLoginSuccess(LoginRepo response, String message) {

        if (message.equalsIgnoreCase("ok")) {
            User_login user_login = new User_login(1, String.valueOf(response.data.user.id), response.data.user.name, response.data.user.mobileNumber, response.data.user.email, response.data.user.role, response.data.accessToken);

            SharedPrefManager.getInstance(this)
                    .saveuser(user_login);

            startActivity(new Intent(LoginActivity.this, HomeActivity.class));


            // startActivity(new Intent(getActivity(), AppliencesCareServicesFragment.class));
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



            Intent in = new Intent(LoginActivity.this, OtpVerifyActivity.class);
            in.putExtra("phone", phone);
            startActivity(in);
            finish();


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
    public void onUserLoginFailure(Throwable t) {
        Sneaker.with(this)
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();
    }


    public void DoLogin() {
        String email = etEmail.getText().toString().trim();
        String pass = etPassword.getText().toString().trim();
        if (email.isEmpty()) {

            Sneaker.with(this)
                    .setTitle("Enter email or Mobile Number!")
                    .setMessage("")
                    .sneakError();
        } else if (pass.isEmpty()) {
            Sneaker.with(this)
                    .setTitle("Enter password !")
                    .setMessage("")
                    .sneakError();
        } else {

            userLoginPresenter.UserLogin(this, email, pass, SharedPrefManager.getInstance(this).getFirebaseToken());

        }

    }

    public void DoLoginWithOTP() {
         phone = ET_Mobile.getText().toString().trim();
        if (phone.isEmpty()) {

            Sneaker.with(this)
                    .setTitle("Enter  Mobile Number!")
                    .setMessage("")
                    .sneakError();
        } else {

            userLoginPresenter.UserLoginWithNumberSendOTP(this, phone);

        }

    }

}
