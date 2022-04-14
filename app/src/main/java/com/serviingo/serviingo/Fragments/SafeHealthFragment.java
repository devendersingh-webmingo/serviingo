package com.serviingo.serviingo.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.Adapterr.AddonseAdapter;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.ViewPresenter.SafeHealthRepoPresenter;
import com.serviingo.serviingo.modelrepo.Responsee.SafeHealthRepo;
import com.serviingo.serviingo.storage.SharedPrefManager;

import java.util.ArrayList;

import static com.serviingo.serviingo.R.drawable.globalloader;

public class SafeHealthFragment extends Fragment implements SafeHealthRepoPresenter.SafeHealthRepoView {
    TextView tvwallet, text, newid, desc, tvgreen;
    CheckBox rb;


    SafeHealthRepoPresenter safeHealthRepoPresenter;

    Bundle extras;
    String Id,Quentiy;
    ArrayList<String>arrayList=new ArrayList<>();



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_safe_health, container, false);
        setui(view);

        return view;
    }

    private void setui(View view) {
        AppTools.showRequestDialog(getActivity());
        extras = getArguments();
        if (extras != null) {

            Id = getArguments().getString("id");
            arrayList= getArguments().getStringArrayList("arrayList");
            Quentiy= getArguments().getString("Quentiy");
        }
  //  Toast.makeText(getContext(), arrayList.toString()+"", Toast.LENGTH_SHORT).show();
       // Toast.makeText(getContext(), SharedPrefManager.getInstance(getContext()).Addonsegetpackage_id()+"\n"+SharedPrefManager.getInstance(getContext()).GetCityid(), Toast.LENGTH_SHORT).show();

        safeHealthRepoPresenter = new SafeHealthRepoPresenter(this);
        safeHealthRepoPresenter.GetAddonse(getContext(),  SharedPrefManager.getInstance(getContext()).Addonsegetpackage_id(),SharedPrefManager.getInstance(getContext()).GetCityid());


        tvwallet = view.findViewById(R.id.tvwallet);
        text = view.findViewById(R.id.text);
        newid = view.findViewById(R.id.newid);
        desc = view.findViewById(R.id.desc);
        tvgreen = view.findViewById(R.id.tvgreen);
        rb = view.findViewById(R.id.rb);

        rb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked)
                {

                    tvgreen.setVisibility(View.VISIBLE);
                }else {
                    tvgreen.setVisibility(View.GONE);
                }



            }
        });
        tvgreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                SharedPrefManager.getInstans(getContext().getApplicationContext()).MembsershipClear();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment appliencesCareServicesFragment = new AppliencesCareServicesFragment();
                Bundle args = new Bundle();
                args.putString("id",  SharedPrefManager.getInstance(getContext()).Addonsegetpackage_id());
                args.putStringArrayList("arrayList",arrayList);

                args.putString("Quentiy", Quentiy);
                appliencesCareServicesFragment.setArguments(args);
                fragmentTransaction.replace(R.id.fragment_Container, appliencesCareServicesFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });


    }

    @Override
    public void onSafeHealthRepoError(String message) {
        AppTools.hideDialog();

        Sneaker.with(this)
                .setTitle(message)
                .setMessage("")
                .sneakError();
    }

    @Override
    public void onSafeHealthRepoSuccess(SafeHealthRepo response, String message) {
        AppTools.hideDialog();

      //Toast.makeText(getContext(), message + "", Toast.LENGTH_SHORT).show();
       // Log.e("safhealth",response.getData().toString());

        AppTools.hideDialog();

        if (message.equalsIgnoreCase("ok")) {

           // Log.e("safhealth",response.getData().getCovidContent().toString());


            if (response.getData().getCovidContent()==null)
            {


              //  Toast.makeText(getContext(), "yes", Toast.LENGTH_SHORT).show();
                SharedPrefManager.getInstans(getContext().getApplicationContext()).MembsershipClear();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment appliencesCareServicesFragment = new AppliencesCareServicesFragment();
                Bundle args = new Bundle();
                args.putString("id",  SharedPrefManager.getInstance(getContext()).Addonsegetpackage_id());
                args.putStringArrayList("arrayList",arrayList);
                args.putString("Quentiy", Quentiy);
                appliencesCareServicesFragment.setArguments(args);
                fragmentTransaction.replace(R.id.fragment_Container, appliencesCareServicesFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();




            }else {
              //  Toast.makeText(getContext(), "No", Toast.LENGTH_SHORT).show();
                tvwallet.setText(response.getData().getCovidContent().getHeading());
                text.setText(response.getData().getCovidContent().getTitle());
                desc.setText(Html.fromHtml(response.getData().getCovidContent().getDescription()));


            }




        }
    }

    @Override
    public void onSafeHealthRepoFailure(Throwable t) {
        AppTools.hideDialog();

        Sneaker.with(this)
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();

    }
}