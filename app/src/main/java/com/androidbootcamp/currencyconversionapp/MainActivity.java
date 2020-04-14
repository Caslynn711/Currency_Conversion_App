package com.androidbootcamp.currencyconversionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Currency;

public class MainActivity extends AppCompatActivity {
    double dollarAmountEntered;
    double euroConvertRate = 1.092;
    double convertedRate;
    double canadianConvertRate = 0.719574;
    double pesoConvertRate = 0.0422935;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        final EditText dollars = (EditText) findViewById(R.id.txtHint);
        final RadioButton euroRad = (RadioButton) findViewById(R.id.radioButton);
        final RadioButton mexRad = (RadioButton) findViewById(R.id.radioButton2);
        final RadioButton canRad = (RadioButton) findViewById(R.id.radioButton3);
        final TextView result = (TextView) findViewById(R.id.txtResult);
        Button convert = (Button) findViewById(R.id.btnConvert);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dollarAmountEntered = Double.parseDouble(dollars.getText().toString());
                DecimalFormat currency = new DecimalFormat("00.00");
                if(euroRad.isChecked()) {
                    if(dollarAmountEntered <= 100000) {
                        convertedRate = dollarAmountEntered / euroConvertRate;
                        result.setText(currency.format(convertedRate) + " Euros");

                    } else {
                        Toast.makeText(MainActivity.this, "Dollar amount must be $100,000.00 or less.", Toast.LENGTH_SHORT).show();
                    }
                }

                if(mexRad.isChecked()){
                    if(dollarAmountEntered <= 100000) {
                        convertedRate = dollarAmountEntered / pesoConvertRate;
                        result.setText(currency.format(convertedRate) + " Pesos");

                    } else {
                        Toast.makeText(MainActivity.this, "Dollar amount must be $100,000.00 or less.", Toast.LENGTH_SHORT).show();
                    }

                }

                if(canRad.isChecked()) {
                    if(dollarAmountEntered <= 100000) {
                        convertedRate = dollarAmountEntered / canadianConvertRate;
                        result.setText(currency.format(convertedRate) + " Canadian Dollars");

                    } else {
                        Toast.makeText(MainActivity.this, "Dollar amount must be $100,000.00 or less.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}
