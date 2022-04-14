package com.serviingo.serviingo.Fragments;

import android.content.DialogInterface;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.Adapterr.CitySpinnerAdapter;
import com.serviingo.serviingo.Adapterr.StateSpinnerAdapter;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.Rtrofit.ApiClientt;
import com.serviingo.serviingo.ViewPresenter.AddressBookPresenter;
import com.serviingo.serviingo.ViewPresenter.CategoriesPresenter;
import com.serviingo.serviingo.ViewPresenter.VandorRegPresenter;
import com.serviingo.serviingo.model.CityModel;
import com.serviingo.serviingo.model.StateModel;
import com.serviingo.serviingo.modelrepo.Responsee.AddressbookRespo;
import com.serviingo.serviingo.modelrepo.Responsee.MyAddressRepoo;
import com.serviingo.serviingo.modelrepo.request.AddressbookRequest;
import com.serviingo.serviingo.modelrepo.request.VandorRegs;

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

public class AddressbookFragment extends Fragment implements AddressBookPresenter.AddressBookView {

    TextView tv_home, tvreferdesc, btn, updatebtn;
    StateModel stateModel;
    ArrayList<StateModel> stateModelList;
    ArrayList<CityModel> cityModelList;
    Spinner spinner_state, spinner_city;
    String state_id, city_id, category_id;
    EditText etFullAddress, etLandMark, etPincode;
    RadioButton home, work, other;
    String Address_Type = " ";
    AddressBookPresenter addressBookPresenter;
    MyAddressRepoo.Data.Address address;

    private static int SPLASH_TIME_OUT = 3000;
    Bundle extras;
    String statekey = "key";

