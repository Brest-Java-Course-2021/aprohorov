package by.prohorov;

import java.util.Scanner;

/**
 * Created by Artsiom Prokharau 05.02.2021
 */

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CostDelivery cd = new CostDelivery();

        System.out.print("Please, enter distance: =>  ");
        double costDistance = cd.costByPriceInKm(cd.checkValue(scanner));

        System.out.print("Please, enter weight: =>  ");
        double costWeight = cd.costByPriceWeightInKgUseEnum(cd.checkValue(scanner));
//        double costWeight = cd.costByPriceWeightInKgUseFile(cd.checkValue(scanner));

        System.out.println("Cost Of Delivery = " + cd.costOfDelivery(costDistance, costWeight));
    }
}
