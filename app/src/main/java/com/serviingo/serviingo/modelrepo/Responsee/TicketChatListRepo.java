package com.serviingo.serviingo.modelrepo.Responsee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TicketChatListRepo {

    @SerializedName("status")
    @Expose
    public Boolean status;
    @SerializedName("message")
    @Expose
    public String message;
    @SerializedName("data")
    @Expose
    public Data data;


    public class Data {

        @SerializedName("ticket")
        @Expose
        public Ticket ticket;
        @SerializedName("chats")
        @Expose
        public List<Chat> chats = null;
        @SerializedName("last_reply")
        @Expose
        public String lastReply;

        public class Chat {

            @SerializedName("id")
            @Expose
            public Integer id;
            @SerializedName("ticket_id")
            @Expose
            public Integer ticketId;
            @SerializedName("user_id")
            @Expose
            public Integer userId;
            @SerializedName("message")
            @Expose
            public String message;


            @SerializedName("date_time")
            @Expose
            public String date_time;


            @SerializedName("file")
            @Expose
            public Object file;
            @SerializedName("created_at")
            @Expose
            public String createdAt;
            @SerializedName("updated_at")
            @Expose
            public String updatedAt;

        }

        public class Ticket {

            @SerializedName("id")
            @Expose
            public Integer id;
            @SerializedName("ticket_id")
            @Expose
            public String ticketId;
            @SerializedName("user_id")
            @Expose
            public Integer userId;
            @SerializedName("team_id")
            @Expose
            public Integer teamId;
            @SerializedName("subject_type")
            @Expose
            public String subjectType;
            @SerializedName("subject")
            @Expose
            public Object subject;
            @SerializedName("booking_id")
            @Expose
            public Integer bookingId;
            @SerializedName("wallet_id")
            @Expose
            public Object walletId;
            @SerializedName("query")
            @Expose
            public String query;
            @SerializedName("file")
            @Expose
            public String file;
            @SerializedName("priority")
            @Expose
            public String priority;
            @SerializedName("status")
            @Expose
            public String status;
            @SerializedName("created_at")
            @Expose
            public String createdAt;
            @SerializedName("updated_at")
            @Expose
            public String updatedAt;

        }
    }

}