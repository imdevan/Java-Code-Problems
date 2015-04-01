package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Main {


    public static void main(String[] args) {
	// write your code here
        WordGraph dict = new WordGraph();
        dict.add("cat");
        dict.add("at");
        dict.add("bat");
        dict.add("ad");
        dict.add("bet");
        dict.add("ed");
        dict.add("bed");

        String src = "cat", trgt = "bed";

        ArrayList<String> transformChain = getTransformChain(dict, src, trgt);

        for(String s : transformChain)
            System.out.println(s);
    }

    private static ArrayList<String> getTransformChain(WordGraph dict, String src, String trgt) {

        if(src == trgt)
            return null;

        // breadth first search
        Queue<ArrayList<String>> paths = new LinkedList<ArrayList<String>>();
        HashSet<String> seen = new HashSet<String>();
        ArrayList<String> firstPath = new ArrayList<String>();
        firstPath.add(src);
        paths.add(firstPath);

        while(paths.size() > 0){
            ArrayList<String> currPath = paths.poll();
            String currWord = currPath.get(currPath.size()-1);
            GraphNode currNode = dict.words.get(currWord);

            // Found target
            if(currWord.equals(trgt))
                return currPath;

            // Already visited current word
            else if(seen.contains(currWord))
                continue;

            // Add word to visited

            // add each neighbor to the list
            for(String s : currNode.neighbors)
            {
                ArrayList<String> newPath = (ArrayList<String>) currPath.clone();
                newPath.add(s);
                paths.add(newPath);
            }
        }

        // throw exception
        // shouldn't get here
        return null;
    }
}
