package com.eng.iso.sharipova.Utils;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.widget.TextView;

import com.eng.iso.sharipova.Entity.IntervalsTwoPair;
import com.eng.iso.sharipova.R;

import java.util.ArrayList;

/**
 * Created by developer on 14.02.2017.
 */

public class TextUtils {
    public static void ColorSubSeq(String text, String whichWordColor, TextView textView , Context context) {
        String textUpper = text.toUpperCase();
        String whichWordColorUpper = whichWordColor.toUpperCase();
        SpannableString ss = new SpannableString(text);
        int strar = 0;

        while (textUpper.indexOf(whichWordColorUpper, strar) >= 0 && whichWordColor.length() != 0) {
            ss.setSpan(new BackgroundColorSpan(ContextCompat.getColor(context, R.color.selected_green)), textUpper.indexOf(whichWordColorUpper, strar), textUpper.indexOf(whichWordColorUpper, strar) + whichWordColorUpper.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            strar = textUpper.indexOf(whichWordColorUpper, strar) + whichWordColorUpper.length();
        }
        textView.setText(ss);
    }
    public static void ColorFillWords(ArrayList<IntervalsTwoPair> intervalsTwoPairs, String text, TextView textView, IntervalsTwoPair incorectWord, Context context){
        SpannableString ss = new SpannableString(text);
        for (IntervalsTwoPair intervalsTwoPair:intervalsTwoPairs){
            ss.setSpan(new BackgroundColorSpan(ContextCompat.getColor(context, R.color.selected_green)), intervalsTwoPair.getStartPosition(), intervalsTwoPair.getEndPosition(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        if(incorectWord!=null){
            ss.setSpan(new BackgroundColorSpan(ContextCompat.getColor(context, R.color.selected_red
            )), incorectWord.getStartPosition(), incorectWord  .getEndPosition(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        textView.setText(ss);
    }
    public static void ColorFillWordsForFillGaps(ArrayList<IntervalsTwoPair> intervalsTwoPairs, String text, TextView textView, Context context){
        SpannableString ss = new SpannableString(text);
        for (IntervalsTwoPair intervalsTwoPair:intervalsTwoPairs){
            if(intervalsTwoPair.getWord().equals(""))
                ss.setSpan(new BackgroundColorSpan(ContextCompat.getColor(context, R.color.seriy)), intervalsTwoPair.getStartPosition(), intervalsTwoPair.getEndPosition(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            else
                ss.setSpan(new BackgroundColorSpan(ContextCompat.getColor(context, R.color.yellow)), intervalsTwoPair.getStartPosition(), intervalsTwoPair.getEndPosition(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        textView.setText(ss);
    }
}
