package com.serviingo.serviingo.modelrepo.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TempCartRequest implements Serializable {


    @SerializedName("package_id")
    @Expose
    public String packageId;
    @SerializedName("addons")
    @Expose
    public ArrayList<String> addons = null;

    @SerializedName("serve_date")
    @Expose
    public String serve_date;


    @SerializedName("serve_time")
    @Expose
    public String serve_time;

    @SerializedName("membership_id")
    @Expose
    public String membership_id;

    @SerializedName("membership_cost")
    @Expose
    public String membership_cost;

    @SerializedName("go_to_checkout")
    @Expose
    public String go_to_checkout;


    public TempCartRequest(String packageId, ArrayList<String> addons, String serve_date, String serve_time, String membership_id, String membership_cost, String go_to_checkout) {

        this.packageId = packageId;
        this.addons = addons;
        this.serve_date = serve_date;
        this.serve_time = serve_time;
        this.membership_id = membership_id;
        this.membership_cost = membership_cost;
        this.go_to_checkout = go_to_checkout;
    }
}