package com.eng.iso.sharipova.Entity;

/**
 * Created by developer on 14.02.2017.
 */

public class IntervalsTwoPair {
    int startPosition;
    int endPosition;

    public IntervalsTwoPair(int startPosition, int endPosition) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }

    public int getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(int endPosition) {
        this.endPosition = endPosition;
    }
}
