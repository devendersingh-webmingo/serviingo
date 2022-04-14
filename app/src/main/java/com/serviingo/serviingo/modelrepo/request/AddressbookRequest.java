package com.serviingo.serviingo.modelrepo.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddressbookRequest {


    @SerializedName("id")
    @Expose
    public String id;


    @SerializedName("address")
    @Expose
    public String address;

    @SerializedName("landmark")
    @Expose
    public String landmark;

    @SerializedName("pincode")
    @Expose
    public String pincode;

    @SerializedName("address_type")
    @Expose
    public String address_type;

    @SerializedName("state_id")
    @Expose
    public String state_id;
    @SerializedName("city_id")
    @Expose
    public String city_id;

    public AddressbookRequest(String address, String landmark, String pincode, String address_type, String state_id, String city_id) {
        this.address = address;
        this.landmark = landmark;
        this.pincode = pincode;
        this.address_type = address_type;
        this.state_id = state_id;
        this.city_id = city_id;
    }

    public AddressbookRequest(String id, String address, String landmark, String pincode, String address_type, String state_id, String city_id) {
        this.id = id;
        this.address = address;
        this.landmark = landmark;
        this.pincode = pincode;
        this.address_type = address_type;
        this.state_id = state_id;
        this.city_id = city_id;
    }

}
