package com.company;

/**
 * Created by Devan on 12/18/2014.
 */
public class Node <T>{
    T val;
    Node left, right;
    public Node()
    {
        val = null;
        left = null;
        right = null;
    }
    public Node(T v)
    {
        val = v;
        left = null;
        right = null;
    }
    public void add(T v)
    {
        if( val != null)
        {
            if (left == null)
                left = new Node(v);
            else if (right == null)
                right = new Node(v);
            else if(left.left == null || left.right == null)
                left.add(v);
            else
                right.add(v);
        }
        else
            val = v;
    }
}
