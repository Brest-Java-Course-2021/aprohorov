package by.prohorov;

import by.prohorov.calc.Calculate;
import by.prohorov.calc.CalculateImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by Artsiom Prokharau 05.02.2021
 */

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("ConfigSpring.xml");


        Calculate result = context.getBean("result", CalculateImpl.class);
        System.out.println("Cost Of Delivery = " + result.costOfDelivery());
    }
}
