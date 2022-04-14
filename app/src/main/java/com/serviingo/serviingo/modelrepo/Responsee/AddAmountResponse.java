package com.serviingo.serviingo.modelrepo.Responsee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddAmountResponse {
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

        @SerializedName("user_id")
        @Expose
        private Integer userId;
        @SerializedName("transaction_id")
        @Expose
        private String transactionId;
        @SerializedName("amount")
        @Expose
        private String amount;
        @SerializedName("avail_balance")
        @Expose
        private String availBalance;
        @SerializedName("remark")
        @Expose
        private String remark;
        @SerializedName("payment_mode")
        @Expose
        private String paymentMode;
        @SerializedName("mode_of_payment")
        @Expose
        private String modeOfPayment;
        @SerializedName("cash_collected_by")
        @Expose
        private String cashCollectedBy;
        @SerializedName("cheque_number")
        @Expose
        private String chequeNumber;
        @SerializedName("cheque_date")
        @Expose
        private String chequeDate;
        @SerializedName("bank_name")
        @Expose
        private String bankName;
        @SerializedName("bank_branch")
        @Expose
        private String bankBranch;
        @SerializedName("utr_number")
        @Expose
        private String utrNumber;
        @SerializedName("ref_id")
        @Expose
        private String refId;
        @SerializedName("order_id")
        @Expose
        private String orderId;
        @SerializedName("created_by")
        @Expose
        private String createdBy;
        @SerializedName("approval")
        @Expose
        private String approval;
        @SerializedName("payment_remark")
        @Expose
        private String paymentRemark;
        @SerializedName("payment_screenshots")
        @Expose
        private String paymentScreenshots;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("id")
        @Expose
        private Integer id;

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public String getTransactionId() {
            return transactionId;
        }

        public void setTransactionId(String transactionId) {
            this.transactionId = transactionId;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getAvailBalance() {
            return availBalance;
        }

        public void setAvailBalance(String availBalance) {
            this.availBalance = availBalance;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getPaymentMode() {
            return paymentMode;
        }

        public void setPaymentMode(String paymentMode) {
            this.paymentMode = paymentMode;
        }

        public String getModeOfPayment() {
            return modeOfPayment;
        }

        public void setModeOfPayment(String modeOfPayment) {
            this.modeOfPayment = modeOfPayment;
        }

        public String getCashCollectedBy() {
            return cashCollectedBy;
        }

        public void setCashCollectedBy(String cashCollectedBy) {
            this.cashCollectedBy = cashCollectedBy;
        }

        public String getChequeNumber() {
            return chequeNumber;
        }

        public void setChequeNumber(String chequeNumber) {
            this.chequeNumber = chequeNumber;
        }

        public String getChequeDate() {
            return chequeDate;
        }

        public void setChequeDate(String chequeDate) {
            this.chequeDate = chequeDate;
        }

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        public String getBankBranch() {
            return bankBranch;
        }

        public void setBankBranch(String bankBranch) {
            this.bankBranch = bankBranch;
        }

        public String getUtrNumber() {
            return utrNumber;
        }

        public void setUtrNumber(String utrNumber) {
            this.utrNumber = utrNumber;
        }

        public String getRefId() {
            return refId;
        }

        public void setRefId(String refId) {
            this.refId = refId;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
        }

        public String getApproval() {
            return approval;
        }

        public void setApproval(String approval) {
            this.approval = approval;
        }

        public String getPaymentRemark() {
            return paymentRemark;
        }

        public void setPaymentRemark(String paymentRemark) {
            this.paymentRemark = paymentRemark;
        }

        public String getPaymentScreenshots() {
            return paymentScreenshots;
        }

        public void setPaymentScreenshots(String paymentScreenshots) {
            this.paymentScreenshots = paymentScreenshots;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

    }
}