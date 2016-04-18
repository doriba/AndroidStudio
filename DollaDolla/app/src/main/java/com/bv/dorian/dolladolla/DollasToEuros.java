package com.bv.dorian.dolladolla;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class DollasToEuros extends AppCompatActivity {

    EditText TextField;
    TextView stringEndValue;
    double endValue;
    Button euroDollar, dollarEuro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dollas_to_euros);
        TextField = (EditText) findViewById(R.id.TextField);
        stringEndValue = (TextView) findViewById(R.id.stringEndValue);
        dollarEuro = (Button) findViewById(R.id.dollarEuro);
        euroDollar = (Button) findViewById(R.id.euroDollar);
    }

    public void dollarToEuro (View view){
        String input = TextField.getText().toString();
        double parseValue = Double.parseDouble(input);
        endValue = (parseValue * 1.13);
        DecimalFormat money = new DecimalFormat("€ ###,###.00");
        stringEndValue.setText(money.format(endValue));
    }

    public void euroToDollar (View view){
        String input = TextField.getText().toString();
        double parseValue = Double.parseDouble(input);
        endValue = ((parseValue / 113) * 100);
        DecimalFormat money = new DecimalFormat("$ ###,###.00");
        stringEndValue.setText(money.format(endValue));
    }
}
