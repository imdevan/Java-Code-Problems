package com.company;

import java.util.Hashtable;
import java.util.Vector;

/**
 * Created by Devan on 12/11/2014.
 */
public class Graph {
    Hashtable<String, Node> nodeList;

    public Graph(String[] dict){
        nodeList = new Hashtable<String, Node>();
        for(String wrd : dict)
            nodeList.put(wrd, new Node(wrd));
    }
    public Graph(){
        nodeList = new Hashtable<String, Node>();
    }

    public void clear(){
        nodeList.clear();
    }
    public void addArray(String [] dict){
        for(String wrd : dict)
            nodeList.put(wrd, new Node(wrd));
    }

    public boolean contains(String s){
        return nodeList.get(s) != null;
    }

    public void setSiblings(String wrd, String sib){
        if(wrd == sib)
            return;

        else{
            nodeList.put(wrd, nodeList.get(wrd).addSib(sib));
            nodeList.put(sib, nodeList.get(sib).addSib(wrd));
        }
    }

    private void print(String s){
        System.out.print(s);
    }

    public void print(){
        for(String key : nodeList.keySet()){
            print("\nNode Key: \n");
            print(key);

            print("\nSiblings: \n");
            for(String sib : nodeList.get(key).siblings)
                print(sib + " ");
        }
    }
}
