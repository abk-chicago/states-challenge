package com.andreakim.statesusa;

import java.util.ArrayList;

/**
 * Created by andreakim on 8/22/16.
 */
public class State extends ArrayList<String>{

    private String states = "states";
    private String name = "name";
    private String abbreviation = "abbreviation";
    private String area = "area";
    private String capital = "capital";
    private String mostPopulousCity = "mostPopulousCity";
    private String flagURL = "flagURL";

    public State() {
    }

    private static State mState = new State();
    public static State mInstance = new State();
    public static State getInstance() {
        return mInstance;
    }

    public State(int initialCapacity, String states, String name, String abbreviation, String area, String capital, String mostPopulousCity, String flagURL) {
        super(initialCapacity);
        this.states = states;
        this.name = name;
        this.abbreviation = abbreviation;
        this.area = area;
        this.capital = capital;
        this.mostPopulousCity = mostPopulousCity;
        this.flagURL = flagURL;
    }

    public String getStates() {
        return states;
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getArea() {
        return area;
    }

    public String getCapital() {
        return capital;
    }

    public String getMostPopulousCity() {
        return mostPopulousCity;
    }

    public String getFlagURL() {
        return flagURL;
    }

    @Override
    public String toString() {
        return "State{" +
                "states='" + states + '\'' +
                ", name='" + name + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", area='" + area + '\'' +
                ", capital='" + capital + '\'' +
                ", mostPopulousCity='" + mostPopulousCity + '\'' +
                ", flagURL='" + flagURL + '\'' +
                '}';
    }


}