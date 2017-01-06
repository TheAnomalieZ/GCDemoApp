package com.taz;

import com.taz.domain.LinkedObject;

/**
 * Created by K.Kokulan on 1/7/2017.
 */
public class MemoryLeakGenerator {

    public static void startAnomalous(){
        Stack stack = new Stack();
        long startTime = System.currentTimeMillis();
        while(false || (System.currentTimeMillis()-startTime)<60000){
            stack.push(new byte[1024*1024]);
            stack.popFixed();
        }
        while(true){
            stack.push(new byte[1024*1024]);
            stack.pop();
        }
    }

    public static void startNormal(){
        Stack stack = new Stack();
        while(true){
            stack.push(new byte[1024*1024*100]);
            stack.popFixed();
        }
    }

}
