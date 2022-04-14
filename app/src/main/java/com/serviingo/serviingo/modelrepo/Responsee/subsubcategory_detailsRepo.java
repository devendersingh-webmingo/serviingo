package com.serviingo.serviingo.modelrepo.Responsee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class subsubcategory_detailsRepo {
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

        @SerializedName("category_image_path")
        @Expose
        private String categoryImagePath;
        @SerializedName("sub_category_image_path")
        @Expose
        private String subCategoryImagePath;
        @SerializedName("subsub_category_image_path")
        @Expose
        private String subsubCategoryImagePath;
        @SerializedName("subsub_category")
        @Expose
        private SubsubCategory subsubCategory;
        @SerializedName("sub_category")
        @Expose
        private SubCategory subCategory;
        @SerializedName("category")
        @Expose
        private Category category;
        @SerializedName("sub_categories")
        @Expose
        private List<SubCategory__1> subCategories = null;
        @SerializedName("subsub_categories")
        @Expose
        private List<SubsubCategory__1> subsubCategories = null;
        @SerializedName("package_categories")
        @Expose
        private List<PackageCategory> packageCategories = null;
        @SerializedName("packages")
        @Expose
        private List<Package> packages = null;
        @SerializedName("deals")
        @Expose
        private List<Deal> deals = null;
        @SerializedName("total_give_rates")
        @Expose
        private Integer totalGiveRates;
        @SerializedName("total_bookings")
        @Expose
        private Integer totalBookings;
        @SerializedName("refer_and_earn")
        @Expose
        private ReferAndEarn referAndEarn;
        @SerializedName("latest_services")
        @Expose
        private List<LatestService> latestServices = null;
        @SerializedName("facebook_link")
        @Expose
        private FacebookLink facebookLink;
        @SerializedName("twitter_link")
        @Expose
        private TwitterLink twitterLink;
        @SerializedName("insta_link")
        @Expose
        private InstaLink instaLink;
        @SerializedName("youtube_link")
        @Expose
        private YoutubeLink youtubeLink;
        @SerializedName("linkedin_link")
        @Expose
        private LinkedinLink linkedinLink;
        @SerializedName("pinterest_link")
        @Expose
        private PinterestLink pinterestLink;

        public String getCategoryImagePath() {
            return categoryImagePath;
        }

        public void setCategoryImagePath(String categoryImagePath) {
            this.categoryImagePath = categoryImagePath;
        }

        public String getSubCategoryImagePath() {
            return subCategoryImagePath;
        }

        public void setSubCategoryImagePath(String subCategoryImagePath) {
            this.subCategoryImagePath = subCategoryImagePath;
        }

        public String getSubsubCategoryImagePath() {
            return subsubCategoryImagePath;
        }

        public void setSubsubCategoryImagePath(String subsubCategoryImagePath) {
            this.subsubCategoryImagePath = subsubCategoryImagePath;
        }

        public SubsubCategory getSubsubCategory() {
            return subsubCategory;
        }

        public void setSubsubCategory(SubsubCategory subsubCategory) {
            this.subsubCategory = subsubCategory;
        }

        public SubCategory getSubCategory() {
            return subCategory;
        }

        public void setSubCategory(SubCategory subCategory) {
            this.subCategory = subCategory;
        }

        public Category getCategory() {
            return category;
        }

        public void setCategory(Category category) {
            this.category = category;
        }

        public List<SubCategory__1> getSubCategories() {
            return subCategories;
        }

        public void setSubCategories(List<SubCategory__1> subCategories) {
            this.subCategories = subCategories;
        }

        public List<SubsubCategory__1> getSubsubCategories() {
            return subsubCategories;
        }

        public void setSubsubCategories(List<SubsubCategory__1> subsubCategories) {
            this.subsubCategories = subsubCategories;
        }

        public List<PackageCategory> getPackageCategories() {
            return packageCategories;
        }

        public void setPackageCategories(List<PackageCategory> packageCategories) {
            this.packageCategories = packageCategories;
        }

        public List<Package> getPackages() {
            return packages;
        }

        public void setPackages(List<Package> packages) {
            this.packages = packages;
        }

        public List<Deal> getDeals() {
            return deals;
        }

        public void setDeals(List<Deal> deals) {
            this.deals = deals;
        }

        public Integer getTotalGiveRates() {
            return totalGiveRates;
        }

        public void setTotalGiveRates(Integer totalGiveRates) {
            this.totalGiveRates = totalGiveRates;
        }

        public Integer getTotalBookings() {
            return totalBookings;
        }

        public void setTotalBookings(Integer totalBookings) {
            this.totalBookings = totalBookings;
        }

        public ReferAndEarn getReferAndEarn() {
            return referAndEarn;
        }

        public void setReferAndEarn(ReferAndEarn referAndEarn) {
            this.referAndEarn = referAndEarn;
        }

        public List<LatestService> getLatestServices() {
            return latestServices;
        }

        public void setLatestServices(List<LatestService> latestServices) {
            this.latestServices = latestServices;
        }

        public FacebookLink getFacebookLink() {
            return facebookLink;
        }

        public void setFacebookLink(FacebookLink facebookLink) {
            this.facebookLink = facebookLink;
        }

        public TwitterLink getTwitterLink() {
            return twitterLink;
        }

        public void setTwitterLink(TwitterLink twitterLink) {
            this.twitterLink = twitterLink;
        }

        public InstaLink getInstaLink() {
            return instaLink;
        }

        public void setInstaLink(InstaLink instaLink) {
            this.instaLink = instaLink;
        }

        public YoutubeLink getYoutubeLink() {
            return youtubeLink;
        }

        public void setYoutubeLink(YoutubeLink youtubeLink) {
            this.youtubeLink = youtubeLink;
        }

        public LinkedinLink getLinkedinLink() {
            return linkedinLink;
        }

        public void setLinkedinLink(LinkedinLink linkedinLink) {
            this.linkedinLink = linkedinLink;
        }

        public PinterestLink getPinterestLink() {
            return pinterestLink;
        }

        public void setPinterestLink(PinterestLink pinterestLink) {
            this.pinterestLink = pinterestLink;
        }
        public class SubsubCategory {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("category_id")
            @Expose
            private Integer categoryId;
            @SerializedName("sub_category_id")
            @Expose
            private Integer subCategoryId;
            @SerializedName("icon")
            @Expose
            private String icon;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("slug")
            @Expose
            private String slug;
            @SerializedName("short_description")
            @Expose
            private String shortDescription;
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

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }

            public String getShortDescription() {
                return shortDescription;
            }

            public void setShortDescription(String shortDescription) {
                this.shortDescription = shortDescription;
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
        public class Category {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("icon")
            @Expose
            private String icon;
            @SerializedName("slug")
            @Expose
            private String slug;
            @SerializedName("reviews_heading")
            @Expose
            private String reviewsHeading;
            @SerializedName("reviews_title")
            @Expose
            private String reviewsTitle;
            @SerializedName("faq_title")
            @Expose
            private String faqTitle;
            @SerializedName("short_description")
            @Expose
            private String shortDescription;
            @SerializedName("about_category")
            @Expose
            private String aboutCategory;
            @SerializedName("status")
            @Expose
            private Integer status;
            @SerializedName("meta_title")
            @Expose
            private String metaTitle;
            @SerializedName("meta_keywords")
            @Expose
            private String metaKeywords;
            @SerializedName("meta_description")
            @Expose
            private String metaDescription;
            @SerializedName("avg_rating")
            @Expose
            private Integer avgRating;
            @SerializedName("banner_title")
            @Expose
            private String bannerTitle;
            @SerializedName("banner_description")
            @Expose
            private String bannerDescription;
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

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }

            public String getReviewsHeading() {
                return reviewsHeading;
            }

            public void setReviewsHeading(String reviewsHeading) {
                this.reviewsHeading = reviewsHeading;
            }

            public String getReviewsTitle() {
                return reviewsTitle;
            }

            public void setReviewsTitle(String reviewsTitle) {
                this.reviewsTitle = reviewsTitle;
            }

            public String getFaqTitle() {
                return faqTitle;
            }

            public void setFaqTitle(String faqTitle) {
                this.faqTitle = faqTitle;
            }

            public String getShortDescription() {
                return shortDescription;
            }

            public void setShortDescription(String shortDescription) {
                this.shortDescription = shortDescription;
            }

            public String getAboutCategory() {
                return aboutCategory;
            }

            public void setAboutCategory(String aboutCategory) {
                this.aboutCategory = aboutCategory;
            }

            public Integer getStatus() {
                return status;
            }

            public void setStatus(Integer status) {
                this.status = status;
            }

            public String getMetaTitle() {
                return metaTitle;
            }

            public void setMetaTitle(String metaTitle) {
                this.metaTitle = metaTitle;
            }

            public String getMetaKeywords() {
                return metaKeywords;
            }

            public void setMetaKeywords(String metaKeywords) {
                this.metaKeywords = metaKeywords;
            }

            public String getMetaDescription() {
                return metaDescription;
            }

            public void setMetaDescription(String metaDescription) {
                this.metaDescription = metaDescription;
            }

            public Integer getAvgRating() {
                return avgRating;
            }

            public void setAvgRating(Integer avgRating) {
                this.avgRating = avgRating;
            }

            public String getBannerTitle() {
                return bannerTitle;
            }

            public void setBannerTitle(String bannerTitle) {
                this.bannerTitle = bannerTitle;
            }

            public String getBannerDescription() {
                return bannerDescription;
            }

            public void setBannerDescription(String bannerDescription) {
                this.bannerDescription = bannerDescription;
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

        public class Deal {

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
            private Object packageCategoryId;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("video")
            @Expose
            private String video;
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
            private String active;
            @SerializedName("active_till")
            @Expose
            private String activeTill;
            @SerializedName("deal_slug")
            @Expose
            private Object dealSlug;
            @SerializedName("vendor_commission")
            @Expose
            private Integer vendorCommission;
            @SerializedName("timer")
            @Expose
            private Object timer;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose



            private String updatedAt;

            @SerializedName("get_rating")
            @Expose
            private GetRating__1 getRating;

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

            public Object getPackageCategoryId() {
                return packageCategoryId;
            }

            public void setPackageCategoryId(Object packageCategoryId) {
                this.packageCategoryId = packageCategoryId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getVideo() {
                return video;
            }

            public void setVideo(String video) {
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

            public String getActive() {
                return active;
            }

            public void setActive(String active) {
                this.active = active;
            }

            public String getActiveTill() {
                return activeTill;
            }

            public void setActiveTill(String activeTill) {
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

            public Object getTimer() {
                return timer;
            }

            public void setTimer(Object timer) {
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

            public GetRating__1 getGetRating() {
                return getRating;
            }

            public void setGetRating(GetRating__1 getRating) {
                this.getRating = getRating;
            }



        }
        public class GetRating__1 {

            @SerializedName("rating")
            @Expose
            private Float rating;
            @SerializedName("user_count")
            @Expose
            private Integer userCount;

            public Float getRating() {
                return rating;
            }

            public void setRating(Float rating) {
                this.rating = rating;
            }

            public Integer getUserCount() {
                return userCount;
            }

            public void setUserCount(Integer userCount) {
                this.userCount = userCount;
            }

        }
        public class SubCategory__1 {

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
        public class SubsubCategory__1 {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("category_id")
            @Expose
            private Integer categoryId;
            @SerializedName("sub_category_id")
            @Expose
            private Integer subCategoryId;
            @SerializedName("icon")
            @Expose
            private String icon;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("slug")
            @Expose
            private String slug;
            @SerializedName("short_description")
            @Expose
            private String shortDescription;
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

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }

            public String getShortDescription() {
                return shortDescription;
            }

            public void setShortDescription(String shortDescription) {
                this.shortDescription = shortDescription;
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
        public class PackageCategory {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("subcat_id")
            @Expose
            private Integer subcatId;
            @SerializedName("subsub_category_id")
            @Expose
            private Integer subsubCategoryId;
            @SerializedName("name")
            @Expose
            private String name;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public Integer getSubcatId() {
                return subcatId;
            }

            public void setSubcatId(Integer subcatId) {
                this.subcatId = subcatId;
            }

            public Integer getSubsubCategoryId() {
                return subsubCategoryId;
            }

            public void setSubsubCategoryId(Integer subsubCategoryId) {
                this.subsubCategoryId = subsubCategoryId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

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

            @SerializedName("get_rating")
            @Expose
            private GetRating getRating;

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

            public GetRating getGetRating() {
                return getRating;
            }

            public void setGetRating(GetRating getRating) {
                this.getRating = getRating;
            }
        }

        public class GetRating {

            @SerializedName("rating")
            @Expose
            private Float rating;
            @SerializedName("user_count")
            @Expose
            private Float userCount;

            public Float getRating() {
                return rating;
            }

            public void setRating(Float rating) {
                this.rating = rating;
            }

            public Float getUserCount() {
                return userCount;
            }

            public void setUserCount(Float userCount) {
                this.userCount = userCount;
            }

        }
        public class ReferAndEarn {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("slug")
            @Expose
            private String slug;
            @SerializedName("heading")
            @Expose
            private String heading;
            @SerializedName("title")
            @Expose
            private String title;
            @SerializedName("description")
            @Expose
            private Object description;
            @SerializedName("images")
            @Expose
            private String images;
            @SerializedName("categories_ids")
            @Expose
            private Object categoriesIds;
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

            public String getHeading() {
                return heading;
            }

            public void setHeading(String heading) {
                this.heading = heading;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public Object getDescription() {
                return description;
            }

            public void setDescription(Object description) {
                this.description = description;
            }

            public String getImages() {
                return images;
            }

            public void setImages(String images) {
                this.images = images;
            }

            public Object getCategoriesIds() {
                return categoriesIds;
            }

            public void setCategoriesIds(Object categoriesIds) {
                this.categoriesIds = categoriesIds;
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
        public class YoutubeLink {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("slug")
            @Expose
            private String slug;
            @SerializedName("link")
            @Expose
            private String link;
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

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
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
        public class FacebookLink {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("slug")
            @Expose
            private String slug;
            @SerializedName("link")
            @Expose
            private String link;
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

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
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
        public class TwitterLink {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("slug")
            @Expose
            private String slug;
            @SerializedName("link")
            @Expose
            private String link;
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

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
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

        public class InstaLink {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("slug")
            @Expose
            private String slug;
            @SerializedName("link")
            @Expose
            private String link;
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

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
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
        public class LatestService {

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
            private String detailImage;
            @SerializedName("description")
            @Expose
            private String description;
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

        }

        public class LinkedinLink {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("slug")
            @Expose
            private String slug;
            @SerializedName("link")
            @Expose
            private String link;
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

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
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
        public class PinterestLink {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("slug")
            @Expose
            private String slug;
            @SerializedName("link")
            @Expose
            private String link;
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

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
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