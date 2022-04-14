package com.serviingo.serviingo.Rtrofit;


import com.serviingo.serviingo.modelrepo.Responsee.AboutRepo;
import com.serviingo.serviingo.modelrepo.Responsee.AddAmountResponse;
import com.serviingo.serviingo.modelrepo.Responsee.AddonseRepo;
import com.serviingo.serviingo.modelrepo.Responsee.AddressbookRespo;
import com.serviingo.serviingo.modelrepo.Responsee.CancelOrderQuestionsRepo;
import com.serviingo.serviingo.modelrepo.Responsee.CartRepo;
import com.serviingo.serviingo.modelrepo.Responsee.CategoriesDetailsRepo;
import com.serviingo.serviingo.modelrepo.Responsee.CheckMinimumOrderPriceRepo;
import com.serviingo.serviingo.modelrepo.Responsee.CouponApplyRepo;
import com.serviingo.serviingo.modelrepo.Responsee.CreateOrderRepo;
import com.serviingo.serviingo.modelrepo.Responsee.CustomPackageRepo;
import com.serviingo.serviingo.modelrepo.Responsee.DateSlotRepo;
import com.serviingo.serviingo.modelrepo.Responsee.DiscountRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Finacial.FinacialCategoryRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Finacial.FinacialServicesRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Finacial.FinacialSubcategoryRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Finacial.FinanceServiceDetailRepo;
import com.serviingo.serviingo.modelrepo.Responsee.GetOrderDetailRepo;
import com.serviingo.serviingo.modelrepo.Responsee.GetOrderNumbersRepo;
import com.serviingo.serviingo.modelrepo.Responsee.GetReferrals;
import com.serviingo.serviingo.modelrepo.Responsee.GetTransactionRepo;
import com.serviingo.serviingo.modelrepo.Responsee.HomePageRepo;
import com.serviingo.serviingo.modelrepo.Responsee.HomeScreenFinacialServiceRepo;
import com.serviingo.serviingo.modelrepo.Responsee.IncompletedBookingRepo;
import com.serviingo.serviingo.modelrepo.Responsee.LoginRepo;
import com.serviingo.serviingo.modelrepo.Responsee.ManageOrderListingRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.BuyMembershipRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.CheckMembershipDiscountRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.MembershipContentRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.MembershipHistoryRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.MembershipPlansRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.MyMembershipRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.PackageviewDetailsRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.WithoutTokenMembershipDetailsRepo;
import com.serviingo.serviingo.modelrepo.Responsee.MyAddressRepoo;
import com.serviingo.serviingo.modelrepo.Responsee.MyRatingAndReviewRespooo;
import com.serviingo.serviingo.modelrepo.Responsee.MyTicketRepo;
import com.serviingo.serviingo.modelrepo.Responsee.MywalletRespo;
import com.serviingo.serviingo.modelrepo.Responsee.PackageReviews;
import com.serviingo.serviingo.modelrepo.Responsee.PackagesRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Profile_Repo;
import com.serviingo.serviingo.modelrepo.Responsee.Razorpay.AddWalletRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Razorpay.Razor_OrderidRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Razorpay.RazorpayRepo;
import com.serviingo.serviingo.modelrepo.Responsee.SafeHealthRepo;
import com.serviingo.serviingo.modelrepo.Responsee.SearchResponse;
import com.serviingo.serviingo.modelrepo.Responsee.SendReferralRepo;
import com.serviingo.serviingo.modelrepo.Responsee.ServetimeSlotRepo;
import com.serviingo.serviingo.modelrepo.Responsee.ShowListPackageRepo;
import com.serviingo.serviingo.modelrepo.Responsee.SubSubcateogriesResponse;
import com.serviingo.serviingo.modelrepo.Responsee.Subcategory_detailsRepo;
import com.serviingo.serviingo.modelrepo.Responsee.SupportQuestionRepo;
import com.serviingo.serviingo.modelrepo.Responsee.TicketChatListRepo;
import com.serviingo.serviingo.modelrepo.Responsee.UpdateProfileRepo;
import com.serviingo.serviingo.modelrepo.Responsee.VandorRepo;
import com.serviingo.serviingo.modelrepo.Responsee.VerifyOtpResponse;
import com.serviingo.serviingo.modelrepo.Responsee.subsubcategory_detailsRepo;
import com.serviingo.serviingo.modelrepo.request.AddressbookRequest;
import com.serviingo.serviingo.modelrepo.request.CartRequest;
import com.serviingo.serviingo.modelrepo.request.Changepassword_request;
import com.serviingo.serviingo.modelrepo.request.CouponApplyRequest;
import com.serviingo.serviingo.modelrepo.request.CreateOrderRequest;
import com.serviingo.serviingo.modelrepo.request.CustomPackageSUBSub_request;
import com.serviingo.serviingo.modelrepo.request.CustomPackage_request;
import com.serviingo.serviingo.modelrepo.request.EditReviewRequest;
import com.serviingo.serviingo.modelrepo.request.GenerateTicketRepo;
import com.serviingo.serviingo.modelrepo.request.PaymentSignatureVerifyReq;
import com.serviingo.serviingo.modelrepo.request.PaymentSignatureVerifyWalletReq;
import com.serviingo.serviingo.modelrepo.request.Reschedule_request;
import com.serviingo.serviingo.modelrepo.request.RetryPaymentRequest;
import com.serviingo.serviingo.modelrepo.request.ReviewRequest;
import com.serviingo.serviingo.modelrepo.request.SendMessageReqest;
import com.serviingo.serviingo.modelrepo.request.ServiceEnquiryRequest;
import com.serviingo.serviingo.modelrepo.request.TempCartRequest;
import com.serviingo.serviingo.modelrepo.request.UpdateProfile_request;
import com.serviingo.serviingo.modelrepo.request.UserReg_Request;
import com.serviingo.serviingo.modelrepo.request.WithoutTokenMemberdeyailsRequest;

