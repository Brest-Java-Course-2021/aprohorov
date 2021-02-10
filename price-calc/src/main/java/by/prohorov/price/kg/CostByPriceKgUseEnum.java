package by.prohorov.price.kg;

import by.prohorov.price.kg.enum_price.PriceKg;
import by.prohorov.validate.ValidatorUser;

import java.math.BigDecimal;

/**
 * Created by Artsiom Prokharau 08.02.2021
 */

public class CostByPriceKgUseEnum extends CostByPriceKgAll {

    public CostByPriceKgUseEnum() {
    }

    public CostByPriceKgUseEnum(ValidatorUser validatorUser) {
        super(validatorUser);
    }

    @Override
    public BigDecimal costByPriceWeightInKg() {
        if (costWeight.intValueExact() < 4) {
            costWeight = validatorPrice.checkValueForPrice(PriceKg.LIGHT.cost);
        } else if (costWeight.intValueExact() > 10) {
            costWeight = validatorPrice.checkValueForPrice(PriceKg.HARD.cost);
        } else {
            costWeight = validatorPrice.checkValueForPrice(PriceKg.AVERAGE.cost);
        }
        return costWeight;
    }
}
