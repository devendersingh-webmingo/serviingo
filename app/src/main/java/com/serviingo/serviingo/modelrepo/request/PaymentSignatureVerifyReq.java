package com.serviingo.serviingo.modelrepo.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaymentSignatureVerifyReq {

    @SerializedName("order_id")
    @Expose
    public String order_id;
    @SerializedName("razorpay_payment_id")
    @Expose
    public String razorpay_payment_id;
    @SerializedName("razorpay_order_id")
    @Expose
    public String razorpay_order_id;
    @SerializedName("razorpay_signature")
    @Expose
    public String razorpay_signature;

    public PaymentSignatureVerifyReq(String order_id, String razorpay_payment_id, String razorpay_order_id, String razorpay_signature) {

        this.order_id = order_id;
        this.razorpay_payment_id = razorpay_payment_id;
        this.razorpay_order_id = razorpay_order_id;
        this.razorpay_signature = razorpay_signature;
    }
}
