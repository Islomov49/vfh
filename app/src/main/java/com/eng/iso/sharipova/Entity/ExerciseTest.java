package com.eng.iso.sharipova.Entity;

import java.util.ArrayList;

/**
 * Created by developer on 12.02.2017.
 */

public class ExerciseTest extends Exercise {
    ArrayList<TestVariant> testVariants;
    ArrayList<String> questions;

    public ExerciseTest(String exNumber, String condition, int type, ArrayList<TestVariant> testVariants, ArrayList<String> questions) {
        super(exNumber, condition, type);
        this.testVariants = testVariants;
        this.questions = questions;
    }

    public ArrayList<TestVariant> getTestVariants() {
        return testVariants;
    }

    public void setTestVariants(ArrayList<TestVariant> testVariants) {
        this.testVariants = testVariants;
    }

    public ArrayList<String> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<String> questions) {
        this.questions = questions;
    }

    public ExerciseTest(String exNumber, String condition, int type) {
        super(exNumber, condition, type);
    }
}
