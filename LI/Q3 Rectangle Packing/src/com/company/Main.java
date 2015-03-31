package com.company;

public class Main {

    public static void main(String[] args) {

        /* Test objects */
        Layout testLayout = new Layout (10, 10);
        Rect [] testRectArray = {new Rect(1,1)};

        /* Test Rect Fit Function */
        testLayout.placeArray(testRectArray);

        /* Print results */
        System.out.printf("Test Layout: %dx%d- %d \n", testLayout.height, testLayout.width, testLayout.area);
        System.out.printf("Space remaining: %d", testLayout.spaceRemaining);

    }
}
