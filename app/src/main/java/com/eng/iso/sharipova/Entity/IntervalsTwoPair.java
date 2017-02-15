package com.eng.iso.sharipova.Entity;

/**
 * Created by developer on 14.02.2017.
 */

public class IntervalsTwoPair {
    int startPosition;
    int endPosition;
    String word;
    public IntervalsTwoPair(int startPosition, int endPosition) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    public IntervalsTwoPair(int startPosition, int endPosition, String word) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
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
