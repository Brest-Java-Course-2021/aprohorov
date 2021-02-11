package by.prohorov.price.parser;

import by.prohorov.price.entity.Price;
import by.prohorov.price.exception.ReadFileException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Artsiom Prokharau 09.02.2021
 */

public class Jackson {

    public <T extends ObjectMapper> Price loaderFile(T clazzParser, String path) {
        ClassLoader classLoader = Jackson.class.getClassLoader();
        try (InputStream ir = classLoader.getResourceAsStream(path)) {
            return clazzParser.readValue(ir, Price.class);
        } catch (IllegalArgumentException | IOException e) {
            throw new ReadFileException("File not found. Please correct path to file. Current path => " + path);
        }
    }
}

