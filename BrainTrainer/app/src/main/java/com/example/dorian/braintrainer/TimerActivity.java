package com.example.dorian.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TimerActivity extends AppCompatActivity {

    private TextView timerTextView;
    private TextView scoreTextView;
    private Button[] buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        timerTextView = (TextView) findViewById(R.id.timerTextView);
        scoreTextView = (TextView) findViewById(R.id.scoreTextView);
        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
        buttons = new Button[4];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = (Button) gridLayout.getChildAt(i);
        }
        startTimer();
    }
    private void startTimer() {
        new CountDownTimer(30000 + 100, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                int seconden = (int) millisUntilFinished / 1000;
                timerTextView.setText(String.valueOf(seconden));
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }
}
