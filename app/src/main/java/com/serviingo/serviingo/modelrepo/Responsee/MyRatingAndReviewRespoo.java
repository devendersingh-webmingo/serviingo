package com.serviingo.serviingo.modelrepo.Responsee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MyRatingAndReviewRespoo {



    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

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

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public class Datum {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("user_id")
        @Expose
        private Integer userId;
        @SerializedName("vendor_id")
        @Expose
        private Object vendorId;
        @SerializedName("pincode")
        @Expose
        private String pincode;
        @SerializedName("order_number")
        @Expose
        private String orderNumber;
        @SerializedName("cart_details")
        @Expose
        private String cartDetails;
        @SerializedName("total_amount")
        @Expose
        private String totalAmount;
        @SerializedName("tax_name")
        @Expose
        private String taxName;
        @SerializedName("tax_amount")
        @Expose
        private Integer taxAmount;
        @SerializedName("hygiene_fees")
        @Expose
        private Integer hygieneFees;
        @SerializedName("order_status")
        @Expose
        private String orderStatus;
        @SerializedName("vendor_status")
        @Expose
        private String vendorStatus;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("mobile_number")
        @Expose
        private String mobileNumber;
        @SerializedName("address")
        @Expose
        private String address;
        @SerializedName("landmark")
        @Expose
        private String landmark;
        @SerializedName("state_id")
        @Expose
        private Integer stateId;
        @SerializedName("city")
        @Expose
        private String city;
        @SerializedName("cancellation_reasons")
        @Expose
        private Object cancellationReasons;
        @SerializedName("cancelled_by")
        @Expose
        private Object cancelledBy;
        @SerializedName("payment_method")
        @Expose
        private String paymentMethod;
        @SerializedName("payment_status")
        @Expose
        private String paymentStatus;
        @SerializedName("assigned_status")
        @Expose
        private String assignedStatus;
        @SerializedName("remark")
        @Expose
        private Object remark;
        @SerializedName("membership_id")
        @Expose
        private Object membershipId;
        @SerializedName("membership_cost")
        @Expose
        private Object membershipCost;
        @SerializedName("cgst")
        @Expose
        private Integer cgst;
        @SerializedName("sgst")
        @Expose
        private Integer sgst;
        @SerializedName("igst")
        @Expose
        private Integer igst;
        @SerializedName("device_type")
        @Expose
        private String deviceType;
        @SerializedName("device_info")
        @Expose
        private String deviceInfo;
        @SerializedName("system_ip")
        @Expose
        private String systemIp;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("rating_reviews")
        @Expose
        private RatingReviews ratingReviews;

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

        public Object getVendorId() {
            return vendorId;
        }

        public void setVendorId(Object vendorId) {
            this.vendorId = vendorId;
        }

        public String getPincode() {
            return pincode;
        }

        public void setPincode(String pincode) {
            this.pincode = pincode;
        }

        public String getOrderNumber() {
            return orderNumber;
        }

        public void setOrderNumber(String orderNumber) {
            this.orderNumber = orderNumber;
        }

        public String getCartDetails() {
            return cartDetails;
        }

        public void setCartDetails(String cartDetails) {
            this.cartDetails = cartDetails;
        }

        public String getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(String totalAmount) {
            this.totalAmount = totalAmount;
        }

        public String getTaxName() {
            return taxName;
        }

        public void setTaxName(String taxName) {
            this.taxName = taxName;
        }

        public Integer getTaxAmount() {
            return taxAmount;
        }

        public void setTaxAmount(Integer taxAmount) {
            this.taxAmount = taxAmount;
        }

        public Integer getHygieneFees() {
            return hygieneFees;
        }

        public void setHygieneFees(Integer hygieneFees) {
            this.hygieneFees = hygieneFees;
        }

        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }

        public String getVendorStatus() {
            return vendorStatus;
        }

        public void setVendorStatus(String vendorStatus) {
            this.vendorStatus = vendorStatus;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getMobileNumber() {
            return mobileNumber;
        }

        public void setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getLandmark() {
            return landmark;
        }

        public void setLandmark(String landmark) {
            this.landmark = landmark;
        }

        public Integer getStateId() {
            return stateId;
        }

        public void setStateId(Integer stateId) {
            this.stateId = stateId;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public Object getCancellationReasons() {
            return cancellationReasons;
        }

        public void setCancellationReasons(Object cancellationReasons) {
            this.cancellationReasons = cancellationReasons;
        }

        public Object getCancelledBy() {
            return cancelledBy;
        }

        public void setCancelledBy(Object cancelledBy) {
            this.cancelledBy = cancelledBy;
        }

        public String getPaymentMethod() {
            return paymentMethod;
        }

        public void setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
        }

        public String getPaymentStatus() {
            return paymentStatus;
        }

        public void setPaymentStatus(String paymentStatus) {
            this.paymentStatus = paymentStatus;
        }

        public String getAssignedStatus() {
            return assignedStatus;
        }

        public void setAssignedStatus(String assignedStatus) {
            this.assignedStatus = assignedStatus;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public Object getMembershipId() {
            return membershipId;
        }

        public void setMembershipId(Object membershipId) {
            this.membershipId = membershipId;
        }

        public Object getMembershipCost() {
            return membershipCost;
        }

        public void setMembershipCost(Object membershipCost) {
            this.membershipCost = membershipCost;
        }

        public Integer getCgst() {
            return cgst;
        }

        public void setCgst(Integer cgst) {
            this.cgst = cgst;
        }

        public Integer getSgst() {
            return sgst;
        }

        public void setSgst(Integer sgst) {
            this.sgst = sgst;
        }

        public Integer getIgst() {
            return igst;
        }

        public void setIgst(Integer igst) {
            this.igst = igst;
        }

        public String getDeviceType() {
            return deviceType;
        }

        public void setDeviceType(String deviceType) {
            this.deviceType = deviceType;
        }

        public String getDeviceInfo() {
            return deviceInfo;
        }

        public void setDeviceInfo(String deviceInfo) {
            this.deviceInfo = deviceInfo;
        }

        public String getSystemIp() {
            return systemIp;
        }

        public void setSystemIp(String systemIp) {
            this.systemIp = systemIp;
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

        public RatingReviews getRatingReviews() {
            return ratingReviews;
        }

        public void setRatingReviews(RatingReviews ratingReviews) {
            this.ratingReviews = ratingReviews;
        }

        public class RatingReviews {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("order_id")
            @Expose
            private Integer orderId;
            @SerializedName("user_id")
            @Expose
            private Integer userId;
            @SerializedName("package_id")
            @Expose
            private Integer packageId;
            @SerializedName("category_id")
            @Expose
            private Integer categoryId;
            @SerializedName("rating")
            @Expose
            private Integer rating;
            @SerializedName("review")
            @Expose
            private Object review;
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

            public Integer getOrderId() {
                return orderId;
            }

            public void setOrderId(Integer orderId) {
                this.orderId = orderId;
            }

            public Integer getUserId() {
                return userId;
            }

            public void setUserId(Integer userId) {
                this.userId = userId;
            }

            public Integer getPackageId() {
                return packageId;
            }

            public void setPackageId(Integer packageId) {
                this.packageId = packageId;
            }

            public Integer getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(Integer categoryId) {
                this.categoryId = categoryId;
            }

            public Integer getRating() {
                return rating;
            }

            public void setRating(Integer rating) {
                this.rating = rating;
            }

            public Object getReview() {
                return review;
            }

            public void setReview(Object review) {
                this.review = review;
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



