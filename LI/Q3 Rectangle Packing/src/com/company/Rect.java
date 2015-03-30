package com.company;

/**
 * Created by Devan on 3/17/2015.
 */
public class Rect {
    int height, width, area;

    public Rect(int height, int width){
        this.height = height;
        this.width = width;
        area = height * width;
    }

    public void rotate(){
        int temp = height;
        height = width;
        width = temp;
    }

    /**
     * @param ra
     * @param rb
     * @return true if ra < rb
     */
    public static boolean smaller(Rect ra,  Rect rb){
        // Fits one way
        if(ra.height <= rb.height && ra.width <= rb.width){
            return true;
        } else{
            // Will ra fit if it's rotated?
            ra.rotate();
            if(ra.height <= rb.height && ra.width <= rb.width){
                return true;
            }
        }

        // Rectangle is not smaller
        return false;
    }

    /**
     * @summary sort Rect array by area
     * @param rArray
     */
    public static void sortByArea(Rect[] rArray){
        /* TODO: sort by area */
    }


}
