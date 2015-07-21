package com.example.lopez.calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements IOpeView{

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.firstnum)
    EditText edtnum1;

    @Bind(R.id.secondnum)
    EditText edtnum2;

    @Bind(R.id.btnAdd)
    FloatingActionButton fabAdd;

    @Bind(R.id.btnSub)
    FloatingActionButton fabSub;

    @Bind(R.id.btnMul)
    FloatingActionButton fabMul;

    @Bind(R.id.btnDiv)
    FloatingActionButton fabDiv;

    @Bind(R.id.btnClr)
    FloatingActionButton fabClr;

    @Bind(R.id.btnEnd)
    FloatingActionButton fabEnd;

    OpePresenter mpresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        mpresenter = new OpePresenter(this, this);

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpresenter.validateNumber(edtnum1.getText().toString(), edtnum2.getText().toString(), "+");
            }
        });

        fabSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpresenter.validateNumber(edtnum1.getText().toString(), edtnum2.getText().toString(), "-");
            }
        });

        fabMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpresenter.validateNumber(edtnum1.getText().toString(), edtnum2.getText().toString(), "*");
            }
        });

        fabDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpresenter.validateNumber(edtnum1.getText().toString(), edtnum2.getText().toString(), "/");
            }
        });

        fabClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtnum1.setText("");
                edtnum2.setText("");
                edtnum1.requestFocus();
            }
        });

        fabEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void frstNumberError() {
        edtnum1.setError(getString(R.string.frst_num_error));
    }

    @Override
    public void secNumberError() {
        edtnum2.setError(getString(R.string.sec_num_error));
    }

    @Override
    public void nextActivity(String num1, String num2, String ope, double sum) {

        Intent i = new Intent(this, SecondActivity.class);

    }

    @Override
    public void errorInput(String num1, String num2, String ope) {

    }


}
