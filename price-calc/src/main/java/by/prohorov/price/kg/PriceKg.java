package by.prohorov.price.kg;

/**
 * Created by Artsiom Prokharau 05.02.2021
 */


public enum PriceKg {
    LIGHT(10), AVERAGE(20), HARD(35);

    public final double cost;

    PriceKg(double cost) {
        this.cost = cost;
    }
}
