package com.serviingo.serviingo.modelrepo.Responsee.Membership;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BuyMembershipRepo {

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
