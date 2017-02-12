package com.eng.iso.sharipova.Entity;

import java.util.ArrayList;

/**
 * Created by developer on 13.02.2017.
 */

public class ExerciseWriteSentencesText extends ExerciseWriteSenrences {
    String text;

    public ExerciseWriteSentencesText(String exNumber, String condition, int type, String text) {
        super(exNumber, condition, type);
        this.text = text;
    }

    public ExerciseWriteSentencesText(String exNumber, String condition, int type, ArrayList<String> usefullTips, String text) {
        super(exNumber, condition, type, usefullTips);
        this.text = text;
    }

    public ExerciseWriteSentencesText(String exNumber, String condition, int type) {
        super(exNumber, condition, type);
    }

    public ExerciseWriteSentencesText(String exNumber, String condition, int type, ArrayList<String> usefullTips) {
        super(exNumber, condition, type, usefullTips);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
