package com.serviingo.serviingo.ViewPresenter;


import android.content.Context;
import android.util.Log;

import com.serviingo.serviingo.Rtrofit.ApiClientt;
import com.serviingo.serviingo.Rtrofit.ApiManager;

import com.serviingo.serviingo.modelrepo.Responsee.LoginRepo;
import com.serviingo.serviingo.modelrepo.Responsee.VandorRepo;
import com.serviingo.serviingo.modelrepo.request.VandorRegs;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserLoginPresenter {

    private UserLoginView view;

    public UserLoginPresenter(UserLoginView view) {
        this.view = view;
    }


    public void TicketChatList(Context context, String email, String pass,String device_token) {
        Call<LoginRepo> loginCall = ApiManager.getApi(context).userlogin(email,pass,device_token);
        //    Call<LoginRepo> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");
        view.showHideProgress(true);

        loginCall.enqueue(new Callback<LoginRepo>() {
            @Override
            public void onResponse(Call<LoginRepo> call, Response<LoginRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onVandorRegSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onVandorRegError(context,jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                      view.onVandorRegError(context,String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onVandorRegError(context,jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onVandorRegError(context,String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginRepo> call, Throwable t) {
                view.onVandorRegFailure(t);
                view.showHideProgress(false);

            }
        });

    }
    public interface UserLoginView {

        void onVandorRegError(Context context ,String message);

        void onVandorRegSuccess( LoginRepo response, String message);
        void showHideProgress(boolean isShow);

        void onVandorRegFailure(Throwable t);
    }
}
