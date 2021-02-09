package by.prohorov.price.kg;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CostByPriceKgUseFileJsonTest {

    private CostByPriceKgUseFileJson costKg;

    @BeforeEach
    void init() {
        costKg = new CostByPriceKgUseFileJson();
    }


    @ParameterizedTest
    @MethodSource()
    void costByPriceWeightInKg_returnValues(double value, double result) {
        costKg.setCostWeight(value);
        assertEquals(costKg.costByPriceWeightInKg(), result);
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
