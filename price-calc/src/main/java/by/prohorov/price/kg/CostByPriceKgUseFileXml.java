package by.prohorov.price.kg;

import by.prohorov.price.parser.Jackson;
import by.prohorov.validate.ValidatorPrice;
import by.prohorov.validate.ValidatorUser;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.math.BigDecimal;

/**
 * Created by Artsiom Prokharau 09.02.2021
 */

public class CostByPriceKgUseFileXml extends CostByPriceKgAll {

    private Jackson jackson;
    private XmlMapper xMapper;
    private String pathXml;


    public CostByPriceKgUseFileXml(ValidatorUser validatorUser, ValidatorPrice validatorPrice, Jackson jackson,XmlMapper xMapper) {
        super(validatorUser, validatorPrice);
        this.jackson = jackson;
        this.xMapper = xMapper;
    }

    public CostByPriceKgUseFileXml() {
    }

    public void setPathXml(String pathXml) {
        this.pathXml = pathXml;
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