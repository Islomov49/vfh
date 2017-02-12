package com.eng.iso.sharipova.Entity;

import java.util.ArrayList;

/**
 * Created by developer on 13.02.2017.
 */

public class ExerciseAdvantagesDisadvantegs extends Exercise {

    String advantageTitle;
    String disadvantageTitle;
    String advantageText;
    String disadvantageText;
    String audioName;
    ArrayList<String> advantageKeyWords;
    ArrayList<String> disadvantageKeyWords;

    public ExerciseAdvantagesDisadvantegs(String exNumber, String condition, int type) {
        super(exNumber, condition, type);
    }

    public ExerciseAdvantagesDisadvantegs(String exNumber, String condition, int type, String advantageTitle, String disadvantageTitle, String advantageText, String disadvantageText, String audioName) {
        super(exNumber, condition, type);
        this.advantageTitle = advantageTitle;
        this.disadvantageTitle = disadvantageTitle;
        this.advantageText = advantageText;
        this.disadvantageText = disadvantageText;
        this.audioName = audioName;
    }

    public String getAdvantageTitle() {
        return advantageTitle;
    }

    public void setAdvantageTitle(String advantageTitle) {
        this.advantageTitle = advantageTitle;
    }

    public String getDisadvantageTitle() {
        return disadvantageTitle;
    }

    public void setDisadvantageTitle(String disadvantageTitle) {
        this.disadvantageTitle = disadvantageTitle;
    }

    public String getAdvantageText() {
        return advantageText;
    }

    public void setAdvantageText(String advantageText) {
        this.advantageText = advantageText;
    }

    public String getDisadvantageText() {
        return disadvantageText;
    }

    public void setDisadvantageText(String disadvantageText) {
        this.disadvantageText = disadvantageText;
    }

    public String getAudioName() {
        return audioName;
    }

    public void setAudioName(String audioName) {
        this.audioName = audioName;
    }

    public ArrayList<String> getAdvantageKeyWords() {
        return advantageKeyWords;
    }

    public void setAdvantageKeyWords(ArrayList<String> advantageKeyWords) {
        this.advantageKeyWords = advantageKeyWords;
    }

    public ArrayList<String> getDisadvantageKeyWords() {
        return disadvantageKeyWords;
    }

    public void setDisadvantageKeyWords(ArrayList<String> disadvantageKeyWords) {
        this.disadvantageKeyWords = disadvantageKeyWords;
    }
}
