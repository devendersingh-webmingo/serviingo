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
import com.serviingo.serviingo.Fragments.HomeFragment;
import com.serviingo.serviingo.Fragments.MyWalletFragment;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.Rtrofit.ApiClientt;
import com.serviingo.serviingo.Rtrofit.ApiManager;
import com.serviingo.serviingo.modelrepo.Responsee.AddAmountResponse;
import com.serviingo.serviingo.utils.ImagePath;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.Part;

import static android.app.Activity.RESULT_OK;

public class AddMoneyWallet_BottomSheet extends BottomSheetDialogFragment {
    TextView exit;
    TextView startDate,Tv_UploadImage;
    Spinner Sp_Payment_Method, Sp_Payment_Mode;
    String[] Payment_Method = {"Select Payment Method", "Offline", "Online"};//array of strings used to populate the spinner
    String[] Payment_Mode = {"Select Payment Mode", "Cheque/DD", "Net Banking", "UPI", "Paytm"};//array of strings used to populate the spinner

    LinearLayout LL_Offline, LL_checkDD, LL_NotcheckDD,LL_UPI,LL_Paytm;
    EditText Ed_Utrno, Ed_amount, ed_checkNo, Ed_Bankname, Ed_bank_branch,Ed_ref_id,Ed_Paytm;
    TextView Continue;
    BottomSheetDialog bottomSheet;


    String amount, payment_mode, paymet_of_mode = "87", checkNo, cheque_date, bank_name, bank_branch,utrNO,ref_id,Paytm;

    String paymentSS="",imageref_id="",imagePaytm="";

