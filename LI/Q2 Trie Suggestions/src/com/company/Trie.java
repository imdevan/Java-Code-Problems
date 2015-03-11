package com.company;

/**
 * Created by Devan on 3/10/2015.
 */
public class Trie {
    TrieNode head;
    public Trie(){
        head = new TrieNode();
    }

    // For this example we are going to assume that our basic tree
    // will contain the words:
    // go, good, god, google
    public void populateTree(){
        addWord("go");
        addWord("good");
        addWord("google");
    }

    public void addWord(String word){
        char[] ca = word.toCharArray();
        TrieNode current = head;
        int cnt = 0;


        for(int i = 0; i < ca.length; i++){
            if(current.children.containsKey(ca[i]))
                current = current.children.get(ca[i]);
            else {
                current.children.put(ca[i], new TrieNode(ca[i]));
                current = current.children.get(ca[i]);
            }
            if(i == ca.length -1){
                current.terminal = true;
                current.terminalString = word;
            }
        }
    }
}
