package com.eng.iso.sharipova.Entity;

import java.util.ArrayList;

/**
 * Created by developer on 12.02.2017.
 */

public class ExerciseWordsFillWrite extends Exercise {
    ArrayList<String> words;
    ArrayList<String> gaps;

    public ExerciseWordsFillWrite(String exNumber, String condition, int type) {
        super(exNumber, condition, type);
    }

    public ExerciseWordsFillWrite(String exNumber, String condition, int type, ArrayList<String> words, ArrayList<String> gaps) {
        super(exNumber, condition, type);
        this.words = words;
        this.gaps = gaps;
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public void setWords(ArrayList<String> words) {
        this.words = words;
    }

    public ArrayList<String> getGaps() {
        return gaps;
    }

    public void setGaps(ArrayList<String> gaps) {
        this.gaps = gaps;
    }
}
