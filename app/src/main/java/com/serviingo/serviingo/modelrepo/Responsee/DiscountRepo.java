package com.serviingo.serviingo.modelrepo.Responsee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DiscountRepo {

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

        @SerializedName("discount_amount")
        @Expose
        private String discountAmount;
        @SerializedName("discount")
        @Expose
        private Discount discount;

        public String getDiscountAmount() {
            return discountAmount;
        }

        public void setDiscountAmount(String discountAmount) {
            this.discountAmount = discountAmount;
        }

        public Discount getDiscount() {
            return discount;
        }

        public void setDiscount(Discount discount) {
            this.discount = discount;
        }


        public class Discount {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("offer_name")
            @Expose
            private String offerName;
            @SerializedName("discount")
            @Expose
            private String discount;
            @SerializedName("min_total")
            @Expose
            private Integer minTotal;
            @SerializedName("max_total")
            @Expose
            private Integer maxTotal;
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

            public String getOfferName() {
                return offerName;
            }

            public void setOfferName(String offerName) {
                this.offerName = offerName;
            }

            public String getDiscount() {
                return discount;
            }

            public void setDiscount(String discount) {
                this.discount = discount;
            }

            public Integer getMinTotal() {
                return minTotal;
            }

            public void setMinTotal(Integer minTotal) {
                this.minTotal = minTotal;
            }

            public Integer getMaxTotal() {
                return maxTotal;
            }

            public void setMaxTotal(Integer maxTotal) {
                this.maxTotal = maxTotal;
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