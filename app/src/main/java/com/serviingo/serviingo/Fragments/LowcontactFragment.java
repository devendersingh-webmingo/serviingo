package com.serviingo.serviingo.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.rjesture.startupkit.ApiStrings;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.Activity.Addtocart;
import com.serviingo.serviingo.Activity.HomeActivity;
import com.serviingo.serviingo.Activity.Lowcontact;
import com.serviingo.serviingo.Adapterr.MyDealsAdapter;
import com.serviingo.serviingo.Adapterr.MyPackageAdapter;
import com.serviingo.serviingo.Adapterr.MySubDealsAdapter;
import com.serviingo.serviingo.Adapterr.MyWalletAdapter;
import com.serviingo.serviingo.Adapterr.SubcategoryAdapter;
import com.serviingo.serviingo.Adapterr.package_categoriesAdapter;
import com.serviingo.serviingo.Adapterr.package_categoriesSubAdapter;
import com.serviingo.serviingo.Common.Preferences;
import com.serviingo.serviingo.Database.AppSettings;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.ViewPresenter.SubSubCategoryPresenter;
import com.serviingo.serviingo.dialogue.PackageReviewDetailsDialogue;
import com.serviingo.serviingo.dialogue.PackageViewDetailsDialogue;
import com.serviingo.serviingo.modelrepo.Responsee.PackageReviews;
import com.serviingo.serviingo.modelrepo.Responsee.PackagesRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Subcategory_detailsRepo;
import com.serviingo.serviingo.modelrepo.Responsee.subsubcategory_detailsRepo;
import com.serviingo.serviingo.storage.SharedPrefManager;
import com.serviingo.serviingo.utils.AppUrls;
import com.serviingo.serviingo.utils.AppUtils;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import static com.rjesture.startupkit.ApiStrings.apiErrorException;
import static com.rjesture.startupkit.ApiStrings.defResponse;
import static com.rjesture.startupkit.AppTools.hideGifDialog;
import static com.rjesture.startupkit.AppTools.setLog;
import static com.rjesture.startupkit.AppTools.showToast;
import static com.serviingo.serviingo.R.drawable.globalloader;

