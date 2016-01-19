package com.demo.android_development.pjwelcome.palindrome;

import android.test.suitebuilder.annotation.SmallTest;

import com.demo.android_development.pjwelcome.palindrome.Helpers.Constants;
import com.demo.android_development.pjwelcome.palindrome.Helpers.Helper;
import com.demo.android_development.pjwelcome.palindrome.Model.ViewModel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by PWelcome on 2016/01/19.
 * Palindrome
 */
@SmallTest
public class ViewModelTest {

    private String textValueEmpty;
    private ViewModel model;
    private String palindromeText;

    @Before
    public void setUp() {
        textValueEmpty = Constants.EMPTY_STRING;
        palindromeText = "racecar";
        model = new ViewModel(palindromeText);
    }

    @Test
    public void emptyInputBox() {
        ViewModel emptyConstructor = new ViewModel();
        if (textValueEmpty.isEmpty())
            assertEquals(emptyConstructor.getViewsBackgroundColor(), Helper.Colors.RED);

        emptyConstructor = new ViewModel(textValueEmpty);
        if (textValueEmpty.isEmpty())
            assertEquals(emptyConstructor.getViewsBackgroundColor(), Helper.Colors.RED);
    }

    @Test
    public void palindromeInputBox() {

        if (Helper.isPalindrome(palindromeText)) {
            assertEquals(model.getViewsBackgroundColor(), Helper.Colors.BLUE);
        } else if (textValueEmpty.isEmpty()) {
            assertEquals(model.getViewsBackgroundColor(), Helper.Colors.RED);
        } else {
            assertEquals(model.getViewsBackgroundColor(), Helper.Colors.GREEN);
        }
    }
}
