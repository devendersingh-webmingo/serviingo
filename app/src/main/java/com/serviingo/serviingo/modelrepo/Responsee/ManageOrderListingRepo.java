package com.serviingo.serviingo.modelrepo.Responsee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ManageOrderListingRepo implements Serializable {
    @SerializedName("status")
    @Expose
    public Boolean status;
    @SerializedName("message")
    @Expose
    public String message;
    @SerializedName("data")
    @Expose
    public Data data;


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

        @SerializedName("current_page")
        @Expose
        public Integer currentPage;
        @SerializedName("data")
        @Expose
        public List<Datum> data = null;
        @SerializedName("first_page_url")
        @Expose
        public String firstPageUrl;
        @SerializedName("from")
        @Expose
        public Integer from;
        @SerializedName("last_page")
        @Expose
        public Integer lastPage;
        @SerializedName("last_page_url")
        @Expose
        public String lastPageUrl;
        @SerializedName("links")
        @Expose
        public List<Link> links = null;
        @SerializedName("next_page_url")
        @Expose
        public String nextPageUrl;
        @SerializedName("path")
        @Expose
        public String path;
        @SerializedName("per_page")
        @Expose
        public Integer perPage;
        @SerializedName("prev_page_url")
        @Expose
        public String prevPageUrl;
        @SerializedName("to")
        @Expose
        public Integer to;
        @SerializedName("total")
        @Expose
        public Integer total;

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

        public List<Link> getLinks() {
            return links;
        }

        public void setLinks(List<Link> links) {
            this.links = links;
        }

        public String getNextPageUrl() {
            return nextPageUrl;
        }

        public void setNextPageUrl(String nextPageUrl) {
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

        public String getPrevPageUrl() {
            return prevPageUrl;
        }

        public void setPrevPageUrl(String prevPageUrl) {
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
            public Integer id;
            @SerializedName("user_id")
            @Expose
            public Integer userId;
            @SerializedName("vendor_id")
            @Expose
            public String vendorId;
            @SerializedName("package_id")
            @Expose
            public Integer packageId;
            @SerializedName("addons")
            @Expose
            public List<Addon> addons = null;
            @SerializedName("pincode")
            @Expose
            public String pincode;
            @SerializedName("order_number")
            @Expose
            public String orderNumber;
            @SerializedName("cart_details")
            @Expose
            public String cartDetails;
            @SerializedName("total_amount")
            @Expose
            public String totalAmount;
            @SerializedName("tax_name")
            @Expose
            public String taxName;
            @SerializedName("tax_amount")
            @Expose
            public String taxAmount;
            @SerializedName("hygiene_fees")
            @Expose
            public String hygieneFees;
            @SerializedName("order_status")
            @Expose
            public String orderStatus;
            @SerializedName("vendor_status")
            @Expose
            public String vendorStatus;
            @SerializedName("name")
            @Expose
            public String name;
            @SerializedName("email")
            @Expose
            public String email;
            @SerializedName("mobile_number")
            @Expose
            public String mobileNumber;
            @SerializedName("address")
            @Expose
            public String address;
            @SerializedName("landmark")
            @Expose
            public String landmark;
            @SerializedName("state_id")
            @Expose
            public Integer stateId;
            @SerializedName("city")
            @Expose
            public String city;
            @SerializedName("cancellation_reasons")
            @Expose
            public String cancellationReasons;
            @SerializedName("cancelled_by")
            @Expose
            public String cancelledBy;
            @SerializedName("payment_method")
            @Expose
            public String paymentMethod;
            @SerializedName("payment_status")
            @Expose
            public String paymentStatus;
            @SerializedName("assigned_status")
            @Expose
            public String assignedStatus;
            @SerializedName("remark")
            @Expose
            public String remark;
            @SerializedName("membership_id")
            @Expose
            public String membershipId;
            @SerializedName("membership_cost")
            @Expose
            public String membershipCost;
            @SerializedName("cgst")
            @Expose
            public String cgst;
            @SerializedName("sgst")
            @Expose
            public String sgst;
            @SerializedName("igst")
            @Expose
            public String igst;
            @SerializedName("device_type")
            @Expose
            public String deviceType;
            @SerializedName("device_info")
            @Expose
            public String deviceInfo;
            @SerializedName("system_ip")
            @Expose
            public String systemIp;
            @SerializedName("created_at")
            @Expose
            public String createdAt;
            @SerializedName("updated_at")
            @Expose
            public String updatedAt;
            @SerializedName("package")
            @Expose
            public Package _package;

            @SerializedName("serve_date")
            @Expose
            private String serveDate;
            @SerializedName("serve_time")
            @Expose
            private String serveTime;

            @SerializedName("serving_datetime")
            @Expose
            private String serving_datetime;


            @SerializedName("find_relatedvendor_info")
            @Expose
            private FindRelatedvendorInfo findRelatedvendorInfo;



            @SerializedName("o_refund_method")
            @Expose
            private String oRefundMethod;
            @SerializedName("o_refund_date")
            @Expose
            private String oRefundDate;
            @SerializedName("o_refund_number")
            @Expose
            private String oRefundNumber;
            
            @SerializedName("o_refund_receipt")
            @Expose
            private String oRefundReceipt;


            @SerializedName("online_refund_date")
            @Expose
            private String online_refund_date;


            public String getoRefundMethod() {
                return oRefundMethod;
            }

            public void setoRefundMethod(String oRefundMethod) {
                this.oRefundMethod = oRefundMethod;
            }

            public String getoRefundDate() {
                return oRefundDate;
            }

            public void setoRefundDate(String oRefundDate) {
                this.oRefundDate = oRefundDate;
            }

            public String getoRefundNumber() {
                return oRefundNumber;
            }

            public void setoRefundNumber(String oRefundNumber) {
                this.oRefundNumber = oRefundNumber;
            }

            public String getoRefundReceipt() {
                return oRefundReceipt;
            }

            public void setoRefundReceipt(String oRefundReceipt) {
                this.oRefundReceipt = oRefundReceipt;
            }

            public String getOnline_refund_date() {
                return online_refund_date;
            }

            public void setOnline_refund_date(String online_refund_date) {
                this.online_refund_date = online_refund_date;
            }

            public FindRelatedvendorInfo getFindRelatedvendorInfo() {
                return findRelatedvendorInfo;
            }

            public void setFindRelatedvendorInfo(FindRelatedvendorInfo findRelatedvendorInfo) {
                this.findRelatedvendorInfo = findRelatedvendorInfo;
            }

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

            public String getHygieneFees() {
                return hygieneFees;
            }

            public void setHygieneFees(String hygieneFees) {
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

            public Package get_package() {
                return _package;
            }

            public void set_package(Package _package) {
                this._package = _package;
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
            public class Package {

                @SerializedName("id")
                @Expose
                public Integer id;
                @SerializedName("name")
                @Expose
                public String name;
                @SerializedName("about_package")
                @Expose
                public String aboutPackage;
                @SerializedName("amount")
                @Expose
                public String amount;
                @SerializedName("category_id")
                @Expose
                public Integer categoryId;
                @SerializedName("sub_category_id")
                @Expose
                public Integer subCategoryId;
                @SerializedName("sub_sub_category_id")
                @Expose
                public Integer subSubCategoryId;
                @SerializedName("service_id")
                @Expose
                public String serviceId;

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
            }
            public class Addon {

                @SerializedName("id")
                @Expose
                public Integer id;
                @SerializedName("name")
                @Expose
                public String name;
                @SerializedName("amount")
                @Expose
                public String amount;
                @SerializedName("discount")
                @Expose
                public String discount;
                @SerializedName("after_discount")
                @Expose
                public String afterDiscount;

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

            public class FindRelatedvendorInfo {

                @SerializedName("id")
                @Expose
                private Integer id;
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
                @SerializedName("vaccinated")
                @Expose
                private String vaccinated;
                @SerializedName("profile_photo_path")
                @Expose
                private String profilePhotoPath;


                @SerializedName("profile_image_url")
                @Expose
                private String profile_image_url;

                public String getProfile_image_url() {
                    return profile_image_url;
                }

                public void setProfile_image_url(String profile_image_url) {
                    this.profile_image_url = profile_image_url;
                }

                public Integer getId() {
                    return id;
                }

                public void setId(Integer id) {
                    this.id = id;
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

                public String getVaccinated() {
                    return vaccinated;
                }

                public void setVaccinated(String vaccinated) {
                    this.vaccinated = vaccinated;
                }

                public String getProfilePhotoPath() {
                    return profilePhotoPath;
                }

                public void setProfilePhotoPath(String profilePhotoPath) {
                    this.profilePhotoPath = profilePhotoPath;
                }

            }

        }

        public class Link {
            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public Boolean getActive() {
                return active;
            }

            public void setActive(Boolean active) {
                this.active = active;
            }

            @SerializedName("url")
            @Expose
            public String url;
            @SerializedName("label")
            @Expose
            public String label;
            @SerializedName("active")
            @Expose
            public Boolean active;

        }
    }

}