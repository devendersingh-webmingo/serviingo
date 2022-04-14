package com.serviingo.serviingo.Activity.RazorPay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.irozon.sneaker.Sneaker;
import com.razorpay.Checkout;
import com.razorpay.PaymentData;
import com.razorpay.PaymentResultWithDataListener;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.Activity.HomeActivity;
import com.serviingo.serviingo.Fragments.AppliencesCareServicesFragment;
import com.serviingo.serviingo.Fragments.CheckOutFragment;
import com.serviingo.serviingo.Fragments.MyWalletFragment;
import com.serviingo.serviingo.Fragments.RecentBookingFragment;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.ViewPresenter.TempCart.RazorPayPresenterr;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.BuyMembershipRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Razorpay.AddWalletRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Razorpay.Razor_OrderidRepo;
import com.serviingo.serviingo.modelrepo.request.PaymentSignatureVerifyReq;
import com.serviingo.serviingo.modelrepo.request.PaymentSignatureVerifyWalletReq;
import com.serviingo.serviingo.modelrepo.request.RetryPaymentRequest;
import com.serviingo.serviingo.storage.SharedPrefManager;

import org.json.JSONObject;

import okhttp3.ResponseBody;

import static com.serviingo.serviingo.R.drawable.globalloader;

public class RazorPaymentActivity extends AppCompatActivity implements PaymentResultWithDataListener, RazorPayPresenterr.RazorPayPresenterrView {
    RazorPayPresenterr razorPayPresenterr;

