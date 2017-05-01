package com.example.donovan.biddinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

import java.text.DecimalFormat;
import java.util.Random;

//import java.util.Random;


public class MainActivity extends AppCompatActivity implements updateViewInterface {

    TextView tvyourValue, tvyourTotal, tvyourPayoff, tvtheirTotal, tvtheirPayoff, tvTheirValue;
    EditText etyourBid, ettheirBid;
    CalculateInterface calculator;

    public static Double rangeMin = 1.0;
    public static Double rangeMax = 100.0;
    public static Double randomValue;
    public static Double theirValue;

    DecimalFormat VALUE_FORMAT = new DecimalFormat("0.##");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etyourBid = (EditText)findViewById(R.id.editTextYourBid);
        ettheirBid = (EditText)findViewById(R.id.editTextTheirBid);
        tvyourValue = (TextView)findViewById(R.id.textViewValue);
        tvyourTotal = (TextView)findViewById(R.id.textViewYourTotal);
        tvtheirTotal = (TextView)findViewById(R.id.textViewTheirTotal);
        tvyourPayoff = (TextView)findViewById(R.id.textViewYourPayoff);
        tvtheirPayoff = (TextView)findViewById(R.id.textViewTheirPayoff);
        tvTheirValue = (TextView)findViewById(R.id.textViewTheirValue);

        calculator = new Values(this); //instantiate the values interface

        Random r = new Random();
        randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
        theirValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();

        tvyourValue.setText("Your Random Value is: " + VALUE_FORMAT.format(randomValue));
        tvTheirValue.setText("Their Random Value is: " + VALUE_FORMAT.format(theirValue));

    }

    public void onClickCalculate(View v) {

        Double yourBid = Double.parseDouble(etyourBid.getText().toString());
        Double theirBid = Double.parseDouble(ettheirBid.getText().toString());

        calculator.calculate(randomValue, theirValue, yourBid, theirBid);

    }

    public void upDateView(Double yourTotal, Double theirTotal, Double yourPayoff,
                           Double theirPayoff) {

        Random r = new Random();
        randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
        theirValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();

        tvyourPayoff.setText("Your Payoff is: " + VALUE_FORMAT.format(yourPayoff));
        tvyourTotal.setText("Your Total is: " + VALUE_FORMAT.format(yourTotal));
        tvtheirPayoff.setText("Their Payoff is: " + VALUE_FORMAT.format(theirPayoff));
        tvtheirTotal.setText("Their Total is: " + VALUE_FORMAT.format(theirTotal));
        tvyourValue.setText("Your new value is: " + VALUE_FORMAT.format(randomValue));
        tvTheirValue.setText("Their new value is: " + VALUE_FORMAT.format(theirValue));

    }
}


