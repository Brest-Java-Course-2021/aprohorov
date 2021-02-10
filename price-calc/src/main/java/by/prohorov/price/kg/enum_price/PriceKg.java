package by.prohorov.price.kg.enum_price;

/**
 * Created by Artsiom Prokharau 05.02.2021
 */


public enum PriceKg {
    LIGHT("10"), AVERAGE("20"), HARD("35");

    public final String cost;

    PriceKg(String cost) {
        this.cost = cost;
    }
}
