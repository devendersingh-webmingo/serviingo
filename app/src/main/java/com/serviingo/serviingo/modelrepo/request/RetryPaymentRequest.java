package com.serviingo.serviingo.modelrepo.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RetryPaymentRequest {


    @SerializedName("order_id")
    @Expose
    public String order_id;

    @SerializedName("pay_method")
    @Expose
    public String pay_method;

    @SerializedName("serve_date")
    @Expose
    public String serve_date;

    @SerializedName("serve_time")
    @Expose
    public String serve_time;

    @SerializedName("razorpay_payment_id")
    @Expose
    public String razorpay_payment_id;

    @SerializedName("razorpay_order_id")
    @Expose
    public String razorpay_order_id;

    @SerializedName("razorpay_signature")
    @Expose
    public String razorpay_signature;




    public RetryPaymentRequest(String order_id, String pay_method, String serve_date, String serve_time) {
        this.order_id = order_id;
        this.pay_method = pay_method;
        this.serve_date = serve_date;
        this.serve_time = serve_time;
    }

    public RetryPaymentRequest(String order_id, String pay_method, String serve_date, String serve_time, String razorpay_payment_id, String razorpay_order_id, String razorpay_signature) {
        this.order_id = order_id;
        this.pay_method = pay_method;
        this.serve_date = serve_date;
        this.serve_time = serve_time;
        this.razorpay_payment_id = razorpay_payment_id;
        this.razorpay_order_id = razorpay_order_id;
        this.razorpay_signature = razorpay_signature;
    }
}
