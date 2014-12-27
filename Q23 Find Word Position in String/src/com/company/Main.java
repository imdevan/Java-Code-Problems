package com.company;

import java.util.HashMap;
import java.util.LinkedList;

public class Main {

    // Given a text file and a word, find the positions that the world occurs in the file.
    // We'll be asked to find the positions of many words in the same file.
    protected static String[] getWords(String text) {
        return text.toLowerCase().split(" ");
    }

    public static HashMap<String, LinkedList<Integer>> precompile(String text) {
        HashMap<String, LinkedList<Integer>> index = new HashMap<String, LinkedList<Integer>>();
        String[] words = getWords(text);

        for (int i = 0; i < words.length; i++) {
            if (index.get(words[i]) == null)
                index.put(words[i], new LinkedList<Integer>());

            index.get(words[i]).add(i);
        }

        return index;
    }

    public static LinkedList<Integer> getWordPos(HashMap<String, LinkedList<Integer>> hm, String s)
    {
        return hm.get(s);
    }
    public static void main(String[] args)
    {
        String text = "We can use hashtable as our inverted index. The key is a word in the file, and the value is the array of positions that word occurs. So, we’ll get all the words in the file and populate the hashtable with their positions. The words may contain capital letters, but we don’t want separate entries for apple, and Apple in our inverted index. So, we’ll write our  own parsing function which converts all the words to lowercase, eliminates non-alphanumeric characters, and then splits on whitespace to get all the actual words in the file. We can do it easily using regular expressions";
        HashMap<String, LinkedList<Integer>> wordIndex = precompile(text);

        for(int i : getWordPos(wordIndex, "the"))
            System.out.print(i + " ");
    }
}
