package com.company;

public class Main {

    public static void main(String[] args) {
        int[] testArray = {1,2,3,2,3};
        System.out.printf("Largest continuous sum: %d", ContSum.findSum(testArray));
    }
}
