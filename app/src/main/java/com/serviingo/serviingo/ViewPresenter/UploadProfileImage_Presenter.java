package com.serviingo.serviingo.ViewPresenter;


import android.content.Context;

import com.serviingo.serviingo.Rtrofit.ApiManager;

import com.serviingo.serviingo.modelrepo.Responsee.Profile_Repo;

import org.json.JSONObject;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UploadProfileImage_Presenter {

    private UploadProfileImageView view;

    public UploadProfileImage_Presenter(UploadProfileImageView view) {
        this.view = view;
    }
    public void uploadImage(MultipartBody.Part image, Context context){
        Call<Profile_Repo> call = ApiManager.getApi(context).uploadPic(image);
        call.enqueue(new Callback<Profile_Repo>() {
            @Override
            public void onResponse(Call<Profile_Repo> call, Response<Profile_Repo> response) {
                if (response.isSuccessful() && response.code() == 200 && response.body() != null) {
                    view.onUploadProfileImageSuccess(response.body(),response.message());
                } else {
                    try {
                        String errorRes = response.errorBody().string();
                        JSONObject jsonObject =new JSONObject(errorRes);
                        String err_msg  = jsonObject.getString("error");
                        int status= jsonObject.getInt("status");
                        view.onUploadProfileImageError(err_msg);
                    }
                    catch (Exception ex){
                        ex.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<Profile_Repo> call, Throwable t) {
                view.onUploadProfileImageFailure(t);
            }
        });

    }

    public interface UploadProfileImageView {

        void onUploadProfileImageError(String message);

        void onUploadProfileImageSuccess(Profile_Repo response, String message);

        void onUploadProfileImageFailure(Throwable t);
    }
}
