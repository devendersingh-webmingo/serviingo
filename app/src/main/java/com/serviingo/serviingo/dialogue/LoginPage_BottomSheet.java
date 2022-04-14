package com.serviingo.serviingo.dialogue;

import android.app.Activity;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.firebase.messaging.FirebaseMessaging;
import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.Activity.Auth.LoginActivity;
import com.serviingo.serviingo.Activity.HomeActivity;
import com.serviingo.serviingo.Fragments.AppliencesCareServicesFragment;
import com.serviingo.serviingo.Fragments.CheckOutFragment;
import com.serviingo.serviingo.Fragments.HomeFragment;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.Rtrofit.ApiManager;
import com.serviingo.serviingo.ViewPresenter.UserLoginPresenter;
import com.serviingo.serviingo.modelrepo.Responsee.AddAmountResponse;
import com.serviingo.serviingo.modelrepo.Responsee.LoginRepo;
import com.serviingo.serviingo.modelrepo.Responsee.VandorRepo;
import com.serviingo.serviingo.storage.SharedPrefManager;
import com.serviingo.serviingo.storage.User_login;
import com.serviingo.serviingo.utils.ImagePath;

import org.json.JSONObject;

import java.io.File;
import java.util.Calendar;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;
import static com.serviingo.serviingo.R.drawable.globalloader;

public class LoginPage_BottomSheet extends BottomSheetDialogFragment implements UserLoginPresenter.UserLoginView {

    BottomSheetDialog bottomSheet;
    EditText etEmail,etPassword;
    TextView tvSubmit;

    UserLoginPresenter userLoginPresenter;



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        bottomSheet = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);


        View view = View.inflate(getContext(), R.layout.logindialog, null);
        etEmail=view.findViewById(R.id.etEmail);
        etPassword=view.findViewById(R.id.etPassword);
        tvSubmit=view.findViewById(R.id.tvSubmit);
        bottomSheet.setContentView(view);
        bottomSheet.setCancelable(true);
        bottomSheet.setCanceledOnTouchOutside(true);
        userLoginPresenter=new UserLoginPresenter(this);

        if (SharedPrefManager.getInstance(getActivity()).getFirebaseToken() == null) {
            FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
                @Override
                public void onComplete(@NonNull Task<String> task) {
                    if (task.isSuccessful()) {

                        SharedPrefManager.getInstance(getActivity()).StoreFirebaseToken(task.getResult());

                        // SharedPrefManager.getInstance(getActivity()).storeToken(Devicetoken);

                        // Toast.makeText(getActivity(), Devicetoken + "", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity(), "Devicetoken is not generated", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }

        tvSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DoLogin(getContext());


            }
        });





        return bottomSheet;

    }
    public void DoLogin(Context context) {
        String email=etEmail.getText().toString().trim();
        String pass=etPassword.getText().toString().trim();
        if (email.isEmpty())
        {

            Sneaker.with(getActivity())
                    .setTitle("Enter email or Mobile Number!")
                    .setMessage("")
                    .sneakError();
        }else  if (pass.isEmpty())

        {
            Sneaker.with(getActivity())
                    .setTitle("Enter password !")
                    .setMessage("")
                    .sneakError();
        }else {

            userLoginPresenter.TicketChatList(getContext(),email,pass,SharedPrefManager.getInstance(getActivity()).getFirebaseToken());

        }

    }

    @Override
    public void onVandorRegError(Context context,String message) {
        Sneaker.with((Activity) context)
                .setTitle(message)
                .setMessage("")
                .sneakError();
    }

    @Override
    public void onVandorRegSuccess(LoginRepo response, String message) {
  /*      Sneaker.with(getActivity())
                .setTitle(message)
                .setMessage("")
                .sneakError();*/
        if (message.equalsIgnoreCase("ok"))
        {
            User_login user_login = new User_login(1, String.valueOf(response.data.user.id), response.data.user.name,  response.data.user.mobileNumber, response.data.user.email, response.data.user.role, response.data.accessToken);

            SharedPrefManager.getInstance(getActivity())
                    .saveuser(user_login);
            bottomSheet.dismiss();

          /*  FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Fragment fragment = new AppliencesCareServicesFragment();
*//*
            Bundle args = new Bundle();
            args.putString("id", Id);
            args.putString("payment", payment_method);
            args.putString("Total", Total);
            args.putString("addon_service_ids", addon_service_ids);
            args.putString("SafetyAndHygieneFee", SafetyAndHygieneFee);

            fragment.setArguments(args);
*//*

            fragmentTransaction.replace(R.id.fragment_Container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
*/


            Intent in=new Intent(getContext(), HomeActivity.class);
            in.putExtra("OrderNumber","key");

            startActivity(in);
           // startActivity(new Intent(getActivity(), AppliencesCareServicesFragment.class));
        }
    }


    @Override
    public void showHideProgress(boolean isShow) {
        if (isShow) {
            AppTools.showRequestDialog(getActivity());

        } else {
            AppTools.hideDialog();

        }

    }

    @Override
    public void onVandorRegFailure(Throwable t) {
        Sneaker.with(getActivity())
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();
    }
}
