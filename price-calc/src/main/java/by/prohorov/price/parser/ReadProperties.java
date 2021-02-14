package by.prohorov.price.parser;

import by.prohorov.price.exception.ReadFileException;
import by.prohorov.price.kg.CostByPriceKgUseProperties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Artsiom Prokharau 10.02.2021
 */

public class ReadProperties {

    public Properties loaderPropertiesFile(String path) {
        Properties price = new Properties();
        ClassLoader classLoader = CostByPriceKgUseProperties.class.getClassLoader();
        try (InputStream is = classLoader.getResourceAsStream(path)) {
            price.load(is);
            return price;
        } catch (NullPointerException | IOException ex) {
            throw new ReadFileException("File not found. Please correct path to file. Current path => " + path);
        }
    }
}
