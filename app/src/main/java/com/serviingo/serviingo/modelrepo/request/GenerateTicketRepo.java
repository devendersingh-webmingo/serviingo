package com.serviingo.serviingo.modelrepo.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GenerateTicketRepo {

    @SerializedName("other_subject")
    @Expose
    public String other_subject;

    @SerializedName("query_module")
    @Expose
    public String query_module;
    @SerializedName("query_statement")
    @Expose
    public String query_statement;
    @SerializedName("priority")
    @Expose
    public String priority;

    @SerializedName("subject_type_id")
    @Expose
    public String subject_type_id;


    public GenerateTicketRepo(String other_subject, String query_module, String query_statement, String priority, String subject_type_id) {
        this.other_subject = other_subject;
        this.query_module = query_module;
        this.query_statement = query_statement;
        this.priority = priority;
        this.subject_type_id = subject_type_id;
    }
}
