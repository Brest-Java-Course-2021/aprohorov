package by.prohorov;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;


/**
 * Created by Artsiom Prokharau 05.02.2021
 */

public class CostDelivery {

    private static final double ONE_KM = 0.25;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] messages = createMessageForUser();
        double[] enteredValue = new double[2];

        for (int i = 0; i < messages.length; i++) {
            System.out.print(messages[i]);
            enteredValue[i] = checkValue(scanner);
        }

        double costDistance = costByPriceInKm(enteredValue[0]);
        double costWeight = costByPriceWeightInKg(enteredValue[1]);

        costOfDelivery(costDistance,costWeight);
    }

    /*
    Use ENUM
     */
    private static double costByPriceWeightInKg(double valueEnterUser) {
        if (valueEnterUser < 4) {
            valueEnterUser = PriceKg.LIGHT.cost;
        } else if (valueEnterUser > 10) {
            valueEnterUser = PriceKg.HARD.cost;
        }else{
            valueEnterUser = PriceKg.AVERAGE.cost;
        }
        return valueEnterUser;
    }

    /*
    Use properties
     */
//    private static double costByPriceWeightInKg(double valueEnterUser) {
//        Properties price = new Properties();
//        try {
//            price.load(new FileReader("price-calc/src/main/resources/price_kg.properties"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        if(valueEnterUser < 4){
//            return Double.parseDouble(price.getProperty("LIGHT"));
//        } else if (valueEnterUser > 10) {
//            return Double.parseDouble(price.getProperty("HARD"));
//        }else{
//            return Double.parseDouble(price.getProperty("AVERAGE"));
//        }
//    }


    private static double  costByPriceInKm(double valueEnterUser) {
        return valueEnterUser * ONE_KM;
    }

    private static void costOfDelivery(double costDistance, double costWeight) {
        double result;
        result = costWeight + costDistance;
        System.out.println("Cost Of Delivery = " + result);
    }

    private static double checkValue(Scanner scanner) {
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


    public static String[] createMessageForUser() {
        String[] messages = new String[2];
        messages[0] = "Please, enter distance: ";
        messages[1] = "Please, enter weight: ";
        return messages;
    }
}
