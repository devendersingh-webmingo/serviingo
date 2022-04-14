package com.serviingo.serviingo.modelrepo.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EditReviewRequest {


    @SerializedName("review")
    @Expose
    public String review;
    @SerializedName("rating")
    @Expose
    public String rating;
    @SerializedName("review_id")
    @Expose
    public String review_id;

    public EditReviewRequest(String review, String rating, String review_id) {
        this.review = review;
        this.rating = rating;
        this.review_id = review_id;
    }
}
