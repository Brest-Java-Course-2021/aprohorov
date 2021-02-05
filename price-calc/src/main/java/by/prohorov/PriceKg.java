package by.prohorov;

/**
 * Created by Artsiom Prokharau 05.02.2021
 */


public enum PriceKg {
    LIGHT(10), AVERAGE(20),HARD(35);

    public final Integer cost;

    private PriceKg(Integer cost) {
        this.cost = cost;
    }
}
