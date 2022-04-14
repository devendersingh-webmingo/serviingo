package com.serviingo.serviingo.modelrepo.Responsee.Membership;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyMembershipRepo {
  /*  @SerializedName("status")
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

        @SerializedName("my_membership")
        @Expose
        private MyMembership myMembership;
        @SerializedName("validity")
        @Expose
        private Integer validity;

        public MyMembership getMyMembership() {
            return myMembership;
        }

        public void setMyMembership(MyMembership myMembership) {
            this.myMembership = myMembership;
        }

        public Integer getValidity() {
            return validity;
        }

        public void setValidity(Integer validity) {
            this.validity = validity;
        }

        public class MyMembership {

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
            @SerializedName("extend_date")
            @Expose
            private Object extendDate;
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
            private Object payBy;
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

            public Object getExtendDate() {
                return extendDate;
            }

            public void setExtendDate(Object extendDate) {
                this.extendDate = extendDate;
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

            public Object getPayBy() {
                return payBy;
            }

            public void setPayBy(Object payBy) {
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
*/


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

        @SerializedName("my_membership")
        @Expose
        private MyMembership myMembership;


        @SerializedName("membership_start_date")
        @Expose
        private String membershipStartDate;
        @SerializedName("membership_end_date")
        @Expose
        private String membershipEndDate;

        @SerializedName("validity")
        @Expose
        private Integer validity;

        public MyMembership getMyMembership() {
            return myMembership;
        }

        public void setMyMembership(MyMembership myMembership) {
            this.myMembership = myMembership;
        }

        public Integer getValidity() {
            return validity;
        }

        public void setValidity(Integer validity) {
            this.validity = validity;
        }

        public class MyMembership {

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
            private Object orderId;
            @SerializedName("start_date")
            @Expose
            private String startDate;
            @SerializedName("end_date")
            @Expose
            private String endDate;
            @SerializedName("extend_date")
            @Expose
            private Object extendDate;
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
            private Object payBy;
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
            @SerializedName("get_membership")
            @Expose
            private GetMembership getMembership;
            @SerializedName("extend_end")
            @Expose
            private String extend_end;

            public String getExtend_end() {
                return extend_end;
            }

            public void setExtend_end(String extend_end) {
                this.extend_end = extend_end;
            }


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

            public Object getOrderId() {
                return orderId;
            }

            public void setOrderId(Object orderId) {
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

            public Object getExtendDate() {
                return extendDate;
            }

            public void setExtendDate(Object extendDate) {
                this.extendDate = extendDate;
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

            public Object getPayBy() {
                return payBy;
            }

            public void setPayBy(Object payBy) {
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

            public GetMembership getGetMembership() {
                return getMembership;
            }

            public void setGetMembership(GetMembership getMembership) {
                this.getMembership = getMembership;
            }

            public class GetMembership {

                @SerializedName("id")
                @Expose
                private Integer id;
                @SerializedName("unique_id")
                @Expose
                private String uniqueId;
                @SerializedName("name")
                @Expose
                private String name;
                @SerializedName("cost")
                @Expose
                private Integer cost;
                @SerializedName("discount")
                @Expose
                private Integer discount;
                @SerializedName("final_cost")
                @Expose
                private Integer finalCost;
                @SerializedName("benefit")
                @Expose
                private Integer benefit;
                @SerializedName("validity")
                @Expose
                private Integer validity;
                @SerializedName("used_in_year")
                @Expose
                private Integer usedInYear;
                @SerializedName("used_in_month")
                @Expose
                private Integer usedInMonth;
                @SerializedName("used_in_day")
                @Expose
                private Integer usedInDay;
                @SerializedName("extend")
                @Expose
                private String extend;
                @SerializedName("extend_month")
                @Expose
                private Integer extendMonth;
                @SerializedName("remark")
                @Expose
                private String remark;
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

                public String getUniqueId() {
                    return uniqueId;
                }

                public void setUniqueId(String uniqueId) {
                    this.uniqueId = uniqueId;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public Integer getCost() {
                    return cost;
                }

                public void setCost(Integer cost) {
                    this.cost = cost;
                }

                public Integer getDiscount() {
                    return discount;
                }

                public void setDiscount(Integer discount) {
                    this.discount = discount;
                }

                public Integer getFinalCost() {
                    return finalCost;
                }

                public void setFinalCost(Integer finalCost) {
                    this.finalCost = finalCost;
                }

                public Integer getBenefit() {
                    return benefit;
                }

                public void setBenefit(Integer benefit) {
                    this.benefit = benefit;
                }

                public Integer getValidity() {
                    return validity;
                }

                public void setValidity(Integer validity) {
                    this.validity = validity;
                }

                public Integer getUsedInYear() {
                    return usedInYear;
                }

                public void setUsedInYear(Integer usedInYear) {
                    this.usedInYear = usedInYear;
                }

                public Integer getUsedInMonth() {
                    return usedInMonth;
                }

                public void setUsedInMonth(Integer usedInMonth) {
                    this.usedInMonth = usedInMonth;
                }

                public Integer getUsedInDay() {
                    return usedInDay;
                }

                public void setUsedInDay(Integer usedInDay) {
                    this.usedInDay = usedInDay;
                }

                public String getExtend() {
                    return extend;
                }

                public void setExtend(String extend) {
                    this.extend = extend;
                }

                public Integer getExtendMonth() {
                    return extendMonth;
                }

                public void setExtendMonth(Integer extendMonth) {
                    this.extendMonth = extendMonth;
                }

                public String getRemark() {
                    return remark;
                }

                public void setRemark(String remark) {
                    this.remark = remark;
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

        public String getMembershipStartDate() {
            return membershipStartDate;
        }

        public void setMembershipStartDate(String membershipStartDate) {
            this.membershipStartDate = membershipStartDate;
        }

        public String getMembershipEndDate() {
            return membershipEndDate;
        }

        public void setMembershipEndDate(String membershipEndDate) {
            this.membershipEndDate = membershipEndDate;
        }
    }
}
