package com.company;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Devan on 3/10/2015.
 */
public class TrieNode {
    boolean terminal;
    String terminalString;
    Character character;
    HashMap<Character, TrieNode> children;

    public TrieNode(){
        terminal = false;
        terminalString = null;
        character = null;
        children = new HashMap<Character, TrieNode>();
    }
    public TrieNode(Character c){
        terminal = false;
        terminalString = null;
        character = c;
        children = new HashMap<Character, TrieNode>();
    }
}
