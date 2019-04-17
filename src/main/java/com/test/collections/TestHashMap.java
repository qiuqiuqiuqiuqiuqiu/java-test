package com.test.collections;

import java.util.*;

public class TestHashMap {
    public static void main(String[] args) {
        /**
         * 程序输出
         * StudentC: 140
         * StudentA: 100
         * StudentB: 90
         */

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("StudentA", 100);
        map.put("StudentB", 90);
        map.put("StudentC", 140);

        // 将map.entrySet()转换成list
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());

        // 通过比较器来实现排序
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        map.forEach((k, v) -> System.out.println(k + ": " + v));
        Arrays.asList("你好", "简单教程", "简单编程").forEach(System.out::println);
        Arrays.asList("你好", "简单教程", "简单编程").forEach(v -> System.out.println(v));
    }
}