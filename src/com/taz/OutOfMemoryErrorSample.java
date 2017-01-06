package com.taz;

import com.taz.domain.LinkedObject;

/**
 * Created by suve on 07/01/17.
 */
public class OutOfMemoryErrorSample {
    public static void start() {
        LinkedObject linkedObject = null;
        int count = 0;
        while (true) {
            count++;
            if(count % 50000 == 0){
                try{
                    Thread.sleep(100);
                    System.out.println("Thread Sleep");
                }catch (Exception e){

                }
            }
            linkedObject = new LinkedObject(linkedObject);
        }
    }
}
