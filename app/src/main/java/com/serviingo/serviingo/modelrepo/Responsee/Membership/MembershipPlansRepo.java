package com.serviingo.serviingo.modelrepo.Responsee.Membership;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MembershipPlansRepo {



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
        private String id;
        @SerializedName("unique_id")
        @Expose
        private String uniqueId;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("cost")
        @Expose
        private String cost;
        @SerializedName("discount")
        @Expose
        private String discount;
        @SerializedName("final_cost")
        @Expose
        private String finalCost;
        @SerializedName("benefit")
        @Expose
        private String benefit;
        @SerializedName("validity")
        @Expose
        private String validity;
        @SerializedName("used_in_year")
        @Expose
        private String usedInYear;
        @SerializedName("used_in_month")
        @Expose
        private String usedInMonth;
        @SerializedName("used_in_day")
        @Expose
        private String usedInDay;
        @SerializedName("extend")
        @Expose
        private String extend;
        @SerializedName("extend_month")
        @Expose
        private String extendMonth;
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

        public String getId() {
            return id;
        }

        public void setId(String id) {
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

        public String getCost() {
            return cost;
        }

        public void setCost(String cost) {
            this.cost = cost;
        }

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public String getFinalCost() {
            return finalCost;
        }

        public void setFinalCost(String finalCost) {
            this.finalCost = finalCost;
        }

        public String getBenefit() {
            return benefit;
        }

        public void setBenefit(String benefit) {
            this.benefit = benefit;
        }

        public String getValidity() {
            return validity;
        }

        public void setValidity(String validity) {
            this.validity = validity;
        }

        public String getUsedInYear() {
            return usedInYear;
        }

        public void setUsedInYear(String usedInYear) {
            this.usedInYear = usedInYear;
        }

        public String getUsedInMonth() {
            return usedInMonth;
        }

        public void setUsedInMonth(String usedInMonth) {
            this.usedInMonth = usedInMonth;
        }

        public String getUsedInDay() {
            return usedInDay;
        }

        public void setUsedInDay(String usedInDay) {
            this.usedInDay = usedInDay;
        }

        public String getExtend() {
            return extend;
        }

        public void setExtend(String extend) {
            this.extend = extend;
        }

        public String getExtendMonth() {
            return extendMonth;
        }

        public void setExtendMonth(String extendMonth) {
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
