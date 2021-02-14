package by.prohorov.price.parser;

import by.prohorov.price.exception.IncorrectFileException;
import by.prohorov.price.exception.ReadFileException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class JacksonTest {

    private Jackson jackson;
    private ObjectMapper objectMapper;
    private XmlMapper xmlMapper;

    @BeforeEach
    void init() {
        jackson = new Jackson();
        objectMapper = new ObjectMapper();
        xmlMapper = new XmlMapper();
    }

    @Test
    void loaderFile_throwReadFileException_WhenObjectNull() {
        String path = "price/price_kg.json";
        assertThrows(ReadFileException.class, () -> jackson.loaderFile(null, path));
    }

    @Test
    void loaderFile_throwReadFileException_WhenBadPath() {
        String path = "bad path";
        assertThrows(ReadFileException.class, () -> jackson.loaderFile(xmlMapper, path));
    }

    @Test
    void loaderFile_returnValueNotNullFromFileJson() {
        String path = "price/price_kg.json";
        assertNotNull(jackson.loaderFile(objectMapper, path));
    }

    @Test
    void loaderFile_returnValueNotNullFromFileXml() {
        String path = "price/price_kg.xml";
        assertNotNull(jackson.loaderFile(xmlMapper, path));
    }

    @Test
    void loaderFile_returnExceptionWhenIncorrectFieldToTheFileXml() {
        String path = "price_incorrect_field.json";
        assertThrows(IncorrectFileException.class, () -> jackson.loaderFile(objectMapper, path));
    }

    @Test
    void loaderFile_returnExceptionWhenIncorrectFieldToTheFileJson() {
        String path = "price_incorrect_field.xml";
        assertThrows(IncorrectFileException.class, () -> jackson.loaderFile(xmlMapper, path));
    }
}