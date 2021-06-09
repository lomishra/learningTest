/*
 * lokesh
 */

package com.cisco.first.module.design;

public class CarType {
    public static void main(String[] args) {

    FactoryDesing factoryDesing = new FactoryDesing();
    factoryDesing.getCarType("Honda").carType();
    factoryDesing.getCarType("Audi").carType();

    }
}
