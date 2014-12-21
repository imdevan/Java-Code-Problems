package com.company;

import java.util.ArrayList;

/**
 * Created by Devan on 12/18/2014.
 */
public class MinHeap {
    ArrayList<Integer> data;

    public MinHeap()
    {
        data = new ArrayList<Integer>();
    }

    public void insert(int val)
    {
        data.add(val);
        siftUp(data.size()-1);
    }

    private int getParentNodeIndex(int ni)
    {
        return (ni%2 == 0)? (ni/2 - 1) : ni/2;
    }

    private void siftUp(int ni)
    {
        int pi, tmp;
        if(ni != 0)
        {
            pi = getParentNodeIndex(ni);
            if((data.get(pi) > data.get(ni)))
            {
                tmp = data.get(ni);
                data.set(ni, data.get(pi));
                data.set(pi, tmp);

                siftUp(pi);
            }
        }
    }
}
