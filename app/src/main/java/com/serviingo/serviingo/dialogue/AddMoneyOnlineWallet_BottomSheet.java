package com.serviingo.serviingo.dialogue;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.Activity.RazorPay.RazorPaymentActivity;
import com.serviingo.serviingo.Fragments.MyWalletFragment;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.Rtrofit.ApiManager;
import com.serviingo.serviingo.ViewPresenter.TempCart.AddMoneyGetKeyPresenter;
import com.serviingo.serviingo.modelrepo.Responsee.AddAmountResponse;
import com.serviingo.serviingo.modelrepo.Responsee.Razorpay.RazorpayRepo;
import com.serviingo.serviingo.utils.ImagePath;

import org.json.JSONObject;

import java.io.File;
import java.util.Calendar;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;
import static com.serviingo.serviingo.R.drawable.globalloader;

public class AddMoneyOnlineWallet_BottomSheet extends BottomSheetDialogFragment implements AddMoneyGetKeyPresenter.AddMoneyGetKeyView {
    TextView exit, otpContinue;
    EditText EditMoney;
    BottomSheetDialog bottomSheet;
    String Amount;
    AddMoneyGetKeyPresenter presenter;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        bottomSheet = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);


        View view = View.inflate(getContext(), R.layout.add_moneywalletonline, null);
        exit = view.findViewById(R.id.exit);
        otpContinue = view.findViewById(R.id.otpContinue);
        EditMoney = view.findViewById(R.id.EditMoney);
        presenter=new AddMoneyGetKeyPresenter(this);

        bottomSheet.setContentView(view);
        bottomSheet.setCancelable(false);
        bottomSheet.setCanceledOnTouchOutside(false);


        otpContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Amount = EditMoney.getText().toString();

                if (Amount.trim().isEmpty()) {
                    Sneaker.with(getActivity())
                            .setTitle("Amount feild must be required")
                            .setMessage("")
                            .sneakError();
                    Toast.makeText(getContext(), "Amount feild must be required", Toast.LENGTH_SHORT).show();
                } else {

                    presenter.GetRazorPayKey(getContext());

                }

            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheet.dismiss();
            }
        });


        return bottomSheet;
    }


    @Override
    public void AddMoneyGetKeyError(String message) {
        Sneaker.with(getActivity())
                .setTitle(message)
                .setMessage("")
                .sneakError();
    }

    @Override
    public void showHideProgress(boolean isShow) {
        if (isShow) {
            AppTools.showGifDialog(getActivity(), globalloader);

        } else {
            AppTools.hideGifDialog();

        }
    }

    @Override
    public void GetRazorPayKeySuccess(RazorpayRepo response, String message) {
       /* Sneaker.with(getActivity())
                .setTitle(response.getData().getPaymentMethod().getApiKey())
                .setMessage("")
                .sneakError();*/
        if (message.equalsIgnoreCase("ok")) {

            //startPayment(response.getData().getPaymentMethod().getApiKey(), total_amount);


            Intent intent = new Intent(getContext(), RazorPaymentActivity.class);// New activity
            intent.putExtra("ApiKey", response.getData().getPaymentMethod().getApiKey());
            intent.putExtra("order_id", "1");
            intent.putExtra("OrderNumber", "1");
            intent.putExtra("payment_mode", "AddmoneyWallet");


            intent.putExtra("total_amount", Amount);

            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
           // bottomSheet.dismiss();


        }
    }

    @Override
    public void AddMoneyGetKeyFailure(Throwable t) {
        Sneaker.with(getActivity())
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();
    }
}
