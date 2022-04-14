package com.serviingo.serviingo.Fragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.Adapterr.TicketchatListAdapter;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.Rtrofit.ApiManager;
import com.serviingo.serviingo.ViewPresenter.TicketChatPresenter;
import com.serviingo.serviingo.modelrepo.Responsee.AddAmountResponse;
import com.serviingo.serviingo.modelrepo.Responsee.TicketChatListRepo;
import com.serviingo.serviingo.modelrepo.request.EditReviewRequest;
import com.serviingo.serviingo.modelrepo.request.ReviewRequest;
import com.serviingo.serviingo.modelrepo.request.SendMessageReqest;
import com.serviingo.serviingo.utils.ImagePath;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;
import static com.serviingo.serviingo.R.drawable.globalloader;

public class ChatFragment extends Fragment implements TicketChatPresenter.TicketChatView,TicketchatListAdapter.MessageClickListener {

    RecyclerView recycler_view;
    TicketChatPresenter presenter;
    Bundle extras;
    String Id;
    ImageView iv_camera;
    EditText edittext_chatbox;
    TextView ivSend;
    ViewMessage viewMessage;
    Uri imageUri;
    String path = "null";

    SwipeRefreshLayout refreshLayout;
    private static final int PICK_IMAGE = 100;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        refreshLayout = view.findViewById(R.id.refreshLayout);

