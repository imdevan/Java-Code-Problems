package com.company;

import java.util.HashSet;
import java.util.Vector;

/**
 * Created by Devan on 12/11/2014.
 */
public class Node {
    String val;
    HashSet<String> siblings;

    // Constructor with value
    public Node(String v){
        val = v;
        siblings = new HashSet<String>();
    }

    public Node(String v, HashSet<String> sibs){
        val = v;
        siblings = sibs;
    }

    public Node addSib(String s){
        siblings.add(s);
        return new Node(val, siblings);
    }
}
