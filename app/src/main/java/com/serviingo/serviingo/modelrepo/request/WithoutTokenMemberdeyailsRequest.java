package com.serviingo.serviingo.modelrepo.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WithoutTokenMemberdeyailsRequest {
    @SerializedName("membership_id")
    @Expose
    public String membership_id;
    @SerializedName("total_amount")
    @Expose
    public String total_amount;

    @SerializedName("service_ids")
    @Expose
    public ArrayList<String> service_ids = null;

    public WithoutTokenMemberdeyailsRequest(String total_amount, ArrayList<String> service_ids) {
        this.total_amount = total_amount;
        this.service_ids = service_ids;
    }

    public WithoutTokenMemberdeyailsRequest(String membership_id, String total_amount, ArrayList<String> service_ids) {
        this.membership_id = membership_id;
        this.total_amount = total_amount;
        this.service_ids = service_ids;
    }
}
