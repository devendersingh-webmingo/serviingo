package com.serviingo.serviingo.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.irozon.sneaker.Sneaker;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.utils.AppUrls;
import com.serviingo.serviingo.utils.CheckInternetConnection;
import com.serviingo.serviingo.utils.util;

import org.json.JSONObject;

public class ContactUsFragment extends Fragment implements View.OnClickListener {

    TextView tvLoaction, tvCall, tvEmail, tvSubmit;

    TextView tv_home, tvreferdesc;
    String pinterest_linklink, facebook_linklink, linkedin_linklink, youtube_linklink, insta_linklink;

    EditText etPostName, etPostEmail, etPostPhone, etPostSubject, ACTV;

    public ContactUsFragment() {
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


        View view = inflater.inflate(R.layout.fragment_contact_us, container, false);
        findViewById(view);


        // getActivity().getSupportActionBar().setTitle();


   /*  setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" "); */
        return view;
    }

    private void findViewById(View view) {
        tvLoaction = view.findViewById(R.id.tvLoaction);
        tvCall = view.findViewById(R.id.tvCall);
        tvEmail = view.findViewById(R.id.tvEmail);
        tvreferdesc = view.findViewById(R.id.tvreferdesc);

//        referImageview=findViewById(R.id.referImageview);
        etPostName = view.findViewById(R.id.etPostName);
        etPostEmail = view.findViewById(R.id.etPostEmail);
        etPostPhone = view.findViewById(R.id.etPostPhone);
        etPostSubject = view.findViewById(R.id.etPostSubject);
        tvSubmit = view.findViewById(R.id.tvSubmit);
        ACTV = view.findViewById(R.id.ACTV);


        tv_home = view.findViewById(R.id.tv_home);


        setOnclickistener();

        if (util.isOnline(getActivity().getApplicationContext())) {
            getContactApi();
        } else {
            new CheckInternetConnection(getContext()).checkConnection();

            Sneaker.with(this)
                    .setTitle(getResources().getString(R.string.noconnection))
                    .setMessage("")
                    .sneakError();
        }

    }

    private void setOnclickistener() {

        tvSubmit.setOnClickListener(this);

        tv_home.setOnClickListener(this);
        // ivNav.setOnClickListener(this);


    }

    private void PostContactApi() {
        String url = AppUrls.PostContact;
        AndroidNetworking.post(url)
                .addBodyParameter("name", etPostName.getText().toString().trim())
                .addBodyParameter("email", etPostEmail.getText().toString().trim())
                .addBodyParameter("mobile", etPostPhone.getText().toString().trim())
                .addBodyParameter("subject", etPostSubject.getText().toString().trim())
                .addBodyParameter("message", ACTV.getText().toString().trim())
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        parseJsonResponse(response);
                    }

