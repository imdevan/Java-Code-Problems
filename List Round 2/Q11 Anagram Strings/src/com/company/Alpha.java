package com.company;
import java.util.HashSet;


/**
 * Created by Devan on 4/1/2015.
 */
public class Alpha {
    private static HashSet<Character> alphabit;


    public static HashSet<Character> getAlphabit() {

        if(alphabit == null)
            init();

        return alphabit;
    }

    private static void init() {
        alphabit = new HashSet<Character>();
        alphabit.add('a');
        alphabit.add('b');
        alphabit.add('c');
        alphabit.add('d');
        alphabit.add('e');
        alphabit.add('f');
        alphabit.add('g');
        alphabit.add('h');
        alphabit.add('i');
        alphabit.add('j');
        alphabit.add('k');
        alphabit.add('l');
        alphabit.add('m');
        alphabit.add('n');
        alphabit.add('o');
        alphabit.add('p');
        alphabit.add('q');
        alphabit.add('r');
        alphabit.add('s');
        alphabit.add('t');
        alphabit.add('u');
        alphabit.add('v');
        alphabit.add('w');
        alphabit.add('x');
        alphabit.add('y');
        alphabit.add('z');
    }

    public static boolean isAlpha(Character c) {
        if(alphabit == null)
            init();

        return alphabit.contains(c);
    }
}
