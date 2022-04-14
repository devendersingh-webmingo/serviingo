package com.serviingo.serviingo.modelrepo.Responsee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomPackageRepo {

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

        @SerializedName("slug")
        @Expose
        private String slug;
        @SerializedName("category_id")
        @Expose
        private Integer categoryId;
        @SerializedName("sub_category_id")
        @Expose
        private Integer subCategoryId;
        @SerializedName("sub_sub_category_id")
        @Expose
        private Object subSubCategoryId;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("service_id")
        @Expose
        private String serviceId;
        @SerializedName("amount")
        @Expose
        private Integer amount;
        @SerializedName("video")
        @Expose
        private Object video;
        @SerializedName("discount")
        @Expose
        private String discount;
        @SerializedName("after_discount")
        @Expose
        private Integer afterDiscount;
        @SerializedName("about_package")
        @Expose
        private Object aboutPackage;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("id")
        @Expose
        private Integer id;

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public Integer getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(Integer categoryId) {
            this.categoryId = categoryId;
        }

        public Integer getSubCategoryId() {
            return subCategoryId;
        }

        public void setSubCategoryId(Integer subCategoryId) {
            this.subCategoryId = subCategoryId;
        }

        public Object getSubSubCategoryId() {
            return subSubCategoryId;
        }

        public void setSubSubCategoryId(Object subSubCategoryId) {
            this.subSubCategoryId = subSubCategoryId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getServiceId() {
            return serviceId;
        }

        public void setServiceId(String serviceId) {
            this.serviceId = serviceId;
        }

        public Integer getAmount() {
            return amount;
        }

        public void setAmount(Integer amount) {
            this.amount = amount;
        }

        public Object getVideo() {
            return video;
        }

        public void setVideo(Object video) {
            this.video = video;
        }

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public Integer getAfterDiscount() {
            return afterDiscount;
        }

        public void setAfterDiscount(Integer afterDiscount) {
            this.afterDiscount = afterDiscount;
        }

        public Object getAboutPackage() {
            return aboutPackage;
        }

        public void setAboutPackage(Object aboutPackage) {
            this.aboutPackage = aboutPackage;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

    }
}