    private static final int PICK_IMAGE = 100;
    Uri imageUri;
    String path = "null";
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        bottomSheet = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);


        View view = View.inflate(getContext(), R.layout.add_moneywallet, null);
        exit = view.findViewById(R.id.exit);
        startDate = view.findViewById(R.id.startDate);
        Tv_UploadImage = view.findViewById(R.id.Tv_UploadImage);
        Sp_Payment_Method = view.findViewById(R.id.Sp_Payment_Method);
        Sp_Payment_Mode = view.findViewById(R.id.Sp_Payment_Mode);
        LL_Offline = view.findViewById(R.id.LL_Offline);
        LL_checkDD = view.findViewById(R.id.LL_checkDD);
        LL_NotcheckDD = view.findViewById(R.id.LL_NotcheckDD);
        LL_UPI= view.findViewById(R.id.LL_UPI);
        LL_Paytm= view.findViewById(R.id.LL_Paytm);
        Ed_Utrno = view.findViewById(R.id.Ed_UTR);
        Ed_amount = view.findViewById(R.id.Ed_amount);
        Continue = view.findViewById(R.id.Continue);
        ed_checkNo = view.findViewById(R.id.ed_checkNo);
        Ed_Bankname = view.findViewById(R.id.Ed_Bankname);
        Ed_bank_branch = view.findViewById(R.id.Ed_bank_branch);
        Ed_ref_id = view.findViewById(R.id.Ed_ref_id);
        Ed_Paytm= view.findViewById(R.id.Ed_Paytm);


        bottomSheet.setContentView(view);
        bottomSheet.setCancelable(false);
        bottomSheet.setCanceledOnTouchOutside(false);



        if (!ImagePath.checkPermissionss(getContext())) {
            ImagePath.requestPermission(getActivity());
        }
        ArrayAdapter<String> aa = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, Payment_Method);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//Setting the ArrayAdapter data on the Spinner
        Sp_Payment_Method.setAdapter(aa);
        Sp_Payment_Method.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getActivity(), position + "", Toast.LENGTH_SHORT).show();
                if (position == 0) {
                    LL_Offline.setVisibility(View.GONE);
                    LL_Offline.setVisibility(View.GONE);
                    LL_NotcheckDD.setVisibility(View.GONE);
                    Tv_UploadImage.setVisibility(View.GONE);
                    Continue.setVisibility(View.GONE);
                    LL_UPI.setVisibility(View.GONE);
                    LL_Paytm.setVisibility(View.GONE);
                } else if (position == 1) {
                    OfflinePay();
                    payment_mode = "1";
                } else if (position == 2) {

                    payment_mode = "2";
                    OnlinePay();
                }

                //  Toast.makeText(getActivity(), parent.getItemAtPosition(position).toString().trim()+"", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheet.dismiss();
            }
        });


        startDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPickerDialog();
            }
        });


        Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DoAddAmount(getContext());

            }
        });

        Tv_UploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(gallery, PICK_IMAGE);
            }
        });

        return bottomSheet;
    }

    private void OnlinePay() {


        LL_Offline.setVisibility(View.GONE);
        LL_NotcheckDD.setVisibility(View.GONE);
        Continue.setVisibility(View.VISIBLE);
        Tv_UploadImage.setVisibility(View.GONE);

        LL_UPI.setVisibility(View.GONE);
        LL_Paytm.setVisibility(View.GONE);



    }

    private void showPickerDialog() {

        DatePickerDialog dtPickerDlg = new DatePickerDialog(getContext(), android.R.style.Theme_Holo_Dialog, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar c = Calendar.getInstance();
                c.set(Calendar.YEAR, year);
                c.set(Calendar.MONTH, month);
                c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String mDate = DateFormat.format("yyyy-MM-dd", c).toString();
                startDate.setText(mDate);
            }
        }, 2020, 01, 01);
        dtPickerDlg.getDatePicker().setSpinnersShown(true);
        dtPickerDlg.getDatePicker().setCalendarViewShown(false);
        dtPickerDlg.setTitle("Select Cheque Date");
        dtPickerDlg.show();
    }


    private void OfflinePay() {
        LL_Offline.setVisibility(View.VISIBLE);


        ArrayAdapter<String> aa = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, Payment_Mode);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//Setting the ArrayAdapter data on the Spinner
        Sp_Payment_Mode.setAdapter(aa);
        Sp_Payment_Mode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getActivity(), position + "", Toast.LENGTH_SHORT).show();
                if (position == 0) {
                    LL_checkDD.setVisibility(View.GONE);
                    LL_NotcheckDD.setVisibility(View.GONE);
                    Continue.setVisibility(View.GONE);
                    LL_UPI.setVisibility(View.GONE);
                    LL_Paytm.setVisibility(View.GONE);
                    Tv_UploadImage.setVisibility(View.GONE);



                } else if (position == 1) {
                    Cheekdd();
                    paymet_of_mode = "1";

                } else if (position == 2) {
                    NetBanking();
                    paymet_of_mode = "2";


                } else if (position == 3) {
                    UPi();
                    paymet_of_mode = "3";


                } else if (position == 4) {
                    Paytm();
                    paymet_of_mode = "4";

                }

                Toast.makeText(getActivity(), parent.getItemAtPosition(position).toString().trim() + "", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void Paytm() {
        LL_NotcheckDD.setVisibility(View.GONE);
        LL_checkDD.setVisibility(View.GONE);
        Continue.setVisibility(View.VISIBLE);
        LL_UPI.setVisibility(View.GONE);
        Tv_UploadImage.setVisibility(View.VISIBLE);

        LL_Paytm.setVisibility(View.VISIBLE);


    }

    private void UPi() {
        LL_NotcheckDD.setVisibility(View.GONE);
        LL_UPI.setVisibility(View.VISIBLE);
        LL_Paytm.setVisibility(View.GONE);

        LL_checkDD.setVisibility(View.GONE);
        Continue.setVisibility(View.VISIBLE);

        Tv_UploadImage.setVisibility(View.VISIBLE);
    }

    private void NetBanking() {
        LL_NotcheckDD.setVisibility(View.VISIBLE);
        Tv_UploadImage.setVisibility(View.VISIBLE);

        LL_checkDD.setVisibility(View.GONE);
        Ed_Utrno.setHint("Enter UTR No.");
        Continue.setVisibility(View.VISIBLE);
        LL_UPI.setVisibility(View.GONE);

        LL_Paytm.setVisibility(View.GONE);

    }

    private void Cheekdd() {
        LL_checkDD.setVisibility(View.VISIBLE);
        LL_NotcheckDD.setVisibility(View.GONE);
        Continue.setVisibility(View.VISIBLE);
        LL_UPI.setVisibility(View.GONE);
        LL_Paytm.setVisibility(View.GONE);
        Tv_UploadImage.setVisibility(View.GONE);



    }

    public void DoAddAmount(Context context) {



        amount = Ed_amount.getText().toString();
        checkNo = ed_checkNo.getText().toString();
        cheque_date = startDate.getText().toString();
        bank_name = Ed_Bankname.getText().toString();
        bank_branch = Ed_bank_branch.getText().toString();
        utrNO=Ed_Utrno.getText().toString();
        ref_id=Ed_ref_id.getText().toString();
        Paytm=Ed_Paytm.getText().toString();

        if (payment_mode.equalsIgnoreCase("1")) {
            if (paymet_of_mode.equalsIgnoreCase("1")) {
                if (amount.isEmpty()) {
                    Sneaker.with(getActivity())
                            .setTitle("Enter Amount to add")
                            .setMessage("")
                            .sneakError();
                } else if (checkNo.isEmpty()) {
                    Sneaker.with(getActivity())
                            .setTitle("Enter Check Number")
                            .setMessage("")
                            .sneakError();
                } else if (cheque_date.isEmpty()) {
                    Sneaker.with(getActivity())
                            .setTitle("Select Cheque Date")
                            .setMessage("")
                            .sneakError();
                } else if (bank_name.isEmpty()) {
                    Sneaker.with(getActivity())
                            .setTitle("Enter Bank name")
                            .setMessage("")
                            .sneakError();
                } else if (bank_branch.isEmpty()) {
                    Toast.makeText(context, "Enter Bank Branch", Toast.LENGTH_SHORT).show();

                    Sneaker.with(getActivity())
                            .setTitle("Enter Bank Branch")
                            .setMessage("")
                            .sneakError();
                } else {
                    sendRequest(getContext(), payment_mode, amount, paymet_of_mode, checkNo, cheque_date, bank_name, bank_branch,utrNO,ref_id,Paytm);

                }
            }
            else if (paymet_of_mode.equalsIgnoreCase("2")) {
                if (utrNO.isEmpty())
                {
                    Sneaker.with(getActivity())
                            .setTitle("Enter UTR No.")
                            .setMessage("")
                            .sneakError();
                }
                else if (amount.isEmpty()) {
                    Sneaker.with(getActivity())
                            .setTitle("Enter Amount to add")
                            .setMessage("")
                            .sneakError();
                }
                else if (path.equals("null"))
                {
                    Sneaker.with(getActivity())
                            .setTitle("The payment  field is required.")
                            .setMessage("")
                            .sneakError();
                }
                else
                {
                    sendaddmony_offline(getContext(),payment_mode,amount,paymet_of_mode,utrNO,ref_id,Paytm,path);
              // sendRequest(getContext(), payment_mode, amount, paymet_of_mode, checkNo, cheque_date, bank_name, bank_branch,utrNO,ref_id,Paytm);

                }

            }
            else if (paymet_of_mode.equalsIgnoreCase("3")) {
                if (ref_id.isEmpty())
                {
                    Sneaker.with(getActivity())
                            .setTitle("Enter Ref id.")
                            .setMessage("")
                            .sneakError();
                }
                else if (amount.isEmpty()) {
                    Sneaker.with(getActivity())
                            .setTitle("Enter Amount to add")
                            .setMessage("")
                            .sneakError();
                } else if (path.equals("null"))
                {
                    Sneaker.with(getActivity())
                            .setTitle("The payment  field is required.")
                            .setMessage("")
                            .sneakError();
                }
                else
                {
                    sendaddmony_offline(getContext(),payment_mode,amount,paymet_of_mode,utrNO,ref_id,Paytm,path);

                    //   sendRequest(getContext(), payment_mode, amount, paymet_of_mode, checkNo, cheque_date, bank_name, bank_branch,utrNO,ref_id,Paytm);
                }

            }

            else if (paymet_of_mode.equalsIgnoreCase("4")) {
                if (Paytm.isEmpty())
                {
                    Sneaker.with(getActivity())
                            .setTitle("order id field is required.")
                            .setMessage("")
                            .sneakError();
                }
                else if (amount.isEmpty()) {
                    Sneaker.with(getActivity())
                            .setTitle("Enter Amount to add")
                            .setMessage("")
                            .sneakError();
                }
                else if (path.equals("null"))
                {
                    Sneaker.with(getActivity())
                            .setTitle("The payment  field is required.")
                            .setMessage("")
                            .sneakError();
                }
                else
                {
                    sendaddmony_offline(getContext(),payment_mode,amount,paymet_of_mode,utrNO,ref_id,Paytm,path);

                    //  sendRequest(getContext(), payment_mode, amount, paymet_of_mode, checkNo, cheque_date, bank_name, bank_branch,utrNO,ref_id,Paytm);

                }

            }
        } else if (payment_mode.equalsIgnoreCase("2")) {


            if (amount.isEmpty()) {
                Sneaker.with(getActivity())
                        .setTitle("Enter Amount to add")
                        .setMessage("")
                        .sneakError();
            } else {


                sendRequest(getContext(), payment_mode, amount, paymet_of_mode, checkNo, cheque_date, bank_name, bank_branch,utrNO,ref_id,Paytm);


            }

        }


    }

    private void sendRequest(Context context, String payment_mode, String amount, String paymet_of_mode, String checkNo, String cheque_date, String bank_name, String bank_branch,String utr_number,String ref_id,String order_id) {
        Call<AddAmountResponse> loginCall = ApiManager.getApi(context).DoaddMoney(payment_mode, amount, paymet_of_mode, checkNo, cheque_date, bank_name, bank_branch,utr_number,ref_id,order_id);

        loginCall.enqueue(new Callback<AddAmountResponse>() {
            @Override
            public void onResponse(Call<AddAmountResponse> call, Response<AddAmountResponse> response) {

            Toast.makeText(context, response.code() + "", Toast.LENGTH_LONG).show();

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {


                        bottomSheet.dismiss();
                        Sneaker.with(getActivity())
                                .setTitle(response.body().getMessage())
                                .setMessage("")
                                .sneakSuccess();

                        FragmentManager fragmentManager = getFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                Fragment homeFragment = new MyWalletFragment();
                                fragmentTransaction.replace(R.id.fragment_Container, homeFragment);
                                fragmentTransaction.addToBackStack(null);

                                fragmentTransaction.commit();
                        //Toast.makeText(context, response.body().getMessage() + "", Toast.LENGTH_LONG).show();



                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        String errorMsg = jsonObject.getString("status");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(Call<AddAmountResponse> call, Throwable t) {

                Log.e("onFailure", t.getLocalizedMessage());
            }
        });
    }
    private void sendaddmony_offline(Context context, String payment_mode, String amount, String paymet_of_mode, String utr_number, String ref_id, String order_id, String path)
    {

      //  @Part MultipartBody.Part payment_screenshot);

        File file = new File(path);
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part payment_screenshot =
                MultipartBody.Part.createFormData("payment_screenshot", file.getName(), requestFile);


        RequestBody payment_modee = RequestBody.create(MediaType.parse("multipart/form-data"), payment_mode);
        RequestBody amountt = RequestBody.create(MediaType.parse("multipart/form-data"), amount);
        RequestBody paymet_of_modee = RequestBody.create(MediaType.parse("multipart/form-data"), paymet_of_mode);
        RequestBody utr_numberr = RequestBody.create(MediaType.parse("multipart/form-data"), utr_number);
        RequestBody ref_idd = RequestBody.create(MediaType.parse("multipart/form-data"),ref_id);
        RequestBody order_idd = RequestBody.create(MediaType.parse("multipart/form-data"), order_id);



        Call<AddAmountResponse> userlist = ApiManager.getApi(context).DoaddMoney_Offline(payment_modee,amountt,paymet_of_modee,utr_numberr,ref_idd,order_idd,payment_screenshot);

        userlist.enqueue(new Callback<AddAmountResponse>() {
            @Override
            public void onResponse(Call<AddAmountResponse> call, Response<AddAmountResponse> response) {

               // Toast.makeText(context, response.code() + "", Toast.LENGTH_LONG).show();

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                   //     Toast.makeText(context, response.body().getMessage() + "", Toast.LENGTH_LONG).show();
                        bottomSheet.dismiss();
                        Sneaker.with(getActivity())
                                .setTitle(response.body().getMessage())
                                .setMessage("")
                                .sneakSuccess();

                        FragmentManager fragmentManager = getFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        Fragment homeFragment = new MyWalletFragment();
                        fragmentTransaction.replace(R.id.fragment_Container, homeFragment);
                        fragmentTransaction.addToBackStack(null);

                        fragmentTransaction.commit();

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        String errorMsg = jsonObject.getString("status");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(Call<AddAmountResponse> call, Throwable t) {

                Log.e("onFailure", t.getLocalizedMessage());
            }
        });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        System.out.println("requestCode" + requestCode);
        switch (requestCode) {
            case ImagePath.REquestPermissionCode:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getActivity(), "Permissin Granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "Permissin Deined", Toast.LENGTH_SHORT).show();
                }


        }


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    /*    if (requestCode == PICK_PHOTO_FOR_AVATAR && resultCode == RESULT_OK) {
            if (data == null)
                return;
            Uri uri = data.getData();
            System.out.println("urii  "+uri +" "+uri.getPath());
            String path  = ImagePath.getPath(context,uri);
            System.out.println("urii path "+path );
            if(path!=null && !path.equals("")) {
                File file = new File(path);
                Upload( file,loginResponse.getUserId());
                //uploadImage(file);
            }

        }*/

        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            if (data == null)
                return;

            Uri uri = data.getData();
            System.out.println("urii  " + uri + " " + uri.getPath());
             path   = ImagePath.getPath(getContext(), uri);
            System.out.println("urii path " + path);

            imageUri = data.getData();
            //circleImageView.setImageURI(imageUri);
            if (path != null && !path.equals("")) {
                File file = new File(path);
               // Toast.makeText(getContext(), "done", Toast.LENGTH_SHORT).show();
                Tv_UploadImage.setText(path);
                //uploadImage(file);

            }
            else {

             Toast.makeText(getContext(), "not", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
