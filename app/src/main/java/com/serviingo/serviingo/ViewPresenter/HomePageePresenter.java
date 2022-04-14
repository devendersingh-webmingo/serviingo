package com.serviingo.serviingo.ViewPresenter;


import android.content.Context;
import android.util.Log;

import com.serviingo.serviingo.Rtrofit.ApiManager;
import com.serviingo.serviingo.modelrepo.Responsee.GetOrderNumbersRepo;
import com.serviingo.serviingo.modelrepo.Responsee.HomePageRepo;
import com.serviingo.serviingo.modelrepo.Responsee.HomeScreenFinacialServiceRepo;
import com.serviingo.serviingo.modelrepo.Responsee.SendReferralRepo;
import com.serviingo.serviingo.modelrepo.request.GenerateTicketRepo;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePageePresenter {

    private HomePageeView view;

    public HomePageePresenter(HomePageeView view) {
        this.view = view;
    }

    public void GetHomePageContent(Context context, String state) {
        Call<HomePageRepo> loginCall = ApiManager.getApi(context).GetHomePageContent(state);
        //    Call<ResponseBody> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");
        view.showHideProgress(true);

        loginCall.enqueue(new Callback<HomePageRepo>() {
            @Override
            public void onResponse(Call<HomePageRepo> call, Response<HomePageRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.GetHomePageeSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onHomePageeError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onHomePageeError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onHomePageeError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onHomePageeError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<HomePageRepo> call, Throwable t) {
                view.onHomePageFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public void SendReferralContent(Context context, String global) {
        Call<SendReferralRepo> loginCall = ApiManager.getApi(context).SendReferral(global);
        //    Call<ResponseBody> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");
        view.showHideProgress(true);

        loginCall.enqueue(new Callback<SendReferralRepo>() {
            @Override
            public void onResponse(Call<SendReferralRepo> call, Response<SendReferralRepo> response) {
                view.showHideProgress(false);
                Log.e("gh500", String.valueOf(response.code()));

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.SendReferralSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        Log.e("errorStr 500", response.errorBody().string());
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onHomePageeError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onHomePageeError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    view.onHomePageeError("Invalid Email id.Please Enter correctly");

                 /*   try {
                        String errorStr = response.errorBody().string();
                        Log.e("errorStr 400",response.errorBody().string());

                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onHomePageeError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onHomePageeError(String.valueOf(response.code()));
                    }*/
                }
            }

            @Override
            public void onFailure(Call<SendReferralRepo> call, Throwable t) {
                view.onHomePageFailure(t);
                view.showHideProgress(false);

            }
        });

    }

    public void GetFinancialServices(Context context) {
        Call<HomeScreenFinacialServiceRepo> loginCall = ApiManager.getApi(context).GetFinancialServices();
        //    Call<ResponseBody> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");
        view.showHideProgress(true);

        loginCall.enqueue(new Callback<HomeScreenFinacialServiceRepo>() {
            @Override
            public void onResponse(Call<HomeScreenFinacialServiceRepo> call, Response<HomeScreenFinacialServiceRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.GetFinancialServicesSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onHomePageeError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onHomePageeError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onHomePageeError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onHomePageeError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<HomeScreenFinacialServiceRepo> call, Throwable t) {
                view.onHomePageFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public interface HomePageeView {

        void onHomePageeError(String message);

        void GetHomePageeSuccess(HomePageRepo response, String message);

        void GetFinancialServicesSuccess(HomeScreenFinacialServiceRepo response, String message);

        void SendReferralSuccess(SendReferralRepo response, String message);

        void onHomePageFailure(Throwable t);

        void showHideProgress(boolean isShow);

    }
}