    public AddressbookFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_addressbook, container, false);
        findViewById(view);
        return view;
    }

    private void findViewById(View view) {
        addressBookPresenter = new AddressBookPresenter(this);

        spinner_state = view.findViewById(R.id.spinner_state);
        spinner_city = view.findViewById(R.id.spinner_city);

        etFullAddress = view.findViewById(R.id.etFullAddress);
        etLandMark = view.findViewById(R.id.etLandMark);
        etPincode = view.findViewById(R.id.etPincode);
        home = view.findViewById(R.id.Home);
        work = view.findViewById(R.id.Work);
        other = view.findViewById(R.id.Other);
        btn = view.findViewById(R.id.btn);
        stateModelList = new ArrayList<StateModel>();
        cityModelList = new ArrayList<>();

        updatebtn = view.findViewById(R.id.updatebtn);
        //   getState();
        // address= getArguments().getString("YourKey");

        extras = getArguments();
        if (extras != null) {
            address = (MyAddressRepoo.Data.Address) getArguments().getSerializable("data");

            statekey = String.valueOf(address.getGetState().getId());
            getState();
            if (!statekey.equalsIgnoreCase("key")) {

                GetCity(statekey);

            }


        } else {
            getState();

        }

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {


                if (extras != null) {
                    updatebtn.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.GONE);
                    //    GetCity(String.valueOf(address.getGetState().getId()));


                    // and get whatever type user account id is
                    address = (MyAddressRepoo.Data.Address) getArguments().getSerializable("data");
                    etFullAddress.setText(address.getAddress());
                    etLandMark.setText(address.getLandmark());
                    etPincode.setText(address.getPincode());
                  //  Toast.makeText(getContext(), String.valueOf(address.getGetState().getId()) + "", Toast.LENGTH_SHORT).show();


                    //   Toast.makeText(getContext(), stateModelList.size()+ "", Toast.LENGTH_SHORT).show();

                    for (int i = 0; i < stateModelList.size(); i++) {
                        // Toast.makeText(getContext(), stateModelList.get(i).getName()+ "", Toast.LENGTH_SHORT).show();
                        //  Log.e("state",stateModelList.get(i).getName());

                        if (stateModelList.get(i).getName().equalsIgnoreCase(address.getGetState().getName())) {
                            spinner_state.setSelection(i);
                        }
                    }
                    Log.e("spinner_city", String.valueOf(cityModelList.size()));


                    for (int i = 0; i < cityModelList.size(); i++) {
                        // Toast.makeText(getContext(), stateModelList.get(i).getName()+ "", Toast.LENGTH_SHORT).show();

                        Log.e("spinner_city", cityModelList.get(i).getName());

                        if (cityModelList.get(i).getName().equalsIgnoreCase(address.getGetCity().getName())) {
                            spinner_city.setSelection(i);
                        }
                    }
                    //     Toast.makeText(getContext(), cityModelList.size() + "", Toast.LENGTH_SHORT).show();


                    if (address.getAddressType().equalsIgnoreCase("work")) {
                        work.setChecked(true);

                    } else if (address.getAddressType().equalsIgnoreCase("other")) {
                        other.setChecked(true);
                    }
                    AppTools.hideDialog();


                    ///    Toast.makeText(getContext(), address.getGetState().getId()+ "", Toast.LENGTH_SHORT).show();

                } else {
                    AppTools.hideDialog();

                }
            }
        }, SPLASH_TIME_OUT);
 /* for (int i = 0; i < cityModelList.size(); i++) {
                        // Toast.makeText(getContext(), stateModelList.get(i).getName()+ "", Toast.LENGTH_SHORT).show();

                     Log.e("spinner_city",cityModelList.get(i).getName());

                        if (cityModelList.get(i).getName().equalsIgnoreCase(address.getGetCity().getName())) {
                            spinner_city.setSelection(i);
                        }
                    }*/

        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateAddressbook();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Addressbook();

            }
        });
    }


    private void Addressbook() {

        if (home.isChecked()) {

            Address_Type = home.getText().toString();
        } else if (work.isChecked()) {
            Address_Type = work.getText().toString();
        } else if (other.isChecked()) {
            Address_Type = other.getText().toString();
        }

        String FullAddress = etFullAddress.getText().toString().trim();
        String LandMark = etLandMark.getText().toString().trim();
        String Pincode = etPincode.getText().toString().trim();

        if (FullAddress.isEmpty()) {
            Sneaker.with(this)
                    .setTitle("The address field is required!")
                    .setMessage("")
                    .sneakError();

        } else if (LandMark.isEmpty()) {
            Sneaker.with(this)
                    .setTitle("The landmark field is required!")
                    .setMessage("")
                    .sneakError();
        } else if (Pincode.isEmpty()) {
            Sneaker.with(this)
                    .setTitle("The pincode field is required.")
                    .setMessage("")
                    .sneakError();
        } else if (state_id.equalsIgnoreCase("00")) {
            Sneaker.with(this)
                    .setTitle("Select  State!")
                    .setMessage("")
                    .sneakError();
        } else if (city_id.equalsIgnoreCase("00")) {
            Sneaker.with(this)
                    .setTitle("Select  City!")
                    .setMessage("")
                    .sneakError();
        } else {
            AppTools.showRequestDialog(getActivity());
            Log.d("checkkkkkk", city_id + "\n" + state_id + "\n");
         //   Toast.makeText(getContext(), Address_Type + "", Toast.LENGTH_SHORT).show();
            AddressbookRequest addressbookRequest = new AddressbookRequest(FullAddress, LandMark, Pincode, Address_Type, state_id, city_id);

            addressBookPresenter.AddressBook(getContext(), addressbookRequest);

            // AppTools.showGifDialog(getActivity(), globalloader);

           /* VandorRegs vandorRegs = new VandorRegs(fname, lname, state_id, city_id, category_id, email, mobile, password, cpassword);

            vandorRegPresenter.VandorReg(vandorRegs);*/

        }


    }

    private void UpdateAddressbook() {

        if (home.isChecked()) {

            Address_Type = home.getText().toString();
        } else if (work.isChecked()) {
            Address_Type = work.getText().toString();
        } else if (other.isChecked()) {
            Address_Type = other.getText().toString();
        }

        String FullAddress = etFullAddress.getText().toString().trim();
        String LandMark = etLandMark.getText().toString().trim();
        String Pincode = etPincode.getText().toString().trim();

        if (FullAddress.isEmpty()) {
            Sneaker.with(this)
                    .setTitle("The address field is required!")
                    .setMessage("")
                    .sneakError();

        } else if (LandMark.isEmpty()) {
            Sneaker.with(this)
                    .setTitle("The landmark field is required!")
                    .setMessage("")
                    .sneakError();
        } else if (Pincode.isEmpty()) {
            Sneaker.with(this)
                    .setTitle("The pincode field is required.")
                    .setMessage("")
                    .sneakError();
        } else if (state_id.equalsIgnoreCase("00")) {
            Sneaker.with(this)
                    .setTitle("Select  State!")
                    .setMessage("")
                    .sneakError();
        } else if (city_id.equalsIgnoreCase("00")) {
            Sneaker.with(this)
                    .setTitle("Select  City!")
                    .setMessage("")
                    .sneakError();
        } else {
            AppTools.showRequestDialog(getActivity());
            Log.d("checkkkkkk", city_id + "\n" + state_id + "\n");
            //Toast.makeText(getContext(), Address_Type + "", Toast.LENGTH_SHORT).show();
            AddressbookRequest addressbookRequest = new AddressbookRequest(FullAddress, LandMark, Pincode, Address_Type, state_id, city_id);

            addressBookPresenter.onUpdateAddress(getContext(), String.valueOf(address.getId()), addressbookRequest);

            // AppTools.showGifDialog(getActivity(), globalloader);

           /* VandorRegs vandorRegs = new VandorRegs(fname, lname, state_id, city_id, category_id, email, mobile, password, cpassword);

            vandorRegPresenter.VandorReg(vandorRegs);*/

        }


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
                            if (statekey.equalsIgnoreCase("key")) {
                                GetCity(state_id);

                            }


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
                //Toast.makeText(getActivity(), t.getLocalizedMessage() + "", Toast.LENGTH_SHORT).show();

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
                    //  AppTools.hideGifDialog();

                    CitySpinnerAdapter coinSpinnerAdapter = new CitySpinnerAdapter(getActivity().getApplicationContext(), cityModelList);
                    spinner_city.setAdapter(coinSpinnerAdapter);
                    spinner_city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
             //   Toast.makeText(getActivity(), t.getLocalizedMessage() + "", Toast.LENGTH_SHORT).show();

            }
        });


    }

    @Override
    public void onAddressBookError(String message) {
        AppTools.showRequestDialog(getActivity());

        Sneaker.with(this)
                .setTitle(message)
                .setMessage("")
                .sneakError();
    }

    @Override
    public void onAddressBookSuccess(AddressbookRespo response, String message) {
        if (message.equalsIgnoreCase("ok")) {
            AppTools.showRequestDialog(getActivity());
            Sneaker.with(this)
                    .setTitle(response.getMessage())
                    .setMessage("")
                    .sneakSuccess();
            //  startActivity( new Intent(ChangePasswordActivity.this, MainActivity.class));


            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Fragment addressFragment = new AddressFragment();
            fragmentTransaction.replace(R.id.fragment_Container, addressFragment);
            fragmentTransaction.commit();


        }
    }

    @Override
    public void onUpdateAddressSuccess(ResponseBody response, String message) {
        Toast.makeText(getContext(), "Address Updated Successfully.", Toast.LENGTH_SHORT).show();
        if (message.equalsIgnoreCase("ok")) {
            AppTools.showRequestDialog(getActivity());

            //  startActivity( new Intent(ChangePasswordActivity.this, MainActivity.class));


            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Fragment addressFragment = new AddressFragment();
            fragmentTransaction.replace(R.id.fragment_Container, addressFragment);
            fragmentTransaction.commit();


        }
    }

    @Override
    public void onAddressBookFailure(Throwable t) {


        AppTools.showRequestDialog(getActivity());

        Sneaker.with(this)
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();

    }


}