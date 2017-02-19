package com.eng.iso.sharipova.Entity;

/**
 * Created by developer on 13.02.2017.
 */

public class ExerciseVocabulOwn extends Exercise {
    String photoName = "";
    public ExerciseVocabulOwn(String exNumber, String condition, int type) {
        super(exNumber, condition, type);
    }

    public ExerciseVocabulOwn(String exNumber, String condition, int type, String photoName) {
        super(exNumber, condition, type);
        this.photoName = photoName;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }
}
