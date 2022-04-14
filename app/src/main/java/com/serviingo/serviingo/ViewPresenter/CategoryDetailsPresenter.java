package com.serviingo.serviingo.ViewPresenter;


import android.content.Context;

import com.serviingo.serviingo.Rtrofit.ApiManager;
import com.serviingo.serviingo.modelrepo.Responsee.CategoriesDetailsRepo;
import com.serviingo.serviingo.modelrepo.Responsee.CheckMinimumOrderPriceRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.MyMembershipRepo;
import com.serviingo.serviingo.modelrepo.request.CartRequest;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryDetailsPresenter {

    private CategoryDetailsView view;

    public CategoryDetailsPresenter(CategoryDetailsView view) {
        this.view = view;
    }

    public void  CategoryDetails(Context context,String id) {
        view. showHideProgress(true);
        Call<CategoriesDetailsRepo> loginCall = ApiManager.getApi(context).categoryDetails(id);
        //    Call<CategoriesDetailsRepo> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");

        loginCall.enqueue(new Callback<CategoriesDetailsRepo>() {
            @Override
            public void onResponse(Call<CategoriesDetailsRepo> call, Response<CategoriesDetailsRepo> response) {
                String s = null;
                view. showHideProgress(false);
                if (response.isSuccessful() && response.body() != null && response.code() == 200) {

                    try {

                        view.onCategoryDetailsSuccess(response.body(), response.message());


                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onCategoryDetailsError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onCategoryDetailsError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onCategoryDetailsError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onCategoryDetailsError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<CategoriesDetailsRepo> call, Throwable t) {
                view. showHideProgress(false);
                view.onCategoryDetailsFailure(t);
            }
        });

    }


    public interface CategoryDetailsView {

        void onCategoryDetailsError(String message);

        void onCategoryDetailsSuccess(CategoriesDetailsRepo response, String message);
       

        void showHideProgress(boolean isShow);

        void onCategoryDetailsFailure(Throwable t);
    }
}
