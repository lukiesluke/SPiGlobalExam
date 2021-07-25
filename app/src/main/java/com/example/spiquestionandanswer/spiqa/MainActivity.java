package com.example.spiquestionandanswer.spiqa;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.mylibrary.Luke;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txtq1, txtq2;
    EditText editTextQ1, editTextQ2, editTextQ4, editTextQ5, editTextQ6;
    Button btnQ1, btnShowAnw1a, btnShowAnw1b, btnShowAnw2, btnShowAnw3, btnShowAnw4, btnShowAnw5, btnShowAnw6;
    String sQ1 = "2,4,2,8,3,8,2";
    long sQ2 = 15;
    private ArrayList<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Toast.makeText(this, Luke.myLastName(), Toast.LENGTH_LONG).show();

        txtq1 = (TextView) findViewById(R.id.txtq1);
        txtq2 = (TextView) findViewById(R.id.txtq2);
        btnQ1 = (Button) findViewById(R.id.btnQ1Set);

        btnShowAnw1a = (Button) findViewById(R.id.btnShowAnw1a);
        btnShowAnw1b = (Button) findViewById(R.id.btnShowAnw1b);
        btnShowAnw2 = (Button) findViewById(R.id.btnShowAnw2);
        btnShowAnw3 = (Button) findViewById(R.id.btnShowAnw3);
        btnShowAnw4 = (Button) findViewById(R.id.btnShowAnw4);
        btnShowAnw5 = (Button) findViewById(R.id.btnShowAnw5);
        btnShowAnw6 = (Button) findViewById(R.id.btnShowAnw6);

        editTextQ1 = (EditText) findViewById(R.id.editTextQ1);
        editTextQ2 = (EditText) findViewById(R.id.editTextQ2);
        editTextQ4 = (EditText) findViewById(R.id.editTextQ4);
        editTextQ5 = (EditText) findViewById(R.id.editTextQ5);
        editTextQ6 = (EditText) findViewById(R.id.editTextQ6);

        editTextQ1.setText(sQ1);
        editTextQ2.setText(sQ2 + "");
        editTextQ4.setText("1000");
        editTextQ5.setText("153");
        editTextQ6.setText("6");

        btnQ1.setOnClickListener(this);
        btnShowAnw1a.setOnClickListener(this);
        btnShowAnw1b.setOnClickListener(this);
        btnShowAnw2.setOnClickListener(this);
        btnShowAnw3.setOnClickListener(this);
        btnShowAnw4.setOnClickListener(this);
        btnShowAnw5.setOnClickListener(this);
        btnShowAnw6.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btnQ1Set) {
            hideScreenKeyboard();
            sQ1 = editTextQ1.getText().toString().trim();
            txtq1.setText("1. Given an array: {" + sQ1 + "}");
        }

        if (view.getId() == R.id.btnShowAnw1a) {
            hideScreenKeyboard();
            sQ1 = editTextQ1.getText().toString().trim();
            items = new ArrayList<String>(Arrays.asList(sQ1.split(",")));

            Toast.makeText(this, "" + ClassFunction.findDuplicates(items), Toast.LENGTH_LONG).show();
        }

        if (view.getId() == R.id.btnShowAnw1b) {
            hideScreenKeyboard();
            sQ1 = editTextQ1.getText().toString().trim();

            Intent i = new Intent(this, AnsweredActivity.class);
            i.putExtra("QUESTION", "Q1b");
            i.putExtra("VALUE", sQ1);
            startActivity(i);

            //ClassFunction.ItemsBeenDuplicated(this, sQ1);
        }

        if (view.getId() == R.id.btnShowAnw2) {
            hideScreenKeyboard();
            sQ2 = Long.parseLong(editTextQ2.getText().toString().trim());
            editTextQ2.setText(sQ2 + "");

            Toast.makeText(this, "Factorial number:\n" + ClassFunction.calculateFactorial(this, sQ2), Toast.LENGTH_LONG).show();
        }

        if (view.getId() == R.id.btnShowAnw3) {
            hideScreenKeyboard();
            sQ1 = editTextQ1.getText().toString().trim();

            Intent i = new Intent(this, AnsweredActivity.class);
            i.putExtra("QUESTION", "Q3");
            i.putExtra("VALUE", sQ1);
            startActivity(i);
            //Toast.makeText(this, "Array value {" + sQ1.trim() + "} in descending orders" + ClassFunction.arrayListDesOrderList(sQ1), Toast.LENGTH_LONG).show();
        }

        if (view.getId() == R.id.btnShowAnw4) {
            hideScreenKeyboard();
            int num = Integer.parseInt(editTextQ4.getText().toString().trim());

            Intent i = new Intent(this, AnsweredActivity.class);
            i.putExtra("QUESTION", "Q4");
            i.putExtra("VALUE", num + "");
            startActivity(i);

            //Toast.makeText(this, "all prime numbers:\n" + ClassFunction.primeNumber(num), Toast.LENGTH_LONG).show();
        }

        if (view.getId() == R.id.btnShowAnw5) {
            hideScreenKeyboard();
            int num = Integer.parseInt(editTextQ5.getText().toString().trim());
            Toast.makeText(this, "Armstrong Number: " + num + "\n" + ClassFunction.ArmStrong(num), Toast.LENGTH_LONG).show();
        }

        if (view.getId() == R.id.btnShowAnw6) {
            hideScreenKeyboard();
            int num = Integer.parseInt(editTextQ6.getText().toString().trim());

            Intent i = new Intent(this, AnsweredActivity.class);
            i.putExtra("QUESTION", "Q6");
            i.putExtra("VALUE", num + "");
            startActivity(i);

            //Toast.makeText(this, "prints format:\n" + ClassFunction.printFormat(num), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        hideScreenKeyboard();
    }

    public void hideScreenKeyboard() {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        if (getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }
}
