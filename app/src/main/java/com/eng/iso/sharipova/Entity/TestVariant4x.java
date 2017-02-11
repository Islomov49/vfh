package com.eng.iso.sharipova.Entity;

/**
 * Created by developer on 12.02.2017.
 */

public class TestVariant4x extends TestVariant{

    String four;

    public TestVariant4x(String first, String second, String thirty, String four) {
        super(first, second, thirty);
        this.four = four;
    }

    public String getFour() {
        return four;
    }

    public void setFour(String four) {
        this.four = four;
    }

    public TestVariant4x(String first, String second, String thirty) {
        super(first, second, thirty);
    }
}
