package com.serviingo.serviingo.ViewPresenter;


import android.content.Context;

import com.serviingo.serviingo.Rtrofit.ApiManager;
import com.serviingo.serviingo.modelrepo.Responsee.AboutRepo;
import com.serviingo.serviingo.modelrepo.Responsee.AboutRepo;
import com.serviingo.serviingo.modelrepo.Responsee.SendReferralRepo;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AboutUSPresenter {

    private AboutUSView view;

    public AboutUSPresenter(AboutUSView view) {
        this.view = view;
    }

     public void GetHomePageContent(Context context) {
        Call<AboutRepo> loginCall = ApiManager.getApi(context).GetAboutPageContent();
        //    Call<ResponseBody> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");
        view.showHideProgress(true);

        loginCall.enqueue(new Callback<AboutRepo>() {
            @Override
            public void onResponse(Call<AboutRepo> call, Response<AboutRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.AboutPageeSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onaboutPageeError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onaboutPageeError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onaboutPageeError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onaboutPageeError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<AboutRepo> call, Throwable t) {
                view.onaboutPageFailure(t);
                view.showHideProgress(false);

            }
        });

    }



    public interface AboutUSView {

        void onaboutPageeError(String message);

        void AboutPageeSuccess(AboutRepo response, String message);
        void onaboutPageFailure(Throwable t);
        void showHideProgress(boolean isShow);

    }
}
