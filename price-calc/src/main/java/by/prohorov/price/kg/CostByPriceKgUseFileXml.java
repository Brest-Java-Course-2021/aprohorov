package by.prohorov.price.kg;

import by.prohorov.price.parser.Jackson;
import by.prohorov.validate.ValidatorUser;

import java.math.BigDecimal;

/**
 * Created by Artsiom Prokharau 09.02.2021
 */

public class CostByPriceKgUseFileXml extends CostByPriceKgAll {

    private Jackson jackson;

    public CostByPriceKgUseFileXml(ValidatorUser validatorUser) {
        super(validatorUser);
        jackson = new Jackson();
    }

    public CostByPriceKgUseFileXml() {
        jackson = new Jackson();
    }

    @Override
    public BigDecimal costByPriceWeightInKg() {
        if (costWeight.intValueExact() < 4) {
            costWeight = validatorPrice.checkValueForPrice(jackson.loaderXmlFile().getLight());
        } else if (costWeight.intValueExact() > 10) {
            costWeight = validatorPrice.checkValueForPrice(jackson.loaderXmlFile().getHard());
        } else {
            costWeight = validatorPrice.checkValueForPrice(jackson.loaderXmlFile().getAverage());
        }
        return costWeight;
    }
}
