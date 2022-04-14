package com.serviingo.serviingo.ViewPresenter.FinacialPresenter;


import android.content.Context;

import com.serviingo.serviingo.Rtrofit.ApiManager;
import com.serviingo.serviingo.modelrepo.Responsee.Finacial.FinanceServiceDetailRepo;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FinacialServicesDetailsPresenter {

    private FinacialServicesDetailsView view;

    public FinacialServicesDetailsPresenter(FinacialServicesDetailsView view) {
        this.view = view;
    }


    public void FinacialServicesDetailsRepo(Context context, String id) {
        Call<FinanceServiceDetailRepo> loginCall = ApiManager.getApi(context).FinanceServiceDetail(id);
        //    Call<FinacialServicesDetailsRepo> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");
        view.showHideProgress(true);

        loginCall.enqueue(new Callback<FinanceServiceDetailRepo>() {
            @Override
            public void onResponse(Call<FinanceServiceDetailRepo> call, Response<FinanceServiceDetailRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onFinacialServicesDetailsRepoSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onFinacialServicesDetailsRepoError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onFinacialServicesDetailsRepoError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onFinacialServicesDetailsRepoError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onFinacialServicesDetailsRepoError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<FinanceServiceDetailRepo> call, Throwable t) {
                view.onFinacialServicesDetailsRepoFailure(t);
                view.showHideProgress(false);

            }
        });

    }

    public interface FinacialServicesDetailsView {

        void onFinacialServicesDetailsRepoError(String message);

        void onFinacialServicesDetailsRepoSuccess(FinanceServiceDetailRepo response, String message);

        void showHideProgress(boolean isShow);

        void onFinacialServicesDetailsRepoFailure(Throwable t);
    }
}
