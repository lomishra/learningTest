/*
 * lokesh
 */

package com.cisco.first.module.design;

public class FactoryDesing {

    public Car getCarType(String carType) {
        Car car =null;
        if (carType.equals("Honda")) {
             car = new Honda();
        } else if (carType.equals("Audi")) {
             car = new Audi();
        } else if (carType.equals("Totota")) {
             car = new Totota();

        }
        return  car;
    }
}
