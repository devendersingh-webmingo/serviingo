package com.serviingo.serviingo.ViewPresenter;


import android.content.Context;

import com.serviingo.serviingo.Rtrofit.ApiManager;
import com.serviingo.serviingo.modelrepo.Responsee.PackageReviews;
import com.serviingo.serviingo.modelrepo.Responsee.PackagesRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Subcategory_detailsRepo;
import com.serviingo.serviingo.modelrepo.Responsee.subsubcategory_detailsRepo;
import com.serviingo.serviingo.modelrepo.request.AddressbookRequest;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubSubCategoryPresenter {

    private SubSubCategoryView view;

    public SubSubCategoryPresenter(SubSubCategoryView view) {
        this.view = view;
    }

    public void SubSubCategory(Context context, String id) {
        Call<subsubcategory_detailsRepo> loginCall = ApiManager.getApi(context).GetSUBSubCategory(id);


        view.showHideProgress(true);

        loginCall.enqueue(new Callback<subsubcategory_detailsRepo>() {
            @Override
            public void onResponse(Call<subsubcategory_detailsRepo> call, Response<subsubcategory_detailsRepo> response) {
                view.showHideProgress(false);


                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onSubSubCategorySuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code()==500){
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                      JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onSubSubCategoryError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onSubSubCategoryError(String.valueOf(response.code()));
                    }

                }else if (response.code()==401)
                {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onSubSubCategoryError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onSubSubCategoryError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<subsubcategory_detailsRepo> call, Throwable t) {
                view.onSubSubCategoryFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public void SubCategory(Context context, String id) {
        Call<Subcategory_detailsRepo> loginCall = ApiManager.getApi(context).GetSubCategory(id);
        view.showHideProgress(true);


        loginCall.enqueue(new Callback<Subcategory_detailsRepo>() {
            @Override
            public void onResponse(Call<Subcategory_detailsRepo> call, Response<Subcategory_detailsRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onSubCategorySuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code()==500){
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onSubSubCategoryError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onSubSubCategoryError(String.valueOf(response.code()));
                    }

                }else if (response.code()==401)
                {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onSubSubCategoryError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onSubSubCategoryError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<Subcategory_detailsRepo> call, Throwable t) {
                view.onSubSubCategoryFailure(t);
                view.showHideProgress(false);

            }
        });

    }
    public void GetPackagelist(Context context, String id) {
        view.showHideProgress(true);

        Call<PackagesRepo> loginCall = ApiManager.getApi(context).GetPackagelist(id);

        loginCall.enqueue(new Callback<PackagesRepo>() {
            @Override
            public void onResponse(Call<PackagesRepo> call, Response<PackagesRepo> response) {
                view.showHideProgress(false);


                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onGetPackagelistSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code()==500){
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onSubSubCategoryError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onSubSubCategoryError(String.valueOf(response.code()));
                    }

                }else if (response.code()==401)
                {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onSubSubCategoryError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onSubSubCategoryError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<PackagesRepo> call, Throwable t) {
                view.onSubSubCategoryFailure(t);
                view.showHideProgress(false);

            }
        });

    }
    public void GetPackageReviews(Context context, String id) {
        Call<PackageReviews> loginCall = ApiManager.getApi(context).GetPackageReviews(id);
        view.showHideProgress(true);


        loginCall.enqueue(new Callback<PackageReviews>() {
            @Override
            public void onResponse(Call<PackageReviews> call, Response<PackageReviews> response) {

                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onGetPackageReviewsSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code()==500){
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onSubSubCategoryError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onSubSubCategoryError(String.valueOf(response.code()));
                    }

                }else if (response.code()==401)
                {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onSubSubCategoryError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onSubSubCategoryError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<PackageReviews> call, Throwable t) {
                view.showHideProgress(false);

                view.onSubSubCategoryFailure(t);
            }
        });

    }

    public interface SubSubCategoryView {

        void onSubSubCategoryError(String message);

        void onSubSubCategorySuccess(subsubcategory_detailsRepo response, String message);
        void onSubCategorySuccess(Subcategory_detailsRepo response, String message);
        void onGetPackagelistSuccess(PackagesRepo response, String message);

        void onGetPackageReviewsSuccess(PackageReviews response, String message);

        void showHideProgress(boolean isShow);


        void onSubSubCategoryFailure(Throwable t);
    }
}
