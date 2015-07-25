package com.example.lopez.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.text.DecimalFormat;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by cl5admin on 7/18/2015.
 */
public class SecondActivity extends AppCompatActivity implements IsecondView{

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.txt1stnum)
    TextView num1;

    @Bind(R.id.txt2ndnum)
    TextView num2;

    @Bind(R.id.ans)
    TextView sum;

    @Bind(R.id.txtoperand)
    TextView opr;

    SecondPresenter second;

    String temp1,temp2,tempope,tempresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        second = new SecondPresenter(this,this);
        temp1 = getIntent().getExtras().getString("num1");
        temp2 = getIntent().getExtras().getString("num2");
        tempope = getIntent().getExtras().getString("operator");
        tempresult = getIntent().getExtras().getString("result");
        second.validateNumber(temp1,temp2,tempope,tempresult);

    }

    @Override
    public void setSuccessColor() {
         sum.setBackgroundColor(getResources().getColor(R.color.Success));
    }

    @Override
    public void setErrorColor() {
        sum.setBackgroundColor(getResources().getColor(R.color.error_color));
    }

    @Override
    public void display(String roundof) {
        this.tempresult=roundof;
        num1.setText(""+temp1);
        num2.setText(""+temp2);
        opr.setText(""+tempope);
        sum.setText("" + tempresult);
    }

    public void error()
    {
        num1.setText(""+temp1);
        num2.setText(""+temp2);
        opr.setText(""+tempope);
        sum.setText("ERROR");
    }


}