                    @Override
                    public void onError(ANError error) {
                        // handle error
                        if (error.getErrorCode() != 0) {
                            Log.d("onError errorCode ", "onError errorCode : " + error.getErrorCode());
                            Log.d("onError errorBody", "onError errorBody : " + error.getErrorBody());
                            Log.d("onError errorDetail", "onError errorDetail : " + error.getErrorDetail());
                        } else {
                            Toast.makeText(getContext(), String.valueOf(error.getErrorDetail()), Toast.LENGTH_SHORT).show();
                            //  AppUtils.showErrorMessage(etNewpassword, String.valueOf(error.getErrorDetail()), mActivity);
                        }
                    }
                });
    }

    private void parseJsonResponse(JSONObject response) {
        try {
            String message = response.getString("message");
            //      Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();
            if (response.getString("status").equals("true")) {
                JSONObject jsonObject = response.getJSONObject("data");
                JSONObject contact_infoobj = jsonObject.getJSONObject("query");
                String name = contact_infoobj.getString("name");
                String email = contact_infoobj.getString("email");
                String mobile_number = contact_infoobj.getString("mobile_number");
                String subject = contact_infoobj.getString("subject");
                String query = contact_infoobj.getString("query");
                String updated_at = contact_infoobj.getString("updated_at");
                String created_at = contact_infoobj.getString("created_at");
                String id = contact_infoobj.getString("id");


                Sneaker.with(getActivity())
                        .setTitle("Submit Successfully.Get touch soon.")
                        .setMessage("")
                        .sneakSuccess();

                //  Toast.makeText(getContext(), name+email+mobile_number+subject+query+updated_at+created_at+id, Toast.LENGTH_SHORT).show();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment homeFragment = new HomeFragment();
                fragmentTransaction.replace(R.id.fragment_Container, homeFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                //   startActivity(new Intent(getContext(), RefundPolicy.class));
            } else {
            }
        } catch (Exception e) {
            Log.v("error", String.valueOf(e));
        }
    }


    private void getContactApi() {
        String url = AppUrls.getcontactcontent;
        Log.v("faq_url", url);
        AndroidNetworking.get(url)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        parsePostJsonResponse(response);
                    }

                    @Override
                    public void onError(ANError error) {
                        Log.v("data", error.getErrorBody());
                        Log.v("data", error.getErrorDetail());
                    }
                });
    }

    private void parsePostJsonResponse(JSONObject response) {
        try {
            String message = response.getString("message");
            //  Toast.makeText(getContext(), ""+message, Toast.LENGTH_SHORT).show();
            if (response.getString("status").equals("true")) {
                JSONObject jsonObject = response.getJSONObject("data");
                JSONObject contact_infoobj = jsonObject.getJSONObject("contact_info");
                String contact_infoid = contact_infoobj.getString("id");

                String email = contact_infoobj.getString("email");
                tvEmail.setText(email);
                String contact_infoaddress = contact_infoobj.getString("address");
                tvLoaction.setText(contact_infoaddress);
                String numbers = contact_infoobj.getString("numbers");
                tvCall.setText(numbers);

                String contact_infodescription = contact_infoobj.getString("created_at");
                String section1_heading = contact_infoobj.getString("updated_at");

                JSONObject refer_and_earnobj = jsonObject.getJSONObject("refer_and_earn");
                String id = refer_and_earnobj.getString("id");
                String slug = refer_and_earnobj.getString("slug");
                String heading = refer_and_earnobj.getString("heading");
                String title = refer_and_earnobj.getString("title");
                tvreferdesc.setText(title);
                String description = refer_and_earnobj.getString("description");
                String images = refer_and_earnobj.getString("images");

                String categories_ids = refer_and_earnobj.getString("categories_ids");
                String created_at = refer_and_earnobj.getString("created_at");
                String updated_at = refer_and_earnobj.getString("updated_at");


                JSONObject facebook_linkobj = jsonObject.getJSONObject("facebook_link");
                String facebook_linkid = facebook_linkobj.getString("id");
                String facebook_linkslug = facebook_linkobj.getString("slug");
                facebook_linklink = facebook_linkobj.getString("link");
                String facebook_linkcreated_at = facebook_linkobj.getString("created_at");
                String facebook_linkupdated_at = facebook_linkobj.getString("updated_at");

                JSONObject twitter_linkobj = jsonObject.getJSONObject("twitter_link");
                String twitter_linkid = twitter_linkobj.getString("id");
                String twitter_linkslug = twitter_linkobj.getString("slug");
                String twitter_linklink = twitter_linkobj.getString("link");
                String twitter_linkcreated_at = twitter_linkobj.getString("created_at");
                String twitter_linkupdated_at = twitter_linkobj.getString("updated_at");

                JSONObject insta_linkobj = jsonObject.getJSONObject("insta_link");
                String insta_linkid = twitter_linkobj.getString("id");
                String insta_linkslug = twitter_linkobj.getString("slug");
                insta_linklink = twitter_linkobj.getString("link");
                String insta_linkcreated_at = twitter_linkobj.getString("created_at");
                String insta_linkupdated_at = twitter_linkobj.getString("updated_at");

                JSONObject youtube_linkobj = jsonObject.getJSONObject("youtube_link");
                String youtube_linkid = youtube_linkobj.getString("id");
                String youtube_linkslug = youtube_linkobj.getString("slug");
                youtube_linklink = youtube_linkobj.getString("link");
                String youtube_linkcreated_at = youtube_linkobj.getString("created_at");
                String youtube_linkupdated_at = youtube_linkobj.getString("updated_at");

                JSONObject linkedin_linkobj = jsonObject.getJSONObject("linkedin_link");
                String linkedin_linkid = linkedin_linkobj.getString("id");
                String linkedin_linkslug = linkedin_linkobj.getString("slug");
                linkedin_linklink = linkedin_linkobj.getString("link");
                String linkedin_linkcreated_at = linkedin_linkobj.getString("created_at");
                String linkedin_linkupdated_at = linkedin_linkobj.getString("updated_at");

                JSONObject pinterest_linkobj = jsonObject.getJSONObject("pinterest_link");
                String pinterest_linkid = pinterest_linkobj.getString("id");
                String pinterest_linkslug = pinterest_linkobj.getString("slug");
                pinterest_linklink = pinterest_linkobj.getString("link");
                String pinterest_linkcreated_at = pinterest_linkobj.getString("created_at");
                String pinterest_linkupdated_at = pinterest_linkobj.getString("updated_at");

            } else {
            }
        } catch (Exception e) {
            Log.v("error", String.valueOf(e));
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvSubmit:
                if (etPostName.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getContext(), "Enter Name", Toast.LENGTH_SHORT).show();
                } else if (etPostEmail.getText().toString().trim().isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(etPostEmail.getText().toString().trim()).matches()) {
                    Toast.makeText(getContext(), "Enter  Email", Toast.LENGTH_SHORT).show();
                } else if (etPostPhone.getText().toString().trim().length()!=10) {
                    Toast.makeText(getContext(), "Enter  Number", Toast.LENGTH_SHORT).show();
                } else if (etPostSubject.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getContext(), "Enter  Subject", Toast.LENGTH_SHORT).show();
                } else if (ACTV.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getContext(), "Enter  Message", Toast.LENGTH_SHORT).show();
                } else {

                    if (util.isOnline(getActivity().getApplicationContext())) {
                        PostContactApi();

                    } else {

                        Sneaker.with(this)
                                .setTitle(getResources().getString(R.string.noconnection))
                                .setMessage("")
                                .sneakError();
                    }

                }

                break;
           /* case R.id.ivNav:
                if (AppSettings.getString(AppSettings.id).isEmpty()) {
                    if (scrollView.getVisibility() == View.VISIBLE) {
                        AppUtils.collapse(scrollView);
                        break;
                    }
                    AppUtils.expand(scrollView);
                } else {
                    if (scrollView.getVisibility() == View.VISIBLE) {
        *//* ivDrop.setVisibility( View.GONE );//scrollView.setVisibility(View.GONE);
         view.setVisibility( View.GONE );*//*
                        AppUtils.collapse(scrollView);
                        break;
                    }
     *//*ivDrop.setVisibility( View.VISIBLE );
     view.setVisibility( View.VISIBLE );*//*
                    AppUtils.expand(scrollView);
                }

                break;*/


