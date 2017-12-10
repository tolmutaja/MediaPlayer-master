package com.example.program;

import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.Button;
import android.media.MediaPlayer;
import android.content.Intent;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {

    TextView txt1, txt2;
    ToggleButton toggleButton;
    Button button;
    CheckBox checkBox;
    RadioButton radioButton;
    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1 = (TextView) findViewById(R.id.txt1);
        txt2 = (TextView) findViewById(R.id.txt2);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        button = (Button) findViewById(R.id.button);
        checkBox =(CheckBox) findViewById(R.id.checkBox);
        radioButton = (RadioButton) findViewById(R.id.radioButton);

        button.setEnabled(false);

        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(this, R.raw.sugarplumfairydance);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        CompoundButton.OnCheckedChangeListener checker = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton checkBox, boolean isChecked){
                if (checkBox.isChecked()){
                    button.setEnabled(true);
                }
                else if (button.isEnabled()){
                    button.setEnabled(false);
                }
            }
        };
        checkBox.setOnCheckedChangeListener(checker);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, VideoAcitvity.class);
                startActivity(intent);
                mediaPlayer.stop();
            }
        });

    }
    public void onToggle(View view){
        if (toggleButton.isChecked()){
            mediaPlayer.stop();
            txt1.setText("Music is off");
        } else{
            txt1.setText("Music is gone");
        }
    }
    public void onRadioButton(View view){
        if (radioButton.isChecked()){
            txt2.setText("You pushed button");
        } else;
    }
}
