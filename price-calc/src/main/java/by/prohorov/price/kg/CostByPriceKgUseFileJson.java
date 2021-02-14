package by.prohorov.price.kg;

import by.prohorov.price.parser.Jackson;
import by.prohorov.validate.ValidatorUser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;

/**
 * Created by Artsiom Prokharau 09.02.2021
 */

public class CostByPriceKgUseFileJson extends CostByPriceKgAll {

    private Jackson jackson = new Jackson();
    private ObjectMapper oMapper = new ObjectMapper();
    String pathJson = "price/price_kg.json";

    public CostByPriceKgUseFileJson(ValidatorUser validatorUser) {
        super(validatorUser);
    }

    public CostByPriceKgUseFileJson() {
    }


    @Override
    public BigDecimal costByPriceWeightInKg() {
        if (costWeight.doubleValue() < 4) {
            return validatorPrice.checkValueForPrice(jackson.loaderFile(oMapper, pathJson).getLight());
        } else if (costWeight.doubleValue() > 10) {
            return validatorPrice.checkValueForPrice(jackson.loaderFile(oMapper, pathJson).getHard());
        } else {
            return validatorPrice.checkValueForPrice(jackson.loaderFile(oMapper, pathJson).getAverage());
        }
    }
}
