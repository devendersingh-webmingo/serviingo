package com.serviingo.serviingo.ViewPresenter.TempCart;

import android.content.Context;

import com.serviingo.serviingo.Rtrofit.ApiManager;
import com.serviingo.serviingo.modelrepo.Responsee.CreateOrderRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.BuyMembershipRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Profile_Repo;
import com.serviingo.serviingo.modelrepo.Responsee.Razorpay.AddWalletRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Razorpay.Razor_OrderidRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Razorpay.RazorpayRepo;
import com.serviingo.serviingo.modelrepo.request.CreateOrderRequest;
import com.serviingo.serviingo.modelrepo.request.PaymentSignatureVerifyReq;
import com.serviingo.serviingo.modelrepo.request.PaymentSignatureVerifyWalletReq;
import com.serviingo.serviingo.modelrepo.request.RetryPaymentRequest;
import com.serviingo.serviingo.modelrepo.request.TempCartRequest;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RazorPayPresenterr {


    private RazorPayPresenterrView view;

    public RazorPayPresenterr(RazorPayPresenterrView view) {
        this.view = view;
    }


    public void GetRazorPayKey(Context context, String id) {
        Call<Razor_OrderidRepo> loginCall = ApiManager.getApi(context).razorpay_order_id(id);
        //    Call<CartRepo> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");
        view.showHideProgress(true);

        loginCall.enqueue(new Callback<Razor_OrderidRepo>() {
            @Override
            public void onResponse(Call<Razor_OrderidRepo> call, Response<Razor_OrderidRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.razorpay_order_idSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.CreateOrderError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.CreateOrderError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.CreateOrderError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.CreateOrderError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<Razor_OrderidRepo> call, Throwable t) {
                view.CreateOrderFailure(t);
                view.showHideProgress(false);

            }
        });

    }

    public void TempCartRequest(Context context, TempCartRequest tempCartRequest) {
        Call<ResponseBody> loginCall = ApiManager.getApi(context).TempCartRequest(tempCartRequest);
        //    Call<CartRepo> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");

        loginCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        //  view.TempCartSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.CreateOrderError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.CreateOrderError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.CreateOrderError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.CreateOrderError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                view.CreateOrderFailure(t);
            }
        });

    }

    public void PaymentSignatureVerifyReq(Context context, PaymentSignatureVerifyReq createOrderRequest) {
        view.showHideProgress(true);
        Call<ResponseBody> loginCall = ApiManager.getApi(context).PaymentSignatureVerifyReq(createOrderRequest);

        loginCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.PaymentSignatureVerifyReqSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.CreateOrderError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.CreateOrderError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.CreateOrderError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.CreateOrderError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                view.showHideProgress(false);

                view.CreateOrderFailure(t);
            }
        });

    }

    public void RetryPaymentReq(Context context, RetryPaymentRequest retryPaymentRequest) {
        view.showHideProgress(true);
        Call<ResponseBody> loginCall = ApiManager.getApi(context).RetryPaymentRequest(retryPaymentRequest);

        loginCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.RetryPaymentReqSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.CreateOrderError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.CreateOrderError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.CreateOrderError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.CreateOrderError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                view.showHideProgress(false);

                view.CreateOrderFailure(t);
            }
        });

    }


    public void GetRazorWalletPayKey(Context context, String id) {
        Call<AddWalletRepo> loginCall = ApiManager.getApi(context).GetAmountRazorKey(id);
        //    Call<CartRepo> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");
        view.showHideProgress(true);

        loginCall.enqueue(new Callback<AddWalletRepo>() {
            @Override
            public void onResponse(Call<AddWalletRepo> call, Response<AddWalletRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.razorpay_Wallet_idSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.CreateOrderError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.CreateOrderError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.CreateOrderError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.CreateOrderError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<AddWalletRepo> call, Throwable t) {
                view.CreateOrderFailure(t);
                view.showHideProgress(false);

            }
        });

    }

    public void PaymentFailed(Context context, String id) {
        Call<ResponseBody> loginCall = ApiManager.getApi(context).PaymentFailed(id);
        //    Call<CartRepo> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");
        view.showHideProgress(true);

        loginCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                view.showHideProgress(false);
                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.PaymentFailedSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.CreateOrderError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.CreateOrderError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.CreateOrderError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.CreateOrderError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                view.CreateOrderFailure(t);
                view.showHideProgress(false);

            }
        });

    }

    public void PaymentSignatureVerifyWalletReq(Context context, PaymentSignatureVerifyWalletReq createOrderRequest) {
        view.showHideProgress(true);
        Call<ResponseBody> loginCall = ApiManager.getApi(context).PaymentSignatureVerifyWalletReq(createOrderRequest);

        loginCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.PaymentSignatureVerifyReqWalletSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.CreateOrderWalletError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.CreateOrderWalletError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        view.CreateOrderWalletError(String.valueOf(response.code()));
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        //view.CreateOrderWalletError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.CreateOrderWalletError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                view.showHideProgress(false);

                view.CreateOrderFailure(t);
            }
        });

    }

    public void BuyMembershipPlan(Context context, String membership_id, String razorpay_order_id, String razorpay_payment_id, String razorpay_signature) {
        view.showHideProgress(true);

        Call<BuyMembershipRepo> loginCall = ApiManager.getApi(context).BuyMyMembership(membership_id, "Razorpay", razorpay_order_id, razorpay_payment_id, razorpay_signature);
        //    Call<BuyMembershipRepo> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");

        loginCall.enqueue(new Callback<BuyMembershipRepo>() {
            @Override
            public void onResponse(Call<BuyMembershipRepo> call, Response<BuyMembershipRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.BuyMembershipPlanSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.CreateOrderError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.CreateOrderError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.CreateOrderError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.CreateOrderError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 422) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.CreateOrderError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.CreateOrderError(String.valueOf(response.code()));
                    }

                }
            }

            @Override
            public void onFailure(Call<BuyMembershipRepo> call, Throwable t) {
                view.CreateOrderFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public interface RazorPayPresenterrView {

        void CreateOrderError(String message);

        void CreateOrderWalletError(String message);

        void showHideProgress(boolean isShow);

        //   void TempCartSuccess(ResponseBody response, String message);
        //   void GetRazorPayKeySuccess(RazorpayRepo response, String message);
        void PaymentSignatureVerifyReqSuccess(ResponseBody response, String message);

        void RetryPaymentReqSuccess(ResponseBody response, String message);


        void PaymentSignatureVerifyReqWalletSuccess(ResponseBody response, String message);

        void razorpay_order_idSuccess(Razor_OrderidRepo response, String message);

        void razorpay_Wallet_idSuccess(AddWalletRepo response, String message);

        void PaymentFailedSuccess(ResponseBody response, String message);

        void BuyMembershipPlanSuccess(BuyMembershipRepo response, String message);

        void CreateOrderFailure(Throwable t);


    }
}
