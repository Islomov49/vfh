package com.eng.iso.sharipova.Entity;

import java.util.ArrayList;

/**
 * Created by developer on 13.02.2017.
 */

public class ExerciseFillTextWords extends  Exercise{
    String text;
    ArrayList<String> words;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public void setWords(ArrayList<String> words) {
        this.words = words;
    }

    public ExerciseFillTextWords(String exNumber, String condition, int type, String text, ArrayList<String> words) {
        super(exNumber, condition, type);
        this.text = text;
        this.words = words;
    }

    public ExerciseFillTextWords(String exNumber, String condition, int type) {
        super(exNumber, condition, type);
    }
}
