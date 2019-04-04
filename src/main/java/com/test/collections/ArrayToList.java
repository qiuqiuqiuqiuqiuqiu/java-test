package com.test.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayToList {
    
    public static void main(String[] args) {
        String[] vowels = {"a", "e", "i", "o", "u"};

        List<String> vowelsList = Arrays.asList(vowels);
        System.out.println(vowelsList);

        List<String> myList = new ArrayList<>();
        for(String s : vowels) {
            myList.add(s);
        }
        System.out.println(myList);
        myList.clear();
    }
}
