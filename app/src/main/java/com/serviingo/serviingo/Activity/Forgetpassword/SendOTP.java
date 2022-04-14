package com.serviingo.serviingo.Activity.Forgetpassword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.Activity.Auth.LoginActivity;
import com.serviingo.serviingo.Activity.Auth.SignUpActivity;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.ViewPresenter.ForgetPasword.ForgotPasswordSendOtpPresenter;

import okhttp3.ResponseBody;

import static com.serviingo.serviingo.R.drawable.globalloader;

public class SendOTP extends AppCompatActivity implements ForgotPasswordSendOtpPresenter.ForgotPasswordSendOtpView{


    TextView back,otpContinue,tvCreateAccount;
    EditText etEmail;
    String email;
    ForgotPasswordSendOtpPresenter passwordSendOtpPresenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_o_t_p);
        findView();


    }

    private void findView() {

        back=findViewById(R.id.back);
        etEmail=findViewById(R.id.etEmail);
        otpContinue=findViewById(R.id.otpContinue);
        tvCreateAccount=findViewById(R.id.tvCreateAccount);
        passwordSendOtpPresenter=new ForgotPasswordSendOtpPresenter(this);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SendOTP.this, LoginActivity.class));
            }
        });


        tvCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SendOTP.this, SignUpActivity.class));
            }
        });
        otpContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email=etEmail.getText().toString().trim();
                if (email.isEmpty())
                {
                    Sneaker.with(SendOTP.this)
                            .setTitle("Enter Email / Phone No!")
                            .setMessage("")
                            .sneakError();
                }else {
                    passwordSendOtpPresenter.SendOtp(SendOTP.this,email);

/*

                    startActivity(new Intent(SendOTP.this, OTP_VerificationActivity.class));
                    Toast.makeText(SendOTP.this, email+"", Toast.LENGTH_SHORT).show();
*/

                }

            }
        });

    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        startActivity(new Intent(SendOTP.this, LoginActivity.class));


    }

    @Override
    public void onForgotPasswordSendOtpError(String message) {
        Sneaker.with(this)
                .setTitle(message)
                .setMessage("")
                .sneakError();
    }

    @Override
    public void onForgotPasswordSendOtpSuccess(ResponseBody response, String message) {
        //Toast.makeText(this, message, Toast.LENGTH_LONG).show();


        Toast.makeText(this, "OTP Successfully Send On Your Mobile Number. Please Verify OTP And Reset Your Password.", Toast.LENGTH_LONG).show();
        if (message.equalsIgnoreCase("ok")) {


            startActivity(new Intent(SendOTP.this, OTP_VerificationActivity.class));


        }
      /*  Sneaker.with(getActivity())
                .setTitle(message)
                .setMessage("")
                .sneakError();*/



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
    public void onForgotPasswordSendOtpFailure(Throwable t) {
        Sneaker.with(this)
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();
    }
}