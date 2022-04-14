package com.serviingo.serviingo.modelrepo.Responsee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ServetimeSlotRepo {

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

        @SerializedName("slots")
        @Expose
        private List<Slot> slots = null;

        public List<Slot> getSlots() {
            return slots;
        }

        public void setSlots(List<Slot> slots) {
            this.slots = slots;
        }



        public class Slot {

            @SerializedName("time")
            @Expose
            private String time;
            @SerializedName("booked_status")
            @Expose
            private Boolean bookedStatus;

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public Boolean getBookedStatus() {
                return bookedStatus;
            }

            public void setBookedStatus(Boolean bookedStatus) {
                this.bookedStatus = bookedStatus;
            }

        }
    }
}