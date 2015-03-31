package com.company;

import java.util.Random;

public class Main {

    public static void streamMedian(int [] a)
    {
        InputStream is = new InputStream();
        int result;
        for(int i = 0; i < a.length; i++)
        {
            is.add(a[i]);
            result = is.getMedian();
            System.out.println(result);
        }
    }
    public static void main(String[] args) {
        // Init test array
        Random r = new Random();
        int [] a = new int[25];
        for(int i = 0; i < a.length; i++)
            a[i] = r.nextInt(5);

        // Test function
        streamMedian(a);
    }
}
