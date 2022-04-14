package com.serviingo.serviingo.modelrepo.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CreateOrderRequest {


    @SerializedName("landmark")
    @Expose
    public String landmark;
    @SerializedName("health_price")
    @Expose
    public String health_price;
    @SerializedName("addon_service_ids")
    @Expose
    public String addon_service_ids;
    @SerializedName("package_id")
    @Expose
    public String packageId;
    @SerializedName("pincode")
    @Expose
    public String pincode;
    @SerializedName("total_amount")
    @Expose
    public String totalAmount;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("mobile_number")
    @Expose
    public String mobileNumber;
    @SerializedName("address")
    @Expose
    public String address;
    @SerializedName("state_id")
    @Expose
    public String stateId;
    @SerializedName("city_id")
    @Expose
    public String cityId;
    @SerializedName("payment_method")
    @Expose
    public String paymentMethod;


    @SerializedName("sub_amount")
    @Expose
    public String sub_amount;
    @SerializedName("pack_quantity")
    @Expose
    public String pack_quantity;

    @SerializedName("addon_services")
    @Expose
    public List<CreateOrderRequest.AddonService> addonServices = null;
    @SerializedName("discount_amount")
    @Expose
    public String discount_amount;


    @SerializedName("membership_discount")
    @Expose
    public String membership_discount;


    @SerializedName("membership_id")
    @Expose
    public String membership_id;

    @SerializedName("membership_cost")
    @Expose
    public String membership_cost;

    @SerializedName("serve_date")
    @Expose
    public String serve_date;

    @SerializedName("serve_time")
    @Expose
    public String serve_time;

    @SerializedName("savein_addressbook")
    @Expose
    public String savein_addressbook;

    @SerializedName("coupon_discount_amount")
    @Expose
    public String coupon_discount_amount;

    @SerializedName("coupon_id")
    @Expose
    public String coupon_id;


    public CreateOrderRequest(String landmark, String health_price, String addon_service_ids, String packageId, String pincode,
                              String totalAmount, String name, String email, String mobileNumber, String address, String stateId,
                              String cityId, String paymentMethod, String sub_amount, String pack_quantity, List<AddonService> addonServices, String discount_amount, String membership_discount,
                              String membership_id, String membership_cost, String serve_date, String serve_time,String savein_addressbook,String coupon_discount_amount,String coupon_id) {
        this.landmark = landmark;
        this.health_price = health_price;
        this.addon_service_ids = addon_service_ids;
        this.packageId = packageId;
        this.pincode = pincode;
        this.totalAmount = totalAmount;
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.stateId = stateId;
        this.cityId = cityId;
        this.paymentMethod = paymentMethod;
        this.sub_amount = sub_amount;
        this.pack_quantity = pack_quantity;
        this.addonServices = addonServices;
        this.discount_amount = discount_amount;
        this.membership_discount = membership_discount;
        this.membership_id = membership_id;
        this.membership_cost = membership_cost;
        this.serve_date = serve_date;
        this.serve_time = serve_time;
        this.savein_addressbook = savein_addressbook;

        this.coupon_discount_amount = coupon_discount_amount;
        this.coupon_id = coupon_id;


    }


    /*
        public CreateOrderRequest(String landmark, String health_price, String addon_service_ids, String packageId, String pincode, String totalAmount, String name, String email, String mobileNumber, String address, String stateId, String cityId, String paymentMethod,String sub_amount,String pack_quantity) {
            this.landmark = landmark;
            this.health_price = health_price;
            this.addon_service_ids = addon_service_ids;
            this.packageId = packageId;
            this.pincode = pincode;
            this.totalAmount = totalAmount;
            this.name = name;
            this.email = email;
            this.mobileNumber = mobileNumber;
            this.address = address;
            this.stateId = stateId;
            this.cityId = cityId;
            this.paymentMethod = paymentMethod;
            this.sub_amount= sub_amount;
            this.pack_quantity = pack_quantity;
        }
    */
    public static class AddonService {

        @SerializedName("service_id")
        @Expose
        public String serviceId;
        @SerializedName("quantity")
        @Expose
        public String quantity;

        public AddonService(String serviceId, String quantity) {
            this.serviceId = serviceId;
            this.quantity = quantity;
        }


    }

}