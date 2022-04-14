package com.serviingo.serviingo.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.core.text.HtmlCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.Activity.FragHowItWorks;
import com.serviingo.serviingo.Activity.fragAboutSaloonForhim;
import com.serviingo.serviingo.Activity.fragFAQ;
import com.serviingo.serviingo.Activity.fragHimSalon;
import com.serviingo.serviingo.Common.Preferences;
import com.serviingo.serviingo.Common.SimpleHTTPConnection;
import com.serviingo.serviingo.Database.AppSettings;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.storage.SharedPrefManager;
import com.serviingo.serviingo.utils.AppUrls;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import static com.rjesture.startupkit.AppTools.setLog;

public class SubCategoryFragment extends Fragment implements View.OnClickListener {

    public static ArrayList<HashMap<String, String>> subSubCategoryArray = new ArrayList();
    public static ArrayList<HashMap<String, String>> subCategoryPackagesArray = new ArrayList();
    public static ArrayList<HashMap<String, String>> subCategorydealsArray = new ArrayList();
    public static ArrayList<HashMap<String, String>> subCategorypackage_categoriesArray = new ArrayList();
    ArrayList<HashMap<String, String>> subCategoryArray = new ArrayList();
    ArrayList<HashMap<String, String>> subPackageArray = new ArrayList();
    GridAdapter GridAdapter;
    RecyclerView subcategoryRecy;
    Context context;
   public CardView carddView;
    FrameLayout flprogramDetails;
    TextView tvHowitWorks, tvHimSalon, tvfaqs, tvAboutSaloonForhim, tvSubcateGoryName, tvbottomdesc, tvbottomHeading, titleTv, descTv;
    String pinterest_linklink, facebook_linklink, linkedin_linklink, youtube_linklink, insta_linklink;


    FragmentManager fragmentManager;
    Preferences pref;
    private Fragment fragment;
    Bundle args;

    Bundle extras;
    String categoryId;
    SwipeRefreshLayout refreshLayout;
    LinearLayout linnerlayoutdata;


