package com.eng.iso.sharipova.Entity;

import java.util.ArrayList;

/**
 * Created by developer on 13.02.2017.
 */

public class ExerciseTwoDefferientThink extends Exercise {
    ArrayList<String> words;
    String firstType;
    String seceondType;

    public ExerciseTwoDefferientThink(String exNumber, String condition, int type) {
        super(exNumber, condition, type);
    }

    public ExerciseTwoDefferientThink(String exNumber, String condition, int type, ArrayList<String> words, String firstType, String seceondType) {
        super(exNumber, condition, type);
        this.words = words;
        this.firstType = firstType;
        this.seceondType = seceondType;
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public void setWords(ArrayList<String> words) {
        this.words = words;
    }

    public String getFirstType() {
        return firstType;
    }

    public void setFirstType(String firstType) {
        this.firstType = firstType;
    }

    public String getSeceondType() {
        return seceondType;
    }

    public void setSeceondType(String seceondType) {
        this.seceondType = seceondType;
    }
}
