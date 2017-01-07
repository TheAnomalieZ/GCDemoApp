package com.taz;

/**
 * Created by suve on 06/01/17.
 */
public class StackOverFlowErrorSample {
    public static void recursivePrint(int num) {
        System.out.println("Number: " + num);
        if(num == 0)
            return;
        else
            recursivePrint(++num);
    }

    public static void start() {
        StackOverFlowErrorSample.recursivePrint(1);
    }
}
