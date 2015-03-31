package com.company;

public class Main {

    public static void swap(Object[] array, int s1, int s2)
    {
        Object t = array[s1];
        array[s1] = array[s2];
        array[s2] = t;
    }

    public static String reverseString(String s)
    {
        // Do nothing if string is less than 2 characters
        if(s.length() <= 1)
            return s;

        // Convert string to array
        String [] sa = s.split(" ");


        // Iterate across String & swap
        for(int i = 0; i < sa.length/2; i++ )
            swap(sa, i, sa.length - 1 - i);

        // Generate return string
        String rt = "";
        for(int i = 0; i < sa.length; i++)
        {
            // Remove additional whitespace
            if(sa[i].equals("") && (i < sa.length-1 && sa[i+1].equals("")))
            {
                i++;
                continue;
            }

            // Add word to string
            rt += sa[i];

            // If not at the end -> Add space to string
            if(i != sa.length-1)
                rt += " ";
        }


        return rt;
    }
    public static void main(String[] args) {
        // Test String
        String test = "Hi,             I am a test           string and I love you               ";

        // Call function to reverse string
        String rt = reverseString(test);

        // Print Result
        System.out.println(rt);
    }
}
