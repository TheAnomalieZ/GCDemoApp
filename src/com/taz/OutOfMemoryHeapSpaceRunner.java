package com.taz;

import com.taz.domain.LinkedObject;

/**
 * Created by  Maninesan on 12/06/16.
 */
public class OutOfMemoryHeapSpaceRunner {
    public static void start(){
        LinkedObject linkedObject = null;
        while (true) {
            linkedObject = new LinkedObject(linkedObject);
        }
    }
}
