package com.serviingo.serviingo.dialogue;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.Adapterr.CitySpinnerAdapter;
import com.serviingo.serviingo.Adapterr.StateSpinnerAdapter;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.Rtrofit.ApiClientt;
import com.serviingo.serviingo.ViewPresenter.FinacialPresenter.FinanceServiceEnquiryPresenter;
import com.serviingo.serviingo.model.CityModel;
import com.serviingo.serviingo.model.StateModel;
import com.serviingo.serviingo.modelrepo.request.ServiceEnquiryRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.serviingo.serviingo.R.drawable.globalloader;

public class FinanceServiceEnquiryBottomSheet extends BottomSheetDialogFragment implements FinanceServiceEnquiryPresenter.FinanceServiceEnquiryView {
    BottomSheetDialog bottomSheet;
    EditText ET_Name, ET_Email, ET_Mobile, et_adahernumber, etpannumber, ET_Address, ET_Pincode;
    TextView startDate, TV_Payment, suecssTv;
    Spinner workprofile, spinner_state, cityspinner;
    StateModel stateModel;


    ArrayList<StateModel> stateModelList;
    ArrayList<CityModel> cityModelList;
    String state_id, city_id, category_id;
    String[] Payment_Method = {"Select Work Profile", "Employed", "Business"};//array of strings used to populate the spinner
    String name, email, mobile, addercard, pannumber, addrerss, pincode;
    FinanceServiceEnquiryPresenter presenter;
    private String id;
    private Context context;


    public FinanceServiceEnquiryBottomSheet(String id, Context context) {
        this.id = id;
        this.context = context;

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        bottomSheet = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);


        View view = View.inflate(getContext(), R.layout.finance_service_enquirybottomsheet, null);
        ET_Name = view.findViewById(R.id.ET_Name);
        ET_Email = view.findViewById(R.id.ET_Email);
        ET_Mobile = view.findViewById(R.id.ET_Mobile);
        et_adahernumber = view.findViewById(R.id.et_adahernumber);
        etpannumber = view.findViewById(R.id.etpannumber);
        ET_Address = view.findViewById(R.id.ET_Address);
        ET_Pincode = view.findViewById(R.id.ET_Pincode);
        startDate = view.findViewById(R.id.startDate);
        TV_Payment = view.findViewById(R.id.TV_Payment);
        suecssTv = view.findViewById(R.id.suecssTv);
        workprofile = view.findViewById(R.id.workprofile);
        spinner_state = view.findViewById(R.id.spinner_state);
        cityspinner = view.findViewById(R.id.cityspinner);
        presenter = new FinanceServiceEnquiryPresenter(this);
        stateModelList = new ArrayList<StateModel>();
        cityModelList = new ArrayList<>();
        getState();
        TV_Payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetQuerydata();
            }
        });
        startDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPickerDialog();
            }
        });
        ArrayAdapter<String> aa = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, Payment_Method);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//Setting the ArrayAdapter data on the Spinner
        workprofile.setAdapter(aa);

        workprofile.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                //  Toast.makeText(getActivity(), parent.getItemAtPosition(position).toString().trim()+"", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
       /* Sneaker.with(getActivity())
                .setTitle(id)
                .setMessage("")
                .sneakError();*/
        bottomSheet.setContentView(view);
        bottomSheet.setCancelable(false);
        bottomSheet.setCanceledOnTouchOutside(false);


        return bottomSheet;
    }

    private void GetQuerydata() {

        name = ET_Name.getText().toString().trim();
        email = ET_Email.getText().toString().trim();
        mobile = ET_Mobile.getText().toString().trim();
        addercard = et_adahernumber.getText().toString().trim();
        pannumber = etpannumber.getText().toString().trim();
        addrerss = ET_Address.getText().toString().trim();
        pincode = ET_Pincode.getText().toString().trim();


        if (workprofile.getSelectedItem().toString().equalsIgnoreCase("Select Work Profile")) {
            Toast.makeText(getContext(), "Select Work Profile", Toast.LENGTH_SHORT).show();

            Sneaker.with(getActivity())
                    .setTitle("Select Work Profile")
                    .setMessage("")
                    .sneakError();
        } else if (state_id.equalsIgnoreCase("00")) {
            Sneaker.with(getActivity())
                    .setTitle("Select  State!")
                    .setMessage("")
                    .sneakError();
            Toast.makeText(getContext(), "Select State!", Toast.LENGTH_SHORT).show();
        } else if (city_id.equalsIgnoreCase("00")) {
            Sneaker.with(getActivity())
                    .setTitle("Select  City!")
                    .setMessage("")
                    .sneakError();
            Toast.makeText(getContext(), "Select City!", Toast.LENGTH_SHORT).show();
        } else if (name.isEmpty()) {

            Toast.makeText(getContext(), "Enter Name!", Toast.LENGTH_SHORT).show();
        } else if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {

            Toast.makeText(getContext(), "Enter Valid Email!", Toast.LENGTH_SHORT).show();
        } else if (mobile.length()!=10) {

            Toast.makeText(getContext(), "Enter Mobile Number!", Toast.LENGTH_SHORT).show();
        } else if (addercard.length()!=12) {

            Toast.makeText(getContext(), "Enter Adahercard Number !", Toast.LENGTH_SHORT).show();
        } else if (pannumber.isEmpty()) {

            Toast.makeText(getContext(), "Enter PanNumber !", Toast.LENGTH_SHORT).show();
        } else if (addrerss.isEmpty()) {

            Toast.makeText(getContext(), "Enter Address!", Toast.LENGTH_SHORT).show();
        } else if (pincode.length()!=6) {

            Toast.makeText(getContext(), "Enter Pincode!", Toast.LENGTH_SHORT).show();
        } else if (startDate.getText().toString().trim().equalsIgnoreCase("mm/dd/yyyy")) {

            Toast.makeText(getContext(), "Select Date of Birth!", Toast.LENGTH_SHORT).show();
        } else {
            ServiceEnquiryRequest request = new ServiceEnquiryRequest(id, name, email, mobile, addrerss, state_id, city_id, pincode, startDate.getText().toString().trim(), addercard,
                    pannumber, workprofile.getSelectedItem().toString());
            presenter.FinanceServiceEnquiry(getContext(), request);
        }

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
        dtPickerDlg.setTitle("Select  Date");
        dtPickerDlg.show();
    }

    private void getState() {
        AppTools.showRequestDialog(getActivity());

        stateModel = new StateModel();


        Call<ResponseBody> bodyCall = ApiClientt.getUserService().GetState();

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
        Call<ResponseBody> bodyCall = ApiClientt.getUserService().GetCity(id);

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
    public void onFinanceServiceError(String message) {
        Toast.makeText(getContext(), message + "", Toast.LENGTH_LONG).show();
    }

    @Override
    public void GetFinanceServiceSuccess(ResponseBody response, String message) {
        //  Toast.makeText(getContext(), message+"", Toast.LENGTH_LONG).show();
        if (message.equalsIgnoreCase("ok")) {
            suecssTv.setVisibility(View.VISIBLE);

            Toast.makeText(getContext(), suecssTv.getText().toString() + "", Toast.LENGTH_LONG).show();
            bottomSheet.dismiss();

        }

    }

    @Override
    public void onFinanceServiceFailure(Throwable t) {
        Toast.makeText(getContext(), t.getLocalizedMessage() + "", Toast.LENGTH_LONG).show();

    }

    @Override
    public void showHideProgress(boolean isShow) {
        if (isShow) {
            AppTools.showRequestDialog(getActivity());

        } else {
            AppTools.hideDialog();

        }

    }
}
