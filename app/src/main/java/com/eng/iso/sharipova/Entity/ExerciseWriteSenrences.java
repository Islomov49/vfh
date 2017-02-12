package com.eng.iso.sharipova.Entity;

import java.util.ArrayList;

/**
 * Created by developer on 13.02.2017.
 */

public class ExerciseWriteSenrences extends Exercise {

    ArrayList<String> usefullTips;
    public ExerciseWriteSenrences(String exNumber, String condition, int type) {
        super(exNumber, condition, type);
    }

    public ExerciseWriteSenrences(String exNumber, String condition, int type, ArrayList<String> usefullTips) {
        super(exNumber, condition, type);
        this.usefullTips = usefullTips;
    }

    public ArrayList<String> getUsefullTips() {
        return usefullTips;
    }

    public void setUsefullTips(ArrayList<String> usefullTips) {
        this.usefullTips = usefullTips;
    }
}
