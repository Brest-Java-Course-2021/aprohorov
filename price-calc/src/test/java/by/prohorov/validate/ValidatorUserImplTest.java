package by.prohorov.validate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Scanner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidatorUserImplTest {

    private ValidatorUserImpl validator;

    @BeforeEach
    void init() {
        validator = new ValidatorUserImpl();
    }

    @Test
    void checkValue_throwNullPointerException_whenMessageNull() {
        assertThrows(NullPointerException.class, () -> validator.checkValue(null));
    }

    @ParameterizedTest
    @MethodSource("correctValues")
    void checkValue_returnBigDecimalValue(String currentValue, double result) {
        validator.setScanner(new Scanner(currentValue));
        String str = "Check value";
        assertEquals(validator.checkValue(str).doubleValue(), result);
    }

//    @ParameterizedTest
//    @ValueSource(strings = {"-1","0","a","-","iw"})
    //Todo create negative test
//    void checkValue_returnBigDecimalValue(String currentValue) {
//        validator.setScanner(new Scanner(currentValue));
//        String str = "Check value";
//        StringWriter output = new StringWriter();
//        assertTrue(output.toString().contains("Incorrect value! Please enter now) "));
//    }

    private static Stream<Arguments> correctValues() {
        return Stream.of(
                Arguments.of("25,5", 25.5),
                Arguments.of("5", 5.0),
                Arguments.of("15", 15.0),
                Arguments.of("46,87", 46.87),
                Arguments.of("54", 54.0),
                Arguments.of("2", 2.0)
        );
    }


}

