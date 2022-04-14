package com.serviingo.serviingo.modelrepo.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ServiceEnquiryRequest {

    @SerializedName("service_id")
    @Expose
    public String service_id;


    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("email")
    @Expose
    public String email;


    @SerializedName("mobile_number")
    @Expose
    public String mobile_number;

    @SerializedName("address")
    @Expose
    public String address;

    @SerializedName("state")
    @Expose
    public String state;

    @SerializedName("city")
    @Expose
    public String city;


    @SerializedName("pincode")
    @Expose
    public String pincode;

    @SerializedName("dob")
    @Expose
    public String dob;

    @SerializedName("aadhaar")
    @Expose
    public String aadhaar;
    @SerializedName("pan_number")
    @Expose
    public String pan_number;
    @SerializedName("work_profile")
    @Expose
    public String work_profile;

    public ServiceEnquiryRequest(String service_id, String name, String email, String mobile_number, String address, String state, String city, String pincode, String dob, String aadhaar, String pan_number, String work_profile) {
        this.service_id = service_id;
        this.name = name;
        this.email = email;
        this.mobile_number = mobile_number;
        this.address = address;
        this.state = state;
        this.city = city;
        this.pincode = pincode;
        this.dob = dob;
        this.aadhaar = aadhaar;
        this.pan_number = pan_number;
        this.work_profile = work_profile;
    }
}
