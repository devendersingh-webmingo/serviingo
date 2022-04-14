package com.serviingo.serviingo.modelrepo.Responsee.Membership;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CheckMembershipDiscountRepo {

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

        @SerializedName("user_membership")
        @Expose
        private UserMembership userMembership;
        @SerializedName("plan_discount")
        @Expose
        private Integer planDiscount;

        public UserMembership getUserMembership() {
            return userMembership;
        }

        public void setUserMembership(UserMembership userMembership) {
            this.userMembership = userMembership;
        }

        public Integer getPlanDiscount() {
            return planDiscount;
        }

        public void setPlanDiscount(Integer planDiscount) {
            this.planDiscount = planDiscount;
        }

        public class UserMembership {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("user_id")
            @Expose
            private Integer userId;
            @SerializedName("membership_id")
            @Expose
            private Integer membershipId;
            @SerializedName("order_id")
            @Expose
            private Integer orderId;
            @SerializedName("start_date")
            @Expose
            private String startDate;
            @SerializedName("end_date")
            @Expose
            private String endDate;
            @SerializedName("extend_start")
            @Expose
            private Object extendStart;
            @SerializedName("extend_end")
            @Expose
            private Object extendEnd;
            @SerializedName("first_date")
            @Expose
            private Object firstDate;
            @SerializedName("amount")
            @Expose
            private Integer amount;
            @SerializedName("active_type_status")
            @Expose
            private String activeTypeStatus;
            @SerializedName("status")
            @Expose
            private String status;
            @SerializedName("pay_by")
            @Expose
            private String payBy;
            @SerializedName("razorpay_order_id")
            @Expose
            private Object razorpayOrderId;
            @SerializedName("razorpay_payment_id")
            @Expose
            private Object razorpayPaymentId;
            @SerializedName("razorpay_signature")
            @Expose
            private Object razorpaySignature;
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

            public Integer getUserId() {
                return userId;
            }

            public void setUserId(Integer userId) {
                this.userId = userId;
            }

            public Integer getMembershipId() {
                return membershipId;
            }

            public void setMembershipId(Integer membershipId) {
                this.membershipId = membershipId;
            }

            public Integer getOrderId() {
                return orderId;
            }

            public void setOrderId(Integer orderId) {
                this.orderId = orderId;
            }

            public String getStartDate() {
                return startDate;
            }

            public void setStartDate(String startDate) {
                this.startDate = startDate;
            }

            public String getEndDate() {
                return endDate;
            }

            public void setEndDate(String endDate) {
                this.endDate = endDate;
            }

            public Object getExtendStart() {
                return extendStart;
            }

            public void setExtendStart(Object extendStart) {
                this.extendStart = extendStart;
            }

            public Object getExtendEnd() {
                return extendEnd;
            }

            public void setExtendEnd(Object extendEnd) {
                this.extendEnd = extendEnd;
            }

            public Object getFirstDate() {
                return firstDate;
            }

            public void setFirstDate(Object firstDate) {
                this.firstDate = firstDate;
            }

            public Integer getAmount() {
                return amount;
            }

            public void setAmount(Integer amount) {
                this.amount = amount;
            }

            public String getActiveTypeStatus() {
                return activeTypeStatus;
            }

            public void setActiveTypeStatus(String activeTypeStatus) {
                this.activeTypeStatus = activeTypeStatus;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getPayBy() {
                return payBy;
            }

            public void setPayBy(String payBy) {
                this.payBy = payBy;
            }

            public Object getRazorpayOrderId() {
                return razorpayOrderId;
            }

            public void setRazorpayOrderId(Object razorpayOrderId) {
                this.razorpayOrderId = razorpayOrderId;
            }

            public Object getRazorpayPaymentId() {
                return razorpayPaymentId;
            }

            public void setRazorpayPaymentId(Object razorpayPaymentId) {
                this.razorpayPaymentId = razorpayPaymentId;
            }

            public Object getRazorpaySignature() {
                return razorpaySignature;
            }

            public void setRazorpaySignature(Object razorpaySignature) {
                this.razorpaySignature = razorpaySignature;
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