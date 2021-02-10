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

    private static final String PATH_PROPERTIES = "price/price_kg.properties";

    public Properties loaderPropertiesFile() {
        Properties price = new Properties();
        ClassLoader classLoader = CostByPriceKgUseProperties.class.getClassLoader();
        try (InputStream is = classLoader.getResourceAsStream(PATH_PROPERTIES)) {
            if (is == null) {
                throw new ReadFileException("File not Found");
            }
            price.load(is);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return price;
    }
}
