package com.miind;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ScheduledQueryIistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_iist);
    }

    public void loadDetails(View v){
        Intent queryDetails = new Intent(ScheduledQueryIistActivity.this, ScheduledQueryDetailsActivity.class);
        startActivity(queryDetails);
    }
}
