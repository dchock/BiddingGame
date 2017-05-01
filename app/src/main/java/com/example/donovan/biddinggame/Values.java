package com.example.donovan.biddinggame;

import java.util.Random;

/**
 * Created by Donovan on 28/04/17.
 */

public class Values implements CalculateInterface {

    private updateViewInterface mainView;
    public static final Double rangeMin = 1.0;
    public static final Double rangMax = 100.0;

    private Double yourPayoff, yourTotal, theirTotal, theirPayoff;//, theirValue;
    //private Double randomValue;

    Values(updateViewInterface mainView) {
        this.mainView = mainView;
    }

    public void calculate(Double randomValue, Double yourBid, Double theirBid, Double theirValue) {

        //Random r = new Random();
        //this.randomValue = rangeMin + (rangMax - rangeMin) + r.nextDouble();
        this.yourTotal = 0.0;
        this.yourPayoff = 0.0;
        this.theirPayoff = 0.0;
        this.theirTotal = 0.0;

        if (yourBid > theirBid) {
            yourPayoff =  randomValue - yourBid;
            //mainView.upDateView(yourTotal, theirTotal, yourPayoff, theirPayoff);

        } else if (yourBid < theirBid) {
            theirPayoff = theirBid - theirValue;

        }


       /* yourTotal = yourTotal + yourPayoff;
        theirTotal = theirTotal + theirPayoff; */
        mainView.upDateView(yourTotal, theirTotal, yourPayoff, theirPayoff);

    }
}
