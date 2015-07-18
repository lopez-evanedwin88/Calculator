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
        this.model=new OpeModel();
    }

    public void validateNumber(String num1, String num2, String opr)
    {
        model.operate(num1,num2,opr,context,this);
    }

    public void frstnumError()
    {
        view.frstNumberError();
    }

    public void secnumError()
    {
        view.secNumberError();
    }

    public void toastmsg(double num1, double num2)
    {
        view.toastmsg(num1, num2);
    }

    public void secondActivity(double num1, double num2, double sum, String opr)
    {
        this.num1=num1;
        this.num2=num2;
        this.opr=opr;

            Intent i = new Intent(context, SecondActivity.class);
            i.putExtra("num1", num1);
            i.putExtra("num2", num2);
            i.putExtra("sum", sum);
            i.putExtra("opr", opr);
            context.startActivity(i);



    }




}
