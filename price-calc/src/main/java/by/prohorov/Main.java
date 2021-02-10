package by.prohorov;

import by.prohorov.calc.Calculate;
import by.prohorov.calc.CalculateImpl;
import by.prohorov.price.kg.CostByPriceKg;
import by.prohorov.price.km.CostByPriceKm;
import by.prohorov.price.km.CostByPriceKmImpl;
import by.prohorov.price.select.SelectPrice;
import by.prohorov.validate.ValidatorUser;
import by.prohorov.validate.ValidatorUserImpl;


/**
 * Created by Artsiom Prokharau 05.02.2021
 */

public class Main {

    public static void main(String[] args) {

        ValidatorUser validatorUser = new ValidatorUserImpl();

        CostByPriceKm costKm = new CostByPriceKmImpl(validatorUser);
        CostByPriceKg costKg = new SelectPrice().selectFromListPrice(validatorUser);

        Calculate result = new CalculateImpl(costKm, costKg);
        System.out.println("Cost Of Delivery = " + result.costOfDelivery());
    }
}
