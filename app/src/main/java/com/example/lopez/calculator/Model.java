package com.example.lopez.calculator;

import android.os.Bundle;
import android.text.TextUtils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * Created by cl5admin on 7/18/2015.
 */
public class Model {

    String num1 , num2 , operator;

    public Model(String num1, String num2, String operator){

            this.num1 = num1.trim();
            this.num2 = num2.trim();
            this.operator = operator.trim();

    }


    public boolean validatefirst()
    {
        if (TextUtils.isEmpty(num1))
        {
            return true;
        }
        return false;
    }

    public boolean validatesecond()
    {

        if (TextUtils.isEmpty(num2))
        {
            return true;
        }

        return false;
    }

    public Number getFormat(String operand) throws ParseException {
        NumberFormat number = NumberFormat.getInstance(Locale.US);
        number.setGroupingUsed(true);
        return number.parse(operand);
    }



    public double operate() {
        double first = 0;
        double second = 0;
        double total = 0;

        try
        {   first = getFormat(num1).doubleValue();
            second = getFormat(num2).doubleValue();
        } catch (ParseException e)
        {
            e.printStackTrace();
        }

        if(!isComputable())
        {
            return -1D;
        }
        else
        {
            switch (operator)
            {
                case "+":
                    total = first+second;
                    break;
                case "-":
                    total = first-second;
                    break;
                case "*":
                    total = first*second;
                    break;
                case "/":
                    total = first/second;
                    break;
            }
            return total;
        }

    }

    public boolean isComputable() {
        if (!TextUtils.isEmpty(num1) && !TextUtils.isEmpty(num2)) {
            try {
                getFormat(num1).toString();
                getFormat(num2).toString();
            } catch (ParseException parseexception) {
                return false;
            }
            if (operator.length() == 1) {
                char c1 = operator.charAt(0);
                if (c1 == '+' || c1 == '-' || c1 == 'x' || c1 == '/') {
                    return true;
                }
            }
        }
        return false;
    }

    public Double converttodouble(String res)
    {
        return Double.parseDouble(res);
    }
    public String roundof(double res)
    {
        DecimalFormat format = new DecimalFormat("#,###.00");
        return format.format(res);
    }


}
