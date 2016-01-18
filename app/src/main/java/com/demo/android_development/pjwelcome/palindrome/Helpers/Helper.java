package com.demo.android_development.pjwelcome.palindrome.Helpers;

/**
 * Created by PWelcome on 2016/01/18.
 * Palindrome
 */
public class Helper {

    public static boolean isPalindrome(String text) {
        String reverse = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            reverse += text.charAt(i);
        }
        return text.equals(reverse);
    }

    public enum Colors {
        BLUE,
        GREEN,
        RED
    }
}
