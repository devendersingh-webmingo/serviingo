package com.serviingo.serviingo.dialogue;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.irozon.sneaker.Sneaker;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.Adapterr.Homepage.PackageDetailsGalleryAdapterr;
import com.serviingo.serviingo.Adapterr.PackageReviwAdapter;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.ViewPresenter.PackageviewDetailsPresenter;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.PackageviewDetailsRepo;
import com.serviingo.serviingo.modelrepo.Responsee.PackageReviews;
import com.squareup.picasso.Picasso;

import static com.serviingo.serviingo.R.drawable.globalloader;

public class PackageReviewDetailsDialogue{

    TextView exit;
    RecyclerView galleryRV;
    Context context;
    PackageReviews packageReviews;


    public PackageReviewDetailsDialogue(Context context, PackageReviews packageReviews) {

        this.context = context;
        this.packageReviews=packageReviews;


    }

    public void Sucess() {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.packagereviewdetailsdialogue, null);
        AlertDialog alertDialog = new AlertDialog.Builder(context)
                .setView(view)
                .setCancelable(false)
                .create();
        // alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        exit = view.findViewById(R.id.exit);
        galleryRV = view.findViewById(R.id.galleryRV);
        LinearLayoutManager linearLayoutManager = (new LinearLayoutManager(context.getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        galleryRV.setLayoutManager(linearLayoutManager);

        galleryRV.setHasFixedSize(true);
        PackageReviwAdapter packageReviwAdapter=new PackageReviwAdapter(packageReviews,context);
        galleryRV.setAdapter(packageReviwAdapter);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();;
            }
        });


        alertDialog.show();
    }

}