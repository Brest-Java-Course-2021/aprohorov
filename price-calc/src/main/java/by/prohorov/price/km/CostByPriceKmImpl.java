package by.prohorov.price.km;

import by.prohorov.validate.ValidatorUser;

import java.math.BigDecimal;

/**
 * Created by Artsiom Prokharau 08.02.2021
 */

public class CostByPriceKmImpl implements CostByPriceKm {

    private static final BigDecimal ONE_KM = new BigDecimal("0.25");

    private BigDecimal costDistance;

    public CostByPriceKmImpl() {
    }

    public CostByPriceKmImpl(ValidatorUser validatorUser) {
        this.costDistance = validatorUser.checkValue("Please, enter distance (km) : =>  ");
    }

    public BigDecimal getCostDistance() {
        return costDistance;
    }

    public void setCostDistance(BigDecimal costDistance) {
        this.costDistance = costDistance;
    }

    @Override
    public BigDecimal costByPriceInKm() {
        return costDistance.multiply(ONE_KM);
    }
}
