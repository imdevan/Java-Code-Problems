package com.company;

public class Main {

    public static void main(String[] args) {
        String s = "test string";
        String rs = reverseString(s);

        System.out.println(rs);
    }

    private static String reverseString(String s) {
        // String builder to manipulate strings
        StringBuilder sb = new StringBuilder();
        sb.append(s);

        // Reverse all characters in string
        for(int i = 0; i < sb.length()/2; i++){
            int ri = sb.length()-1-i;
            // Swap characters in sb
            swapChar(sb, i, ri);
        }

        // Variables to track
        int ws = 0, we = 0;

        // Reverse each character in each word of the string
        for(int i = 0; i < sb.length(); i++){

            // Reached the end of the word
            if(sb.charAt(i) == ' '){

                // Set end of word to index before the space
                we = i - 1;

                // ignore all other spaces
                while(sb.charAt(i+1) == ' '){
                    sb.deleteCharAt(i+1);
                }

                // Reverse word
                reverseSubstring(sb, ws, we);

                // Set start of word to space after space
                ws = i+1;
            }

            // End of string
            if(i == sb.length() - 1){
                // Word ends at i
                we = i;
                // Reverse word
                reverseSubstring(sb, ws, we);
            }
        }

        // Return string builder as string
        return sb.toString();
    }

    /**
     * Reverse substring within a string builder
     * @param sb
     * @param ws
     * @param we
     */
    private static void reverseSubstring(StringBuilder sb, int ws, int we) {
        int mid = (we - ws)/2 + ws;
        int backwordsCounter = we;
        for(int j = ws; j <= mid; j++){
            swapChar(sb, j, backwordsCounter--);
        }

    }

    private static void swapChar(StringBuilder sb, int i, int ri) {
        char c = sb.charAt(ri);
        sb.setCharAt(ri, sb.charAt(i));
        sb.setCharAt(i, c);
    }


}
