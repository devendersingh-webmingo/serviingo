package com.serviingo.serviingo.ViewPresenter;


import android.content.Context;

import com.serviingo.serviingo.Rtrofit.ApiManager;
import com.serviingo.serviingo.modelrepo.Responsee.CustomPackageRepo;
import com.serviingo.serviingo.modelrepo.Responsee.DiscountRepo;
import com.serviingo.serviingo.modelrepo.Responsee.ShowListPackageRepo;
import com.serviingo.serviingo.modelrepo.Responsee.ShowListPackageRepo;
import com.serviingo.serviingo.modelrepo.request.CustomPackageSUBSub_request;
import com.serviingo.serviingo.modelrepo.request.CustomPackage_request;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MakePackagePresenter {

    private MakePackageListView view;

    public MakePackagePresenter(MakePackageListView view) {
        this.view = view;
    }

    public void GetPackage(Context context, String id) {
        Call<ShowListPackageRepo> loginCall = ApiManager.getApi(context).GetPackage(id
        );

        loginCall.enqueue(new Callback<ShowListPackageRepo>() {
            @Override
            public void onResponse(Call<ShowListPackageRepo> call, Response<ShowListPackageRepo> response) {

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onMakePackagelistSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code()==500){
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                      JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onMakePackagelistError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onMakePackagelistError(String.valueOf(response.code()));
                    }

                }else if (response.code()==401)
                {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onMakePackagelistError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onMakePackagelistError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ShowListPackageRepo> call, Throwable t) {
                view.onMakePackagelistFailure(t);
            }
        });

    }

    public void Discount(Context context, String id) {
        Call<DiscountRepo> loginCall = ApiManager.getApi(context).Discount(id);

        loginCall.enqueue(new Callback<DiscountRepo>() {
            @Override
            public void onResponse(Call<DiscountRepo> call, Response<DiscountRepo> response) {

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onDiscoutSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code()==500){
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onMakePackagelistError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onMakePackagelistError(String.valueOf(response.code()));
                    }

                }else if (response.code()==401)
                {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onMakePackagelistError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onMakePackagelistError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<DiscountRepo> call, Throwable t) {
                view.onMakePackagelistFailure(t);
            }
        });

    }

    public void CustomPackage(Context context, CustomPackage_request customPackage_request) {
        Call<CustomPackageRepo> loginCall = ApiManager.getApi(context).CustomPackage(customPackage_request);

        loginCall.enqueue(new Callback<CustomPackageRepo>() {
            @Override
            public void onResponse(Call<CustomPackageRepo> call, Response<CustomPackageRepo> response) {

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onCustomPackageSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code()==500){
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onMakePackagelistError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onMakePackagelistError(String.valueOf(response.code()));
                    }

                }else if (response.code()==401)
                {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onMakePackagelistError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onMakePackagelistError(String.valueOf(response.code()));
                    }
                }else {
                    view.onMakePackagelistError(String.valueOf(response.code()));

                }
            }

            @Override
            public void onFailure(Call<CustomPackageRepo> call, Throwable t) {
                view.onMakePackagelistFailure(t);
            }
        });

    }


    public void CustomPackageSUBSub_request(Context context, CustomPackageSUBSub_request customPackage_request) {
        Call<CustomPackageRepo> loginCall = ApiManager.getApi(context).CustomPackageSUBSub_request(customPackage_request);

        loginCall.enqueue(new Callback<CustomPackageRepo>() {
            @Override
            public void onResponse(Call<CustomPackageRepo> call, Response<CustomPackageRepo> response) {

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onCustomPackageSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code()==500){
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onMakePackagelistError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onMakePackagelistError(String.valueOf(response.code()));
                    }

                }else if (response.code()==401)
                {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onMakePackagelistError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onMakePackagelistError(String.valueOf(response.code()));
                    }
                }else {
                    view.onMakePackagelistError(String.valueOf(response.code()));

                }
            }

            @Override
            public void onFailure(Call<CustomPackageRepo> call, Throwable t) {
                view.onMakePackagelistFailure(t);
            }
        });

    }

    public interface MakePackageListView {

        void onMakePackagelistError(String message);

        void onMakePackagelistSuccess(ShowListPackageRepo repo, String message);
        void onDiscoutSuccess(DiscountRepo repo, String message);
        void onCustomPackageSuccess(CustomPackageRepo repo, String message);

        void onMakePackagelistFailure(Throwable t);
    }
}
