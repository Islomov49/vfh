package com.eng.iso.sharipova.Entity;

import java.util.ArrayList;

/**
 * Created by developer on 11.02.2017.
 */

public class ExerciseAnswerQuestions extends Exercise {
    private ArrayList<String> questions;

    public ExerciseAnswerQuestions(String exNumber, String condition, int type) {
        super(exNumber, condition, type);
    }

    public ExerciseAnswerQuestions(String exNumber, String condition, int type, ArrayList<String> questions) {
        super(exNumber, condition, type);
        this.questions = questions;
    }

    public ArrayList<String> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<String> questions) {
        this.questions = questions;
    }
}
