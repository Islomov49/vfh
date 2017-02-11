package com.eng.iso.sharipova.Entity;

import java.util.ArrayList;

/**
 * Created by developer on 12.02.2017.
 */

public class ExerciseRearrange extends Exercise {

    ArrayList<String> rewords;

    public ExerciseRearrange(String exNumber, String condition, int type) {
        super(exNumber, condition, type);
    }

    public ExerciseRearrange(String exNumber, String condition, int type, ArrayList<String> rewords) {
        super(exNumber, condition, type);
        this.rewords = rewords;
    }

    public ArrayList<String> getRewords() {
        return rewords;
    }

    public void setRewords(ArrayList<String> rewords) {
        this.rewords = rewords;
    }
}
