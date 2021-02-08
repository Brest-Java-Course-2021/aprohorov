package by.prohorov.validate;

import java.util.Scanner;

/**
 * Created by Artsiom Prokharau 08.02.2021
 */

public class ValidatorImpl implements Validator {

    private Scanner scanner;


    public ValidatorImpl() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public double checkValue(String message) {
        System.out.print(message);
        double value;
        do {
            while (!scanner.hasNextDouble()) {
                System.out.println("Incorrect value! Please enter now) ");
                scanner.next();
            }
            value = scanner.nextDouble();
            if (value < 1) {
                System.out.println("Incorrect : value < 0");
            }
        } while (value < 1);

        return value;
    }

    // ------------------- 2й вариант -------------
//    @Override
//    public double checkValue(String message) {
//        System.out.println(message);
//        String value = scanner.next();
//        if (value.matches("[0-9]*")) {
//            return Double.parseDouble(value);
//        } else {
//            return checkValue(message);
//        }
//    }
//}

}
