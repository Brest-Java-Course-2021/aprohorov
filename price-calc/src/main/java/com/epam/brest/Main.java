package com.epam.brest;

/**
 * Created by Artsiom Prokharau 01.02.2021
 */

public class Main {

    public static void main(String[] args) {
//        System.out.println("Hello world");

        double distance = 10.0;
        double price = 25.5;
        double weight = 13.2;
        double price2 = 25.5;

        double result = distance * price + (weight * price2);
        System.out.println("result = " + result);

    }


}
