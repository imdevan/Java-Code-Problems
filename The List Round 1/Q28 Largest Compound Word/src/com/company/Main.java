package com.company;

public class Main {

    public static void main(String[] args) {
        double grade = (2.977 * 122 ) + (10*4);
        grade /= 122+10;

        System.out.printf("%.3f", grade);

        /*
        Node trie = new Node();
        String [] test = {"cat", "cats", "catsdogcats", "catxdogcatrat",
                            "dog", "dogcatsdog", "hippopotamuses", "rat",
                            "rat", "ratcat" ,"ratcatdog", "ratcatdogcat"};

        for(String s : test)
            trie.insert(s);

        for(String s : trie.getAllPrefixesOfWord("ratcatdog"))
            System.out.println(s);

        trie.print();

        */
    }
}
