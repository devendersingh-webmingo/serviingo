package com.serviingo.serviingo.dialogue;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.irozon.sneaker.Sneaker;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.Activity.HomeActivity;
import com.serviingo.serviingo.Adapterr.Homepage.CustomizedGalleryAdapterr;
import com.serviingo.serviingo.Adapterr.Homepage.PackageDetailsGalleryAdapterr;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.ViewPresenter.PackageviewDetailsPresenter;
import com.serviingo.serviingo.ViewPresenter.UserLoginPresenter;
import com.serviingo.serviingo.modelrepo.Responsee.LoginRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.PackageviewDetailsRepo;
import com.serviingo.serviingo.modelrepo.Responsee.PackagesRepo;
import com.serviingo.serviingo.storage.SharedPrefManager;
import com.serviingo.serviingo.storage.User_login;
import com.squareup.picasso.Picasso;

import static com.serviingo.serviingo.R.drawable.globalloader;

public class PackageViewDetailsDialogue implements PackageviewDetailsPresenter.PackageviewDetailsView {
    TextView tvwallet, text,exit,tvwallett;
    ImageView imageView;
    YouTubePlayerView youTubePlayerView;
    Context context;
    String  id;
    RecyclerView galleryRV;


    PackageviewDetailsPresenter presenter;


    public PackageViewDetailsDialogue(Context context, String  id) {

        this.context = context;
        this.id = id;

    }

    public void Sucess() {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.packageviewdetailsdialogue, null);
        AlertDialog alertDialog = new AlertDialog.Builder(context)
                .setView(view)
                .setCancelable(false)
                .create();

        // alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        tvwallet = view.findViewById(R.id.tvwallet);
        tvwallett= view.findViewById(R.id.tvwallett);
        imageView = view.findViewById(R.id.imageView);
        exit = view.findViewById(R.id.exit);
        text = view.findViewById(R.id.text);
        youTubePlayerView = view.findViewById(R.id.youtube_player_view);
        presenter=new PackageviewDetailsPresenter(this);

        galleryRV = view.findViewById(R.id.galleryRV);
        presenter.GetHomePageContent(context,id);



        LinearLayoutManager linearLayoutManager = (new LinearLayoutManager(context.getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        galleryRV.setLayoutManager(linearLayoutManager);
        galleryRV.setHasFixedSize(true);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();;

            }
        });


        alertDialog.show();
    }

    @Override
    public void onPacakgeDetailsError(String message) {

        Sneaker.with((Activity) context)
                .setTitle(message)
                .setMessage("")
                .sneakError();
        }

    @Override
    public void onPackageDeatilsSuccess(PackageviewDetailsRepo response, String message) {

       if (message.equalsIgnoreCase("ok"))
       {

           tvwallett.setText("Know more about "+response.getData().getPackage().getName());
           if (response.getData().getServices().size()>0)
           {

               tvwallet.setText(response.getData().getServices().get(0).getName());
               text.setText(Html.fromHtml(response.getData().getServices().get(0).getDescription()));
               if (response.getData().getServices().get(0).getDetailVideo()==null)
               {
                   youTubePlayerView.setVisibility(View.GONE);

                   imageView.setVisibility(View.VISIBLE);
                   Picasso.get().load(response.getData().getServiceImagePath()+response.getData().getServices().get(0).getDetailImage()).into(imageView);

               }else {
                  imageView.setVisibility(View.GONE);
                   youTubePlayerView.setVisibility(View.VISIBLE);
                   youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                       @Override
                       public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                           String videoId = (String) response.getData().getServices().get(0).getDetailVideo();
                          youTubePlayer.loadVideo(videoId, 0);

                       }
                   });

               }


           }
           if (response.getData().getGalleries().size()>0){

               PackageDetailsGalleryAdapterr customGalleryAdapter = new PackageDetailsGalleryAdapterr(response, context);

               // set the adapter for gallery
               galleryRV.setAdapter(customGalleryAdapter);
           }

       }
    }

    @Override
    public void onPackageDetailsFailure(Throwable t) {


        Sneaker.with((Activity) context)
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();
    }

    @Override
    public void showHideProgress(boolean isShow) {
        if (isShow) {
            AppTools.showGifDialog((Activity) context, globalloader);

        } else {
            AppTools.hideGifDialog();

        }
    }
}