package com.test.interview;

public class IsMatch {
    public static void main(String[] args){
        System.out.println(isMatch("aa","*"));
    }

    public static boolean isMatch(String s, String p){
        if (p.length() == 0)
            return s.length() == 0;

        if (p.length() > 1 && p.charAt(1) == '*') {
            if (isMatch(s, p.substring(2)))
                return true;
            if (s.length() > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0)))
                return isMatch(s.substring(1), p);
            return false;
        } else {
            if (s.length() > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0)))
                return isMatch(s.substring(1), p.substring(1));
            return false;
        }
    }
}
