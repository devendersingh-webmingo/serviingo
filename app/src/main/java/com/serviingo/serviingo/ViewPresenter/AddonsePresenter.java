package com.serviingo.serviingo.ViewPresenter;


import android.content.Context;

import com.serviingo.serviingo.Rtrofit.ApiManager;
import com.serviingo.serviingo.modelrepo.Responsee.AddonseRepo;

import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddonsePresenter {

    private AddonseListView view;

    public AddonsePresenter(AddonseListView view) {
        this.view = view;
    }

    public void GetAddonse(Context context, String id, ArrayList<String> addons) {
        Call<AddonseRepo> loginCall = ApiManager.getApi(context).GetAddonse(id,addons);

        loginCall.enqueue(new Callback<AddonseRepo>() {
            @Override
            public void onResponse(Call<AddonseRepo> call, Response<AddonseRepo> response) {

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onAddonseSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code()==500){
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                      JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onAddonseError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onAddonseError(String.valueOf(response.code()));
                    }

                }else if (response.code()==401)
                {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onAddonseError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onAddonseError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<AddonseRepo> call, Throwable t) {
                view.onAddonseFailure(t);
            }
        });

    }



    public interface AddonseListView {

        void onAddonseError(String message);

        void onAddonseSuccess(AddonseRepo response, String message);

        void onAddonseFailure(Throwable t);
    }
}
