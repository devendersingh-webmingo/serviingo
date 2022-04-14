package com.serviingo.serviingo.ViewPresenter;


import android.content.Context;

import com.serviingo.serviingo.Rtrofit.ApiManager;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.PackageviewDetailsRepo;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PackageviewDetailsPresenter {

    private PackageviewDetailsView view;

    public PackageviewDetailsPresenter(PackageviewDetailsView view) {
        this.view = view;
    }

     public void GetHomePageContent(Context context ,String id) {
        Call<PackageviewDetailsRepo> loginCall = ApiManager.getApi(context).GetPackageDetails(id);
        //    Call<ResponseBody> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");
        view.showHideProgress(true);

        loginCall.enqueue(new Callback<PackageviewDetailsRepo>() {
            @Override
            public void onResponse(Call<PackageviewDetailsRepo> call, Response<PackageviewDetailsRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onPackageDeatilsSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onPacakgeDetailsError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onPacakgeDetailsError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onPacakgeDetailsError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onPacakgeDetailsError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<PackageviewDetailsRepo> call, Throwable t) {
                view.onPackageDetailsFailure(t);
                view.showHideProgress(false);

            }
        });

    }



    public interface PackageviewDetailsView {

        void onPacakgeDetailsError(String message);

        void onPackageDeatilsSuccess(PackageviewDetailsRepo response, String message);
        void onPackageDetailsFailure(Throwable t);
        void showHideProgress(boolean isShow);

    }
}
