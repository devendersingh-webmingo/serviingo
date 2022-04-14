package com.serviingo.serviingo.Activity.Rating;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.iarcuschin.simpleratingbar.SimpleRatingBar;
import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.Activity.HomeActivity;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.ViewPresenter.AddReviewPresenter;
import com.serviingo.serviingo.modelrepo.request.ReviewRequest;

import okhttp3.ResponseBody;

public class RatingActivity extends AppCompatActivity implements AddReviewPresenter.AddReviewView {
    Intent intent;
    String id;
    SimpleRatingBar text_rating;
    EditText descTv;
    TextView loginwithemailtv;
    String comment, ratingg;

    AddReviewPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        intent = getIntent();
        if (intent != null) {
            id = intent.getStringExtra("id");

        }

        presenter = new AddReviewPresenter(this);

        text_rating = findViewById(R.id.text_rating);
        descTv = findViewById(R.id.descTv);
        loginwithemailtv = findViewById(R.id.loginwithemailtv);

        loginwithemailtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RatingData();
            }
        });

        text_rating.setOnRatingBarChangeListener(new SimpleRatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(SimpleRatingBar simpleRatingBar, float rating, boolean fromUser) {

                char first = String.valueOf(rating).charAt(0);
                ratingg = String.valueOf(first);
            }
        });
    }


    public void RatingData() {
        comment = descTv.getText().toString().trim();
        if (comment.isEmpty()) {
            Sneaker.with(this)
                    .setTitle(" Type Feedback Comment")
                    .setMessage("")
                    .sneakError();
        } else if (ratingg == null) {
            Sneaker.with(this)
                    .setTitle("Please Give stars")
                    .setMessage("")
                    .sneakError();
        } else {
            AppTools.showRequestDialog(this);

            ReviewRequest reviewRequest = new ReviewRequest(id, comment, ratingg);
            presenter.AddReview(this, reviewRequest);

        }

    }

    @Override
    public void onAddReviewError(String message) {
        AppTools.hideDialog();

        Sneaker.with(this)
                .setTitle(message)
                .setMessage("")
                .sneakError();

    }

    @Override
    public void onAddReviewSuccess(ResponseBody response, String message) {
        AppTools.hideDialog();

        Sneaker.with(this)
                .setTitle("Your Rating & Reviews Submitted successfully.")
                .setMessage("")
                .sneakSuccess();

        if (message.equalsIgnoreCase("ok")) {

            Intent in = new Intent(RatingActivity.this, HomeActivity.class);
            startActivity(in);
            finish();


        }
    }

    @Override
    public void onAddReviewFailure(Throwable t) {

        AppTools.hideDialog();

        Sneaker.with(this)
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();

    }
}