package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] ta = new int[100];
        Random r = new Random();

        for(int i = 0; i < ta.length; i++)
            ta[i] = r.nextInt(100);

        // Test input stream
        InputStream is = new InputStream();

        for(int i : ta)
            is.add(i);

    }
}
