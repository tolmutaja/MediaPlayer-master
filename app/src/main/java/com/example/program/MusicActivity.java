package com.example.program;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.media.MediaPlayer;

public class MusicActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
    }
    public void onPlay(View view){
        if (mediaPlayer == null){
            mediaPlayer = MediaPlayer.create(this, R.raw.tsirkus);
            mediaPlayer.start();
        }
    }
    public void onPause(View view){
        mediaPlayer.pause();
    }
    public void onStop (View view){
        mediaPlayer.stop();
        mediaPlayer = null;
    }
}
