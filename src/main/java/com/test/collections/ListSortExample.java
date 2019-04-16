package com.test.collections;

import java.util.*;

public class ListSortExample {

    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<Integer>();
        Random random = new Random();
        for (int i=0; i<10; i++) ints.add(random.nextInt(1000));

        // lambda expression is not supported in language level 5
        // ints.sort((o1,o2) -> {return (o2-o1);});
        System.out.println("reverse sorting: " + ints);


        Collections.sort(ints);
        System.out.println("natural sorting: " + ints);

    }
}
