package by.prohorov.price.kg;

import by.prohorov.price.parser.Jackson;
import by.prohorov.validate.ValidatorUser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;

/**
 * Created by Artsiom Prokharau 09.02.2021
 */

public class CostByPriceKgUseFileJson extends CostByPriceKgAll {


    private Jackson jackson;
    private ObjectMapper oMapper;

    public CostByPriceKgUseFileJson(ValidatorUser validatorUser) {
        super(validatorUser);
        jackson = new Jackson();

    }

    public CostByPriceKgUseFileJson() {
        jackson = new Jackson();
        oMapper = new ObjectMapper();
    }


    @Override
    public BigDecimal costByPriceWeightInKg() {
        String pathJson = "price/price_kg.json";

        if (costWeight.intValueExact() < 4) {
            costWeight = validatorPrice.checkValueForPrice(jackson.loaderFile(oMapper, pathJson).getLight());
        } else if (costWeight.intValueExact() > 10) {
            costWeight = validatorPrice.checkValueForPrice(jackson.loaderFile(oMapper, pathJson).getHard());
        } else {
            costWeight = validatorPrice.checkValueForPrice(jackson.loaderFile(oMapper, pathJson).getAverage());
        }
        return costWeight;
    }
}
