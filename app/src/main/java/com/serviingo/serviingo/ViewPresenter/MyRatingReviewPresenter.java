package com.serviingo.serviingo.ViewPresenter;


import android.content.Context;

import com.serviingo.serviingo.Rtrofit.ApiManager;
import com.serviingo.serviingo.modelrepo.Responsee.MyRatingAndReviewRespooo;


import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyRatingReviewPresenter {

    private MyRatingReviewView view;

    public MyRatingReviewPresenter(MyRatingReviewView view) {
        this.view = view;
    }

    public void MyRatingReview(Context context) {
        Call<MyRatingAndReviewRespooo> loginCall = ApiManager.getApi(context).DoMyRatingAndReviewRespo();

        loginCall.enqueue(new Callback<MyRatingAndReviewRespooo>() {
            @Override
            public void onResponse(Call<MyRatingAndReviewRespooo> call, Response<MyRatingAndReviewRespooo> response) {

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onMyRatingReviewSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code()==500){
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                      JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onMyRatingReviewError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onMyRatingReviewError(String.valueOf(response.code()));
                    }

                }else if (response.code()==401)
                {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onMyRatingReviewError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onMyRatingReviewError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<MyRatingAndReviewRespooo> call, Throwable t) {
                view.onMyRatingReviewFailure(t);
            }
        });

    }

    public interface MyRatingReviewView {

        void onMyRatingReviewError(String message);

        void onMyRatingReviewSuccess(MyRatingAndReviewRespooo response, String message);

        void onMyRatingReviewFailure(Throwable t);
    }
}