import java.util.ArrayList;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserService {


    /**
     * File Name: UserService.java
     * Description: This file contains classes and functions for the Api.
     *
     * @author Devender
     * Date Created: 20/07/2021
     * Date Released:
     * Created by Devender Singh
     */
    @GET("states")
    Call<ResponseBody> GetState(
    );

    @GET("vendor/serve/states")
    Call<ResponseBody> GetServeState(
    );

    @GET
            ("finance/content")
    Call<HomeScreenFinacialServiceRepo> GetFinancialServices(
    );

   /* @GET("fetchcitybystate/")
    Call<ResponseBody> GetCity(
            @Query("state_id") String state_id
    );
*/

    @GET("category/details/{id}")
    Call<CategoriesDetailsRepo> categoryDetails(
            @Path("id") String id
    );

    @GET("sub-sub/categories/{sub_category_id}")
    Call<SubSubcateogriesResponse> GetSubSubCategories(
            @Path("sub_category_id") String sub_category_id
    );


    @GET("subsub-category/details/{id}")
    Call<subsubcategory_detailsRepo> GetSUBSubCategory(
            @Path("id") String id
    );

    @GET("sub-category/details/{id}")
    Call<Subcategory_detailsRepo> GetSubCategory(
            @Path("id") String id
    );

    @GET("package/service/details/{id}")
    Call<PackageviewDetailsRepo> GetPackageDetails(
            @Path("id") String id
    );


    @GET("packages/{id}")
    Call<PackagesRepo> GetPackagelist(
            @Path("id") String id
    );

    @GET("package/reviews/{id}")
    Call<PackageReviews> GetPackageReviews(
            @Path("id") String id
    );



    @GET("get/services-by/subsubcategory/{id}")
    Call<ShowListPackageRepo> GetPackage(
            @Path("id") String id
    );


    @GET("service/safe-and-health/{id}/{city_id}")
    Call<SafeHealthRepo> GetSafeHealth(
            @Path("id") String id,
            @Path("city_id") String city_id
    );


    @GET("cities/{state_id}")
    Call<ResponseBody> GetCity(
            @Path("state_id") String state_id
    );


    @GET("vendor/serve/cities/{state_id}")
    Call<ResponseBody> GetServeCity(
            @Path("state_id") String state_id
    );

    @GET("categories")
    Call<ResponseBody> Getcategory(
    );

    @FormUrlEncoded
    @POST("check/valid/discount")
    Call<DiscountRepo> Discount(
            @Field("price") String price

    );

    @FormUrlEncoded
    @POST("vendor/signup")
    Call<VandorRepo> doVandorReg(
            @Field("first_name") String first_name,
            @Field("last_name") String last_name,
            @Field("state") String state,
            @Field("city") String city,
            @Field("category") String category,
            @Field("email") String email,
            @Field("mobile_number") String mobile_number,
            @Field("password") String password,
            @Field("confirm_password") String confirm_password
    );


    @POST("user/registration")
    Call<ResponseBody> DoUserReg(@Body UserReg_Request credential);

    @FormUrlEncoded
    @POST("user/login")
    Call<LoginRepo> userlogin(
            @Field("email") String email,
            @Field("password") String password,
            @Field("device_token") String device_token


    );


    @GET("user/logout")
    Call<ResponseBody> DoLogout(

    );

    @GET("myprofile")
    Call<Profile_Repo> Domyprofile(
    );

    @GET("my-address")
    Call<MyAddressRepoo> DoMyAddresss(

    );

    @POST("create/my-address")
    Call<AddressbookRespo> DoAddressbook(@Body AddressbookRequest credential);

    //deleteAddress
    // https://7xhospitals.com/serviingo/api/delete/my-address/15
    @DELETE("delete/my-address/{id}")
    Call<ResponseBody> DoDeleteAddress(@Path("id") String Review_Id);
    //update Address

    @PATCH("update/my-address")
    Call<ResponseBody> DoUpdateAddress(@Query("id") String id, @Body AddressbookRequest credential);


    //get review
    @GET("my/rating/reviews")
    Call<MyRatingAndReviewRespooo> DoMyRatingAndReviewRespo(

    );


    //Adding review
    @POST("create/rating/reviews")
    Call<ResponseBody> AddReview(@Body ReviewRequest credential);

    //updateing Review
    @PUT("update/rating/reviews")
    Call<ResponseBody> DoUpdateReview(@Body EditReviewRequest credential);


    @DELETE("delete/rating/reviews/{id}")
    Call<ResponseBody> DodeleteReview(@Path("id") String Review_Id);


    @GET("mywallet")
    Call<MywalletRespo> DoMyWallet(

    );

    @POST("update/password")
    Call<ResponseBody> Doupdatepassword(@Body Changepassword_request credential);


    @FormUrlEncoded
    @POST("add/wallet/fund")
    Call<AddAmountResponse> DoaddMoney(
            @Field("payment_mode") String payment_mode,
            @Field("amount") String amount,

            @Field("paymet_of_mode") String paymet_of_mode,

            @Field("cheque_number") String cheque_number,

            @Field("cheque_date") String cheque_date,
            @Field("bank_name") String bank_name,
            @Field("bank_branch") String bank_branch,
            @Field("utr_number") String utr_number,
            @Field("ref_id") String ref_id,
            @Field("order_id") String order_id


    );


    @Multipart
    @POST("add/wallet/fund")
    Call<AddAmountResponse> DoaddMoney_Offline(
            @Part("payment_mode") RequestBody payment_mode,
            @Part("amount") RequestBody amount,
            @Part("paymet_of_mode") RequestBody paymet_of_mode,
            @Part("utr_number") RequestBody utr_number,
            @Part("ref_id") RequestBody ref_id,
            @Part("order_id") RequestBody order_id,

            @Part MultipartBody.Part payment_screenshot);


    @PUT("update/profile")
    Call<UpdateProfileRepo> DoMyprofileUpdate(@Body UpdateProfile_request credential);


    @Multipart
    @POST("update/profile/photo")
    Call<Profile_Repo> uploadPic(@Part MultipartBody.Part image);

    @FormUrlEncoded
    @POST("get/add-on-services")
    Call<AddonseRepo> GetAddonse(
            @Field("package_id") String package_id,
            @Field("addons[]") ArrayList<String> addons

    );

    /* @FormUrlEncoded
     @POST("cart")
     Call<CartRepo> GetCart(
             @Field("package_id") String package_id,
             @Field("addon_service_ids") String addon_service_ids

     );*/
    @POST("cart")
    Call<CartRepo> GetCart(@Body CartRequest credential);

    @POST("create/sub-category/custom-package")
    Call<CustomPackageRepo> CustomPackage(@Body CustomPackage_request credential);

    @POST("create/sub-sub-category/custom-package")
    Call<CustomPackageRepo> CustomPackageSUBSub_request(@Body CustomPackageSUBSub_request credential);


    @FormUrlEncoded
    @POST("check/minimum-order/price")
    Call<CheckMinimumOrderPriceRepo> CheckMinimumOrderPrice(
            @Field("category_id") String category_id

    );

    @POST("create/order")
    Call<CreateOrderRepo> CreateOrder(@Body CreateOrderRequest credential);


    @GET("orders/{type}")
    Call<ManageOrderListingRepo> ManageOrderListing(
            @Path("type") String type
    );

    @FormUrlEncoded
    @POST("cancel/order")
    Call<ResponseBody> CancelOrder(
            @Field("order_id") String order_id,
            @Field("cancellation_reasons") String cancellation_reasons,
            @Field("query_type") int query_type


    );

    @GET("cancel-order/questions")
    Call<CancelOrderQuestionsRepo> GetCancelOrderQuestionsRepo(
    );


    @GET("order/details/{id}")
    Call<GetOrderDetailRepo> GetOrderDetail(
            @Path("id") String id
    );


    @GET("my/tickets")
    Call<MyTicketRepo> MyTicketList(
    );

    @POST("generate/tickets")
    Call<ResponseBody> GenerateTicket(@Body GenerateTicketRepo credential);

    @GET("get/booking/numbers")
    Call<GetOrderNumbersRepo> GetOrderNumbersList(
    );

    @GET("get/transaction/ids")
    Call<GetTransactionRepo> GetTransactionlist(
    );

    @FormUrlEncoded
    @POST("support/question")
    Call<SupportQuestionRepo> GetSupportQuestion(
            @Field("model") String model

    );


    @GET("my/ticket/chat/{id}")
    Call<TicketChatListRepo> TicketChatList(
            @Path("id") String id
    );

    @POST("send/message")
    Call<ResponseBody> SendMessage(@Body SendMessageReqest credential);

    @Multipart
    @POST("send/message")
    Call<ResponseBody> SendMessageWithImage(
            @Part("ticket_id") RequestBody ticket_id,
            @Part("message") RequestBody message,

            @Part MultipartBody.Part file);

    @Multipart
    @POST("generate/tickets")
    Call<ResponseBody> GenerateTicketwithImage(
            @Part("other_subject") RequestBody other_subject,
            @Part("query_module") RequestBody query_module,
            @Part("query_statement") RequestBody query_statement,
            @Part("priority") RequestBody priority,
            @Part("subject_type_id") RequestBody subject_type_id,
            @Part MultipartBody.Part file);


   /* @GET("home/lucknow")
    Call<HomePageRepo> GetHomePageContent(
    );
*/

    @GET("home/{state_id}")
    Call<HomePageRepo> GetHomePageContent(
            @Path("state_id") String state_id
    );

    @GET("about")
    Call<AboutRepo> GetAboutPageContent(

    );


    @GET("get/referrals")
    Call<GetReferrals> GetReferrals(
    );

    @FormUrlEncoded
    @POST("send/referral")
    Call<SendReferralRepo> SendReferral(
            @Field("global") String global

    );

    //MemberShip Api
    @GET("membership/content")
    Call<MembershipContentRepo> MembershipContent(
    );

    @GET("membership/plans")
    Call<MembershipPlansRepo> MembershipPlan(
    );

    @GET("membership/history")
    Call<MembershipHistoryRepo> MembershipHistory();

    @GET("my/membership")
    Call<MyMembershipRepo> MyMembership();


/*
    @GET("buy/membership")
    Call<ResponseBody> BuyMyMembership();*/

    @FormUrlEncoded
    @POST("buy/membership")
    Call<BuyMembershipRepo> BuyMyMembership(
            @Field("membership_id") String membership_id,
            @Field("method") String method,
            @Field("razorpay_order_id") String razorpay_order_id,
            @Field("razorpay_payment_id") String razorpay_payment_id,
            @Field("razorpay_signature") String razorpay_signature


    );


    //--------------------------------Financail Service---------------------//

    @GET("finance/categories")
    Call<FinacialCategoryRepo> FinanceCategories();

    @GET("finance/sub-categories/{Sub_id}")
    Call<FinacialSubcategoryRepo> FinanceSubCategories(
            @Path("Sub_id") String Sub_id
    );

    @GET("finance/services/{services_id}")
    Call<FinacialServicesRepo> FinanceServices(
            @Path("services_id") String services_id
    );

    @GET("finance/service/detail/{detail_id}")
    Call<FinanceServiceDetailRepo> FinanceServiceDetail(
            @Path("detail_id") String detail_id
    );

    /*Your Query Successfully Submitted, Our Team Content You Soon !!*/


    @POST("finance/service/enquiry")
    Call<ResponseBody> FinanceServiceEnquiry(@Body ServiceEnquiryRequest credential);


    @POST("get/discount/by-membership")
    Call<WithoutTokenMembershipDetailsRepo> WithoutTokenMembershipDetailsRepo(@Body WithoutTokenMemberdeyailsRequest credential);

    @POST("check/membership/discount")
    Call<CheckMembershipDiscountRepo> CheckMembershipDiscount(@Body WithoutTokenMemberdeyailsRequest credential);



    //--------------------------------Forget Pasword OTP---------------------//

    @FormUrlEncoded
    @POST("forgot-password/send/otp")
    Call<ResponseBody> ForgotPasswordSendOtp(
            @Field("global") String global


    );

    @FormUrlEncoded
    @POST("verify/otp")
    Call<VerifyOtpResponse> VerifyOtp(
            @Field("otp") String otp


    );
   /* @FormUrlEncoded
    @POST("verify/mobile")
    Call<ResponseBody> VerifyMobile(
            @Field("otp") String otp


    );*/


    @FormUrlEncoded
    @POST("verify/otp/update/mobile")
    Call<ResponseBody> VerifyMobile(
            @Field("otp") String otp,
            @Field("mobile_number") String mobile_number


    );

    @FormUrlEncoded
    @POST("send/otp/mobile-update")
    Call<ResponseBody> SendOtpMobileUpdate(
            @Field("mobile_number") String mobile_number


    );

    @FormUrlEncoded
    @POST("reset/password")
    Call<ResponseBody> ResetPassword(
            @Field("user_id") String user_id,
            @Field("otp") String otp,
            @Field("password") String password,
            @Field("password_confirmation") String password_confirmation


    );


    @FormUrlEncoded
    @POST("autocomplete/search")
    Call<SearchResponse> Search(
            @Field("search") String search,
            @Field("city_id") String city_id
    );


    //Timeand date Slot---------------

    @GET("serve/dates/{sub_category_id}")
    Call<DateSlotRepo> ServeDatesSlot(
            @Path("sub_category_id") String sub_category_id
    );


    //https://serviingo.com/serve/api/serve/time/slots


    @FormUrlEncoded
    @POST("serve/time/slots")
    Call<ServetimeSlotRepo> ServetimeSlot(
            @Field("sub_category_id") String sub_category_id,
            @Field("date") String date
    );

    //cartserve Api
    @GET("incomplete/bookings")
    Call<IncompletedBookingRepo> IncompletedBooking();

    @DELETE("delete/incomplete/booking/{id}")
    Call<ResponseBody> DoDeleteTempCart(@Path("id") String TempCart_Id);

    @POST("creating/temp-cart")
    Call<ResponseBody> TempCartRequest(@Body TempCartRequest credential);



    @POST("order/apply/coupon")
    Call<CouponApplyRepo> CouponApply(@Body CouponApplyRequest credential);


    //Razorpay Payment
    @GET("gateway/razorpay")
    Call<RazorpayRepo> GetRazorPayKey(

    );

    @GET("get/razorpay/order-id/{order_id}")
    Call<Razor_OrderidRepo> razorpay_order_id(
            @Path("order_id") String sub_category_id
    );

    @POST("razorpay/payment-signature/verify")
    Call<ResponseBody> PaymentSignatureVerifyReq(@Body PaymentSignatureVerifyReq credential);

    @POST("order/re-payment")
    Call<ResponseBody> RetryPaymentRequest(@Body RetryPaymentRequest credential);


    @GET("online/payment/failed/{order_id}")
    Call<ResponseBody> PaymentFailed(
            @Path("order_id") String order_id
    );


    @POST("add-wallet-amount/razorpay")
    Call<ResponseBody> Add_walletVerifyWalletReq(@Body PaymentSignatureVerifyWalletReq credential);

    @FormUrlEncoded
    @POST("generate/order/razorpay")
    Call<AddWalletRepo> GetAmountRazorKey(
            @Field("amount") String amount
    );

    @POST("add-wallet-amount/razorpay")
    Call<ResponseBody> PaymentSignatureVerifyWalletReq(@Body PaymentSignatureVerifyWalletReq credential);

    /*

    Usernew Login Proceeess
    */

    @FormUrlEncoded
    @POST("send/otp/user-login")
    Call<ResponseBody> UserLoginWithNumberSendOTP(
            @Field("mobile_number") String mobile_number
    );

    @FormUrlEncoded
    @POST("user/login/by-otp")
    Call<LoginRepo> LoginOTPVerifying(
            @Field("otp") String otp,
            @Field("device_token") String device_token


    );


    @FormUrlEncoded
    @POST("send/otp/new-user")
    Call<ResponseBody> UsersendNewNumberSendOTP(
            @Field("mobile_number") String mobile_number
    );

    @FormUrlEncoded
    @POST("verify/otp/new-user")
    Call<ResponseBody> NewuserOTPVerifying(
            @Field("otp") String otp
    );


    @POST("order/re-schedule")
    Call<ResponseBody> ReSchedule(@Body Reschedule_request credential);


}
