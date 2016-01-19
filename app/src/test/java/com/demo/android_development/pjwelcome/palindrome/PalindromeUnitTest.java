package com.demo.android_development.pjwelcome.palindrome;

import android.test.suitebuilder.annotation.SmallTest;

import com.demo.android_development.pjwelcome.palindrome.Helpers.Helper;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by PWelcome on 2016/01/18.
 * Palindrome
 */
@SmallTest
public class PalindromeUnitTest {

    private String palindromeText;
    private String notPalindromeText;

    @Before
    public void setUp() {
        palindromeText = "racecar";
        notPalindromeText = "hello";
    }

    @Test
    public void isPalindrome() {
        assertTrue(Helper.isPalindrome(palindromeText));
    }

    @Test
    public void isNotPalindrome() {
        assertFalse(Helper.isPalindrome(notPalindromeText));
    }


}
