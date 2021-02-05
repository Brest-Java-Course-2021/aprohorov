package by.prohorov;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;


/**
 * Created by Artsiom Prokharau 05.02.2021
 */

public class CostDelivery {

    private static final double ONE_KM = 0.25;


    /*
    Use ENUM
     */
    public double costByPriceWeightInKgUseEnum(double valueEnterUser) {
        if (valueEnterUser < 4) {
            valueEnterUser = PriceKg.LIGHT.cost;
        } else if (valueEnterUser > 10) {
            valueEnterUser = PriceKg.HARD.cost;
        } else {
            valueEnterUser = PriceKg.AVERAGE.cost;
        }
        return valueEnterUser;
    }

    /*
    Use properties
     */
    public double costByPriceWeightInKgUseFile(double valueEnterUser) {
        Properties price = new Properties();
        try {
            ClassLoader classLoader = CostDelivery.class.getClassLoader();
            InputStream is = classLoader.getResourceAsStream("price_kg.properties");
            price.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (valueEnterUser < 4) {
            return Double.parseDouble(price.getProperty("LIGHT"));
        } else if (valueEnterUser > 10) {
            return Double.parseDouble(price.getProperty("HARD"));
        } else {
            return Double.parseDouble(price.getProperty("AVERAGE"));
        }
    }


    public double costByPriceInKm(double valueEnterUser) {
        return valueEnterUser * ONE_KM;
    }

    public double costOfDelivery(double costDistance, double costWeight) {
        return costDistance + costWeight;
    }

    public double checkValue(Scanner scanner) {
        double value;
        do {
            while (!scanner.hasNextDouble()) {
                System.out.println("Incorrect value! Please enter now) ");
                scanner.next();
            }
            value = scanner.nextDouble();
            if (value < 0) {
                System.out.println("Incorrect : value < 0");
            }
        } while (value < 0);
        return value;
    }
}
