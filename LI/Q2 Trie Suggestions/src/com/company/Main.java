package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    // Given a tring return all possible suggesetions from a precompiled trie
    // ex: go from trie compiled in Trie class

    public static ArrayList<String> getSuggestions(Trie t, String word){
        // Result list
        ArrayList<String> r = new ArrayList<String>();

        // Go to the spot in the trie where the word ends
        TrieNode current = t.head;
        for(char c : word.toCharArray())
            if(current.children.containsKey(c))
                current = current.children.get(c);

        // Current is now equal to the trie node of the last character of the word

        // BFS of trie to find terminal terms
        // Structures for bfs
        Queue<TrieNode> queue = new LinkedList<TrieNode>();
        queue.add(current);

        while(queue.size() > 0){

            TrieNode curr = queue.poll();
            if(curr.terminal)
                r.add(curr.terminalString);

            if(curr.children != null)
                for(Character c: curr.children.keySet())
                    queue.add(curr.children.get(c));
        }

        return r;
    }


    public static void main(String[] args) {
        Trie precompiledTrie = new Trie();
        precompiledTrie.populateTree();

        for(String word : getSuggestions(precompiledTrie, "go"))
            System.out.println(word);
    }
}
