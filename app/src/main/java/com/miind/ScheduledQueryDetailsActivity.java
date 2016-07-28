package com.miind;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ScheduledQueryDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_details);
    }

    public void loadLiveResolution(View v){
        Intent queryDetails = new Intent(ScheduledQueryDetailsActivity.this, LiveResolutionActivity.class);
        startActivity(queryDetails);
    }
}
