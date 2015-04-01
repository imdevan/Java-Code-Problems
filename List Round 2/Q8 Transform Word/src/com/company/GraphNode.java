package com.company;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Devan on 4/1/2015.
 */
public class GraphNode {
    ArrayList<String> neighbors;
    String val;

    public GraphNode(){
        neighbors = new ArrayList<String>();
        val = null;
    }
    public GraphNode(String s){
        neighbors = new ArrayList<String>();
        val = s;
    }

}
