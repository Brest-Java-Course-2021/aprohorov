package by.prohorov.price.kg;

import by.prohorov.price.parser.Jackson;
import by.prohorov.validate.ValidatorUser;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.math.BigDecimal;

/**
 * Created by Artsiom Prokharau 09.02.2021
 */

public class CostByPriceKgUseFileXml extends CostByPriceKgAll {

    private Jackson jackson = new Jackson();
    private XmlMapper xMapper = new XmlMapper();
    private String pathXml = "price/price_kg.xml";

    public CostByPriceKgUseFileXml(ValidatorUser validatorUser) {
        super(validatorUser);
    }

    public CostByPriceKgUseFileXml() {
    }

    @Override
    public BigDecimal costByPriceWeightInKg() {
        if (costWeight.doubleValue() < 4) {
            return validatorPrice.checkValueForPrice(jackson.loaderFile(xMapper, pathXml).getLight());
        } else if (costWeight.doubleValue() > 10) {
            return validatorPrice.checkValueForPrice(jackson.loaderFile(xMapper, pathXml).getHard());
        } else {
            return validatorPrice.checkValueForPrice(jackson.loaderFile(xMapper, pathXml).getAverage());
        }
    }
}