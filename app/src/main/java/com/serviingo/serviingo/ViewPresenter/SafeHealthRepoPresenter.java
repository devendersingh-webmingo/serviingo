package com.serviingo.serviingo.ViewPresenter;


import android.content.Context;

import com.serviingo.serviingo.Rtrofit.ApiManager;
import com.serviingo.serviingo.modelrepo.Responsee.SafeHealthRepo;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SafeHealthRepoPresenter {

    private SafeHealthRepoView view;

    public SafeHealthRepoPresenter(SafeHealthRepoView view) {
        this.view = view;
    }

    public void GetAddonse(Context context, String id,String city_id) {
        Call<SafeHealthRepo> loginCall = ApiManager.getApi(context).GetSafeHealth(id,city_id);

        loginCall.enqueue(new Callback<SafeHealthRepo>() {
            @Override
            public void onResponse(Call<SafeHealthRepo> call, Response<SafeHealthRepo> response) {

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onSafeHealthRepoSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code()==500){
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                      JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onSafeHealthRepoError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onSafeHealthRepoError(String.valueOf(response.code()));
                    }

                }else if (response.code()==401)
                {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onSafeHealthRepoError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onSafeHealthRepoError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<SafeHealthRepo> call, Throwable t) {
                view.onSafeHealthRepoFailure(t);
            }
        });

    }



    public interface SafeHealthRepoView {

        void onSafeHealthRepoError(String message);

        void onSafeHealthRepoSuccess(SafeHealthRepo response, String message);

        void onSafeHealthRepoFailure(Throwable t);
    }
}
