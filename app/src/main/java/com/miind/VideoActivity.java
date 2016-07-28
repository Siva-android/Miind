package com.miind;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    MediaController mc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        VideoView vd = (VideoView) findViewById(R.id.videoView);

        // Load and start the movie
        Uri video1 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.lathe);
        mc = new MediaController(this);
        vd.setMediaController(mc);
        vd.setVideoURI(video1);
        vd.start();
    }
}
