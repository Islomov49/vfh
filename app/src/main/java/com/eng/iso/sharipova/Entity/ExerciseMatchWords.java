package com.eng.iso.sharipova.Entity;

import java.util.ArrayList;

/**
 * Created by developer on 13.02.2017.
 */

public class ExerciseMatchWords extends Exercise{
    ArrayList<String> firstCollumb;
    ArrayList<String> secondCollumb;

    public ExerciseMatchWords(String exNumber, String condition, int type) {
        super(exNumber, condition, type);
    }

    public ExerciseMatchWords(String exNumber, String condition, int type, ArrayList<String> firstCollumb, ArrayList<String> secondCollumb) {
        super(exNumber, condition, type);
        this.firstCollumb = firstCollumb;
        this.secondCollumb = secondCollumb;
    }

    public ArrayList<String> getFirstCollumb() {
        return firstCollumb;
    }

    public void setFirstCollumb(ArrayList<String> firstCollumb) {
        this.firstCollumb = firstCollumb;
    }

    public ArrayList<String> getSecondCollumb() {
        return secondCollumb;
    }

    public void setSecondCollumb(ArrayList<String> secondCollumb) {
        this.secondCollumb = secondCollumb;
    }
}
