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

    @Override
    public BigDecimal checkValue(String message) {
        System.out.print(message);
        BigDecimal value;
        do {
            while (!scanner.hasNextBigDecimal()) {
                System.out.println("Incorrect value! Please enter now) ");
                scanner.next();
            }
            value = scanner.nextBigDecimal();
            if (value.intValueExact() < 1) {
                System.out.println("Incorrect : value < 0");
            }
        } while (value.intValueExact() < 1);

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
