package com.serviingo.serviingo.ViewPresenter;


import android.content.Context;

import com.serviingo.serviingo.Rtrofit.ApiManager;
import com.serviingo.serviingo.modelrepo.Responsee.AddressbookRespo;
import com.serviingo.serviingo.modelrepo.request.AddressbookRequest;
import com.serviingo.serviingo.modelrepo.request.Changepassword_request;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddressBookPresenter {

    private AddressBookView view;

    public AddressBookPresenter(AddressBookView view) {
        this.view = view;
    }

    public void AddressBook(Context context, AddressbookRequest addressbookRequest) {
        Call<AddressbookRespo> loginCall = ApiManager.getApi(context).DoAddressbook(addressbookRequest);

        loginCall.enqueue(new Callback<AddressbookRespo>() {
            @Override
            public void onResponse(Call<AddressbookRespo> call, Response<AddressbookRespo> response) {

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onAddressBookSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code()==500){
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                      JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onAddressBookError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onAddressBookError(String.valueOf(response.code()));
                    }

                }else if (response.code()==401)
                {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onAddressBookError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onAddressBookError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<AddressbookRespo> call, Throwable t) {
                view.onAddressBookFailure(t);
            }
        });

    }

    public void onUpdateAddress(Context context, String id,AddressbookRequest addressbookRequest) {
        Call<ResponseBody> loginCall = ApiManager.getApi(context).DoUpdateAddress(id,addressbookRequest);

        loginCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onUpdateAddressSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code()==500){
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onAddressBookError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onAddressBookError(String.valueOf(response.code()));
                    }

                }else if (response.code()==401)
                {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1= jsonObject.getJSONObject("message");

                        view.onAddressBookError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onAddressBookError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                view.onAddressBookFailure(t);
            }
        });

    }


    public interface AddressBookView {

        void onAddressBookError(String message);

        void onAddressBookSuccess(AddressbookRespo response, String message);
        void onUpdateAddressSuccess(ResponseBody response, String message);

        void onAddressBookFailure(Throwable t);
    }
}
