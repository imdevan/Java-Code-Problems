package com.company;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Devan on 3/30/2015.
 * @summary Layout s basically a height x width matrix of booleans
 */
public class Layout {
    Boolean [][] space;
    ArrayList<Rect> rFit;
    int height, width, area, spaceRemaining;
    HashMap<Pos, Rect> notFilled;

    /**
     * Constructor
     */
    public Layout(int height, int width){
        this.space = new Boolean[height][width];
        this.height = height;
        this.width = width;
        this.area = height * width;
        this.spaceRemaining = height * width;
        this.rFit = new ArrayList<Rect>();

        /**
         * Initiate not filled with a rectangle at 0,0
         */
        this.notFilled = new HashMap<Pos, Rect>();
        this.notFilled.put(new Pos(0, 0), new Rect(height, width));
    }

    /**
     * @summary Checks if rectangle r will fit in layout.
     *          Go through notFilled to check if r will fit
     * @param r
     * @return
     */
    public boolean willFit(Rect r){

        for(Pos p : notFilled.keySet()){
            Rect rectNF = notFilled.get(p);
            if(Rect.smaller(rectNF, r)){
                return true;
            } else{
                return false;
            }
        }

        /**
         * Throw an exception, because we shouldn't get this far
         */
        return false;
    }

    /**
     * @summary Fill space in layout
     * @param r
     */
    public void place(Rect r){
        // Go to place where r will fit
        // Set those paces to false
        // remove pos from notfilled
        // add new smaller rect to notfilled
    }

    /**
     * @summary Fill layout with array of rects using First Fit Decreasing
     * @param rArray
     */
    public void placeArray(Rect[] rArray){

        // If there is no remaining space
        if(spaceRemaining == 0)
            return;

        // Sort rArray by area
        // TODO: not sure if this is the most effecient algo
        Rect.sortByArea(rArray);

        /**
         * Iterate across the array starting with the largest
         * place all rectangles that ill fit in rFit
         */
        for(Rect r : rArray){
            if(willFit(r)){
                place(r);
                rFit.add(r);
            }
        }
    }
}
