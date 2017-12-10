package com.example.program;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoAcitvity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_acitvity);

        VideoView videoView = (VideoView) findViewById(R.id.videoView);

        videoView.requestFocus();

        String vSource = "android.resource://com.example.program/" + R.raw.mm;

        videoView.setVideoURI(Uri.parse(vSource));

        videoView.setMediaController(new MediaController(this));

        videoView.start();
    }
    public void onClick (View view){
        Intent intent = new Intent(VideoAcitvity.this, MusicActivity.class);
        startActivity(intent);
    }
}
