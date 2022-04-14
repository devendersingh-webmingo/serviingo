package com.serviingo.serviingo.modelrepo.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Reschedule_request {

    @SerializedName("order_id")
    @Expose
    public String order_id;

    @SerializedName("serve_date")
    @Expose
    public String serve_date;

    @SerializedName("serve_time")
    @Expose
    public String serve_time;

    @SerializedName("query_type_id")
    @Expose
    public String query_type_id;

    public Reschedule_request(String order_id, String serve_date, String serve_time, String query_type_id) {
        this.order_id = order_id;
        this.serve_date = serve_date;
        this.serve_time = serve_time;
        this.query_type_id = query_type_id;
    }
}
