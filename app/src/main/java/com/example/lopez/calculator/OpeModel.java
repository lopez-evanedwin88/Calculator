package com.example.lopez.calculator;

import android.content.Context;
import android.text.TextUtils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * Created by cl5admin on 7/18/2015.
 */
public class OpeModel {


    public void operate(String num1, String num2, String opr, Context context, OpePresenter present)
    {

        if(TextUtils.isEmpty(num1))
        {
            present.frstnumError();
        }

        if(TextUtils.isEmpty(num2))
        {
            present.secnumError();
        }

        if(opr.toString().equals("+"))
        {
            NumberFormat format = NumberFormat.getInstance(Locale.US);
            Number number = null;
            Number number2 = null;

            try
            {
                    number = format.parse(num1.replaceAll("[^0-9.]",""));
                    number2 = format.parse(num2.replaceAll("[^0-9.]", ""));
                    double frstnum = number.doubleValue();
                    double secnum = number2.doubleValue();
                    double sum = frstnum + secnum;
                    present.secondActivity(frstnum, secnum, sum, opr);

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }


        }

        if(opr.toString().equals("-"))
        {
            NumberFormat format = NumberFormat.getInstance(Locale.US);
            Number number = null;
            Number number2 = null;

            try {

                number = format.parse(num1.replaceAll("[^0-9.]", ""));
                number2 = format.parse(num2.replaceAll("[^0-9.]", ""));
                double frstnum = number.doubleValue();
                double secnum = number2.doubleValue();
                double diff = frstnum - secnum;
                present.secondActivity(frstnum, secnum, diff, opr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if(opr.toString().equals("*"))
        {
            NumberFormat format = NumberFormat.getInstance(Locale.US);
            Number number = null;
            Number number2 = null;

            try
            {
                number = format.parse(num1.replaceAll("[^0-9.]", ""));
                number2 = format.parse(num2.replaceAll("[^0-9.]", ""));
                double frstnum = number.doubleValue();
                double secnum = number2.doubleValue();
                double prod = frstnum * secnum;
                present.secondActivity(frstnum, secnum, prod, opr);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        if(opr.toString().equals("/"))
        {
            NumberFormat format = NumberFormat.getInstance(Locale.US);
            Number number = null;
            Number number2 = null;

            try {
                number = format.parse(num1.replaceAll("[^0-9.]",""));
                number2 = format.parse(num2.replaceAll("[^0-9.]",""));
                double frstnum = number.doubleValue();
                double secnum = number2.doubleValue();
                double div = frstnum / secnum;
                present.secondActivity(frstnum,secnum,div,opr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}
