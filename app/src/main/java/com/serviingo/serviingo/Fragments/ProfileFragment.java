package com.serviingo.serviingo.Fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.Adapterr.CitySpinnerAdapter;
import com.serviingo.serviingo.Adapterr.StateSpinnerUpdateAdapter;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.Rtrofit.ApiClientt;
import com.serviingo.serviingo.ViewPresenter.DoLogoutPresenter;
import com.serviingo.serviingo.ViewPresenter.DoMyprofilePresenter;
import com.serviingo.serviingo.ViewPresenter.DoMyprofileUpdatePresenter;
import com.serviingo.serviingo.ViewPresenter.ForgetPasword.SendOtpMobileUpdatePresenter;
import com.serviingo.serviingo.ViewPresenter.ForgetPasword.VerifyMobilePresenter;
import com.serviingo.serviingo.ViewPresenter.UploadProfileImage_Presenter;
import com.serviingo.serviingo.model.CityModel;
import com.serviingo.serviingo.model.StateModel;
import com.serviingo.serviingo.modelrepo.Responsee.Profile_Repo;
import com.serviingo.serviingo.modelrepo.Responsee.UpdateProfileRepo;
import com.serviingo.serviingo.modelrepo.request.UpdateProfile_request;
import com.serviingo.serviingo.utils.AppUtils;
import com.serviingo.serviingo.utils.ImagePath;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;

public class ProfileFragment extends Fragment implements View.OnClickListener, DoMyprofilePresenter.DoMyprofileView, DoMyprofileUpdatePresenter.DoMyprofileUpdateView, UploadProfileImage_Presenter.UploadProfileImageView {

    TextView btn_addresssDetails;
    ImageView imageView, ivCamera;
    DoMyprofilePresenter presenter;
    CircleImageView circleImageView;
    EditText etprofile_name, etprofileEmail, ed_houseno, ed_nearby, ed_pincode;
    TextView etprofilePhone;
    StateModel stateModel;
    ArrayList<StateModel> stateModelList;
    ArrayList<CityModel> cityModelList;
    Spinner spinner_state, spinner_city, genderSpinner;
    String state_id, city_id, genderr;
    String[] gender = {"Select Gender", "Male", "Female", "Transgender "};//array of strings used to populate the spinner
    DoMyprofileUpdatePresenter doMyprofileUpdatePresenter;
    UploadProfileImage_Presenter uploadProfileImagePresenter;
    String genderid;
    TextView tv_dashboardd,
            tv_myBooking, tv_myProfile, tv_myWallet, tv_Financial, tv_changePassword, tv_myReviews, IncompleteBooking_Tv, tv_myAddressbook, tv_mySupport, tv_referralDashboard;
    ImageView arrowIvv;
    public static ScrollView scrollView;
    private static final int PICK_IMAGE = 100;
    private static int SPLASH_TIME_OUT = 3000;
    Uri imageUri;
    private DoLogoutPresenter doLogoutPresenter;
    ViewDialog alert;
    ViewDialogOpenMobile openMobile;
    String numberr;

    public ProfileFragment() {

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

        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        //   AppTools.showRequestDialog(getActivity());

        setui(view);
        // getActivity().getSupportActionBar().setTitle();

        getState();

        DoMyprofile();

   /*  setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" "); */
        return view;
    }

    private void DoMyprofile() {
        presenter = new DoMyprofilePresenter(this);
        presenter.DoMyprofil(getActivity());
        AppTools.showRequestDialog(getActivity());


    }

