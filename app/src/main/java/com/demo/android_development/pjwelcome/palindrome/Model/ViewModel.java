package com.demo.android_development.pjwelcome.palindrome.Model;

import com.demo.android_development.pjwelcome.palindrome.Helpers.Constants;
import com.demo.android_development.pjwelcome.palindrome.Helpers.Helper;

/**
 * Created by PWelcome on 2016/01/18.
 * Palindrome
 */
public class ViewModel {

    private String inputText;

    public ViewModel() {
        inputText = Constants.EMPTY_STRING;
    }

    public ViewModel(String inputText) {
        this.inputText = inputText;
    }

    public String getInputText() {
        return inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }

    public Helper.Colors getViewsBackgroundColor() {
        if (inputText.isEmpty()) {
            return Helper.Colors.RED;
        } else if (Helper.isPalindrome(inputText)) {
            return Helper.Colors.BLUE;
        } else {
            return Helper.Colors.GREEN;
        }
    }


}
