package com.demo.android_development.pjwelcome.palindrome;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.widget.RelativeLayout;

import com.demo.android_development.pjwelcome.palindrome.Helpers.Constants;
import com.demo.android_development.pjwelcome.palindrome.Helpers.Helper;
import com.demo.android_development.pjwelcome.palindrome.Model.ViewModel;

public class MainActivity extends AppCompatActivity {

    private AppCompatTextView displayTextView;
    private AppCompatEditText inputBox;
    private RelativeLayout parentView;
    private ViewModel model;
    private boolean appStarting = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initViewModel();
        receivePalindrome();
        appStarting = true;
    }

    private void initViewModel() {
        model = new ViewModel(inputBox.getText().toString());
    }

    private void initViews() {
        parentView = (RelativeLayout) findViewById(R.id.parentView);
        displayTextView = (AppCompatTextView) findViewById(R.id.display_TextView);
        inputBox = (AppCompatEditText) findViewById(R.id.inputBox_text);
    }

    @Override
    protected void onPause() {
        super.onPause();
        appStarting = false;
        savingPalindrome(inputBox.getText().toString());
    }

    private void savingPalindrome(String text) {
        SharedPreferences mPrefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        prefsEditor.putString(getString(R.string.palindrome_String), text);
        prefsEditor.commit();
    }


    private void receivePalindrome() {
        SharedPreferences mPrefs = getPreferences(MODE_PRIVATE);
        displayTextView.setText(inputBox.getText());
        displayTextView.setText(mPrefs.getString(getString(R.string.palindrome_String), Constants.EMPTY_STRING));
        model.setInputText(mPrefs.getString(getString(R.string.palindrome_String), Constants.EMPTY_STRING));
        setBackgroundColor(model.setViewsBackgroundColor());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        savingPalindrome(inputBox.getText().toString());
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!appStarting)
            checkTextView();
    }

    private void checkTextView() {
        model.setInputText(inputBox.getText().toString());
        setBackgroundColor(model.setViewsBackgroundColor());
        displayTextView.setText(model.getInputText());
    }

    private void setBackgroundColor(Helper.Colors color) {
        if (color.equals(Helper.Colors.BLUE))
            parentView.setBackgroundColor(getResources().getColor(R.color.blue));
        else if (color.equals(Helper.Colors.RED))
            parentView.setBackgroundColor(getResources().getColor(R.color.red));
        else
            parentView.setBackgroundColor(getResources().getColor(R.color.green));
    }
}
