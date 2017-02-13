package com.eng.iso.sharipova.Utils;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.widget.TextView;

/**
 * Created by developer on 14.02.2017.
 */

public class TextUtils {
    public static void ColorSubSeq(String text, String whichWordColor, String colorCode, TextView textView) {
        String textUpper = text.toUpperCase();
        String whichWordColorUpper = whichWordColor.toUpperCase();
        SpannableString ss = new SpannableString(text);
        int strar = 0;

        while (textUpper.indexOf(whichWordColorUpper, strar) >= 0 && whichWordColor.length() != 0) {
            ss.setSpan(new BackgroundColorSpan(Color.parseColor(colorCode)), textUpper.indexOf(whichWordColorUpper, strar), textUpper.indexOf(whichWordColorUpper, strar) + whichWordColorUpper.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            strar = textUpper.indexOf(whichWordColorUpper, strar) + whichWordColorUpper.length();
        }
        textView.setText(ss);
    }
    public static void ColorFillWords(){

    }
}
