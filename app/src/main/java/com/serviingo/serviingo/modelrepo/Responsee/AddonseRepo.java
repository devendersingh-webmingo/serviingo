package com.serviingo.serviingo.modelrepo.Responsee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AddonseRepo {
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


        @SerializedName("package")
        @Expose
        private Package _package;
        @SerializedName("sub_category")
        @Expose
        private SubCategory subCategory;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("keyword")
        @Expose
        private String keyword;
        @SerializedName("image_base_path")
        @Expose
        private String imageBasePath;
        @SerializedName("services")
        @Expose
        private List<Service> services = null;

        public Package getPackage() {
            return _package;
        }

        public void setPackage(Package _package) {
            this._package = _package;
        }

        public SubCategory getSubCategory() {
            return subCategory;
        }

        public void setSubCategory(SubCategory subCategory) {
            this.subCategory = subCategory;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        public String getImageBasePath() {
            return imageBasePath;
        }

        public void setImageBasePath(String imageBasePath) {
            this.imageBasePath = imageBasePath;
        }

        public List<Service> getServices() {
            return services;
        }

        public void setServices(List<Service> services) {
            this.services = services;
        }


        public class Package {

            @SerializedName("id")
            @Expose
            private Integer id;
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
            private Object detailImage;
            @SerializedName("description")
            @Expose
            private Object description;
            @SerializedName("detail_video")
            @Expose
            private Object detailVideo;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;
            @SerializedName("deleted_at")
            @Expose
            private Object deletedAt;


            @SerializedName("used_in")
            @Expose
            private String usedIn;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
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

            public Object getDetailImage() {
                return detailImage;
            }

            public void setDetailImage(Object detailImage) {
                this.detailImage = detailImage;
            }

            public Object getDescription() {
                return description;
            }

            public void setDescription(Object description) {
                this.description = description;
            }

            public Object getDetailVideo() {
                return detailVideo;
            }

            public void setDetailVideo(Object detailVideo) {
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

            public String getUsedIn() {
                return usedIn;
            }

            public void setUsedIn(String usedIn) {
                this.usedIn = usedIn;
            }


        }

        public class SubCategory {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("category_id")
            @Expose
            private Integer categoryId;
            @SerializedName("sub_category_icon")
            @Expose
            private String subCategoryIcon;
            @SerializedName("sub_category_name")
            @Expose
            private String subCategoryName;
            @SerializedName("sub_category_slug")
            @Expose
            private String subCategorySlug;
            @SerializedName("short_description")
            @Expose
            private String shortDescription;
            @SerializedName("features")
            @Expose
            private String features;
            @SerializedName("meta_title")
            @Expose
            private String metaTitle;
            @SerializedName("meta_description")
            @Expose
            private String metaDescription;
            @SerializedName("meta_keyword")
            @Expose
            private String metaKeyword;
            @SerializedName("status")
            @Expose
            private Integer status;
            @SerializedName("eligiable_for_all")
            @Expose
            private String eligiableForAll;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;
            @SerializedName("servicable_pincode")
            @Expose
            private String servicablePincode;
            @SerializedName("deleted_at")
            @Expose
            private Object deletedAt;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public Integer getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(Integer categoryId) {
                this.categoryId = categoryId;
            }

            public String getSubCategoryIcon() {
                return subCategoryIcon;
            }

            public void setSubCategoryIcon(String subCategoryIcon) {
                this.subCategoryIcon = subCategoryIcon;
            }

            public String getSubCategoryName() {
                return subCategoryName;
            }

            public void setSubCategoryName(String subCategoryName) {
                this.subCategoryName = subCategoryName;
            }

            public String getSubCategorySlug() {
                return subCategorySlug;
            }

            public void setSubCategorySlug(String subCategorySlug) {
                this.subCategorySlug = subCategorySlug;
            }

            public String getShortDescription() {
                return shortDescription;
            }

            public void setShortDescription(String shortDescription) {
                this.shortDescription = shortDescription;
            }

            public String getFeatures() {
                return features;
            }

            public void setFeatures(String features) {
                this.features = features;
            }

            public String getMetaTitle() {
                return metaTitle;
            }

            public void setMetaTitle(String metaTitle) {
                this.metaTitle = metaTitle;
            }

            public String getMetaDescription() {
                return metaDescription;
            }

            public void setMetaDescription(String metaDescription) {
                this.metaDescription = metaDescription;
            }

            public String getMetaKeyword() {
                return metaKeyword;
            }

            public void setMetaKeyword(String metaKeyword) {
                this.metaKeyword = metaKeyword;
            }

            public Integer getStatus() {
                return status;
            }

            public void setStatus(Integer status) {
                this.status = status;
            }

            public String getEligiableForAll() {
                return eligiableForAll;
            }

            public void setEligiableForAll(String eligiableForAll) {
                this.eligiableForAll = eligiableForAll;
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

            public String getServicablePincode() {
                return servicablePincode;
            }

            public void setServicablePincode(String servicablePincode) {
                this.servicablePincode = servicablePincode;
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