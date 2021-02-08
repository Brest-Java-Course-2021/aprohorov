package by.prohorov.price.kg;

import by.prohorov.validate.Validator;

/**
 * Created by Artsiom Prokharau 08.02.2021
 */

public class CostByPriceKgUseEnum implements CostByPriceKg {

    private double costWeight;

    public CostByPriceKgUseEnum() {
    }

    public CostByPriceKgUseEnum(Validator validator) {
        this.costWeight = validator.checkValue("Please, enter weight (kg) : =>  ");
    }

    public double getCostWeight() {
        return costWeight;
    }

    public void setCostWeight(double costWeight) {
        this.costWeight = costWeight;
    }

    @Override
    public double costByPriceWeightInKg() {
        if (costWeight < 4) {
            costWeight = PriceKg.LIGHT.cost;
        } else if (costWeight > 10) {
            costWeight = PriceKg.HARD.cost;
        } else {
            costWeight = PriceKg.AVERAGE.cost;
        }
        return costWeight;
    }
}
