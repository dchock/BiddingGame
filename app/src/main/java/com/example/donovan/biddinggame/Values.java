package com.example.donovan.biddinggame;

import java.util.Random;

import static com.example.donovan.biddinggame.MainActivity.rangeMax;
import static com.example.donovan.biddinggame.MainActivity.rangeMin;

/**
 * Created by Donovan on 28/04/17.
 */

public class Values implements CalculateInterface {

    private updateViewInterface mainView;


    Double yourPayoff, theirPayoff;
    Double theirTotal = 0.0;
    Double yourTotal = 0.0;

    Values(updateViewInterface mainView) {
        this.mainView = mainView;
    }


    public void calculate(Double randomValue, Double theirValue,  Double yourBid, Double theirBid) {

        this.yourPayoff = 0.0;
        this.theirPayoff = 0.0;


        if (yourBid > theirBid) {

            yourPayoff =  randomValue - yourBid;
            yourTotal = yourTotal + yourPayoff;

        } else if (yourBid < theirBid) {

            theirPayoff = theirValue - theirBid;
            theirTotal = theirTotal + theirPayoff;

        }

        /* yourTotal = yourTotal + yourPayoff;
        theirTotal = theirTotal + theirPayoff; */


        mainView.upDateView(yourTotal, theirTotal, yourPayoff, theirPayoff);

    }
}
