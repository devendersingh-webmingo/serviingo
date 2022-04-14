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
import com.serviingo.serviingo.ViewPresenter.ForgetPasword.ResetPasswordPresenter;

import okhttp3.ResponseBody;

import static com.serviingo.serviingo.R.drawable.globalloader;

public class CratePasswordActivity extends AppCompatActivity implements ResetPasswordPresenter.ResetPasswordView {

    EditText confirmpassword, password;
    TextView otpContinue, tvCreateAccount;

    String passwordd, Cpasswordd;
    String user_id, otp;
    ResetPasswordPresenter passwordPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crate_password);
        findView();


    }

    private void findView() {

        confirmpassword = findViewById(R.id.confirmpassword);
        password = findViewById(R.id.password);
        otpContinue = findViewById(R.id.otpContinue);
        tvCreateAccount = findViewById(R.id.tvCreateAccount);
        passwordPresenter = new ResetPasswordPresenter(this);
        //  verifyOtpResponse  = (VerifyOtpResponse) i.getSerializableExtra("response");

        if (getIntent() != null) {
            user_id = getIntent().getStringExtra("user_id");
            otp = getIntent().getStringExtra("otp");
            Toast.makeText(this, user_id+otp+"", Toast.LENGTH_SHORT).show();

        }
        tvCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CratePasswordActivity.this, SignUpActivity.class));

            }
        });

        otpContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                passwordd = password.getText().toString();
                Cpasswordd = confirmpassword.getText().toString();

                if (passwordd.length() < 6) {
                    Sneaker.with(CratePasswordActivity.this)
                            .setTitle("The password must be at least 6 characters!")
                            .setMessage("")
                            .sneakError();


                } else if (!passwordd.equals(Cpasswordd)) {

                    Sneaker.with(CratePasswordActivity.this)
                            .setTitle("Confirm password not match")
                            .setMessage("")
                            .sneakError();

                } else {

                    passwordPresenter.ResetPassword(CratePasswordActivity.this, user_id, otp, passwordd, Cpasswordd);

                }


            }
        });

    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        startActivity(new Intent(CratePasswordActivity.this, SendOTP.class));


    }

    @Override
    public void onResetPasswordError(String message) {
        Sneaker.with(CratePasswordActivity.this)
                .setTitle(message)
                .setMessage("")
                .sneakSuccess();
    }

    @Override
    public void onResetPasswordSuccess(ResponseBody response, String message) {
        if (message.equalsIgnoreCase("ok")) {
            Toast.makeText(this, "Your new password successfully created, please login your account.", Toast.LENGTH_LONG).show();


            startActivity(new Intent(CratePasswordActivity.this, LoginActivity.class));

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
    public void onResetPasswordFailure(Throwable t) {
        Sneaker.with(CratePasswordActivity.this)
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakSuccess();
    }
}