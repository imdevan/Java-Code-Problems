package com.company;

import java.util.ArrayList;

/**
 * Created by Devan on 12/27/2014.
 */
public class Node {
    Character letter;
    boolean isTerminal;
    ArrayList<Node> children;

    public Node()
    {
        letter = null; isTerminal = false; children = new ArrayList<Node>();
    }

    public Node(char c)
    {
        letter = c; isTerminal = false; children = new ArrayList<Node>();
    }

    // Insert word into trie
    public void insert(String word)
    {
        Node current = this;
        for(int i = 0; i < word.length(); i++)
        {
            char l = word.charAt(i);
            if(!current.contains(l))
                current.children.add(new Node(l));
        }

        current.isTerminal = true;
    }

    // Returns ArrayList of all prefixes of word
    public ArrayList<String> getAllPrefixesOfWord(String word)
    {
        String prefix = "";
        ArrayList<String> prefixes = new ArrayList<String>();

        Node current = this;
        for(int i = 0; i < word.length(); i++)
        {
            char l = word.charAt(i);

            if(!current.contains(l))
                return prefixes;

            current = current.children.get(children.indexOf(l));
            prefix += l;

            if (current.isTerminal)
                prefixes.add(prefix);
        }

        return prefixes;
    }

    // Determine of character is in trie
    public boolean contains(char c)
    {
        if(letter == null)
            return false;
        else if(letter.equals(c))
            return true;
        else
            for(Node n: children)
                if(n.contains(c))
                    return true;

        // Not found in self or children
        return false;
    }

    public void print()
    {
        if(letter != null)
        System.out.print(letter);
        for(Node n : children)
        {
            n.print();
            if(isTerminal == true)
                System.out.print("\n");
        }
    }

}
