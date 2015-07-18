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
public class SecondActivity extends AppCompatActivity{

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        DecimalFormat format = new DecimalFormat("#,###.00");
        num1.setText("" +format.format(getIntent().getExtras().getDouble("num1")));
        num2.setText(""+format.format(getIntent().getExtras().getDouble("num2")));
        sum.setText(""+format.format(getIntent().getExtras().getDouble("sum")));
        opr.setText(""+getIntent().getExtras().getString("opr"));
    }

}
