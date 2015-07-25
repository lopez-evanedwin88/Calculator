package com.example.lopez.calculator;

import android.content.Context;

/**
 * Created by cl5admin on 7/25/2015.
 */
public class SecondPresenter {

    Model model;
    IsecondView view;
    Context context;
    public SecondPresenter(IsecondView View, Context context)
    {
        this.view=View;
        this.context=context;
    }

    public void validateNumber(String num1, String num2, String operator, String result)
    {
        model = new Model(num1,num2,operator);

        Double temp;
        String Ftemp;

        temp = model.converttodouble(result);

        Ftemp = model.roundof(temp);

        if (temp==-1D)
        {
            view.setErrorColor();
            view.error();
        }
        else
        {
            view.setSuccessColor();
            view.display(Ftemp);
        }
    }

}
