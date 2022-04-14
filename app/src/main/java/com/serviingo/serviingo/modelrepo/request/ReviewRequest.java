package com.serviingo.serviingo.modelrepo.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReviewRequest {

    @SerializedName("order_id")
    @Expose
    public String order_id;
    @SerializedName("review")
    @Expose
    public String review;
    @SerializedName("rating")
    @Expose
    public String rating;
    @SerializedName("review_id")
    @Expose
    public String review_id;

    public ReviewRequest(String order_id, String review, String rating) {
        this.order_id = order_id;
        this.review = review;
        this.rating = rating;
    }

}
