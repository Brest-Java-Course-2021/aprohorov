package by.prohorov.price.entity;

import java.util.ArrayList;

/**
 * Created by Artsiom Prokharau 09.02.2021
 */

public class Price {

    private Integer light;
    private Integer average;
    private Integer hard;

    public Price() {
    }

    public Integer getLight() {
        return light;
    }

    public void setLight(Integer light) {
        this.light = light;
    }

    public Integer getAverage() {
        return average;
    }

    public void setAverage(Integer average) {
        this.average = average;
    }

    public Integer getHard() {
        return hard;
    }

    public void setHard(Integer hard) {
        this.hard = hard;
    }
}
