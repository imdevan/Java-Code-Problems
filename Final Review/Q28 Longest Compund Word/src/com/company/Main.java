package com.company;

import java.util.ArrayList;

public class Main {
    public static void println(String s)
    {
        System.out.println(s);
    }
    public static String findLongestCompoundWord(String[] words){
        Trie trie = new Trie();
        ArrayList<String> pal = new ArrayList<String>();
        String longestCompoundWord = "";

        for(String word: words)
        {
            trie.insert(word);
            if(trie.getAllPrefexisOfWord(word).size() > pal.size()
                    && word.length() > longestCompoundWord.length())
            {
                longestCompoundWord = word;
                pal = trie.getAllPrefexisOfWord(word);
               // Print prefixes for testing
               // for(String s: pal)
               //     println(s + " " + s.length());
            }
        }

        return longestCompoundWord;
    }

    public static void main(String[] args) {

        String[] words = {"cat", "cats", "catsdogcats", "catxdogcatsrat", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcat", "ratcatdog", "ratcatdogcat"};

        println(findLongestCompoundWord(words));
    }
}
