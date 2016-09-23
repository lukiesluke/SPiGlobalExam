package com.example.spiquestionandanswer.spiqa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txtq1, txtq2;
    EditText editTextQ1, editTextQ2, editTextQ4, editTextQ5, editTextQ6;
    Button btnQ1, btnQ2, btnShowAnw1a, btnShowAnw1, btnShowAnw2, btnShowAnw3, btnShowAnw4, btnShowAnw5, btnShowAnw6;
    String sQ1 = "2,4,2,8,3,8,2";
    long sQ2 = 15;
    private ArrayList<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtq1 = (TextView) findViewById(R.id.txtq1);
        txtq2 = (TextView) findViewById(R.id.txtq2);
        btnQ1 = (Button) findViewById(R.id.btnQ1Set);

        btnShowAnw1 = (Button) findViewById(R.id.btnShowAnw1);
        btnShowAnw1a = (Button) findViewById(R.id.btnShowAnw1a);
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
        editTextQ4.setText("100");
        editTextQ5.setText("153");
        editTextQ6.setText("6");

        btnQ1.setOnClickListener(this);
        btnShowAnw1a.setOnClickListener(this);
        btnShowAnw1.setOnClickListener(this);
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

        //noinspection SimplifiableIfStatement
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
            txtq1.setText("1. Given an array: " + sQ1);
        }

        if (view.getId() == R.id.btnShowAnw1a) {
            hideScreenKeyboard();
            sQ1 = editTextQ1.getText().toString().trim();
            items = new ArrayList<String>(Arrays.asList(sQ1.split(",")));
            findDuplicates(items);
            Toast.makeText(this, "" + findDuplicates(items), Toast.LENGTH_LONG).show();
        }

        if (view.getId() == R.id.btnShowAnw1) {
            hideScreenKeyboard();
            sQ1 = editTextQ1.getText().toString().trim();
            ItemsBeenDuplicated(sQ1);
        }

        if (view.getId() == R.id.btnShowAnw2) {
            hideScreenKeyboard();
            sQ2 = Long.parseLong(editTextQ2.getText().toString().trim());
            editTextQ2.setText(sQ2 + "");
            Toast.makeText(this, "Factorial number of:\n" + sQ2 + " = " + calculateFactorial(sQ2), Toast.LENGTH_LONG).show();
        }

        if (view.getId() == R.id.btnShowAnw3) {
            hideScreenKeyboard();
            sQ1 = editTextQ1.getText().toString().trim();
            arrayListDesOrderList(sQ1);
        }

        if (view.getId() == R.id.btnShowAnw4) {
            hideScreenKeyboard();
            int num = Integer.parseInt(editTextQ4.getText().toString().trim());
            ArmStrong(num);
            Toast.makeText(this, "all prime numbers:\n" + primeNumber(num), Toast.LENGTH_LONG).show();
        }

        if (view.getId() == R.id.btnShowAnw5) {
            hideScreenKeyboard();
            int num = Integer.parseInt(editTextQ5.getText().toString().trim());
            Toast.makeText(this, "Armstrong Number: " + num + "\n" + ArmStrong(num), Toast.LENGTH_LONG).show();
        }

        if (view.getId() == R.id.btnShowAnw6) {
            hideScreenKeyboard();
            int num = Integer.parseInt(editTextQ6.getText().toString().trim());
            Toast.makeText(this, "prints format:\n" + printFormat(num), Toast.LENGTH_LONG).show();
        }
    }

    public static Set<String> findDuplicates(List<String> listContainingDuplicates) {

        final Set<String> setToReturn = new HashSet<String>();
        final Set<String> set1 = new HashSet<String>();

        for (String yourInt : listContainingDuplicates) {
            if (!set1.add(yourInt)) {
                setToReturn.add(yourInt);
            }
        }
        return setToReturn;
    }

    private void ItemsBeenDuplicated(String sQ1) {
        items = new ArrayList<String>(Arrays.asList(sQ1.split(",")));
        List<String> myList = new ArrayList<String>(items);

        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String s : items) {
            Integer count = map.get(s);
            map.put(s, (count == null) ? 1 : count + 1);
        }

        Toast.makeText(this, "Duplicate array items count: " + map + "\n", Toast.LENGTH_LONG).show();
    }

    private long calculateFactorial(long number) {

        long factorial = 1;
        try {
            factorial = number;
            for (long i = factorial - 1; i > 0; i--) {
                factorial = i * factorial;
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Incorrect Input", Toast.LENGTH_LONG).show();
        }
        return factorial;
    }

    private void arrayListDesOrderList(String sQ1) {
        items = new ArrayList<String>(Arrays.asList(sQ1.split(",")));
        Collections.sort(items, Collections.reverseOrder());
        StringBuilder builder = new StringBuilder();
        for (String str : items) {
            builder.append(str + "\n");
        }
        builder.toString();
        Toast.makeText(this, "descending order:\n" + builder.toString(), Toast.LENGTH_LONG).show();
    }

    private boolean isPrimeNumber(int number) {

        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private String primeNumber(int max) {
        int j = 2;
        StringBuilder builder = new StringBuilder();
        for (int i = j; i <= max; i++) {
            if (isPrimeNumber(i)) {
                builder.append(i + "\n");
                System.out.print("function of prime number: " + i + "\n");
                j = i + 1;
            }
        }
        return builder.toString();
    }

    private String printFormat(int line) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < line; i++) {
            for (int x = 0; x <= i; x++) {
                builder.append("*");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    private String ArmStrong(int n) {
        int c = 0, a, temp;
        temp = n;
        while (n > 0) {
            a = n % 10;
            n = n / 10;
            c = c + (a * a * a);
        }

        String result;
        if (temp == c) {
            result = "armstrong number";
        } else {
            result = "Not armstrong number";
        }
        return result;
    }

    public void hideScreenKeyboard() {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        if (getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }
}
