package com.serviingo.serviingo.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.Activity.Auth.LoginActivity;
import com.serviingo.serviingo.Adapterr.CitySpinnerAdapter;
import com.serviingo.serviingo.Adapterr.StateSpinnerUpdateAdapter;
import com.serviingo.serviingo.Common.Preferences;
import com.serviingo.serviingo.Database.AppSettings;
import com.serviingo.serviingo.ViewPresenter.DoLogoutPresenter;
import com.serviingo.serviingo.ViewPresenter.DoMyprofilePresenter;
import com.serviingo.serviingo.ViewPresenter.DoMyprofileUpdatePresenter;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.Rtrofit.ApiClientt;
import com.serviingo.serviingo.ViewPresenter.UploadProfileImage_Presenter;
import com.serviingo.serviingo.model.CityModel;
import com.serviingo.serviingo.model.StateModel;
import com.serviingo.serviingo.modelrepo.Responsee.Profile_Repo;
import com.serviingo.serviingo.modelrepo.Responsee.UpdateProfileRepo;
import com.serviingo.serviingo.modelrepo.request.UpdateProfile_request;
import com.serviingo.serviingo.storage.SharedPrefManager;
import com.serviingo.serviingo.utils.AppUtils;
import com.serviingo.serviingo.utils.ImagePath;
import com.serviingo.serviingo.view.BaseActivity;
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

import static com.serviingo.serviingo.R.drawable.globalloader;

public class ProfileActivity extends BaseActivity implements View.OnClickListener, DoMyprofilePresenter.DoMyprofileView, DoMyprofileUpdatePresenter.DoMyprofileUpdateView, UploadProfileImage_Presenter.UploadProfileImageView ,DoLogoutPresenter.DoLogoutView {

    TextView btn_addresssDetails;
    ImageView imageView, ivNav,ivBack;
    RelativeLayout rlDashBoard, rr_home, rr_category, rr_recharge, rrInsurance,
            rr_About, rr_Contact;
    public static ScrollView scrollView;
    DoMyprofilePresenter presenter;
    CircleImageView circleImageView;

    EditText etprofile_name, etprofileEmail, etprofilePhone, ed_houseno, ed_nearby, ed_pincode;


    StateModel stateModel;
    ArrayList<StateModel> stateModelList;
    ArrayList<CityModel> cityModelList;

    Spinner spinner_state, spinner_city, genderSpinner;
    String state_id, city_id, genderr;
    String[] gender = {"Select Gender", "Male", "Female", "Transgender "};//array of strings used to populate the spinner
    DoMyprofileUpdatePresenter doMyprofileUpdatePresenter;
    UploadProfileImage_Presenter uploadProfileImagePresenter;

    Preferences pref;
    String genderid;

    private static final int PICK_IMAGE = 100;

