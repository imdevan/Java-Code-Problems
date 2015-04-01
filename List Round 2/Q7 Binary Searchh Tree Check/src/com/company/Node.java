package com.company;

/**
 * Created by Devan on 4/1/2015.
 */
public class Node {
    Node left, right;
    Integer val;

    public Node(){
        left = null;
        right = null;
        val = null;
    }

    public Node(int v){
        left = null;
        right = null;
        val = v;
    }

    public void add(int v){
        if(val == null)
            val = v;
        else if(val > v)
            if(left == null)
                left = new Node(v);
            else
                left.add(v);
        else
            if(right == null)
                right = new Node(v);
            else
                right.add(v);
    }
}
