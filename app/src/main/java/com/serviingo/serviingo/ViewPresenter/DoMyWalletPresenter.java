package com.serviingo.serviingo.ViewPresenter;


import android.content.Context;

import com.serviingo.serviingo.Rtrofit.ApiManager;
import com.serviingo.serviingo.modelrepo.Responsee.MywalletRespo;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoMyWalletPresenter {


    private  DoMyWalletView  view;

    public DoMyWalletPresenter(DoMyWalletView view) {
        this.view = view;
    }

    public void DoMyprofil( Context context) {
        Call<MywalletRespo> loginCall =  ApiManager.getApi(context).DoMyWallet();

        loginCall.enqueue(new Callback<MywalletRespo>() {
            @Override
            public void onResponse(Call<MywalletRespo> call, Response<MywalletRespo> response) {

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onDoMyWalletSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        String errorMsg = jsonObject.getString("status");
                        view.onDoMyWalleteError(String.valueOf(response.code()));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDoMyWalleteError(String.valueOf(response.code()));
                    }

                }
            }

            @Override
            public void onFailure(Call<MywalletRespo> call, Throwable t) {
                view.onDoMyWalletFailure(t);
            }
        });

    }

    public interface DoMyWalletView {

        void onDoMyWalleteError(String message);

        void onDoMyWalletSuccess( MywalletRespo response, String message);

        void onDoMyWalletFailure(Throwable t);
    }
}
