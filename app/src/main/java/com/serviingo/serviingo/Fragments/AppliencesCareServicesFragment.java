package com.serviingo.serviingo.Fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.Adapterr.CartAdapter;
import com.serviingo.serviingo.Adapterr.TimeSlotAdapter.DatelistslotAdapterr;
import com.serviingo.serviingo.Adapterr.TimeSlotAdapter.Package_servicesAdapterr;
import com.serviingo.serviingo.Adapterr.TimeSlotAdapter.timelistslotAdapterr;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.ViewPresenter.CartPresenter;
import com.serviingo.serviingo.ViewPresenter.TimeSlotPresenter;
import com.serviingo.serviingo.dialogue.BuyMemberShipBottomSheet;
import com.serviingo.serviingo.dialogue.LoginPage_BottomSheet;
import com.serviingo.serviingo.model.CartModel;
import com.serviingo.serviingo.modelrepo.Responsee.CartRepo;
import com.serviingo.serviingo.modelrepo.Responsee.CheckMinimumOrderPriceRepo;
import com.serviingo.serviingo.modelrepo.Responsee.CouponApplyRepo;
import com.serviingo.serviingo.modelrepo.Responsee.DateSlotRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.CheckMembershipDiscountRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.MyMembershipRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.WithoutTokenMembershipDetailsRepo;
import com.serviingo.serviingo.modelrepo.Responsee.ServetimeSlotRepo;
import com.serviingo.serviingo.modelrepo.request.CartRequest;
import com.serviingo.serviingo.modelrepo.request.CouponApplyRequest;
import com.serviingo.serviingo.modelrepo.request.CreateOrderRequest;
import com.serviingo.serviingo.modelrepo.request.TempCartRequest;
import com.serviingo.serviingo.modelrepo.request.WithoutTokenMemberdeyailsRequest;
import com.serviingo.serviingo.storage.SharedPrefManager;
import com.serviingo.serviingo.utils.AppUrls;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import okhttp3.ResponseBody;

import static android.content.Context.MODE_PRIVATE;

public class AppliencesCareServicesFragment extends Fragment implements CartPresenter.CartListView, CartAdapter.CartListener {

    Bundle extras;
    String Id, Quentiy;
    TextView tvHeading, tvSubHeading, tvsafty, tvrus, tvAc, tv, tvdata, tvv, tvwallet, text, tvsubmoney, tvrs, tvvaluue, signup, tvAddMoreServices, SubAmount_TV,
            tvDiscount;
    ImageView imageView, ivgreens;
    CartPresenter cartPresenter;
    ArrayList<String> arrayList = new ArrayList<>();
    String addon_service_ids;
    CartAdapter cartAdapter;
    RecyclerView recyclerView;
    RelativeLayout relativelayout;
    TextView totalavailablebalance, pay;
    String category_id;
    String SafetyAndHygieneFee;
    String Total, Totall, payment_method, Subtoal, discount_amount, MemberShipDiscount, plan_id;
    RadioButton rdwallet, rdallet, rdOnline;
    ImageView updateCartDecrease, updateCartIncrease;
    TextView quentityTv;
    CartRequest cartRequest;
    int finalprice, price;
    int quantity;
    CartRequest.AddonService addonService;
    ArrayList<CartRequest.AddonService> addonServices = new ArrayList<>();
    String membership_id, membership_cost;

    TextView cartnumbertv;

    ArrayList<CartModel> addonse = new ArrayList<>();
    CartModel cartModel;

    List<Integer> addonServiceIds = null;
    String Subcategory, serve_time = "2021-08-24", serve_date = "000";
    TextView timeslot, memebershipstatus, descMemberTv;

    ViewDialog alert;
    ImageView openSlotBox, deletemembershipPrice;
    LinearLayout slottimeLL, memebershipstatusLL;
    TextView dateSlot, timeslott;
    ArrayList<String> arrayListt = new ArrayList<>();
    ArrayList aList = new ArrayList<>();

    String checkTempcart;
    RecyclerView package_servicesRC;
    TextView buymember, memebershipPurchasename, memebershipPurchaseprice;
    LinearLayout memebershipPurchase;
    ImageView memebershipPurchaseDelete;


    LinearLayout applyLL, removeLL;
    EditText et_promo;
    TextView apply, Remove;

    String CouponDiscountAmount = " ", coupon_id = " ";
    FrameLayout fl;


