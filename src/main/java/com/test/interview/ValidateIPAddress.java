package com.test.interview;

public class ValidateIPAddress {
    public static void main(String[] args) {
        System.out.println(validIPAddress(".127.0.0.1."));
    }

    public static String validIPAddress(String IP) {
        if (validIPv4(IP)) {
            return "IPv4";
        } else if (validIPv6(IP)) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }

    public static boolean validIPv4(String IP) {
        if(IP.indexOf(".") > 0 && !IP.startsWith(".") && !IP.endsWith(".")) {
            String[] parts = IP.split("\\.");
            if (parts.length == 4) {
                for (String p : parts) {
                    for (char c : p.toCharArray())
                        if(!Character.isDigit(c))
                            return false;
                    if (p.length() == 0 || p.length() > 3 || (p.charAt(0) == '0' && p.length() > 1) || Integer.valueOf(p) >= 256)
                        return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    public static boolean validIPv6(String IP) {
        if(IP.indexOf(":") > 0 && !IP.startsWith(":") && !IP.endsWith(":")) {
            String[] parts = IP.split(":");
            if (parts.length == 8) {
                for (String p : parts) {
                    System.out.println(p);
                    for (char c : p.toCharArray())
                        if((!Character.isDigit(c) && !Character.isLetter(c)) || (c >= 'G' && c <= 'Z') || (c >= 'g' && c <= 'z'))
                            return false;
                    if (p.length() == 0 || p.length() > 4)
                        return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }
}
