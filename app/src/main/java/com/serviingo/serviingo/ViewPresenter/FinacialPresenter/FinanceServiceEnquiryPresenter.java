package com.serviingo.serviingo.ViewPresenter.FinacialPresenter;


import android.content.Context;

import com.serviingo.serviingo.Rtrofit.ApiManager;

import com.serviingo.serviingo.modelrepo.request.ServiceEnquiryRequest;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FinanceServiceEnquiryPresenter {

    private FinanceServiceEnquiryView view;

    public FinanceServiceEnquiryPresenter(FinanceServiceEnquiryView view) {
        this.view = view;
    }


    public void FinanceServiceEnquiry(Context context, ServiceEnquiryRequest reqest) {
        Call<ResponseBody> loginCall = ApiManager.getApi(context).FinanceServiceEnquiry(reqest);
        //    Call<ResponseBody> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");
        view.showHideProgress(true);

        loginCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.GetFinanceServiceSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onFinanceServiceError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onFinanceServiceError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onFinanceServiceError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onFinanceServiceError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                view.onFinanceServiceFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public interface FinanceServiceEnquiryView {

        void onFinanceServiceError(String message);


        void GetFinanceServiceSuccess(ResponseBody response, String message);


        void onFinanceServiceFailure(Throwable t);

        void showHideProgress(boolean isShow);

    }
}
