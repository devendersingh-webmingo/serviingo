package com.serviingo.serviingo.ViewPresenter;


import android.content.Context;

import com.serviingo.serviingo.Rtrofit.ApiManager;
import com.serviingo.serviingo.modelrepo.Responsee.MyTicketRepo;
import com.serviingo.serviingo.modelrepo.Responsee.CheckMinimumOrderPriceRepo;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyTicketPresenter {

    private MyTicketView view;

    public MyTicketPresenter(MyTicketView view) {
        this.view = view;
    }

    public void MyTicket(Context context) {
        Call<MyTicketRepo> loginCall = ApiManager.getApi(context).MyTicketList();
        //    Call<MyTicketRepo> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");
        view.showHideProgress(true);

        loginCall.enqueue(new Callback<MyTicketRepo>() {
            @Override
            public void onResponse(Call<MyTicketRepo> call, Response<MyTicketRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onMyTicketSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onMyTicketError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onMyTicketError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onMyTicketError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onMyTicketError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<MyTicketRepo> call, Throwable t) {
                view.onMyTicketFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public interface MyTicketView {

        void onMyTicketError(String message);

        void onMyTicketSuccess(MyTicketRepo response, String message);

        void onMyTicketFailure(Throwable t);
        void showHideProgress(boolean isShow);

    }
}
