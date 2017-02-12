package com.eng.iso.sharipova.Entity;

import java.util.ArrayList;

/**
 * Created by developer on 13.02.2017.
 */

public class ExerciseWordsFillWriteAudio extends ExerciseFillTextWords {
    String audioName;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ExerciseWordsFillWriteAudio(String exNumber, String condition, int type, String audioName) {
        super(exNumber, condition, type);
        this.audioName = audioName;
    }
    public ExerciseWordsFillWriteAudio(String exNumber, String condition, int type) {
        super(exNumber, condition, type);
    }
    public String getAudioName() {
        return audioName;
    }

    public void setAudioName(String audioName) {
        this.audioName = audioName;
    }

    public ExerciseWordsFillWriteAudio(String exNumber, String condition, int type, String text, ArrayList<String> words, String audioName, String text1) {
        super(exNumber, condition, type, text, words);
        this.audioName = audioName;
        this.text = text1;
    }

    public ExerciseWordsFillWriteAudio(String exNumber, String condition, int type, String audioName, String text) {
        super(exNumber, condition, type);
        this.audioName = audioName;
        this.text = text;
    }

}
