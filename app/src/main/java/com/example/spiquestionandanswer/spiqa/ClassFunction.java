package com.example.spiquestionandanswer.spiqa;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by LukiesLuke on 9/23/2016.
 */

public class ClassFunction {

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

    public static String ItemsBeenDuplicated(String sQ1) {
        ArrayList<String> items;

        items = new ArrayList<String>(Arrays.asList(sQ1.split(",")));
        List<String> myList = new ArrayList<String>(items);

        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String s : items) {
            Integer count = map.get(s);
            map.put(s, (count == null) ? 1 : count + 1);
        }
        return map.toString();
        //Toast.makeText(context.getApplicationContext(), "Duplicate array items count: " + map + "\n", Toast.LENGTH_LONG).show();
    }

    public static long calculateFactorial(Context context, long number) {

        long factorial = 1;
        try {
            factorial = number;
            for (long i = factorial - 1; i > 0; i--) {
                factorial = i * factorial;
            }
        } catch (NumberFormatException e) {
            Toast.makeText(context.getApplicationContext(), "Incorrect Input", Toast.LENGTH_LONG).show();
        }
        return factorial;
    }

    public static String arrayListDesOrderList(String sQ1) {
        ArrayList<String> items;

        items = new ArrayList<String>(Arrays.asList(sQ1.split(",")));
        Collections.sort(items, Collections.reverseOrder());
        StringBuilder builder = new StringBuilder();
        for (String str : items) {
            builder.append(str + "\n");
        }
        return builder.toString();

    }

    public static String primeNumber(int max) {
        int j = 2;
        StringBuilder builder = new StringBuilder();
        for (int i = j; i <= max; i++) {
            if (isPrimeNumber(i)) {
                builder.append(i + "\n");
                j = i + 1;
            }
        }
        return builder.toString();
    }

    private static boolean isPrimeNumber(int number) {

        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static String ArmStrong(int n) {
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

    public static String printFormat(int line) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < line; i++) {
            for (int x = 0; x <= i; x++) {
                builder.append("*");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
