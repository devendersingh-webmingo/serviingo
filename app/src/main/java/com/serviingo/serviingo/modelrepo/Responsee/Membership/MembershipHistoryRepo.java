package com.serviingo.serviingo.modelrepo.Responsee.Membership;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class MembershipHistoryRepo {


    @SerializedName("status")
    @Expose
    public Boolean status;
    @SerializedName("message")
    @Expose
    public String message;
    @SerializedName("data")
    @Expose
    public Data data;

    public class Data {

        @SerializedName("histories")
        @Expose
        public List<History> histories = null;

        public class History {

            @SerializedName("id")
            @Expose
            public Integer id;
            @SerializedName("user_id")
            @Expose
            public Integer userId;
            @SerializedName("membership_id")
            @Expose
            public Integer membershipId;
            @SerializedName("order_id")
            @Expose
            public Integer orderId;
            @SerializedName("start_date")
            @Expose
            public String startDate;
            @SerializedName("end_date")
            @Expose
            public String endDate;
            @SerializedName("extend_date")
            @Expose
            public Object extendDate;
            @SerializedName("amount")
            @Expose
            public Integer amount;
            @SerializedName("active_type_status")
            @Expose
            public String activeTypeStatus;
            @SerializedName("status")
            @Expose
            public String status;
            @SerializedName("pay_by")
            @Expose
            public Object payBy;
            @SerializedName("razorpay_order_id")
            @Expose
            public Object razorpayOrderId;
            @SerializedName("razorpay_payment_id")
            @Expose
            public Object razorpayPaymentId;
            @SerializedName("razorpay_signature")
            @Expose
            public Object razorpaySignature;
            @SerializedName("created_at")
            @Expose
            public String createdAt;
            @SerializedName("updated_at")
            @Expose
            public String updatedAt;
            @SerializedName("get_membership")
            @Expose
            public GetMembership getMembership;

            public class GetMembership {

                @SerializedName("id")
                @Expose
                public Integer id;
                @SerializedName("unique_id")
                @Expose
                public String uniqueId;
                @SerializedName("name")
                @Expose
                public String name;
                @SerializedName("cost")
                @Expose
                public Integer cost;
                @SerializedName("discount")
                @Expose
                public Integer discount;
                @SerializedName("final_cost")
                @Expose
                public Integer finalCost;
                @SerializedName("benefit")
                @Expose
                public Integer benefit;
                @SerializedName("validity")
                @Expose
                public Integer validity;
                @SerializedName("used_in_year")
                @Expose
                public Integer usedInYear;
                @SerializedName("used_in_month")
                @Expose
                public Integer usedInMonth;
                @SerializedName("used_in_day")
                @Expose
                public Integer usedInDay;
                @SerializedName("extend")
                @Expose
                public String extend;
                @SerializedName("extend_month")
                @Expose
                public Integer extendMonth;
                @SerializedName("remark")
                @Expose
                public String remark;
                @SerializedName("status")
                @Expose
                public String status;
                @SerializedName("created_at")
                @Expose
                public String createdAt;
                @SerializedName("updated_at")
                @Expose
                public String updatedAt;

            }
        }
    }
}
