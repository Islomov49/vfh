package com.eng.iso.sharipova.Entity;

import java.util.ArrayList;

/**
 * Created by developer on 13.02.2017.
 */

public class ExerciseSynonyms extends Exercise {
    ArrayList<String> words;

    public ExerciseSynonyms(String exNumber, String condition, int type) {
        super(exNumber, condition, type);
    }

    public ExerciseSynonyms(String exNumber, String condition, int type, ArrayList<String> words) {
        super(exNumber, condition, type);
        this.words = words;
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public void setWords(ArrayList<String> words) {
        this.words = words;
    }
}