    Uri imageUri;
    private DoLogoutPresenter doLogoutPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profileactivity);
        AppTools.showGifDialog(mActivity, globalloader);

        setui();
        DoMyprofile();
        getState();

    }

    private void DoMyprofile() {
        presenter = new DoMyprofilePresenter(this);
        presenter.DoMyprofil(this);

    }

    private void setui() {
        doLogoutPresenter=new DoLogoutPresenter(this);

        btn_addresssDetails = findViewById(R.id.btn_addresssDetails);
        doMyprofileUpdatePresenter = new DoMyprofileUpdatePresenter(this);
        uploadProfileImagePresenter = new UploadProfileImage_Presenter(this);
        pref = new Preferences(mActivity);

        ivNav= findViewById(R.id.ivNav);
        ivBack = findViewById(R.id.ivBack);
        scrollView = findViewById(R.id.scroll_side_menu);
        rlDashBoard = findViewById(R.id.rlDashBoard);
        rr_home = findViewById(R.id.rr_home);
        rr_category = findViewById(R.id.rr_category);
        rr_recharge = findViewById(R.id.rr_recharge);
        rrInsurance = findViewById(R.id.rrInsurance);
        rr_About = findViewById(R.id.rr_About);
        rr_Contact = findViewById(R.id.rr_Contact);


        etprofile_name = findViewById(R.id.etprofile_name);
        etprofileEmail = findViewById(R.id.etprofileEmail);
        etprofilePhone = findViewById(R.id.etprofilePhone);
        ed_houseno = findViewById(R.id.ed_houseno);
        ed_nearby = findViewById(R.id.ed_nearby);
        ed_pincode = findViewById(R.id.ed_pincode);

        spinner_state = findViewById(R.id.spinner_state);
        spinner_city = findViewById(R.id.spinner_city);
        genderSpinner = findViewById(R.id.genderSpinner);


        circleImageView = findViewById(R.id.ivProfilePic);

        if (!ImagePath.checkPermissionss(getApplicationContext())) {
            ImagePath.requestPermission(this);
        }
        setOnClickListener();

        ArrayAdapter<String> aa = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, gender);
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


    }

    private void setOnClickListener() {

        btn_addresssDetails.setOnClickListener(this);


        rlDashBoard.setOnClickListener(this);
        rr_home.setOnClickListener(this);
        rr_category.setOnClickListener(this);
        rr_recharge.setOnClickListener(this);
        rrInsurance.setOnClickListener(this);
        rr_About.setOnClickListener(this);
        rr_Contact.setOnClickListener(this);
          ivBack.setOnClickListener(this);
        ivNav.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_addresssDetails:
                updateProfile();

                break;

            case R.id.ivNav:
                if (AppSettings.getString(AppSettings.id).isEmpty()) {
                    if (scrollView.getVisibility() == View.VISIBLE) {
                        AppUtils.collapse(scrollView);
                        break;
                    }
                    AppUtils.expand(scrollView);
                } else {
                    if (scrollView.getVisibility() == View.VISIBLE) {

                        AppUtils.collapse(scrollView);
                        break;
                    }
                    AppUtils.expand(scrollView);
                }

                break;
            case R.id.ivBack:
                onBackPressed();
                break;
            case R.id.rlDashBoard:
                //samepage
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.rr_home:
                //My Booking
                startActivity(new Intent(this, MyBookingActivity.class));
                break;
            case R.id.rr_category:
                //My Profile
                startActivity(new Intent(this, ProfileActivity.class));
                break;
            case R.id.rr_recharge:
                //My Wallet
                startActivity(new Intent(this, MyWalletActivity.class));
                break;
            case R.id.rrInsurance:
                //Logout
                AlertDialogBox();

                break;
            case R.id.rr_About:
                startActivity(new Intent(this, AboutUs.class));
                break;
            case R.id.rr_Contact:
                startActivity(new Intent(this, ContactUsActivity.class));
                break;
          /*  case R.id.rr_register:
                startActivity(new Intent(this, SignUpActivity.class));
                break;
            case R.id.rrsignin:
                startActivity(new Intent(this, LoginActivity.class));
                break;*/


        }
    }

    @Override
    public void onDoMyprofileError(String message) {
        AppTools.hideGifDialog();

        Log.e("onDoMyprofileError", message);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        System.out.println("requestCode" + requestCode);
        switch (requestCode) {
            case ImagePath.REquestPermissionCode:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permissin Granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Permissin Deined", Toast.LENGTH_SHORT).show();
                }


        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
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
            String path   = ImagePath.getPath(getApplicationContext(), uri);
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
        AppTools.showGifDialog(mActivity, globalloader);

        Log.e("filefile", String.valueOf(file));


      /*  File file = new File(path);
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part image =
                MultipartBody.Part.createFormData("profile_image", file.getName(), requestFile);*/

        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part image = MultipartBody.Part.createFormData("image", file.getName(), requestFile);
        uploadProfileImagePresenter.uploadImage(image, getApplicationContext());
    }

    @Override
    public void onDoMyprofileSuccess(Profile_Repo response, String message) {
        AppTools.hideGifDialog();

        if (message.equalsIgnoreCase("ok")) {

            Picasso.get().load(response.getData().getProfile().getProfilePhotoPath()).into(circleImageView);
            etprofile_name.setText(response.getData().getProfile().getName());

            etprofileEmail.setText(response.getData().getProfile().getEmail());
            etprofilePhone.setText(response.getData().getProfile().getMobileNumber());
            genderid = response.getData().getProfile().getGender().trim();
         //   Toast.makeText(this, genderid+"", Toast.LENGTH_SHORT).show();

           // spinner_state.setPrompt();


            if (genderid.equalsIgnoreCase("Male")) {
                genderSpinner.setSelection(1);

            } else if (genderid.equalsIgnoreCase("Female")) {

                genderSpinner.setSelection(2);

            } else if (genderid.equalsIgnoreCase("Transgender")) {

                genderSpinner.setSelection(3);
            } else {

                genderSpinner.setSelection(0);
            }
            state_id = response.getData().getProfile().getStateId().trim();

            city_id = response.getData().getProfile().getCityId().trim();
            ed_houseno.setText(response.getData().getProfile().getAddress().trim());
            ed_nearby.setText(response.getData().getProfile().getLandmark().trim());
            ed_pincode.setText(response.getData().getProfile().getPincode().trim());


        }


    }

    @Override
    public void onDoMyprofileFailure(Throwable t) {
        AppTools.hideGifDialog();

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
                        AppTools.hideGifDialog();

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


                            //   Toast.makeText(VenderReg.this, jsonObject2.getString("id") + "", Toast.LENGTH_SHORT).show();

                        }
                        /*
                         */
                    } catch (IOException | JSONException e) {
                        e.printStackTrace();
                    }

                    StateSpinnerUpdateAdapter coinSpinnerAdapter = new StateSpinnerUpdateAdapter(getApplicationContext(), stateModelList, state_id);

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
                AppTools.hideGifDialog();

                Toast.makeText(ProfileActivity.this, t.getLocalizedMessage() + "", Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void GetCity(String id) {
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

                String s = null;
                cityModelList.clear();

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    AppTools.hideGifDialog();

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
                    AppTools.hideGifDialog();

                    CitySpinnerAdapter coinSpinnerAdapter = new CitySpinnerAdapter(getApplicationContext(), cityModelList);
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
                Toast.makeText(ProfileActivity.this, t.getLocalizedMessage() + "", Toast.LENGTH_SHORT).show();

            }
        });


    }

    @Override
    public void onDoMyprofileUpdateError(String message) {
        Sneaker.with(this)
                .setTitle("Mobile number OR Email  already exist in our record.")
                .setMessage("")
                .sneakError();
        AppTools.hideGifDialog();


    }

    @Override
    public void onDoMyprofileUpdateSuccess(UpdateProfileRepo response, String message) {
     /*   Sneaker.with(this)
                .setTitle(message)
                .setMessage("")
                .sneakError();*/
        //AppTools.hideGifDialog();


        if (message.equalsIgnoreCase("ok")) {

          //  Toast.makeText(this, response.getMessage() + "", Toast.LENGTH_SHORT).show();

                Sneaker.with(this)
                        .setTitle(response.getMessage() )
                        .setMessage("")
                        .sneakSuccess();
                presenter.DoMyprofil(this);

            }
          //  startActivity(new Intent(this, MainActivity.class));



    }

    @Override
    public void showHideProgress(boolean isShow) {

    }

    @Override
    public void onDoMyprofileUpdateFailure(Throwable t) {
        Sneaker.with(this)
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();
        AppTools.hideGifDialog();

    }


    private void updateProfile() {
        //EditText etprofile_name,etprofileEmail,etprofilePhone,ed_houseno,ed_nearby,ed_pincode;

        String name = etprofile_name.getText().toString().trim();
        String email = etprofileEmail.getText().toString().trim();
        String phone = etprofilePhone.getText().toString().trim();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Sneaker.with(this)
                    .setTitle("Enter your Valid email!")
                    .setMessage("")
                    .sneakError();
        } else if (genderr.equalsIgnoreCase("Select Gender")) {
            Sneaker.with(this)
                    .setTitle("Select Gender!")
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
            AppTools.showGifDialog(mActivity, globalloader);

            UpdateProfile_request updateProfile_request = new UpdateProfile_request(name, genderr, email, phone, state_id, city_id,
                    ed_houseno.getText().toString().trim(), ed_nearby.getText().toString().trim(), ed_pincode.getText().toString().trim());
            doMyprofileUpdatePresenter.DoMyprofil(ProfileActivity.this, updateProfile_request);
        }

    }

    public void On_click_OpenGallery(View view) {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    public void onUploadProfileImageError(String message) {

        Toast.makeText(this, message+"", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUploadProfileImageSuccess(Profile_Repo response   , String message) {
      //  Toast.makeText(this, message+"", Toast.LENGTH_SHORT).show();
        if (message.equalsIgnoreCase("ok")) {
            Sneaker.with(this)
                    .setTitle("Profile Updated Successfully")
                    .setMessage("")
                    .sneakSuccess();
            presenter.DoMyprofil(this);

        }


    }

    @Override
    public void onUploadProfileImageFailure(Throwable t) {
        Sneaker.with(this)
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();
     //   Toast.makeText(this, t.getLocalizedMessage()+"", Toast.LENGTH_SHORT).show();

    }
    public void AlertDialogBox(){

        //Logout
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ProfileActivity.this);

        // set title
        alertDialogBuilder.setTitle("SERVIINGO");

        // set dialog message
        alertDialogBuilder.setIcon(R.mipmap.logo);
        alertDialogBuilder
                .setMessage("Are you sure to Logout !!!!!")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        doLogoutPresenter.DoLogout(ProfileActivity.this);

                    }
                })
                .setNegativeButton("No",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();

                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }

    @Override
    public void onDoLogoutError(String message) {
        AppTools.hideGifDialog();
        Sneaker.with(this)
                .setTitle(message)
                .setMessage("")
                .sneakError();

    }

    @Override
    public void onDoLogoutSuccess(ResponseBody response, String message) {
        if (message.equalsIgnoreCase("ok"))
        {
            Toast.makeText(this, "User Logout Successfully.", Toast.LENGTH_SHORT).show();

            SharedPrefManager.getInstans(getApplicationContext()).clear();
            AppSettings.putString(AppSettings.mobile, "");
            AppSettings.putString(AppSettings.loginCheck, "");

            //userprofile data
            AppSettings.putString(AppSettings.id, "");
            AppSettings.putString(AppSettings.name, "");
            AppSettings.putString(AppSettings.email, "");
            AppSettings.putString(AppSettings.gender, "");
            AppSettings.putString(AppSettings.mobile, "");
            AppSettings.putString(AppSettings.wallet, "");
            AppSettings.putString(AppSettings.dob, "");
            AppSettings.putString(AppSettings.user_pic, "");
            AppSettings.putString(AppSettings.referralId, "");
            AppSettings.putString(AppSettings.profilePic, "");

            AppSettings.putString(AppSettings.googleName, "");
            AppSettings.putString(AppSettings.googleEmail, "");
            AppSettings.putString(AppSettings.googledob, "");
            AppSettings.putString(AppSettings.googleId, "");

            AppSettings.putString(AppSettings.fbname, "");
            AppSettings.putString(AppSettings.fbId, "");
            pref.set(AppSettings.loginCheck,"false");
            pref.commit();
            AppTools.hideGifDialog();

            startActivity(new Intent(this, LoginActivity.class));
        }


    }

    @Override
    public void onDoLogoutFailure(Throwable t) {
        AppTools.hideGifDialog();
        Sneaker.with(this)
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();


    }
}
