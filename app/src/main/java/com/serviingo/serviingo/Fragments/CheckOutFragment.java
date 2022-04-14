package com.serviingo.serviingo.Fragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.irozon.sneaker.Sneaker;
import com.razorpay.Checkout;
import com.razorpay.PaymentData;
import com.razorpay.PaymentResultWithDataListener;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.Activity.RazorPay.RazorPaymentActivity;
import com.serviingo.serviingo.Activity.Success;
import com.serviingo.serviingo.Adapterr.CitySpinnerAdapter;
import com.serviingo.serviingo.Adapterr.MyAddressAdapter;
import com.serviingo.serviingo.Adapterr.SelectAddressAdapter;
import com.serviingo.serviingo.Adapterr.StateSpinnerAdapter;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.Rtrofit.ApiClientt;
import com.serviingo.serviingo.ViewPresenter.CreateOrderPresenter;
import com.serviingo.serviingo.ViewPresenter.MyAddressPresenter;
import com.serviingo.serviingo.base.BaseFragment;
import com.serviingo.serviingo.model.CityModel;
import com.serviingo.serviingo.model.StateModel;
import com.serviingo.serviingo.modelrepo.Responsee.CreateOrderRepo;
import com.serviingo.serviingo.modelrepo.Responsee.MyAddressRepoo;
import com.serviingo.serviingo.modelrepo.Responsee.Profile_Repo;
import com.serviingo.serviingo.modelrepo.Responsee.Razorpay.RazorpayRepo;
import com.serviingo.serviingo.modelrepo.request.CartRequest;
import com.serviingo.serviingo.modelrepo.request.CreateOrderRequest;
import com.serviingo.serviingo.modelrepo.request.PaymentSignatureVerifyReq;
import com.serviingo.serviingo.modelrepo.request.TempCartRequest;
import com.serviingo.serviingo.storage.SharedPrefManager;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.serviingo.serviingo.R.drawable.globalloader;

public class CheckOutFragment extends BaseFragment implements MyAddressPresenter.MyAddressView, CreateOrderPresenter.CreateOrderPresenterView {
    TextView TV_Payment;
    Spinner cityspinner, spinner_state, SpinnerAddresss;
    EditText ET_Pincode, ET_LandMark, ET_Address, ET_Mobile, ET_Email, ET_Name;
    String name, email, mobile, address, landmark, pincode, city, state;
    SuccessViewDialog successViewDialog;
    MyAddressPresenter myAddressPresenter;
    LinearLayout selectAddressLL;
    StateModel stateModel;
    ArrayList<StateModel> stateModelList;
    String state_id, city_id, category_id;
    ArrayList<CityModel> cityModelList;
    Bundle extras;
    private static int SPLASH_TIME_OUT = 1000;

    String package_id, payment_method, total_amount, addon_service_ids, SafetyAndHygieneFee, pack_quantity, Subtoal, discount_amount, serve_time, serve_date,


    membership_cost, membership_id, membership_discount;
    private CreateOrderPresenter createOrderPresenter;
    // ArrayList<CartRequest.AddonService> addonServices;
    TextView cartnumbertv;

    ArrayList<CreateOrderRequest.AddonService> addonServices;
    ArrayList<String> arrayList = new ArrayList<>();
    String order_id, OrderNumber;
    RadioButton rdwallet, rdallet, rdOnline;
    CheckBox SaveInAddressBook_CB, CheckBoxProfile;
    String ProfileCheckbox = "No", saveaddressCheckBox = "No";
    String CouponDiscountAmount=" ",coupon_id=" ";

