package by.prohorov.validate;

import by.prohorov.price.exception.ReadValueInPriceException;

import java.math.BigDecimal;

/**
 * Created by Artsiom Prokharau 10.02.2021
 */

public class ValidatorPriceImpl implements ValidatorPrice {

    @Override
    public BigDecimal checkValueForPrice(String priceValue) {

        if (priceValue.matches("^(?=\\s*\\S)\\d*\\.?\\d*")) {
            return new BigDecimal(priceValue);
        } else {
            throw new ReadValueInPriceException("Incorrect value in File. Correct please and return");
        }
    }
}
