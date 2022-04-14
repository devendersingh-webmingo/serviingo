package com.serviingo.serviingo.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.ViewPresenter.AboutUSPresenter;
import com.serviingo.serviingo.modelrepo.Responsee.AboutRepo;
import com.squareup.picasso.Picasso;

public class AboutUsFragment extends Fragment implements View.OnClickListener, AboutUSPresenter.AboutUSView {


    ImageView imageViews, imagesection3;

    TextView short_descriptionTV, description, sectionheading1, sectiondescription1, sectionheading2, sectiondescription2, sectionheading3, sectiondescription3,
            sectionheading4, sectiontitle4, count1, title1, count2, title2, count3, title3, heading;
    AboutUSPresenter presenter;


    public AboutUsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_about_us, container, false);
        findViewById(view);


        // getActivity().getSupportActionBar().setTitle();


   /*  setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" "); */
        return view;


    }

    private void findViewById(View view) {
        presenter = new AboutUSPresenter(this);


        imageViews = view.findViewById(R.id.imageViews);
        imagesection3 = view.findViewById(R.id.imagesection3);
        short_descriptionTV = view.findViewById(R.id.short_descriptionTV);
        description = view.findViewById(R.id.description);
        sectionheading1 = view.findViewById(R.id.sectionheading1);
        sectiondescription1 = view.findViewById(R.id.sectiondescription1);
        sectionheading2 = view.findViewById(R.id.sectionheading2);
        sectiondescription2 = view.findViewById(R.id.sectiondescription2);
        sectionheading3 = view.findViewById(R.id.sectionheading3);
        sectiondescription3 = view.findViewById(R.id.sectiondescription3);
        sectionheading4 = view.findViewById(R.id.sectionheading4);
        sectiontitle4 = view.findViewById(R.id.sectiontitle4);
        count1 = view.findViewById(R.id.count1);
        title1 = view.findViewById(R.id.title1);
        count2 = view.findViewById(R.id.count2);
        title2 = view.findViewById(R.id.title2);
        count3 = view.findViewById(R.id.count3);
        title3 = view.findViewById(R.id.title3);
        heading = view.findViewById(R.id.heading);
        presenter.GetHomePageContent(getContext());
        ;


        setOnclickistener();


    }

    private void setOnclickistener() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {


            case R.id.tv_home:
                Toast.makeText(getContext(), "HomeFragment", Toast.LENGTH_SHORT).show();

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


                Fragment homeFragment = new HomeFragment();
                fragmentTransaction.replace(R.id.fragment_Container, homeFragment);
                fragmentTransaction.commit();
/*

                Fragment homeFragment = new HomeFragment();
                replaceFragment(homeFragment,"myWalletFragment");

*/

                break;
        }
    }


    @Override
    public void onaboutPageeError(String message) {
        Sneaker.with(getActivity())
                .setTitle(message)
                .setMessage("")
                .sneakError();
    }

    @Override
    public void AboutPageeSuccess(AboutRepo response, String message) {
        if (message.equalsIgnoreCase("ok")) {


            short_descriptionTV.setText(response.getData().getAboutContent().getShortDescription());
            description.setText(Html.fromHtml(response.getData().getAboutContent().getDescription()));
            heading.setText(response.getData().getAboutContent().getHeading());
            sectionheading1.setText(response.getData().getAboutContent().getSection1Heading());
            sectiondescription1.setText(response.getData().getAboutContent().getSection1Description());

            sectionheading2.setText(response.getData().getAboutContent().getSection2Heading());


            sectiondescription2.setText(response.getData().getAboutContent().getSection2Description());

            sectionheading3.setText(response.getData().getAboutContent().getSection3Heading());
            sectiondescription3.setText(response.getData().getAboutContent().getSection3Description());

            sectionheading4.setText(response.getData().getAboutContent().getSectionFourHeading());

            sectiontitle4.setText(response.getData().getAboutContent().getSectionFourTitle());




            count1.setText(response.getData().getAboutContent().getTabOneCount());
            title1.setText(response.getData().getAboutContent().getTabOneTitle());

            count2.setText(response.getData().getAboutContent().getTabTwoCount());

            title2.setText(response.getData().getAboutContent().getTabTwoTitle());

            count3.setText(response.getData().getAboutContent().getTabThreeCount());

            title3.setText(response.getData().getAboutContent().getTabThreeTitle());
            Picasso.get().load(response.getData().getImagePath() + response.getData().getAboutContent().getImage()).into(imageViews);

            Picasso.get().load(response.getData().getImagePath() + response.getData().getAboutContent().getSection3Image()).into(imagesection3);


        }

    }

    @Override
    public void onaboutPageFailure(Throwable t) {
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
}