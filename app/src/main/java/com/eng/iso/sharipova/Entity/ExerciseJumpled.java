package com.eng.iso.sharipova.Entity;

import java.util.ArrayList;

/**
 * Created by developer on 13.02.2017.
 */

public class ExerciseJumpled extends Exercise {
    ArrayList<String> jumpleds;

    public ExerciseJumpled(String exNumber, String condition, int type, ArrayList<String> jumpleds) {
        super(exNumber, condition, type);
        this.jumpleds = jumpleds;
    }

    public ArrayList<String> getJumpleds() {
        return jumpleds;
    }

    public void setJumpleds(ArrayList<String> jumpleds) {
        this.jumpleds = jumpleds;
    }

    public ExerciseJumpled(String exNumber, String condition, int type) {
        super(exNumber, condition, type);
    }
}
