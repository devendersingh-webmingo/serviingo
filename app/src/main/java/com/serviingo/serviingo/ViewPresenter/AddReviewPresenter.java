package com.serviingo.serviingo.ViewPresenter;


import android.content.Context;

import com.serviingo.serviingo.Rtrofit.ApiManager;
import com.serviingo.serviingo.modelrepo.request.AddressbookRequest;
import com.serviingo.serviingo.modelrepo.request.ReviewRequest;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddReviewPresenter {

    private AddReviewView view;

    public AddReviewPresenter(AddReviewView view) {
        this.view = view;
    }

    public void AddReview(Context context, ReviewRequest reviewRequest) {
        Call<ResponseBody> loginCall = ApiManager.getApi(context).AddReview(reviewRequest);

        loginCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onAddReviewSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code()==500){
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                      JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onAddReviewError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onAddReviewError(String.valueOf(response.code()));
                    }

                }else if (response.code()==401)
                {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onAddReviewError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onAddReviewError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                view.onAddReviewFailure(t);
            }
        });

    }

    public interface AddReviewView {

        void onAddReviewError(String message);

        void onAddReviewSuccess(ResponseBody response, String message);

        void onAddReviewFailure(Throwable t);
    }
}
