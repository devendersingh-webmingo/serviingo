package com.serviingo.serviingo.modelrepo.Responsee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DateSlotRepo {
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



            @SerializedName("today_day_name")
            @Expose
            private String todayDayName;
            @SerializedName("today_day")
            @Expose
            private String todayDay;
            @SerializedName("today_date")
            @Expose
            private String todayDate;
            @SerializedName("slot_dates")
            @Expose
            private List<SlotDate> slotDates = null;

            public String getTodayDayName() {
                return todayDayName;
            }

            public void setTodayDayName(String todayDayName) {
                this.todayDayName = todayDayName;
            }

            public String getTodayDay() {
                return todayDay;
            }

            public void setTodayDay(String todayDay) {
                this.todayDay = todayDay;
            }

            public String getTodayDate() {
                return todayDate;
            }

            public void setTodayDate(String todayDate) {
                this.todayDate = todayDate;
            }

            public List<SlotDate> getSlotDates() {
                return slotDates;
            }

            public void setSlotDates(List<SlotDate> slotDates) {
                this.slotDates = slotDates;
            }


        public class SlotDate {

            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("day")
            @Expose
            private String day;
            @SerializedName("date")
            @Expose
            private String date;


            @SerializedName("value")
            @Expose
            private String value;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDay() {
                return day;
            }

            public void setDay(String day) {
                this.day = day;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

        }
    }

}