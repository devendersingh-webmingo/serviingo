package com.serviingo.serviingo.modelrepo.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CustomPackage_request {



    @SerializedName("service")
    @Expose
    private ArrayList<String> service = null;
    @SerializedName("total_price")
    @Expose
    private String totalPrice;
    @SerializedName("sub_category_id")
    @Expose
    private String subCategoryId;


    @SerializedName("offer_discount")
    @Expose
    private String offerDiscount;



    @SerializedName("discount_amount")
    @Expose
    private String discountAmount;
/*
    public CustomPackage_request(ArrayList<String> service, String totalPrice,  String sub_sub_category_id, String offerDiscount, String discountAmount) {

        this.service = service;
        this.totalPrice = totalPrice;
        this.sub_sub_category_id = sub_sub_category_id;
        this.offerDiscount = offerDiscount;
        this.discountAmount = discountAmount;
    }
*/

    public CustomPackage_request(ArrayList<String> service, String totalPrice, String subCategoryId, String offerDiscount, String discountAmount) {
        super();
        this.service = service;
        this.totalPrice = totalPrice;
        this.subCategoryId = subCategoryId;
        this.offerDiscount = offerDiscount;
        this.discountAmount = discountAmount;
    }

    public ArrayList<String> getService() {
        return service;
    }

    public void setService(ArrayList<String> service) {
        this.service = service;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(String subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getOfferDiscount() {
        return offerDiscount;
    }

    public void setOfferDiscount(String offerDiscount) {
        this.offerDiscount = offerDiscount;
    }

    public String getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
    }


}


