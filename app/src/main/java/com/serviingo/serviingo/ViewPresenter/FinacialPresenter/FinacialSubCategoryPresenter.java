package com.serviingo.serviingo.ViewPresenter.FinacialPresenter;


import android.content.Context;

import com.serviingo.serviingo.Rtrofit.ApiManager;
import com.serviingo.serviingo.modelrepo.Responsee.Finacial.FinacialSubcategoryRepo;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FinacialSubCategoryPresenter {

    private FinacialSubCategoryView view;

    public FinacialSubCategoryPresenter(FinacialSubCategoryView view) {
        this.view = view;
    }


    public void FinacialSubcategoryRepo(Context context, String id) {
        Call<FinacialSubcategoryRepo> loginCall = ApiManager.getApi(context).FinanceSubCategories(id);
        //    Call<FinacialSubcategoryRepo> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");
        view.showHideProgress(true);

        loginCall.enqueue(new Callback<FinacialSubcategoryRepo>() {
            @Override
            public void onResponse(Call<FinacialSubcategoryRepo> call, Response<FinacialSubcategoryRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onFinacialSubcategoryRepoSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onFinacialSubcategoryRepoError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onFinacialSubcategoryRepoError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onFinacialSubcategoryRepoError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onFinacialSubcategoryRepoError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<FinacialSubcategoryRepo> call, Throwable t) {
                view.onFinacialSubcategoryRepoFailure(t);
                view.showHideProgress(false);

            }
        });

    }

    public interface FinacialSubCategoryView {

        void onFinacialSubcategoryRepoError(String message);

        void onFinacialSubcategoryRepoSuccess(FinacialSubcategoryRepo response, String message);

        void showHideProgress(boolean isShow);

        void onFinacialSubcategoryRepoFailure(Throwable t);
    }
}
