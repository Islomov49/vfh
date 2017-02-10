package com.eng.iso.sharipova.Entity;

/**
 * Created by developer on 11.02.2017.
 */

public class Exercise {
    private String exNumber;
    private String condition;
    private int type;
    public Exercise(String exNumber, String condition, int type) {
        this.type = type;
        this.exNumber = exNumber;
        this.condition = condition;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getExNumber() {
        return exNumber;
    }

    public void setExNumber(String exNumber) {
        this.exNumber = exNumber;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
