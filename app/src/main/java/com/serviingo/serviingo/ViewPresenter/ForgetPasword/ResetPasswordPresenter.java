package com.serviingo.serviingo.ViewPresenter.ForgetPasword;


import android.content.Context;

import com.serviingo.serviingo.Rtrofit.ApiManager;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResetPasswordPresenter {

    private ResetPasswordView view;

    public ResetPasswordPresenter(ResetPasswordView view) {
        this.view = view;
    }

    public void ResetPassword(Context context, String userid,String otp,String password,String cpassword) {
        view.showHideProgress(true);

        Call<ResponseBody> loginCall = ApiManager.getApi(context).ResetPassword(userid,otp,password,cpassword);
        //    Call<ResponseBody> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");

        loginCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String s = null;
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {

                    try {

                        view.onResetPasswordSuccess(response.body(), response.message());


                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onResetPasswordError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onResetPasswordError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onResetPasswordError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onResetPasswordError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                view.onResetPasswordFailure(t);
                view.showHideProgress(false);

            }
        });

    }

    public interface ResetPasswordView {

        void onResetPasswordError(String message);

        void onResetPasswordSuccess(ResponseBody response, String message);


        void showHideProgress(boolean isShow);

        void onResetPasswordFailure(Throwable t);
    }
}
