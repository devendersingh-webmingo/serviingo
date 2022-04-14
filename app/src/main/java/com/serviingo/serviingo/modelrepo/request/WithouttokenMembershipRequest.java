package com.serviingo.serviingo.modelrepo.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WithouttokenMembershipRequest {


    @SerializedName("membership_id")
    @Expose
    public String membership_id;


    @SerializedName("total_amount")
    @Expose
    public String total_amount;

    @SerializedName("service_ids")
    @Expose
    List<Integer> service_ids;

    public WithouttokenMembershipRequest(String membership_id, String total_amount, List<Integer> service_ids) {
        this.membership_id = membership_id;
        this.total_amount = total_amount;
        this.service_ids = service_ids;

    }
}
