package by.prohorov;

import by.prohorov.calc.Calculate;
import by.prohorov.calc.CalculateImpl;
import by.prohorov.price.kg.CostByPriceKgUseEnum;
import by.prohorov.price.kg.CostByPriceKgUseFileJson;
import by.prohorov.price.kg.CostByPriceKgUseFileXml;
import by.prohorov.price.kg.CostByPriceKgUseProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by Artsiom Prokharau 05.02.2021
 */

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("ConfigSpring.xml");


        Calculate result =  context.getBean("result",CalculateImpl.class);
        System.out.println("Cost Of Delivery = " + result.costOfDelivery());
    }
}
