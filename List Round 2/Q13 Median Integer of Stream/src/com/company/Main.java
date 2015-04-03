package com.company;

public class Main {

    public static void main(String[] args) {
        MedianStreamHolder msh = new MedianStreamHolder();
        msh.add(5);
        msh.add(4);
        msh.add(6);
        msh.add(3);
        msh.add(4);
        msh.add(6);
        msh.add(10);

        System.out.print(msh.median);
    }
}
