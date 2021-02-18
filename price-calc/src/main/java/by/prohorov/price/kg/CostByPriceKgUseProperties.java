package by.prohorov.price.kg;

import by.prohorov.price.exception.IncorrectFileException;
import by.prohorov.price.parser.ReadProperties;
import by.prohorov.validate.ValidatorPrice;
import by.prohorov.validate.ValidatorUser;

import java.math.BigDecimal;
import java.util.Properties;

/**
 * Created by Artsiom Prokharau 10.02.2021
 */

public class CostByPriceKgUseProperties extends CostByPriceKgAll {

    private String pathProperties;

    public CostByPriceKgUseProperties(ValidatorUser validatorUser, ValidatorPrice validatorPrice) {
        super(validatorUser, validatorPrice);
    }

    public CostByPriceKgUseProperties() {
    }

    public void setPathProperties(String pathProperties) {
        this.pathProperties = pathProperties;
    }

    @Override
    public BigDecimal costByPriceWeightInKg() {
        Properties price = new ReadProperties().loaderPropertiesFile(pathProperties);
        try {
            if (costWeight.doubleValue() < 4) {
                return validatorPrice.checkValueForPrice(price.getProperty("LIGHT"));
            } else if (costWeight.doubleValue() > 10) {
                return validatorPrice.checkValueForPrice(price.getProperty("HARD"));
            } else {
                return validatorPrice.checkValueForPrice(price.getProperty("AVERAGE"));
            }
        } catch (NullPointerException ex) {
            throw new IncorrectFileException("File incorrect. Please correct the name field to file with the name => " + pathProperties);
        }
    }
}