        setui(view);
        refreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {

                        // Your code goes here
                        // In this code, we are just
                        // changing the text in the textbox


                        setui(view);

                        // This line is important as it explicitly
                        // refreshes only once
                        // If "true" it implicitly refreshes forever
                        refreshLayout.setRefreshing(false);
                    }
                }
        );
        return view;
    }

    private void setui(View view) {
        viewMessage=new ViewMessage();
        recycler_view = view.findViewById(R.id.recycler_view);
        presenter=new TicketChatPresenter(this);
        iv_camera= view.findViewById(R.id.iv_camera);
        edittext_chatbox= view.findViewById(R.id.edittext_chatbox);
        ivSend= view.findViewById(R.id.ivSend);
        extras = getArguments();
        if (extras != null) {
            Id = getArguments().getString("id");
            presenter.TicketChatList(getContext(),Id);
        }
       // Toast.makeText(getContext(), Id + "", Toast.LENGTH_SHORT).show();


        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1, LinearLayoutManager.VERTICAL, false);
        recycler_view.setLayoutManager(gridLayoutManager);
        recycler_view.setHasFixedSize(true);
        ivSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edittext_chatbox.getText().toString().trim().isEmpty())
                {

                    Sneaker.with(getActivity())
                            .setTitle("Type a message")
                            .setMessage("")
                            .sneakError();
                }else {
                        if (path.equalsIgnoreCase("null"))
                        {
                            SendMessageReqest sendMessageReqest=new SendMessageReqest(Id,edittext_chatbox.getText().toString().trim());

                            presenter.SendMessagePresenter(getContext(),sendMessageReqest);
                        }else {
                            sendaddmony_offline(getContext(),Id, String.valueOf(edittext_chatbox.getText().toString().trim()),path);
                        }


                }
            }
        });

        iv_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                On_click_OpenGallery();

            }
        });

    }

    @Override
    public void onGenerateTicketError(String message) {

        Sneaker.with(getActivity())
                .setTitle(message)
                .setMessage("")
                .sneakError();


    }

    @Override
    public void GetOrderNumbersSuccess(TicketChatListRepo response, String message) {

        if (message.equalsIgnoreCase("ok"))
        {
            TicketchatListAdapter adapter=new TicketchatListAdapter(response,getContext(),this);
            recycler_view.setAdapter(adapter);
        }
     /*   Sneaker.with(getActivity())
                .setTitle(message)
                .setMessage("")
                .sneakError();
*/
    }

    @Override
    public void GetSendMessageSuccess(ResponseBody response, String message) {
       /* Sneaker.with(getActivity())
                .setTitle(message)
                .setMessage("")
                .sneakError();*/
        presenter.TicketChatList(getContext(),Id);
        edittext_chatbox.setText(" ");

    }

    @Override
    public void onGenerateTicketFailure(Throwable t) {
        Sneaker.with(getActivity())
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();

    }

    @Override
    public void showHideProgress(boolean isShow) {
        if (isShow) {
            AppTools.showRequestDialog(getActivity());

        } else {
            AppTools.hideDialog();

        }
    }

    public void On_click_OpenGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    public void ViewMediaClick(TicketChatListRepo repo, int position) {
        viewMessage.showDialog(getActivity(), String.valueOf(repo.data.chats.get(position).file));

        //Toast.makeText(getContext(), repo.data.chats.get(position).file+"", Toast.LENGTH_SHORT).show();
    }
    public class ViewMessage {

        AlertDialog alertDialog;
        ImageView imageviewMesg;


        public void showDialog(Activity activity, String image) {

            LayoutInflater inflater = LayoutInflater.from(activity);
            View view = inflater.inflate(R.layout.viewimagemessage, null);
            alertDialog = new AlertDialog.Builder(activity)
                    .setView(view)
                    .setCancelable(false)
                    .create();


            ImageView close = view.findViewById(R.id.close);
            imageviewMesg = view.findViewById(R.id.messageview);
           Picasso.get().load(image).into(imageviewMesg);

            close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss();
                }
            });



            alertDialog.show();
        }


    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        System.out.println("requestCode" + requestCode);
        switch (requestCode) {
            case ImagePath.REquestPermissionCode:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getActivity(), "Permissin Granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "Permissin Deined", Toast.LENGTH_SHORT).show();
                }


        }


    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    /*    if (requestCode == PICK_PHOTO_FOR_AVATAR && resultCode == RESULT_OK) {
            if (data == null)
                return;
            Uri uri = data.getData();
            System.out.println("urii  "+uri +" "+uri.getPath());
            String path  = ImagePath.getPath(context,uri);
            System.out.println("urii path "+path );
            if(path!=null && !path.equals("")) {
                File file = new File(path);
                Upload( file,loginResponse.getUserId());
                //uploadImage(file);
            }

        }*/

        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            if (data == null)
                return;

            Uri uri = data.getData();
            System.out.println("urii  " + uri + " " + uri.getPath());
            path   = ImagePath.getPath(getContext(), uri);
            System.out.println("urii path " + path);

            imageUri = data.getData();
            //circleImageView.setImageURI(imageUri);
            if (path != null && !path.equals("")) {
                File file = new File(path);
                System.out.println("filefilefile " + file);
                // Toast.makeText(getContext(), "done", Toast.LENGTH_SHORT).show();
               // Tv_UploadImage.setText(path);
              //uploadImage(file);

            }
            else {

                Toast.makeText(getContext(), "not", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void sendaddmony_offline(Context context, String ticket_id, String message,String pathh)
    {
        AppTools.showRequestDialog(getActivity());

        //  @Part MultipartBody.Part payment_screenshot);

        File file = new File(pathh);
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part filee =
                MultipartBody.Part.createFormData("file", file.getName(), requestFile);


        RequestBody ticket_idd = RequestBody.create(MediaType.parse("multipart/form-data"), ticket_id);
        RequestBody messagee = RequestBody.create(MediaType.parse("multipart/form-data"), message);

        Call<ResponseBody> userlist = ApiManager.getApi(context).SendMessageWithImage(ticket_idd,messagee,filee);

        userlist.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                // Toast.makeText(context, response.code() + "", Toast.LENGTH_LONG).show();
                AppTools.hideDialog();

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        //     Toast.makeText(context, response.body().getMessage() + "", Toast.LENGTH_LONG).show();
/*
                        Sneaker.with(getActivity())
                                .setTitle(response.body().string())
                                .setMessage("")
                                .sneakSuccess();*/
                        presenter.TicketChatList(getContext(),Id);
                        edittext_chatbox.setText(" ");
                        path = "null";



                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        String errorMsg = jsonObject.getString("status");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                AppTools.hideDialog();

                Log.e("onFailure", t.getLocalizedMessage());
            }
        });
    }


}