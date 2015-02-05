package com.company;
// Write a program to determine whether an input string x is a substring of another 
/// input string y.  (For example, "bat" is a substring of "abate", but not of "beat".)  You 
//        may use any language you like.

public class Main {

    public static boolean isSubstring(String s1, String s2){
        // s1 is sub of s2?
        char[] sa = s1.toCharArray();
        char[] sb = s2.toCharArray();
        boolean isSubstring = false;

        for(int i = 0; i < sb.length; i++){
            if(sb[i] == sa[0]) {
                for (int j = 0; j < sa.length; j++) {
                    if(sb[i+j] != sa[j]) {
                        isSubstring = false;
                        break;
                    }else{
                        isSubstring = true;
                    }
                }
                if(isSubstring)
                    break;
            }
        }

        // Not a substring
        return isSubstring;
    }
    public static void main(String[] args) {
	// write your code here
        System.out.print(isSubstring("bat", "abatesdfbfate"));
    }
}
