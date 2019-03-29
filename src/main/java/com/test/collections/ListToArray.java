package com.test.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListToArray {

    public static void main(String[] args) {
        List<String> letters = new ArrayList<>();

        letters.add("A");
        letters.add("B");
        letters.add("C");

        String[] strArray = new String[letters.size()];
        strArray = letters.toArray(strArray);
        System.out.println(Arrays.toString(strArray));
    }
}
