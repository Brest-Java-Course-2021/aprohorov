package by.prohorov.price.parser;

import by.prohorov.price.exception.ReadFileException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ReadPropertiesTest {

    private ReadProperties readProperties;

    @BeforeEach
    void init() {
        readProperties = new ReadProperties();
    }


    @Test
    void loaderPropertiesFile_throwReadFileException_WhenBadPath() {
        String path = "bad path";
        assertThrows(ReadFileException.class, () -> readProperties.loaderPropertiesFile(path));
    }

    @Test
    void loaderFile_returnValueNotNullFromFile() {
        String path = "price/price_kg.properties";
        assertNotNull(readProperties.loaderPropertiesFile(path));
    }
}