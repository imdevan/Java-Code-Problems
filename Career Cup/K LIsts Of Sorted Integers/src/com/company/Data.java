package com.company;

import java.util.Comparator;

/**
 * Created by Devan on 2/11/2015.
 */
public class Data implements Comparable<Data>{
    public Integer val;
    public Integer list;
    public Integer index;

    public Data(int v, int l){
        val = v;
        list = l;
        index = null;
    }

    public Data(int v, int l, int i){
        val = v;
        list = l;
        index = i;
    }

    @Override
    public int compareTo(Data o) {
        return val - o.val;
    }
}
