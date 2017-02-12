package com.eng.iso.sharipova.Entity;

import java.util.ArrayList;

/**
 * Created by developer on 13.02.2017.
 */

public class ExerciseListenTextMatchKey extends Exercise {
    ArrayList<String> keyWords;
    ArrayList<String> texts;
    String audioName;
    public ExerciseListenTextMatchKey(String exNumber, String condition, int type) {
        super(exNumber, condition, type);
    }

    public ExerciseListenTextMatchKey(String exNumber, String condition, int type, ArrayList<String> keyWords, ArrayList<String> texts, String audioName) {
        super(exNumber, condition, type);
        this.keyWords = keyWords;
        this.texts = texts;
        this.audioName = audioName;
    }

    public ArrayList<String> getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(ArrayList<String> keyWords) {
        this.keyWords = keyWords;
    }

    public ArrayList<String> getTexts() {
        return texts;
    }

    public void setTexts(ArrayList<String> texts) {
        this.texts = texts;
    }

    public String getAudioName() {
        return audioName;
    }

    public void setAudioName(String audioName) {
        this.audioName = audioName;
    }
}
