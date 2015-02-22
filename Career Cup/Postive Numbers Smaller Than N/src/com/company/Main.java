package com.company;

import java.util.HashSet;

public class Main {
    public static void sop(int n){System.out.println(n);}

    // Function that printse all numbers smaller than N that are also the sum of 2 cubed numbers
    public static void printSmallerThanNOn2(int num){
        int count = 0;
        for(int i = 0; i < num; i++){
            for(int j = 0; j < num; j++){
                count = i*i*i + j*j*j;
                if(count < num)
                    sop(count);
            }
        }
    }

    // Function that printse all numbers smaller than N that are also the sum of 2 cubed numbers
    public static void printSmallerThanN(int num){
        HashSet<Integer> hs = new HashSet<Integer>();
        int count = 0;
        float numCubeRoot = (float) Math.cbrt((double)num);
        for(int i = 1; i <= numCubeRoot; i++){
            for(int j = 1; j <= numCubeRoot; j++){
                count = i*i*i + j*j*j;
                if(count < num){
                    if(!hs.contains(count)){
                        sop(count);
                        hs.add(count);
                    }
                }
            }
        }
    }




    public static void main(String[] args) {
	// write your code here
        printSmallerThanN(2000);
    }
}
