package com.serviingo.serviingo.modelrepo.Responsee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class GetOrderDetailRepo implements Serializable {


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

      /*  @SerializedName("included_services")
        @Expose
        private List<IncludedService> includedServices = null;
        @SerializedName("order_info")
        @Expose
        private OrderInfo orderInfo;
        @SerializedName("sub_total")
        @Expose
        private String subTotal;
        @SerializedName("discount_amount")
        @Expose
        private Integer discountAmount;
        @SerializedName("hygiene_fees")
        @Expose
        private Integer hygieneFees;
        @SerializedName("total_amount")
        @Expose
        private String totalAmount;

        public List<IncludedService> getIncludedServices() {
            return includedServices;
        }

        public void setIncludedServices(List<IncludedService> includedServices) {
            this.includedServices = includedServices;
        }

        public OrderInfo getOrderInfo() {
            return orderInfo;
        }

        public void setOrderInfo(OrderInfo orderInfo) {
            this.orderInfo = orderInfo;
        }

        public String getSubTotal() {
            return subTotal;
        }

        public void setSubTotal(String subTotal) {
            this.subTotal = subTotal;
        }

        public Integer getDiscountAmount() {
            return discountAmount;
        }

        public void setDiscountAmount(Integer discountAmount) {
            this.discountAmount = discountAmount;
        }

        public Integer getHygieneFees() {
            return hygieneFees;
        }

        public void setHygieneFees(Integer hygieneFees) {
            this.hygieneFees = hygieneFees;
        }

        public String getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(String totalAmount) {
            this.totalAmount = totalAmount;
        }
*/


        @SerializedName("included_services")
        @Expose
        private List<IncludedService> includedServices = null;
        @SerializedName("order_info")
        @Expose
        private OrderInfo orderInfo;
        @SerializedName("service_amount")
        @Expose
        private Integer serviceAmount;
        @SerializedName("addon_amount")
        @Expose
        private Integer addonAmount;
        @SerializedName("sub_total")
        @Expose
        private Integer subTotal;
        @SerializedName("service_discount")
        @Expose
        private Integer serviceDiscount;
        @SerializedName("membership_discount")
        @Expose
        private Integer membershipDiscount;
        @SerializedName("total_discount")
        @Expose
        private Integer totalDiscount;
        @SerializedName("membership_fees")
        @Expose
        private Integer membershipFees;
        @SerializedName("hygiene_fees")
        @Expose
        private Integer hygieneFees;
        @SerializedName("billing_amount")
        @Expose
        private String billingAmount;

        @SerializedName("invoice_url")
        @Expose
        private String invoice_url;


        public String getInvoice_url() {
            return invoice_url;
        }

        public void setInvoice_url(String invoice_url) {
            this.invoice_url = invoice_url;
        }

        public List<IncludedService> getIncludedServices() {
            return includedServices;
        }

        public void setIncludedServices(List<IncludedService> includedServices) {
            this.includedServices = includedServices;
        }

        public OrderInfo getOrderInfo() {
            return orderInfo;
        }

        public void setOrderInfo(OrderInfo orderInfo) {
            this.orderInfo = orderInfo;
        }

        public Integer getServiceAmount() {
            return serviceAmount;
        }

        public void setServiceAmount(Integer serviceAmount) {
            this.serviceAmount = serviceAmount;
        }

        public Integer getAddonAmount() {
            return addonAmount;
        }

        public void setAddonAmount(Integer addonAmount) {
            this.addonAmount = addonAmount;
        }

        public Integer getSubTotal() {
            return subTotal;
        }

        public void setSubTotal(Integer subTotal) {
            this.subTotal = subTotal;
        }

        public Integer getServiceDiscount() {
            return serviceDiscount;
        }

        public void setServiceDiscount(Integer serviceDiscount) {
            this.serviceDiscount = serviceDiscount;
        }

        public Integer getMembershipDiscount() {
            return membershipDiscount;
        }

        public void setMembershipDiscount(Integer membershipDiscount) {
            this.membershipDiscount = membershipDiscount;
        }

        public Integer getTotalDiscount() {
            return totalDiscount;
        }

        public void setTotalDiscount(Integer totalDiscount) {
            this.totalDiscount = totalDiscount;
        }

        public Integer getMembershipFees() {
            return membershipFees;
        }

        public void setMembershipFees(Integer membershipFees) {
            this.membershipFees = membershipFees;
        }

        public Integer getHygieneFees() {
            return hygieneFees;
        }

        public void setHygieneFees(Integer hygieneFees) {
            this.hygieneFees = hygieneFees;
        }

        public String getBillingAmount() {
            return billingAmount;
        }

        public void setBillingAmount(String billingAmount) {
            this.billingAmount = billingAmount;
        }


        public class IncludedService {

            @SerializedName("id")
            @Expose
            private Integer id;
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


        public class OrderInfo {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("user_id")
            @Expose
            private Integer userId;
            @SerializedName("vendor_id")
            @Expose
            private String vendorId;
            @SerializedName("package_id")
            @Expose
            private Integer packageId;
            @SerializedName("addons")
            @Expose
            private List<Addon> addons = null;
            @SerializedName("pincode")
            @Expose
            private String pincode;
            @SerializedName("order_number")
            @Expose
            private String orderNumber;
            @SerializedName("cart_details")
            @Expose
            private String cartDetails;

            @SerializedName("coupon_discount_amount")
            @Expose
            private String coupon_discount_amount;

            public String getCoupon_discount_amount() {
                return coupon_discount_amount;
            }

            public void setCoupon_discount_amount(String coupon_discount_amount) {
                this.coupon_discount_amount = coupon_discount_amount;
            }

            @SerializedName("sub_amount")
            @Expose
            private Integer subAmount;
            @SerializedName("discount_amount")
            @Expose
            private Integer discountAmount;
            @SerializedName("membership_discount")
            @Expose
            private Integer membershipDiscount;
            @SerializedName("total_amount")
            @Expose
            private String totalAmount;
            @SerializedName("tax_name")
            @Expose
            private String taxName;
            @SerializedName("tax_amount")
            @Expose
            private String taxAmount;
            @SerializedName("hygiene_fees")
            @Expose
            private Integer hygieneFees;
            @SerializedName("order_status")
            @Expose
            private String orderStatus;
            @SerializedName("vendor_status")
            @Expose
            private String vendorStatus;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("email")
            @Expose
            private String email;
            @SerializedName("mobile_number")
            @Expose
            private String mobileNumber;
            @SerializedName("address")
            @Expose
            private String address;
            @SerializedName("landmark")
            @Expose
            private String landmark;
            @SerializedName("state_id")
            @Expose
            private Integer stateId;
            @SerializedName("city")
            @Expose
            private String city;
            @SerializedName("cancellation_reasons")
            @Expose
            private String cancellationReasons;
            @SerializedName("cancelled_by")
            @Expose
            private String cancelledBy;
            @SerializedName("payment_method")
            @Expose
            private String paymentMethod;
            @SerializedName("payment_status")
            @Expose
            private String paymentStatus;
            @SerializedName("assigned_status")
            @Expose
            private String assignedStatus;
            @SerializedName("remark")
            @Expose
            private String remark;
            @SerializedName("membership_id")
            @Expose
            private String membershipId;
            @SerializedName("membership_cost")
            @Expose
            private String membershipCost;
            @SerializedName("cgst")
            @Expose
            private String cgst;
            @SerializedName("sgst")
            @Expose
            private String sgst;
            @SerializedName("igst")
            @Expose
            private String igst;
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


            @SerializedName("serving_datetime")
            @Expose
            private String serving_datetime;


            @SerializedName("serve_time")
            @Expose
            private String serveTime;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;
            @SerializedName("package")
            @Expose
            private Package _package;
            public String getServing_datetime() {
                return serving_datetime;
            }

            public void setServing_datetime(String serving_datetime) {
                this.serving_datetime = serving_datetime;
            }


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

            public String getVendorId() {
                return vendorId;
            }

            public void setVendorId(String vendorId) {
                this.vendorId = vendorId;
            }

            public Integer getPackageId() {
                return packageId;
            }

            public void setPackageId(Integer packageId) {
                this.packageId = packageId;
            }

            public List<Addon> getAddons() {
                return addons;
            }

            public void setAddons(List<Addon> addons) {
                this.addons = addons;
            }

            public String getPincode() {
                return pincode;
            }

            public void setPincode(String pincode) {
                this.pincode = pincode;
            }

            public String getOrderNumber() {
                return orderNumber;
            }

            public void setOrderNumber(String orderNumber) {
                this.orderNumber = orderNumber;
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

            public Integer getMembershipDiscount() {
                return membershipDiscount;
            }

            public void setMembershipDiscount(Integer membershipDiscount) {
                this.membershipDiscount = membershipDiscount;
            }

            public String getTotalAmount() {
                return totalAmount;
            }

            public void setTotalAmount(String totalAmount) {
                this.totalAmount = totalAmount;
            }

            public String getTaxName() {
                return taxName;
            }

            public void setTaxName(String taxName) {
                this.taxName = taxName;
            }

            public String getTaxAmount() {
                return taxAmount;
            }

            public void setTaxAmount(String taxAmount) {
                this.taxAmount = taxAmount;
            }

            public Integer getHygieneFees() {
                return hygieneFees;
            }

            public void setHygieneFees(Integer hygieneFees) {
                this.hygieneFees = hygieneFees;
            }

            public String getOrderStatus() {
                return orderStatus;
            }

            public void setOrderStatus(String orderStatus) {
                this.orderStatus = orderStatus;
            }

            public String getVendorStatus() {
                return vendorStatus;
            }

            public void setVendorStatus(String vendorStatus) {
                this.vendorStatus = vendorStatus;
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

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getLandmark() {
                return landmark;
            }

            public void setLandmark(String landmark) {
                this.landmark = landmark;
            }

            public Integer getStateId() {
                return stateId;
            }

            public void setStateId(Integer stateId) {
                this.stateId = stateId;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getCancellationReasons() {
                return cancellationReasons;
            }

            public void setCancellationReasons(String cancellationReasons) {
                this.cancellationReasons = cancellationReasons;
            }

            public String getCancelledBy() {
                return cancelledBy;
            }

            public void setCancelledBy(String cancelledBy) {
                this.cancelledBy = cancelledBy;
            }

            public String getPaymentMethod() {
                return paymentMethod;
            }

            public void setPaymentMethod(String paymentMethod) {
                this.paymentMethod = paymentMethod;
            }

            public String getPaymentStatus() {
                return paymentStatus;
            }

            public void setPaymentStatus(String paymentStatus) {
                this.paymentStatus = paymentStatus;
            }

            public String getAssignedStatus() {
                return assignedStatus;
            }

            public void setAssignedStatus(String assignedStatus) {
                this.assignedStatus = assignedStatus;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getMembershipId() {
                return membershipId;
            }

            public void setMembershipId(String membershipId) {
                this.membershipId = membershipId;
            }

            public String getMembershipCost() {
                return membershipCost;
            }

            public void setMembershipCost(String membershipCost) {
                this.membershipCost = membershipCost;
            }

            public String getCgst() {
                return cgst;
            }

            public void setCgst(String cgst) {
                this.cgst = cgst;
            }

            public String getSgst() {
                return sgst;
            }

            public void setSgst(String sgst) {
                this.sgst = sgst;
            }

            public String getIgst() {
                return igst;
            }

            public void setIgst(String igst) {
                this.igst = igst;
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

            public Package getPackage() {
                return _package;
            }

            public void setPackage(Package _package) {
                this._package = _package;
            }


            public class Addon {

                @SerializedName("id")
                @Expose
                private Integer id;
                @SerializedName("name")
                @Expose
                private String name;
                @SerializedName("quantity")
                @Expose
                private String quantity;
                @SerializedName("amount")
                @Expose
                private String amount;
                @SerializedName("discount")
                @Expose
                private String discount;
                @SerializedName("after_discount")
                @Expose
                private String afterDiscount;

                public Integer getId() {
                    return id;
                }

                public void setId(Integer id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public String getQuantity() {
                    return quantity;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public void setQuantity(String quantity) {
                    this.quantity = quantity;
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

            public class Package {

                @SerializedName("id")
                @Expose
                private Integer id;
                @SerializedName("name")
                @Expose
                private String name;
                @SerializedName("about_package")
                @Expose
                private String aboutPackage;
                @SerializedName("amount")
                @Expose
                private String amount;
                @SerializedName("category_id")
                @Expose
                private Integer categoryId;
                @SerializedName("sub_category_id")
                @Expose
                private Integer subCategoryId;
                @SerializedName("sub_sub_category_id")
                @Expose
                private Integer subSubCategoryId;
                @SerializedName("service_id")
                @Expose
                private String serviceId;
                @SerializedName("get_category")
                @Expose
                private GetCategory getCategory;
                @SerializedName("get_sub_category")
                @Expose
                private GetSubCategory getSubCategory;
                @SerializedName("get_sub_sub_category")
                @Expose
                private GetSubSubCategory getSubSubCategory;

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

                public String getAboutPackage() {
                    return aboutPackage;
                }

                public void setAboutPackage(String aboutPackage) {
                    this.aboutPackage = aboutPackage;
                }

                public String getAmount() {
                    return amount;
                }

                public void setAmount(String amount) {
                    this.amount = amount;
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

                public String getServiceId() {
                    return serviceId;
                }

                public void setServiceId(String serviceId) {
                    this.serviceId = serviceId;
                }

                public GetCategory getGetCategory() {
                    return getCategory;
                }

                public void setGetCategory(GetCategory getCategory) {
                    this.getCategory = getCategory;
                }

                public GetSubCategory getGetSubCategory() {
                    return getSubCategory;
                }

                public void setGetSubCategory(GetSubCategory getSubCategory) {
                    this.getSubCategory = getSubCategory;
                }

                public GetSubSubCategory getGetSubSubCategory() {
                    return getSubSubCategory;
                }

                public void setGetSubSubCategory(GetSubSubCategory getSubSubCategory) {
                    this.getSubSubCategory = getSubSubCategory;
                }


                public class GetSubCategory {

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
                    private String deletedAt;

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

                    public String getDeletedAt() {
                        return deletedAt;
                    }

                    public void setDeletedAt(String deletedAt) {
                        this.deletedAt = deletedAt;
                    }

                }

                public class GetCategory {

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
                    private String deletedAt;

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

                    public String getDeletedAt() {
                        return deletedAt;
                    }

                    public void setDeletedAt(String deletedAt) {
                        this.deletedAt = deletedAt;
                    }

                }

                public class GetSubSubCategory {

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
                    private String deletedAt;

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

                    public String getDeletedAt() {
                        return deletedAt;
                    }

                    public void setDeletedAt(String deletedAt) {
                        this.deletedAt = deletedAt;
                    }

                }
            }
        }
    }
}
