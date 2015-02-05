package com.company;

/**
 * Created by Devan on 1/6/2015.
 */

public class Node{
    Integer val;
    Node next;

    public Node(){
        val = null; next = null;
    }
    public Node(int v)
    {
        val = v; next = null;
    }
    public void addArray(int[] v)
    {
        for(int vi: v)
            add(vi);
    }
    public void add(int v)
    {
        if(next == null)
            next = new Node(v);
        else
            next.add(v);
    }
    public void print()
    {
        if(next == null)
            return;

        System.out.print(next.val + " ");

        next.print();
    }
}