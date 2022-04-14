package com.serviingo.serviingo.modelrepo.Responsee.Razorpay;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RazorpayRepo {


    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Data data;

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


    public class Data {

        @SerializedName("payment_method")
        @Expose
        private PaymentMethod paymentMethod;

        public PaymentMethod getPaymentMethod() {
            return paymentMethod;
        }

        public void setPaymentMethod(PaymentMethod paymentMethod) {
            this.paymentMethod = paymentMethod;
        }



        public class PaymentMethod {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("slug")
            @Expose
            private String slug;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("logo")
            @Expose
            private String logo;
            @SerializedName("all_charges")
            @Expose
            private Integer allCharges;
            @SerializedName("debit_cart_charge")
            @Expose
            private Integer debitCartCharge;
            @SerializedName("credit_cart_charge")
            @Expose
            private Integer creditCartCharge;
            @SerializedName("upi_charge")
            @Expose
            private Integer upiCharge;
            @SerializedName("api_key")
            @Expose
            private String apiKey;
            @SerializedName("secret_key")
            @Expose
            private String secretKey;
            @SerializedName("status")
            @Expose
            private String status;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }

            public Integer getAllCharges() {
                return allCharges;
            }

            public void setAllCharges(Integer allCharges) {
                this.allCharges = allCharges;
            }

            public Integer getDebitCartCharge() {
                return debitCartCharge;
            }

            public void setDebitCartCharge(Integer debitCartCharge) {
                this.debitCartCharge = debitCartCharge;
            }

            public Integer getCreditCartCharge() {
                return creditCartCharge;
            }

            public void setCreditCartCharge(Integer creditCartCharge) {
                this.creditCartCharge = creditCartCharge;
            }

            public Integer getUpiCharge() {
                return upiCharge;
            }

            public void setUpiCharge(Integer upiCharge) {
                this.upiCharge = upiCharge;
            }

            public String getApiKey() {
                return apiKey;
            }

            public void setApiKey(String apiKey) {
                this.apiKey = apiKey;
            }

            public String getSecretKey() {
                return secretKey;
            }

            public void setSecretKey(String secretKey) {
                this.secretKey = secretKey;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getUpdatedAt() {
                return updatedAt;
            }

            public void setUpdatedAt(String updatedAt) {
                this.updatedAt = updatedAt;
            }

        }
    }
}
