package com.example.lopez.calculator;

import android.os.Bundle;

/**
 * Created by cl5admin on 7/18/2015.
 */
public interface ImainView {

    public void frstNumberError();

    public void secNumberError();

    public void nextActivity(String num1, String num2, String operator, String result);

}
