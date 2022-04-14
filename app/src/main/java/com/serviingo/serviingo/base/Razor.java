/*
package com.serviingo.serviingo.base;

public class orderFragment extends BaseFragment {
    public static ScrollView scrollView;
    ImageView imageView;
    View rootView;
    RecyclerView recyclerView;
    OfferAdapter offerAdapter;
    EditText et_searchView;
    LinearLayoutManager layoutManager;
    TextView changePassword, tvtrackOrder;
    RelativeLayout tvMyorder;
    LinearLayout tvManagePriscription, llmyPrescriptionsOrder, llsearchButton,
            llmanageAddress, llwallet, llSavedCards, llMyStuff, llMyCoupons,
            llMyRatings, llAllNotifications, llMyWishList,
            llLogout, llProfileInformations, llmyPrescriptions, accountsettings, tvpayments;
    Preferences pref;
    Spinner spYear;
    String strJobId = "";
    ArrayList<HashMap<String, String>> orderArraylist = new ArrayList<>();
    ArrayList<HashMap<String, String>> yeararraylist = new ArrayList<>();
    ArrayList<HashMap<String, String>> arrayTrans = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.order_activity, container, false);
        findViewById();
        return rootView;
    }

    private void findViewById() {
        Checkout.preload(mActivity);

    }


    //checkPayment mode COD
    public void postPaymentModeCOD(String invoicNumber, String PaymentMode, String orderStatus) {
        //invoice
        AppUtils.showRequestDialog(mActivity);
        String url = AppUrls.PostCODInvoice + invoicNumber;
        String token = pref.get("token");
        Log.v("ddurl", token);

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("payment_mode", PaymentMode);
        hashMap.put("order_status ", orderStatus);
        setLog("MyHashSample", hashMap + " good");

        AndroidNetworking.post(url)
                .addBodyParameter(hashMap)
                .setPriority(Priority.HIGH)
                .addHeaders("Authorization", "Bearer " + token)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        AppUtils.hideDialog();
                        parseCODInvoiceResponse(response);
                    }

                    @Override
                    public void onError(ANError error) {
                        AppUtils.hideDialog();
                        Log.v("data", error.getErrorBody());
                        Log.v("data", error.getErrorDetail());
                    }
                });
    }

    private void parseCODInvoiceResponse(JSONObject response) {
        try {
            Log.v("rescategoryApiCheck", "empty " + response);
            if (response.getString("success").equals("true")) {
                Log.v("codInvoiceCheck", response.getString("success"));
            }
        } catch (Exception e) {
            Log.v("error", String.valueOf(e));
        }

    }

//checkPayment mode COD

    //Offer Detail
    public class OfferAdapter extends RecyclerView.Adapter<OfferHolder> {
        ArrayList<HashMap<String, String>> data = new ArrayList();


        public OfferAdapter(ArrayList<HashMap<String, String>> favList) {
            data = favList;
        }

        @Override
        public OfferHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.inflate_order, parent, false);
            return new OfferHolder(itemView);
        }

        public void onBindViewHolder(OfferHolder holder, final int position) {
            holder.relativeLayout.setVisibility(View.GONE);
           */
/* holder.tvPay.setVisibility(View.GONE);
            holder.tvPlaced.setVisibility(View.VISIBLE);*//*

            holder.date.setText(data.get(position).get("created_at"));
            holder.tvdetailbutton.setText(data.get(position).get("order_status"));
            holder.tvPlaced.setText(data.get(position).get("payment_status"));
            holder.tvUserName.setText("New User");
            */
/*if (data.get(position).get("final_amount") == null) {
                holder.tvRupees.setText(" ");
                holder.tvrs.setText(" ");
            } else {*//*

            holder.tvRupees.setText("RS. " + data.get(position).get("final_amount"));
            holder.tvrs.setText("RS. " + data.get(position).get("final_amount"));
            /}/
          */
/*  if (data.get(position).get("invoice_number") == null) {
                holder.tvorder.setText("ORDER ");
            } else {*//*

                holder.tvorder.setText("ORDER  #"+data.get(position).

        get("invoice_number"));
            /
    }/
            holder.docName.setText("Your Remark is : "+pref.get("ReMark"));

        Picasso.get().

    load(AppUrls.baseImagePath +data.get(position).

    get("prescription")).

    placeholder(R.drawable.no_image_available).

    into(holder.ivView);
        holder.tvViewPrescription.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View v){

    }
    });
        if(data.get(position).

    get("order_status").

    equalsIgnoreCase("processing"))

    {
    } else if(data.get(position).

    get("order_status").

    equalsIgnoreCase("pending"))

    {
    } else

    {
        holder.relativeLayout.setVisibility(View.VISIBLE);
        holder.LeftButton.setText("Confirm Order");
        if (pref.get("moveToOrder").equalsIgnoreCase("true")) {
            holder.cancelOrder.setVisibility(View.GONE);
        } else {
            holder.cancelOrder.setVisibility(View.VISIBLE);
            holder.cancelOrder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    postCancelOrder(data.get(position).get("invoice_number"));
                }
            });
            pref.get("moveToOrder").equalsIgnoreCase("false");

        }
    }
        if(data.get(position).

    get("payment_mode").

    equalsIgnoreCase("cod"))

    {
        //run cod condition
        postPaymentModeCOD(data.get(position).get("invoice_number"), data.get(position).get("payment_mode"), data.get(position).get("order_status"));
    }

        holder.LeftButton.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View v){
        try {
            String invoice = data.get(position).get("invoice_number");
            float amount = Float.parseFloat(data.get(position).get("final_amount"));
            startPayment(amount);
        } catch (NumberFormatException ex) { // handle your exception
            Toast.makeText(mActivity, "" + ex, Toast.LENGTH_SHORT).show();
        }
    }
    });

    getOrderInvoice(data.get(position).

    get("invoice_number"));
}

    public int getItemCount() {
        return data.size();
    }
}

private class OfferHolder extends RecyclerView.ViewHolder {
    ImageView ivView;
    RelativeLayout relativeLayout;
    TextView tvRupees, docName, tvorder;
    TextView date, LeftButton, cancelOrder;
    TextView tvUserName, tvViewPrescription;
    TextView tvdetailbutton, tvPlaced, tvrs;

    public OfferHolder(View itemView) {
        super(itemView);
        tvRupees = itemView.findViewById(R.id.tvRupees);
        ivView = itemView.findViewById(R.id.ivView);
        docName = itemView.findViewById(R.id.docName);
        relativeLayout = itemView.findViewById(R.id.relativeLayout);
        cancelOrder = itemView.findViewById(R.id.cancelOrder);
        LeftButton = itemView.findViewById(R.id.LeftButton);
        date = itemView.findViewById(R.id.date);

        tvorder = itemView.findViewById(R.id.tvorder);
        tvrs = itemView.findViewById(R.id.tvrs);
        tvUserName = itemView.findViewById(R.id.tvUserName);
        tvdetailbutton = itemView.findViewById(R.id.tvdetailbutton);
        tvViewPrescription = itemView.findViewById(R.id.tvViewPrescription);
        tvPlaced = itemView.findViewById(R.id.tvPlaced);
    }

}


    public void startPayment(float finalAmount) {
        */
