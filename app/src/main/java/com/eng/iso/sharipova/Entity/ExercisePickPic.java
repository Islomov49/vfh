package com.eng.iso.sharipova.Entity;

import java.util.ArrayList;

/**
 * Created by developer on 12.02.2017.
 */

public class ExercisePickPic extends Exercise {

    private String photoName;
    private ArrayList<String> words;


    public ExercisePickPic(String exNumber, String condition, int type) {
        super(exNumber, condition, type);
    }

    public ExercisePickPic(String exNumber, String condition, int type, String photoName, ArrayList<String> words) {
        super(exNumber, condition, type);
        this.photoName = photoName;
        this.words = words;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public void setWords(ArrayList<String> words) {
        this.words = words;
    }
}
