package com.serviingo.serviingo.modelrepo.Responsee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class IncompletedBookingRepo {

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

        @SerializedName("incomplete_orders")
        @Expose
        private IncompleteOrders incompleteOrders;

        public IncompleteOrders getIncompleteOrders() {
            return incompleteOrders;
        }

        public void setIncompleteOrders(IncompleteOrders incompleteOrders) {
            this.incompleteOrders = incompleteOrders;
        }

        public class IncompleteOrders {

            @SerializedName("current_page")
            @Expose
            private Integer currentPage;
            @SerializedName("data")
            @Expose
            private List<Datum> data = null;
            @SerializedName("first_page_url")
            @Expose
            private String firstPageUrl;
            @SerializedName("from")
            @Expose
            private Integer from;
            @SerializedName("last_page")
            @Expose
            private Integer lastPage;
            @SerializedName("last_page_url")
            @Expose
            private String lastPageUrl;
            @SerializedName("next_page_url")
            @Expose
            private Object nextPageUrl;
            @SerializedName("path")
            @Expose
            private String path;
            @SerializedName("per_page")
            @Expose
            private Integer perPage;
            @SerializedName("prev_page_url")
            @Expose
            private Object prevPageUrl;
            @SerializedName("to")
            @Expose
            private Integer to;
            @SerializedName("total")
            @Expose
            private Integer total;

            public Integer getCurrentPage() {
                return currentPage;
            }

            public void setCurrentPage(Integer currentPage) {
                this.currentPage = currentPage;
            }

            public List<Datum> getData() {
                return data;
            }

            public void setData(List<Datum> data) {
                this.data = data;
            }

            public String getFirstPageUrl() {
                return firstPageUrl;
            }

            public void setFirstPageUrl(String firstPageUrl) {
                this.firstPageUrl = firstPageUrl;
            }

            public Integer getFrom() {
                return from;
            }

            public void setFrom(Integer from) {
                this.from = from;
            }

            public Integer getLastPage() {
                return lastPage;
            }

            public void setLastPage(Integer lastPage) {
                this.lastPage = lastPage;
            }

            public String getLastPageUrl() {
                return lastPageUrl;
            }

            public void setLastPageUrl(String lastPageUrl) {
                this.lastPageUrl = lastPageUrl;
            }


            public Object getNextPageUrl() {
                return nextPageUrl;
            }

            public void setNextPageUrl(Object nextPageUrl) {
                this.nextPageUrl = nextPageUrl;
            }

            public String getPath() {
                return path;
            }

            public void setPath(String path) {
                this.path = path;
            }

            public Integer getPerPage() {
                return perPage;
            }

            public void setPerPage(Integer perPage) {
                this.perPage = perPage;
            }

            public Object getPrevPageUrl() {
                return prevPageUrl;
            }

            public void setPrevPageUrl(Object prevPageUrl) {
                this.prevPageUrl = prevPageUrl;
            }

            public Integer getTo() {
                return to;
            }

            public void setTo(Integer to) {
                this.to = to;
            }

            public Integer getTotal() {
                return total;
            }

            public void setTotal(Integer total) {
                this.total = total;
            }

            public class Datum {

                @SerializedName("id")
                @Expose
                private Integer id;
                @SerializedName("user_id")
                @Expose
                private Integer userId;
                @SerializedName("package_id")
                @Expose
                private Integer packageId;
                @SerializedName("addons")
                @Expose
                private String addons;
                @SerializedName("cart_details")
                @Expose
                private String cartDetails;
                @SerializedName("sub_amount")
                @Expose
                private Integer subAmount;
                @SerializedName("discount_amount")
                @Expose
                private Integer discountAmount;
                @SerializedName("hygiene_fees")
                @Expose
                private Integer hygieneFees;
                @SerializedName("membership_discount")
                @Expose
                private Integer membershipDiscount;
                @SerializedName("total_amount")
                @Expose
                private Integer totalAmount;
                @SerializedName("name")
                @Expose
                private Object name;
                @SerializedName("email")
                @Expose
                private Object email;
                @SerializedName("mobile_number")
                @Expose
                private Object mobileNumber;
                @SerializedName("address")
                @Expose
                private Object address;
                @SerializedName("landmark")
                @Expose
                private Object landmark;
                @SerializedName("state_id")
                @Expose
                private Object stateId;
                @SerializedName("city_id")
                @Expose
                private Object cityId;
                @SerializedName("membership_id")
                @Expose
                private Object membershipId;
                @SerializedName("membership_cost")
                @Expose
                private Object membershipCost;
                @SerializedName("payment_method")
                @Expose
                private Object paymentMethod;
                @SerializedName("device_type")
                @Expose
                private String deviceType;
                @SerializedName("device_info")
                @Expose
                private String deviceInfo;
                @SerializedName("system_ip")
                @Expose
                private String systemIp;
                @SerializedName("serve_date")
                @Expose
                private String serveDate;
                @SerializedName("serve_time")
                @Expose
                private String serveTime;
                @SerializedName("user_register_type")
                @Expose
                private String userRegisterType;
                @SerializedName("go_to_checkout")
                @Expose
                private String goToCheckout;
                @SerializedName("created_at")
                @Expose
                private String createdAt;
                @SerializedName("updated_at")
                @Expose
                private String updatedAt;
                @SerializedName("get_user_info")
                @Expose
                private GetUserInfo getUserInfo;
                @SerializedName("serving_datetime")
                @Expose
                private String serving_datetime;
                @SerializedName("temp_created_time")
                @Expose
                private String temp_created_time;



                @SerializedName("get_package_info")
                @Expose
                private GetPackageInfo getPackageInfo;

                public Integer getId() {
                    return id;
                }

                public void setId(Integer id) {
                    this.id = id;
                }

                public Integer getUserId() {
                    return userId;
                }

                public void setUserId(Integer userId) {
                    this.userId = userId;
                }

                public Integer getPackageId() {
                    return packageId;
                }

                public void setPackageId(Integer packageId) {
                    this.packageId = packageId;
                }

                public String getAddons() {
                    return addons;
                }

                public void setAddons(String addons) {
                    this.addons = addons;
                }

                public String getCartDetails() {
                    return cartDetails;
                }

                public void setCartDetails(String cartDetails) {
                    this.cartDetails = cartDetails;
                }

                public Integer getSubAmount() {
                    return subAmount;
                }

                public void setSubAmount(Integer subAmount) {
                    this.subAmount = subAmount;
                }

                public Integer getDiscountAmount() {
                    return discountAmount;
                }

                public void setDiscountAmount(Integer discountAmount) {
                    this.discountAmount = discountAmount;
                }
                public String getTemp_created_time() {
                    return temp_created_time;
                }

                public void setTemp_created_time(String temp_created_time) {
                    this.temp_created_time = temp_created_time;
                }
                public Integer getHygieneFees() {
                    return hygieneFees;
                }

                public void setHygieneFees(Integer hygieneFees) {
                    this.hygieneFees = hygieneFees;
                }

                public Integer getMembershipDiscount() {
                    return membershipDiscount;
                }

                public void setMembershipDiscount(Integer membershipDiscount) {
                    this.membershipDiscount = membershipDiscount;
                }
                public String getServing_datetime() {
                    return serving_datetime;
                }

                public void setServing_datetime(String serving_datetime) {
                    this.serving_datetime = serving_datetime;
                }

                public Integer getTotalAmount() {
                    return totalAmount;
                }

                public void setTotalAmount(Integer totalAmount) {
                    this.totalAmount = totalAmount;
                }

                public Object getName() {
                    return name;
                }

                public void setName(Object name) {
                    this.name = name;
                }

                public Object getEmail() {
                    return email;
                }

                public void setEmail(Object email) {
                    this.email = email;
                }

                public Object getMobileNumber() {
                    return mobileNumber;
                }

                public void setMobileNumber(Object mobileNumber) {
                    this.mobileNumber = mobileNumber;
                }

                public Object getAddress() {
                    return address;
                }

                public void setAddress(Object address) {
                    this.address = address;
                }

                public Object getLandmark() {
                    return landmark;
                }

                public void setLandmark(Object landmark) {
                    this.landmark = landmark;
                }

                public Object getStateId() {
                    return stateId;
                }

                public void setStateId(Object stateId) {
                    this.stateId = stateId;
                }

                public Object getCityId() {
                    return cityId;
                }

                public void setCityId(Object cityId) {
                    this.cityId = cityId;
                }

                public Object getMembershipId() {
                    return membershipId;
                }

                public void setMembershipId(Object membershipId) {
                    this.membershipId = membershipId;
                }

                public Object getMembershipCost() {
                    return membershipCost;
                }

                public void setMembershipCost(Object membershipCost) {
                    this.membershipCost = membershipCost;
                }

                public Object getPaymentMethod() {
                    return paymentMethod;
                }

                public void setPaymentMethod(Object paymentMethod) {
                    this.paymentMethod = paymentMethod;
                }

                public String getDeviceType() {
                    return deviceType;
                }

                public void setDeviceType(String deviceType) {
                    this.deviceType = deviceType;
                }

                public String getDeviceInfo() {
                    return deviceInfo;
                }

                public void setDeviceInfo(String deviceInfo) {
                    this.deviceInfo = deviceInfo;
                }

                public String getSystemIp() {
                    return systemIp;
                }

                public void setSystemIp(String systemIp) {
                    this.systemIp = systemIp;
                }

                public String getServeDate() {
                    return serveDate;
                }

                public void setServeDate(String serveDate) {
                    this.serveDate = serveDate;
                }

                public String getServeTime() {
                    return serveTime;
                }

                public void setServeTime(String serveTime) {
                    this.serveTime = serveTime;
                }

                public String getUserRegisterType() {
                    return userRegisterType;
                }

                public void setUserRegisterType(String userRegisterType) {
                    this.userRegisterType = userRegisterType;
                }

                public String getGoToCheckout() {
                    return goToCheckout;
                }

                public void setGoToCheckout(String goToCheckout) {
                    this.goToCheckout = goToCheckout;
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

                public GetPackageInfo getGetPackageInfo() {
                    return getPackageInfo;
                }

                public void setGetPackageInfo(GetPackageInfo getPackageInfo) {
                    this.getPackageInfo = getPackageInfo;
                }

                public class GetPackageInfo {

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


                    @SerializedName("package_image")
                    @Expose
                    private PackageImage packageImage;

                    public PackageImage getPackageImage() {
                        return packageImage;
                    }

                    public void setPackageImage(PackageImage packageImage) {
                        this.packageImage = packageImage;
                    }

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

                public class GetUserInfo {

                    @SerializedName("id")
                    @Expose
                    private Integer id;
                    @SerializedName("permission_id")
                    @Expose
                    private Object permissionId;
                    @SerializedName("referral_user_id")
                    @Expose
                    private Object referralUserId;
                    @SerializedName("referral_master_id")
                    @Expose
                    private Integer referralMasterId;
                    @SerializedName("name")
                    @Expose
                    private String name;
                    @SerializedName("email")
                    @Expose
                    private String email;
                    @SerializedName("mobile_number")
                    @Expose
                    private String mobileNumber;
                    @SerializedName("state_id")
                    @Expose
                    private Integer stateId;
                    @SerializedName("city_id")
                    @Expose
                    private Integer cityId;
                    @SerializedName("category_id")
                    @Expose
                    private Object categoryId;
                    @SerializedName("sub_category_id")
                    @Expose
                    private Object subCategoryId;
                    @SerializedName("service_id")
                    @Expose
                    private Object serviceId;
                    @SerializedName("profile_pic")
                    @Expose
                    private Object profilePic;
                    @SerializedName("role")
                    @Expose
                    private String role;
                    @SerializedName("gender")
                    @Expose
                    private String gender;
                    @SerializedName("pincode")
                    @Expose
                    private String pincode;
                    @SerializedName("address")
                    @Expose
                    private String address;
                    @SerializedName("first_name")
                    @Expose
                    private Object firstName;
                    @SerializedName("last_name")
                    @Expose
                    private Object lastName;
                    @SerializedName("business_type")
                    @Expose
                    private Object businessType;
                    @SerializedName("website")
                    @Expose
                    private Object website;
                    @SerializedName("referral_id")
                    @Expose
                    private Object referralId;
                    @SerializedName("full_address")
                    @Expose
                    private Object fullAddress;
                    @SerializedName("pan_card_number")
                    @Expose
                    private Object panCardNumber;
                    @SerializedName("aadhaar_card_number")
                    @Expose
                    private Object aadhaarCardNumber;
                    @SerializedName("business_proof_number")
                    @Expose
                    private Object businessProofNumber;
                    @SerializedName("business_address")
                    @Expose
                    private Object businessAddress;
                    @SerializedName("account_type")
                    @Expose
                    private Object accountType;
                    @SerializedName("account_name")
                    @Expose
                    private Object accountName;
                    @SerializedName("account_number")
                    @Expose
                    private Object accountNumber;
                    @SerializedName("ifsc_code")
                    @Expose
                    private Object ifscCode;
                    @SerializedName("bank_name")
                    @Expose
                    private Object bankName;
                    @SerializedName("bank_branch")
                    @Expose
                    private Object bankBranch;
                    @SerializedName("pan_card_document")
                    @Expose
                    private Object panCardDocument;
                    @SerializedName("aadhaar_card_front")
                    @Expose
                    private Object aadhaarCardFront;
                    @SerializedName("aadhaar_card_back")
                    @Expose
                    private Object aadhaarCardBack;
                    @SerializedName("business_proof_document")
                    @Expose
                    private Object businessProofDocument;
                    @SerializedName("cancelled_cheque_img")
                    @Expose
                    private Object cancelledChequeImg;
                    @SerializedName("photographs")
                    @Expose
                    private Object photographs;
                    @SerializedName("other_documents")
                    @Expose
                    private Object otherDocuments;
                    @SerializedName("country_id")
                    @Expose
                    private String countryId;
                    @SerializedName("landmark")
                    @Expose
                    private String landmark;
                    @SerializedName("status")
                    @Expose
                    private Integer status;
                    @SerializedName("email_verified_at")
                    @Expose
                    private String emailVerifiedAt;
                    @SerializedName("current_team_id")
                    @Expose
                    private Object currentTeamId;
                    @SerializedName("profile_photo_path")
                    @Expose
                    private Object profilePhotoPath;
                    @SerializedName("wallet_amount")
                    @Expose
                    private String walletAmount;
                    @SerializedName("unique_id")
                    @Expose
                    private String uniqueId;
                    @SerializedName("total_loan")
                    @Expose
                    private Integer totalLoan;
                    @SerializedName("remaining_loan")
                    @Expose
                    private Integer remainingLoan;
                    @SerializedName("dob")
                    @Expose
                    private Object dob;
                    @SerializedName("father_name")
                    @Expose
                    private Object fatherName;
                    @SerializedName("sender_amount")
                    @Expose
                    private Integer senderAmount;
                    @SerializedName("receiver_amount")
                    @Expose
                    private Integer receiverAmount;
                    @SerializedName("sender_referral_status")
                    @Expose
                    private String senderReferralStatus;
                    @SerializedName("receiver_referral_status")
                    @Expose
                    private String receiverReferralStatus;
                    @SerializedName("serve_state_id")
                    @Expose
                    private Object serveStateId;
                    @SerializedName("serve_city_id")
                    @Expose
                    private Object serveCityId;
                    @SerializedName("serve_pincodes")
                    @Expose
                    private Object servePincodes;
                    @SerializedName("mobile_verified")
                    @Expose
                    private String mobileVerified;
                    @SerializedName("vaccinated")
                    @Expose
                    private String vaccinated;
                    @SerializedName("vaccine_file")
                    @Expose
                    private Object vaccineFile;
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

                    public Object getPermissionId() {
                        return permissionId;
                    }

                    public void setPermissionId(Object permissionId) {
                        this.permissionId = permissionId;
                    }

                    public Object getReferralUserId() {
                        return referralUserId;
                    }

                    public void setReferralUserId(Object referralUserId) {
                        this.referralUserId = referralUserId;
                    }

                    public Integer getReferralMasterId() {
                        return referralMasterId;
                    }

                    public void setReferralMasterId(Integer referralMasterId) {
                        this.referralMasterId = referralMasterId;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
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

                    public Object getCategoryId() {
                        return categoryId;
                    }

                    public void setCategoryId(Object categoryId) {
                        this.categoryId = categoryId;
                    }

                    public Object getSubCategoryId() {
                        return subCategoryId;
                    }

                    public void setSubCategoryId(Object subCategoryId) {
                        this.subCategoryId = subCategoryId;
                    }

                    public Object getServiceId() {
                        return serviceId;
                    }

                    public void setServiceId(Object serviceId) {
                        this.serviceId = serviceId;
                    }

                    public Object getProfilePic() {
                        return profilePic;
                    }

                    public void setProfilePic(Object profilePic) {
                        this.profilePic = profilePic;
                    }

                    public String getRole() {
                        return role;
                    }

                    public void setRole(String role) {
                        this.role = role;
                    }

                    public String getGender() {
                        return gender;
                    }

                    public void setGender(String gender) {
                        this.gender = gender;
                    }

                    public String getPincode() {
                        return pincode;
                    }

                    public void setPincode(String pincode) {
                        this.pincode = pincode;
                    }

                    public String getAddress() {
                        return address;
                    }

                    public void setAddress(String address) {
                        this.address = address;
                    }

                    public Object getFirstName() {
                        return firstName;
                    }

                    public void setFirstName(Object firstName) {
                        this.firstName = firstName;
                    }

                    public Object getLastName() {
                        return lastName;
                    }

                    public void setLastName(Object lastName) {
                        this.lastName = lastName;
                    }

                    public Object getBusinessType() {
                        return businessType;
                    }

                    public void setBusinessType(Object businessType) {
                        this.businessType = businessType;
                    }

                    public Object getWebsite() {
                        return website;
                    }

                    public void setWebsite(Object website) {
                        this.website = website;
                    }

                    public Object getReferralId() {
                        return referralId;
                    }

                    public void setReferralId(Object referralId) {
                        this.referralId = referralId;
                    }

                    public Object getFullAddress() {
                        return fullAddress;
                    }

                    public void setFullAddress(Object fullAddress) {
                        this.fullAddress = fullAddress;
                    }

                    public Object getPanCardNumber() {
                        return panCardNumber;
                    }

                    public void setPanCardNumber(Object panCardNumber) {
                        this.panCardNumber = panCardNumber;
                    }

                    public Object getAadhaarCardNumber() {
                        return aadhaarCardNumber;
                    }

                    public void setAadhaarCardNumber(Object aadhaarCardNumber) {
                        this.aadhaarCardNumber = aadhaarCardNumber;
                    }

                    public Object getBusinessProofNumber() {
                        return businessProofNumber;
                    }

                    public void setBusinessProofNumber(Object businessProofNumber) {
                        this.businessProofNumber = businessProofNumber;
                    }

                    public Object getBusinessAddress() {
                        return businessAddress;
                    }

                    public void setBusinessAddress(Object businessAddress) {
                        this.businessAddress = businessAddress;
                    }

                    public Object getAccountType() {
                        return accountType;
                    }

                    public void setAccountType(Object accountType) {
                        this.accountType = accountType;
                    }

                    public Object getAccountName() {
                        return accountName;
                    }

                    public void setAccountName(Object accountName) {
                        this.accountName = accountName;
                    }

                    public Object getAccountNumber() {
                        return accountNumber;
                    }

                    public void setAccountNumber(Object accountNumber) {
                        this.accountNumber = accountNumber;
                    }

                    public Object getIfscCode() {
                        return ifscCode;
                    }

                    public void setIfscCode(Object ifscCode) {
                        this.ifscCode = ifscCode;
                    }

                    public Object getBankName() {
                        return bankName;
                    }

                    public void setBankName(Object bankName) {
                        this.bankName = bankName;
                    }

                    public Object getBankBranch() {
                        return bankBranch;
                    }

                    public void setBankBranch(Object bankBranch) {
                        this.bankBranch = bankBranch;
                    }

                    public Object getPanCardDocument() {
                        return panCardDocument;
                    }

                    public void setPanCardDocument(Object panCardDocument) {
                        this.panCardDocument = panCardDocument;
                    }

                    public Object getAadhaarCardFront() {
                        return aadhaarCardFront;
                    }

                    public void setAadhaarCardFront(Object aadhaarCardFront) {
                        this.aadhaarCardFront = aadhaarCardFront;
                    }

                    public Object getAadhaarCardBack() {
                        return aadhaarCardBack;
                    }

                    public void setAadhaarCardBack(Object aadhaarCardBack) {
                        this.aadhaarCardBack = aadhaarCardBack;
                    }

                    public Object getBusinessProofDocument() {
                        return businessProofDocument;
                    }

                    public void setBusinessProofDocument(Object businessProofDocument) {
                        this.businessProofDocument = businessProofDocument;
                    }

                    public Object getCancelledChequeImg() {
                        return cancelledChequeImg;
                    }

                    public void setCancelledChequeImg(Object cancelledChequeImg) {
                        this.cancelledChequeImg = cancelledChequeImg;
                    }

                    public Object getPhotographs() {
                        return photographs;
                    }

                    public void setPhotographs(Object photographs) {
                        this.photographs = photographs;
                    }

                    public Object getOtherDocuments() {
                        return otherDocuments;
                    }

                    public void setOtherDocuments(Object otherDocuments) {
                        this.otherDocuments = otherDocuments;
                    }

                    public String getCountryId() {
                        return countryId;
                    }

                    public void setCountryId(String countryId) {
                        this.countryId = countryId;
                    }

                    public String getLandmark() {
                        return landmark;
                    }

                    public void setLandmark(String landmark) {
                        this.landmark = landmark;
                    }

                    public Integer getStatus() {
                        return status;
                    }

                    public void setStatus(Integer status) {
                        this.status = status;
                    }

                    public String getEmailVerifiedAt() {
                        return emailVerifiedAt;
                    }

                    public void setEmailVerifiedAt(String emailVerifiedAt) {
                        this.emailVerifiedAt = emailVerifiedAt;
                    }

                    public Object getCurrentTeamId() {
                        return currentTeamId;
                    }

                    public void setCurrentTeamId(Object currentTeamId) {
                        this.currentTeamId = currentTeamId;
                    }

                    public Object getProfilePhotoPath() {
                        return profilePhotoPath;
                    }

                    public void setProfilePhotoPath(Object profilePhotoPath) {
                        this.profilePhotoPath = profilePhotoPath;
                    }

                    public String getWalletAmount() {
                        return walletAmount;
                    }

                    public void setWalletAmount(String walletAmount) {
                        this.walletAmount = walletAmount;
                    }

                    public String getUniqueId() {
                        return uniqueId;
                    }

                    public void setUniqueId(String uniqueId) {
                        this.uniqueId = uniqueId;
                    }

                    public Integer getTotalLoan() {
                        return totalLoan;
                    }

                    public void setTotalLoan(Integer totalLoan) {
                        this.totalLoan = totalLoan;
                    }

                    public Integer getRemainingLoan() {
                        return remainingLoan;
                    }

                    public void setRemainingLoan(Integer remainingLoan) {
                        this.remainingLoan = remainingLoan;
                    }

                    public Object getDob() {
                        return dob;
                    }

                    public void setDob(Object dob) {
                        this.dob = dob;
                    }

                    public Object getFatherName() {
                        return fatherName;
                    }

                    public void setFatherName(Object fatherName) {
                        this.fatherName = fatherName;
                    }

                    public Integer getSenderAmount() {
                        return senderAmount;
                    }

                    public void setSenderAmount(Integer senderAmount) {
                        this.senderAmount = senderAmount;
                    }

                    public Integer getReceiverAmount() {
                        return receiverAmount;
                    }

                    public void setReceiverAmount(Integer receiverAmount) {
                        this.receiverAmount = receiverAmount;
                    }

                    public String getSenderReferralStatus() {
                        return senderReferralStatus;
                    }

                    public void setSenderReferralStatus(String senderReferralStatus) {
                        this.senderReferralStatus = senderReferralStatus;
                    }

                    public String getReceiverReferralStatus() {
                        return receiverReferralStatus;
                    }

                    public void setReceiverReferralStatus(String receiverReferralStatus) {
                        this.receiverReferralStatus = receiverReferralStatus;
                    }

                    public Object getServeStateId() {
                        return serveStateId;
                    }

                    public void setServeStateId(Object serveStateId) {
                        this.serveStateId = serveStateId;
                    }

                    public Object getServeCityId() {
                        return serveCityId;
                    }

                    public void setServeCityId(Object serveCityId) {
                        this.serveCityId = serveCityId;
                    }

                    public Object getServePincodes() {
                        return servePincodes;
                    }

                    public void setServePincodes(Object servePincodes) {
                        this.servePincodes = servePincodes;
                    }

                    public String getMobileVerified() {
                        return mobileVerified;
                    }

                    public void setMobileVerified(String mobileVerified) {
                        this.mobileVerified = mobileVerified;
                    }

                    public String getVaccinated() {
                        return vaccinated;
                    }

                    public void setVaccinated(String vaccinated) {
                        this.vaccinated = vaccinated;
                    }

                    public Object getVaccineFile() {
                        return vaccineFile;
                    }

                    public void setVaccineFile(Object vaccineFile) {
                        this.vaccineFile = vaccineFile;
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


    }
}