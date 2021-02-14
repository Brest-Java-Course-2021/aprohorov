package by.prohorov.price.parser;

import by.prohorov.price.entity.Price;
import by.prohorov.price.exception.IncorrectFileException;
import by.prohorov.price.exception.ReadFileException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Artsiom Prokharau 09.02.2021
 */

public class Jackson {

    public <T extends ObjectMapper> Price loaderFile(T classParser, String path) {
        ClassLoader classLoader = Jackson.class.getClassLoader();
        try (InputStream ir = classLoader.getResourceAsStream(path)) {
            return classParser.readValue(ir, Price.class);
        } catch (JsonMappingException e) {
            throw new IncorrectFileException("File incorrect. Please correct the name field to file with the name => " + path);
        } catch (IllegalArgumentException | IOException ex) {
            throw new ReadFileException("File not found. Please correct path to file. Current path => " + path);
        } catch (NullPointerException ex) {
            throw new ReadFileException("ClassParser null. Please check  to classParser!\n" + ex.getLocalizedMessage());
        }
    }
}

