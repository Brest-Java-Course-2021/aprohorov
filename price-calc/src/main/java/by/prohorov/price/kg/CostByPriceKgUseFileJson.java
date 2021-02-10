package by.prohorov.price.kg;

import by.prohorov.price.parser.Jackson;
import by.prohorov.validate.ValidatorUser;

import java.math.BigDecimal;

/**
 * Created by Artsiom Prokharau 09.02.2021
 */

public class CostByPriceKgUseFileJson extends CostByPriceKgAll {


    private Jackson jackson;

    public CostByPriceKgUseFileJson(ValidatorUser validatorUser) {
        super(validatorUser);
        jackson = new Jackson();
    }

    public CostByPriceKgUseFileJson() {
        jackson = new Jackson();
    }

    @Override
    public BigDecimal costByPriceWeightInKg() {
        if (costWeight.intValueExact() < 4) {
            costWeight = validatorPrice.checkValueForPrice(jackson.loaderJsonFile().getLight());
        } else if (costWeight.intValueExact() > 10) {
            costWeight = validatorPrice.checkValueForPrice(jackson.loaderJsonFile().getHard());
        } else {
            costWeight = validatorPrice.checkValueForPrice(jackson.loaderJsonFile().getAverage());
        }
        return costWeight;
    }
}
