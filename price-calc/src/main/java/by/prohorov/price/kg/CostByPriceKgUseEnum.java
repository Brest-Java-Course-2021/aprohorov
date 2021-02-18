package by.prohorov.price.kg;

import by.prohorov.price.kg.enum_price.PriceKg;
import by.prohorov.validate.ValidatorPrice;
import by.prohorov.validate.ValidatorUser;

import java.math.BigDecimal;

/**
 * Created by Artsiom Prokharau 08.02.2021
 */

public class CostByPriceKgUseEnum extends CostByPriceKgAll {

    public CostByPriceKgUseEnum() {
    }

    public CostByPriceKgUseEnum(ValidatorUser validatorUser, ValidatorPrice validatorPrice) {
        super(validatorUser, validatorPrice);
    }

    @Override
    public BigDecimal costByPriceWeightInKg() {
        if (costWeight.doubleValue() < 4) {
            return validatorPrice.checkValueForPrice(PriceKg.LIGHT.cost);
        } else if (costWeight.doubleValue() > 10) {
            return validatorPrice.checkValueForPrice(PriceKg.HARD.cost);
        } else {
            return validatorPrice.checkValueForPrice(PriceKg.AVERAGE.cost);
        }
    }
}
