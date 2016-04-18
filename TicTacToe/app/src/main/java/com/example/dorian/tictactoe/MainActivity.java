package com.example.dorian.tictactoe;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int actieveSpeler;
    int[] spelVerloop = {0,0,0,0,0,0,0,0,0};
    int [][] win = {
        {0,1,2},
        {3,4,5},
        {6,7,8},
        {0,3,6},
        {1,4,7},
        {2,5,8},
        {0,4,8},
        {2,4,6}
    };
    int spelerWin;
    boolean spelKlaar;
    TextView endText;
    Button restartButton;
    LinearLayout endGameScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actieveSpeler =  1;
        spelerWin = 0;
        endText = (TextView) findViewById(R.id.endText);
        restartButton = (Button) findViewById(R.id.restartButton);
        endGameScreen = (LinearLayout) findViewById(R.id.endGameScreen);
    }

    public void setImg(View view){
        ImageView imageView = (ImageView) view;
        int i = Integer.parseInt(imageView.getTag().toString());

        if(spelVerloop[i] == 0) {
            spelVerloop[i] = actieveSpeler;
            if (actieveSpeler == 1) {
                imageView.setTranslationY(-1000f);
                imageView.setImageResource(R.drawable.iks);
                imageView.animate().translationY(0f).setDuration(300);
                checkEindeSpel();
                actieveSpeler = 2;
            } else {
                imageView.setTranslationY(-1000f);
                imageView.setImageResource(R.drawable.ooo);
                imageView.animate().translationY(0f).setDuration(300);
                checkEindeSpel();
                actieveSpeler = 1;
            }
            if(spelKlaar){
                endGame();
            }
        }
    }

    private void checkEindeSpel(){
        for(int[] winner: win){
            boolean isWinner = true;
            for(int i: winner){
                if(spelVerloop[i] != actieveSpeler){
                    isWinner = false;
                    break;
                }
            }
            if(isWinner){
                spelerWin = actieveSpeler;
                spelKlaar = true;
            }
        }
        if(spelerWin == 0){
            spelKlaar = true;
            for(int i: spelVerloop){
                if(i == 0){
                    spelKlaar = false;
                    break;
                }
            }
        }
    }

    private void endGame(){
        switch(spelerWin){
            case 0:
                endText.setText("Gefeliciteerd niemand!");
                break;
            case 1:
                endText.setText("Kruisjes winnen!");
                break;
            case 2:
                endText.setText("Rondjes winnen!");
                break;
        }
        endGameScreen.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void nieuwSpel(View view){
        GridLayout grid = (GridLayout) findViewById(R.id.grid);
        for(int i = 0; i < spelVerloop.length; i++){
            spelVerloop[i] = 0;
            ImageView imageView = (ImageView) grid.getChildAt(i);
            imageView.setImageResource(0);
        }
        actieveSpeler = 1;
        spelKlaar = false;
        spelerWin = 0;
        endGameScreen.setVisibility(View.GONE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