    public AppliencesCareServicesFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_appliences_care_services, container, false);
        setui(view);

        return view;


    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void setui(View view) {
        cartnumbertv = getActivity().findViewById(R.id.cartnumbertv);
        buymember = view.findViewById(R.id.buymember);
        memebershipPurchase = view.findViewById(R.id.memebershipPurchase);
        memebershipPurchaseDelete = view.findViewById(R.id.memebershipPurchaseDelete);
        memebershipPurchasename = view.findViewById(R.id.memebershipPurchasename);
        memebershipPurchaseprice = view.findViewById(R.id.memebershipPurchaseprice);
        memebershipstatusLL = view.findViewById(R.id.memebershipstatusdiscount);
        fl = view.findViewById(R.id.fl);
        addonServices.clear();


        arrayListt.clear();
        arrayList.clear();

        alert = new ViewDialog();

        AppTools.showRequestDialog(getActivity());
        cartPresenter = new CartPresenter(this);

        extras = getArguments();


        if (extras != null) {

            Id = getArguments().getString("id");
            arrayList.clear();
            aList.clear();
            arrayList = getArguments().getStringArrayList("arrayList");
            Quentiy = getArguments().getString("Quentiy");

            checkTempcart = getArguments().getString("checkTempcart");
            addon_service_ids = getArguments().getString("csv");
            // membership_id= getArguments().getString("membership_id");
            //membership_cost= getArguments().getString("membership_cost");
            //addon_service_ids = String.join(",", arrayList);

            if (checkTempcart == null) {
                addon_service_ids = SharedPrefManager.getInstance(getContext()).Get_addon_service_Array_Id();

            }
            //Toast.makeText(getContext(), addon_service_ids + "extras != null", Toast.LENGTH_SHORT).show();

            if (addon_service_ids != null) {
                aList = new ArrayList(Arrays.asList(addon_service_ids.split(",")));

            }


            //Toast.makeText(getContext(), addon_service_ids, Toast.LENGTH_SHORT).show();

            if (arrayList.size() > 0) {

                for (int i = 0; i < aList.size(); i++) {
                    String id = String.valueOf(aList.get(i));
                    addonService = new CartRequest.AddonService(id, "1");
                    addonServices.add(addonService);

                    cartRequest = new CartRequest(Id, Quentiy, addonServices);

                    System.out.println(" -->" + aList.get(i));
                }
                cartPresenter.GetAddonse(getContext(), cartRequest);
                if (SharedPrefManager.getInstance(getActivity()).isLoggedin()) {

                    TempCartRequest tempCartRequest = new TempCartRequest(Id, aList, "", " ", " ", " ", "No");
                    cartPresenter.TempCartRequest(getContext(), tempCartRequest);
                    buymember.setVisibility(View.VISIBLE);

                }


            } else {

                cartRequest = new CartRequest(Id, Quentiy, addonServices);

                cartPresenter.GetAddonse(getContext(), cartRequest);
                if (SharedPrefManager.getInstance(getActivity()).isLoggedin()) {

                    buymember.setVisibility(View.VISIBLE);

                    TempCartRequest tempCartRequest = new TempCartRequest(Id, aList, "", " ", " ", " ", "No");
                    cartPresenter.TempCartRequest(getContext(), tempCartRequest);
                }
                //System.out.println(" -->"+aList.get(i));

                //Toast.makeText(getContext(), "else", Toast.LENGTH_SHORT).show();


            }

            SharedPrefManager.getInstance(getActivity())
                    .OrderId(Id, addon_service_ids, Quentiy);
            SharedPrefManager.getInstance(getActivity())
                    .OrderDetails(null, null);
            // Toast.makeText(getContext(), "extra", Toast.LENGTH_SHORT).show();

        } else if (SharedPrefManager.getInstance(getContext()).isPacakgein() != null) {

            aList.clear();
            //loadData();


            addon_service_ids = SharedPrefManager.getInstance(getContext()).Get_addon_service_Array_Id();
            Id = SharedPrefManager.getInstance(getContext()).Addonsegetpackage_id();
            Quentiy = SharedPrefManager.getInstance(getContext()).Addonsequantityid();
            if (addon_service_ids != null) {

                //   Toast.makeText(getContext(), addon_service_ids + "", Toast.LENGTH_SHORT).show();

                Log.e("checsdskkkkk", addon_service_ids);

                aList = new ArrayList(Arrays.asList(addon_service_ids.split(",")));

                if (SharedPrefManager.getInstance(getActivity()).isLoggedin()) {
                    buymember.setVisibility(View.VISIBLE);
                    TempCartRequest tempCartRequest = new TempCartRequest(Id, aList, "", " ", " ", " ", "No");
                    cartPresenter.TempCartRequest(getContext(), tempCartRequest);
                }

                for (int i = 0; i < aList.size(); i++) {
                    String id = String.valueOf(aList.get(i));
                    addonService = new CartRequest.AddonService(id, "1");
                    addonServices.add(addonService);

                    cartRequest = new CartRequest(Id, Quentiy, addonServices);

                    System.out.println(" -->" + aList.get(i));
                }

                cartRequest = new CartRequest(Id, Quentiy, addonServices);
                cartPresenter.GetAddonse(getContext(), cartRequest);


            } else {

                //  Toast.makeText(getContext(), "faasda", Toast.LENGTH_SHORT).show();
                cartRequest = new CartRequest(Id, Quentiy, addonServices);

                cartPresenter.GetAddonse(getContext(), cartRequest);

              /*  Id = SharedPrefManager.getInstance(getContext()).Addonsegetpackage_id();
                addon_service_ids = SharedPrefManager.getInstans(getContext()).getaddon_service_ids();
            */
            }


        }
        deletemembershipPrice = view.findViewById(R.id.deletemembershipPrice);
        openSlotBox = view.findViewById(R.id.openSlotBox);
        slottimeLL = view.findViewById(R.id.slottimeLL);
        package_servicesRC = view.findViewById(R.id.package_servicesRC);
        slottimeLL.setVisibility(View.GONE);
        dateSlot = view.findViewById(R.id.dateSlot);
        timeslott = view.findViewById(R.id.timeslott);
        timeslot = view.findViewById(R.id.timeslot);
        memebershipstatus = view.findViewById(R.id.memebershipstatusTv);
        descMemberTv = view.findViewById(R.id.descMemberTv);
        tvHeading = view.findViewById(R.id.tvHeading);
        tvDiscount = view.findViewById(R.id.tvDiscount);
        imageView = view.findViewById(R.id.imageView);
        tvSubHeading = view.findViewById(R.id.tvSubHeading);
        tvsafty = view.findViewById(R.id.tvsafty);
        rdwallet = view.findViewById(R.id.rdwallet);
        rdallet = view.findViewById(R.id.rdallet);
        rdOnline = view.findViewById(R.id.rdOnline);
        tvrus = view.findViewById(R.id.tvrus);
        SubAmount_TV = view.findViewById(R.id.SubAmount_TV);
        tvAc = view.findViewById(R.id.tvAc);
        tv = view.findViewById(R.id.tv);
        tvdata = view.findViewById(R.id.tvdata);
        tvv = view.findViewById(R.id.tvv);
        tvwallet = view.findViewById(R.id.tvwallet);
        text = view.findViewById(R.id.text);
        ivgreens = view.findViewById(R.id.ivgreens);
        tvsubmoney = view.findViewById(R.id.tvsubmoney);
        tvAddMoreServices = view.findViewById(R.id.tvAddMoreServices);
        tvrs = view.findViewById(R.id.tvrs);
        tvHeading = view.findViewById(R.id.tvHeading);
        tvHeading = view.findViewById(R.id.tvHeading);
        tvvaluue = view.findViewById(R.id.tvvaluue);
        recyclerView = view.findViewById(R.id.recyclerView);
        signup = view.findViewById(R.id.signup);
        relativelayout = view.findViewById(R.id.relativelayout);
        quentityTv = view.findViewById(R.id.quentityTv);

        applyLL = view.findViewById(R.id.applyLL);
        removeLL = view.findViewById(R.id.removeLL);
        et_promo = view.findViewById(R.id.et_promo);
        apply = view.findViewById(R.id.apply);
        Remove = view.findViewById(R.id.Remove);


        Remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeLL.setVisibility(View.GONE);
                applyLL.setVisibility(View.VISIBLE);
                Total = String.valueOf(Integer.valueOf(Total) + Integer.valueOf(CouponDiscountAmount));
                tvvaluue.setText(" \u20B9" + Total);
                pay.setText("Pay Now  \u20B9" + Total);


                CouponDiscountAmount = "";
                coupon_id = "";
                Sneaker.with(getActivity())
                        .setTitle("Coupon Removed Successfully")
                        .setMessage("")
                        .sneakSuccess();
                et_promo.setText("");

            }
        });


        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Promocode = et_promo.getText().toString().trim();
                if (Promocode.isEmpty()) {
                    Sneaker.with(getActivity())
                            .setTitle("Please Enter Coupon Code.")
                            .setMessage("")
                            .sneakError();
                } else {

                    CouponApplyRequest coupondata = new CouponApplyRequest(Promocode, Totall, plan_id,/*SharedPrefManager.getInstance(getActivity()).getmembership_id(), SharedPrefManager.getInstance(getActivity()).GetMembershipCost()*/MemberShipDiscount, Id);


                    cartPresenter.CouponApply(getContext(), coupondata);
                    Log.e("CouponApplyRequest", membership_id + "\n" + coupondata.toString());

                    //Log.e("membership_idmembership_id",membership_id, coupondata.toString());


                }
            }
        });

        // quentityTv.setText(Quentiy);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);

        GridLayoutManager gridLayoutManagerr = new GridLayoutManager(getContext(), 1, LinearLayoutManager.VERTICAL, false);
        package_servicesRC.setLayoutManager(gridLayoutManagerr);
        package_servicesRC.setHasFixedSize(true);

        totalavailablebalance = view.findViewById(R.id.totalavailablebalance);
        updateCartDecrease = view.findViewById(R.id.updateCartDecrease);
        updateCartIncrease = view.findViewById(R.id.updateCartIncrease);

        pay = view.findViewById(R.id.pay);


        if (SharedPrefManager.getInstance(getActivity()).isLoggedin()) {
            signup.setVisibility(View.GONE);

        }


        deletemembershipPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // MemberShipDiscount= String.valueOf(response.getData().getPlanDiscount());
                Total = String.valueOf(Integer.valueOf(Total) + Integer.valueOf(MemberShipDiscount));
                tvvaluue.setText(" \u20B9" + Total);
                pay.setText("Pay Now  \u20B9" + Total);
                memebershipstatusLL.setVisibility(View.GONE);
                MemberShipDiscount = " ";
                plan_id = "";


            }
        });
        tvAddMoreServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //    SharedPrefManager.getInstans(getApplicationContext()).clear();
                //SharedPrefManager.getInstans(getContext().getApplicationContext()).pacakgeClear();

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment addonesFragment = new AddonesFragment();
                Bundle args = new Bundle();
                args.putString("id", Id);
                args.putString("Quentiy", quentityTv.getText().toString().trim());

                args.putStringArrayList("arrayList", arrayList);

