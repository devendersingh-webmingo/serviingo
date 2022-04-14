package com.serviingo.serviingo.ViewPresenter;


import android.content.Context;

import com.serviingo.serviingo.Rtrofit.ApiManager;
import com.serviingo.serviingo.modelrepo.Responsee.GetOrderDetailRepo;
import com.serviingo.serviingo.modelrepo.Responsee.ManageOrderListingRepo;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ManageOrderListingPresenter {

    private ManageOrderListingView view;

    public ManageOrderListingPresenter(ManageOrderListingView view) {
        this.view = view;
    }

    public void ManageOrderListing(Context context, String type) {
        view.showHideProgress(true);

        Call<ManageOrderListingRepo> loginCall = ApiManager.getApi(context).ManageOrderListing(type);

        loginCall.enqueue(new Callback<ManageOrderListingRepo>() {
            @Override
            public void onResponse(Call<ManageOrderListingRepo> call, Response<ManageOrderListingRepo> response) {
                view.showHideProgress(false);


                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onManageOrderListingSuccess(response.body(), response.message());
                        view.showHideProgress(false);

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code()==500){
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                      JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onManageOrderListingError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onManageOrderListingError(String.valueOf(response.code()));
                    }

                }else if (response.code()==401)
                {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onManageOrderListingError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onManageOrderListingError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ManageOrderListingRepo> call, Throwable t) {
                view.showHideProgress(false);

                view.onManageOrderListingFailure(t);

            }
        });

    }
    public void CancelOrder(Context context, String id,String reason,int query_type) {
        view.showHideProgress(true);

        Call<ResponseBody> loginCall = ApiManager.getApi(context).CancelOrder(id,reason,query_type);

        loginCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                view.showHideProgress(false);


                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onCancelOrderSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code()==500){
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onManageOrderListingError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onManageOrderListingError(String.valueOf(response.code()));
                    }

                }else if (response.code()==401)
                {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onManageOrderListingError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onManageOrderListingError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                view.onManageOrderListingFailure(t);
                view.showHideProgress(false);

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

                        view.onManageOrderListingError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onManageOrderListingError(String.valueOf(response.code()));
                    }

                }else if (response.code()==401)
                {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onManageOrderListingError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onManageOrderListingError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<GetOrderDetailRepo> call, Throwable t) {
                view.onManageOrderListingFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public interface ManageOrderListingView {

        void onManageOrderListingError(String message);

        void onManageOrderListingSuccess(ManageOrderListingRepo response, String message);
        void onCancelOrderSuccess(ResponseBody response, String message);

        void onGetOrderDetailSuccess(GetOrderDetailRepo response, String message);

        void onManageOrderListingFailure(Throwable t);
        void showHideProgress(boolean isShow);

    }
}
