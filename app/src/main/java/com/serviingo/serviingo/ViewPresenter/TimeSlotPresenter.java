package com.serviingo.serviingo.ViewPresenter;


import android.content.Context;

import com.serviingo.serviingo.Rtrofit.ApiManager;
import com.serviingo.serviingo.modelrepo.Responsee.DateSlotRepo;
import com.serviingo.serviingo.modelrepo.Responsee.ServetimeSlotRepo;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TimeSlotPresenter {

    private TimeSlotView view;

    public TimeSlotPresenter(TimeSlotView view) {
        this.view = view;
    }


    public void DateSlotRepo(Context context, String id) {
        Call<DateSlotRepo> loginCall = ApiManager.getApi(context).ServeDatesSlot(id);
        //    Call<DateSlotRepo> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");
        view.showHideProgress(true);

        loginCall.enqueue(new Callback<DateSlotRepo>() {
            @Override
            public void onResponse(Call<DateSlotRepo> call, Response<DateSlotRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onDateSlotRepoSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onDateSlotRepoError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDateSlotRepoError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onDateSlotRepoError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDateSlotRepoError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<DateSlotRepo> call, Throwable t) {
                view.onDateSlotRepoFailure(t);
                view.showHideProgress(false);

            }
        });

    }

    public void TimeSlotRepo(Context context, String sub_category_id,String date) {
        Call<ServetimeSlotRepo> loginCall = ApiManager.getApi(context).ServetimeSlot(sub_category_id,date);
        //    Call<DateSlotRepo> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");
     //  view.showHideProgress(true);

        loginCall.enqueue(new Callback<ServetimeSlotRepo>() {
            @Override
            public void onResponse(Call<ServetimeSlotRepo> call, Response<ServetimeSlotRepo> response) {
                //view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onTimeSlotRepoSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onDateSlotRepoError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDateSlotRepoError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onDateSlotRepoError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDateSlotRepoError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ServetimeSlotRepo> call, Throwable t) {
                view.onDateSlotRepoFailure(t);
                view.showHideProgress(false);

            }
        });

    }

    public interface TimeSlotView {

        void onDateSlotRepoError(String message);

        void onDateSlotRepoSuccess(DateSlotRepo response, String message);

        void onTimeSlotRepoSuccess(ServetimeSlotRepo response, String message);

        void showHideProgress(boolean isShow);

        void onDateSlotRepoFailure(Throwable t);
    }
}
