package com.company;

public class Main extends Thread{

    public static void sop(String s){System.out.println(s);}


    public static void main(String[] args) {
	// write your code here

        Thread t = new Thread();
        sop("Before thread start");
        t.start();
        sop("After thread start");
    }
}
