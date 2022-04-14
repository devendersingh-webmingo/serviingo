package com.serviingo.serviingo.modelrepo.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SendMessageReqest {

    @SerializedName("ticket_id")
    @Expose
    public String ticket_id;


    @SerializedName("message")
    @Expose
    public String message;

    public SendMessageReqest(String ticket_id, String message) {
        this.ticket_id = ticket_id;
        this.message = message;
    }
}
