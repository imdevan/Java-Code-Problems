package com.company;

import java.util.ArrayList;

/**
 * Created by Devan on 12/19/2014.
 */
public abstract class Heap {
    protected ArrayList<Integer> data;

    public Heap()
    {
        data = new ArrayList<Integer>();
    }

    public void add(int v)
    {
        data.add(v);
        siftUp(data.size()-1);
    }

    public Integer pop()
    {
        Integer temp = data.get(0);
        swap(0, data.size()-1);
        siftDown(0);

        data.remove(data.size()-1);

        return temp;
    }

    public int size()
    {
        return data.size();
    }

    public Integer getFirst()
    {
        return data.get(0);
    }

    protected int getParent(int ni)
    {
        return (ni%2 == 0) ? ni/2 - 1: ni/2;
    }

    protected int[] getChild(int ni)
    {
        int[] a = {ni*2 + 1, ni*2 + 2};
        return a;
    }

    protected void swap(int n1, int n2)
    {
        int temp = data.get(n1);
        data.set(n1, data.get(n2));
        data.set(n2, data.get(n1));
        data.set(n2, data.get(n1));
    }

    /*
     * Sift Up & Down Implented in child classes
     */
    protected abstract void siftUp(int i);
    protected abstract void siftDown(int i);

}
