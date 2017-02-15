package com.eng.iso.sharipova.Utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;

/**
 * Created by developer on 16.02.2017.
 */

public class EditTextState extends android.support.v7.widget.AppCompatEditText {
    SharedPreferences sharedPreferences;
    int lesson, exercise;
    String key;
    public EditTextState(Context context) {
        super(context);
        Log.d("testtt", "EditTextState: 1");
    }

    public EditTextState(Context context, AttributeSet attrs) {
        super(context, attrs);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        Log.d("testtt", "EditTextState: 2");

    }
    public void initStateLisner(int lesson,int exercise,int idintifie){
        this.lesson= lesson;
        this.exercise= exercise;
        key = Integer.toString(lesson) + "-"+Integer.toString(exercise)+ "-"+Integer.toString(idintifie);
        if(!sharedPreferences.getString(key,"").equals(""))
        this.setText(sharedPreferences.getString(key,""));
        this.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                sharedPreferences.edit().putString(key,EditTextState.this.getText().toString()).apply();
            }
        });
    }
    public EditTextState(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.d("testtt", "EditTextState: 2");
    }

    @Override
    public void addTextChangedListener(TextWatcher watcher) {
        super.addTextChangedListener(watcher);
    }
}
