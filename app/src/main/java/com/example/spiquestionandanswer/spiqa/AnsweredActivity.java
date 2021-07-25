package com.example.spiquestionandanswer.spiqa;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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
