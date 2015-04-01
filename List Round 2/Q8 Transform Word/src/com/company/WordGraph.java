package com.company;

import java.util.HashMap;

/**
 * Created by Devan on 4/1/2015.
 */
public class WordGraph {

    public HashMap<String, GraphNode> words;

    public WordGraph() {
        words = new HashMap<String, GraphNode>();
    }

    public void add(String s) {
        // Word already in graph
        if(words.containsKey(s))
            return;

        // Put new graph node in
        words.put(s, new GraphNode(s));

        // Set neighbors of new graph node
        GraphNode refference = words.get(s);


        // Check if word has siblings in graph
        StringBuilder sb = new StringBuilder();

        // Add a letter
        for(int i = 0; i <= s.length(); i++){
            for(Character c : Alpha.getAlphabit()){
                sb.append(s);
                sb.insert(i,c);
                if(words.containsKey(sb.toString()))
                    makeNeighbors(sb.toString(), s);
                sb.setLength(0);
            }
        }

        // Change a letter
        for(int i = 0; i < s.length(); i++){
            for(Character c : Alpha.getAlphabit()){
                sb.append(s);
                sb.setCharAt(i, c);
                if(words.containsKey(sb.toString()))
                    makeNeighbors(sb.toString(), s);
                sb.setLength(0);
            }
        }

        // Remove a letter
        for(int i = 0; i < s.length(); i++){
            sb.append(s);
            sb.deleteCharAt(i);
            if(words.containsKey(sb.toString()))
                makeNeighbors(sb.toString(), s);
            sb.setLength(0);
        }

    }

    private void makeNeighbors(String s, String s2) {
        if(!words.containsKey(s) || !words.containsKey(s2) || s.equals(s2))
            return;

        words.get(s).neighbors.add(s2);
        words.get(s2).neighbors.add(s);
    }
}
