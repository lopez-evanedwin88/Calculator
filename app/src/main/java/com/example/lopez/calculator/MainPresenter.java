package com.example.lopez.calculator;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import java.text.ParseException;

/**
 * Created by cl5admin on 7/18/2015.
 */
public class MainPresenter {

    Context context;
    ImainView view;
    Model model;

    double num1,num2;
    String opr;


    public MainPresenter(ImainView num, Context context)
    {
        this.view=num;
        this.context=context;
    }

    public void validateNumber(String num1, String num2, String opr) throws ParseException {
        this.model = new Model(num1,num2,opr);

        if (model.validatefirst())
        {
            frstnumError();
        }

        if (model.validatesecond())
        {
            secnumError();
        }

        if (model.validatefirst()||model.validatesecond())
        {
            return;
        }

        view.nextActivity(model.num1,model.num2,model.operator,Double.toString(model.operate()));


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
