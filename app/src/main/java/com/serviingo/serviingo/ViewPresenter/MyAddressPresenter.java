package com.serviingo.serviingo.ViewPresenter;


import android.content.Context;

import com.serviingo.serviingo.Rtrofit.ApiManager;
import com.serviingo.serviingo.modelrepo.Responsee.AddressbookRespo;
import com.serviingo.serviingo.modelrepo.Responsee.MyAddressRepoo;
import com.serviingo.serviingo.modelrepo.request.AddressbookRequest;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyAddressPresenter {

    private MyAddressView view;

    public MyAddressPresenter(MyAddressView view) {
        this.view = view;
    }

    public void MyAddressList(Context context) {
        Call<MyAddressRepoo> loginCall = ApiManager.getApi(context).DoMyAddresss();

        loginCall.enqueue(new Callback<MyAddressRepoo>() {
            @Override
            public void onResponse(Call<MyAddressRepoo> call, Response<MyAddressRepoo> response) {

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onMyAddressSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code()==500){
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                      JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onMyAddressError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onMyAddressError(String.valueOf(response.code()));
                    }

                }else if (response.code()==401)
                {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onMyAddressError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onMyAddressError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<MyAddressRepoo> call, Throwable t) {
                view.onMyAddressFailure(t);
            }
        });

    }
    public void DeleteAddress(Context context, String addressId) {
        Call<ResponseBody> loginCall = ApiManager.getApi(context).DoDeleteAddress(addressId);

        loginCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onDeleteAddressSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code()==500){
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onMyAddressError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onMyAddressError(String.valueOf(response.code()));
                    }

                }else if (response.code()==401)
                {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onMyAddressError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onMyAddressError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                view.onMyAddressFailure(t);
            }
        });

    }
    public interface MyAddressView {

        void onMyAddressError(String message);

        void onMyAddressSuccess(MyAddressRepoo response, String message);
        void onDeleteAddressSuccess(ResponseBody response, String message);


        void onMyAddressFailure(Throwable t);
    }
}
