package com.serviingo.serviingo.ViewPresenter;


import android.content.Context;

import com.serviingo.serviingo.Rtrofit.ApiManager;
import com.serviingo.serviingo.modelrepo.Responsee.GetOrderDetailRepo;
import com.serviingo.serviingo.modelrepo.request.EditReviewRequest;
import com.serviingo.serviingo.modelrepo.request.ReviewRequest;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateReviewPresenter {

    private UpdateReviewView view;

    public UpdateReviewPresenter(UpdateReviewView view) {
        this.view = view;
    }

    public void UpdateReview(Context context, EditReviewRequest reviewRequest) {
        Call<ResponseBody> loginCall = ApiManager.getApi(context).DoUpdateReview(reviewRequest);

        loginCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onUpdateReviewSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code()==500){
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                      JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onUpdateReviewError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onUpdateReviewError(String.valueOf(response.code()));
                    }

                }else if (response.code()==401)
                {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onUpdateReviewError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onUpdateReviewError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                view.onUpdateReviewFailure(t);
            }
        });

    }

    public void DeleteReview(Context context, String reviewId) {
        Call<ResponseBody> loginCall = ApiManager.getApi(context).DodeleteReview(reviewId);

        loginCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onDeleteReviewSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code()==500){
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onUpdateReviewError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onUpdateReviewError(String.valueOf(response.code()));
                    }

                }else if (response.code()==401)
                {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onUpdateReviewError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onUpdateReviewError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                view.onUpdateReviewFailure(t);
            }
        });

    }

    public void GetOrderDetail(Context context, String id) {

        view.showHideProgress(true);

        Call<GetOrderDetailRepo> loginCall = ApiManager.getApi(context).GetOrderDetail(id);

        loginCall.enqueue(new Callback<GetOrderDetailRepo>() {
            @Override
            public void onResponse(Call<GetOrderDetailRepo> call, Response<GetOrderDetailRepo> response) {
                view.showHideProgress(false);


                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onGetOrderDetailSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code()==500){
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onUpdateReviewError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onUpdateReviewError(String.valueOf(response.code()));
                    }

                }else if (response.code()==401)
                {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onUpdateReviewError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onUpdateReviewError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<GetOrderDetailRepo> call, Throwable t) {
                view.onUpdateReviewFailure(t);

                view.showHideProgress(false);

            }
        });

    }

    public interface UpdateReviewView {

        void onUpdateReviewError(String message);

       void onUpdateReviewSuccess(ResponseBody response, String message);
        void onDeleteReviewSuccess(ResponseBody response, String message);

        void onUpdateReviewFailure(Throwable t);
        void showHideProgress(boolean isShow);
        void onGetOrderDetailSuccess(GetOrderDetailRepo body, String message);
    }
}
