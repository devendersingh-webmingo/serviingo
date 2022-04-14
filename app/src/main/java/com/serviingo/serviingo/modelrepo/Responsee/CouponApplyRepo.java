package com.serviingo.serviingo.modelrepo.Responsee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CouponApplyRepo {


    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Data data;

    @Override
    public String toString() {
        return "CouponApplyRepo{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

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

        @SerializedName("coupon_discounted")
        @Expose
        private Integer couponDiscounted;
        @SerializedName("coupon_id")
        @Expose
        private Integer couponId;

        public Integer getCouponDiscounted() {
            return couponDiscounted;
        }

        public void setCouponDiscounted(Integer couponDiscounted) {
            this.couponDiscounted = couponDiscounted;
        }

        public Integer getCouponId() {
            return couponId;
        }

        public void setCouponId(Integer couponId) {
            this.couponId = couponId;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "couponDiscounted=" + couponDiscounted +
                    ", couponId=" + couponId +
                    '}';
        }
    }
}