    public SubCategoryFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_sub_category, container, false);
        refreshLayout = view.findViewById(R.id.refreshLayout);
        linnerlayoutdata= view.findViewById(R.id.linnerlayoutdata);

        setui(view);
        displayView(0);

        refreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {

                        // Your code goes here
                        // In this code, we are just
                        // changing the text in the textbox

                        setui(view);


                        // This line is important as it explicitly
                        // refreshes only once
                        // If "true" it implicitly refreshes forever
                        refreshLayout.setRefreshing(false);
                    }
                }
        );
        return view;
    }

    private void setui(View view) {
        AppTools.showRequestDialog(getActivity());

        args = new Bundle();
        extras = getArguments();
        if (extras != null) {
            categoryId = getArguments().getString("id");

            SharedPrefManager.getInstance(getActivity())
                    .categoriesID(categoryId);


        }
        flprogramDetails = view.findViewById(R.id.flprogramDetails);
        subcategoryRecy = view.findViewById(R.id.subcategoryRecy);
        pref = new Preferences(getContext());
        LinearLayoutManager linearLayoutManager = (new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        subcategoryRecy.setLayoutManager(linearLayoutManager);
        subcategoryRecy.setHasFixedSize(true);

        carddView = view.findViewById(R.id.carddView);
        tvHowitWorks = view.findViewById(R.id.tvHowitWorks);
        tvHimSalon = view.findViewById(R.id.tvHimSalon);
        tvfaqs = view.findViewById(R.id.tvfaqs);
        tvAboutSaloonForhim = view.findViewById(R.id.tvAboutSaloonForhim);
//        referImageview = findViewById(R.id.referImageview);
    /*    ivPinterest = findViewById(R.id.ivPinterest);
        ivYoutube = findViewById(R.id.ivYoutube);
        ivinsta = findViewById(R.id.ivinsta);
        ivtwitter = findViewById(R.id.ivtwitter);
        ivfacebook = findViewById(R.id.ivfacebook);*/
        tvbottomdesc = view.findViewById(R.id.tvbottomdesc);
        tvbottomHeading = view.findViewById(R.id.tvbottomHeading);
        titleTv = view.findViewById(R.id.titleTv);
        descTv = view.findViewById(R.id.descTv);
        //carddView.setVisibility(View.VISIBLE);
        setOnClickListener();
        String categoryId = getActivity().getIntent().getStringExtra("id");

        if (SimpleHTTPConnection.isNetworkAvailable(getActivity())) {
            getRecyclerData();
        } else {
            // AppUtils.showErrorMessage(tvreferdesc, "Please Check Your Internet Connection", getActivity());
        }
    }

    private void setOnClickListener() {
       /* ivPinterest.setOnClickListener(this);
        ivYoutube.setOnClickListener(this);
        ivinsta.setOnClickListener(this);
        ivtwitter.setOnClickListener(this);
        ivfacebook.setOnClickListener(this);*/


        tvHowitWorks.setOnClickListener(this);
        tvHimSalon.setOnClickListener(this);
        tvfaqs.setOnClickListener(this);
        tvAboutSaloonForhim.setOnClickListener(this);

    }

    public void displayView(int position) {
        fragmentManager = getActivity().getSupportFragmentManager();
        switch (position) {
            case 0:
                fragment = new FragHowItWorks();
                // args.putSerializable(ARG_ANIMALS, animals as Serializable)
                args.putString("categoryId", categoryId);
                fragment.setArguments(args);
               // carddView.setVisibility(View.VISIBLE);
                break;
            case 1:
                fragment = new fragHimSalon();

                carddView.setVisibility(View.GONE);
                break;
            case 2:
                fragment = new fragFAQ();
                carddView.setVisibility(View.GONE);

                break;
            case 3:
                carddView.setVisibility(View.GONE);
                fragment = new fragAboutSaloonForhim();

                break;
        }





      /*  FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        Fragment subCategoryFragment = new SubCategoryFragment();
        Bundle args = new Bundle();
        // args.putSerializable(ARG_ANIMALS, animals as Serializable)
        args.putString("id", data.get(position).get("id"));
        subCategoryFragment.setArguments(args);
        fragmentTransaction.replace(R.id.fragment_Container,subCategoryFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        Bundle args = new Bundle();
        // args.putSerializable(ARG_ANIMALS, animals as Serializable)
        args.putString("categoryId",categoryId);
        subCategoryFragment.setArguments(args);
        */

        fragmentManager.beginTransaction()
                .replace(R.id.flprogramDetails, fragment)
                .addToBackStack("")
                .commit();
    }

    public void onClick(View v) {
        switch (v.getId()) {


            case R.id.tvHowitWorks:
                displayView(0);
                tvHimSalon.setBackgroundColor(getResources().getColor(R.color.purple_700));
                tvfaqs.setBackgroundColor(getResources().getColor(R.color.purple_700));
                tvAboutSaloonForhim.setBackgroundColor(getResources().getColor(R.color.purple_700));
                tvHowitWorks.setBackgroundColor(getResources().getColor(R.color.valueContent));
                break;
            case R.id.tvHimSalon:
                displayView(1);
                tvHowitWorks.setBackgroundColor(getResources().getColor(R.color.purple_700));
                tvfaqs.setBackgroundColor(getResources().getColor(R.color.purple_700));
                tvAboutSaloonForhim.setBackgroundColor(getResources().getColor(R.color.purple_700));
                tvHimSalon.setBackgroundColor(getResources().getColor(R.color.valueContent));
                break;
            case R.id.tvfaqs:
                displayView(2);
                tvHowitWorks.setBackgroundColor(getResources().getColor(R.color.purple_700));
                tvHimSalon.setBackgroundColor(getResources().getColor(R.color.purple_700));
                tvAboutSaloonForhim.setBackgroundColor(getResources().getColor(R.color.purple_700));
                tvfaqs.setBackgroundColor(getResources().getColor(R.color.valueContent));
                break;
            case R.id.tvAboutSaloonForhim:
                displayView(3);
                tvHowitWorks.setBackgroundColor(getResources().getColor(R.color.purple_700));
                tvfaqs.setBackgroundColor(getResources().getColor(R.color.purple_700));
                tvHimSalon.setBackgroundColor(getResources().getColor(R.color.purple_700));
                tvAboutSaloonForhim.setBackgroundColor(getResources().getColor(R.color.valueContent));
                break;


        }
    }

    private void getRecyclerData() {
        //  String categoryId = getIntent().getStringExtra("id");
        Log.v("categoryId", categoryId + "");
        String url = AppUrls.getCategoryDetails + categoryId;
        Log.v("subcat_url", url);
        AndroidNetworking.get(url)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        parseJsonResponse(response);
                    }

                    @Override
                    public void onError(ANError error) {
                        Log.v("data", error.getErrorBody());
                        Log.v("data", error.getErrorDetail());
                    }
                });
    }

    private void parseJsonResponse(JSONObject response) {
        try {
            subCategoryArray.clear();
            subPackageArray.clear();
            String message = response.getString("message");
            //   Toast.makeText(this, "" + message, Toast.LENGTH_SHORT).show();
            if (response.getString("status").equals("true")) {
                JSONObject jsonObject = response.getJSONObject("data");
                String total_give_rates = jsonObject.getString("total_give_rates");
                JSONObject refer_and_earnobj = jsonObject.getJSONObject("refer_and_earn");
                String id = refer_and_earnobj.getString("id");
                String slug = refer_and_earnobj.getString("slug");
                String heading = refer_and_earnobj.getString("heading");
                String title = refer_and_earnobj.getString("title");


                String description = refer_and_earnobj.getString("description");
                String images = refer_and_earnobj.getString("images");
                //Picasso.get().load(AppUrls.getImage ).into(referImageview);
                String categories_ids = refer_and_earnobj.getString("categories_ids");
                String created_at = refer_and_earnobj.getString("created_at");
                String updated_at = refer_and_earnobj.getString("updated_at");
                JSONObject jsonObject1 = jsonObject.getJSONObject("category");
                titleTv.setText(jsonObject1.getString("banner_title"));
                descTv.setText(HtmlCompat.fromHtml(jsonObject1.getString("banner_description"),0));
                JSONArray sub_categoriesrray = jsonObject.getJSONArray("sub_categories");
                for (int i = 0; i < sub_categoriesrray.length(); i++) {
                    JSONObject productobject = sub_categoriesrray.getJSONObject(i);
                    HashMap<String, String> addList = new HashMap();
                    addList.put("id", productobject.getString("id"));
                    addList.put("category_id", productobject.getString("category_id"));
                    addList.put("sub_category_icon", productobject.getString("sub_category_icon"));
                    addList.put("sub_category_name", productobject.getString("sub_category_name"));
                    addList.put("sub_category_slug", productobject.getString("sub_category_slug"));
                    addList.put("short_description", productobject.getString("short_description"));
                    addList.put("features", productobject.getString("features"));
                    addList.put("meta_title", productobject.getString("meta_title"));
                    addList.put("meta_description", productobject.getString("meta_description"));
                    addList.put("meta_keyword", productobject.getString("meta_keyword"));
                    addList.put("status", productobject.getString("status"));
                    addList.put("eligiable_for_all", productobject.getString("eligiable_for_all"));
                    addList.put("created_at", productobject.getString("created_at"));
                    addList.put("updated_at", productobject.getString("updated_at"));
                    addList.put("servicable_pincode", productobject.getString("servicable_pincode"));
                    subCategoryArray.add(addList);
                    Log.v("Sub_CategoryArray12", subCategoryArray.toString());
                    JSONArray subSub_categoriesrray = productobject.getJSONArray("sub_sub_categories");
                    for (int j = 0; j < subSub_categoriesrray.length(); j++) {
                        JSONObject subSubobject = subSub_categoriesrray.getJSONObject(j);
                        HashMap<String, String> subSubList = new HashMap();
                        subSubList.put("id", subSubobject.getString("id"));
                        subSubList.put("category_id", subSubobject.getString("category_id"));
                        subSubList.put("sub_category_id", subSubobject.getString("sub_category_id"));
                        subSubList.put("icon", subSubobject.getString("icon"));
                        subSubList.put("name", subSubobject.getString("name"));
                        subSubList.put("slug", subSubobject.getString("slug"));
                        subSubList.put("short_description", subSubobject.getString("short_description"));
                        subSubList.put("meta_title", subSubobject.getString("meta_title"));
                        subSubList.put("meta_description", subSubobject.getString("meta_description"));
                        subSubList.put("meta_keyword", subSubobject.getString("meta_keyword"));
                        subSubList.put("status", subSubobject.getString("status"));
                        subSubList.put("created_at", subSubobject.getString("created_at"));
                        subSubList.put("updated_at", subSubobject.getString("updated_at"));
                        subSubList.put("deleted_at", subSubobject.getString("deleted_at"));
                        subPackageArray.add(subSubList);
                        Log.v("Sub_PacgeArray12", subPackageArray.toString());
                    }
                }
                Log.v("Sub_PackageArray12", subPackageArray.toString());
                subcategoryRecy.setHasFixedSize(true);
                GridAdapter = new GridAdapter(context, subCategoryArray);
                subcategoryRecy.setAdapter(GridAdapter);

                AppTools.hideDialog();

                // subcategoryRecy.setItemViewCacheSize(500);
                /* GridAdapter.notifyDataSetChanged();*/
                JSONArray reviewsrray = jsonObject.getJSONArray("reviews");
                for (int i = 0; i < reviewsrray.length(); i++) {
                    JSONObject productobject = reviewsrray.getJSONObject(i);
                    HashMap<String, String> addList = new HashMap();
                    // addList.put("id", productobject.getString("id"));
                }
                JSONArray faqsrray = jsonObject.getJSONArray("faqs");
                for (int i = 0; i < faqsrray.length(); i++) {
                    JSONObject productobject = faqsrray.getJSONObject(i);
                    HashMap<String, String> addList = new HashMap();
                    // addList.put("id", productobject.getString("id"));
                }
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

                JSONObject categoryobj = jsonObject.getJSONObject("category");
                String categoryobjid = categoryobj.getString("id");
                String categoryobjslug = categoryobj.getString("slug");
                String categoryobjname = categoryobj.getString("name");
                pref.set(AppSettings.categoryobjname, categoryobjname);
                pref.commit();
                tvAboutSaloonForhim.setText("About " + categoryobjname);
                String categoryobjicon = categoryobj.getString("icon");
                String categoryobjreviews_heading = categoryobj.getString("reviews_heading");
                pref.set(AppSettings.categoryobjreviews_heading, categoryobjreviews_heading);
                pref.commit();
                tvHimSalon.setText(categoryobjreviews_heading);
                tvHowitWorks.setText("How It Works");
                linnerlayoutdata.setVisibility(View.VISIBLE);
                tvfaqs.setText("FAQ's");

                String categoryobjreviews_title = categoryobj.getString("reviews_title");
                pref.set(AppSettings.categoryobjreviews_title, categoryobjreviews_title);
                pref.commit();

                String categoryobjfaq_title = categoryobj.getString("faq_title");
                String categoryobjshort_description = categoryobj.getString("short_description");
                pref.set(AppSettings.categoryobjshort_description, categoryobjshort_description);
                pref.commit();
                String categoryobjabout_category = categoryobj.getString("about_category");
                pref.set(AppSettings.categoryobjabout_category, categoryobjabout_category);
                pref.commit();
                String categoryobjstatus = categoryobj.getString("status");
                String categoryobjmeta_title = categoryobj.getString("meta_title");
                String categoryobjmeta_keywords = categoryobj.getString("meta_keywords");
                pref.set(AppSettings.categoryobjmeta_keywords, categoryobjmeta_keywords);
                pref.commit();
                String categoryobjmeta_description = categoryobj.getString("meta_description");
                pref.set(AppSettings.categoryobjmeta_description, categoryobjmeta_description);
                pref.commit();
                String categoryobjavg_rating = categoryobj.getString("avg_rating");
                pref.set(AppSettings.categoryobjavg_rating, categoryobjavg_rating);
                pref.commit();
                String categoryobjbanner_title = categoryobj.getString("banner_title");
                String categoryobjbanner_description = categoryobj.getString("banner_description");
                String categoryobjdeleted_at = categoryobj.getString("deleted_at");
                String categoryobjcreated_at = categoryobj.getString("created_at");
                String categoryobjupdated_at = categoryobj.getString("updated_at");
               // tvbottomHeading.setText(categoryobjname + " in Lucknow");
              //  tvbottomdesc.setText(categoryobjshort_description);

            } else {

            }
        } catch (Exception e) {
            Log.v("error", String.valueOf(e));
        }
    }


    private void getSubCategoryDetails(String id) {
        String url = AppUrls.getSubCategoryDetails + id;
        Log.v("subcat_url", url);
        AndroidNetworking.get(url)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String message = response.getString("message");
                            Log.v("resp", response.toString());
                            subCategorydealsArray.clear();
                            subCategoryPackagesArray.clear();
                            if (response.getString("status").equals("true")) {
                                JSONObject jsonObject = response.getJSONObject("data");
                                JSONArray package_categories = jsonObject.getJSONArray("package_categories");
                                for (int i = 0; i < package_categories.length(); i++) {
                                    JSONObject productobject = package_categories.getJSONObject(i);
                                    HashMap<String, String> addList = new HashMap();
                                    addList.put("id", productobject.getString("id"));
                                    addList.put("subcat_id", productobject.getString("subcat_id"));
                                    addList.put("subsub_category_id", productobject.getString("subsub_category_id"));
                                    addList.put("name", productobject.getString("name"));
                                    subCategoryPackagesArray.add(addList);
                                }
                                JSONArray packages = jsonObject.getJSONArray("packages");
                                for (int i = 0; i < packages.length(); i++) {
                                    JSONObject productobject = packages.getJSONObject(i);
                                    HashMap<String, String> addList = new HashMap();
                                    subCategorypackage_categoriesArray.add(addList);
                                }
                                JSONArray deals = jsonObject.getJSONArray("deals");
                                for (int i = 0; i < deals.length(); i++) {
                                    JSONObject productobject = deals.getJSONObject(i);
                                    HashMap<String, String> addList = new HashMap();
                                    subCategorydealsArray.add(addList);
                                }
                                if (subCategoryPackagesArray.size() != 0) {
                                    //  startActivity(new Intent(SubCategoryFragment.this, Lowcontact.class));


                                    FragmentManager fragmentManager = getFragmentManager();
                                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                    Fragment subCategoryFragment = new LowcontactFragment();
                                    Bundle args = new Bundle();
                                    // args.putSerializable(ARG_ANIMALS, animals as Serializable)
                                    // args.putString("id", data.get(position).get("id"));
                                    subCategoryFragment.setArguments(args);
                                    fragmentTransaction.replace(R.id.fragment_Container, subCategoryFragment);
                                    fragmentTransaction.addToBackStack(null);
                                    fragmentTransaction.commit();


                                } else if (subCategorypackage_categoriesArray.size() != 0) {
                                    //startActivity(new Intent(SubCategoryFragment.this, Lowcontact.class));

                                    FragmentManager fragmentManager = getFragmentManager();
                                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                    Fragment subCategoryFragment = new LowcontactFragment();
                                    Bundle args = new Bundle();
                                    // args.putSerializable(ARG_ANIMALS, animals as Serializable)
                                    // args.putString("id", data.get(position).get("id"));
                                    subCategoryFragment.setArguments(args);
                                    fragmentTransaction.replace(R.id.fragment_Container, subCategoryFragment);
                                    fragmentTransaction.addToBackStack(null);
                                    fragmentTransaction.commit();

                                } else if (subCategorydealsArray.size() != 0) {
                                    // startActivity(new Intent(SubCategoryFragment.this, Lowcontact.class));

                                    FragmentManager fragmentManager = getFragmentManager();
                                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                    Fragment subCategoryFragment = new LowcontactFragment();
                                    Bundle args = new Bundle();
                                    // args.putSerializable(ARG_ANIMALS, animals as Serializable)
                                    // args.putString("id", data.get(position).get("id"));
                                    subCategoryFragment.setArguments(args);
                                    fragmentTransaction.replace(R.id.fragment_Container, subCategoryFragment);
                                    fragmentTransaction.addToBackStack(null);
                                    fragmentTransaction.commit();
                                } else {
                                    // startActivity(new Intent(SubCategoryFragment.this, Lowcontact.class));

                                    FragmentManager fragmentManager = getFragmentManager();
                                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                    Fragment subCategoryFragment = new LowcontactFragment();
                                    Bundle args = new Bundle();
                                    // args.putSerializable(ARG_ANIMALS, animals as Serializable)
                                    // args.putString("id", data.get(position).get("id"));
                                    subCategoryFragment.setArguments(args);
                                    fragmentTransaction.replace(R.id.fragment_Container, subCategoryFragment);
                                    fragmentTransaction.addToBackStack(null);
                                    fragmentTransaction.commit();
                                }
                               /* Log.v("SubsubArralist", subSubCategoryArray+"");
                                holder.gridSubcategoryRecy.setHasFixedSize(true);
                                gridLayoutManager = new GridLayoutManager(context, 3);
                                holder.gridSubcategoryRecy.setLayoutManager(gridLayoutManager);
                                dataAdapter = new DataAdapter(context, subSubCategoryArray);
                                holder.gridSubcategoryRecy.setAdapter(dataAdapter);
                                dataAdapter.notifyDataSetChanged();*/

                            } else {
                            }
                        } catch (Exception e) {
                            Log.v("error", String.valueOf(e));
                        }
                    }

                    @Override
                    public void onError(ANError error) {
                        Log.v("data", error.getErrorBody());
                        Log.v("data", error.getErrorDetail());
                    }
                });
    }

    private void getSubSubCategoryDetails(String id) {
        String url = AppUrls.getSubSubCategoryDetails + id;
        Log.v("subcat_url", url);
        AndroidNetworking.get(url)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String message = response.getString("message");
                            Log.v("resp", response.toString());
                            subCategorydealsArray.clear();
                            subCategoryPackagesArray.clear();
                            if (response.getString("status").equals("true")) {
                                JSONObject jsonObject = response.getJSONObject("data");
                                JSONArray package_categories = jsonObject.getJSONArray("package_categories");
                                for (int i = 0; i < package_categories.length(); i++) {
                                    JSONObject productobject = package_categories.getJSONObject(i);
                                    HashMap<String, String> addList = new HashMap();
                                    addList.put("id", productobject.getString("id"));
                                    addList.put("subcat_id", productobject.getString("subcat_id"));
                                    addList.put("subsub_category_id", productobject.getString("subsub_category_id"));
                                    addList.put("name", productobject.getString("name"));
                                    subCategoryPackagesArray.add(addList);
                                }
                                JSONArray packages = jsonObject.getJSONArray("packages");
                                for (int i = 0; i < packages.length(); i++) {
                                    JSONObject productobject = packages.getJSONObject(i);
                                    HashMap<String, String> addList = new HashMap();
                                    subCategorypackage_categoriesArray.add(addList);
                                }
                                JSONArray deals = jsonObject.getJSONArray("deals");
                                for (int i = 0; i < deals.length(); i++) {
                                    JSONObject productobject = deals.getJSONObject(i);
                                    HashMap<String, String> addList = new HashMap();
                                    subCategorydealsArray.add(addList);
                                }

                                if (subCategoryPackagesArray.size() != 0) {

                                } else if (subCategorypackage_categoriesArray.size() != 0) {

                                } else if (subCategorydealsArray.size() != 0) {

                                } else {
                                    // startActivity(new Intent(SubCategoryFragment.this, Lowcontact.class));

                                    FragmentManager fragmentManager = getFragmentManager();
                                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                    Fragment subCategoryFragment = new LowcontactFragment();
                                    Bundle args = new Bundle();
                                    // args.putSerializable(ARG_ANIMALS, animals as Serializable)
                                    // args.putString("id", data.get(position).get("id"));
                                    subCategoryFragment.setArguments(args);
                                    fragmentTransaction.replace(R.id.fragment_Container, subCategoryFragment);
                                    fragmentTransaction.addToBackStack(null);
                                    fragmentTransaction.commit();
                                }

                               /* Log.v("SubsubArralist", subSubCategoryArray+"");
                                holder.gridSubcategoryRecy.setHasFixedSize(true);
                                gridLayoutManager = new GridLayoutManager(context, 3);
                                holder.gridSubcategoryRecy.setLayoutManager(gridLayoutManager);
                                dataAdapter = new DataAdapter(context, subSubCategoryArray);
                                holder.gridSubcategoryRecy.setAdapter(dataAdapter);
                                dataAdapter.notifyDataSetChanged();*/

                            } else {
                            }
                        } catch (Exception e) {
                            Log.v("error", String.valueOf(e));
                        }
                    }

                    @Override
                    public void onError(ANError error) {
                        Log.v("data", error.getErrorBody());
                        Log.v("data", error.getErrorDetail());
                    }
                });
    }

    class GridAdapter extends RecyclerView.Adapter<SubCategoryFragment.GridAdapter.WalletHolder> {
        ArrayList<HashMap<String, String>> data = new ArrayList();
        ArrayList<HashMap<String, String>> SubSubArraylist = new ArrayList();
        Context context;

        GridLayoutManager gridLayoutManager;
        SubCategoryFragment.DataAdapter dataAdapter;

        public GridAdapter(Context context, ArrayList<HashMap<String, String>> testimoniallist) {
            this.context = context;
            this.data = testimoniallist;
        }

        @Override
        public SubCategoryFragment.GridAdapter.WalletHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.subcategory_content, parent, false);
            return new SubCategoryFragment.GridAdapter.WalletHolder(view);
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        @Override
        public void onBindViewHolder(final SubCategoryFragment.GridAdapter.WalletHolder holder, final int position) {
            Picasso.get().load(AppUrls.BASESubCategoryimagepath + data.get(position).get("sub_category_icon")).into(holder.iv_Imageview);
            holder.tvSubName.setText(data.get(position).get("sub_category_name"));
            Log.v("subCategoryNamedata", data.get(position).get("sub_category_name"));

            ArrayList<HashMap<String, String>> sub_CatArray = new ArrayList<>();
            for (int i = 0; i < subPackageArray.size(); i++) {
//                Log.v("SubCatCheck","msg  "+data.get(position).get("category_id")+"  "+subPackageArray.get(i).get("category_id"));
                if (subPackageArray.get(i).get("sub_category_id").equalsIgnoreCase(data.get(position).get("id"))) {
                    sub_CatArray.add(subPackageArray.get(i));
                }
            }
            Log.v("SubCatCheck", "msg  " + sub_CatArray.size() + "  " + subPackageArray.size());
           /* JSONObject jsonObject = new JSONObject();
            JSONArray subSub_categoriesrray = jsonObject.getJSONArray("sub_sub_categories");
            for (int j = 0; j < subSub_categoriesrray.length(); j++) {
                JSONObject subSubobject = subSub_categoriesrray.getJSONObject(i);
                HashMap<String, String> subSubList = new HashMap();
                subSubList.put("id", subSubobject.getString("id"));

            }*/


            holder.ll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    Fragment subSubCategoriesFragment = new SubSubCategoriesFragment();
                    Bundle args = new Bundle();
                    args.putString("id", data.get(position).get("id"));
                    args.putString("sub", "sub");
                    args.putString("name", data.get(position).get("sub_category_name"));


                    args.putString("short_description", data.get(position).get("short_description"));
                    subSubCategoriesFragment.setArguments(args);
                    fragmentTransaction.replace(R.id.fragment_Container, subSubCategoriesFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();

                    //
                    //  Toast.makeText(getContext(),data.get(position).get("id")+ "", Toast.LENGTH_SHORT).show();
                }
            });

            holder.gridSubcategoryRecy.setHasFixedSize(true);
            gridLayoutManager = new GridLayoutManager(context, 3);
            holder.gridSubcategoryRecy.setLayoutManager(gridLayoutManager);
            dataAdapter = new SubCategoryFragment.DataAdapter(context, sub_CatArray);
            holder.gridSubcategoryRecy.setAdapter(dataAdapter);
        }

        public class WalletHolder extends RecyclerView.ViewHolder {

            TextView tvSubName;
            ImageView iv_Imageview;
            RecyclerView gridSubcategoryRecy;
            RelativeLayout ll;

            public WalletHolder(View itemView) {
                super(itemView);
                iv_Imageview = itemView.findViewById(R.id.ivSubImage);
                tvSubName = itemView.findViewById(R.id.tvSubName);
                ll = itemView.findViewById(R.id.ll);
                gridSubcategoryRecy = itemView.findViewById(R.id.gridSubcategoryRecy);
            }

        }

    }

    class DataAdapter extends RecyclerView.Adapter<SubCategoryFragment.DataAdapter.WalletHolder> {
        ArrayList<HashMap<String, String>> data = new ArrayList();
        Context context;

        public DataAdapter(Context context, ArrayList<HashMap<String, String>> testimoniallist) {
            this.context = context;
            this.data = testimoniallist;
        }


        @Override
        public SubCategoryFragment.DataAdapter.WalletHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.subsubadapter, parent, false);
            return new SubCategoryFragment.DataAdapter.WalletHolder(view);
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        @Override
        public void onBindViewHolder(final SubCategoryFragment.DataAdapter.WalletHolder holder, final int position) {

            Picasso.get().load(AppUrls.BASESUBSubCategoryimagepath + data.get(position).get("icon")).into(holder.iv_Imageview);
            holder.CateName.setText(data.get(position).get("name"));

            holder.cv_View.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pref.set(AppSettings.subcatId, data.get(position).get("sub_category_id"));
                    pref.commit();
                    pref.set(AppSettings.subSubcatId, data.get(position).get("id"));
                    pref.commit();
                    setLog("subCatId", "gsdf" + data.get(position));
                    // Toast.makeText(getContext(), data.get(position).get("id")+"", Toast.LENGTH_SHORT).show();

                    //   getSubCategoryDetails(data.get(position).get("sub_category_id"));


                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    Fragment lowcontactFragment = new LowcontactFragment();
                    Bundle args = new Bundle();
                    args.putString("id", data.get(position).get("id"));
                    args.putString("name", data.get(position).get("name"));
                    args.putString("sub", "subsub");

                    args.putString("short_description", data.get(position).get("short_description"));
                    lowcontactFragment.setArguments(args);
                    fragmentTransaction.replace(R.id.fragment_Container, lowcontactFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();



                  /*Intent i=new Intent(SubCategoryFragment.this,primaryActivity.class);
                  i.putExtra("icon",data.get(position).get("icon"));
                  i.putExtra("name",data.get(position).get("name"));
                  startActivity(i);*/
                }
            });


        }

        public class WalletHolder extends RecyclerView.ViewHolder {

            TextView CateName;
            ImageView iv_Imageview;
            CardView cv_View;

            public WalletHolder(View itemView) {
                super(itemView);
                iv_Imageview = itemView.findViewById(R.id.iv_Imageview);
                CateName = itemView.findViewById(R.id.CateName);
                cv_View = itemView.findViewById(R.id.cv_View);

            }

        }

    }
}