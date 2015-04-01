package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        String str1 = "abc", str2 = "def";

        String str3 = interleaveStrings(str1, str2);

        System.out.printf("%s, %s\n%s", str1, str2, str3);

    }

    private static String interleaveStrings(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        int c1 = 0, c2 = 0;

        while(c1 < str1.length() || c2 < str2.length()){
            int stri = (Math.random()<0.5)?0:1;

            if(stri == 0 && c1 < str1.length() || c2 >= str2.length())
                sb.append(str1.charAt(c1++));
            else
                sb.append(str2.charAt(c2++));
        }

        return sb.toString();
    }
}
