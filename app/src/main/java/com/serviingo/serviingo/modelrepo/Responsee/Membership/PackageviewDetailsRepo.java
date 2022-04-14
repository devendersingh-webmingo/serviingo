package com.serviingo.serviingo.modelrepo.Responsee.Membership;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PackageviewDetailsRepo {


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

        @SerializedName("gallery_image_path")
        @Expose
        private String galleryImagePath;
        @SerializedName("service_image_path")
        @Expose
        private String serviceImagePath;
        @SerializedName("galleries")
        @Expose
        private List<Gallery> galleries = null;
        @SerializedName("services")
        @Expose
        private List<Service> services = null;
        @SerializedName("package")
        @Expose
        private Package _package;

        public String getGalleryImagePath() {
            return galleryImagePath;
        }

        public void setGalleryImagePath(String galleryImagePath) {
            this.galleryImagePath = galleryImagePath;
        }

        public String getServiceImagePath() {
            return serviceImagePath;
        }

        public void setServiceImagePath(String serviceImagePath) {
            this.serviceImagePath = serviceImagePath;
        }

        public List<Gallery> getGalleries() {
            return galleries;
        }

        public void setGalleries(List<Gallery> galleries) {
            this.galleries = galleries;
        }

        public List<Service> getServices() {
            return services;
        }

        public void setServices(List<Service> services) {
            this.services = services;
        }

        public Package getPackage() {
            return _package;
        }

        public void setPackage(Package _package) {
            this._package = _package;
        }

        public class Gallery {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("package_id")
            @Expose
            private Integer packageId;
            @SerializedName("image")
            @Expose
            private String image;
            @SerializedName("created_at")
            @Expose
            private Object createdAt;
            @SerializedName("updated_at")
            @Expose
            private Object updatedAt;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public Integer getPackageId() {
                return packageId;
            }

            public void setPackageId(Integer packageId) {
                this.packageId = packageId;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public Object getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(Object createdAt) {
                this.createdAt = createdAt;
            }

            public Object getUpdatedAt() {
                return updatedAt;
            }

            public void setUpdatedAt(Object updatedAt) {
                this.updatedAt = updatedAt;
            }

        }

        public class Package {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("state_id")
            @Expose
            private Integer stateId;
            @SerializedName("city_id")
            @Expose
            private Integer cityId;
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
            private Integer subSubCategoryId;
            @SerializedName("package_category_id")
            @Expose
            private Integer packageCategoryId;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("video")
            @Expose
            private Object video;
            @SerializedName("service_id")
            @Expose
            private String serviceId;
            @SerializedName("amount")
            @Expose
            private String amount;
            @SerializedName("discount")
            @Expose
            private String discount;
            @SerializedName("after_discount")
            @Expose
            private String afterDiscount;
            @SerializedName("about_package")
            @Expose
            private String aboutPackage;
            @SerializedName("status")
            @Expose
            private Integer status;
            @SerializedName("active")
            @Expose
            private Object active;
            @SerializedName("active_till")
            @Expose
            private Object activeTill;
            @SerializedName("deal_slug")
            @Expose
            private Object dealSlug;
            @SerializedName("vendor_commission")
            @Expose
            private Integer vendorCommission;
            @SerializedName("timer")
            @Expose
            private Integer timer;
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

            public Integer getStateId() {
                return stateId;
            }

            public void setStateId(Integer stateId) {
                this.stateId = stateId;
            }

            public Integer getCityId() {
                return cityId;
            }

            public void setCityId(Integer cityId) {
                this.cityId = cityId;
            }

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

            public Integer getSubSubCategoryId() {
                return subSubCategoryId;
            }

            public void setSubSubCategoryId(Integer subSubCategoryId) {
                this.subSubCategoryId = subSubCategoryId;
            }

            public Integer getPackageCategoryId() {
                return packageCategoryId;
            }

            public void setPackageCategoryId(Integer packageCategoryId) {
                this.packageCategoryId = packageCategoryId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Object getVideo() {
                return video;
            }

            public void setVideo(Object video) {
                this.video = video;
            }

            public String getServiceId() {
                return serviceId;
            }

            public void setServiceId(String serviceId) {
                this.serviceId = serviceId;
            }

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }

            public String getDiscount() {
                return discount;
            }

            public void setDiscount(String discount) {
                this.discount = discount;
            }

            public String getAfterDiscount() {
                return afterDiscount;
            }

            public void setAfterDiscount(String afterDiscount) {
                this.afterDiscount = afterDiscount;
            }

            public String getAboutPackage() {
                return aboutPackage;
            }

            public void setAboutPackage(String aboutPackage) {
                this.aboutPackage = aboutPackage;
            }

            public Integer getStatus() {
                return status;
            }

            public void setStatus(Integer status) {
                this.status = status;
            }

            public Object getActive() {
                return active;
            }

            public void setActive(Object active) {
                this.active = active;
            }

            public Object getActiveTill() {
                return activeTill;
            }

            public void setActiveTill(Object activeTill) {
                this.activeTill = activeTill;
            }

            public Object getDealSlug() {
                return dealSlug;
            }

            public void setDealSlug(Object dealSlug) {
                this.dealSlug = dealSlug;
            }

            public Integer getVendorCommission() {
                return vendorCommission;
            }

            public void setVendorCommission(Integer vendorCommission) {
                this.vendorCommission = vendorCommission;
            }

            public Integer getTimer() {
                return timer;
            }

            public void setTimer(Integer timer) {
                this.timer = timer;
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

        public class Service {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("state_id")
            @Expose
            private Integer stateId;
            @SerializedName("city_id")
            @Expose
            private Integer cityId;
            @SerializedName("category_id")
            @Expose
            private Integer categoryId;
            @SerializedName("sub_category_id")
            @Expose
            private Integer subCategoryId;
            @SerializedName("sub_sub_category_id")
            @Expose
            private Integer subSubCategoryId;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("amount")
            @Expose
            private String amount;
            @SerializedName("discount")
            @Expose
            private String discount;
            @SerializedName("after_discount")
            @Expose
            private String afterDiscount;
            @SerializedName("status")
            @Expose
            private Integer status;
            @SerializedName("icon")
            @Expose
            private String icon;
            @SerializedName("detail_image")
            @Expose
            private String detailImage;
            @SerializedName("description")
            @Expose
            private String description;
            @SerializedName("detail_video")
            @Expose
            private String detailVideo;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;
            @SerializedName("deleted_at")
            @Expose
            private Object deletedAt;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public Integer getStateId() {
                return stateId;
            }

            public void setStateId(Integer stateId) {
                this.stateId = stateId;
            }

            public Integer getCityId() {
                return cityId;
            }

            public void setCityId(Integer cityId) {
                this.cityId = cityId;
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

            public Integer getSubSubCategoryId() {
                return subSubCategoryId;
            }

            public void setSubSubCategoryId(Integer subSubCategoryId) {
                this.subSubCategoryId = subSubCategoryId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }

            public String getDiscount() {
                return discount;
            }

            public void setDiscount(String discount) {
                this.discount = discount;
            }

            public String getAfterDiscount() {
                return afterDiscount;
            }

            public void setAfterDiscount(String afterDiscount) {
                this.afterDiscount = afterDiscount;
            }

            public Integer getStatus() {
                return status;
            }

            public void setStatus(Integer status) {
                this.status = status;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getDetailImage() {
                return detailImage;
            }

            public void setDetailImage(String detailImage) {
                this.detailImage = detailImage;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getDetailVideo() {
                return detailVideo;
            }

            public void setDetailVideo(String detailVideo) {
                this.detailVideo = detailVideo;
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

            public Object getDeletedAt() {
                return deletedAt;
            }

            public void setDeletedAt(Object deletedAt) {
                this.deletedAt = deletedAt;
            }

        }
    }

}