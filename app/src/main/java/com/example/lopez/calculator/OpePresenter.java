package com.example.lopez.calculator;

import android.content.Context;
import android.content.Intent;

/**
 * Created by cl5admin on 7/18/2015.
 */
public class OpePresenter {

    Context context;
    IOpeView view;
    OpeModel model;

    double num1,num2;
    String opr;


    public OpePresenter(IOpeView num, Context context)
    {
        this.view=num;
        this.context=context;
    }

    public void validateNumber(String num1, String num2, String opr)
    {
        this.model = new OpeModel(num1,num2,opr);

        double sum = model.operate();

        if (model.checkifValid())
        {
            view.nextActivity(num1,num2,opr,sum);
        }
        else
        {
            view.errorInput(num1,num2,opr);
        }
    }

    public void frstnumError()
    {
        view.frstNumberError();
    }

    public void secnumError()
    {
        view.secNumberError();
    }






}
