package com.company;

import java.util.ArrayList;

/**
 * Created by Devan on 12/18/2014.
 */

public class InputStream{

    int length = 0;
    ArrayList<Integer> al;
    int median;

    public InputStream (){
        length = 0;
        al = new ArrayList<Integer>();
    }

    public void add(int in)
    {
        length++;
        al.add(in);

        if(length%2 == 0 && length >  2)
        {
            median = al.get(length/2) + al.get(length/2 +1);
        }
        else
            median = al.get(length/2);

        System.out.println(median);
    }
}

