package com.taz;
import java.util.Random;
import com.taz.domain.LinkedObject;

import static java.lang.Thread.sleep;

/**
 * Created by K.Kokulan on 1/7/2017.
 */
public class MemoryLeakGenerator {

    public static void startAnomalous(){
        Stack stack = new Stack();
        Random rn = new Random();

        long startTime = System.currentTimeMillis();
        while(false || (System.currentTimeMillis()-startTime)<200000){

            stack.push(new byte[rn.nextInt(1000) + 1000]);
            stack.popFixed();
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        startTime = System.currentTimeMillis();
//        while(false || (System.currentTimeMillis()-startTime)<240000){
        while(false || (System.currentTimeMillis()-startTime)<60000){
            stack.push(new byte[rn.nextInt(1000) + 10000000]);
            stack.pop();
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    while(true){
        stack.push(new byte[rn.nextInt(1000) + 1000]);
        stack.popFixed();
        try {
            sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//        OutOfMemoryHeapSpaceRunner.start();

    }

    public static void startNormal(){
        Random rn = new Random();
        Stack stack = new Stack();
        while(true){

            stack.push(new byte[rn.nextInt(1000) + 1000]);
            stack.popFixed();
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
