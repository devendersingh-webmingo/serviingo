package com.serviingo.serviingo.modelrepo.Responsee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResponse {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Data data;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
    public class Data {

        @SerializedName("suggestion")
        @Expose
        private List<Suggestion> suggestion = null;

        public List<Suggestion> getSuggestion() {
            return suggestion;
        }

        public void setSuggestion(List<Suggestion> suggestion) {
            this.suggestion = suggestion;
        }
        public class Suggestion {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("label")
            @Expose
            private String label;
            @SerializedName("type")
            @Expose
            private String type;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

        }
    }
}