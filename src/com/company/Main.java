package com.company;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Vector;

public class Main {

    public  static void constructGraph(Graph graph, String[] dict, char[] alphabet)
    {
        // Initialize temporary strings
        String remove, change, add;

        // Clear graph and add dictionary
        graph.clear();
        graph.addArray(dict);

        // Make connections in graph
        for(String word : dict)
        {
            for(int i = 0; i < word.length(); i++)
            {
                // Remove 1 Character
                remove = word.substring(0,i) + word.substring(i + 1);
                if(graph.contains(remove) && !remove.equals(word))
                    graph.setSiblings(word, remove);

                // Change 1 character
                for(char c : alphabet)
                {
                    change = word.substring(0,i) + c + word.substring(i+1);
                    if(graph.contains(change)  && !change.equals(word))
                        graph.setSiblings(word, change);
                }
            }

            // Add 1 character
            for(int i = 0; i < word.length()+1; i ++)
            {
                for(char c : alphabet)
                {
                    add = word.substring(0,i) + c + word.substring(i);
                    if(graph.contains(add))
                        graph.setSiblings(word, add);
                }
            }
        }
    }

    public static Vector<String> transformWord(Graph graph, String src, String trgt){

        if(graph.nodeList.size() == 0 || !graph.contains(src) || !graph.contains(src))
            return new Vector<String>();


        ArrayDeque<Vector<String>> paths = new ArrayDeque<Vector<String>>();
        Vector<String> currentPath;
        Vector<String> tempPath;
        HashSet<String> seen = new HashSet<String>();
        String currentWord;


        currentPath = new Vector<String>();
        currentPath.add(src);
        paths.add(currentPath);

        while(paths.size() != 0){
            currentPath = paths.pollFirst();
            currentWord = currentPath.lastElement();

            if(currentWord.equals(trgt))
                return currentPath;
            else if(seen.contains(currentWord))
                continue;

            seen.add(currentWord);
            for(String word : graph.nodeList.get(currentWord).siblings)
                    if(!currentPath.contains(word))
                    {

                        tempPath = (Vector)currentPath.clone();
                        tempPath.add(word);
                        paths.addLast(tempPath);
                    }
        }

        return new Vector<String>();
    }

    public static void main(String[] args) {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        String[] dictionary = {"at","cat",  "bet", "bat", "ad", "ed", "bed"};

        Graph testGraph = new Graph();

        constructGraph(testGraph, dictionary, alphabet);

        // Print testGraph
        testGraph.print();

        Vector<String> path = transformWord(testGraph, "cat", "bed");
        System.out.println(path);
    }
}
