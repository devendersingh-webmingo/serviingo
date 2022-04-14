package com.serviingo.serviingo.Activity.Forgetpassword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.ViewPresenter.ForgetPasword.VerifyOtpPresenter;
import com.serviingo.serviingo.modelrepo.Responsee.VerifyOtpResponse;

import static com.serviingo.serviingo.R.drawable.globalloader;

public class OTP_VerificationActivity extends AppCompatActivity implements VerifyOtpPresenter.VerifyOtpView {
    PinView pinView;
    TextView resendotp, otpContinue;
    VerifyOtpPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_t_p__verification);
        findView();

    }

    private void findView() {

        pinView = findViewById(R.id.pinview);
        resendotp = findViewById(R.id.resendotp);
        otpContinue = findViewById(R.id.otpContinue);
        presenter = new VerifyOtpPresenter(this);

        otpContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String otp = pinView.getText().toString();
                if (otp.length() < 4) {
                    Sneaker.with(OTP_VerificationActivity.this)
                            .setTitle("Enter OTP!")
                            .setMessage("")
                            .sneakError();


                } else {
                    presenter.VerifyOtp(OTP_VerificationActivity.this, otp);


                }

            }
        });

    }

    @Override
    public void onVerifyOtpError(String message) {
        Sneaker.with(this)
                .setTitle(message)
                .setMessage("")
                .sneakError();
    }

    @Override
    public void onVerifyOtpSuccess(VerifyOtpResponse response, String message) {
        if (message.equalsIgnoreCase("ok")) {


            Toast.makeText(this, response.getMessage(), Toast.LENGTH_LONG).show();

            //   startActivity(new Intent(OTP_VerificationActivity.this, CratePasswordActivity.class));
            Intent in = new Intent(OTP_VerificationActivity.this, CratePasswordActivity.class);
            in.putExtra("user_id", String.valueOf(response.getData().getVerifyContent().getUserId()));
            in.putExtra("otp", response.getData().getVerifyContent().getOtp());
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
    public void onVerifyOtpFailure(Throwable t) {
        Sneaker.with(this)
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();
    }
}