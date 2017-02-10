package com.eng.iso.sharipova.Entity;

import java.util.Calendar;

/**
 * Created by developer on 11.02.2017.
 */

public class Lesson {
    private long id;
    private String headerText;
    private String contentText;

    public Lesson(long id, String headerText, String contentText) {
        this.id = id;
        this.headerText = headerText;
        this.contentText = contentText;
    }

    public Lesson(String headerText, String contentText) {
        id = System.currentTimeMillis();
        this.headerText = headerText;
        this.contentText = contentText;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHeaderText() {
        return headerText;
    }

    public void setHeaderText(String headerText) {
        this.headerText = headerText;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }
}