public class LowcontactFragment extends Fragment
        implements View.OnClickListener,
        SubSubCategoryPresenter.SubSubCategoryView, MyPackageAdapter.AddToCartListener, SubcategoryAdapter.AddToCartListener,
        package_categoriesAdapter.AddPackageCategoriesListener, package_categoriesSubAdapter.AddPackageCategoriesSubListener
        , MyDealsAdapter.AddToCartListener, MySubDealsAdapter.AddToCartListener {


    TextView tvHeading, tv_Package;
    RecyclerView horizontalrecy, verticalrecy, verticalDeals;
    LinearLayoutManager linearLayoutManager, llManager;

    Bundle extras;
    String Id, name, short_description, check;
    SubSubCategoryPresenter presenter;
    ImageView imageView;
    TextView Editthis_Package, descTv, title;
    LinearLayout LLPackage, LLEditPakage;

    MyPackageAdapter myPackageAdapter;
    package_categoriesAdapter package_categoriesAdapter;
    package_categoriesSubAdapter package_categoriesSubAdapter;
    String sub_category_id;
    CardView makeYourpackage, deals;


    TextView cartnumbertv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lowcontact, container, false);


        setui(view);


        return view;
    }

    private void setui(View view) {
        cartnumbertv = getActivity().findViewById(R.id.cartnumbertv);

        AppTools.showRequestDialog(getActivity());
        presenter = new SubSubCategoryPresenter(this);
        makeYourpackage = view.findViewById(R.id.makeYourpackage);
        makeYourpackage.setVisibility(View.GONE);
        deals = view.findViewById(R.id.deals);
        deals.setVisibility(View.GONE);
        verticalrecy = view.findViewById(R.id.verticalrecy);

        linearLayoutManager = (new LinearLayoutManager(getContext().getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        verticalrecy.setLayoutManager(linearLayoutManager);
        verticalrecy.setHasFixedSize(true);

        verticalDeals = view.findViewById(R.id.verticalDeals);
        LinearLayoutManager linearLayoutManager2 = (new LinearLayoutManager(getContext().getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        verticalDeals.setLayoutManager(linearLayoutManager2);
        verticalDeals.setHasFixedSize(true);

        horizontalrecy = view.findViewById(R.id.horizontalrecy);
        llManager = (new LinearLayoutManager(getContext().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        horizontalrecy.setLayoutManager(llManager);
        horizontalrecy.setHasFixedSize(true);
        tvHeading = view.findViewById(R.id.tvHeading);
        tv_Package = view.findViewById(R.id.tv_Package);
        imageView = view.findViewById(R.id.imageView);
        Editthis_Package = view.findViewById(R.id.Editthis_Package);
        descTv = view.findViewById(R.id.descTv);
        title = view.findViewById(R.id.title);

        LLPackage = view.findViewById(R.id.LLPackage);
        LLEditPakage = view.findViewById(R.id.LLEditPakage);

        extras = getArguments();
        if (extras != null) {
            Id = getArguments().getString("id");
            check = getArguments().getString("sub");

            short_description = getArguments().getString("short_description");
            name = getArguments().getString("name");

            title.setText(name);
            descTv.setText(short_description);

        }

        if (check.equalsIgnoreCase("sub")) {
            presenter.SubCategory(getContext(), Id);

            // Toast.makeText(getContext(), check+"", Toast.LENGTH_SHORT).show();

        } else if (check.equalsIgnoreCase("subsub")) {
            presenter.SubSubCategory(getContext(), Id);
            //  Toast.makeText(getContext(), check+"", Toast.LENGTH_SHORT).show();

        }


        setOnClickListener();
        // Log.e("fhsdkjf", check + "\n" + short_description);

        Editthis_Package.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Toast.makeText(getContext(), "Editthis_Package", Toast.LENGTH_SHORT).show();

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment addonesFragment = new MakePakageFragment();
                Bundle args = new Bundle();
                args.putString("sub", check);
                args.putString("id", Id);

                args.putString("name", title.getText().toString());
                args.putString("sub_category_id", sub_category_id);
                args.putString("Quentiy", "1");
                addonesFragment.setArguments(args);
                fragmentTransaction.replace(R.id.fragment_Container, addonesFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        makeYourpackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                LLPackage.setVisibility(View.GONE);
                LLEditPakage.setVisibility(View.VISIBLE);


            }
        });
        deals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                verticalrecy.setVisibility(View.GONE);
                verticalDeals.setVisibility(View.VISIBLE);
                LLPackage.setVisibility(View.VISIBLE);
                LLEditPakage.setVisibility(View.GONE);
            }
        });


    }

    private void setOnClickListener() {

      /*  String icon = getIntent().getStringExtra("icon");
        String name = getIntent().getStringExtra("name");*/

        /* Picasso.get().load(AppUrls.BASESUBSubCategoryimagepath + icon).into(imageView);*/
        //tvwallet.setText(name);

    }

    @Override
    public void onClick(View v) {

    }


    @Override
    public void onSubSubCategoryError(String message) {
        Toast.makeText(getContext(), message + "", Toast.LENGTH_SHORT).show();
        AppTools.hideDialog();

        LLPackage.setVisibility(View.GONE);
        LLEditPakage.setVisibility(View.VISIBLE);

    }

    @Override
    public void onSubSubCategorySuccess(subsubcategory_detailsRepo response, String message) {


        if (message.equalsIgnoreCase("ok")) {


            String feature = response.getData().getSubCategory().getFeatures();
            String[] splitString = feature.split(",");

            sub_category_id = String.valueOf(response.getData().getSubCategory().getId());


            for (String s : splitString) {
                System.out.println(s);
                Log.e("onSubSubCategorySuccess", s);

                if (s.equalsIgnoreCase("add_on_services_allowed")) {

                    if (response.getData().getPackageCategories().size() > 0) {
                        //tv_Package.setVisibility(View.VISIBLE);
                        tvHeading.setText(response.getData().getSubsubCategory().getShortDescription());

                        //    Toast.makeText(getContext(), response.getData().getPackageCategories().size() + "", Toast.LENGTH_SHORT).show();
                       /* response.getData().getPackageCategories().get(response.getData().getPackageCategories().size()).setName("deals");

                        response.getData().getPackageCategories().get(response.getData().getPackageCategories().size()).setName("dealss");
*/
                        package_categoriesAdapter = new package_categoriesAdapter(response, getContext().getApplicationContext(), this);
                        //  subcategoryAdapter = new SubcategoryAdapter(response, getContext().getApplicationContext(), this);
                        //verticalrecy.setAdapter(subcategoryAdapter);
                        horizontalrecy.setAdapter(package_categoriesAdapter);
                        AppTools.hideDialog();
                    }/* else if (s.equalsIgnoreCase("edit_package_option")) {

                        LLPackage.setVisibility(View.GONE);
                        LLEditPakage.setVisibility(View.VISIBLE);


                        title.setText(response.getData().getSubCategory().getSubCategoryName());
                        descTv.setText(response.getData().getSubCategory().getShortDescription());

                        Picasso.get().load(response.getData().getSubCategoryImagePath() + response.getData().getSubCategory().getSubCategoryIcon()).into(imageView);
                        AppTools.hideGifDialog();

                    }*/
                } else if (s.equalsIgnoreCase("deals")) {


                    if (response.getData().getDeals().size() > 0) {
                        deals.setVisibility(View.VISIBLE);

                        MyDealsAdapter myDealsAdapter = new MyDealsAdapter(response, getContext(), this);
                        verticalDeals.setAdapter(myDealsAdapter);

                        Toast.makeText(getContext(), "Deals", Toast.LENGTH_SHORT).show();


                    }

                } else if (s.equalsIgnoreCase("edit_package_option")) {

                    //   makeYourpackage.setVisibility(View.VISIBLE);
                    LLPackage.setVisibility(View.GONE);
                    LLEditPakage.setVisibility(View.VISIBLE);
                    title.setText(response.getData().getSubCategory().getSubCategoryName());
                    descTv.setText(response.getData().getSubCategory().getShortDescription());
                    Picasso.get().load(response.getData().getSubCategoryImagePath() + response.getData().getSubCategory().getSubCategoryIcon()).into(imageView);
                    AppTools.hideDialog();

                }
            }
        }

    }

    @Override
    public void onSubCategorySuccess(Subcategory_detailsRepo response, String message) {
        AppTools.hideDialog();


        if (message.equalsIgnoreCase("ok")) {

            sub_category_id = String.valueOf(response.getData().getSubCategory().getId());

            String feature = response.getData().getSubCategory().getFeatures();
            String[] splitString = feature.split(",");


            for (String s : splitString) {
                System.out.println(s);
                Log.e("afadasdasd", s);
                if (s.equalsIgnoreCase("add_on_services_allowed")) {
                    //  AppTools.showGifDialog(getActivity(), globalloader);

                    if (response.getData().getPackageCategories().size() > 0) {

                        tvHeading.setText(response.getData().getSubCategory().getShortDescription());

                        //   Toast.makeText(getContext(), response.getData().getPackageCategories().size() + "", Toast.LENGTH_SHORT).show();
                        package_categoriesSubAdapter = new package_categoriesSubAdapter(response, getContext().getApplicationContext(), this);
                        //  subcategoryAdapter = new SubcategoryAdapter(response, getContext().getApplicationContext(), this);
                        //verticalrecy.setAdapter(subcategoryAdapter);
                        horizontalrecy.setAdapter(package_categoriesSubAdapter);

                    } /*else if (s.equalsIgnoreCase("edit_package_option")) {

                        LLPackage.setVisibility(View.GONE);
                        LLEditPakage.setVisibility(View.VISIBLE);


                        title.setText(response.getData().getSubCategory().getSubCategoryName());
                        descTv.setText(response.getData().getSubCategory().getShortDescription());

                        Picasso.get().load(response.getData().getSubCategoryImagePath() + response.getData().getSubCategory().getSubCategoryIcon()).into(imageView);
                        AppTools.hideGifDialog();

                    }*/
                } else if (s.equalsIgnoreCase("deals")) {

                    if (response.getData().getDeals().size() > 0) {

                        deals.setVisibility(View.VISIBLE);


                        MySubDealsAdapter myDealsAdapter = new MySubDealsAdapter(response, getContext(), this);
                        verticalDeals.setAdapter(myDealsAdapter);


                    }


                } else if (s.equalsIgnoreCase("edit_package_option")) {
                    //  makeYourpackage.setVisibility(View.VISIBLE);

                    LLPackage.setVisibility(View.GONE);
                    LLEditPakage.setVisibility(View.VISIBLE);


                    title.setText(response.getData().getSubCategory().getSubCategoryName());
                    descTv.setText(response.getData().getSubCategory().getShortDescription());

                    Picasso.get().load(response.getData().getSubCategoryImagePath() + response.getData().getSubCategory().getSubCategoryIcon()).into(imageView);
                    AppTools.hideDialog();

                }



/*

                if (s.equalsIgnoreCase("edit_package_option")) {
                    makeYourpackage.setVisibility(View.VISIBLE);
                    Toast.makeText(getContext(), "asdasdasddas", Toast.LENGTH_SHORT).show();
                }
*/

            }

        }

    }

    @Override
    public void onGetPackagelistSuccess(PackagesRepo response, String message) {

        if (message.equalsIgnoreCase("ok")) {
            if (response.getData().getPackages().size() > 0) {
                AppTools.hideDialog();

                LLEditPakage.setVisibility(View.GONE);
                LLPackage.setVisibility(View.VISIBLE);

                myPackageAdapter = new MyPackageAdapter(response, getContext().getApplicationContext(), this);
                verticalrecy.setAdapter(myPackageAdapter);

                AppTools.hideDialog();

            }

        }


    }

    @Override
    public void onGetPackageReviewsSuccess(PackageReviews response, String message) {
        if (message.equalsIgnoreCase("ok")) {
            if (response.getData().getReviews().size() > 0) {
                AppTools.hideDialog();
                PackageReviewDetailsDialogue packageViewDetailsDialogue = new PackageReviewDetailsDialogue(getContext(), response);

                packageViewDetailsDialogue.Sucess();


            }

        }


    }

    @Override
    public void onSubSubCategoryFailure(Throwable t) {
        AppTools.hideDialog();

        Toast.makeText(getContext(), t.getLocalizedMessage() + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void AddToCartClick(String id, int position) {
        //  Toast.makeText(getContext(), id + "", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void AddToCartClick(String id, int position, String Quentiy) {
        // Toast.makeText(getContext(), Quentiy + "", Toast.LENGTH_SHORT).show();


        cartnumbertv.setVisibility(View.VISIBLE);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment addonesFragment = new AddonesFragment();
        Bundle args = new Bundle();
        args.putString("id", id);
        args.putString("Quentiy", Quentiy);


        Log.e("checkddddd", id + " ");


        SharedPrefManager.getInstance(getActivity())
                .PacckageDetails(id, Quentiy);


        addonesFragment.setArguments(args);
        fragmentTransaction.replace(R.id.fragment_Container, addonesFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }


    @Override
    public void addLifeCycleCallBack(YouTubePlayerView youTubePlayerView) {
        getLifecycle().addObserver(youTubePlayerView);

    }

    @Override
    public void IncreaseQuentity(String Quentity, int position, Subcategory_detailsRepo Subcategory_detailsRepo) {

    }

    @Override
    public void DecressQuentity(String Quentity, int position, Subcategory_detailsRepo Subcategory_detailsRepo) {

    }

    @Override
    public void IncreaseQuentity(String Quentity, int position, subsubcategory_detailsRepo subsubcategory_detailsRepo) {

    }

    @Override
    public void DecressQuentity(String Quentity, int position, subsubcategory_detailsRepo subsubcategory_detailsRepo) {

    }

    @Override
    public void IncreaseQuentity(String Quentity, int position, PackagesRepo packagesRepo) {

        //  Toast.makeText(getContext(), Quentity + "", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void DecressQuentity(String Quentity, int position, PackagesRepo packagesRepo) {
        /*
        if (packagesRepo.getData().getAddonServices().get(position).getAfterDiscount() != null) {
            finalprice = finalprice - Integer.valueOf(cartRepo.getData().getAddonServices().get(position).getAfterDiscount());

        } else {

            //     cartRepo.getData().getAddonServices().get(position).getAmount();
            finalprice = finalprice - Integer.valueOf(cartRepo.getData().getAddonServices().get(position).getAmount());

        }*/
        //   Toast.makeText(getContext(), Quentity + "", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void ViewDetails(String id, int position) {

        //Toast.makeText(getContext(), id + "", Toast.LENGTH_SHORT).show();


        PackageViewDetailsDialogue packageViewDetailsDialogue = new PackageViewDetailsDialogue(getContext(), id);

        packageViewDetailsDialogue.Sucess();

    }

    @Override
    public void ReviewClickDetails(String id, int position) {
        presenter.GetPackageReviews(getContext(), id);
      //  Toast.makeText(getContext(), id+"", Toast.LENGTH_SHORT).show();


    }


    @Override
    public void PackageCategoriesClick(subsubcategory_detailsRepo response, int position,
                                       int packagecategoriesId) {
        AppTools.showRequestDialog(getActivity());

    // Toast.makeText(getActivity(), response.getData().getPackageCategories().get(position).getId() + "", Toast.LENGTH_SHORT).show();
        presenter.GetPackagelist(getActivity(), String.valueOf(packagecategoriesId));
        verticalrecy.setVisibility(View.VISIBLE);
        verticalDeals.setVisibility(View.GONE);


       /* if (response.getData().getPackages().size() > 0) {
            //AppTools.hideGifDialog();

            LLEditPakage.setVisibility(View.GONE);
            LLPackage.setVisibility(View.VISIBLE);

            tvHeading.setText(response.getData().getSubCategory().getShortDescription());
            myPackageAdapter = new MyPackageAdapter(response, getContext().getApplicationContext(), this,packagecategoriesId);
            verticalrecy.setAdapter(myPackageAdapter);
        }
*/

        /*else {
            AppTools.hideGifDialog();

            LLPackage.setVisibility(View.GONE);
            LLEditPakage.setVisibility(View.VISIBLE);


            title.setText(response.getData().getSubCategory().getSubCategoryName());
            descTv.setText(response.getData().getSubCategory().getShortDescription());

            Picasso.get().load(response.getData().getSubCategoryImagePath() + response.getData().getSubCategory().getSubCategoryIcon()).into(imageView);

        }*/
    }

    @Override
    public void PackageCategoriesSubClick(Subcategory_detailsRepo subcategory_detailsRepo, int position, int packagecategoriesId) {
        AppTools.showRequestDialog(getActivity(), "Loading..");

        presenter.GetPackagelist(getActivity(), String.valueOf(packagecategoriesId));
        verticalrecy.setVisibility(View.VISIBLE);
        verticalDeals.setVisibility(View.GONE);

    }


    @Override
    public void showHideProgress(boolean isShow) {
        if (isShow) {
            AppTools.showRequestDialog(getActivity());
            LLEditPakage.setVisibility(View.GONE);


        } else {
            AppTools.hideDialog();


        }

    }


}