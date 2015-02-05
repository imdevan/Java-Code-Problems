package com.company;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by Devan on 1/13/2015.
 */
public class Trie {
    Character letter;
    // Some kind of data structure of children
    HashMap<Character, Trie> children;
    boolean isTerminal;

    public Trie(){
        letter = null;
        children = new HashMap<Character, Trie>();
        isTerminal = false;
    }
    public Trie(Character c){
        letter = c;
        children = new HashMap<Character, Trie>();
        isTerminal = false;
    }
    public void insert(String word)
    {
        Trie current = this;
        for(int i = 0; i < word.length(); i++)
        {
            Character letter = word.charAt(i);
            if(!current.children.containsKey(letter))
                current.children.put(letter, new Trie(letter));
            current = current.children.get(letter);
        }
        current.isTerminal = true;
    }
    public ArrayList<String> getAllPrefexisOfWord(String word)
    {
        String prefix = "";
        ArrayList<String> prefixes = new ArrayList<String>();
        Trie current = this;
        for(int i = 0; i < word.length(); i++)
        {
            Character letter = word.charAt(i);
            if(!current.children.containsKey(letter))
                return prefixes;
            current = current.children.get(letter);
            prefix += letter;
            if(current.isTerminal)
                prefixes.add(prefix);
        }
        return prefixes;
    }


    private void println(Character s){
        if(isTerminal)
            System.out.println(s + " " + "T");
        else
            System.out.println(s);
    }
    private void print(String s){
        System.out.print(s);
    }
    public void print(){
        println(letter);

        for(Character c: children.keySet())
            children.get(c).print();
    }
}
