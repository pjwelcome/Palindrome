package com.demo.android_development.pjwelcome.palindrome;

import android.test.suitebuilder.annotation.SmallTest;

import com.demo.android_development.pjwelcome.palindrome.Helpers.Constants;
import com.demo.android_development.pjwelcome.palindrome.Helpers.Helper;
import com.demo.android_development.pjwelcome.palindrome.Model.ViewModel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by PWelcome on 2016/01/18.
 * Palindrome
 */
@SmallTest
public class PalindromeUnitTest {

    private String textValueEmpty;
    private String palindromeText;
    private String notPalindromeText;
    private ViewModel model;

    @Before
    public void setUp() {
        textValueEmpty = Constants.EMPTY_STRING;
        palindromeText = "racecar";
        notPalindromeText = "hello";
        model = new ViewModel(palindromeText);
    }

    @Test
    public void isPalindrome() {
        assertTrue(Helper.isPalindrome(palindromeText));
    }

    @Test
    public void isNotPalindrome() {
        assertFalse(Helper.isPalindrome(notPalindromeText));
    }

    @Test
    public void emptyInputBox() {
        ViewModel emptyConstructor = new ViewModel();
        if (textValueEmpty.isEmpty())
            assertEquals(emptyConstructor.setViewsBackgroundColor(), Helper.Colors.RED);

        emptyConstructor = new ViewModel(textValueEmpty);
        if (textValueEmpty.isEmpty())
            assertEquals(emptyConstructor.setViewsBackgroundColor(), Helper.Colors.RED);
    }

    @Test
    public void palindromeInputBox() {

        if (Helper.isPalindrome(palindromeText)) {
            assertEquals(model.setViewsBackgroundColor(), Helper.Colors.BLUE);
        } else if (textValueEmpty.isEmpty()) {
            assertEquals(model.setViewsBackgroundColor(), Helper.Colors.RED);
        } else {
            assertEquals(model.setViewsBackgroundColor(), Helper.Colors.GREEN);
        }
    }
}
