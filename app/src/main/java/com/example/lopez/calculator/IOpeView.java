package com.example.lopez.calculator;

/**
 * Created by cl5admin on 7/18/2015.
 */
public interface IOpeView {

    public void frstNumberError();

    public void secNumberError();

    public void nextActivity(String num1, String num2, String ope, double sum);

    public void errorInput(String num1, String num2, String ope);

}
