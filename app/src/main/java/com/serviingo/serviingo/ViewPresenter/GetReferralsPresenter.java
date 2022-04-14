package com.serviingo.serviingo.ViewPresenter;


import android.content.Context;

import com.serviingo.serviingo.Rtrofit.ApiManager;
import com.serviingo.serviingo.modelrepo.Responsee.GetReferrals;
import com.serviingo.serviingo.modelrepo.Responsee.GetReferrals;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetReferralsPresenter {

    private GetReferralsView view;

    public GetReferralsPresenter(GetReferralsView view) {
        this.view = view;
    }


    public void GetReferrals(Context context ) {
        Call<GetReferrals> loginCall = ApiManager.getApi(context).GetReferrals();
        //    Call<GetReferrals> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");
        view.showHideProgress(true);

        loginCall.enqueue(new Callback<GetReferrals>() {
            @Override
            public void onResponse(Call<GetReferrals> call, Response<GetReferrals> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onGetReferralsSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onGetReferralsError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onGetReferralsError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onGetReferralsError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onGetReferralsError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<GetReferrals> call, Throwable t) {
                view.onGetReferralsFailure(t);
                view.showHideProgress(false);

            }
        });

    }
    public interface GetReferralsView {

        void onGetReferralsError(String message);

        void onGetReferralsSuccess(GetReferrals response, String message);
        void showHideProgress(boolean isShow);

        void onGetReferralsFailure(Throwable t);
    }
}
