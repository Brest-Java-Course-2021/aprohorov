package by.prohorov.price.kg;

import by.prohorov.price.exception.IncorrectFileException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CostByPriceKgUseProprtiesTest {

    private CostByPriceKgUseProperties costKg;

    @BeforeEach
    void init() {
        costKg = new CostByPriceKgUseProperties();
    }


    @ParameterizedTest
    @MethodSource()
    void costByPriceWeightInKg_returnValues(double value, double result) {
        BigDecimal convertToDecimal = new BigDecimal(value);
        costKg.setCostWeight(convertToDecimal);
        assertEquals(costKg.costByPriceWeightInKg().doubleValue(), result);
    }

    @Test
    void loaderPropertiesFile_throwIncorrectFileException_WhenValueNotFoundTheFile() {
        BigDecimal convertToDecimal = new BigDecimal(new Random().nextInt(40));
        costKg.setCostWeight(convertToDecimal);
        costKg.setPath("price_incorrect_field.properties");
        assertThrows(IncorrectFileException.class, () -> costKg.costByPriceWeightInKg());
    }

    private static Stream<Arguments> costByPriceWeightInKg_returnValues() {
        return Stream.of(
                Arguments.of(1, 10),
                Arguments.of(5, 20),
                Arguments.of(15, 35),
                Arguments.of(7, 20),
                Arguments.of(54, 35),
                Arguments.of(2, 10)
        );
    }
}