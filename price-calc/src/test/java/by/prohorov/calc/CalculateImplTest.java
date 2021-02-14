package by.prohorov.calc;

import by.prohorov.price.kg.CostByPriceKgUseEnum;
import by.prohorov.price.km.CostByPriceKmImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateImplTest {

    private CalculateImpl calculate;
    private CostByPriceKmImpl costKm;
    private CostByPriceKgUseEnum costKg;

    @BeforeEach
    void init() {
        costKm = new CostByPriceKmImpl();
        costKg = new CostByPriceKgUseEnum();
        calculate = new CalculateImpl(costKm, costKg);
    }

    @ParameterizedTest
    @MethodSource("checkValue")
    void costOfDelivery_checkNeededResult(double distance, double weight, double result) {
        costKm.setCostDistance(new BigDecimal(distance));
        costKg.setCostWeight(new BigDecimal(weight));
        assertEquals(result, calculate.costOfDelivery().doubleValue());
    }


    private static Stream<Arguments> checkValue() {
        return Stream.of(
                Arguments.of(25, 41, 41.25),
                Arguments.of(453, 75, 148.25),
                Arguments.of(34, 45, 43.5),
                Arguments.of(10, 10, 22.5)
        );
    }
}