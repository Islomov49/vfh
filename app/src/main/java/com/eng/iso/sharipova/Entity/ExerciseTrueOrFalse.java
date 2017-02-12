package com.eng.iso.sharipova.Entity;

import java.util.ArrayList;

/**
 * Created by developer on 13.02.2017.
 */

public class ExerciseTrueOrFalse extends Exercise {
    ArrayList<String> sentence;

    public ExerciseTrueOrFalse(String exNumber, String condition, int type, ArrayList<String> sentence) {
        super(exNumber, condition, type);
        this.sentence = sentence;
    }

    public ArrayList<String> getSentence() {
        return sentence;
    }

    public void setSentence(ArrayList<String> sentence) {
        this.sentence = sentence;
    }

    public ExerciseTrueOrFalse(String exNumber, String condition, int type) {
        super(exNumber, condition, type);
    }
}
