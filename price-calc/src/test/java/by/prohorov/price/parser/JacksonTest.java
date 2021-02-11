package by.prohorov.price.parser;

import by.prohorov.price.entity.Price;
import by.prohorov.price.exception.ReadFileException;
import by.prohorov.price.exception.ReadValueInPriceException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JacksonTest {

    private Jackson jackson;
    private ObjectMapper objectMapper;

    @BeforeEach
    void init() {
        jackson = new Jackson();
        objectMapper = new ObjectMapper();
    }

    @Test
    void loaderFile_throwReadFileException_() {
        String path = "bad path";
        assertThrows(ReadFileException.class, () -> jackson.loaderFile(objectMapper, path));
    }

    @Test
    void loaderFile_returnValueNotNull() {
        String path = "price/price_kg.json";
       assertNotNull(jackson.loaderFile(objectMapper, path));
    }
}