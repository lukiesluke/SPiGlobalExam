package com.example.spiquestionandanswer.spiqa;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class AnsweredActivity extends AppCompatActivity {
    private String question, value;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answered);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtResult = (TextView) findViewById(R.id.txtResult);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            question = extras.getString("QUESTION");
            value = extras.getString("VALUE").trim();
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Back to Hone", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        questionResult(question);
    }

    public void questionResult(String q) {

        switch (q) {
            case "Q1b":
                txtResult.setText("Duplicate array value = {" + value + "} items count:\n" + ClassFunction.ItemsBeenDuplicated(value));
                break;
            case "Q3":
                txtResult.setText("Array value = {" + value + "} in descending orders:\n" + ClassFunction.arrayListDesOrderList(value));
                break;
            case "Q4":
                txtResult.setText("All prime numbers <" + value + ":\n" + ClassFunction.primeNumber(Integer.parseInt(value)));
                break;
            case "Q6":
                txtResult.setText("Prints format:\n" + ClassFunction.printFormat(Integer.parseInt(value)));
                break;
        }
    }
}
