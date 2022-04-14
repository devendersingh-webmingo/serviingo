package com.serviingo.serviingo.ViewPresenter;


import android.content.Context;

import com.serviingo.serviingo.Rtrofit.ApiManager;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.MembershipHistoryRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.MembershipHistoryRepo;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MembershipHistoryPresenter {

    private MembershipHistoryView view;

    public MembershipHistoryPresenter(MembershipHistoryView view) {
        this.view = view;
    }


    public void MembershipHistory(Context context) {
        Call<MembershipHistoryRepo> loginCall = ApiManager.getApi(context).MembershipHistory();
        //    Call<ResponseBody> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");
        view.showHideProgress(true);

        loginCall.enqueue(new Callback<MembershipHistoryRepo>() {
            @Override
            public void onResponse(Call<MembershipHistoryRepo> call, Response<MembershipHistoryRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.GetMembershipHistorySuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onMembershipHistoryError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onMembershipHistoryError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onMembershipHistoryError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onMembershipHistoryError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<MembershipHistoryRepo> call, Throwable t) {
                view.onMembershipHistoryFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public interface MembershipHistoryView {

        void onMembershipHistoryError(String message);

        void GetMembershipHistorySuccess(MembershipHistoryRepo response, String message);


        void onMembershipHistoryFailure(Throwable t);

        void showHideProgress(boolean isShow);

    }
}
