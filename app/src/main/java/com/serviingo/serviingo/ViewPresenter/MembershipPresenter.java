package com.serviingo.serviingo.ViewPresenter;


import android.content.Context;

import com.serviingo.serviingo.Rtrofit.ApiManager;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.BuyMembershipRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.MembershipContentRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.MembershipPlansRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.MyMembershipRepo;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MembershipPresenter {
    private MembershipView view;
    public MembershipPresenter(MembershipView view) {
        this.view = view;
    }
    public void MembershipContent(Context context) {
        Call<MembershipContentRepo> loginCall = ApiManager.getApi(context).MembershipContent();
        //    Call<BuyMembershipRepo> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");

        loginCall.enqueue(new Callback<MembershipContentRepo>() {
            @Override
            public void onResponse(Call<MembershipContentRepo> call, Response<MembershipContentRepo> response) {

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

                        view.onMembershipError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onMembershipError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onMembershipError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onMembershipError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<MembershipContentRepo> call, Throwable t) {
                view.onMembershipFailure(t);

            }
        });

    }
    public void MembershipPlan(Context context) {
        Call<MembershipPlansRepo> loginCall = ApiManager.getApi(context).MembershipPlan();
        //    Call<BuyMembershipRepo> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");

        loginCall.enqueue(new Callback<MembershipPlansRepo>() {
            @Override
            public void onResponse(Call<MembershipPlansRepo> call, Response<MembershipPlansRepo> response) {

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.GetMembershipPlanSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onMembershipError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onMembershipError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onMembershipError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onMembershipError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<MembershipPlansRepo> call, Throwable t) {
                view.onMembershipFailure(t);

            }
        });

    }
    public void BuyMembershipPlan(Context context,String membership_id) {
        view.showHideProgress(true);

        Call<BuyMembershipRepo> loginCall = ApiManager.getApi(context).BuyMyMembership(membership_id,"wallet"," "," "," ");
        //    Call<BuyMembershipRepo> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");

        loginCall.enqueue(new Callback<BuyMembershipRepo>() {
            @Override
            public void onResponse(Call<BuyMembershipRepo> call, Response<BuyMembershipRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.BuyMembershipPlanSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onMembershipError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onMembershipError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onMembershipError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onMembershipError(String.valueOf(response.code()));
                    }

                }
                else if (response.code() == 422) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onMembershipError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onMembershipError(String.valueOf(response.code()));
                    }

                }
            }

            @Override
            public void onFailure(Call<BuyMembershipRepo> call, Throwable t) {
                view.onMembershipFailure(t);
                view.showHideProgress(false);

            }
        });

    }
    public void MyMembership(Context context) {
        Call<MyMembershipRepo> loginCall = ApiManager.getApi(context).MyMembership();
        //    Call<BuyMembershipRepo> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");
        view.showHideProgress(true);

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

                        view.onMembershipError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onMembershipError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onMembershipError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onMembershipError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<MyMembershipRepo> call, Throwable t) {
                view.onMembershipFailure(t);
                view.showHideProgress(false);

            }
        });

    }
    public interface MembershipView {

        void onMembershipError(String message);

        void GetMembershipSuccess(MembershipContentRepo response, String message);
        void GetMembershipPlanSuccess(MembershipPlansRepo response, String message);

        void BuyMembershipPlanSuccess(BuyMembershipRepo response, String message);
        void GetMembershipSuccess(MyMembershipRepo response, String message);

        void onMembershipFailure(Throwable t);

        void showHideProgress(boolean isShow);

    }
}
