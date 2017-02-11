package com.eng.iso.sharipova.Entity;

import java.util.ArrayList;

/**
 * Created by developer on 12.02.2017.
 */

public class ExerciseComWordsFillWrite extends Exercise {
    ArrayList<String> words;
    ArrayList<String> gaps;
    String photoName;
    int countPick;

    public ExerciseComWordsFillWrite(String exNumber, String condition, int type) {
        super(exNumber, condition, type);
    }

    public ExerciseComWordsFillWrite(String exNumber, String condition, int type, ArrayList<String> words, ArrayList<String> gaps, String photoName, int countPick) {
        super(exNumber, condition, type);
        this.words = words;
        this.gaps = gaps;
        this.photoName = photoName;
        this.countPick = countPick;
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

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public int getCountPick() {
        return countPick;
    }

    public void setCountPick(int countPick) {
        this.countPick = countPick;
    }
}
