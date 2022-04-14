package com.serviingo.serviingo.ViewPresenter;


import android.content.Context;

import com.serviingo.serviingo.Rtrofit.ApiManager;
import com.serviingo.serviingo.modelrepo.Responsee.CancelOrderQuestionsRepo;
import com.serviingo.serviingo.modelrepo.request.Reschedule_request;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CancelOrderQuestionsPresenter {

    private CancelOrderQuestionsView view;

    public CancelOrderQuestionsPresenter(CancelOrderQuestionsView view) {
        this.view = view;
    }

     public void CancelOrderQuestions(Context context) {
        Call<CancelOrderQuestionsRepo> loginCall = ApiManager.getApi(context).GetCancelOrderQuestionsRepo();
        //    Call<ResponseBody> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");

        loginCall.enqueue(new Callback<CancelOrderQuestionsRepo>() {
            @Override
            public void onResponse(Call<CancelOrderQuestionsRepo> call, Response<CancelOrderQuestionsRepo> response) {


                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.AboutPageeSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onaboutPageeError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onaboutPageeError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onaboutPageeError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onaboutPageeError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<CancelOrderQuestionsRepo> call, Throwable t) {
                view.onaboutPageFailure(t);


            }
        });

    }

    public void ReSchedule(Context context, Reschedule_request reschedule_request) {
        Call<ResponseBody> loginCall = ApiManager.getApi(context).ReSchedule(reschedule_request);
        //    Call<ResponseBody> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");

        loginCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {


                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.ReScheduleSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onaboutPageeError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onaboutPageeError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onaboutPageeError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onaboutPageeError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                view.onaboutPageFailure(t);


            }
        });

    }



    public interface CancelOrderQuestionsView {

        void onaboutPageeError(String message);

        void AboutPageeSuccess(CancelOrderQuestionsRepo response, String message);
        void ReScheduleSuccess(ResponseBody response, String message);
        void onaboutPageFailure(Throwable t);

    }
}