    public CheckOutFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_check_out, container, false);

        setui(view);

        return view;
    }

    private void setui(View view) {
        Checkout.preload(mActivity);
        addonServices = new ArrayList<>();
        createOrderPresenter = new CreateOrderPresenter(this);
        extras = getArguments();
        if (extras != null) {
            package_id = getArguments().getString("id");
            //   payment_method = getArguments().getString("payment");
            total_amount = getArguments().getString("Total");
            addon_service_ids = getArguments().getString("addon_service_ids");
            SafetyAndHygieneFee = getArguments().getString("SafetyAndHygieneFee");
            pack_quantity = getArguments().getString("pack_quantity");
            Subtoal = getArguments().getString("Subtoal");
            CouponDiscountAmount = getArguments().getString("CouponDiscountAmount");
            coupon_id = getArguments().getString("coupon_id");

            serve_time = getArguments().getString("serve_time");
            serve_date = getArguments().getString("serve_date");
            discount_amount = getArguments().getString("discount_amount");
            addonServices = (ArrayList<CreateOrderRequest.AddonService>) getArguments().getSerializable("addonServices");
            arrayList = getArguments().getStringArrayList("arrayList");
            Log.e("CouponDiscountAmount", CouponDiscountAmount + "coupon_id" + coupon_id);



            if (SharedPrefManager.getInstance(getActivity()).getmembership_cost() != null) {
                membership_cost = SharedPrefManager.getInstance(getActivity()).getmembership_cost();
                membership_id = SharedPrefManager.getInstance(getActivity()).getmembership_id();
                membership_discount = SharedPrefManager.getInstance(getActivity()).GetMembershipCost();
                // Toast.makeText(getContext(), membership_cost+"\n"+membership_id+"\n"+membership_discount+"", Toast.LENGTH_SHORT).show();
                Log.e("dfkhdwshfbklbndsf", membership_cost + "huk" + membership_id + "yj" + membership_discount);

            } else {


                membership_discount = SharedPrefManager.getInstance(getActivity()).GetMembershipCost();
                //  membership_id = SharedPrefManager.getInstance(getActivity()).getmembership_id();
                Log.e("dfkhdwshfbklbndsf", membership_cost + "huk" + discount_amount + "yj" + membership_discount);
            }

            TempCartRequest tempCartRequest = new TempCartRequest(package_id, arrayList, serve_date, serve_time, membership_id, membership_cost, "Yes");
            createOrderPresenter.TempCartRequest(getContext(), tempCartRequest);

            /*Log.e("addonServices", package_id + "\n" + payment_method + "\n"
                    + total_amount + "\n" + addon_service_ids + "\n"
                    + SafetyAndHygieneFee+ "\n"+addonServices.size());

    */

        }


        stateModelList = new ArrayList<StateModel>();
        cityModelList = new ArrayList<>();
        getState();
        myAddressPresenter = new MyAddressPresenter(this);


        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                AppTools.showRequestDialog(getActivity());


                myAddressPresenter.MyAddressList(getContext());


            }
        }, SPLASH_TIME_OUT);

        cartnumbertv = getActivity().findViewById(R.id.cartnumbertv);

        successViewDialog = new SuccessViewDialog();
        TV_Payment = view.findViewById(R.id.TV_Payment);
        cityspinner = view.findViewById(R.id.cityspinner);
        spinner_state = view.findViewById(R.id.spinner_state);
        SpinnerAddresss = view.findViewById(R.id.SpinnerAddresss);
        ET_Pincode = view.findViewById(R.id.ET_Pincode);
        ET_LandMark = view.findViewById(R.id.ET_LandMark);
        ET_Address = view.findViewById(R.id.ET_Address);
        ET_Mobile = view.findViewById(R.id.ET_Mobile);
        ET_Email = view.findViewById(R.id.ET_Email);
        ET_Name = view.findViewById(R.id.ET_Name);

        CheckBoxProfile = view.findViewById(R.id.CheckBoxProfile);
        SaveInAddressBook_CB = view.findViewById(R.id.SaveInAddressBook_CB);

        rdwallet = view.findViewById(R.id.rdwallet);
        rdallet = view.findViewById(R.id.rdallet);
        rdOnline = view.findViewById(R.id.rdOnline);

        selectAddressLL = view.findViewById(R.id.selectAddressLL);
        TV_Payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProceedToPayment();
            }
        });

        ET_Name.setText(SharedPrefManager.getInstans(getContext()).getfullname());
        ET_Mobile.setText(SharedPrefManager.getInstans(getContext()).getNumber());
        ET_Email.setText(SharedPrefManager.getInstans(getContext()).getemail());
    }

    private void ProceedToPayment() {
        name = ET_Name.getText().toString().trim();
        email = ET_Email.getText().toString().trim();
        mobile = ET_Mobile.getText().toString().trim();
        address = ET_Address.getText().toString().trim();
        landmark = ET_LandMark.getText().toString().trim();
        pincode = ET_Pincode.getText().toString().trim();

        if (rdwallet.isChecked()) {

            payment_method = "wallet";
        } else if (rdallet.isChecked()) {
            payment_method = "cod";
        } else if (rdOnline.isChecked()) {
            payment_method = "online";

        }
        if (CheckBoxProfile.isChecked()) {
            ProfileCheckbox = "Yes";
        } else {
            ProfileCheckbox = "No";

        }
        if (SaveInAddressBook_CB.isChecked()) {
            saveaddressCheckBox = "Yes";
        } else {
            saveaddressCheckBox = "No";


        }


        if (name.isEmpty()) {
            Sneaker.with(getActivity())
                    .setTitle("Name Field is required")
                    .setMessage("")
                    .sneakError();
        } else if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Sneaker.with(getActivity())
                    .setTitle("Valid email Field is required")
                    .setMessage("")
                    .sneakError();

        } else if (mobile.length() != 10) {
            Sneaker.with(getActivity())
                    .setTitle("mobile Field is required")
                    .setMessage("")
                    .sneakError();
        } else if (address.isEmpty()) {
            Sneaker.with(getActivity())
                    .setTitle("address Field is required")
                    .setMessage("")
                    .sneakError();
        } else if (landmark.isEmpty()) {
            Sneaker.with(getActivity())
                    .setTitle("landmark Field is required")
                    .setMessage("")
                    .sneakError();
        } else if (pincode.isEmpty()) {
            Sneaker.with(getActivity())
                    .setTitle("pincode Field is required")
                    .setMessage("")
                    .sneakError();
        } else {
           /* Sneaker.with(getActivity())
                    .setTitle("Done")
                    .setMessage("")
                    .sneakSuccess();*/
            //  successViewDialog.showDialog(getActivity());
            CreateOrderRequest createOrderRequest = new CreateOrderRequest(landmark, SafetyAndHygieneFee, addon_service_ids, package_id, pincode,
                    total_amount, name, email, mobile, address, state_id, city_id, payment_method, Subtoal, pack_quantity, addonServices, discount_amount,
                    membership_discount, membership_id, membership_cost, serve_date, serve_time,saveaddressCheckBox, CouponDiscountAmount,coupon_id);
            createOrderPresenter.CreateOrder(getContext(), createOrderRequest);


        }


    }

    @Override
    public void onMyAddressError(String message) {
        AppTools.hideDialog();

        Sneaker.with(this)
                .setTitle(message)
                .setMessage("")
                .sneakError();
    }

    @Override
    public void onMyAddressSuccess(MyAddressRepoo response, String message) {
        Log.e("response", response.getData().toString());


        if (message.equalsIgnoreCase("ok")) {
            if (response.getData().getAddress().size() > 0) {

                SelectAddressAdapter addressAdapter = new SelectAddressAdapter(getContext(), response);
                SpinnerAddresss.setAdapter(addressAdapter);


                SpinnerAddresss.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        AppTools.showRequestDialog(getActivity());

                        ET_Pincode.setText(response.getData().getAddress().get(position).getPincode());

                        ET_LandMark.setText(response.getData().getAddress().get(position).getLandmark());
                        ET_Address.setText(response.getData().getAddress().get(position).getAddress());

                        for (int i = 0; i < stateModelList.size(); i++) {
                            // Toast.makeText(getContext(), stateModelList.get(i).getName()+ "", Toast.LENGTH_SHORT).show();

                            if (stateModelList.get(i).getName().equalsIgnoreCase(response.getData().getAddress().get(position).getGetState().getName())) {
                                spinner_state.setSelection(i);

                                state_id = String.valueOf(response.getData().getAddress().get(position).getGetState().getId());
                                GetCity(state_id);


                                new Handler().postDelayed(new Runnable() {

                                    @Override
                                    public void run() {
                                        AppTools.hideDialog();

                                        for (int j = 0; j < cityModelList.size(); j++) {
                                            Log.e("state", cityModelList.get(j).getName() + "\n" + response.getData().getAddress().get(position).getGetCity().getName());


                                            if (cityModelList.get(j).getName().equalsIgnoreCase(response.getData().getAddress().get(position).getGetCity().getName())) {
                                                cityspinner.setSelection(j);

                                            }
                                        }


                                    }
                                }, SPLASH_TIME_OUT);


                            }
                        }
                        // GetCity(state_id);

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
            } else {
                AppTools.hideDialog();

                selectAddressLL.setVisibility(View.GONE);
                createOrderPresenter.DoMyprofil(getContext());

                // Toast.makeText(getContext(), "No Addresss", Toast.LENGTH_SHORT).show();
            }


        }
    }

    @Override
    public void onDeleteAddressSuccess(ResponseBody response, String message) {

    }

    @Override
    public void onMyAddressFailure(Throwable t) {
        AppTools.hideDialog();

        Sneaker.with(this)
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();
    }

    private void getState() {
        AppTools.showRequestDialog(getActivity());

        stateModel = new StateModel();


        Call<ResponseBody> bodyCall = ApiClientt.getUserService().GetServeState();

        bodyCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                // Log.e("response", String.valueOf(response.body().toString()));

                //Toast.makeText(VenderReg.this, response.code(), Toast.LENGTH_SHORT).show();
                // Toast.makeText(VenderReg.this, response.body().getLocale()+"", Toast.LENGTH_SHORT).show();

                String s = null;


                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        s = response.body().string();
                        Log.e("response", s);
                        stateModel.setId("00");
                        stateModel.setName("Select State");

                        stateModelList.add(0, stateModel);

                        JSONObject jsonObject = new JSONObject(s);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("data");
                        JSONArray jsonArray = jsonObject1.getJSONArray("states");
                        for (int i = 0; i <= jsonArray.length(); i++) {

                            JSONObject jsonObject2 = jsonArray.getJSONObject(i);

                            stateModel = new StateModel();
                            stateModel.setId(jsonObject2.getString("id"));
                            stateModel.setName(jsonObject2.getString("name"));
                            stateModel.setCountry_id(jsonObject2.getString("country_id"));

                            stateModelList.add(stateModel);
                            // AppTools.hideGifDialog();

                            //   Toast.makeText(VenderReg.this, jsonObject2.getString("id") + "", Toast.LENGTH_SHORT).show();

                        }
                        /*
                         */
                    } catch (IOException | JSONException e) {
                        e.printStackTrace();
                    }

                    StateSpinnerAdapter coinSpinnerAdapter = new StateSpinnerAdapter(getActivity().getApplicationContext(), stateModelList);
                    spinner_state.setAdapter(coinSpinnerAdapter);
                    spinner_state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            state_id = stateModelList.get(position).getId();
                            GetCity(state_id);

                           /* if (!statekey.equalsIgnoreCase("key")) {

                                GetCity(String.valueOf(address.getGetState().getId()));

                            } else if (statekey.equalsIgnoreCase("key")) {
                                //  spinnertextview.setTextColor(Color.WHITE);



                            }*/


                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                //  loadingDialogs.dismissDialog();
                Toast.makeText(getActivity(), t.getLocalizedMessage() + "", Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void GetCity(String id) {
        CityModel stateModel = new CityModel();
        ;
        Call<ResponseBody> bodyCall = ApiClientt.getUserService().GetServeCity(id);

        bodyCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.e("responseee", String.valueOf(response.code()));
//       Toast.makeText(VenderReg.this, response.code(), Toast.LENGTH_SHORT).show();
                // Toast.makeText(VenderReg.this, response.body().getLocale()+"", Toast.LENGTH_SHORT).show();

                String s = null;
                cityModelList.clear();

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        s = response.body().string();
                        Log.e("response", s);
                        stateModel.setName("Select City");
                        stateModel.setId("00");

                        cityModelList.add(0, stateModel);

                        //   Toast.makeText(getActivity(), s + "", Toast.LENGTH_SHORT).show();
                        JSONObject jsonObject = new JSONObject(s);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("data");
                        JSONArray jsonArray = jsonObject1.getJSONArray("cities");
                        for (int i = 0; i <= jsonArray.length(); i++) {
                            JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                            CityModel stateModel = new CityModel();
                            stateModel.setId(jsonObject2.getString("id"));
                            stateModel.setName(jsonObject2.getString("name"));
                            cityModelList.add(stateModel);
                        }
                        /*
                         */
                    } catch (IOException | JSONException e) {
                        e.printStackTrace();
                    }
                    AppTools.hideDialog();

                    CitySpinnerAdapter coinSpinnerAdapter = new CitySpinnerAdapter(getActivity().getApplicationContext(), cityModelList);
                    cityspinner.setAdapter(coinSpinnerAdapter);
                    cityspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                            city_id = cityModelList.get(position).getId();


                            // GetCity(state_id);

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                //  loadingDialogs.dismissDialog();
                Toast.makeText(getActivity(), t.getLocalizedMessage() + "", Toast.LENGTH_SHORT).show();

            }
        });


    }

    @Override
    public void CreateOrderError(String message) {
        Sneaker.with(getActivity())
                .setTitle(message)
                .setMessage("")
                .sneakError();
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
    public void TempCartSuccess(ResponseBody response, String message) {
      /*  Sneaker.with(getActivity())
                .setTitle(message)
                .setMessage("")
                .sneakError();*/
    }

    @Override
    public void GetRazorPayKeySuccess(RazorpayRepo response, String message) {
        if (message.equalsIgnoreCase("ok")) {

            //startPayment(response.getData().getPaymentMethod().getApiKey(), total_amount);


            Intent intent = new Intent(getContext(), RazorPaymentActivity.class);// New activity
            intent.putExtra("ApiKey", response.getData().getPaymentMethod().getApiKey());
            intent.putExtra("order_id", order_id);
            intent.putExtra("OrderNumber", OrderNumber);

            intent.putExtra("total_amount", total_amount);

            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);


        }

    }

    @Override
    public void PaymentSignatureVerifyReqSuccess(ResponseBody response, String message) {
        if (message.equalsIgnoreCase("ok")) {
            successViewDialog.showDialog(getActivity(), OrderNumber);

        }

    }

    @Override
    public void CreateOrderSuccess(CreateOrderRepo response, String message) {

        if (message.equalsIgnoreCase("ok")) {

            if (payment_method.equalsIgnoreCase("online")) {
                OrderNumber = response.getData().orderNumber;
                order_id = String.valueOf(response.getData().id);
                createOrderPresenter.GetRazorPayKey(getContext());

            } else {
                OrderNumber = response.getData().orderNumber;
                successViewDialog.showDialog(getActivity(), OrderNumber);
                cartnumbertv.setVisibility(View.GONE);

                SharedPrefManager.getInstans(getContext().getApplicationContext()).pacakgeClear();
                SharedPrefManager.getInstans(getContext().getApplicationContext()).MembsershipClear();
                SharedPrefManager.getInstans(getContext().getApplicationContext()).AddonseClear();


            }


        }

    }


    @Override
    public void onDoMyprofileSuccess(Profile_Repo response, String message) {
        AppTools.hideDialog();

        if (message.equalsIgnoreCase("ok")) {


            state_id = response.getData().getProfile().getStateId().trim();

            city_id = response.getData().getProfile().getCityId().trim();
            ET_Address.setText(response.getData().getProfile().getAddress().trim());
            ET_LandMark.setText(response.getData().getProfile().getLandmark().trim());
            ET_Pincode.setText(response.getData().getProfile().getPincode().trim());
            //  Toast.makeText(getActivity(), response.getData().getProfile().getState.name +"", Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {

                    if (response.getData().getProfile().getState.name != null) {


                        for (int i = 0; i < stateModelList.size(); i++) {
                            //   Toast.makeText(getContext(), stateModelList.get(i).getName()+ "", Toast.LENGTH_SHORT).show();

                            if (stateModelList.get(i).getName().equalsIgnoreCase(response.getData().getProfile().getState.name)) {
                                spinner_state.setSelection(i);

                                state_id = String.valueOf(response.getData().getProfile().getState.id);
                                GetCity(state_id);


                                new Handler().postDelayed(new Runnable() {

                                    @Override
                                    public void run() {
                                        AppTools.hideDialog();

                                        for (int j = 0; j < cityModelList.size(); j++) {
                                            //  Log.e("state", cityModelList.get(j).getName() + "\n" + response.getData().getAddress().get(position).getGetCity().getName());
                                            if (cityModelList.get(j).getName().equalsIgnoreCase(response.getData().getProfile().getCity.name)) {
                                                cityspinner.setSelection(j);

                                            }
                                        }


                                    }
                                }, SPLASH_TIME_OUT);


                            }
                        }
                        // GetCity(state_id);

                    }


                }
            }, SPLASH_TIME_OUT);


        }


    }

    @Override
    public void CreateOrderFailure(Throwable t) {
        Sneaker.with(getActivity())
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();
    }


    /* @Override
     public void onPaymentSuccess(String s, PaymentData paymentData) {
         // orderID = paymentData.getOrderId();
         String Payment_id = paymentData.getPaymentId();
         // status ="Success";

         if (paymentData != null) {
             PaymentSignatureVerifyReq paymentSignatureVerifyReq = new PaymentSignatureVerifyReq(order_id, paymentData.getPaymentId(), paymentData.getOrderId(), paymentData.getSignature());
             createOrderPresenter.PaymentSignatureVerifyReq(getContext(), paymentSignatureVerifyReq);

           *//*  SaveBody saveBody = new SaveBody(Amount,orderID,status,Payment_id);
            presenter.savePaymentData(saveBody,context);*//*
        }
    }
*/
   /* @Override
    public void onPaymentError(int i, String s, PaymentData paymentData) {

        Log.e("gfdgfgfdfd", s);

      *//*  orderID = paymentData.getOrderId();
        String Payment_id = paymentData.getPaymentId();
        status =s;*//*
     *//*   if (paymentData!=null){
            SaveBody saveBody = new SaveBody(Amount,orderID,status,Payment_id);
            presenter.savePaymentData(saveBody,context);
        }else{
            SaveBody saveBody = new SaveBody(Amount,orderID,status,Payment_id);
            presenter.savePaymentData(saveBody,context);
        }*//*
    }
*/
    public class SuccessViewDialog {

        private TextView success, tvsubmoney, tvordernumber;

        // Dialog dialog=new Dialog(this,android.R.style.Theme_Black_NoTitleBar_Fullscreen)


        public void showDialog(Activity activity, String Ordernumber) {


            Dialog dialog = new Dialog(getContext(), android.R.style.Theme_Black_NoTitleBar_Fullscreen);
            dialog.setContentView(R.layout.success);
            dialog.setCancelable(false);
            dialog.show();
            success = dialog.findViewById(R.id.success);
            tvsubmoney = dialog.findViewById(R.id.tvsubmoney);
            tvordernumber = dialog.findViewById(R.id.tvordernumber);
            tvordernumber.setText(Ordernumber);

            success.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //  dialog.dismiss();

                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    Fragment fragment = new RecentBookingFragment();
                    fragmentTransaction.replace(R.id.fragment_Container, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    dialog.dismiss();
                }
            });

        }


    }


/*
    public void startPayment(String apiKey, String TotalAmount) {
        Checkout checkout = new Checkout();
        checkout.setKeyID(apiKey);

        checkout.setImage(R.mipmap.rzp);
        final Activity activity = getActivity();
        int amount = Integer.valueOf(TotalAmount) * 100;
        Log.e("Amount", String.valueOf(amount));


        */
/**
 * Pass your payment options to the Razorpay Checkout as a JSONObject
 *//*

        try {
            JSONObject options = new JSONObject();
            // options.put("order_id", order_id);
            options.put("name", SharedPrefManager.getInstans(getContext()).getfullname());
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
            //  options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
            options.put("currency", "INR");
            options.put("amount", amount);//pass amount in currency subunits
            options.put("prefill.email", SharedPrefManager.getInstans(getContext()).getemail());
            options.put("prefill.contact", SharedPrefManager.getInstans(getContext()).getNumber());
            checkout.open(mActivity, options);
        } catch (Exception e) {
            Log.e("TAG", "Error in starting Razorpay Checkout", e);
        }
    }
*/


}
