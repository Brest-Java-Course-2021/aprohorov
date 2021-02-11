package by.prohorov.price.kg;

import by.prohorov.price.parser.Jackson;
import by.prohorov.validate.ValidatorUser;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.math.BigDecimal;

/**
 * Created by Artsiom Prokharau 09.02.2021
 */

public class CostByPriceKgUseFileXml extends CostByPriceKgAll {

    private Jackson jackson;
    private XmlMapper xMapper;

    public CostByPriceKgUseFileXml(ValidatorUser validatorUser) {
        super(validatorUser);
        jackson = new Jackson();

    }

    public CostByPriceKgUseFileXml() {
        jackson = new Jackson();
        xMapper = new XmlMapper();
    }

    @Override
    public BigDecimal costByPriceWeightInKg() {
        String pathXml = "price/price_kg.xml";

        if (costWeight.intValueExact() < 4) {
            costWeight = validatorPrice.checkValueForPrice(jackson.loaderFile(xMapper, pathXml).getLight());
        } else if (costWeight.intValueExact() > 10) {
            costWeight = validatorPrice.checkValueForPrice(jackson.loaderFile(xMapper, pathXml).getHard());
        } else {
            costWeight = validatorPrice.checkValueForPrice(jackson.loaderFile(xMapper, pathXml).getAverage());
        }
        return costWeight;
    }
}
