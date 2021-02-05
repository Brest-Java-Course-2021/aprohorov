package by.prohorov;

/**
 * Created by Artsiom Prokharau 05.02.2021
 */


public enum PriceKg {
    LIGHT(10), AVERAGE(20), HARD(35);

    public final double cost;

    private PriceKg(double cost) {
        this.cost = cost;
    }
}
