package com.test.interview;

import java.util.HashMap;
import java.util.Map;

public class Round1 {

    static Map<String, String> map = new HashMap();
    public static void main(String[] args) {
        map.put("cc","18");
        map.put("bb","16");
        map.put("aa","14");
        map.put("61","7");
        map.put("41","5");
        map.put("30","3");
        map.put("31","4");
        map.put("20","2");
        map.put("10","1");

        System.out.println("Hello World!");
        String A = "123abc";
        String B = "abc";
        System.out.println(add(A,B,'0'));
    }

    public static String add(String strA, String strB, char c){
        if(strA.length() == 0 && strB.length() == 0) return "";
        if(strA.length() == 0) strA = "0";
        if(strB.length() == 0) strB = "0";

        char tempA = strA.charAt(strA.length()-1);
        char tempB = strB.charAt(strB.length()-1);

        String newStrA = strA.substring(0, strA.length() - 1);
        String newStrB = strB.substring(0, strB.length() - 1);

        String value = addThreeChar(tempA,tempB,c);
        char newC, result;
        if(value.length() == 1){
            newC = '0';
        }else{
            newC = '1';
        }
        result = value.charAt(value.length()-1);

        return add(newStrA, newStrB, newC) + result;
    }

    public static String addThreeChar(char a, char b, char c){
        // System.out.println(a + ", " + b + ", " + c);
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append(b);
        System.out.println(sb.toString());
        String result = map.get(sb.toString());
        // System.out.println(result);
        if(c == '1'){
            if(result.length() == 1){
                System.out.println(result+'1');
                result = map.get(result+'1');
            } else {
                System.out.println(result.substring(1)+'1');
                result = result.substring(0,1)
                        + map.get(result.substring(1)+'1');
            }
        }

        // System.out.println(result);
        return result;
    }

}
