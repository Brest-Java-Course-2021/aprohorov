package by.prohorov.price.kg;

import by.prohorov.price.parser.ReadProperties;
import by.prohorov.validate.ValidatorUser;

import java.math.BigDecimal;
import java.util.Properties;

/**
 * Created by Artsiom Prokharau 10.02.2021
 */

public class CostByPriceKgUseProperties extends CostByPriceKgAll {

    private ReadProperties readProperties;

    public CostByPriceKgUseProperties(ValidatorUser validatorUser) {
        super(validatorUser);
    }

    public CostByPriceKgUseProperties() {
    }

    @Override
    public BigDecimal costByPriceWeightInKg() {
        readProperties = new ReadProperties();
        Properties price = readProperties.loaderPropertiesFile();

        if (costWeight.intValueExact() < 4) {
            return validatorPrice.checkValueForPrice(price.getProperty("LIGHT"));
        } else if (costWeight.intValueExact() > 10) {
            return validatorPrice.checkValueForPrice(price.getProperty("HARD"));
        } else {
            return validatorPrice.checkValueForPrice(price.getProperty("AVERAGE"));
        }
    }
}

