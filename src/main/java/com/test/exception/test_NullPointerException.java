package com.test.exception;

public class test_NullPointerException {

    private int x = 10;
    private static Object mutex = null;

    public static void main(String[] args) {
        test_NullPointerException t = initT();

        // call null instance method
        try {
            t.foo("Hi");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        // access null object attribute
        try {
            int i = t.x;
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        // null is passed in method argument, call null instance method
        try {
            foo2(null);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        // throw null
        try {
            throw null;
        } catch (NullPointerException e){
            e.printStackTrace();
        }

        // get length of null array, call null instance method
        try {
            int[] data = null;
            int len = data.length;
        } catch (NullPointerException e){
            e.printStackTrace();
        }

        // access index value of null array
        try {
            int[] data = null;
            int len = data[2];
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        // synchronized on null object
        try {
            synchronized (mutex) {
                System.out.println("synchronized block");
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private static test_NullPointerException initT(){
        return null;
    }

    public void foo(String s) {
        System.out.println(s.toLowerCase());
    }

    public static void foo2(String s){
        System.out.println(s.toLowerCase());
    }
}
