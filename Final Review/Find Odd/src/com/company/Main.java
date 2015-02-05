package com.company;

public class Main {
    public static int findOdd(int[] a) {
        int r = 0;
        for(int num: a)
            r ^= num;
        return r;
    }
    public static void main(String[] args) {
        int [] a = {1,2,3,1, 20};
        System.out.println(findOdd(a));
        int [] b = {1,2,3,1,3, 2};
        System.out.println(findOdd(b));
    }
}