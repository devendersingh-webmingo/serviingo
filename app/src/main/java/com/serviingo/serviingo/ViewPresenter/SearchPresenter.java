package com.serviingo.serviingo.ViewPresenter;

import android.content.Context;

import com.serviingo.serviingo.Rtrofit.ApiManager;
import com.serviingo.serviingo.modelrepo.Responsee.SearchResponse;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchPresenter {

    private SearchPresenterView view;

    public SearchPresenter(SearchPresenterView view) {
        this.view = view;
    }

    public void Search(Context context, String Search , String CityId) {


        Call<SearchResponse> loginCall = ApiManager.getApi(context).Search(Search,CityId);
        loginCall.enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                String s = null;


                if (response.isSuccessful() && response.body() != null && response.code() == 200) {

                    try {

                        view.onSerachSuccess(response.body(), response.message());


                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onSerachError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onSerachError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onSerachError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onSerachError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                view.onSerachFailure(t);

            }
        });

    }

    public interface SearchPresenterView {

        void onSerachError(String message);

        void onSerachSuccess(SearchResponse response, String message);



        void onSerachFailure(Throwable t);
    }
}
