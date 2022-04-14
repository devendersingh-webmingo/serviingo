package com.serviingo.serviingo.modelrepo.Responsee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetTransactionRepo {


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

        @SerializedName("transaction")
        @Expose
        public List<Transaction> transaction = null;


        public class Transaction {

            @SerializedName("id")
            @Expose
            public Integer id;
            @SerializedName("transaction_id")
            @Expose
            public String transactionId;

        }

    }

}