    private void setui(View view) {
        alert = new ViewDialog();
        openMobile = new ViewDialogOpenMobile();
        IncompleteBooking_Tv = view.findViewById(R.id.IncompleteBooking_Tv);

        scrollView = view.findViewById(R.id.scroll_side_menu);
        tv_dashboardd = view.findViewById(R.id.tv_dashboardd);
        tv_myBooking = view.findViewById(R.id.tv_myBooking);
        tv_myProfile = view.findViewById(R.id.tv_myProfile);
        tv_myWallet = view.findViewById(R.id.tv_myWallet);
        tv_Financial = view.findViewById(R.id.tv_Financial);
        tv_changePassword = view.findViewById(R.id.tv_changePassword);
        tv_myReviews = view.findViewById(R.id.tv_myReviews);
        tv_myAddressbook = view.findViewById(R.id.tv_myAddressbook);
        tv_mySupport = view.findViewById(R.id.tv_mySupport);
        tv_referralDashboard = view.findViewById(R.id.tv_referralDashboard);
        arrowIvv = view.findViewById(R.id.arrowIvv);


        btn_addresssDetails = view.findViewById(R.id.btn_addresssDetails);
        doMyprofileUpdatePresenter = new DoMyprofileUpdatePresenter(this);
        uploadProfileImagePresenter = new UploadProfileImage_Presenter(this);


        ivCamera = view.findViewById(R.id.ivCamera);
        etprofile_name = view.findViewById(R.id.etprofile_name);
        etprofileEmail = view.findViewById(R.id.etprofileEmail);
        etprofileEmail.setEnabled(false);
        etprofilePhone = view.findViewById(R.id.etprofilePhone);


        ed_houseno = view.findViewById(R.id.ed_houseno);
        ed_nearby = view.findViewById(R.id.ed_nearby);
        ed_pincode = view.findViewById(R.id.ed_pincode);

        spinner_state = view.findViewById(R.id.spinner_state);
        spinner_city = view.findViewById(R.id.spinner_city);
        genderSpinner = view.findViewById(R.id.genderSpinner);


        circleImageView = view.findViewById(R.id.ivProfilePic);

        etprofilePhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMobile.showDialog();


            }
        });
        if (!ImagePath.checkPermissionss(getContext().getApplicationContext())) {
            ImagePath.requestPermission(getActivity());

        }
        setOnClickListener();

        ArrayAdapter<String> aa = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, gender);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//Setting the ArrayAdapter data on the Spinner
        genderSpinner.setAdapter(aa);
        genderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                genderr = parent.getItemAtPosition(position).toString().trim();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        tv_dashboardd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (arrowIvv.getRotation() == 0) {
                    arrowIvv.setRotation(-90);

                    scrollView.setVisibility(View.GONE);
                    AppUtils.collapse(scrollView);

                /*    if (scrollView.getVisibility() == View.VISIBLE) {
                        AppUtils.collapse(scrollView);
                    } else {
                        AppUtils.expand(scrollView);

                    }*/
                } else {
                    arrowIvv.setRotation(0);

                    scrollView.setVisibility(View.VISIBLE);
                    AppUtils.expand(scrollView);

                }
            }
        });

    }

    private void setOnClickListener() {

        btn_addresssDetails.setOnClickListener(this);
        ivCamera.setOnClickListener(this);

        tv_myBooking.setOnClickListener(this);
        tv_myProfile.setOnClickListener(this);
        tv_myWallet.setOnClickListener(this);
        tv_Financial.setOnClickListener(this);
        tv_changePassword.setOnClickListener(this);
        tv_myReviews.setOnClickListener(this);
        tv_myAddressbook.setOnClickListener(this);
        tv_mySupport.setOnClickListener(this);
        tv_referralDashboard.setOnClickListener(this);
        IncompleteBooking_Tv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch (v.getId()) {
            case R.id.btn_addresssDetails:
                updateProfile();

                break;
            case R.id.ivCamera:
                On_click_OpenGallery();
                break;

            case R.id.tv_Dashboard:
                // onBackPressed();


                Fragment homeFragment = new HomeFragment();
                fragmentTransaction.replace(R.id.fragment_Container, homeFragment);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
                break;
            case R.id.tv_myProfile:
                // onBackPressed();


                Fragment profileFragment = new ProfileFragment();
                fragmentTransaction.replace(R.id.fragment_Container, profileFragment);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
                break;
            case R.id.tv_Financial:
                // onBackPressed();

                Fragment Membership = new MyMemberShipFragment();
                fragmentTransaction.replace(R.id.fragment_Container, Membership);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
                break;
            case R.id.tv_myBooking:
                // onBackPressed();
               /* Fragment profileFragment = new ProfileFragment();
                fragmentTransaction.replace(R.id.fragment_Container,profileFragment);
                fragmentTransaction.commit();*/
                Fragment RecentBookingFragment = new RecentBookingFragment();
                fragmentTransaction.replace(R.id.fragment_Container, RecentBookingFragment);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();

                break;
            case R.id.tv_myWallet:
                // onBackPressed();
                Fragment myWalletFragment = new MyWalletFragment();
                fragmentTransaction.replace(R.id.fragment_Container, myWalletFragment);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
                break;
            case R.id.tv_changePassword:
                // onBackPressed();
                Fragment changePasswordFragment = new ChangePasswordFragment();
                fragmentTransaction.replace(R.id.fragment_Container, changePasswordFragment);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
                break;
            case R.id.IncompleteBooking_Tv:
                // onBackPressed();

                Fragment IncompleteBookingFragment = new IncompleteBookingFragment();
                fragmentTransaction.replace(R.id.fragment_Container, IncompleteBookingFragment);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
                break;
            case R.id.tv_myReviews:
                // onBackPressed();

                Fragment reviewRatingFragment = new ReviewRatingFragment();
                fragmentTransaction.replace(R.id.fragment_Container, reviewRatingFragment);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
                break;
            case R.id.tv_myAddressbook:
                // onBackPressed();

                Fragment addressFragment = new AddressFragment();
                fragmentTransaction.replace(R.id.fragment_Container, addressFragment);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
                break;
            case R.id.tv_mySupport:
                // onBackPressed();


                Fragment tabs = new SupportTicketsFragment();
                fragmentTransaction.replace(R.id.fragment_Container, tabs);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
                break;
            case R.id.tv_referralDashboard:
                // onBackPressed();

                Fragment ReferralUser = new ReferralUserFragment();
                fragmentTransaction.replace(R.id.fragment_Container, ReferralUser);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
                break;


        }

    }


    @Override
    public void onDoMyprofileError(String message) {
        AppTools.hideDialog();

        Log.e("onDoMyprofileError", message);

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


        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            if (data == null)
                return;

            Uri uri = data.getData();
            System.out.println("urii  " + uri + " " + uri.getPath());
            String path = ImagePath.getPath(getActivity().getApplicationContext(), uri);
            System.out.println("urii path " + path);

            imageUri = data.getData();
            //circleImageView.setImageURI(imageUri);
            if (path != null && !path.equals("")) {
                File file = new File(path);
                uploadImage(file);
            }
        }
    }

    private void uploadImage(File file) {
        //  AppTools.showGifDialog(getActivity(), globalloader);

        Log.e("filefile", String.valueOf(file));

        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part image = MultipartBody.Part.createFormData("image", file.getName(), requestFile);
        uploadProfileImagePresenter.uploadImage(image, getActivity().getApplicationContext());
    }

    @Override
    public void onDoMyprofileSuccess(Profile_Repo response, String message) {
        AppTools.hideDialog();

        if (message.equalsIgnoreCase("ok")) {

            if (response.getData().getProfile().getProfilePhotoPath() != null) {

                Picasso.get().load(response.getData().getProfile().getProfilePhotoPath()).into(circleImageView);

            }

            etprofile_name.setText(response.getData().getProfile().getName());

            etprofileEmail.setText(response.getData().getProfile().getEmail());
            etprofilePhone.setText(response.getData().getProfile().getMobileNumber());

            //   Toast.makeText(this, genderid+"", Toast.LENGTH_SHORT).show();

            // spinner_state.setPrompt();


            state_id = response.getData().getProfile().getStateId().trim();

            city_id = response.getData().getProfile().getCityId().trim();
            ed_houseno.setText(response.getData().getProfile().getAddress().trim());
            ed_nearby.setText(response.getData().getProfile().getLandmark().trim());
            ed_pincode.setText(response.getData().getProfile().getPincode().trim());
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
                                                spinner_city.setSelection(j);

                                            }
                                        }


                                    }
                                }, SPLASH_TIME_OUT);


                            }
                        }
                        // GetCity(state_id);

                    }

                    if (response.getData().getServeAlertMsg() != null) {
                        AlertDialogBox(response.getData().getServeAlertMsg());
                    }
                }
            }, SPLASH_TIME_OUT);

            if (response.getData().getProfile().getGender() != null) {
                genderid = response.getData().getProfile().getGender().trim();
                if (genderid.equalsIgnoreCase("Male")) {
                    genderSpinner.setSelection(1);

                } else if (genderid.equalsIgnoreCase("Female")) {

                    genderSpinner.setSelection(2);

                } else if (genderid.equalsIgnoreCase("Transgender")) {

                    genderSpinner.setSelection(3);
                } else {

                    genderSpinner.setSelection(0);
                }
            }


        }


    }

    @Override
    public void onDoMyprofileFailure(Throwable t) {
        AppTools.hideDialog();

        Log.e("onDoMyprofileFailure", t.getLocalizedMessage());

    }


    private void getState() {

        stateModelList = new ArrayList<StateModel>();
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
                        AppTools.hideDialog();

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
                            AppTools.hideDialog();


                            //   Toast.makeText(VenderReg.this, jsonObject2.getString("id") + "", Toast.LENGTH_SHORT).show();

                        }
                        /*
                         */
                    } catch (IOException | JSONException e) {
                        e.printStackTrace();
                    }

                    StateSpinnerUpdateAdapter coinSpinnerAdapter = new StateSpinnerUpdateAdapter(getActivity().getApplicationContext(), stateModelList, state_id);

                    spinner_state.setAdapter(coinSpinnerAdapter);
                    spinner_state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                            //  spinnertextview.setTextColor(Color.WHITE);
                            state_id = stateModelList.get(position).getId();


                            GetCity(state_id);

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
                AppTools.hideDialog();

                Toast.makeText(getActivity(), t.getLocalizedMessage() + "", Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void GetCity(String id) {
        AppTools.showRequestDialog(getActivity());


        cityModelList = new ArrayList<>();
        CityModel stateModel = new CityModel();
        ;
        Call<ResponseBody> bodyCall = ApiClientt.getUserService().GetCity(id);

        bodyCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.e("responseee", String.valueOf(response.code()));
//       Toast.makeText(VenderReg.this, response.code(), Toast.LENGTH_SHORT).show();
                // Toast.makeText(VenderReg.this, response.body().getLocale()+"", Toast.LENGTH_SHORT).show();
                AppTools.hideDialog();

                String s = null;
                cityModelList.clear();

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    AppTools.hideDialog();


                    try {
                        s = response.body().string();
                        Log.e("response", s);
                        stateModel.setName("Select City");
                        stateModel.setId("00");

                        cityModelList.add(0, stateModel);

                        // Toast.makeText(ProfileActivity.this, s + "", Toast.LENGTH_SHORT).show();
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
                    spinner_city.setAdapter(coinSpinnerAdapter);
                    spinner_city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            try {

                                city_id = cityModelList.get(position).getId();

                            } catch (Exception e) {

                            }
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
    public void onDoMyprofileUpdateError(String message) {
        Sneaker.with(getActivity())
                .setTitle("Mobile number OR Email  already exist in our record.")
                .setMessage("")
                .sneakError();
        AppTools.hideDialog();


    }

    @Override
    public void onDoMyprofileUpdateSuccess(UpdateProfileRepo response, String message) {
     /*   Sneaker.with(this)
                .setTitle(message)
                .setMessage("")
                .sneakError();*/
        //AppTools.hideGifDialog();
            Log.e("checkkkkk", response.toString());

        if (message.equalsIgnoreCase("ok")) {

            //  Toast.makeText(this, response.getMessage() + "", Toast.LENGTH_SHORT).show();
            Sneaker.with(getActivity())
                    .setTitle(response.getMessage())
                    .setMessage("")
                    .sneakSuccess();
         ///   presenter.DoMyprofil(getActivity());

            if (response.getData().getMobileUpdated().trim().equalsIgnoreCase("Yes")) {


                presenter.DoMyprofil(getActivity());

            } else {
                Sneaker.with(getActivity())
                        .setTitle(response.getMessage())
                        .setMessage("")
                        .sneakSuccess();
                presenter.DoMyprofil(getActivity());

            }

        }
        //  startActivity(new Intent(this, MainActivity.class));


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
    public void onDoMyprofileUpdateFailure(Throwable t) {
        Sneaker.with(getActivity())
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();
        AppTools.hideDialog();

    }


    private void updateProfile() {
        //EditText etprofile_name,etprofileEmail,etprofilePhone,ed_houseno,ed_nearby,ed_pincode;

        String name = etprofile_name.getText().toString().trim();
        String email = etprofileEmail.getText().toString().trim();
        String phone = etprofilePhone.getText().toString().trim();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Sneaker.with(getActivity())
                    .setTitle("Enter your Valid email!")
                    .setMessage("")
                    .sneakError();
        } else if (genderr.equalsIgnoreCase("Select Gender")) {
            Sneaker.with(getActivity())
                    .setTitle("Select Gender!")
                    .setMessage("")
                    .sneakError();
        } else if (state_id.equalsIgnoreCase("00")) {
            Sneaker.with(getActivity())
                    .setTitle("Select  State!")
                    .setMessage("")
                    .sneakError();
        } else if (city_id.equalsIgnoreCase("00")) {
            Sneaker.with(getActivity())
                    .setTitle("Select  City!")
                    .setMessage("")
                    .sneakError();
        } else {
            // AppTools.showGifDialog(getActivity(), globalloader);

            UpdateProfile_request updateProfile_request = new UpdateProfile_request(name, genderr, email, phone, state_id, city_id,
                    ed_houseno.getText().toString().trim(), ed_nearby.getText().toString().trim(), ed_pincode.getText().toString().trim());
            doMyprofileUpdatePresenter.DoMyprofil(getActivity(), updateProfile_request);
        }

    }

    public void On_click_OpenGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override

    public void onUploadProfileImageError(String message) {
        AppTools.hideDialog();


        Sneaker.with(getActivity())
                .setTitle(message)
                .setMessage("")
                .sneakSuccess();

    }

    @Override
    public void onUploadProfileImageSuccess(Profile_Repo response, String message) {
        //  Toast.makeText(this, message+"", Toast.LENGTH_SHORT).show();
        if (message.equalsIgnoreCase("ok")) {
            AppTools.hideDialog();

            Sneaker.with(getActivity())
                    .setTitle("Profile Updated Successfully")
                    .setMessage("")
                    .sneakSuccess();
            presenter.DoMyprofil(getActivity());

        }


    }

    @Override
    public void onUploadProfileImageFailure(Throwable t) {
        AppTools.hideDialog();

        Sneaker.with(getActivity())
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();
        //   Toast.makeText(this, t.getLocalizedMessage()+"", Toast.LENGTH_SHORT).show();

    }


    public class ViewDialog implements VerifyMobilePresenter

            .VerifyOtpView {


        Dialog dialog;
        PinView pinView;
        TextView otpContinue, exit;


        public void showDialog() {
            dialog = new Dialog(getContext());
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.otpverification);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            WindowManager.LayoutParams wmlp = dialog.getWindow().getAttributes();
//            wmlp.x = 30;   //x position
            wmlp.y = 300;   //y position

            wmlp.gravity = Gravity.TOP;

            VerifyMobilePresenter presenter = new VerifyMobilePresenter(this);

            pinView = dialog.findViewById(R.id.pinview);
            otpContinue = dialog.findViewById(R.id.otpContinue);
            exit = dialog.findViewById(R.id.exit);
            otpContinue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String otp = pinView.getText().toString();
                    if (otp.length() < 4) {
                        Sneaker.with(getActivity())
                                .setTitle("Enter OTP!")
                                .setMessage("")
                                .sneakError();


                    } else {
                        presenter.VerifyMobile(getActivity(), otp, numberr);


                    }

                }
            });

            exit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            dialog.show();
        }


        @Override
        public void onVerifyOtpError(String message) {
            Sneaker.with(getActivity())
                    .setTitle(message)
                    .setMessage("")
                    .sneakError();

        }

        @Override
        public void onVerifyOtpSuccess(ResponseBody response, String message) {
            if (message.equalsIgnoreCase("ok")) {
                Sneaker.with(getActivity())
                        .setTitle("Congratulations, your mobile number is verified.")
                        .setMessage("")
                        .sneakSuccess();
                dialog.dismiss();
                presenter.DoMyprofil(getActivity());

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
        public void onVerifyOtpFailure(Throwable t) {
            Sneaker.with(getActivity())
                    .setTitle(t.getLocalizedMessage())
                    .setMessage("")
                    .sneakError();


        }
    }

    public class ViewDialogOpenMobile implements SendOtpMobileUpdatePresenter

            .SendOtpMobileUpdateView {


        Dialog dialog;
        TextView otpContinue, exit;
        EditText number;
        SendOtpMobileUpdatePresenter presenter;

        public void showDialog() {
            dialog = new Dialog(getContext());
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.activity_senddilog);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            WindowManager.LayoutParams wmlp = dialog.getWindow().getAttributes();
//            wmlp.x = 30;   //x position
            wmlp.y = 300;   //y position

            wmlp.gravity = Gravity.TOP;

            presenter = new SendOtpMobileUpdatePresenter(this);
            otpContinue = dialog.findViewById(R.id.otpContinue);
            number = dialog.findViewById(R.id.number);
            exit = dialog.findViewById(R.id.exit);
            exit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            otpContinue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    numberr = number.getText().toString();
                    if (numberr.length() != 10) {
                        Sneaker.with(getActivity())
                                .setTitle("Enter New Number")
                                .setMessage("")
                                .sneakError();
                        Toast.makeText(getContext(), "Enter New Number", Toast.LENGTH_SHORT).show();

                    } else {

                        presenter.SendOtpMobileUpdate(getContext(), numberr);

                    }

                }
            });


            dialog.show();
        }


        @Override
        public void onSendOtpMobileError(String message) {
            Sneaker.with(getActivity())
                    .setTitle(message)
                    .setMessage("")
                    .sneakError();
        }

        @Override
        public void onSendOtpMobileSuccess(ResponseBody response, String message) {
            if (message.equalsIgnoreCase("ok")) {
                Sneaker.with(getActivity())
                        .setTitle("OTP Successfully Send On Your New Mobile Number For Verification")
                        .setMessage("")
                        .sneakSuccess();

                dialog.dismiss();
                alert.showDialog();

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
        public void onSendOtpMobileFailure(Throwable t) {
            Sneaker.with(getActivity())
                    .setTitle(t.getLocalizedMessage())
                    .setMessage("")
                    .sneakError();
        }
    }

    public void AlertDialogBox(String msg) {

        //Logout
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());

        // set title
        alertDialogBuilder.setTitle(" ");
        // set dialog message
       // alertDialogBuilder.setIcon(R.drawable.logoo1);
        alertDialogBuilder
                .setMessage(msg)
                .setCancelable(false)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }

}





