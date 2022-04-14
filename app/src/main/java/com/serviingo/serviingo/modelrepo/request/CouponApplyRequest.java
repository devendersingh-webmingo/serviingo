package com.serviingo.serviingo.modelrepo.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CouponApplyRequest {



    @SerializedName("coupon_code")
    @Expose
    public String coupon_code;
    @SerializedName("amount")
    @Expose
    public String amount;
    @SerializedName("plan_id")
    @Expose
    public String plan_id;
    @SerializedName("membership_discount")
    @Expose
    public String membership_discount;
    @SerializedName("package_id")
    @Expose
    public String package_id;

    public CouponApplyRequest(String coupon_code, String amount, String plan_id, String membership_discount, String package_id) {
        this.coupon_code = coupon_code;
        this.amount = amount;
        this.plan_id = plan_id;
        this.membership_discount = membership_discount;
        this.package_id = package_id;
    }

    @Override
    public String toString() {
        return "CouponApplyRequest{" +
                "coupon_code='" + coupon_code + '\'' +
                ", amount='" + amount + '\'' +
                ", plan_id='" + plan_id + '\'' +
                ", membership_discount='" + membership_discount + '\'' +
                ", package_id='" + package_id + '\'' +
                '}';
    }
}
