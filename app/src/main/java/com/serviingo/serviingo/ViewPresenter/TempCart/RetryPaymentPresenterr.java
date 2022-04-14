package com.serviingo.serviingo.ViewPresenter.TempCart;

import android.content.Context;

import com.serviingo.serviingo.Rtrofit.ApiManager;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.BuyMembershipRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Razorpay.AddWalletRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Razorpay.Razor_OrderidRepo;
import com.serviingo.serviingo.modelrepo.request.PaymentSignatureVerifyReq;
import com.serviingo.serviingo.modelrepo.request.PaymentSignatureVerifyWalletReq;
import com.serviingo.serviingo.modelrepo.request.RetryPaymentRequest;
import com.serviingo.serviingo.modelrepo.request.TempCartRequest;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetryPaymentPresenterr {


    private RetryPaymentView view;

    public RetryPaymentPresenterr(RetryPaymentView view) {
        this.view = view;
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

                        view.RetryPaymentReqError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.RetryPaymentReqError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.RetryPaymentReqError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.RetryPaymentReqError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                view.showHideProgress(false);

                view.RetryPaymentReqFailure(t);
            }
        });

    }





    public interface RetryPaymentView {

        void RetryPaymentReqError(String message);
        void showHideProgress(boolean isShow);
        void RetryPaymentReqSuccess(ResponseBody response, String message);
        void RetryPaymentReqFailure(Throwable t);


    }
}
