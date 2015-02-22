package com.company;

public class Main{
    public static int addWithout(int a, int b)
    {
        if(b == 0) return a;        // termination condition
        int sum = a ^ b;            // sum without carry
        int carry = (a&b) << 1;     // carry without sum
        return addWithout(sum, carry);    // recur
    }

    public static void main(String[] args){
        int a = 22, b = 11, result = addWithout(a, b);
        System.out.printf("Test: %d + %d = %d", a, b, result);
    }
}