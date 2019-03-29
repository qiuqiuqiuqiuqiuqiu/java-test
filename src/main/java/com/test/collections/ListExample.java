package com.test.collections;

import java.util.ArrayList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        List<String> vowels = new ArrayList<>();

        vowels.add("A");
        vowels.add("I");
        vowels.add(1, "E");
        System.out.println(vowels);

        List<String> list = new ArrayList<>();
        list.add("O"); list.add("U");

        vowels.addAll(list);
        System.out.println(vowels);
        list.clear();

        System.out.println("letters list size = " + vowels.size());
        vowels.set(2, "E");
        vowels.clear();
    }
}
