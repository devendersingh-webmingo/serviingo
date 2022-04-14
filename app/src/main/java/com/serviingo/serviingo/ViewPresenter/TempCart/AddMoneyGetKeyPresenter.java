package com.serviingo.serviingo.ViewPresenter.TempCart;

import android.content.Context;

import com.serviingo.serviingo.Rtrofit.ApiManager;
import com.serviingo.serviingo.modelrepo.Responsee.Razorpay.AddWalletRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Razorpay.RazorpayRepo;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddMoneyGetKeyPresenter {


    private AddMoneyGetKeyView view;

    public AddMoneyGetKeyPresenter(AddMoneyGetKeyView view) {
        this.view = view;
    }


    public void GetRazorPayKey(Context context) {
        Call<RazorpayRepo> loginCall = ApiManager.getApi(context).GetRazorPayKey();
        //    Call<CartRepo> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");
        view.showHideProgress(true);

        loginCall.enqueue(new Callback<RazorpayRepo>() {
            @Override
            public void onResponse(Call<RazorpayRepo> call, Response<RazorpayRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.GetRazorPayKeySuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.AddMoneyGetKeyError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.AddMoneyGetKeyError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.AddMoneyGetKeyError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.AddMoneyGetKeyError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<RazorpayRepo> call, Throwable t) {
                view.AddMoneyGetKeyFailure(t);
                view.showHideProgress(false);

            }
        });

    }



    public interface AddMoneyGetKeyView {

        void AddMoneyGetKeyError(String message);

        void showHideProgress(boolean isShow);

        void GetRazorPayKeySuccess(RazorpayRepo response, String message);


        void AddMoneyGetKeyFailure(Throwable t);


    }
}
