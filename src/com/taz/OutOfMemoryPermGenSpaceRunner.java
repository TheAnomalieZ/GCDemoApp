package com.taz;
/**
 * Created by  Maninesan on 12/06/16.
 */
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryPermGenSpaceRunner {
    public static void start() throws MalformedURLException, ClassNotFoundException {
        List<Class> bigPermGenObjectList = new ArrayList<Class>();

        while (true) {
            ClassLoader classLoader = new URLClassLoader(new URL[]{new URL("file:memory-management.jar")}, null);
            Class bigPermGenObjectClass = classLoader.loadClass("com.epam.ganiaev.domain.BigPermGenObject");

            bigPermGenObjectList.add(bigPermGenObjectClass);
        }
    }
}
