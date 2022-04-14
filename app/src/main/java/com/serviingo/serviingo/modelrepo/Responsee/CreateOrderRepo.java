package com.serviingo.serviingo.modelrepo.Responsee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CreateOrderRepo {
    @SerializedName("status")
    @Expose
    public Boolean status;
    @SerializedName("message")
    @Expose
    public String message;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @SerializedName("data")
    @Expose
    public Data data;

    public class Data {

        @SerializedName("user_id")
        @Expose
        public Integer userId;
        @SerializedName("package_id")
        @Expose
        public Integer packageId;
        @SerializedName("addons")
        @Expose
        public List<Object> addons = null;
        @SerializedName("pincode")
        @Expose
        public String pincode;
        @SerializedName("order_number")
        @Expose
        public String orderNumber;
        @SerializedName("cart_details")
        @Expose
        public String cartDetails;
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
        @SerializedName("landmark")
        @Expose
        public String landmark;
        @SerializedName("state_id")
        @Expose
        public String stateId;
        @SerializedName("city")
        @Expose
        public String city;
        @SerializedName("payment_method")
        @Expose
        public String paymentMethod;
        @SerializedName("hygiene_fees")
        @Expose
        public Object hygieneFees;
        @SerializedName("updated_at")
        @Expose
        public String updatedAt;
        @SerializedName("created_at")
        @Expose
        public String createdAt;
        @SerializedName("id")
        @Expose
        public Integer id;

    }

}