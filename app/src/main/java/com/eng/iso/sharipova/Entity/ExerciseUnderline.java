package com.eng.iso.sharipova.Entity;

import java.util.ArrayList;

/**
 * Created by developer on 11.02.2017.
 */

public class ExerciseUnderline extends Exercise {

    private ArrayList<String> words;
    private String title;
    private String text;

    public ExerciseUnderline(String exNumber, String condition,int type) {
        super(exNumber, condition,type);
    }

    public ExerciseUnderline(String exNumber, String condition, int type, ArrayList<String> words, String title, String text) {
        super(exNumber, condition,type);
        this.words = words;
        this.title = title;
        this.text = text;
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public void setWords(ArrayList<String> words) {
        this.words = words;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
