package com.company;

import java.util.ArrayList;
import java.util.HashSet;

public class Main {

    public static class Pair{
        int first, second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
        public void print(){
            System.out.printf("{%d, %d}", first, second);
        }
    }
    /**
     * Given an integer array, output all pairs that sum up to a specific value k.
     */
    public static ArrayList<Pair> getArrayPairs(int[] intArray, int k){

        ArrayList<Pair> output = new ArrayList<Pair>();
        HashSet<Integer> seen = new HashSet<Integer>();

        for(Integer num : intArray){
            int target = k - num;
            if(seen.contains(target))
                output.add(new Pair(target, num));

            else
                seen.add(num);
        }

        return output;
    }

    public static void main(String[] args) {
        int[] testArray = {5,5,2,1,3,4,5};
        ArrayList<Pair> output = getArrayPairs(testArray, 7);

        for(Pair pair : output)
            pair.print();
    }
}
