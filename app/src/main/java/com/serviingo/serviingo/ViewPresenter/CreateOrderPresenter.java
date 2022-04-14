package com.serviingo.serviingo.ViewPresenter;

import android.content.Context;

import com.serviingo.serviingo.Rtrofit.ApiManager;
import com.serviingo.serviingo.modelrepo.Responsee.AddonseRepo;
import com.serviingo.serviingo.modelrepo.Responsee.CreateOrderRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Profile_Repo;
import com.serviingo.serviingo.modelrepo.Responsee.Razorpay.RazorpayRepo;
import com.serviingo.serviingo.modelrepo.request.CreateOrderRequest;
import com.serviingo.serviingo.modelrepo.request.PaymentSignatureVerifyReq;
import com.serviingo.serviingo.modelrepo.request.TempCartRequest;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateOrderPresenter {


    private CreateOrderPresenterView view;

    public CreateOrderPresenter(CreateOrderPresenterView view) {
        this.view = view;
    }

    public void CreateOrder(Context context, CreateOrderRequest createOrderRequest) {
        view.showHideProgress(true);
        Call<CreateOrderRepo> loginCall = ApiManager.getApi(context).CreateOrder(createOrderRequest);

        loginCall.enqueue(new Callback<CreateOrderRepo>() {
            @Override
            public void onResponse(Call<CreateOrderRepo> call, Response<CreateOrderRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.CreateOrderSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code()==500){
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.CreateOrderError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.CreateOrderError(String.valueOf(response.code()));
                    }

                }else if (response.code()==401)
                {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.CreateOrderError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.CreateOrderError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<CreateOrderRepo> call, Throwable t) {
                view.showHideProgress(false);

                view.CreateOrderFailure(t);
            }
        });

    }

    public void DoMyprofil( Context context) {
        Call<Profile_Repo> loginCall =  ApiManager.getApi(context).Domyprofile();

        loginCall.enqueue(new Callback<Profile_Repo>() {
            @Override
            public void onResponse(Call<Profile_Repo> call, Response<Profile_Repo> response) {

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onDoMyprofileSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        String errorMsg = jsonObject.getString("status");
                        view.CreateOrderError(String.valueOf(response.code()));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.CreateOrderError(String.valueOf(response.code()));
                    }

                }
            }

            @Override
            public void onFailure(Call<Profile_Repo> call, Throwable t) {
                view.CreateOrderFailure(t);
            }
        });

    }

    public void GetRazorPayKey(Context context) {
        Call<RazorpayRepo> loginCall = ApiManager.getApi(context).GetRazorPayKey();
        //    Call<CartRepo> loginCall = ApiManager.getApi(context).GetCart( "38","47,48");
        view.showHideProgress(true);

        loginCall.enqueue(new Callback<RazorpayRepo>() {
            @Override
            public void onResponse(Call<RazorpayRepo> call, Response<RazorpayRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.GetRazorPayKeySuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.CreateOrderError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.CreateOrderError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.CreateOrderError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.CreateOrderError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<RazorpayRepo> call, Throwable t) {
                view.CreateOrderFailure(t);
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

                        view.CreateOrderError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.CreateOrderError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.CreateOrderError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.CreateOrderError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                view.CreateOrderFailure(t);
            }
        });

    }

    public void PaymentSignatureVerifyReq(Context context, PaymentSignatureVerifyReq createOrderRequest) {
        view.showHideProgress(true);
        Call<ResponseBody> loginCall = ApiManager.getApi(context).PaymentSignatureVerifyReq(createOrderRequest);

        loginCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.PaymentSignatureVerifyReqSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code()==500){
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.CreateOrderError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.CreateOrderError(String.valueOf(response.code()));
                    }

                }else if (response.code()==401)
                {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.CreateOrderError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.CreateOrderError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                view.showHideProgress(false);

                view.CreateOrderFailure(t);
            }
        });

    }

    public interface CreateOrderPresenterView {

        void CreateOrderError(String message);

        void showHideProgress(boolean isShow);
        void TempCartSuccess(ResponseBody response, String message);
        void GetRazorPayKeySuccess(RazorpayRepo response, String message);
        void PaymentSignatureVerifyReqSuccess(ResponseBody response, String message);

        void CreateOrderSuccess(CreateOrderRepo response,  String message);

        void onDoMyprofileSuccess( Profile_Repo response, String message);

        void CreateOrderFailure(Throwable t);


    }
}
