package com.serviingo.serviingo.ViewPresenter.FinacialPresenter;


import android.content.Context;

import com.serviingo.serviingo.Rtrofit.ApiManager;
import com.serviingo.serviingo.modelrepo.Responsee.Finacial.FinacialServicesRepo;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FinacialServicesPresenter {

    private FinacialServicesView view;

    public FinacialServicesPresenter(FinacialServicesView view) {
        this.view = view;
    }


    public void FinacialServicesRepo(Context context, String id) {
        Call<FinacialServicesRepo> loginCall = ApiManager.getApi(context).FinanceServices(id);
        //    Call<FinacialServicesRepo> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");
        view.showHideProgress(true);

        loginCall.enqueue(new Callback<FinacialServicesRepo>() {
            @Override
            public void onResponse(Call<FinacialServicesRepo> call, Response<FinacialServicesRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onFinacialServicesRepoSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onFinacialServicesRepoError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onFinacialServicesRepoError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onFinacialServicesRepoError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onFinacialServicesRepoError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<FinacialServicesRepo> call, Throwable t) {
                view.onFinacialServicesRepoFailure(t);
                view.showHideProgress(false);

            }
        });

    }

    public interface FinacialServicesView {

        void onFinacialServicesRepoError(String message);

        void onFinacialServicesRepoSuccess(FinacialServicesRepo response, String message);

        void showHideProgress(boolean isShow);

        void onFinacialServicesRepoFailure(Throwable t);
    }
}
