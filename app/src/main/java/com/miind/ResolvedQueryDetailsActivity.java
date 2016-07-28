package com.miind;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class ResolvedQueryDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resolved_query_details);
    }

    public void loadVideo(View v) {
        Intent queryDetails = new Intent(ResolvedQueryDetailsActivity.this, VideoActivity.class);
        startActivity(queryDetails);
    }

    public void loadRating(View v) {
        Intent queryDetails = new Intent(ResolvedQueryDetailsActivity.this, RatingActivity.class);
        startActivity(queryDetails);
    }
}
