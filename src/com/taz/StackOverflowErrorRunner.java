package com.taz;

import com.taz.domain.LinkedObject;

/**
 * Created by  Maninesan on 12/06/16.
 */
public class StackOverflowErrorRunner {
    public static void start(){
        LinkedObject linkedObject = null;
        for (int i = 0; i < 50000; i++) {
            linkedObject = new LinkedObject(linkedObject);
        }

        System.out.println(linkedObject);
    }
}
