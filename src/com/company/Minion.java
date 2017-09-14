package com.company;

/**
 * Created by Jonathan on 5/16/2016.
 */


/**
 * The Minion class models the information of a minion which contains attributes
 * name, height, and numbewr of evil deeds done. It supports retrieving said attributes
 * and increasing the number of evil deeds done.
 */

public class Minion {

    private String name;
    private Double height;
    private int numEvilDeeds;

    public Minion(String name, Double height, int numEvilDeeds) {

        this.name = name;
        this.height = height;
        this.numEvilDeeds = numEvilDeeds;

    }

    public Minion(String name, Double height) {

        this.name = name;
        this.height = height;
        this.numEvilDeeds = 0;

    }

    public String getName() {

        return name;

    }

    public Double getHeightInM() {

        return height;

    }

    public int getEvilDeedCount() {

        return numEvilDeeds;

    }

    public void incrementEvilDeeds() {

        numEvilDeeds++;

    }

    @Override
    public String toString() {

        return "[Name:" + getName() + ", " + "Height:" + getHeightInM() + "m" + ", " + "Evil Deeds:" + getEvilDeedCount() + "]";

    }

}
