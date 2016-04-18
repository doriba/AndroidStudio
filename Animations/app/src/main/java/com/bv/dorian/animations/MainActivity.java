package com.bv.dorian.animations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.SeekBar;

public class MainActivity   extends AppCompatActivity {

    ImageView cow, dog;
    boolean isCow, isFade, isTranslate, isRotate;
    long animatieDuur;
    SeekBar seekBar;
    RadioButton fadeButton, translateButton, rotateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cow = (ImageView) findViewById(R.id.cow);
        dog = (ImageView) findViewById(R.id.dog);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                animatieDuur = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        fadeButton = (RadioButton) findViewById(R.id.fadeRadioButton);
        fadeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                isFade = true;
                isTranslate = false;
                isRotate = false;

                if(isCow){
                    dog.setAlpha(0f);
                    dog.setTranslationX(0f);
                    dog.setScaleX(1f);
                    dog.setScaleY(1f);
                }
                else{
                    cow.setAlpha(0f);
                    cow.setTranslationX(0f);
                    cow.setScaleX(1f);
                    cow.setScaleY(1f);

                }
            }
        });
        translateButton = (RadioButton) findViewById(R.id.translateRadioButton);
        translateButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                isFade = false;
                isTranslate = true;
                isRotate = false;

                if(isCow){
                    dog.setAlpha(1f);
                    dog.setTranslationX(-1000f);
                    dog.setScaleX(1f);
                    dog.setScaleY(1f);
                }
                else{
                    cow.setAlpha(1f);
                    cow.setTranslationX(1000f);
                    cow.setScaleX(1f);
                    cow.setScaleY(1f);
                }
            }
        });
        rotateButton = (RadioButton) findViewById(R.id.rotateRadioButton);
        rotateButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                isFade = false;
                isTranslate = false;
                isRotate = true;

                if(isCow){
                    dog.setAlpha(1f);
                    dog.setTranslationX(0f);
                    dog.setScaleX(0f);
                    dog.setScaleY(0f);
                }
                else{
                    cow.setAlpha(1f);
                    cow.setTranslationX(0f);
                    cow.setScaleX(0f);
                    cow.setScaleY(0f);
                }
            }
        });

        isFade = true;
        fadeButton.setChecked(true);
        isCow = true;
        animatieDuur = 2000l;
        seekBar.setProgress((int) animatieDuur);
        dog.setAlpha(0f);
    }

    public void animate(View view) {
        if(isFade){
            fade();
        }
        else if(isTranslate){
            translate();
        }
        else{
            rotate();
        }
        isCow = !isCow;
    }

    private void fade() {
        if (isCow) {
            cow.animate().alpha(0f).setDuration(2000l);
            dog.animate().alpha(1f).setDuration(2000l);
        } else {
            cow.animate().alpha(1f).setDuration(2000l);
            dog.animate().alpha(0f).setDuration(2000l);
        }
    }

    private void translate() {
        if (isCow) {
            cow.animate()
                    .translationX(1000l)
                    .setDuration(animatieDuur);
            dog.animate()
                    .translationX(0f)
                    .setDuration(animatieDuur);
        } else {
            cow.animate()
                    .translationX(0l)
                    .setDuration(animatieDuur);
            dog.animate()
                    .translationX(-1000f)
                    .setDuration(animatieDuur);
        }
    }

    private void rotate() {
        if (isCow) {
            cow.animate()
                    .rotation(720f)
                    .scaleX(0f)
                    .scaleY(0f)
                    .setDuration(animatieDuur);
            dog.animate()
                    .rotation(-720f)
                    .scaleX(1f)
                    .scaleY(1f)
                    .setDuration(animatieDuur);
        }
        else{
            cow.animate()
                    .rotation(-720f)
                    .scaleX(1f)
                    .scaleY(1f)
                    .setDuration(animatieDuur);
            dog.animate()
                    .rotation(720f)
                    .scaleX(0f)
                    .scaleY(0f)
                    .setDuration(animatieDuur);
        }
    }
}
