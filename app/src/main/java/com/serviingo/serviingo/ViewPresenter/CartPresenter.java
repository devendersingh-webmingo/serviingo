package com.serviingo.serviingo.ViewPresenter;


import android.content.Context;
import android.util.Log;

import com.serviingo.serviingo.Rtrofit.ApiManager;
import com.serviingo.serviingo.modelrepo.Responsee.CartRepo;
import com.serviingo.serviingo.modelrepo.Responsee.CheckMinimumOrderPriceRepo;
import com.serviingo.serviingo.modelrepo.Responsee.CouponApplyRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.CheckMembershipDiscountRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.MyMembershipRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.WithoutTokenMembershipDetailsRepo;
import com.serviingo.serviingo.modelrepo.request.CartRequest;
import com.serviingo.serviingo.modelrepo.request.CouponApplyRequest;
import com.serviingo.serviingo.modelrepo.request.TempCartRequest;
import com.serviingo.serviingo.modelrepo.request.WithoutTokenMemberdeyailsRequest;
import com.serviingo.serviingo.storage.SharedPrefManager;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartPresenter {

    private CartListView view;

    public CartPresenter(CartListView view) {
        this.view = view;
    }

    public void GetAddonse(Context context, CartRequest cartRequest) {

        Call<CartRepo> loginCall = ApiManager.getApi(context).GetCart(cartRequest);
        //    Call<CartRepo> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");

        loginCall.enqueue(new Callback<CartRepo>() {
            @Override
            public void onResponse(Call<CartRepo> call, Response<CartRepo> response) {
                String s = null;

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {

                    try {

                        view.onCartListSuccess(response.body(), response.message());


                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onCartListError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onCartListError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onCartListError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onCartListError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<CartRepo> call, Throwable t) {
                view.onCartListFailure(t);
            }
        });

    }

    /*
        SharedPrefManager.getInstance(getActivity())
            .SetMembershipCost(String.valueOf(response.getData().getPlanDiscount()));*/
    public void CheckMinimumOrderPrice(Context context, String category_id) {
        Call<CheckMinimumOrderPriceRepo> loginCall = ApiManager.getApi(context).CheckMinimumOrderPrice(category_id);
        //    Call<CartRepo> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");

        loginCall.enqueue(new Callback<CheckMinimumOrderPriceRepo>() {
            @Override
            public void onResponse(Call<CheckMinimumOrderPriceRepo> call, Response<CheckMinimumOrderPriceRepo> response) {

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onCheckMinimumOrderPriceSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onCartListError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onCartListError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onCartListError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onCartListError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<CheckMinimumOrderPriceRepo> call, Throwable t) {
                view.onCartListFailure(t);
            }
        });

    }

    public void MyMembership(Context context) {
        Call<MyMembershipRepo> loginCall = ApiManager.getApi(context).MyMembership();
        //    Call<ResponseBody> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");

        loginCall.enqueue(new Callback<MyMembershipRepo>() {
            @Override
            public void onResponse(Call<MyMembershipRepo> call, Response<MyMembershipRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.GetMembershipSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onCartListError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onCartListError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onCartListError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onCartListError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<MyMembershipRepo> call, Throwable t) {
                view.onCartListFailure(t);
                view.showHideProgress(false);

            }
        });

    }

    public void TempCartRequest(Context context, TempCartRequest tempCartRequest) {
        Call<ResponseBody> loginCall = ApiManager.getApi(context).TempCartRequest(tempCartRequest);
        //    Call<CartRepo> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");

        loginCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.TempCartSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        //  view.onCartListError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        //   view.onCartListError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        // view.onCartListError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        // view.onCartListError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                view.onCartListFailure(t);
            }
        });

    }

    public void WithoutTokenMembershipDetailsRepo(Context context, WithoutTokenMemberdeyailsRequest tempCartRequest) {
        view.showHideProgress(true);
        Call<WithoutTokenMembershipDetailsRepo> loginCall = ApiManager.getApi(context).WithoutTokenMembershipDetailsRepo(tempCartRequest);
        //    Call<CartRepo> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");

        loginCall.enqueue(new Callback<WithoutTokenMembershipDetailsRepo>() {
            @Override
            public void onResponse(Call<WithoutTokenMembershipDetailsRepo> call, Response<WithoutTokenMembershipDetailsRepo> response) {

                view.showHideProgress(false);
                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.WithoutTokenMembershipDetailSucess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onCartListError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onCartListError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onCartListError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onCartListError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<WithoutTokenMembershipDetailsRepo> call, Throwable t) {

                view.showHideProgress(false);
                view.onCartListFailure(t);
            }
        });

    }

    public void CheckMembershipDiscountRepo(Context context, WithoutTokenMemberdeyailsRequest tempCartRequest) {
        view.showHideProgress(true);
        Call<CheckMembershipDiscountRepo> loginCall = ApiManager.getApi(context).CheckMembershipDiscount(tempCartRequest);
        //    Call<CartRepo> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");
        Log.e("Rupesssssss", String.valueOf(tempCartRequest.total_amount));

        loginCall.enqueue(new Callback<CheckMembershipDiscountRepo>() {
            @Override
            public void onResponse(Call<CheckMembershipDiscountRepo> call, Response<CheckMembershipDiscountRepo> response) {

                view.showHideProgress(false);
                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.CheckMembershipDiscountDetailSucess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onCartListError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onCartListError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onCartListError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onCartListError(String.valueOf(response.code()));
                    }
                } else if (response.code() == 422) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onCartListError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onCartListError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<CheckMembershipDiscountRepo> call, Throwable t) {

                view.showHideProgress(false);
                view.onCartListFailure(t);
            }
        });

    }


    public void CouponApply(Context context, CouponApplyRequest couponApplyRequest) {
        Call<CouponApplyRepo> loginCall = ApiManager.getApi(context).CouponApply(couponApplyRequest);
        //    Call<CartRepo> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");
        view.showHideProgress(true);

        loginCall.enqueue(new Callback<CouponApplyRepo>() {
            @Override
            public void onResponse(Call<CouponApplyRepo> call, Response<CouponApplyRepo> response) {

                view.showHideProgress(false);


                if (response.isSuccessful() && response.body() != null && response.code() == 200) {

                    try {

                        view.CouponApplySuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                         view.onCartListError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                          view.onCartListError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                         view.onCartListError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onCartListError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<CouponApplyRepo> call, Throwable t) {
                view.showHideProgress(false);
                view.onCartListFailure(t);
            }
        });

    }



    public interface CartListView {

        void onCartListError(String message);

        void onCartListSuccess(CartRepo response, String message);

        void onCheckMinimumOrderPriceSuccess(CheckMinimumOrderPriceRepo response, String message);

        void GetMembershipSuccess(MyMembershipRepo response, String message);

        void TempCartSuccess(ResponseBody response, String message);


        void CouponApplySuccess(CouponApplyRepo response, String message);



        void CheckMembershipDiscountDetailSucess(CheckMembershipDiscountRepo response, String message);

        void WithoutTokenMembershipDetailSucess(WithoutTokenMembershipDetailsRepo response, String message);

        void showHideProgress(boolean isShow);

        void onCartListFailure(Throwable t);
    }
}
