package com.test.interview;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<String, String> map = new HashMap<>();
    public static void main(String[] args) {
        map.put("0", "零");
        map.put("1", "壹");
        map.put("10", "壹拾");
        map.put("100", "壹佰");
        map.put("1000", "壹仟");
        System.out.println(trans(111111));

        System.out.println(1111/10000);
        System.out.println(1111%10000);


    }

    public static String trans(long num){
        String str = String.valueOf(num);
        String result = "";
        long temp = 0;

        temp = num/100000000;
        System.out.println(temp);
        if(temp > 0) {
            num = num%100000000;
            result = result + lessThan4(temp) + "亿";
        }

        temp = num/10000;
        System.out.println(temp);

        if (temp > 0) {
            num = num % 10000;
            result = result + lessThan4(temp) + "万" + lessThan4(num);
        }

        return result;
    }

    public static String lessThan4(long num) {
        String str = String.valueOf(num);
        if(map.containsKey(str))
            return map.get(str);
        long t = num/str.length()^10;

        String temp = String.valueOf(t);
        System.out.println("hah" + temp);
        return map.get(temp) // 加N个0
                + lessThan4(num/10^str.length());
    }

}