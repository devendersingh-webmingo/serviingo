package com.serviingo.serviingo.modelrepo.Responsee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MywalletRespo {
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


        @SerializedName("available_wallet_amount")
        @Expose
        private String availableWalletAmount;

        @SerializedName("histories")
        @Expose
        private List<History> histories = null;

        public List<History> getHistories() {
            return histories;
        }

        public void setHistories(List<History> histories) {
            this.histories = histories;
        }

        public String getAvailableWalletAmount() {
            return availableWalletAmount;
        }

        public void setAvailableWalletAmount(String availableWalletAmount) {
            this.availableWalletAmount = availableWalletAmount;
        }

        public class History {
/*

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("user_id")
            @Expose
            private Integer userId;
            @SerializedName("booking_id")
            @Expose
            private String bookingId;
            @SerializedName("transaction_id")
            @Expose
            private String transactionId;
            @SerializedName("amount")
            @Expose
            private String amount;
            @SerializedName("avail_balance")
            @Expose
            private Integer availBalance;
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
            @SerializedName("payment_screenshots")
            @Expose
            private String paymentScreenshots;
            @SerializedName("ref_id")
            @Expose
            private String refId;
            @SerializedName("order_id")
            @Expose
            private String orderId;
            @SerializedName("payment_remark")
            @Expose
            private String paymentRemark;
            @SerializedName("created_by")
            @Expose
            private String createdBy;
            @SerializedName("status")
            @Expose
            private String status;
            @SerializedName("approval")
            @Expose
            private String approval;
            @SerializedName("type")
            @Expose
            private String type;
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

            public String getBookingId() {
                return bookingId;
            }

            public void setBookingId(String bookingId) {
                this.bookingId = bookingId;
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

            public Integer getAvailBalance() {
                return availBalance;
            }

            public void setAvailBalance(Integer availBalance) {
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

            public String getPaymentScreenshots() {
                return paymentScreenshots;
            }

            public void setPaymentScreenshots(String paymentScreenshots) {
                this.paymentScreenshots = paymentScreenshots;
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

            public String getPaymentRemark() {
                return paymentRemark;
            }

            public void setPaymentRemark(String paymentRemark) {
                this.paymentRemark = paymentRemark;
            }

            public String getCreatedBy() {
                return createdBy;
            }

            public void setCreatedBy(String createdBy) {
                this.createdBy = createdBy;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getApproval() {
                return approval;
            }

            public void setApproval(String approval) {
                this.approval = approval;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
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
*/


            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("title")
            @Expose
            private String title;
            @SerializedName("user_id")
            @Expose
            private Integer userId;
            @SerializedName("booking_id")
            @Expose
            private String bookingId;
            @SerializedName("transaction_id")
            @Expose
            private String transactionId;
            @SerializedName("withdrawal")
            @Expose
            private String withdrawal;
            @SerializedName("deposit")
            @Expose
            private String deposit;
            @SerializedName("amount")
            @Expose
            private String amount;
            @SerializedName("avail_balance")
            @Expose
            private Integer availBalance;
            @SerializedName("remark")
            @Expose
            private String remark;
            @SerializedName("payment_mode")
            @Expose
            private String paymentMode;
            @SerializedName("mode_of_payment")
            @Expose
            private String modeOfPayment;
            @SerializedName("payment_remark")
            @Expose
            private String paymentRemark;
            @SerializedName("created_by")
            @Expose
            private String createdBy;
            @SerializedName("approval")
            @Expose
            private String approval;
            @SerializedName("type")
            @Expose
            private String type;
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

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public Integer getUserId() {
                return userId;
            }

            public void setUserId(Integer userId) {
                this.userId = userId;
            }

            public String getBookingId() {
                return bookingId;
            }

            public void setBookingId(String bookingId) {
                this.bookingId = bookingId;
            }

            public String getTransactionId() {
                return transactionId;
            }

            public void setTransactionId(String transactionId) {
                this.transactionId = transactionId;
            }

            public String getWithdrawal() {
                return withdrawal;
            }

            public void setWithdrawal(String withdrawal) {
                this.withdrawal = withdrawal;
            }

            public String getDeposit() {
                return deposit;
            }

            public void setDeposit(String deposit) {
                this.deposit = deposit;
            }

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }

            public Integer getAvailBalance() {
                return availBalance;
            }

            public void setAvailBalance(Integer availBalance) {
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

            public String getPaymentRemark() {
                return paymentRemark;
            }

            public void setPaymentRemark(String paymentRemark) {
                this.paymentRemark = paymentRemark;
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

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
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
