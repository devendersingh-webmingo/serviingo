package com.serviingo.serviingo.modelrepo.Responsee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginRepo {



    @SerializedName("status")
    @Expose
    public Boolean status;
    @SerializedName("message")
    @Expose
    public String message;
    @SerializedName("data")
    @Expose
    public Data data;

    public class Data {

        @SerializedName("user")
        @Expose
        public User user;
        @SerializedName("access_token")
        @Expose
        public String accessToken;

        public class User {

            @SerializedName("id")
            @Expose
            public Integer id;
            @SerializedName("referral_user_id")
            @Expose
            public Object referralUserId;
            @SerializedName("referral_master_id")
            @Expose
            public Object referralMasterId;
            @SerializedName("name")
            @Expose
            public String name;
            @SerializedName("email")
            @Expose
            public String email;
            @SerializedName("mobile_number")
            @Expose
            public String mobileNumber;
            @SerializedName("state_id")
            @Expose
            public Integer stateId;
            @SerializedName("city_id")
            @Expose
            public Integer cityId;
            @SerializedName("category_id")
            @Expose
            public Object categoryId;
            @SerializedName("sub_category_id")
            @Expose
            public Object subCategoryId;
            @SerializedName("service_id")
            @Expose
            public Object serviceId;
            @SerializedName("profile_pic")
            @Expose
            public Object profilePic;
            @SerializedName("role")
            @Expose
            public String role;
            @SerializedName("gender")
            @Expose
            public String gender;
            @SerializedName("pincode")
            @Expose
            public String pincode;
            @SerializedName("address")
            @Expose
            public String address;
            @SerializedName("first_name")
            @Expose
            public Object firstName;
            @SerializedName("last_name")
            @Expose
            public Object lastName;
            @SerializedName("business_type")
            @Expose
            public Object businessType;
            @SerializedName("website")
            @Expose
            public Object website;
            @SerializedName("referral_id")
            @Expose
            public Object referralId;
            @SerializedName("full_address")
            @Expose
            public Object fullAddress;
            @SerializedName("pan_card_number")
            @Expose
            public Object panCardNumber;
            @SerializedName("aadhaar_card_number")
            @Expose
            public Object aadhaarCardNumber;
            @SerializedName("business_proof_number")
            @Expose
            public Object businessProofNumber;
            @SerializedName("business_address")
            @Expose
            public Object businessAddress;
            @SerializedName("account_type")
            @Expose
            public Object accountType;
            @SerializedName("account_name")
            @Expose
            public Object accountName;
            @SerializedName("account_number")
            @Expose
            public Object accountNumber;
            @SerializedName("ifsc_code")
            @Expose
            public Object ifscCode;
            @SerializedName("bank_name")
            @Expose
            public Object bankName;
            @SerializedName("bank_branch")
            @Expose
            public Object bankBranch;
            @SerializedName("pan_card_document")
            @Expose
            public Object panCardDocument;
            @SerializedName("aadhaar_card_front")
            @Expose
            public Object aadhaarCardFront;
            @SerializedName("aadhaar_card_back")
            @Expose
            public Object aadhaarCardBack;
            @SerializedName("business_proof_document")
            @Expose
            public Object businessProofDocument;
            @SerializedName("cancelled_cheque_img")
            @Expose
            public Object cancelledChequeImg;
            @SerializedName("photographs")
            @Expose
            public Object photographs;
            @SerializedName("other_documents")
            @Expose
            public Object otherDocuments;
            @SerializedName("country_id")
            @Expose
            public String countryId;
            @SerializedName("landmark")
            @Expose
            public String landmark;
            @SerializedName("status")
            @Expose
            public Integer status;
            @SerializedName("email_verified_at")
            @Expose
            public Object emailVerifiedAt;
            @SerializedName("current_team_id")
            @Expose
            public Object currentTeamId;
            @SerializedName("profile_photo_path")
            @Expose
            public String profilePhotoPath;
            @SerializedName("wallet_amount")
            @Expose
            public String walletAmount;
            @SerializedName("unique_id")
            @Expose
            public String uniqueId;
            @SerializedName("total_loan")
            @Expose
            public Integer totalLoan;
            @SerializedName("remaining_loan")
            @Expose
            public Integer remainingLoan;
            @SerializedName("dob")
            @Expose
            public Object dob;
            @SerializedName("father_name")
            @Expose
            public Object fatherName;
            @SerializedName("sender_amount")
            @Expose
            public Integer senderAmount;
            @SerializedName("receiver_amount")
            @Expose
            public Integer receiverAmount;
            @SerializedName("sender_referral_status")
            @Expose
            public String senderReferralStatus;
            @SerializedName("receiver_referral_status")
            @Expose
            public String receiverReferralStatus;
            @SerializedName("created_at")
            @Expose
            public String createdAt;
            @SerializedName("updated_at")
            @Expose
            public String updatedAt;
            @SerializedName("deleted_at")
            @Expose
            public Object deletedAt;
            @SerializedName("profile_photo_url")
            @Expose
            public String profilePhotoUrl;

        }
    }

}
