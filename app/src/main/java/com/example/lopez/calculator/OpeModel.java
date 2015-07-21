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

    String num1 , num2 , operand;
    OpePresenter present;

    public OpeModel(String num1, String num2, String operand)
    {
        this.num1=num1;
        this.num2=num2;
        this.operand=operand;
    }

    public boolean checkifValid()
    {
        boolean temp = false;
        if(TextUtils.isEmpty(num1))
        {
            present.frstnumError();
            temp = true;
        }

        if(TextUtils.isEmpty(num2))
        {
            present.secnumError();
            temp = true;
        }

        return temp;
    }

    public double operate()
    {
        double total = 0;

        if(operand.toString().equals("+"))
        {
            try
            {
                NumberFormat format = NumberFormat.getInstance();
                String temp1 = format.format(num1);
                String temp2 = format.format(num2);
                double frstnum = Double.valueOf(temp1);
                double secnum = Double.valueOf(temp2);
                total = frstnum + secnum;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        if(operand.toString().equals("-"))
        {
            try
            {
                NumberFormat format = NumberFormat.getInstance();
                String temp1 = format.format(num1);
                String temp2 = format.format(num2);
                double frstnum = Double.valueOf(temp1);
                double secnum = Double.valueOf(temp2);
                total = frstnum - secnum;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        if(operand.toString().equals("*"))
        {
            try
            {
                NumberFormat format = NumberFormat.getInstance();
                String temp1 = format.format(num1);
                String temp2 = format.format(num2);
                double frstnum = Double.valueOf(temp1);
                double secnum = Double.valueOf(temp2);
                total = frstnum * secnum;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        if(operand.toString().equals("/"))
        {
            try
            {
                NumberFormat format = NumberFormat.getInstance();
                String temp1 = format.format(num1);
                String temp2 = format.format(num2);
                double frstnum = Double.valueOf(temp1);
                double secnum = Double.valueOf(temp2);
                total = frstnum * secnum;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        return  total;
    }
}