/*
          You need to pass Checkout.preload in oncreate() in order to let Razorpay create CheckoutActivity
          and also declare ApiKey in manifest
         *//*

        final Checkout co = new Checkout();
        try {
            JSONObject options = new JSONObject();
            options.put("name", R.string.app_name);
            options.put("description", "Your payable Amount");
            //You can omit the image option to fetch the image from dashboard
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
            options.put("currency", "INR");
            options.put("amount", 100 * finalAmount);
            JSONObject preFill = new JSONObject();
            preFill.put("email", "imran@webmingo.in");
            preFill.put("contact", "9170839181");
            options.put("prefill", preFill);
            co.open(mActivity, options);
        } catch (Exception e) {
            showToast(mActivity, "Error in payment: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void onPaymentSuccess(String razorPaymentId) {
        try {
            showToast(mActivity, "Payment Successful");
            //  save_course_purchase_user_recordApi(razorPaymentId);
            postPaymentModeOnLine(razorPaymentId, "String invoicNumber", "", "String orderStatus");
        } catch (Exception e) {
            Log.e("razorPayment", "Exception in onPaymentSuccess", e);
        }

    }

    public void postPaymentModeOnLine(String razorPaymentId, String invoicNumber, String PaymentMode, String orderStatus) {
        //invoice
        AppUtils.showRequestDialog(mActivity);
        String url = "http://themetoaster.co.in/kkmedical/api/confirm-order-prescription";
        String token = pref.get("token");
        Log.v("ddurl", token);


        AndroidNetworking.post(url)
                .addBodyParameter(hashMap)
                .setPriority(Priority.HIGH)
                .addHeaders("Authorization", "Bearer " + token)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        AppUtils.hideDialog();
                        parsePaymentModeOnLineResponse(response);
                    }

                    @Override
                    public void onError(ANError error) {
                        AppUtils.hideDialog();
                        Log.v("data", error.getErrorBody());
                        Log.v("data", error.getErrorDetail());
                    }
                });
    }

    private void parsePaymentModeOnLineResponse(JSONObject response) {
        try {
            Log.v("rescategoryApiCheck", "empty " + response);
            if (response.getString("success").equals("true")) {
                Log.v("codInvoiceCheck", response.getString("success"));

            }

        } catch (Exception e) {
            Log.v("error", String.valueOf(e));
        }

    }


    */
/**
     * The name of the function has to be
     * onPaymentError
     * Wrap your code in try catch, as shown, to ensure that this method runs correctly
     *//*

    @SuppressWarnings("unused")
    @Override
    public void onPaymentError(int code, String response) {
        try {
            showToast(mActivity, "Payment failed: " + response);
            Log.e("razorPayment", "Payment failed: " + code + " " + response);
//            save_course_purchase_user_recordApi("test");

            postPaymentModeOnLineFailed("", "");
        } catch (Exception e) {
            Log.e("razorPayment", "Exception in onPaymentError", e);
        }
    }

    public void postPaymentModeOnLineFailed(String razorPaymentId, String invoicNumber) {
        //invoice
        AppUtils.showRequestDialog(mActivity);
        String url = "http://themetoaster.co.in/kkmedical/api/failed-order-prescription";
        String token = pref.get("token");
        Log.v("ddurl", token);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("invoicenumber", invoicNumber);
        hashMap.put("razorpay_order_id ", razorPaymentId);
        setLog("MyHashSample", hashMap + " good");

        AndroidNetworking.post(url)
                .addBodyParameter(hashMap)
                .setPriority(Priority.HIGH)
                .addHeaders("Authorization", "Bearer " + token)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        AppUtils.hideDialog();
                        parsePaymentModeOnLineFailResponse(response);
                    }

                    @Override
                    public void onError(ANError error) {
                        AppUtils.hideDialog();
                        Log.v("data", error.getErrorBody());
                        Log.v("data", error.getErrorDetail());
                    }
                });
    }

    private void parsePaymentModeOnLineFailResponse(JSONObject response) {
        try {
            Log.v("rescategoryApiCheck", "empty " + response);
            if (response.getString("success").equals("true")) {
                Log.v("codInvoiceCheck", response.getString("success"));

            }

        } catch (Exception e) {
            Log.v("error", String.valueOf(e));
        }

    }

}



*/