//            case R.id.ivNav:
//                if (AppSettings.getString(AppSettings.id).isEmpty()) {
//                    if (scrollView.getVisibility() == View.VISIBLE) {
//                        AppUtils.collapse(scrollView);
//                        break;
//                    }
//                    AppUtils.expand(scrollView);
//                } else {
//                    if (scrollView.getVisibility() == View.VISIBLE) {
//        /* ivDrop.setVisibility( View.GONE );//scrollView.setVisibility(View.GONE);
//         view.setVisibility( View.GONE );*/
//                        AppUtils.collapse(scrollView);
//                        break;
//                    }
//     /*ivDrop.setVisibility( View.VISIBLE );
//     view.setVisibility( View.VISIBLE );*/
//                    AppUtils.expand(scrollView);
//                }
//
//                break;
//            case R.id.ivBack:
//                onBackPressed();
//                break;


            case R.id.tv_home:

                Fragment homeFragment = new HomeFragment();
                replaceFragment(homeFragment, "myWalletFragment");


                break;

        }
    }

    public void replaceFragment(Fragment fragment, String tag) {
        //Get current fragment placed in container
        Fragment currentFragment = getChildFragmentManager().findFragmentById(R.id.fragment_Container);

        //Prevent adding same fragment on top
        if (currentFragment.getClass() == fragment.getClass()) {
            return;
        }

        //If fragment is already on stack, we can pop back stack to prevent stack infinite growth
        if (getChildFragmentManager().findFragmentByTag(tag) != null) {
            getChildFragmentManager().popBackStack(tag, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }

        //Otherwise, just replace fragment
        getChildFragmentManager()
                .beginTransaction()
                .addToBackStack(tag)
                .add(fragment, tag)
                .commit();
    }

}