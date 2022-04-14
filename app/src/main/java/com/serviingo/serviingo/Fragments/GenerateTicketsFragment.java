package com.serviingo.serviingo.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.Adapterr.BookingRelatedAdapter;
import com.serviingo.serviingo.Adapterr.CancelorderQuestionAdapter;
import com.serviingo.serviingo.Adapterr.SelectAddressAdapter;
import com.serviingo.serviingo.Adapterr.TransationAdapter;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.Rtrofit.ApiManager;
import com.serviingo.serviingo.ViewPresenter.GenerateTicketPresenter;
import com.serviingo.serviingo.model.CancelOrderQuestionmodel;
import com.serviingo.serviingo.modelrepo.Responsee.GetOrderNumbersRepo;
import com.serviingo.serviingo.modelrepo.Responsee.GetTransactionRepo;
import com.serviingo.serviingo.modelrepo.Responsee.SupportQuestionRepo;
import com.serviingo.serviingo.modelrepo.request.GenerateTicketRepo;
import com.serviingo.serviingo.modelrepo.request.SendMessageReqest;
import com.serviingo.serviingo.utils.ImagePath;

import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

import static android.app.Activity.RESULT_OK;
import static com.serviingo.serviingo.R.drawable.globalloader;

public class GenerateTicketsFragment extends Fragment implements GenerateTicketPresenter.GenerateTicketView {

    GenerateTicketPresenter generateTicketPresenter;
    GenerateTicketRepo request;
    Spinner SubjectSpinner, PrioritySpinner, transactionSpinner;
    EditText Query, OtherIssueTV;
    TextView SupportTickets, transactionTV, Tv_UploadImage;
    String[] Subject = {"Select Query Module", "Order", "Services", "Payment", "Rating & Review", "Others"};//array of strings used to populate the spinner

    String[] PrioritySpinnerArray = {"Normal", "Medium", "High"};
    private static final int PICK_IMAGE = 100;

    private String priority, query_statement, query_module, subject_type_id = " ";
    ;

    Uri imageUri;
    String path = "null";
    List<CancelOrderQuestionmodel> list = new ArrayList<>();


