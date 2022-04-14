package com.serviingo.serviingo.modelrepo.Responsee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PackageReviews {


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

        @SerializedName("reviews")
        @Expose
        private List<Review> reviews = null;

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



            @SerializedName("review_date")
            @Expose
            private String reviewdate;

            public String getReviewdate() {
                return reviewdate;
            }

            public void setReviewdate(String reviewdate) {
                this.reviewdate = reviewdate;
            }

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
                @SerializedName("profile_image_url")
                @Expose
                private String profileImageUrl;

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

                public String getProfileImageUrl() {
                    return profileImageUrl;
                }

                public void setProfileImageUrl(String profileImageUrl) {
                    this.profileImageUrl = profileImageUrl;
                }


            }

        }
    }
}

