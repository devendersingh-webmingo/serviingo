package com.serviingo.serviingo.ViewPresenter;


import android.content.Context;

import com.serviingo.serviingo.Rtrofit.ApiManager;
import com.serviingo.serviingo.modelrepo.Responsee.SubSubcateogriesResponse;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetSubSubCategoriesPresenter {

    private GetSubSubCategoriesView view;
    public GetSubSubCategoriesPresenter(GetSubSubCategoriesView view) {
        this.view = view;
    }
    public void GetSubSubCategoriesView(Context context, String sub_category_id) {
        Call<SubSubcateogriesResponse> loginCall = ApiManager.getApi(context).GetSubSubCategories(sub_category_id);
        //    Call<ResponseBody> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");
        view.showHideProgress(true);

        loginCall.enqueue(new Callback<SubSubcateogriesResponse>() {
            @Override
            public void onResponse(Call<SubSubcateogriesResponse> call, Response<SubSubcateogriesResponse> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.GetSubSubCategoriesuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onGetSubSubCategoriesError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onGetSubSubCategoriesError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onGetSubSubCategoriesError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onGetSubSubCategoriesError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<SubSubcateogriesResponse> call, Throwable t) {
                view.onGetSubSubCategoriesFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public interface GetSubSubCategoriesView {

        void onGetSubSubCategoriesError(String message);

        void GetSubSubCategoriesuccess(SubSubcateogriesResponse response, String message);

        void onGetSubSubCategoriesFailure(Throwable t);

        void showHideProgress(boolean isShow);

    }
}