    public GenerateTicketsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_generate_tickets, container, false);
        intiView(view);

        return view;
    }

    private void intiView(View view) {
        generateTicketPresenter = new GenerateTicketPresenter(this);

        SubjectSpinner = view.findViewById(R.id.SubjectSpinner);
        PrioritySpinner = view.findViewById(R.id.PrioritySpinner);


        Query = view.findViewById(R.id.Query);
        SupportTickets = view.findViewById(R.id.SupportTickets);
        transactionTV = view.findViewById(R.id.transactionTV);
        Tv_UploadImage = view.findViewById(R.id.Tv_UploadImage);
        transactionSpinner = view.findViewById(R.id.transactionSpinner);
        OtherIssueTV = view.findViewById(R.id.OtherIssueTV);
//generateTicketPresenter.MyTicket(getContext(),request);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, Subject);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//Setting the ArrayAdapter data on the Spinner
        SubjectSpinner.setAdapter(aa);
        SubjectSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Toast.makeText(getActivity(), position + "", Toast.LENGTH_SHORT).show();


                if (position == 0) {

                    OtherIssueTV.setVisibility(View.GONE);
                    transactionSpinner.setVisibility(View.GONE);
                    query_module = "orderrrr";
                    subject_type_id = " ";

                } else if (position == 1) {
                    transactionTV.setText("Subject Query");

                    OtherIssueTV.setVisibility(View.GONE);
                    transactionSpinner.setVisibility(View.VISIBLE);
                    query_module = "order";
                    generateTicketPresenter.GetSupportQuestion(getContext(), query_module);

              /*     generateTicketPresenter.GetOrderNumbers(getContext());
                    subject_type = "1";
*/

                } else if (position == 2) {
                    transactionTV.setText("Subject Query");
                    OtherIssueTV.setVisibility(View.GONE);
                    transactionSpinner.setVisibility(View.VISIBLE);
                    query_module = "service";

                    generateTicketPresenter.GetSupportQuestion(getContext(), query_module);

                  /*  generateTicketPresenter.GetTransactionlist(getContext());

                    subject_type = "2";*/

                } else if (position == 3) {
                    transactionTV.setText("Subject Query");
                    OtherIssueTV.setVisibility(View.GONE);
                    transactionSpinner.setVisibility(View.VISIBLE);
                    query_module = "payment";

                    generateTicketPresenter.GetSupportQuestion(getContext(), query_module);

                  /*  generateTicketPresenter.GetTransactionlist(getContext());

                    subject_type = "2";*/

                } else if (position == 4) {
                    transactionTV.setText("Subject Query");
                    OtherIssueTV.setVisibility(View.GONE);
                    transactionSpinner.setVisibility(View.VISIBLE);
                    query_module = "rating";

                    generateTicketPresenter.GetSupportQuestion(getContext(), query_module);

                  /*  generateTicketPresenter.GetTransactionlist(getContext());

                    subject_type = "2";*/

                } else if (position == 5) {
                    transactionSpinner.setVisibility(View.GONE);
                    OtherIssueTV.setVisibility(View.VISIBLE);
                    transactionTV.setText("Other Issue");
                    query_module = "other";
                }

                //  Toast.makeText(getActivity(), parent.getItemAtPosition(position).toString().trim()+"", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<String> aaa = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, PrioritySpinnerArray);
        aaa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//Setting the ArrayAdapter data on the Spinner
        PrioritySpinner.setAdapter(aaa);
        PrioritySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //  Toast.makeText(getActivity(), position + "", Toast.LENGTH_SHORT).show();
                priority = parent.getItemAtPosition(position).toString().trim();
                // Toast.makeText(getActivity(), parent.getItemAtPosition(position).toString().trim() + "", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Tv_UploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                On_click_OpenGallery();

            }
        });


        SupportTickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GenerateTicketApi();

                // generateTicketPresenter.GenerateTicket(getContext(),request);
            }
        });

    }

    private void GenerateTicketApi() {

        query_statement = Query.getText().toString().trim();
        //query_statement

        if (query_statement.isEmpty()) {
            Sneaker.with(getActivity())
                    .setTitle("Enter your Query ")
                    .setMessage("")
                    .sneakError();
        } else if (subject_type_id.equalsIgnoreCase("0")) {
            Sneaker.with(getActivity())
                    .setTitle("The query statement field is required. ")
                    .setMessage("")
                    .sneakError();

        } else if (query_module.equalsIgnoreCase("orderrrr")) {


            Sneaker.with(getActivity())
                    .setTitle("The Subject Query   field is required. ")
                    .setMessage("")
                    .sneakError();

        } else {

            if (path.equalsIgnoreCase("null")) {
                if (query_module.equalsIgnoreCase("other")) {


                    if (!OtherIssueTV.getText().toString().trim().isEmpty()) {
                        request = new GenerateTicketRepo(OtherIssueTV.getText().toString(), query_module, query_statement, priority, " ");
                        generateTicketPresenter.GenerateTicket(getContext(), request);

                    } else {

                        Sneaker.with(getActivity())
                                .setTitle("The Other Subject is required. ")
                                .setMessage("")
                                .sneakError();

                    }

                } else {
                    request = new GenerateTicketRepo(" ",query_module, query_statement, priority,subject_type_id);
                    generateTicketPresenter.GenerateTicket(getContext(), request);
                }


            } else {
               // Context context, String other_subject, String booking_id, String transaction_id,String subject_type,String query_statement,String priority,String  pathh)
                if (query_module.equalsIgnoreCase("other")) {


                    if (!OtherIssueTV.getText().toString().trim().isEmpty()) {


                        GenerateTicketWithImage(getContext(), OtherIssueTV.getText().toString(), query_module, query_statement, priority," ", path);


                    } else {

                        Sneaker.with(getActivity())
                                .setTitle("The Other Subject is required. ")
                                .setMessage("")
                                .sneakError();

                    }

                } else {
                    GenerateTicketWithImage(getContext(), " ", query_module, query_statement, priority,subject_type_id, path);

                }

            }
        }


    }

    @Override
    public void onGenerateTicketError(String message) {
        Sneaker.with(getActivity())
                .setTitle(message)
                .setMessage("")
                .sneakError();
    }

    @Override
    public void onGenerateTicketSuccess(ResponseBody response, String message) {

        if (message.equalsIgnoreCase("ok")) {
            Sneaker.with(getActivity())
                    .setTitle("Your Ticket Successfully Submitted.")
                    .setMessage("")
                    .sneakSuccess();


            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            Fragment fragment = new SupportTicketsFragment();
            fragmentTransaction.replace(R.id.fragment_Container, fragment);
            fragmentTransaction.addToBackStack(null);

            fragmentTransaction.commit();
        }

    }


    @Override
    public void GetSupportQuestionSuccess(SupportQuestionRepo response, String message) {


        if (message.equalsIgnoreCase("ok")) {
            list.clear();
            subject_type_id=" ";
            transactionSpinner.setVisibility(View.GONE);
            if (response.getData().size() > 0) {
                transactionSpinner.setVisibility(View.VISIBLE);

                list.add(new CancelOrderQuestionmodel("Select Query ", 0000));
                for (int i = 0; i < response.getData().size(); i++) {

                    CancelOrderQuestionmodel itemData = new CancelOrderQuestionmodel(response.getData().get(i).getQueries(),
                            response.getData().get(i).getId());

                    list.add(itemData);

                }


                CancelorderQuestionAdapter countrySpinnerAdapter = new CancelorderQuestionAdapter(getContext(), R.id.coinName, list);
                transactionSpinner.setAdapter(countrySpinnerAdapter);
                transactionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        //   query_type = list.get(position).getId();

                      //  Toast.makeText(getContext(), list.get(position).getId() + "", Toast.LENGTH_SHORT).show();


                        subject_type_id = String.valueOf(list.get(position).getId());


                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });

            }
        }


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

    private void GenerateTicketWithImage(Context context, String other_subject, String query_module, String query_statement, String priority, String subject_type_id,  String pathh) {
        AppTools.showRequestDialog(getActivity());

        //  @Part MultipartBody.Part payment_screenshot);

        File file = new File(pathh);
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part filee =
                MultipartBody.Part.createFormData("file", file.getName(), requestFile);


        RequestBody other_subjectt = RequestBody.create(MediaType.parse("multipart/form-data"), other_subject);
        RequestBody query_modulee = RequestBody.create(MediaType.parse("multipart/form-data"), query_module);

        RequestBody query_statementt = RequestBody.create(MediaType.parse("multipart/form-data"), query_statement);
        RequestBody priorityy = RequestBody.create(MediaType.parse("multipart/form-data"), priority);
        RequestBody subject_type_idd = RequestBody.create(MediaType.parse("multipart/form-data"), subject_type_id);








        Call<ResponseBody> userlist = ApiManager.getApi(context).GenerateTicketwithImage(other_subjectt, query_modulee, query_statementt, priorityy, subject_type_idd, filee);

        userlist.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                // Toast.makeText(context, response.code() + "", Toast.LENGTH_LONG).show();
                AppTools.hideDialog();

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        Sneaker.with(getActivity())
                                .setTitle("Your Ticket Successfully Submitted.")
                                .setMessage("")
                                .sneakSuccess();

                        //     Toast.makeText(context, response.body().getMessage() + "", Toast.LENGTH_LONG).show();
/*
                        Sneaker.with(getActivity())
                                .setTitle(response.body().string())
                                .setMessage("")
                                .sneakSuccess();*/

                        FragmentManager fragmentManager = getFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                        Fragment fragment = new SupportTicketsFragment();
                        fragmentTransaction.replace(R.id.fragment_Container, fragment);
                        fragmentTransaction.addToBackStack(null);

                        fragmentTransaction.commit();


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
            path = ImagePath.getPath(getContext(), uri);
            System.out.println("urii path " + path);

            imageUri = data.getData();
            //circleImageView.setImageURI(imageUri);
            if (path != null && !path.equals("")) {
                File file = new File(path);
                System.out.println("filefilefile " + file);
                // Toast.makeText(getContext(), "done", Toast.LENGTH_SHORT).show();
                // Tv_UploadImage.setText(path);
                //uploadImage(file);
                Tv_UploadImage.setText(path);
            } else {

                Toast.makeText(getContext(), "not", Toast.LENGTH_SHORT).show();
            }
        }
    }
}