/*
                arrayList = getArguments().getStringArrayList("arrayList");
                Quentiy = getArguments().getString("Quentiy");*/

                addonesFragment.setArguments(args);
                fragmentTransaction.replace(R.id.fragment_Container, addonesFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        buymember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BuyMemberShipBottomSheet addMoneyWallet_bottomSheet = new BuyMemberShipBottomSheet();
                addMoneyWallet_bottomSheet.show(getActivity().getSupportFragmentManager(), addMoneyWallet_bottomSheet.getTag());
            }
        });
        ivgreens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartnumbertv.setVisibility(View.GONE);
                SharedPrefManager.getInstans(getContext().getApplicationContext()).pacakgeClear();
                SharedPrefManager.getInstans(getContext().getApplicationContext()).AddonseClear();

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment homeFragment = new HomeFragment();
                fragmentTransaction.replace(R.id.fragment_Container, homeFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(getActivity(), LoginActivity.class));
                SharedPrefManager.getInstance(getActivity())
                        .OrderDetails(Id, quentityTv.getText().toString());

                //saveData();

                LoginPage_BottomSheet addMoneyWallet_bottomSheet = new LoginPage_BottomSheet();
                addMoneyWallet_bottomSheet.show(getActivity().getSupportFragmentManager(), addMoneyWallet_bottomSheet.getTag());


            }
        });

        timeslot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              /*  FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment fragment = new TimeSlotFragment();
                Bundle args = new Bundle();
                args.putString("Subcategory", Subcategory);


                // args.putParcelableArrayList("arraylist", addonServices);

                fragment.setArguments(args);

                fragmentTransaction.replace(R.id.fragment_Container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();*/


                alert.showDialog(Subcategory);

            }
        });
        openSlotBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                alert.showDialog(Subcategory);

            }
        });
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //    loadData();


             /*   if (rdwallet.isChecked()) {

                    payment_method = "wallet";
                } else if (rdallet.isChecked()) {
                    payment_method = "cod";
                } else if (rdOnline.isChecked()) {
                    payment_method = "online";

                }*/


                if (serve_time.trim().equalsIgnoreCase("2021-08-24")) {

                    Sneaker.with(getActivity())
                            .setTitle("Select Your  Slot !")
                            .setMessage("")
                            .sneakError();
                } else if (serve_date.trim().equalsIgnoreCase("000")) {

                    Sneaker.with(getActivity())
                            .setTitle("Select Your  Slot !")
                            .setMessage("")
                            .sneakError();
                } else {
                    AppTools.showRequestDialog(getActivity());
                    cartPresenter.CheckMinimumOrderPrice(getContext(), category_id);

                }

                //       Toast.makeText(getContext(), category_id + "", Toast.LENGTH_SHORT).show();


            }
        });
        updateCartIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                removeLL.setVisibility(View.GONE);
                applyLL.setVisibility(View.VISIBLE);
                CouponDiscountAmount = "";
                coupon_id = "";

                et_promo.setText("");

                quantity = Integer.parseInt(quentityTv.getText().toString());
                quantity++;
                quentityTv.setText(String.valueOf(quantity));

                SharedPrefManager.getInstance(getActivity())
                        .PacckageDetails(Id, quentityTv.getText().toString());

                cartRequest = new CartRequest(Id, quentityTv.getText().toString(), addonServices);
                cartPresenter.GetAddonse(getContext(), cartRequest);

                //  finalprice = price + finalprice;
                //tv.setText(String.valueOf(finalprice));


            }
        });
        updateCartDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                removeLL.setVisibility(View.GONE);
                applyLL.setVisibility(View.VISIBLE);
                CouponDiscountAmount = "";
                coupon_id = "";
                et_promo.setText("");

                quantity = Integer.parseInt(quentityTv.getText().toString());

                if (quantity > 1) {
                    quantity--;
                    quentityTv.setText(String.valueOf(quantity));
                    SharedPrefManager.getInstance(getActivity())
                            .PacckageDetails(Id, quentityTv.getText().toString());


                    cartRequest = new CartRequest(Id, quentityTv.getText().toString(), addonServices);
                    cartPresenter.GetAddonse(getContext(), cartRequest);


                    //     finalprice=Integer.parseInt(tv.getText().toString())/quantity;

                }

                   /* quantity--;
                holder.txtQuantity.setText(String.valueOf(quantity));

               */


            }
        });
        memebershipPurchaseDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                showMemberShipDeleteDialog();

            }
        });


    }

    public void showMemberShipDeleteDialog() {

        TextView tvDelete, tvCancel, descTv;
        androidx.appcompat.app.AlertDialog alertDialog;

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.rating_delete_alertbox, null);
        alertDialog = new androidx.appcompat.app.AlertDialog.Builder(getContext())
                .setView(view)
                .setCancelable(false)
                .create();


        ImageView close = view.findViewById(R.id.close);
        tvDelete = view.findViewById(R.id.tvDelete);
        tvCancel = view.findViewById(R.id.tvCancel);
        descTv = view.findViewById(R.id.descTv);
        descTv.setText("Remove This Membership Plan");
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        tvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Total = String.valueOf(Integer.valueOf(Total) - Integer.valueOf(SharedPrefManager.getInstance(getActivity()).getmembership_cost()));
                Total = String.valueOf(Integer.valueOf(Total) + Integer.valueOf(MemberShipDiscount));

                tvvaluue.setText(" \u20B9" + Total);
                pay.setText("Pay Now  \u20B9" + Total);
                memebershipPurchase.setVisibility(View.GONE);
                memebershipstatusLL.setVisibility(View.GONE);
                SharedPrefManager.getInstans(getContext().getApplicationContext()).MembsershipClear();
                MemberShipDiscount = " ";
                plan_id = "";


                alertDialog.dismiss();


            }
        });
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        alertDialog.show();
    }

    @Override
    public void onCartListError(String message) {
        AppTools.hideDialog();
        //Log.e("getLocalizedMessage",t.getLocalizedMessage())
        Sneaker.with(getActivity())
                .setTitle(message)
                .setMessage("")
                .sneakError();
 Toast.makeText(getContext(), message + "", Toast.LENGTH_LONG).show();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCartListSuccess(CartRepo response, String message) {
      /*  Sneaker.with(this)
                .setTitle(message)
                .setMessage("")
                .sneakError();*/
        if (message.equalsIgnoreCase("ok")) {

            addonServices.clear();
            arrayListt.clear();
            arrayList.clear();

            Subcategory = String.valueOf(response.getData().getSubCategory().getId());
            AppTools.hideDialog();
            tvAc.setText(response.getData().getPackage().getName());
            category_id = String.valueOf(response.getData().getPackage().getCategoryId());
            tv.setText(String.valueOf(response.getData().getPackage().getAfterDiscount()));
            price = Integer.parseInt(response.getData().getPackage().getAfterDiscount());
            finalprice = Integer.parseInt(response.getData().getPackage().getAfterDiscount());

            tvdata.setText("\u20B9" + String.valueOf(response.getData().getPackage().getAmount()));
            tvv.setText(String.valueOf(response.getData().getPackage().getDiscount()) + "% OFF");
            SafetyAndHygieneFee = String.valueOf(response.getData().getSafetyAndHygieneFee());
            if (SafetyAndHygieneFee.equalsIgnoreCase("0")) {
                tvrus.setVisibility(View.GONE);
                tvsafty.setVisibility(View.GONE);
            }


            if (response.getData().getPackage().getDiscount().equalsIgnoreCase("0")) {
                tvv.setVisibility(View.GONE);
                fl.setVisibility(View.GONE);
            }


            tvrus.setText("\u20B9" + SafetyAndHygieneFee);

            if (response.getData().getDiscount()<1)
            {
                tvrs.setVisibility(View.GONE);
                tvDiscount.setVisibility(View.GONE);

            }

            tvrs.setText("\u20B9" + response.getData().getDiscount());


            Total = String.valueOf(response.getData().getTotal());

            Totall = String.valueOf(Integer.valueOf(response.getData().getTotal()) - Integer.valueOf(response.getData().getSafetyAndHygieneFee()));
            SubAmount_TV.setText("\u20B9" + Totall);

            tvvaluue.setText(" \u20B9" + Total);
            quentityTv.setText(response.getData().getPackage().getQuantity());
            //  totalavailablebalance.setText("Total Available Bal:  \u20B9" + Total);

            pay.setText("Pay Now  \u20B9" + Total);
            Subtoal = String.valueOf(response.getData().getSubTotal());
            tvsubmoney.setText("\u20B9" + Subtoal);
            discount_amount = String.valueOf(response.getData().getDiscount());
            addonServiceIds = response.getData().getAddonServiceIds();

            Picasso.get().load(AppUrls.BASESubCategoryimagepath + response.getData().getSubCategory().getSubCategoryIcon()).into(imageView);
            quentityTv.setText(response.getData().getPackage().getQuantity());

            if (SharedPrefManager.getInstance(getActivity()).isLoggedin()) {
                buymember.setVisibility(View.VISIBLE);

                signup.setVisibility(View.INVISIBLE);
                timeslot.setVisibility(View.VISIBLE);
                relativelayout.setVisibility(View.VISIBLE);
                pay.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {

                    /*
                     * Showing splash screen with a timer. This will be useful when you
                     * want to show case your app logo / company
                     */

                    @Override
                    public void run() {
                        // This method will be executed once the timer is over
                        // Start your app main activity
                        cartPresenter.MyMembership(getContext());

                    }
                }, 300);

            }


            if (response.getData().getPackageServices().size() > 0) {

                Log.e("ssize", String.valueOf(response.getData().getAddonServices().size()));

                Package_servicesAdapterr package_servicesAdapterr = new Package_servicesAdapterr(response, getContext());
                package_servicesRC.setAdapter(package_servicesAdapterr);
            }


            if (response.getData().getAddonServices().size() > 0) {

                Log.e("ssizessize", String.valueOf(response.getData().getAddonServices().size()));

                cartAdapter = new CartAdapter(response, getContext().getApplicationContext(), this);
                recyclerView.setAdapter(cartAdapter);

                //   cartAdapter.notifyDataSetChanged();


                for (int i = 0; i < response.getData().getAddonServices().size(); i++) {

                    addonService = new CartRequest.AddonService(String.valueOf(response.getData().getAddonServices().get(i).getId()), String.valueOf(response.getData().getAddonServices().get(i).getQuantity()));
                    addonServices.add(addonService);
                    arrayListt.add(String.valueOf(response.getData().getAddonServices().get(i).getId()));
                    arrayList.add(String.valueOf(response.getData().getAddonServices().get(i).getId()));
                    //Log.e("getAddonServicessize",String.valueOf(response.getData().getAddonServices().get(i).getDiscountedAmount()));


                }
                //  Toast.makeText(getContext(), String.valueOf(response.getData().getTotal())+"", Toast.LENGTH_SHORT).show();

                if (SharedPrefManager.getInstance(getActivity()).GetMembershipname() != null) {
                    // Toast.makeText(getActivity(), SharedPrefManager.getInstance(getActivity()).GetMembershipname()+"", Toast.LENGTH_SHORT).show();
                    membership_id = SharedPrefManager.getInstance(getActivity()).getmembership_id();
                    membership_cost = SharedPrefManager.getInstance(getActivity()).getmembership_cost();
                    plan_id = SharedPrefManager.getInstance(getActivity()).getmembership_id();

                    tvvaluue.setText(" \u20B9" + Total);
                    pay.setText("Pay Now  \u20B9" + Total);
                    //Toast.makeText(getActivity(), Id+"", Toast.LENGTH_SHORT).show();
                    arrayList.add(SharedPrefManager.getInstance(getContext()).GetSerivceID());

                    WithoutTokenMemberdeyailsRequest withoutTokenMemberdeyailsRequest = new WithoutTokenMemberdeyailsRequest(membership_id, Totall, arrayList);
                    cartPresenter.WithoutTokenMembershipDetailsRepo(getContext(), withoutTokenMemberdeyailsRequest);
                    deletemembershipPrice.setVisibility(View.GONE);

                    memebershipPurchase.setVisibility(View.VISIBLE);
                    memebershipPurchasename.setText("Membership Plan(" + SharedPrefManager.getInstance(getActivity()).GetMembershipname() + ")");
                    memebershipPurchaseprice.setText(" + \u20B9" + SharedPrefManager.getInstance(getActivity()).getmembership_cost());

                    Total = String.valueOf(Integer.valueOf(Total) + Integer.valueOf(SharedPrefManager.getInstance(getActivity()).getmembership_cost()));
                    //    Toast.makeText(getContext(), Total+"", Toast.LENGTH_SHORT).show();
                }


                if (arrayListt.size() > 0) {
                    String addon_service_Array_Id = String.join(",", arrayListt);

                    SharedPrefManager.getInstance(getActivity())
                            .addon_service_Array_Id(addon_service_Array_Id);
                }


//                response.getData().getAddonServices().clear();


            } else {
                if (SharedPrefManager.getInstance(getActivity()).GetMembershipname() != null) {
                    // Toast.makeText(getActivity(), SharedPrefManager.getInstance(getActivity()).GetMembershipname()+"", Toast.LENGTH_SHORT).show();


                    membership_id = SharedPrefManager.getInstance(getActivity()).getmembership_id();
                    plan_id = SharedPrefManager.getInstance(getActivity()).getmembership_id();

                    membership_cost = SharedPrefManager.getInstance(getActivity()).getmembership_cost();


                    tvvaluue.setText(" \u20B9" + Total);
                    pay.setText("Pay Now  \u20B9" + Total);
                    //Toast.makeText(getActivity(), Id+"", Toast.LENGTH_SHORT).show();
                    arrayList.add(SharedPrefManager.getInstance(getContext()).GetSerivceID());

                    WithoutTokenMemberdeyailsRequest withoutTokenMemberdeyailsRequest = new WithoutTokenMemberdeyailsRequest(membership_id, Totall, arrayList);
                    cartPresenter.WithoutTokenMembershipDetailsRepo(getContext(), withoutTokenMemberdeyailsRequest);
                    deletemembershipPrice.setVisibility(View.GONE);

                    memebershipPurchase.setVisibility(View.VISIBLE);
                    memebershipPurchasename.setText("Membership Plan(" + SharedPrefManager.getInstance(getActivity()).GetMembershipname() + ")");
                    memebershipPurchaseprice.setText(" + \u20B9" + SharedPrefManager.getInstance(getActivity()).getmembership_cost());

                    Total = String.valueOf(Integer.valueOf(Total) + Integer.valueOf(SharedPrefManager.getInstance(getActivity()).getmembership_cost()));
                    //    Toast.makeText(getContext(), Total+"", Toast.LENGTH_SHORT).show();
                }

            }


        }

    }

    @Override
    public void onCheckMinimumOrderPriceSuccess(CheckMinimumOrderPriceRepo response, String message) {
        AppTools.hideDialog();

   /*     Sneaker.with(this)
                .setTitle(message)
                .setMessage("")
                .sneakError();*/

        if (message.equalsIgnoreCase("ok")) {

            if (Integer.valueOf(Totall) >= response.getData()) {
                ///    if (Integer.valueOf(Total) >= 300) {


                SharedPrefManager.getInstance(getActivity())
                        .SetMembershipCost(MemberShipDiscount);
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment fragment = new CheckOutFragment();
                Bundle args = new Bundle();
                args.putString("id", Id);
                //args.putString("payment", payment_method);
                args.putString("Total", Total);
                args.putString("addon_service_ids", addon_service_ids);
                args.putString("SafetyAndHygieneFee", SafetyAndHygieneFee);
                args.putString("pack_quantity", quentityTv.getText().toString());
                args.putString("Subtoal", Subtoal);
                args.putString("CouponDiscountAmount", CouponDiscountAmount);
                args.putString("coupon_id", coupon_id);


                args.putStringArrayList("arrayList", aList);

                args.putString("discount_amount", discount_amount);
                args.putString("serve_time", serve_time);

                args.putString("serve_date", serve_date);

                args.putSerializable("addonServices", addonServices);

                // args.putParcelableArrayList("arraylist", addonServices);

                fragment.setArguments(args);

                fragmentTransaction.replace(R.id.fragment_Container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();



          /*
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment fragment = new TimeSlotFragment();
                Bundle args = new Bundle();
                args.putString("Subcategory", Subcategory);

                args.putString("id", Id);

                args.putString("payment", payment_method);
                args.putString("Total", Total);
                args.putString("addon_service_ids", addon_service_ids);
                args.putString("SafetyAndHygieneFee", SafetyAndHygieneFee);
                args.putString("pack_quantity", quentityTv.getText().toString());
                args.putString("Subtoal", Subtoal);


                args.putString("discount_amount", discount_amount);


                args.putSerializable("addonServices", addonServices);

                // args.putParcelableArrayList("arraylist", addonServices);

                fragment.setArguments(args);

                fragmentTransaction.replace(R.id.fragment_Container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                Log.e("passssssss", Id + "\n" + payment_method + "\n"
                        + Total);
*/
            } else {
                totalavailablebalance.setText("Order can not be accepted less than Rs." + response.getData() + ", Please add some products to your cart.");
                AlertOrderLow("Order can not be accepted less than Rs." + response.getData());

            }


        /*    FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Fragment fragment = new CheckOutFragment();
            fragmentTransaction.replace(R.id.fragment_Container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();*/

        }
    }

    @Override
    public void GetMembershipSuccess(MyMembershipRepo response, String message) {
        if (message.equalsIgnoreCase("ok")) {

            if (response.getData().getMyMembership() != null) {

                if (response.getData().getMyMembership().getActiveTypeStatus().equalsIgnoreCase("Active")) {

                    buymember.setVisibility(View.GONE);

                    // buymember.setVisibility(View.VISIBLE);
                    arrayList.add(SharedPrefManager.getInstance(getContext()).GetSerivceID());
                    Log.e("SharedPrefManager", SharedPrefManager.getInstance(getContext()).GetSerivceID());
                    Log.e("Totall", Totall);
                    Log.e("arrayList", String.valueOf(arrayList.size()));
                    for (int i = 0; i < arrayList.size(); i++) {
                        Log.e("arrarrayLisayList", arrayList.get(i));
                    }


                    WithoutTokenMemberdeyailsRequest withoutTokenMemberdeyailsRequest = new WithoutTokenMemberdeyailsRequest(Totall, arrayList);
                    cartPresenter.CheckMembershipDiscountRepo(getContext(), withoutTokenMemberdeyailsRequest);

                } else {
                    if (SharedPrefManager.getInstance(getActivity()).GetMembershipname() == null) {


                        buymember.setVisibility(View.VISIBLE);
                        BuyMemberShipBottomSheet addMoneyWallet_bottomSheet = new BuyMemberShipBottomSheet();
                        addMoneyWallet_bottomSheet.show(getActivity().getSupportFragmentManager(), addMoneyWallet_bottomSheet.getTag());
                    }
                }
            } else {
                if (SharedPrefManager.getInstance(getActivity()).GetMembershipname() == null) {
                    buymember.setVisibility(View.VISIBLE);

                    BuyMemberShipBottomSheet addMoneyWallet_bottomSheet = new BuyMemberShipBottomSheet();
                    addMoneyWallet_bottomSheet.show(getActivity().getSupportFragmentManager(), addMoneyWallet_bottomSheet.getTag());
                }
            }


            Log.e("dhddddd", response.getData().getMyMembership().getActiveTypeStatus());
            Log.e("dhddddd", String.valueOf(response.getData().getValidity()));


        }

    }

    @Override
    public void TempCartSuccess(ResponseBody response, String message) {
       /* Sneaker.with(getActivity())
                .setTitle(message)
                .setMessage("")
                .sneakError();*/
    }

    @Override
    public void CouponApplySuccess(CouponApplyRepo response, String message) {


        if (message.equalsIgnoreCase("ok")) {
            //   tvsubmoney.setText(" \u20B9" + String. valueOf(Integer.valueOf(Total)));
            Log.e("Couponruyiesponse", response.getData().toString());
            Log.e("Couponresponse", response.toString());
            String tt = Totall;
            Toast.makeText(getActivity(), response.getMessage() + "", Toast.LENGTH_SHORT).show();


            Sneaker.with(getActivity())
                    .setTitle(response.getMessage())
                    .setMessage("")
                    .sneakSuccess();

            removeLL.setVisibility(View.VISIBLE);
            applyLL.setVisibility(View.GONE);
            CouponDiscountAmount = String.valueOf(response.getData().getCouponDiscounted());
            coupon_id = String.valueOf(response.getData().getCouponId());

            Total = String.valueOf(Integer.valueOf(Total) - Integer.valueOf(CouponDiscountAmount));


            //  tvvaluue.setText("( \u20B9" + CouponDiscountAmount + " Coupon OFF FROM \u20B9 " + tt + ")" + " \u20B9" + Total);

            tvvaluue.setText("( \u20B9" + CouponDiscountAmount + " Coupon Discount on \u20B9 " + tt + ")" + " \u20B9" + Total);
            pay.setText("Pay Now  \u20B9" + Total);


        }


    }

    @Override
    public void CheckMembershipDiscountDetailSucess(CheckMembershipDiscountRepo response, String message) {


        if (message.equalsIgnoreCase("ok")) {
            //   tvsubmoney.setText(" \u20B9" + String.valueOf(Integer.valueOf(Total)));

            if (response.getData().getPlanDiscount() > 0) {

                memebershipPurchase.setVisibility(View.GONE);
                memebershipstatusLL.setVisibility(View.VISIBLE);

                deletemembershipPrice.setVisibility(View.VISIBLE);
                Total = String.valueOf(Integer.valueOf(Total) - response.getData().getPlanDiscount());

                memebershipstatus.setText(" ₹" + response.getData().getPlanDiscount());

                descMemberTv.setText("Membership Discount (From ₹" + Totall + ")");
                MemberShipDiscount = String.valueOf(response.getData().getPlanDiscount());
                //plan_id=String.valueOf(response.getData().getUserMembership().getId());

                tvvaluue.setText(" \u20B9" + Total);

                pay.setText("Pay Now  \u20B9" + Total);
                memebershipstatusLL.setVisibility(View.VISIBLE);
            } else {

            }


        }
    }

    @Override
    public void WithoutTokenMembershipDetailSucess(WithoutTokenMembershipDetailsRepo response, String message) {

        //Toast.makeText(getActivity(), message+"", Toast.LENGTH_SHORT).show();
     /*    Sneaker.with(getActivity())
                .setTitle(String.valueOf(response.getData().getPlanDiscount()))
                .setMessage("")
                .sneakError();*/
        if (message.equalsIgnoreCase("ok")) {
            //   tvsubmoney.setText(" \u20B9" + String.valueOf(Integer.valueOf(Total)));

            Total = String.valueOf(Integer.valueOf(Total) - response.getData().getPlanDiscount());

            memebershipstatus.setText(" ₹" + response.getData().getPlanDiscount());

            descMemberTv.setText("Membership Discount (From ₹" + Totall + ")");
            MemberShipDiscount = String.valueOf(response.getData().getPlanDiscount());


            tvvaluue.setText(" \u20B9" + Total);

            pay.setText("Pay Now  \u20B9" + Total);
            memebershipstatusLL.setVisibility(View.VISIBLE);


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
    public void onCartListFailure(Throwable t) {
        Log.e("getLocalizedMessage", t.getLocalizedMessage());
        AppTools.hideDialog();
        Sneaker.with(getActivity())
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();
    }


    public void AlertOrderLow(String title) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder//.setIcon(R.drawable.logo_black)
                .setTitle(title)
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });

        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public void IncreaseQuentity(String Quentity, int position, CartRepo cartRepo) {

        removeLL.setVisibility(View.GONE);
        applyLL.setVisibility(View.VISIBLE);
        CouponDiscountAmount = "";
        coupon_id = "";
        et_promo.setText("");

        Log.e("getAddonServicessize", String.valueOf(addonServices.size()));

        for (int i = 0; i < addonServices.size(); i++) {

            if (addonServices.get(i).serviceId.equalsIgnoreCase(String.valueOf(cartRepo.getData().getAddonServices().get(position).getId()))) {

                //  addonServices.remove(i);

                //
                Log.e("sizeLow", String.valueOf(addonServices.size()));


                //addonServices.add(addonService = new CartRequest.AddonService(String.valueOf(cartRepo.getData().getAddonServices().get(position).getId()), Quentity));


//                list.set(index, "C_NEW");
                addonServices.set(i, new CartRequest.AddonService(String.valueOf(cartRepo.getData().getAddonServices().get(position).getId()), Quentity));


                Log.e("sizehigh", String.valueOf(addonServices.size()));


            }
        }
        cartRequest = new CartRequest(Id, quentityTv.getText().toString(), addonServices);

        cartPresenter.GetAddonse(getContext(), cartRequest);


    }

    @Override
    public void DecressQuentity(String Quentity, int position, CartRepo cartRepo) {


        removeLL.setVisibility(View.GONE);
        applyLL.setVisibility(View.VISIBLE);
        CouponDiscountAmount = "";
        coupon_id = "";
        et_promo.setText("");

        for (int i = 0; i < addonServices.size(); i++) {
            if (addonServices.get(i).serviceId.equalsIgnoreCase(String.valueOf(cartRepo.getData().getAddonServices().get(position).getId()))) {
                addonServices.remove(i);
                Log.e("sizeLow", String.valueOf(addonServices.size()));
                addonServices.add(addonService = new CartRequest.AddonService(String.valueOf(cartRepo.getData().getAddonServices().get(position).getId()), Quentity));
                Log.e("sizehigh", String.valueOf(addonServices.size()));

            }


        }
        cartRequest = new CartRequest(Id, quentityTv.getText().toString(), addonServices);
        cartPresenter.GetAddonse(getContext(), cartRequest);

    }

    @Override
    public void DeleteAddonse(String Quentity, int position, CartRepo cartRepo) {


        for (int i = 0; i < addonServices.size(); i++) {
            if (addonServices.get(i).serviceId.equalsIgnoreCase(String.valueOf(cartRepo.getData().getAddonServices().get(position).getId()))) {

                addonServices.remove(i);

                //    Toast.makeText(getContext(), String.valueOf(cartRepo.getData().getAddonServices().get(position).getName()) + "", Toast.LENGTH_SHORT).show();
                //Toast.makeText(getContext(),String.valueOf(cartRepo.getData().getAddonServices().get(position).getId())+"", Toast.LENGTH_SHORT).show();

                if (addonServices.size() == 0) {

                    recyclerView.setVisibility(View.GONE);
                    addonServices.clear();
                    SharedPrefManager.getInstans(getContext().getApplicationContext()).AddonseClear();
                    cartRequest = new CartRequest(Id, quentityTv.getText().toString(), addonServices);
                    cartPresenter.GetAddonse(getContext(), cartRequest);
                } else {

                    cartRequest = new CartRequest(Id, quentityTv.getText().toString(), addonServices);
                    cartPresenter.GetAddonse(getContext(), cartRequest);
                }


            }


        }

    }


    @Override
    public void onResume() {
        super.onResume();
    }


    public class ViewDialog implements TimeSlotPresenter.TimeSlotView, DatelistslotAdapterr.DateClick, timelistslotAdapterr.CustomizedClick {


        Dialog dialog;

        RecyclerView dateRV, timeRV;
        TimeSlotPresenter presenter;

        ArrayList<CreateOrderRequest.AddonService> addonServices;

        CardView btn_moreDetails;
        ImageView exit;
        String time, date, Showdate;


        public void showDialog(String id) {
            dialog = new Dialog(getContext());
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.fragment_time_slot);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            WindowManager.LayoutParams wmlp = dialog.getWindow().getAttributes();
//            wmlp.x = 30;   //x position
            wmlp.y = 300;   //y position

            wmlp.gravity = Gravity.TOP;
            findViewById(dialog, id);

            dialog.show();
        }


        private void findViewById(Dialog view, String id) {
            extras = getArguments();
          //  Toast.makeText(getContext(), id+"", Toast.LENGTH_SHORT).show();

          /*  if (extras != null) {

                Subcategory = getArguments().getString("Subcategory");

         *//*   package_id = getArguments().getString("id");
            payment_method = getArguments().getString("payment");
            total_amount = getArguments().getString("Total");

            addon_service_ids = getArguments().getString("addon_service_ids");
            SafetyAndHygieneFee = getArguments().getString("SafetyAndHygieneFee");
            pack_quantity = getArguments().getString("pack_quantity");
            Subtoal = getArguments().getString("Subtoal");
            discount_amount = getArguments().getString("discount_amount");
            addonServices = (ArrayList<CreateOrderRequest.AddonService>) getArguments().getSerializable("addonServices");
*//*
             *//*

            Log.e("addonServices", package_id + "\n" + payment_method + "\n"
                    + total_amount + "\n" + addon_service_ids + "\n"
                    + SafetyAndHygieneFee + "\n" + addonServices.size());

*//*

                // Toast.makeText(getContext(), Subcategory+"", Toast.LENGTH_SHORT).show();
            }*/


            dateRV = view.findViewById(R.id.dateRV);
            LinearLayoutManager linearLayoutManager2 = (new LinearLayoutManager(getContext().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
            dateRV.setLayoutManager(linearLayoutManager2);
            dateRV.setHasFixedSize(true);
            btn_moreDetails = view.findViewById(R.id.btn_moreDetails);
            exit = view.findViewById(R.id.exit);
            timeRV = view.findViewById(R.id.timeRV);
            LinearLayoutManager linearLayoutManager3 = (new LinearLayoutManager(getContext().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
            timeRV.setLayoutManager(linearLayoutManager3);
            timeRV.setHasFixedSize(true);
            presenter = new TimeSlotPresenter(this);

            presenter.DateSlotRepo(getContext(), id);
            // presenter.TimeSlotRepo(getContext(),"1","2021-08-24");


            exit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            btn_moreDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    slottimeLL.setVisibility(View.VISIBLE);
                    timeslot.setVisibility(View.GONE);
                    serve_time = time;
                    serve_date = date;
                    dateSlot.setText("Date: " + Showdate);
                    String _24HourTime = serve_time;
                    SimpleDateFormat _24HourSDF = new SimpleDateFormat("HH:mm");
                    SimpleDateFormat _12HourSDF = new SimpleDateFormat("hh:mm a");
                    try {
                        Date _24HourDt = _24HourSDF.parse(_24HourTime);
                        timeslott.setText("Timing: " + _12HourSDF.format(_24HourDt));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }


                    //   timeslott.setText("Timing: " + serve_time);

                  /*  FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    Fragment fragment = new AppliencesCareServicesFragment();
                    Bundle args = new Bundle();
                    args.putString("serve_time", serve_time);
                    args.putString("serve_date", serve_date);


                    // args.putParcelableArrayList("arraylist", addonServices);

                    fragment.setArguments(args);

                    fragmentTransaction.replace(R.id.fragment_Container, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();

*/
                }
            });


        }


        @Override
        public void onDateSlotRepoError(String message) {
            Sneaker.with(getActivity())
                    .setTitle(message)
                    .setMessage("")
                    .sneakError();
        }

        @Override
        public void onDateSlotRepoSuccess(DateSlotRepo response, String message) {

            if (message.equalsIgnoreCase("ok")) {
                if (response.getData().getSlotDates().size() > 0) {
                    DatelistslotAdapterr datelistslotAdapterr = new DatelistslotAdapterr(response, getContext(), this);
                    dateRV.setAdapter(datelistslotAdapterr);
                    presenter.TimeSlotRepo(getContext(), Subcategory, String.valueOf(response.getData().getTodayDate()));/*"2022-01-27"*//* response.getData().getTodayDate()*//*);*/

                    // serve_date = response.getData().getTodayDate();
                } else {

                    btn_moreDetails.setVisibility(View.GONE);
                    dialog.dismiss();

                    Sneaker.with(getActivity())
                            .setTitle("No any slots available for this date, please try after some time")
                            .setMessage("")
                            .sneakWarning();
                }
            }
      /*  Sneaker.with(getActivity())
                .setTitle(message)
                .setMessage("")
                .sneakError();
*/

        }

        @Override
        public void onTimeSlotRepoSuccess(ServetimeSlotRepo response, String message) {
            if (message.equalsIgnoreCase("ok")) {
                arrayList.clear();
                if (response.getData().getSlots().size() > 0) {
                    for (int i = 0; i < response.getData().getSlots().size(); i++) {
                        if (response.getData().getSlots().get(i).getBookedStatus() == true) {
                            arrayList.add(response.getData().getSlots().get(i).getTime());
                        }
                    }
                    if (arrayList.size() > 0) {
                        timeRV.setVisibility(View.VISIBLE);

                        timelistslotAdapterr t = new timelistslotAdapterr(arrayList, getContext(), this);
                        timeRV.setAdapter(t);
                    } else {
                        timeRV.setVisibility(View.GONE);
                    }



/*
                DatelistslotAdapterr datelistslotAdapterr=new DatelistslotAdapterr(response,getContext(),this);
                dateRV.setAdapter(datelistslotAdapterr);*/
                } else {
                    timeRV.setVisibility(View.GONE);
                }
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
        public void onDateSlotRepoFailure(Throwable t) {
            Sneaker.with(getActivity())
                    .setTitle(t.getLocalizedMessage())
                    .setMessage("")
                    .sneakError();
        }

        @Override
        public void CustomizeddateClickk(DateSlotRepo repo, int pos) {
            presenter.TimeSlotRepo(getContext(), Subcategory, String.valueOf(repo.getData().getSlotDates().get(pos).getValue()));

            date = String.valueOf(repo.getData().getSlotDates().get(pos).getValue());
            Showdate = String.valueOf(repo.getData().getSlotDates().get(pos).getDate());
            Log.e("datedate", date);


        }

        @Override
        public void CustomizedTimeClickk(String repo, int pos) {
            // Toast.makeText(getContext(), pos + "", Toast.LENGTH_SHORT).show();


            time = repo;


        }
    }


    private String setDateTimeValues(String date) {

        Log.e("serve_dateserve_dafffte", date);

        try {
            String pattern = "dd-MM-yyyy HH:mm a";
            DateFormat df = new SimpleDateFormat(pattern);
            Date myDate = df.parse(date);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
            //   setLog("MyNewDate", date + "  " + formatter.format(myDate));
            return formatter.format(myDate).toUpperCase();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

   /* public void onStart() {


        super.onStart();
        //update your fragment
    }*/
}