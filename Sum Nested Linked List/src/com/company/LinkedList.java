package com.company;

/**
 * Created by Devan on 1/24/2015.
 */
public class LinkedList {
    LinkedList next;
    Integer intV;
    LinkedList listV;

    public LinkedList(){
        intV = null;
        listV = null;
        next = null;
    }

    public LinkedList(Integer v){
        intV = v;
        listV = null;
        next = null;
    }

    public LinkedList(LinkedList v){
        intV = null;
        listV = v;
        next = null;
    }

    public void add(int v){
        if(next == null)
            next = new LinkedList(v);
        else
            next.add(v);
    }

    public void add(LinkedList v){
        if(next == null)
            next = new LinkedList(v);
        else
            next.add(v);
    }

    public boolean isList(){
        return (listV != null);
    }

    public boolean isInt(){
        return (intV != null);
    }

    public boolean hasNext(){
        return(next != null);
    }
}
