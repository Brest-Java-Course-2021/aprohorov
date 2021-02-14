package by.prohorov.validate;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by Artsiom Prokharau 08.02.2021
 */

public class ValidatorUserImpl implements ValidatorUser {

    private Scanner scanner;


    public ValidatorUserImpl() {
        this.scanner = new Scanner(System.in);
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public BigDecimal checkValue(String message) {

        if (message != null) {
            System.out.print(message);
        } else {
            throw new NullPointerException("Message is null!");
        }
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

        return new BigDecimal(value);
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
