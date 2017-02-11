package com.eng.iso.sharipova.Entity;

import java.util.ArrayList;

/**
 * Created by developer on 12.02.2017.
 */

public class ExerciseTest4x extends Exercise {
    ArrayList<TestVariant4x> testVariants;
    ArrayList<String> questions;

    public ExerciseTest4x(String exNumber, String condition, int type, ArrayList<TestVariant4x> testVariants, ArrayList<String> questions) {
        super(exNumber, condition, type);
        this.testVariants = testVariants;
        this.questions = questions;
    }

    public ArrayList<TestVariant4x> getTestVariants() {
        return testVariants;
    }

    public void setTestVariants(ArrayList<TestVariant4x> testVariants) {
        this.testVariants = testVariants;
    }

    public ArrayList<String> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<String> questions) {
        this.questions = questions;
    }

    public ExerciseTest4x(String exNumber, String condition, int type) {
        super(exNumber, condition, type);
    }
}
