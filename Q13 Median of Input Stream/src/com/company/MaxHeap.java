package com.company;

import com.company.Heap;

import java.util.ArrayList;

/**
 * Created by Devan on 12/19/2014.
 */
public class MaxHeap extends Heap {

    protected void siftUp(int ni)
    {
        int pi, temp;
        if(ni != 0)
        {
            pi = getParent(ni);
            if(data.get(ni) > data.get(pi) )
            {
                swap(ni, pi);
                siftUp(pi);
            }
        }
    }

    protected void siftDown(int ni)
    {
        if(ni < data.size())
        {
            // p c1 c2 c1c1 c1c2 c2c1 c2c2
            int [] children = getChild(ni);
            if(data.size() == children[0])
                return;

            if(data.get(children[0]) > data.get(ni))
            {
                swap(children[0], ni);
                siftDown(children[0]);
            }
            else
            {
                swap(children[1], ni);
                siftDown(children[1]);
            }
        }
    }
}
