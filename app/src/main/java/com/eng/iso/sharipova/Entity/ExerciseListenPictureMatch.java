package com.eng.iso.sharipova.Entity;

/**
 * Created by developer on 13.02.2017.
 */

public class ExerciseListenPictureMatch extends Exercise {

    String photoName;
    String audioName;
    int countWords;

    public ExerciseListenPictureMatch(String exNumber, String condition, int type, String photoName, String audioName, int countWords) {
        super(exNumber, condition, type);
        this.photoName = photoName;
        this.audioName = audioName;
        this.countWords = countWords;
    }

    public ExerciseListenPictureMatch(String exNumber, String condition, int type) {
        super(exNumber, condition, type);
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getAudioName() {
        return audioName;
    }

    public void setAudioName(String audioName) {
        this.audioName = audioName;
    }

    public int getCountWords() {
        return countWords;
    }

    public void setCountWords(int countWords) {
        this.countWords = countWords;
    }
}
