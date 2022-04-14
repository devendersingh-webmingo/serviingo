package com.serviingo.serviingo.modelrepo.Responsee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetOrderNumbersRepo {

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

        @SerializedName("booking_numbers")
        @Expose
        public List<BookingNumber> bookingNumbers = null;
        public class BookingNumber {

            @SerializedName("id")
            @Expose
            public Integer id;
            @SerializedName("order_number")
            @Expose
            public String orderNumber;

        }
    }

}