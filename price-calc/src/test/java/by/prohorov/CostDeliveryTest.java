package by.prohorov;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


class CostDeliveryTest {


    public CostDelivery costDelivery;


    @BeforeEach
    void init() {
        costDelivery = new CostDelivery();
    }

    @ParameterizedTest
    @MethodSource("testEnumOrFile_returnValue")
    void costByPriceWeightInKgUseEnum_returnValue(double value,double result) {
        assertEquals(costDelivery.costByPriceWeightInKgUseEnum(value), result);
    }


    @ParameterizedTest
    @MethodSource("testEnumOrFile_returnValue")
    void costByPriceWeightInKgUseFile_returnValue(double value,double result) {
        assertEquals(costDelivery.costByPriceWeightInKgUseFile(value), result);
    }

    @Test
    void costByPriceInKm() {
        double value = costDelivery.costByPriceInKm(25);
        assertEquals(6.25, value);
        assertNotEquals(value, 18);
    }

    @ParameterizedTest
    @MethodSource
    void costOfDelivery_returnValue(double val1,double val2,double result) {
        assertEquals(costDelivery.costOfDelivery(val1, val2), result);
    }


    private static Stream<Arguments> testEnumOrFile_returnValue() {
        return Stream.of(
                Arguments.of(1, 10),
                Arguments.of(5, 20),
                Arguments.of(15, 35),
                Arguments.of(7, 20),
                Arguments.of(54, 35),
                Arguments.of(2, 10)
        );
    }

    private static Stream<Arguments> costOfDelivery_returnValue(){
        return Stream.of(
                Arguments.of(25.3,45.2, 70.5),
                Arguments.of(45.3,75.2, 120.5),
                Arguments.of(-34.2,45.2, 11.0),
                Arguments.of(10,10, 20)

        );
    }



}