package by.prohorov.price.km;

import by.prohorov.validate.Validator;

/**
 * Created by Artsiom Prokharau 08.02.2021
 */

public class CostByPriceKmImpl implements CostByPriceKm {

    private double costDistance;

    public CostByPriceKmImpl() {
    }

    public CostByPriceKmImpl(Validator validator) {
        this.costDistance = validator.checkValue("Please, enter distance (km) : =>  ");
    }

    public double getCostDistance() {
        return costDistance;
    }

    public void setCostDistance(double costDistance) {
        this.costDistance = costDistance;
    }

    @Override
    public double costByPriceInKm() {
        return costDistance * ONE_KM;
    }
}
