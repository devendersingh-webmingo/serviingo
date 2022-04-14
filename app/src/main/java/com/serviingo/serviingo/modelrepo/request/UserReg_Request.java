package com.serviingo.serviingo.modelrepo.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserReg_Request {


    @SerializedName("referral_id")
    @Expose
    public String referral_id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("mobile_number")
    @Expose
    public String mobileNumber;
    @SerializedName("password")
    @Expose
    public String password;
    @SerializedName("confirm_password")
    @Expose
    public String confirmPassword;


    public UserReg_Request(String referral_id, String name, String email, String mobileNumber, String password, String confirmPassword) {
        this.referral_id = referral_id;
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
/*
    public UserReg_Request(String name, String email, String mobileNumber, String password, String confirmPassword) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }*/
}