    String ApiKey, order_id, order_number, total_amount, payment_mode = "check", membership_id;
    Intent intent;
    SuccessViewDialog successViewDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_razor_payment);
        Checkout.preload(RazorPaymentActivity.this);

        razorPayPresenterr = new RazorPayPresenterr(this);
        intent = getIntent();
        successViewDialog = new SuccessViewDialog();

        if (intent != null) {
            order_id = intent.getStringExtra("order_id");

            if (order_id.equalsIgnoreCase("1")) {

                payment_mode = intent.getStringExtra("payment_mode");

                if (payment_mode.equalsIgnoreCase("AddmoneyWallet")) {
                    ApiKey = intent.getStringExtra("ApiKey");
                    total_amount = intent.getStringExtra("total_amount");
                    razorPayPresenterr.GetRazorWalletPayKey(this, total_amount);

                } else if (payment_mode.equalsIgnoreCase("BuyMembership")) {
                    membership_id = intent.getStringExtra("membership_id");
                    ApiKey = intent.getStringExtra("ApiKey");
                    total_amount = intent.getStringExtra("total_amount");
                    razorPayPresenterr.GetRazorWalletPayKey(this, total_amount);

                }


            } else {

              /*  if (intent.getStringExtra("OrderNumber").equalsIgnoreCase("RetryPayment"))
                {
                    Toast.makeText(this, "RetryPayment", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "new Order", Toast.LENGTH_SHORT).show();

                }*/

                ApiKey = intent.getStringExtra("ApiKey");
                order_number = intent.getStringExtra("OrderNumber");
                total_amount = intent.getStringExtra("total_amount");
                razorPayPresenterr.GetRazorPayKey(this, order_id);

                Log.e("orderrr is", order_id);

            }

            ///  Toast.makeText(this, total_amount + "", Toast.LENGTH_SHORT).show();

        }


    }


    public void startPayment(String ApiKey, String Razorpayorder_id, String total_amount) {
        int amount = Integer.valueOf(total_amount) * 100;

        Checkout checkout = new Checkout();
        checkout.setKeyID(ApiKey);

        checkout.setImage(R.mipmap.rzp);
        //final Activity activity = this;


        /**
         * Pass your payment options to the Razorpay Checkout as a JSONObject
         */
        try {
            JSONObject options = new JSONObject();
            // options.put("order_id", order_id);
            options.put("name", SharedPrefManager.getInstans(this).getfullname());
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
            options.put("order_id", Razorpayorder_id);//from response of step 3.
            options.put("currency", "INR");
            options.put("amount", amount);//pass amount in currency subunits
            options.put("prefill.email", SharedPrefManager.getInstans(this).getemail());
            options.put("prefill.contact", SharedPrefManager.getInstans(this).getNumber());
            checkout.open(RazorPaymentActivity.this, options);
        } catch (Exception e) {
            Log.e("TAG", "Error in starting Razorpay Checkout", e);
        }
    }

    @Override
    public void onPaymentSuccess(String s, PaymentData paymentData) {
        // orderID = paymentData.getOrderId();
        String Payment_id = paymentData.getPaymentId();
        // status ="Success";

        if (paymentData != null) {


            if (order_id.equalsIgnoreCase("1")) {


                if (payment_mode.equalsIgnoreCase("BuyMembership")) {
                    razorPayPresenterr.BuyMembershipPlan(this, membership_id, paymentData.getOrderId(), paymentData.getPaymentId(), paymentData.getSignature());

                } else if (payment_mode.equalsIgnoreCase("AddmoneyWallet")) {
                    PaymentSignatureVerifyWalletReq paymentSignatureVerifyReq = new PaymentSignatureVerifyWalletReq(total_amount, paymentData.getPaymentId(), paymentData.getOrderId(), paymentData.getSignature(), "razorpay");
                    razorPayPresenterr.PaymentSignatureVerifyWalletReq(this, paymentSignatureVerifyReq);

                }

            } else {

                if (order_number.equalsIgnoreCase("RetryPayment")) {
                    RetryPaymentRequest retryPaymentRequest = new RetryPaymentRequest(order_id, "online", SharedPrefManager.getInstance(this).getSlotDate(), SharedPrefManager.getInstance(this).getSlotTime(), paymentData.getPaymentId(), paymentData.getOrderId(), paymentData.getSignature());
                    razorPayPresenterr.RetryPaymentReq(this, retryPaymentRequest);

                } else {
                    PaymentSignatureVerifyReq paymentSignatureVerifyReq = new PaymentSignatureVerifyReq(order_id, paymentData.getPaymentId(), paymentData.getOrderId(), paymentData.getSignature());
                    razorPayPresenterr.PaymentSignatureVerifyReq(this, paymentSignatureVerifyReq);

                }


            }

            Log.e("Payment data", String.valueOf(paymentData));
            Log.e("getPaymentId", String.valueOf(paymentData.getPaymentId()));
            Log.e("getOrderId", String.valueOf(paymentData.getOrderId()));
            Log.e("getSignature", String.valueOf(paymentData.getSignature()));


          /*  SaveBody saveBody = new SaveBody(Amount,orderID,status,Payment_id);
            presenter.savePaymentData(saveBody,context);*/
        }
    }

    @Override
    public void onPaymentError(int i, String s, PaymentData paymentData) {
        ///  Toast.makeText(this, "onPaymentError", Toast.LENGTH_SHORT).show();

        if (order_id.equalsIgnoreCase("1")) {
            PaymentSignatureVerifyWalletReq paymentSignatureVerifyReq = new PaymentSignatureVerifyWalletReq(total_amount, null, null, null, "wallet");
            razorPayPresenterr.PaymentSignatureVerifyWalletReq(this, paymentSignatureVerifyReq);

        } else {


            SharedPrefManager.getInstans(RazorPaymentActivity.this).pacakgeClear();
            SharedPrefManager.getInstans(RazorPaymentActivity.this).AddonseClear();
            Intent intent = new Intent(RazorPaymentActivity.this, HomeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);


            //razorPayPresenterr.PaymentFailed(this, order_id);


        }
        Log.e("tagtagtag", s);
    }


    @Override
    public void CreateOrderError(String message) {
        Sneaker.with(this)
                .setTitle(message)
                .setMessage("")
                .sneakError();
    }

    @Override
    public void CreateOrderWalletError(String message) {
        if (message.equalsIgnoreCase("401")) {
           /* Sneaker.with(this)
                    .setTitle("Something happned wrong, amount not added in wallet.")
                    .setMessage("")
                    .sneakError();*/

            Toast.makeText(this, "Something happned wrong, amount not added in wallet.", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(RazorPaymentActivity.this, HomeActivity.class);
            intent.putExtra("OrderNumber", "1");

            startActivity(intent);
            finish();

        }


    }

    @Override
    public void showHideProgress(boolean isShow) {

        if (isShow) {
            AppTools.showRequestDialog(this);


        } else {
            AppTools.hideDialog();

        }

    }

    @Override
    public void PaymentSignatureVerifyReqSuccess(ResponseBody response, String message) {
        if (message.equalsIgnoreCase("ok")) {
            successViewDialog.showDialog(this, order_number);

        }

    }

    @Override
    public void RetryPaymentReqSuccess(ResponseBody response, String message) {
        if (message.equalsIgnoreCase("ok")) {
            Intent intent = new Intent(RazorPaymentActivity.this, HomeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }


    }

    @Override
    public void PaymentSignatureVerifyReqWalletSuccess(ResponseBody response, String message) {
        if (message.equalsIgnoreCase("ok")) {
/*
            getSupportFragmentManager().beginTransaction()
                    .addToBackStack("MyWalletFragment")
                    .replace(R.id.fragment_Container, new MyWalletFragment(), "MyWalletFragment")
                    .commit();*/


            Intent intent = new Intent(RazorPaymentActivity.this, HomeActivity.class);
            intent.putExtra("OrderNumber", "1");
            intent.putExtra("payment_mode", "AddmoneyWallet");
            startActivity(intent);
            finish();

         /*   Fragment myFragment = new MyWalletFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.youLayout, myFragment,
                    fragmentTransaction.addToBackStack("youfragment")
            fragmentTransaction.commit();*/
        }
     /*   Sneaker.with(this)
                .setTitle(message)
                .setMessage("")
                .sneakError();*/
    }

    @Override
    public void razorpay_order_idSuccess(Razor_OrderidRepo response, String message) {

        if (message.equalsIgnoreCase("ok")) {

            startPayment(ApiKey, response.getData().getRazorpayOrderId(), total_amount);


        }
    }

    @Override
    public void razorpay_Wallet_idSuccess(AddWalletRepo response, String message) {

        if (message.equalsIgnoreCase("ok")) {

            startPayment(ApiKey, response.getData().getRazorpayOrderId(), total_amount);


        }

    }

    @Override
    public void PaymentFailedSuccess(ResponseBody response, String message) {
        if (message.equalsIgnoreCase("ok")) {
            SharedPrefManager.getInstans(RazorPaymentActivity.this).pacakgeClear();
            SharedPrefManager.getInstans(RazorPaymentActivity.this).AddonseClear();

            Intent intent = new Intent(RazorPaymentActivity.this, HomeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);

        }

    }

    @Override
    public void BuyMembershipPlanSuccess(BuyMembershipRepo response, String message) {


        if (message.equalsIgnoreCase("ok")) {
            Intent intent = new Intent(RazorPaymentActivity.this, HomeActivity.class);
            intent.putExtra("OrderNumber", "1");
            intent.putExtra("payment_mode", "BuyMembership");
            startActivity(intent);
            finish();
        }


    }

    @Override
    public void CreateOrderFailure(Throwable t) {
        Sneaker.with(this)
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();
    }

    public class SuccessViewDialog {

        private TextView success, tvsubmoney, tvordernumber;

        // Dialog dialog=new Dialog(this,android.R.style.Theme_Black_NoTitleBar_Fullscreen)


        public void showDialog(Activity activity, String Ordernumber) {


            Dialog dialog = new Dialog(RazorPaymentActivity.this, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
            dialog.setContentView(R.layout.success);
            dialog.setCancelable(false);
            dialog.show();
            success = dialog.findViewById(R.id.success);
            tvsubmoney = dialog.findViewById(R.id.tvsubmoney);
            tvordernumber = dialog.findViewById(R.id.tvordernumber);
            tvordernumber.setText(Ordernumber);

            success.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //  dialog.dismiss();

                /*    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    Fragment fragment = new RecentBookingFragment();
                    fragmentTransaction.replace(R.id.fragment_Container, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();*/

                    SharedPrefManager.getInstans(RazorPaymentActivity.this).pacakgeClear();
                    SharedPrefManager.getInstans(RazorPaymentActivity.this).AddonseClear();

                    Intent intent = new Intent(RazorPaymentActivity.this, HomeActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                    dialog.dismiss();
                }
            });

        }


    }

    @Override
    public void onBackPressed() {


        Intent intent = new Intent(RazorPaymentActivity.this, HomeActivity.class);
        startActivity(intent);
        super.onBackPressed();

    }
}
