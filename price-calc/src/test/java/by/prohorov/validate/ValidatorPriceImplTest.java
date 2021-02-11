package by.prohorov.validate;

import by.prohorov.price.exception.ReadValueInPriceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorPriceImplTest {

    private ValidatorPrice validatorPrice;

    @BeforeEach
    void init() {
        validatorPrice = new ValidatorPriceImpl();
    }

    @ParameterizedTest
    @ValueSource(strings = {" ","","f","12q","+","1,0","-1","-0.25"})
    void checkValueForPrice_throwReadValueInPriceException(String badValue) {
        assertThrows(ReadValueInPriceException.class, () -> validatorPrice.checkValueForPrice(badValue));
    }

    @ParameterizedTest
    @ValueSource(strings = {"25","1","25.5","0.25","0000.1"})
    void checkValueForPrice(String value) {
        BigDecimal validateValue = validatorPrice.checkValueForPrice(value);
        assertEquals(validateValue, new BigDecimal(value));
    }
}