package com.miind;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class QueryHistoryDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_history_details);
    }

    public void loadVideo(View v) {
        Intent queryDetails = new Intent(QueryHistoryDetailsActivity.this, VideoActivity.class);
        startActivity(queryDetails);
    }

    public void loadChat(View v) {
        Intent queryDetails = new Intent(QueryHistoryDetailsActivity.this, ChatActivity.class);
        startActivity(queryDetails);
    }
}
