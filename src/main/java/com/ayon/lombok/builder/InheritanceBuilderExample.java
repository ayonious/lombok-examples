package com.ayon.lombok.builder;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@ToString
abstract class Vehicle {
    private final String brand;
    private final String model;
    private final int year;
}

@SuperBuilder
@Getter
@ToString(callSuper = true)
class Car extends Vehicle {
    private final int numberOfDoors;
    private final String fuelType;
}

@SuperBuilder
@Getter
@ToString(callSuper = true)
class Motorcycle extends Vehicle {
    private final boolean hasSidecar;
    private final String engineType;
}

public class InheritanceBuilderExample {
    public static void main(String[] args) {
        Car car = Car.builder()
                .brand("Toyota")
                .model("Camry")
                .year(2024)
                .numberOfDoors(4)
                .fuelType("Hybrid")
                .build();

        Motorcycle motorcycle = Motorcycle.builder()
                .brand("Harley-Davidson")
                .model("Street 750")
                .year(2023)
                .hasSidecar(false)
                .engineType("V-Twin")
                .build();

        System.out.println("Car: " + car);
        System.out.println("Motorcycle: " + motorcycle);
    }
}