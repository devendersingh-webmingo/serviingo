package com.serviingo.serviingo.ViewPresenter.NewLoginProcess;


import android.content.Context;

import com.serviingo.serviingo.Rtrofit.ApiManager;
import com.serviingo.serviingo.modelrepo.Responsee.LoginRepo;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewUserLoginPresenter {

    private UserLoginView view;

    public NewUserLoginPresenter(UserLoginView view) {
        this.view = view;
    }


    public void UserLogin(Context context, String email, String pass,String device_token) {
        Call<LoginRepo> loginCall = ApiManager.getApi(context).userlogin(email, pass,device_token);
        //    Call<LoginRepo> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");
        view.showHideProgress(true);

        loginCall.enqueue(new Callback<LoginRepo>() {
            @Override
            public void onResponse(Call<LoginRepo> call, Response<LoginRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onUserLoginSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onUserLoginError(context, jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onUserLoginError(context, String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onUserLoginError(context, jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onUserLoginError(context, String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginRepo> call, Throwable t) {
                view.onUserLoginFailure(t);
                view.showHideProgress(false);

            }
        });

    }

    public void UserLoginWithNumberSendOTP(Context context, String Number) {
        Call<ResponseBody> loginCall = ApiManager.getApi(context).UserLoginWithNumberSendOTP(Number);
        //    Call<LoginRepo> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");
        view.showHideProgress(true);

        loginCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onUserLoginWithTOPSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onUserLoginError(context, jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onUserLoginError(context, String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onUserLoginError(context, jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onUserLoginError(context, String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                view.onUserLoginFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public interface UserLoginView {

        void onUserLoginError(Context context, String message);

        void onUserLoginSuccess(LoginRepo response, String message);
        void onUserLoginWithTOPSuccess(ResponseBody response, String message);

        void showHideProgress(boolean isShow);

        void onUserLoginFailure(Throwable t);
    }
}
