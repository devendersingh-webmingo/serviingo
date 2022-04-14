package com.serviingo.serviingo.modelrepo.Responsee.Finacial;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FinacialServicesRepo {



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

        @SerializedName("services")
        @Expose
        private List<Service> services = null;

        public List<Service> getServices() {
            return services;
        }

        public void setServices(List<Service> services) {
            this.services = services;
        }

        public class Service {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("master_id")
            @Expose
            private Integer masterId;
            @SerializedName("category_id")
            @Expose
            private Integer categoryId;
            @SerializedName("slug")
            @Expose
            private String slug;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("title")
            @Expose
            private Object title;
            @SerializedName("description")
            @Expose
            private String description;
            @SerializedName("status")
            @Expose
            private String status;
            @SerializedName("image")
            @Expose
            private String image;
            @SerializedName("logo")
            @Expose
            private String logo;
            @SerializedName("emi_per_lakh")
            @Expose
            private String emiPerLakh;
            @SerializedName("interest")
            @Expose
            private Float interest;
            @SerializedName("eligibility")
            @Expose
            private String eligibility;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public Integer getMasterId() {
                return masterId;
            }

            public void setMasterId(Integer masterId) {
                this.masterId = masterId;
            }

            public Integer getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(Integer categoryId) {
                this.categoryId = categoryId;
            }

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Object getTitle() {
                return title;
            }

            public void setTitle(Object title) {
                this.title = title;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }

            public String getEmiPerLakh() {
                return emiPerLakh;
            }

            public void setEmiPerLakh(String emiPerLakh) {
                this.emiPerLakh = emiPerLakh;
            }

            public Float getInterest() {
                return interest;
            }

            public void setInterest(Float interest) {
                this.interest = interest;
            }

            public String getEligibility() {
                return eligibility;
            }

            public void setEligibility(String eligibility) {
                this.eligibility = eligibility;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getUpdatedAt() {
                return updatedAt;
            }

            public void setUpdatedAt(String updatedAt) {
                this.updatedAt = updatedAt;
            }

        }
    }
}
