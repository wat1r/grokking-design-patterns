package com.frankcooper.design.pattern.builders;

/**
 * @author: wangzhou(Frank Cooper)
 * @date: 2022/3/3 19:34
 * @description:
 */

import com.frankcooper.design.pattern.builders.cars.Car;
import com.frankcooper.design.pattern.builders.cars.Manual;
import com.frankcooper.design.pattern.builders.director.Director;

/**
 * Demo class. Everything comes together here.
 */
public class Demo {

    public static void main(String[] args) {
        Director director = new Director();

        // Director gets the concrete builder object from the client
        // (application code). That's because application knows better which
        // builder to use to get a specific product.
        CarBuilder builder = new CarBuilder();
        director.constructSportsCar(builder);

        // The final product is often retrieved from a builder object, since
        // Director is not aware and not dependent on concrete builders and
        // products.
        Car car = builder.getResult();
        System.out.println("Car built:\n" + car.getCarType());

        System.out.println("\nCar  built:\n" + car.print());

        System.out.println("\n----------------------\n");
        CarManualBuilder manualBuilder = new CarManualBuilder();

        // Director may know several building recipes.
        director.constructSportsCar(manualBuilder);
        Manual carManual = manualBuilder.getResult();
        System.out.println("\nCar manual built:\n" + carManual.print());
    }

}