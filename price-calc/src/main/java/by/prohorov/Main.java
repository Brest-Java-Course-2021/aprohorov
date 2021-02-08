package by.prohorov;

import by.prohorov.calc.Calculate;
import by.prohorov.calc.CalculateImpl;
import by.prohorov.price.kg.CostByPriceKg;
import by.prohorov.price.kg.CostByPriceKgUseEnum;
import by.prohorov.price.km.CostByPriceKm;
import by.prohorov.price.km.CostByPriceKmImpl;
import by.prohorov.validate.Validator;
import by.prohorov.validate.ValidatorImpl;

/**
 * Created by Artsiom Prokharau 05.02.2021
 */

public class Main {

    public static void main(String[] args) {

        Validator validator = new ValidatorImpl();

        CostByPriceKm costKm = new CostByPriceKmImpl(validator);
//                       ----------------- Use File.properties -----------------
//        CostByPriceKg costKg = new CostByPriceKgUseFile(validator);
//                       ----------------- Use ENUM(recommend) -----------------
        CostByPriceKg costKg = new CostByPriceKgUseEnum(validator);

        Calculate result = new CalculateImpl(costKm, costKg);
        System.out.println("Cost Of Delivery = " + result.costOfDelivery());

    }
}
