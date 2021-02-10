package by.prohorov.validate;

import java.math.BigDecimal;

/**
 * Created by Artsiom Prokharau 10.02.2021
 */


public interface ValidatorPrice {

    BigDecimal checkValueForPrice(String priceValue);

}
