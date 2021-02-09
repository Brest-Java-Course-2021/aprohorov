package by.prohorov.price.kg;

import by.prohorov.price.entity.Price;
import by.prohorov.price.parser.Jackson;
import by.prohorov.validate.Validator;

import java.io.IOException;

/**
 * Created by Artsiom Prokharau 09.02.2021
 */

public class CostByPriceKgUseFileXml implements CostByPriceKg {

    private double costWeight;

    public CostByPriceKgUseFileXml() {
    }

    public CostByPriceKgUseFileXml(Validator validator) {
        this.costWeight = validator.checkValue("Please, enter weight (kg) : =>  ");
    }

    public double getCostWeight() {
        return costWeight;
    }

    public void setCostWeight(double costWeight) {
        this.costWeight = costWeight;
    }

    @Override
    public double costByPriceWeightInKg() {
        try {
            if (costWeight < 4) {
                costWeight = Jackson.loaderXmlFile().getLight();
            } else if (costWeight > 10) {
                costWeight = Jackson.loaderXmlFile().getHard();
            } else {
                costWeight = Jackson.loaderXmlFile().getAverage();
            }
        } catch (IOException ex) {
            ex.getMessage();
        }
        return costWeight;
    }
}
