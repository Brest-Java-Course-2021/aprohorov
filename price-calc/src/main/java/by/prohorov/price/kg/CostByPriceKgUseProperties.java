package by.prohorov.price.kg;

import by.prohorov.validate.Validator;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Artsiom Prokharau 09.02.2021
 */

public class CostByPriceKgUseProperties  implements CostByPriceKg{

    private double costWeight;

    public CostByPriceKgUseProperties() {
    }

    public CostByPriceKgUseProperties(Validator validator) {
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
        Properties price = new Properties();
        try {
            ClassLoader classLoader = CostByPriceKgUseProperties.class.getClassLoader();
            InputStream is = classLoader.getResourceAsStream("price/price_kg.properties");
            price.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (costWeight < 4) {
            return Double.parseDouble(price.getProperty("LIGHT"));
        } else if (costWeight > 10) {
            return Double.parseDouble(price.getProperty("HARD"));
        } else {
            return Double.parseDouble(price.getProperty("AVERAGE"));
        }
    }
}

