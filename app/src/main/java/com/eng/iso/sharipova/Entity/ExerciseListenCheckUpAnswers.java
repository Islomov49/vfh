package com.eng.iso.sharipova.Entity;

/**
 * Created by developer on 13.02.2017.
 */

public class ExerciseListenCheckUpAnswers extends Exercise {
    String audioName;

    public ExerciseListenCheckUpAnswers(String exNumber, String condition, int type, String audioName) {
        super(exNumber, condition, type);
        this.audioName = audioName;
    }

    public String getAudioName() {
        return audioName;
    }

    public void setAudioName(String audioName) {
        this.audioName = audioName;
    }

    public ExerciseListenCheckUpAnswers(String exNumber, String condition, int type) {
        super(exNumber, condition, type);
    }
}
