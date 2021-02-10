package by.prohorov.price.select;

import by.prohorov.price.kg.*;
import by.prohorov.validate.ValidatorUser;

import java.util.Random;

/**
 * Created by Artsiom Prokharau 10.02.2021
 */

public class SelectPrice {

    public CostByPriceKg selectFromListPrice(ValidatorUser validatorUser) {

        int randomFile = new Random().nextInt(4);
        CostByPriceKg costKg = null;
        switch (randomFile) {
            case 0:
                costKg = new CostByPriceKgUseProperties(validatorUser);
                break;
            case 1:
                costKg = new CostByPriceKgUseEnum(validatorUser);
                break;
            case 2:
                costKg = new CostByPriceKgUseFileXml(validatorUser);
                break;
            case 3:
                costKg = new CostByPriceKgUseFileJson(validatorUser);
                break;
            default:
                System.out.println("Нет подходящего варианта");
        }
        return costKg;
    }
}
