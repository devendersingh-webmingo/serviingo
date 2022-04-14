package com.serviingo.serviingo.ViewPresenter;


import android.content.Context;

import com.serviingo.serviingo.Rtrofit.ApiManager;
import com.serviingo.serviingo.modelrepo.Responsee.UpdateProfileRepo;
import com.serviingo.serviingo.modelrepo.request.UpdateProfile_request;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoMyprofileUpdatePresenter {


    private  DoMyprofileUpdateView  view;

    public DoMyprofileUpdatePresenter(DoMyprofileUpdateView view) {
        this.view = view;
    }

    public void DoMyprofil(Context context, UpdateProfile_request updateProfile_request) {

        view.showHideProgress(true);
        Call<UpdateProfileRepo> loginCall =  ApiManager.getApi(context).DoMyprofileUpdate(updateProfile_request);

        loginCall.enqueue(new Callback<UpdateProfileRepo>() {
            @Override
            public void onResponse(Call<UpdateProfileRepo> call, Response<UpdateProfileRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onDoMyprofileUpdateSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        String errorMsg = jsonObject.getString("status");
                        view.onDoMyprofileUpdateError(String.valueOf(response.code()));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDoMyprofileUpdateError(String.valueOf(response.code()));
                    }

                }
            }

            @Override
            public void onFailure(Call<UpdateProfileRepo> call, Throwable t) {
                view.onDoMyprofileUpdateFailure(t);
                view.showHideProgress(false);
            }
        });

    }

    public interface DoMyprofileUpdateView {

        void onDoMyprofileUpdateError(String message);

        void onDoMyprofileUpdateSuccess( UpdateProfileRepo response, String message);
        void showHideProgress(boolean isShow);

        void onDoMyprofileUpdateFailure(Throwable t);
    }
}
