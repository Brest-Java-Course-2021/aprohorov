package by.prohorov.calc;

import by.prohorov.price.kg.CostByPriceKg;
import by.prohorov.price.km.CostByPriceKm;

/**
 * Created by Artsiom Prokharau 08.02.2021
 */

public class CalculateImpl implements Calculate {

    private CostByPriceKm costByPriceKm;
    private CostByPriceKg costByPriceKg;


    public CalculateImpl(CostByPriceKm costByPriceKm, CostByPriceKg costByPriceKg) {
        this.costByPriceKm = costByPriceKm;
        this.costByPriceKg = costByPriceKg;
    }

    @Override
    public double costOfDelivery() {
        return costByPriceKm.costByPriceInKm() + costByPriceKg.costByPriceWeightInKg();
    }
}
