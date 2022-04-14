package com.serviingo.serviingo.ViewPresenter.FinacialPresenter;


import android.content.Context;

import com.serviingo.serviingo.Rtrofit.ApiManager;
import com.serviingo.serviingo.modelrepo.Responsee.Finacial.FinacialCategoryRepo;


import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FinacialCategoryPresenter {

    private FinacialCategoryView view;

    public FinacialCategoryPresenter(FinacialCategoryView view) {
        this.view = view;
    }


    public void FinacialCategoryRepo(Context context) {
        Call<FinacialCategoryRepo> loginCall = ApiManager.getApi(context).FinanceCategories();
        //    Call<FinacialCategoryRepo> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");
        view.showHideProgress(true);

        loginCall.enqueue(new Callback<FinacialCategoryRepo>() {
            @Override
            public void onResponse(Call<FinacialCategoryRepo> call, Response<FinacialCategoryRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onFinacialCategoryRepoSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onFinacialCategoryRepoError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onFinacialCategoryRepoError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onFinacialCategoryRepoError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onFinacialCategoryRepoError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<FinacialCategoryRepo> call, Throwable t) {
                view.onFinacialCategoryRepoFailure(t);
                view.showHideProgress(false);

            }
        });

    }

    public interface FinacialCategoryView {

        void onFinacialCategoryRepoError(String message);

        void onFinacialCategoryRepoSuccess(FinacialCategoryRepo response, String message);

        void showHideProgress(boolean isShow);

        void onFinacialCategoryRepoFailure(Throwable t);
    }
}
