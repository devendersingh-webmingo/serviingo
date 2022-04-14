package com.serviingo.serviingo.modelrepo.Responsee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MyRatingAndReviewRespooo {
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

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

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }
    public class Datum {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("user_id")
        @Expose
        private String userId;
        @SerializedName("package_id")
        @Expose
        private String packageId;
        @SerializedName("addons")
        @Expose
        private List<Addon> addons = null;
        @SerializedName("order_number")
        @Expose
        private String orderNumber;
        @SerializedName("total_amount")
        @Expose
        private String totalAmount;
        @SerializedName("order_status")
        @Expose
        private String orderStatus;
        @SerializedName("created_at")
        @Expose
        private String createdAt;



        @SerializedName("package")
        @Expose
        private Package _package;


        @SerializedName("vendor_some_info")
        @Expose
        private VendorSomeInfo vendorSomeInfo;

        @SerializedName("serving_datetime")
        @Expose
        private String serving_datetime;
        @SerializedName("rating_reviews")
        @Expose
        private RatingReviews ratingReviews;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public List<Addon> getAddons() {
            return addons;
        }

        public VendorSomeInfo getVendorSomeInfo() {
            return vendorSomeInfo;
        }

        public void setVendorSomeInfo(VendorSomeInfo vendorSomeInfo) {
            this.vendorSomeInfo = vendorSomeInfo;
        }

        public String getServing_datetime() {
            return serving_datetime;
        }

        public void setServing_datetime(String serving_datetime) {
            this.serving_datetime = serving_datetime;
        }

        public void setAddons(List<Addon> addons) {
            this.addons = addons;
        }

        public String getOrderNumber() {
            return orderNumber;
        }

        public void setOrderNumber(String orderNumber) {
            this.orderNumber = orderNumber;
        }

        public String getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(String totalAmount) {
            this.totalAmount = totalAmount;
        }

        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public Package getPackage() {
            return _package;
        }

        public void setPackage(Package _package) {
            this._package = _package;
        }

        public RatingReviews getRatingReviews() {
            return ratingReviews;
        }

        public void setRatingReviews(RatingReviews ratingReviews) {
            this.ratingReviews = ratingReviews;
        }

        public class VendorSomeInfo {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("unique_id")
            @Expose
            private String uniqueId;
            @SerializedName("first_name")
            @Expose
            private String firstName;
            @SerializedName("last_name")
            @Expose
            private String lastName;
            @SerializedName("email")
            @Expose
            private String email;
            @SerializedName("mobile_number")
            @Expose
            private String mobileNumber;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUniqueId() {
                return uniqueId;
            }

            public void setUniqueId(String uniqueId) {
                this.uniqueId = uniqueId;
            }

            public String getFirstName() {
                return firstName;
            }

            public void setFirstName(String firstName) {
                this.firstName = firstName;
            }

            public String getLastName() {
                return lastName;
            }

            public void setLastName(String lastName) {
                this.lastName = lastName;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getMobileNumber() {
                return mobileNumber;
            }

            public void setMobileNumber(String mobileNumber) {
                this.mobileNumber = mobileNumber;
            }

        }
        public class Package {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("about_package")
            @Expose
            private Object aboutPackage;
            @SerializedName("package_image")
            @Expose
            private PackageImage packageImage;




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

            public Object getAboutPackage() {
                return aboutPackage;
            }

            public void setAboutPackage(Object aboutPackage) {
                this.aboutPackage = aboutPackage;
            }

            public PackageImage getPackageImage() {
                return packageImage;
            }

            public void setPackageImage(PackageImage packageImage) {
                this.packageImage = packageImage;
            }




            public class PackageImage {

                @SerializedName("base_url")
                @Expose
                private String baseUrl;
                @SerializedName("image")
                @Expose
                private String image;

                public String getBaseUrl() {
                    return baseUrl;
                }

                public void setBaseUrl(String baseUrl) {
                    this.baseUrl = baseUrl;
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

            }

        }
        public class RatingReviews {

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

        }
        public class Addon {

            @SerializedName("id")
            @Expose
            private String id;
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

        }
    }
}
