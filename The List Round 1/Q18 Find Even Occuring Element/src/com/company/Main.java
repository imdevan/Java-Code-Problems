package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static ArrayList<Integer> evenOccuringElements(int [] a)
    {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        ArrayList<Integer> r = new ArrayList<Integer>();

        for(int i : a)
            if(hm.containsKey(i))
                hm.put(i, hm.get(i)+1);
            else
                hm.put(i, 1);

        for(int i : hm.keySet())
            if(hm.get(i) % 2 == 0)
                r.add(i);

        return r;
    }

    public static void main(String[] args) {

        int [] test = {1,1,2,3,4,5,6,6};

        System.out.println("Test Result, should print '1'");

        for(int i : evenOccuringElements(test))
            System.out.println(i);
    }
}
