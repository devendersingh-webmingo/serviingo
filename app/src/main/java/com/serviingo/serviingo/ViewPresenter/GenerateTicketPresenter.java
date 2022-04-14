package com.serviingo.serviingo.ViewPresenter;


import android.content.Context;

import com.serviingo.serviingo.Rtrofit.ApiManager;

import com.serviingo.serviingo.modelrepo.Responsee.GetOrderNumbersRepo;
import com.serviingo.serviingo.modelrepo.Responsee.GetTransactionRepo;
import com.serviingo.serviingo.modelrepo.Responsee.SupportQuestionRepo;
import com.serviingo.serviingo.modelrepo.request.GenerateTicketRepo;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GenerateTicketPresenter {

    private GenerateTicketView view;

    public GenerateTicketPresenter(GenerateTicketView view) {
        this.view = view;
    }

    public void GenerateTicket(Context context, GenerateTicketRepo repo) {
        Call<ResponseBody> loginCall = ApiManager.getApi(context).GenerateTicket(repo);
        //    Call<ResponseBody> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");
        view.showHideProgress(true);

        loginCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onGenerateTicketSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onGenerateTicketError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onGenerateTicketError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onGenerateTicketError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onGenerateTicketError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                view.onGenerateTicketFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public void GetSupportQuestion(Context context, String key) {
        Call<SupportQuestionRepo> loginCall = ApiManager.getApi(context).GetSupportQuestion(key);
        //    Call<ResponseBody> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");
        view.showHideProgress(true);

        loginCall.enqueue(new Callback<SupportQuestionRepo>() {
            @Override
            public void onResponse(Call<SupportQuestionRepo> call, Response<SupportQuestionRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.GetSupportQuestionSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onGenerateTicketError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onGenerateTicketError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onGenerateTicketError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onGenerateTicketError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<SupportQuestionRepo> call, Throwable t) {
                view.onGenerateTicketFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public interface GenerateTicketView {

        void onGenerateTicketError(String message);

        void onGenerateTicketSuccess(ResponseBody response, String message);
        void GetSupportQuestionSuccess(SupportQuestionRepo response, String message);




        void onGenerateTicketFailure(Throwable t);

        void showHideProgress(boolean isShow);

    }
}
