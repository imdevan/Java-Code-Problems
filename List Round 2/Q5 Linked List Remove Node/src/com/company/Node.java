package com.company;

/**
 * Created by Devan on 3/31/2015.
 */
public class Node {
    Integer val;
    Node next;

    public Node(){
        val = null;
        next = null;
    }

    public Node(int val){
        this.val = val;
        this.next = null;
    }

    public void add(int v){
        if(next != null)
            next.add(v);
        else
            next = new Node(v);
    }

    public void print(){
        if(next == null)
            return;

        System.out.println(next.val);
        next.print();
    }
}
