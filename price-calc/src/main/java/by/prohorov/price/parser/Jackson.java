package by.prohorov.price.parser;

import by.prohorov.price.entity.Price;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Artsiom Prokharau 09.02.2021
 */

public class Jackson {

    private String pathXml = "price/price_kg.xml";
    private String pathJson = "price/price_kg.json";

    public Price loaderXmlFile() {
        XmlMapper xmlMapper = new XmlMapper();
        ClassLoader classLoader = Jackson.class.getClassLoader();
        InputStream ir = classLoader.getResourceAsStream(pathXml);
        try {
            return xmlMapper.readValue(ir, Price.class);
            //Todo refactor
        } catch (IOException e) {
            System.err.println("File not found");
        }
        return null;
    }

    public Price loaderJsonFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        ClassLoader classLoader = Jackson.class.getClassLoader();
        try (InputStream ir = classLoader.getResourceAsStream(pathJson)) {
            return objectMapper.readValue(ir, Price.class);
            //Todo refactor
        } catch (IOException e) {
            System.err.println("File not found");
        }
        return null;
    }
}
