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

    public static Price loaderXmlFile() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        ClassLoader classLoader = Jackson.class.getClassLoader();
        InputStream ir = classLoader.getResourceAsStream("price/price_kg.xml");
        return xmlMapper.readValue(ir, Price.class);
    }

    public static Price loaderJsonFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ClassLoader classLoader = Jackson.class.getClassLoader();
        InputStream ir = classLoader.getResourceAsStream("price/price_kg.json");
        return objectMapper.readValue(ir, Price.class);

    }
}
