package com.serviingo.serviingo.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.irozon.sneaker.Sneaker;
import com.serviingo.serviingo.Activity.Addones;
import com.serviingo.serviingo.Activity.Addtocart;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.utils.CheckInternetConnection;
import com.serviingo.serviingo.utils.util;

public class AddtocartFragment extends Fragment {

    TextView btn,tvPrice;
    ImageView ivNav,ivBack;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_addtocart, container, false);
        findvuewbyid(view);



        // getActivity().getSupportActionBar().setTitle();


   /*  setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" "); */
        return view;
    }

    private void findvuewbyid(View view) {
        btn=view.findViewById(R.id.btn);
        tvPrice=view.findViewById(R.id.tvPrice);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  startActivity(new Intent(Addtocart.this, Addones.class));
            }
        });
        tvPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // startActivity(new Intent(Addtocart.this,Addones.class));
            }
        });

        //ivNav = findViewById(R.id.ivNav);

    }
}