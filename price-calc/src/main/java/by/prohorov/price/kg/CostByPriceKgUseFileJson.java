package by.prohorov.price.kg;

import by.prohorov.price.parser.Jackson;
import by.prohorov.validate.ValidatorPrice;
import by.prohorov.validate.ValidatorUser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;

/**
 * Created by Artsiom Prokharau 09.02.2021
 */

public class CostByPriceKgUseFileJson extends CostByPriceKgAll {

    private Jackson jackson;
    private String pathJson;
    private ObjectMapper oMapper;

    public CostByPriceKgUseFileJson(ValidatorUser validatorUser, ValidatorPrice validatorPrice, Jackson jackson, ObjectMapper oMapper) {
        super(validatorUser, validatorPrice);
        this.jackson = jackson;
        this.oMapper = oMapper;
    }

    public CostByPriceKgUseFileJson() {
        jackson = new Jackson();
        oMapper = new ObjectMapper();
    }

    public void setPathJson(String pathJson) {
        this.pathJson = pathJson;
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
