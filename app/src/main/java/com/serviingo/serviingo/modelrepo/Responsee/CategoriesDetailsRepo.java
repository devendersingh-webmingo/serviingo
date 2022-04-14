package com.serviingo.serviingo.modelrepo.Responsee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoriesDetailsRepo {



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
        @SerializedName("category")
        @Expose
        private Category category;
        @SerializedName("how_it_works")
        @Expose
        private List<HowItWork> howItWorks = null;
        @SerializedName("total_give_rates")
        @Expose
        private String totalGiveRates;
       /* @SerializedName("reviews")
        @Expose
        private List<Review> reviews = null;*/
        @SerializedName("faqs")
        @Expose
        private List<Faq> faqs = null;

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

        public Category getCategory() {
            return category;
        }

        public void setCategory(Category category) {
            this.category = category;
        }



        public List<HowItWork> getHowItWorks() {
            return howItWorks;
        }

        public void setHowItWorks(List<HowItWork> howItWorks) {
            this.howItWorks = howItWorks;
        }

        public String getTotalGiveRates() {
            return totalGiveRates;
        }

        public void setTotalGiveRates(String totalGiveRates) {
            this.totalGiveRates = totalGiveRates;
        }

     /*   public List<Review> getReviews() {
            return reviews;
        }

        public void setReviews(List<Review> reviews) {
            this.reviews = reviews;
        }*/

        public List<Faq> getFaqs() {
            return faqs;
        }

        public void setFaqs(List<Faq> faqs) {
            this.faqs = faqs;
        }





        public class Category {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("state_id")
            @Expose
            private String stateId;
            @SerializedName("city_id")
            @Expose
            private String cityId;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("icon")
            @Expose
            private String icon;
            @SerializedName("background_image")
            @Expose
            private String backgroundImage;
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
            private String status;
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
            private String avgRating;
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
            private String deletedAt;
            @SerializedName("category_rating")
            @Expose
            private CategoryRating categoryRating;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getStateId() {
                return stateId;
            }

            public void setStateId(String stateId) {
                this.stateId = stateId;
            }

            public String getCityId() {
                return cityId;
            }

            public void setCityId(String cityId) {
                this.cityId = cityId;
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

            public String getBackgroundImage() {
                return backgroundImage;
            }

            public void setBackgroundImage(String backgroundImage) {
                this.backgroundImage = backgroundImage;
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

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
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

            public String getAvgRating() {
                return avgRating;
            }

            public void setAvgRating(String avgRating) {
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

            public String getDeletedAt() {
                return deletedAt;
            }

            public void setDeletedAt(String deletedAt) {
                this.deletedAt = deletedAt;
            }

            public CategoryRating getCategoryRating() {
                return categoryRating;
            }

            public void setCategoryRating(CategoryRating categoryRating) {
                this.categoryRating = categoryRating;
            }

            public class CategoryRating {

                @SerializedName("avg_rating")
                @Expose
                private String avgRating;
                @SerializedName("total_rate")
                @Expose
                private String totalRate;
                @SerializedName("total_booking")
                @Expose
                private Integer totalBooking;
                @SerializedName("image_base_url")
                @Expose
                private String imageBaseUrl;
                @SerializedName("reviews")
                @Expose
                private List<Review> reviews = null;

                public String getAvgRating() {
                    return avgRating;
                }

                public void setAvgRating(String avgRating) {
                    this.avgRating = avgRating;
                }

                public String getTotalRate() {
                    return totalRate;
                }

                public void setTotalRate(String totalRate) {
                    this.totalRate = totalRate;
                }

                public Integer getTotalBooking() {
                    return totalBooking;
                }

                public void setTotalBooking(Integer totalBooking) {
                    this.totalBooking = totalBooking;
                }

                public String getImageBaseUrl() {
                    return imageBaseUrl;
                }

                public void setImageBaseUrl(String imageBaseUrl) {
                    this.imageBaseUrl = imageBaseUrl;
                }

                public List<Review> getReviews() {
                    return reviews;
                }

                public void setReviews(List<Review> reviews) {
                    this.reviews = reviews;
                }

                public class Review {

                    @SerializedName("id")
                    @Expose
                    private String id;
                    @SerializedName("order_id")
                    @Expose
                    private String orderId;
                    @SerializedName("user_id")
                    @Expose
                    private String userId;
                    @SerializedName("package_id")
                    @Expose
                    private String packageId;
                    @SerializedName("category_id")
                    @Expose
                    private String categoryId;
                    @SerializedName("rating")
                    @Expose
                    private String rating;
                    @SerializedName("review")
                    @Expose
                    private String review;
                    @SerializedName("status")
                    @Expose
                    private String status;
                    @SerializedName("created_at")
                    @Expose
                    private String createdAt;
                    @SerializedName("updated_at")
                    @Expose
                    private String updatedAt;
                    @SerializedName("get_user_info")
                    @Expose
                    private GetUserInfo getUserInfo;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String getOrderId() {
                        return orderId;
                    }

                    public void setOrderId(String orderId) {
                        this.orderId = orderId;
                    }

                    public String getUserId() {
                        return userId;
                    }

                    public void setUserId(String userId) {
                        this.userId = userId;
                    }

                    public String getPackageId() {
                        return packageId;
                    }

                    public void setPackageId(String packageId) {
                        this.packageId = packageId;
                    }

                    public String getCategoryId() {
                        return categoryId;
                    }

                    public void setCategoryId(String categoryId) {
                        this.categoryId = categoryId;
                    }

                    public String getRating() {
                        return rating;
                    }

                    public void setRating(String rating) {
                        this.rating = rating;
                    }

                    public String getReview() {
                        return review;
                    }

                    public void setReview(String review) {
                        this.review = review;
                    }

                    public String getStatus() {
                        return status;
                    }

                    public void setStatus(String status) {
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

                    public GetUserInfo getGetUserInfo() {
                        return getUserInfo;
                    }

                    public void setGetUserInfo(GetUserInfo getUserInfo) {
                        this.getUserInfo = getUserInfo;
                    }



                    public class GetUserInfo {

                        @SerializedName("id")
                        @Expose
                        private String id;
                        @SerializedName("name")
                        @Expose
                        private String name;
                        @SerializedName("profile_photo_path")
                        @Expose
                        private String profilePhotoPath;
                        @SerializedName("state_id")
                        @Expose
                        private String stateId;
                        @SerializedName("city_id")
                        @Expose
                        private String cityId;
                        @SerializedName("get_state")
                        @Expose
                        private GetState getState;
                        @SerializedName("get_city")
                        @Expose
                        private GetCity getCity;

                        public String getId() {
                            return id;
                        }

                        public void setId(String id) {
                            this.id = id;
                        }

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }

                        public String getProfilePhotoPath() {
                            return profilePhotoPath;
                        }

                        public void setProfilePhotoPath(String profilePhotoPath) {
                            this.profilePhotoPath = profilePhotoPath;
                        }

                        public String getStateId() {
                            return stateId;
                        }

                        public void setStateId(String stateId) {
                            this.stateId = stateId;
                        }

                        public String getCityId() {
                            return cityId;
                        }

                        public void setCityId(String cityId) {
                            this.cityId = cityId;
                        }

                        public GetState getGetState() {
                            return getState;
                        }

                        public void setGetState(GetState getState) {
                            this.getState = getState;
                        }

                        public GetCity getGetCity() {
                            return getCity;
                        }

                        public void setGetCity(GetCity getCity) {
                            this.getCity = getCity;
                        }



                        public class GetState {

                            @SerializedName("id")
                            @Expose
                            private String id;
                            @SerializedName("country_id")
                            @Expose
                            private String countryId;
                            @SerializedName("name")
                            @Expose
                            private String name;
                            @SerializedName("created_at")
                            @Expose
                            private String createdAt;
                            @SerializedName("updated_at")
                            @Expose
                            private String updatedAt;

                            public String getId() {
                                return id;
                            }

                            public void setId(String id) {
                                this.id = id;
                            }

                            public String getCountryId() {
                                return countryId;
                            }

                            public void setCountryId(String countryId) {
                                this.countryId = countryId;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
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

                        public class GetCity {

                            @SerializedName("id")
                            @Expose
                            private String id;
                            @SerializedName("state_id")
                            @Expose
                            private String stateId;
                            @SerializedName("name")
                            @Expose
                            private String name;
                            @SerializedName("created_at")
                            @Expose
                            private String createdAt;
                            @SerializedName("updated_at")
                            @Expose
                            private String updatedAt;

                            public String getId() {
                                return id;
                            }

                            public void setId(String id) {
                                this.id = id;
                            }

                            public String getStateId() {
                                return stateId;
                            }

                            public void setStateId(String stateId) {
                                this.stateId = stateId;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
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
            }


        }
      /*  public class Category {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("state_id")
            @Expose
            private String stateId;
            @SerializedName("city_id")
            @Expose
            private String cityId;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("icon")
            @Expose
            private String icon;
            @SerializedName("background_image")
            @Expose
            private String backgroundImage;
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
            private String status;
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
            private String avgRating;
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
            private String deletedAt;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getStateId() {
                return stateId;
            }

            public void setStateId(String stateId) {
                this.stateId = stateId;
            }

            public String getCityId() {
                return cityId;
            }

            public void setCityId(String cityId) {
                this.cityId = cityId;
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

            public String getBackgroundImage() {
                return backgroundImage;
            }

            public void setBackgroundImage(String backgroundImage) {
                this.backgroundImage = backgroundImage;
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

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
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

            public String getAvgRating() {
                return avgRating;
            }

            public void setAvgRating(String avgRating) {
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

            public String getDeletedAt() {
                return deletedAt;
            }

            public void setDeletedAt(String deletedAt) {
                this.deletedAt = deletedAt;
            }

        }
*/
        public class HowItWork {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("category_id")
            @Expose
            private String categoryId;
            @SerializedName("position")
            @Expose
            private String position;
            @SerializedName("title")
            @Expose
            private String title;
            @SerializedName("description")
            @Expose
            private String description;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(String categoryId) {
                this.categoryId = categoryId;
            }

            public String getPosition() {
                return position;
            }

            public void setPosition(String position) {
                this.position = position;
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

       /* public class Review {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("order_id")
            @Expose
            private String orderId;
            @SerializedName("user_id")
            @Expose
            private String userId;
            @SerializedName("package_id")
            @Expose
            private String packageId;
            @SerializedName("category_id")
            @Expose
            private String categoryId;
            @SerializedName("rating")
            @Expose
            private String rating;
            @SerializedName("review")
            @Expose
            private String review;
            @SerializedName("status")
            @Expose
            private String status;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getOrderId() {
                return orderId;
            }

            public void setOrderId(String orderId) {
                this.orderId = orderId;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getPackageId() {
                return packageId;
            }

            public void setPackageId(String packageId) {
                this.packageId = packageId;
            }

            public String getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(String categoryId) {
                this.categoryId = categoryId;
            }

            public String getRating() {
                return rating;
            }

            public void setRating(String rating) {
                this.rating = rating;
            }

            public String getReview() {
                return review;
            }

            public void setReview(String review) {
                this.review = review;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
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

        }*/
        public class Faq {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("category_id")
            @Expose
            private String categoryId;
            @SerializedName("question")
            @Expose
            private String question;
            @SerializedName("answer")
            @Expose
            private String answer;
            @SerializedName("status")
            @Expose
            private String status;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(String categoryId) {
                this.categoryId = categoryId;
            }

            public String getQuestion() {
                return question;
            }

            public void setQuestion(String question) {
                this.question = question;
            }

            public String getAnswer() {
                return answer;
            }

            public void setAnswer(String answer) {
                this.answer = answer;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
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

        }
    }

}
