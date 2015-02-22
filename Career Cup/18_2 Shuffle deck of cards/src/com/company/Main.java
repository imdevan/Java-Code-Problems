package com.company;

import java.util.Random;

public class Main {

    public static int rand(int a, int b)
    {
        Random r = new Random();
        return r.nextInt( b+ 1 - a) + a;
    }

    public static void arraySwap(int[] d, int swapi, int i)
    {
        int temp = d[i];
        d[i] = d[swapi];
        d[swapi] = temp;
    }

    public static void shuffle(int [] d, int i )
    {
        // Termination condition
        if(i == 0) return;

        // Random card to swap
        int swapi = rand(0, i);

        // Swap
        arraySwap(d, swapi, i);

        // Recur
        shuffle(d, i-1);
    }

    public static void shufffleDeck(int[] d)
    {
        shuffle(d, d.length -1);
    }
    public static void main(String[] args) {


    }
}
