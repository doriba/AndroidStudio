package com.example.dorian.eggtimer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    SeekBar seekBar;
    CountDownTimer timer;
    int time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        time = 30;

        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
        seekBar = (SeekBar) findViewById(R.id.seekBar);

        seekBar.setMax(599);
        seekBar.setProgress(time);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                time = progress;
                setTimerText();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void setTimerText(){
        int minutes = (time / 60);
        int seconds = (time - minutes * 60);
        String stringTijd = (minutes + ":" + seconds);
        if(seconds < 10){
            stringTijd = (minutes + ":0" + seconds);
        }
        textView.setText(stringTijd);
    }

    public void toggleTimer(View view) {
        if (timer != null) {
            timer.cancel();
            button.setText("Start");
            timer = null;
        }
        else {
            button.setText("Stop");
            timer = new CountDownTimer(time * 1000 + 100, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    time = (int) millisUntilFinished / 1000;
                    setTimerText();
                }

                @Override
                public void onFinish() {
                    MediaPlayer media = MediaPlayer.create(getApplicationContext(), R.raw.airhorn);
                    media.start();
                    textView.setText("0:00");
                }
            };
            timer.start();
        }
    }
}
