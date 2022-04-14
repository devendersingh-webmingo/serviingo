package com.serviingo.serviingo.Fragments;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.text.HtmlCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.Adapterr.HomeAdapter;
import com.serviingo.serviingo.Adapterr.Homepage.CateoriesSectionAdapter;
import com.serviingo.serviingo.Adapterr.Homepage.CitySpinnerAdapterhome;
import com.serviingo.serviingo.Adapterr.Homepage.CustomizedGalleryAdapterr;
import com.serviingo.serviingo.Adapterr.Homepage.FourSectionAdapter;
import com.serviingo.serviingo.Adapterr.Homepage.HomeCaetegoryAdapter;
import com.serviingo.serviingo.Adapterr.Homepage.HomeSubsubCategoryAdapter;
import com.serviingo.serviingo.Adapterr.Homepage.ReviewSectionAdapter;
import com.serviingo.serviingo.Adapterr.Homepage.SlidingImageAdapter;
import com.serviingo.serviingo.Adapterr.Homepage.SlidingMiddleImageAdapter;
import com.serviingo.serviingo.Adapterr.Homepage.ThreeSectionAdapter;
import com.serviingo.serviingo.Fragments.FinancialService.FinacialFragment;
import com.serviingo.serviingo.Fragments.FinancialService.FinanceServiceDetailFragment;
import com.serviingo.serviingo.Fragments.FinancialService.FinanceServicesFragment;
import com.serviingo.serviingo.Fragments.FinancialService.FinanceSubCategoriesFragment;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.ViewPresenter.HomePageePresenter;
import com.serviingo.serviingo.model.Adonsemodel;
import com.serviingo.serviingo.model.CityModel;
import com.serviingo.serviingo.model.ThreeSectionModel;
import com.serviingo.serviingo.modelrepo.Responsee.HomePageRepo;
import com.serviingo.serviingo.modelrepo.Responsee.HomeScreenFinacialServiceRepo;
import com.serviingo.serviingo.modelrepo.Responsee.SendReferralRepo;
import com.serviingo.serviingo.storage.SharedPrefManager;
import com.squareup.picasso.Picasso;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class
HomeFragment extends Fragment implements HomePageePresenter.HomePageeView, SlidingImageAdapter.SliderClick,
        HomeCaetegoryAdapter.HomeAdapterClick, CustomizedGalleryAdapterr.CustomizedGalleryClick,
        SlidingMiddleImageAdapter.SlidingMiddle, HomeAdapter.HomeAdapterClick, ThreeSectionAdapter.HomeAdapterClick
        , FourSectionAdapter.HomeAdapterClick, CateoriesSectionAdapter.CateoriesSectionAdapterClick, HomeSubsubCategoryAdapter.HomeAdapterSubsubCategoryClick {
    // firt-recentcateogry
    //second-LattestService
    HomePageePresenter homePageePresenter;
    private static ViewPager mpage, VPMiddleslider;
    CirclePageIndicator indicator, indicatorr;
    private static int currentPage = 0;
    private static int No_page = 0;

    private static int currentPagee = 0;
    private static int No_pagee = 0;

    TextView cityvisivle, tvHeading, heeading, heading3, heading4, heading5, heading6, heading7, heading8, heading9, heading10, aboutHeading, aboutDesc,
            headingfinacialTv, desfinacialTv;
    RecyclerView box1_recyclerview, galleryRV, rcv, threesectionRV, sectionfourRv, ReviewRv, box1_recyclervieww;

    LinearLayoutManager linearLayoutManager;

    ImageView iv_Imageview, finacialIV;
    Spinner spinner_state;
    HomePageRepo homePageRepo;
    TextView sendrefer, tvreferdescc, refe, ed_Main, CateName;
    EditText searchhview;
    SwipeRefreshLayout refreshLayout;
    TextView tvserviceprovider;
    LinearLayout LLFinaicailC;
    ArrayList<CityModel> cityModelArrayList = new ArrayList<>();


    public HomeFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_home, container, false);
        setui(view);
        refreshLayout = view.findViewById(R.id.refreshLayout);

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
        box1_recyclerview = view.findViewById(R.id.box1_recyclerview);
        box1_recyclerview.setVisibility(View.GONE);
        homePageRepo = new HomePageRepo();
        homePageePresenter = new HomePageePresenter(this);
        homePageePresenter.GetHomePageContent(getContext(), "Lucknow");
        tvserviceprovider = view.findViewById(R.id.tvserviceprovider);

        mpage = view.findViewById(R.id.imageSlider);
        VPMiddleslider = view.findViewById(R.id.VPMiddleslider);
        indicator = (CirclePageIndicator) view.findViewById(R.id.indicator);
        indicatorr = (CirclePageIndicator) view.findViewById(R.id.indicatorr);
        tvHeading = view.findViewById(R.id.tvHeading);
        cityvisivle = view.findViewById(R.id.cityvisivle);
        heeading = view.findViewById(R.id.heeading);
        sendrefer = view.findViewById(R.id.sendrefer);
        searchhview = view.findViewById(R.id.searchhview);
        tvreferdescc = view.findViewById(R.id.tvreferdescc);
        refe = view.findViewById(R.id.refe);
        LLFinaicailC = view.findViewById(R.id.LLFinaicailC);
        ed_Main = view.findViewById(R.id.ed_Main);
        CateName = view.findViewById(R.id.CateName);
        heading3 = view.findViewById(R.id.heading3);
        heading4 = view.findViewById(R.id.heading4);
        heading5 = view.findViewById(R.id.heading5);
        heading6 = view.findViewById(R.id.heading6);
        heading7 = view.findViewById(R.id.heading7);
        heading8 = view.findViewById(R.id.heading8);
        heading9 = view.findViewById(R.id.heading9);
        heading10 = view.findViewById(R.id.heading10);
        aboutHeading = view.findViewById(R.id.aboutHeading);
        aboutDesc = view.findViewById(R.id.aboutDesc);
        headingfinacialTv = view.findViewById(R.id.headingfinacialTv);
        desfinacialTv = view.findViewById(R.id.desfinacialTv);

        iv_Imageview = view.findViewById(R.id.iv_Imageview);
        finacialIV = view.findViewById(R.id.finacialIV);
        spinner_state = view.findViewById(R.id.spinner_state);


        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        box1_recyclerview.setLayoutManager(gridLayoutManager);

        GridLayoutManager manager = new GridLayoutManager(getContext(), 3, GridLayoutManager.HORIZONTAL, false);

        box1_recyclervieww = view.findViewById(R.id.box1_recyclervieww);
        // GridLayoutManager gridLayoutManagerr = new GridLayoutManager(getContext(), 4);

        box1_recyclervieww.setLayoutManager(manager);


        galleryRV = view.findViewById(R.id.galleryRV);

        linearLayoutManager = (new LinearLayoutManager(getContext().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        galleryRV.setLayoutManager(linearLayoutManager);
        galleryRV.setHasFixedSize(true);


        rcv = view.findViewById(R.id.rcv);
      /*  GridLayoutManager gridLayoutManager2 = new GridLayoutManager(getContext(), 3);
        rcv.setLayoutManager(gridLayoutManager2);
        rcv.setHasFixedSize(true);*/

        LinearLayoutManager linearLayoutManagerrr = (new LinearLayoutManager(getContext().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        rcv.setLayoutManager(linearLayoutManagerrr);
        rcv.setHasFixedSize(true);

        threesectionRV = view.findViewById(R.id.threesectionRV);

        LinearLayoutManager linearLayoutManagerr = (new LinearLayoutManager(getContext().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        threesectionRV.setLayoutManager(linearLayoutManagerr);
        // threesectionRV.setHasFixedSize(true);


   /*
        GridLayoutManager threesection = new GridLayoutManager(getContext(), 2);
        threesectionRV.setLayoutManager(threesection);
        threesectionRV.setHasFixedSize(true);*/


        sectionfourRv = view.findViewById(R.id.sectionfourRv);

        LinearLayoutManager linearLayoutManar = (new LinearLayoutManager(getContext().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        sectionfourRv.setLayoutManager(linearLayoutManar);
        sectionfourRv.setHasFixedSize(true);


        ReviewRv = view.findViewById(R.id.ReviewRv);

        LinearLayoutManager linearLayoutMan = (new LinearLayoutManager(getContext().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        ReviewRv.setLayoutManager(linearLayoutMan);
        ReviewRv.setHasFixedSize(true);
/*
        GridLayoutManager sectionfour = new GridLayoutManager(getContext(), 2);
        sectionfourRv.setLayoutManager(sectionfour);
        sectionfourRv.setHasFixedSize(true);*/
    /*    linearLayoutManager = (new LinearLayoutManager(getContext().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
*/

        cityvisivle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cityvisivle.setVisibility(View.GONE);
                spinner_state.setVisibility(View.VISIBLE);
            }
        });


        ed_Main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment SearchFragment = new SearchFragment();
                fragmentTransaction.replace(R.id.fragment_Container, SearchFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        sendrefer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (SharedPrefManager.getInstance(getContext()).isLoggedin()) {
                    if (searchhview.getText().toString().trim().isEmpty()) {
                        Sneaker.with(getActivity())
                                .setTitle("Referral email or mobile number field must be required.")
                                .setMessage("")
                                .sneakError();
                    } else {

                        homePageePresenter.SendReferralContent(getContext(), searchhview.getText().toString().trim());

                    }

                } else {
                    Sneaker.with(getActivity())
                            .setTitle("Firstly Login In Your Account.")
                            .setMessage("")
                            .sneakWarning();

                }

            }
        });
        LLFinaicailC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment finacialFragment = new FinacialFragment();
                fragmentTransaction.replace(R.id.fragment_Container, finacialFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

    }

    @Override
    public void onHomePageeError(String message) {
        Sneaker.with(getActivity())
                .setTitle(message)
                .setMessage("")
                .sneakError();
    }

    @Override
    public void GetHomePageeSuccess(HomePageRepo response, String message) {
        mpage.setVisibility(View.INVISIBLE);
        VPMiddleslider.setVisibility(View.INVISIBLE);

        if (message.equalsIgnoreCase("ok")) {

            homePageePresenter.GetFinancialServices(getContext());

            if (response.getData().getSliders().size() > 0) {
                mpage.setVisibility(View.VISIBLE);
                mpage.setAdapter(new SlidingImageAdapter(response, getContext(), this));
                indicator.setViewPager(mpage);
                setIndicator(response.getData().getSliders().size());
            }

            SharedPrefManager.getInstance(getActivity())
                    .CityIDDetails(String.valueOf(response.getData().getCity().getId()));

            heading3.setText(response.getData().getMainSection().getHeading());
            heading4.setText(response.getData().getMainSection().getTitle());
            heading5.setText(response.getData().getTwoSection().getHeading());
            heading6.setText(response.getData().getTwoSection().getTitle());
            heading7.setText(response.getData().getThreeSection().getHeading());
            heading8.setText(response.getData().getThreeSection().getTitle());
            heading9.setText(response.getData().getFourSection().getHeading());
            heading10.setText(response.getData().getFourSection().getTitle());
            aboutHeading.setText(response.getData().getAboutContent().getHeading());


            tvreferdescc.setText(response.getData().getReferAndEarn().getTitle());
            refe.setText(response.getData().getReferAndEarn().getHeading());

            // cityvisivle.setVisibility(View.VISIBLE);
            //cityvisivle.setText(response.getData().getCity().getName());

            aboutDesc.setText(Html.fromHtml(response.getData().getAboutContent().getDescription()));

            Picasso.get().load(response.getData().getAboutImagePath() + response.getData().getAboutContent().getImage()).into(iv_Imageview);

            tvserviceprovider.setText(response.getData().getAboutContent().getServiceProvide() + "+");
            if (response.getData().getAllCategories().size() > 0) {

                box1_recyclervieww.setAdapter(new HomeCaetegoryAdapter(response, getContext(), this));

            }


        }
        if (response.getData().getGalleryImages().size() > 0) {
            // initialize the adapter
            CustomizedGalleryAdapterr customGalleryAdapter = new CustomizedGalleryAdapterr(response, getContext(), this);

            // set the adapter for gallery
            galleryRV.setAdapter(customGalleryAdapter);
/*
            final int duration = 10;
            final int pixelsToMove = 30;
            final Handler mHandler = new Handler(Looper.getMainLooper());
            final Runnable SCROLLING_RUNNABLE = new Runnable() {

                @Override
                public void run() {
                    galleryRV.smoothScrollBy(pixelsToMove, 0);
                    mHandler.postDelayed(this, duration);
                }
            };

            galleryRV.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    int lastItem = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                    if (lastItem == linearLayoutManager.getItemCount() - 1) {
                        mHandler.removeCallbacks(SCROLLING_RUNNABLE);
                        Handler postHandler = new Handler();
                        postHandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                galleryRV.setAdapter(null);
                                galleryRV.setAdapter(customGalleryAdapter);
                                mHandler.postDelayed(SCROLLING_RUNNABLE, 2000);
                            }
                        }, 2000);
                    }
                }
            });
            mHandler.postDelayed(SCROLLING_RUNNABLE, 2000);*/


        }
        if (response.getData().getSubCategories().size() > 0) {

            rcv.setAdapter(new HomeAdapter(response, getContext(), this));

        }
        if (response.getData().getMiddleSliders().size() > 0) {

            VPMiddleslider.setVisibility(View.VISIBLE);
            VPMiddleslider.setAdapter(new SlidingMiddleImageAdapter(response, getContext(), this));
            indicatorr.setViewPager(VPMiddleslider);

            setmiddelIndicator(response.getData().getMiddleSliders().size());
        }
        if (response.getData().getReviews().size() > 0) {
            // initialize the adapter
            cityModelArrayList.clear();


            for (int i = 0; i < response.getData().getReviews().size(); i++) {
                if (SharedPrefManager.getInstance(getContext()).GetCityid() .equalsIgnoreCase( response.getData().getReviews().get(i).getReview_city_id()) ){

                    if (response.getData().getReviews().get(i).getGetUserInfo() != null) {

                        CityModel cityModel = new CityModel(response.getData().getReviews().get(i).getReview(), response.getData().getReviews().get(i).getGetUserInfo().getName(),
                                response.getData().getReviews().get(i).getGetUserInfo().getProfilePhotoPath());
                        cityModelArrayList.add(cityModel);


                    }


                }


            }
            ReviewSectionAdapter customGalleryAdapter = new ReviewSectionAdapter(cityModelArrayList, getContext());

            // set the adapter for gallery
            ReviewRv.setAdapter(customGalleryAdapter);
        }
        if (response.getData().getHomeSubsubCategories().size() > 0) {
            sectionfourRv.setAdapter(new HomeSubsubCategoryAdapter(response, getContext(), this));
        }


        CitySpinnerAdapterhome coinSpinnerAdapter = new CitySpinnerAdapterhome(getContext(), response);
        spinner_state.setAdapter(coinSpinnerAdapter);

        for (int i = 0; i < response.getData().getServeCities().size(); i++) {
            if (response.getData().getServeCities().get(i).getName().equalsIgnoreCase(response.getData().getCity().getName())) {
                spinner_state.setSelection(i);

            }
        }
        //
        spinner_state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //spinner_state.setSelection(Integer.parseInt(response.getData().getCity().getName()));


                if (!response.getData().getServeCities().get(position).getName().equalsIgnoreCase(response.getData().getCity().getName())) {

                    box1_recyclerview.setVisibility(View.GONE);
                    box1_recyclerview.setAdapter(null);
                    galleryRV.setAdapter(null);

                    threesectionRV.setAdapter(null);
                    rcv.setAdapter(null);
                    sectionfourRv.setAdapter(null);
                    ReviewRv.setAdapter(null);
                       /* mpage.setAdapter(null);
                        VPMiddleslider.setAdapter(null);
*/
                    homePageePresenter.GetHomePageContent(getContext(), response.getData().getServeCities().get(position).getName());

                }

                //homePageRepo=null;


                      /*  homePageRepo.getData().getSliders().clear();
                        homePageRepo.getData().getAllCategories().clear();
                        homePageRepo.getData().getGalleryImages().clear();

                       */
                Log.e("homePageePresenter", response.getData().getServeCities().get(position).getName());

                    /*if (position == 0) {


                    } else {


                        box1_recyclerview.setAdapter(null);
                        galleryRV.setAdapter(null);

                        threesectionRV.setAdapter(null);
                        rcv.setAdapter(null);
                        sectionfourRv.setAdapter(null);
                        ReviewRv.setAdapter(null);
                       *//* mpage.setAdapter(null);
                        VPMiddleslider.setAdapter(null);
*//*
                        homePageePresenter.GetHomePageContent(getContext(), response.getData().getServeCities().get(position).getName());
                        //homePageRepo=null;


                      *//*  homePageRepo.getData().getSliders().clear();
                        homePageRepo.getData().getAllCategories().clear();
                        homePageRepo.getData().getGalleryImages().clear();

                       *//*
                        Log.e("homePageePresenter", response.getData().getServeCities().get(position).getName());
                        // HomePageRepo.Data.AllCategory.cl
                        // homePageRepo.getData().getAllCategories().clear();
                    }*/

                 /*   Sneaker.with(getActivity())
                            .setTitle(response.getData().getServeCities().get(position).getName())
                            .setMessage("")
                            .sneakError();*/
/*

                    city_id = cityModelList.get(position).getId();
*/

                // GetCity(state_id);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }


    @Override
    public void GetFinancialServicesSuccess(HomeScreenFinacialServiceRepo response, String message) {

        if (message.equalsIgnoreCase("ok")) {
            Picasso.get().load(response.getData().getFinance().getImages()).into(finacialIV);

            headingfinacialTv.setText(response.getData().getFinance().getHeading());
            desfinacialTv.setText(response.getData().getFinance().getDescription());
            CateName.setText(response.getData().getFinance().getHeading());

        }


    }

    @Override
    public void SendReferralSuccess(SendReferralRepo response, String message) {
        Sneaker.with(getActivity())
                .setTitle(response.getMessage())
                .setMessage("")
                .sneakSuccess();
    }

    @Override
    public void onHomePageFailure(Throwable t) {
        Sneaker.with(getActivity())
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();
    }

    @Override
    public void showHideProgress(boolean isShow) {

        if (isShow) {


            AppTools.showRequestDialog(getActivity());

            box1_recyclerview.setVisibility(View.GONE);

        } else {
            AppTools.hideDialog();
            box1_recyclerview.setVisibility(View.VISIBLE);

        }
    }

    public void setIndicator(int size) {
        final float density = getResources().getDisplayMetrics().density;
        //Set circle indicator radius
        indicator.setRadius(5 * density);
        No_page = size;
        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == No_page) {
                    currentPage = 0;
                }
                mpage.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });
    }

    public void setmiddelIndicator(int size) {
        final float density = getResources().getDisplayMetrics().density;
        //Set circle indicator radius
        indicatorr.setRadius(5 * density);
        No_pagee = size;
        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPagee == No_pagee) {
                    currentPagee = 0;
                }
                VPMiddleslider.setCurrentItem(currentPagee++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);

        // Pager listener over indicator
        indicatorr.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPagee = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });
    }

    @Override
    public void SliderClickk(HomePageRepo repo, int pos) {

      /*  Sneaker.with(getActivity())
                .setTitle(String.valueOf(repo.getData().getSliders().get(pos).getId()))
                .setMessage("")
                .sneakError();*/


        if (repo.getData().getSliders().get(pos).getPageType() != null) {
            String page_type = repo.getData().getSliders().get(pos).getPageType();

            if (page_type.equalsIgnoreCase("sub-detail")) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment subCategoryFragment = new SubCategoryFragment();
                Bundle args = new Bundle();
                // args.putSerializable(ARG_ANIMALS, animals as Serializable)
                args.putString("id", String.valueOf(repo.getData().getSliders().get(pos).getRedirectionType().getId()));
                subCategoryFragment.setArguments(args);
                fragmentTransaction.replace(R.id.fragment_Container, subCategoryFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            } else if (page_type.equalsIgnoreCase("packages")) {

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment lowcontactFragment = new LowcontactFragment();
                Bundle args = new Bundle();
                args.putString("id", String.valueOf(repo.getData().getSliders().get(pos).getRedirectionType().getId()));
                args.putString("sub", "subsub");
                args.putString("name", "name");
                args.putString("short_description", "short_description");
                lowcontactFragment.setArguments(args);
                fragmentTransaction.replace(R.id.fragment_Container, lowcontactFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            } else if (page_type.equalsIgnoreCase("finance-subcategories")) {


                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment addonesFragment = new FinanceSubCategoriesFragment();
                Bundle args = new Bundle();
                args.putString("id", String.valueOf(repo.getData().getSliders().get(pos).getRedirectionType().getId()));
                args.putString("getName", " ");

                addonesFragment.setArguments(args);
                fragmentTransaction.replace(R.id.fragment_Container, addonesFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


            } else if (page_type.equalsIgnoreCase("finance-services")) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment addonesFragment = new FinanceServicesFragment();
                Bundle args = new Bundle();
                args.putString("id", String.valueOf(repo.getData().getSliders().get(pos).getRedirectionType().getId()));
                args.putString("getName", " ");
                addonesFragment.setArguments(args);
                fragmentTransaction.replace(R.id.fragment_Container, addonesFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


            } else if (page_type.equalsIgnoreCase("finance-service-detail")) {


                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment addonesFragment = new FinanceServiceDetailFragment();
                Bundle args = new Bundle();
                args.putString("id", String.valueOf(repo.getData().getGalleryImages().get(pos).getRedirectionType().getId()));
                args.putString("getName", " ");

                addonesFragment.setArguments(args);
                fragmentTransaction.replace(R.id.fragment_Container, addonesFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            } else {
                String url = String.valueOf(repo.getData().getSliders().get(pos).getLink());


                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setPackage("com.android.chrome");
                try {
                    getContext().startActivity(intent);
                } catch (ActivityNotFoundException ex) {
                    // Chrome browser presumably not installed so allow user to choose instead
                    intent.setPackage(null);
                    getContext().startActivity(intent);
                }


            }


        } else {

            String url = String.valueOf(repo.getData().getSliders().get(pos).getLink());


            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setPackage("com.android.chrome");
            try {
                getContext().startActivity(intent);
            } catch (ActivityNotFoundException ex) {
                // Chrome browser presumably not installed so allow user to choose instead
                intent.setPackage(null);
                getContext().startActivity(intent);
            }


        }





        /*


        String url = String.valueOf(repo.getData().getSliders().get(pos).getUrl());

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setPackage("com.android.chrome");
        try {
            getContext().startActivity(intent);
        } catch (ActivityNotFoundException ex) {
            // Chrome browser presumably not installed so allow user to choose instead
            intent.setPackage(null);
            getContext().startActivity(intent);
        }

*/
       /*
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        // Verify that the intent will resolve to an activity
        if (intent.resolveActivity(getContext().getPackageManager()) != null) {
            // Here we use an intent without a Chooser unlike the next example
            startActivity(intent);
        }*/

    }


    @Override
    public void HomeAdapterClickk(HomePageRepo repo, int pos) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment subCategoryFragment = new SubCategoryFragment();
        Bundle args = new Bundle();
        // args.putSerializable(ARG_ANIMALS, animals as Serializable)
        args.putString("id", String.valueOf(repo.getData().getAllCategories().get(pos).getId()));
        subCategoryFragment.setArguments(args);
        fragmentTransaction.replace(R.id.fragment_Container, subCategoryFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    @Override
    public void threeSecotion(ArrayList<ThreeSectionModel> arrayListmodel) {
        threesectionRV.setAdapter(new ThreeSectionAdapter(arrayListmodel, getContext(), this));

    }

    @Override
    public void CategoriesList(ArrayList<ThreeSectionModel> arrayListmodel) {

        // sectionfourRv.setAdapter(new FourSectionAdapter(foursectionlist, getContext(), this));

        box1_recyclerview.setAdapter(new CateoriesSectionAdapter(getContext(), arrayListmodel, this));
        //  box1_recyclerview.setVisibility(View.VISIBLE);

        // Toast.makeText(getContext(), arrayListmodel.size()+"", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void twoSecotion(ArrayList<ThreeSectionModel> arrayListmodel) {
        //rcv.setAdapter(new HomeAdapter(arrayListmodel, getContext(), this));

    }

    @Override
    public void FourSecotion(ArrayList<ThreeSectionModel> foursectionlist) {
        //  sectionfourRv.setAdapter(new FourSectionAdapter(foursectionlist, getContext(), this));

    }

    @Override
    public void CustomizedGalleryClickk(HomePageRepo repo, int pos) {

        String page_type = repo.getData().getGalleryImages().get(pos).getPageType();

        if (page_type.equalsIgnoreCase("sub-detail")) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Fragment subCategoryFragment = new SubCategoryFragment();
            Bundle args = new Bundle();
            // args.putSerializable(ARG_ANIMALS, animals as Serializable)
            args.putString("id", String.valueOf(repo.getData().getGalleryImages().get(pos).getRedirectionType().getId()));
            subCategoryFragment.setArguments(args);
            fragmentTransaction.replace(R.id.fragment_Container, subCategoryFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        } else if (page_type.equalsIgnoreCase("packages")) {

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Fragment lowcontactFragment = new LowcontactFragment();
            Bundle args = new Bundle();
            args.putString("id", String.valueOf(repo.getData().getGalleryImages().get(pos).getRedirectionType().getId()));
            args.putString("sub", "subsub");
            args.putString("name", "name");
            args.putString("short_description", "short_description");
            lowcontactFragment.setArguments(args);
            fragmentTransaction.replace(R.id.fragment_Container, lowcontactFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        } else if (page_type.equalsIgnoreCase("finance-subcategories")) {


            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Fragment addonesFragment = new FinanceSubCategoriesFragment();
            Bundle args = new Bundle();
            args.putString("id", String.valueOf(repo.getData().getGalleryImages().get(pos).getRedirectionType().getId()));
            args.putString("getName", " ");

            addonesFragment.setArguments(args);
            fragmentTransaction.replace(R.id.fragment_Container, addonesFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();


        } else if (page_type.equalsIgnoreCase("finance-services")) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Fragment addonesFragment = new FinanceServicesFragment();
            Bundle args = new Bundle();
            args.putString("id", String.valueOf(repo.getData().getGalleryImages().get(pos).getRedirectionType().getId()));
            args.putString("getName", " ");
            addonesFragment.setArguments(args);
            fragmentTransaction.replace(R.id.fragment_Container, addonesFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();


        } else if (page_type.equalsIgnoreCase("finance-service-detail")) {


            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Fragment addonesFragment = new FinanceServiceDetailFragment();
            Bundle args = new Bundle();
            args.putString("id", String.valueOf(repo.getData().getGalleryImages().get(pos).getRedirectionType().getId()));
            args.putString("getName", " ");

            addonesFragment.setArguments(args);
            fragmentTransaction.replace(R.id.fragment_Container, addonesFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        } else {
            String url = String.valueOf(repo.getData().getGalleryImages().get(pos).getLink());


            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setPackage("com.android.chrome");
            try {
                getContext().startActivity(intent);
            } catch (ActivityNotFoundException ex) {
                // Chrome browser presumably not installed so allow user to choose instead
                intent.setPackage(null);
                getContext().startActivity(intent);
            }


        }


    }

    @Override
    public void SlidingMiddle(HomePageRepo repo, int pos) {
      /*  Sneaker.with(getActivity())
                .setTitle(String.valueOf(pos))
                .setMessage("")
                .sneakError();
*/


        if (repo.getData().getMiddleSliders().get(pos).getPageType() != null) {
            String page_type = repo.getData().getMiddleSliders().get(pos).getPageType();

            if (page_type.equalsIgnoreCase("sub-detail")) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment subCategoryFragment = new SubCategoryFragment();
                Bundle args = new Bundle();
                // args.putSerializable(ARG_ANIMALS, animals as Serializable)
                args.putString("id", String.valueOf(repo.getData().getMiddleSliders().get(pos).getRedirectionType().getId()));
                subCategoryFragment.setArguments(args);
                fragmentTransaction.replace(R.id.fragment_Container, subCategoryFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            } else if (page_type.equalsIgnoreCase("packages")) {

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment lowcontactFragment = new LowcontactFragment();
                Bundle args = new Bundle();
                args.putString("id", String.valueOf(repo.getData().getMiddleSliders().get(pos).getRedirectionType().getId()));
                args.putString("sub", "subsub");
                args.putString("name", "name");
                args.putString("short_description", "short_description");
                lowcontactFragment.setArguments(args);
                fragmentTransaction.replace(R.id.fragment_Container, lowcontactFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            } else if (page_type.equalsIgnoreCase("finance-subcategories")) {


                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment addonesFragment = new FinanceSubCategoriesFragment();
                Bundle args = new Bundle();
                args.putString("id", String.valueOf(repo.getData().getMiddleSliders().get(pos).getRedirectionType().getId()));
                args.putString("getName", " ");

                addonesFragment.setArguments(args);
                fragmentTransaction.replace(R.id.fragment_Container, addonesFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


            } else if (page_type.equalsIgnoreCase("finance-services")) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment addonesFragment = new FinanceServicesFragment();
                Bundle args = new Bundle();
                args.putString("id", String.valueOf(repo.getData().getMiddleSliders().get(pos).getRedirectionType().getId()));
                args.putString("getName", " ");
                addonesFragment.setArguments(args);
                fragmentTransaction.replace(R.id.fragment_Container, addonesFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


            } else if (page_type.equalsIgnoreCase("finance-service-detail")) {


                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment addonesFragment = new FinanceServiceDetailFragment();
                Bundle args = new Bundle();
                args.putString("id", String.valueOf(repo.getData().getMiddleSliders().get(pos).getRedirectionType().getId()));
                args.putString("getName", " ");

                addonesFragment.setArguments(args);
                fragmentTransaction.replace(R.id.fragment_Container, addonesFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            } else {
                String url = String.valueOf(repo.getData().getMiddleSliders().get(pos).getLink());


                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setPackage("com.android.chrome");
                try {
                    getContext().startActivity(intent);
                } catch (ActivityNotFoundException ex) {
                    // Chrome browser presumably not installed so allow user to choose instead
                    intent.setPackage(null);
                    getContext().startActivity(intent);
                }


            }



/*

        String url = String.valueOf(repo.getData().getMiddleSliders().get(pos).getUrl());

     */
/*   Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        // Verify that the intent will resolve to an activity
        if (intent.resolveActivity(getContext().getPackageManager()) != null) {
            // Here we use an intent without a Chooser unlike the next example
            startActivity(intent);
        }
*//*


        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setPackage("com.android.chrome");
        try {
            getContext().startActivity(intent);
        } catch (ActivityNotFoundException ex) {
            // Chrome browser presumably not installed so allow user to choose instead
            intent.setPackage(null);
            getContext().startActivity(intent);
        }
*/

        } else {
            String url = String.valueOf(repo.getData().getMiddleSliders().get(pos).getLink());


            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setPackage("com.android.chrome");
            try {
                getContext().startActivity(intent);
            } catch (ActivityNotFoundException ex) {
                // Chrome browser presumably not installed so allow user to choose instead
                intent.setPackage(null);
                getContext().startActivity(intent);
            }


        }

    }

    @Override
    public void HomeAdaptertwosecotionClickk(HomePageRepo homePageRepo, int position) {


        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment subSubCategoriesFragment = new LowcontactFragment();
        Bundle args = new Bundle();
        args.putString("id", String.valueOf(homePageRepo.getData().getSubCategories().get(position).getId()));
        args.putString("sub", "sub");
        args.putString("name", homePageRepo.getData().getSubCategories().get(position).getSubCategoryName());


        args.putString("short_description", homePageRepo.getData().getSubCategories().get(position).getShortDescription());
        subSubCategoriesFragment.setArguments(args);
        fragmentTransaction.replace(R.id.fragment_Container, subSubCategoriesFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();




/*
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment subCategoryFragment = new SubCategoryFragment();
        Bundle args = new Bundle();
        // args.putSerializable(ARG_ANIMALS, animals as Serializable)
        args.putString("id", id);
        subCategoryFragment.setArguments(args);
        fragmentTransaction.replace(R.id.fragment_Container, subCategoryFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();*/

    }

    @Override
    public void HomeAdapterthirdsecotionClickk(String id) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment subCategoryFragment = new SubCategoryFragment();
        Bundle args = new Bundle();
        // args.putSerializable(ARG_ANIMALS, animals as Serializable)
        args.putString("id", id);
        subCategoryFragment.setArguments(args);
        fragmentTransaction.replace(R.id.fragment_Container, subCategoryFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void HomeAdapterFoursecotionClickk(String id) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment subCategoryFragment = new SubCategoryFragment();
        Bundle args = new Bundle();
        // args.putSerializable(ARG_ANIMALS, animals as Serializable)
        args.putString("id", id);
        subCategoryFragment.setArguments(args);
        fragmentTransaction.replace(R.id.fragment_Container, subCategoryFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void CateoriesSectionAdapterClick(String id) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment subCategoryFragment = new SubCategoryFragment();
        Bundle args = new Bundle();
        // args.putSerializable(ARG_ANIMALS, animals as Serializable)
        args.putString("id", id);
        subCategoryFragment.setArguments(args);
        fragmentTransaction.replace(R.id.fragment_Container, subCategoryFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void SubsubCategoryClickk(HomePageRepo repo, int pos) {
        // Toast.makeText(getContext(), pos+"", Toast.LENGTH_SHORT).show();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment subSubCategoriesFragment = new LowcontactFragment();
        Bundle args = new Bundle();
        args.putString("id", String.valueOf(repo.getData().getHomeSubsubCategories().get(pos).getId()));
        args.putString("sub", "subsub");
        args.putString("name", repo.getData().getHomeSubsubCategories().get(pos).getName());
        args.putString("short_description", " .");
        subSubCategoriesFragment.setArguments(args);
        fragmentTransaction.replace(R.id.fragment_Container, subSubCategoriesFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
}