package com.taz;

/**
 * Created by suve on 07/01/17.
 */
public class StackOverFlowErrorString {
    static class A {
        private int aValue;
        private B bInstance = null;

        public A() {
            aValue = 0;
            bInstance = new B();
        }

        @Override
        public String toString() {
            return "";
        }
    }

    static class B {
        private int bValue;
        private A aInstance = null;

        public B() {
            bValue = 10;
            aInstance = new A();
        }

        @Override
        public String toString() {
            return "";
        }
    }

    public static void start() {
        A obj = new A();
        System.out.println(obj.toString());
    }
}
