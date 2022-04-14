package com.serviingo.serviingo.modelrepo.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaymentSignatureVerifyWalletReq {


    @SerializedName("amount")
    @Expose
    public String amount;
    @SerializedName("razorpay_payment_id")
    @Expose
    public String razorpay_payment_id;
    @SerializedName("razorpay_order_id")
    @Expose
    public String razorpay_order_id;
    @SerializedName("razorpay_signature")
    @Expose
    public String razorpay_signature;


    @SerializedName("payment_mode")
    @Expose
    public String payment_mode;

/*

    public PaymentSignatureVerifyWalletReq(String amount, String razorpay_payment_id, String razorpay_order_id, String razorpay_signature) {

        this.amount = amount;
        this.razorpay_payment_id = razorpay_payment_id;
        this.razorpay_order_id = razorpay_order_id;
        this.razorpay_signature = razorpay_signature;
    }
*/

    public PaymentSignatureVerifyWalletReq(String amount, String razorpay_payment_id, String razorpay_order_id, String razorpay_signature, String payment_mode) {
        this.amount = amount;
        this.razorpay_payment_id = razorpay_payment_id;
        this.razorpay_order_id = razorpay_order_id;
        this.razorpay_signature = razorpay_signature;
        this.payment_mode = payment_mode;
    }
}
