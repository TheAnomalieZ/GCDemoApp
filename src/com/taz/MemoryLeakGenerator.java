package com.taz;
import java.lang.reflect.Field;
import java.util.Random;
import com.taz.domain.LinkedObject;
import sun.misc.Unsafe;

import static java.lang.Thread.sleep;

/**
 * Created by K.Kokulan on 1/7/2017.
 */
public class MemoryLeakGenerator {
    public static Random rn = new Random();
    public static Stack stack = new Stack();
    public static void startAnomalous(){
        long startTime = System.currentTimeMillis();
        while(false || (System.currentTimeMillis()-startTime)<100000){

            stack.push(new byte[rn.nextInt(100) + 100000 ]);
            stack.popFixed();
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long sTime = System.currentTimeMillis();
        System.out.println("Start anomaly");
        while(false || (System.currentTimeMillis()-sTime)<10000){
            stack.push(new byte[rn.nextInt(10000) + 100000 ]);
            stack.pop();
        }
        System.gc();
        System.out.println("Start normal");

        while(true){
            stack.push(new byte[rn.nextInt(100) + 100000 ]);
            stack.popFixed();
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

   }

    public static void normal(long time){
        long sTime = System.currentTimeMillis();
        System.out.println("Start normal");
        while(false || (System.currentTimeMillis()-sTime)<time){
            stack.push(new byte[rn.nextInt(100) + 100000 ]);
            stack.popFixed();
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void anomaly(long time){
        long sTime = System.currentTimeMillis();
        System.out.println("Start anomaly");
        while(false || (System.currentTimeMillis()-sTime)<time){
            stack.push(new byte[rn.nextInt(10000) + 100000 ]);
            stack.pop();
        }
    }


    public static void startNormal(){
        while(true){
            stack.push(new byte[rn.nextInt(100) + 100000 ]);
            stack.popFixed();
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void startOutOfMemory(){

        long startTime = System.currentTimeMillis();
        while(false || (System.currentTimeMillis()-startTime)<200000){
            stack.push(new byte[rn.nextInt(100) + 100000 ]);
            stack.popFixed();
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Start out of memory error");
        LinkedObject linkedObject = null;
        while (true) {
            linkedObject = new LinkedObject(linkedObject);
            stack.push(linkedObject);
            stack.pop();
        }
    }


    public static void startAnomaly3(){
        long time;
        time= rn.nextInt(100)*1000+30000;
        normal(time);
        time= rn.nextInt(10)*1000+10000;
        anomaly(time);
        time= rn.nextInt(100)*1000+30000;
        normal(time);
        time= rn.nextInt(10)*1000+10000;
        anomaly(time);
        time= rn.nextInt(100)*1000+30000;
        normal(time);
        time= rn.nextInt(10)*1000+10000;
        anomaly(time);
        time= rn.nextInt(100)*1000+30000;
        normal(time);
        time= rn.nextInt(100)*1000+10000;
        anomaly(time);
        startNormal();
    }

    public static void callDirectMemory()
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Unsafe unsafe = getUnsafe();
        long addr = unsafe.allocateMemory(1024* 1024 * 1024 * 1024);
        System.out.println(String.format("0x%x", addr));
    }

    public static Unsafe getUnsafe()
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        return (Unsafe) field.get(null);
    }



}

