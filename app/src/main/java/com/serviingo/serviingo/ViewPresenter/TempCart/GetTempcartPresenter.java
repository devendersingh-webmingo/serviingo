package com.serviingo.serviingo.ViewPresenter.TempCart;


import android.content.Context;

import com.serviingo.serviingo.Rtrofit.ApiManager;
import com.serviingo.serviingo.modelrepo.Responsee.IncompletedBookingRepo;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetTempcartPresenter {

    private GetTempcartView view;

    public GetTempcartPresenter(GetTempcartView view) {
        this.view = view;
    }


    public void GetTempcartRepo(Context context) {
        Call<IncompletedBookingRepo> loginCall = ApiManager.getApi(context).IncompletedBooking();
        //    Call<GetTempcartRepo> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");
        view.showHideProgress(true);

        loginCall.enqueue(new Callback<IncompletedBookingRepo>() {
            @Override
            public void onResponse(Call<IncompletedBookingRepo> call, Response<IncompletedBookingRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onGetTempcartRepoSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onGetTempcartRepoError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onGetTempcartRepoError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onGetTempcartRepoError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onGetTempcartRepoError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<IncompletedBookingRepo> call, Throwable t) {
                view.onGetTempcartRepoFailure(t);
                view.showHideProgress(false);

            }
        });

    }
    public void DeleteTempcart(Context context,String id) {
        Call<ResponseBody> loginCall = ApiManager.getApi(context).DoDeleteTempCart(id);
        //    Call<GetTempcartRepo> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");
        view.showHideProgress(true);

        loginCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onDeleteTempcartRepoSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onGetTempcartRepoError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onGetTempcartRepoError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onGetTempcartRepoError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onGetTempcartRepoError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                view.onGetTempcartRepoFailure(t);
                view.showHideProgress(false);

            }
        });

    }

    public interface GetTempcartView {

        void onGetTempcartRepoError(String message);

        void onGetTempcartRepoSuccess(IncompletedBookingRepo response, String message);
        void onDeleteTempcartRepoSuccess(ResponseBody response, String message);

        void showHideProgress(boolean isShow);

        void onGetTempcartRepoFailure(Throwable t);
    }
}
