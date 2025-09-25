package com.ayon.lombok.builder;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class InheritanceBuilderExampleTest {

    @Test
    void testCarBuilder() {
        Car car = Car.builder()
                .brand("Toyota")
                .model("Camry")
                .year(2024)
                .numberOfDoors(4)
                .fuelType("Hybrid")
                .build();

        assertThat(car.getBrand()).isEqualTo("Toyota");
        assertThat(car.getModel()).isEqualTo("Camry");
        assertThat(car.getYear()).isEqualTo(2024);
        assertThat(car.getNumberOfDoors()).isEqualTo(4);
        assertThat(car.getFuelType()).isEqualTo("Hybrid");
    }

    @Test
    void testMotorcycleBuilder() {
        Motorcycle motorcycle = Motorcycle.builder()
                .brand("Harley-Davidson")
                .model("Street 750")
                .year(2023)
                .hasSidecar(false)
                .engineType("V-Twin")
                .build();

        assertThat(motorcycle.getBrand()).isEqualTo("Harley-Davidson");
        assertThat(motorcycle.getModel()).isEqualTo("Street 750");
        assertThat(motorcycle.getYear()).isEqualTo(2023);
        assertThat(motorcycle.isHasSidecar()).isFalse();
        assertThat(motorcycle.getEngineType()).isEqualTo("V-Twin");
    }

    @Test
    void testToStringIncludesParentFields() {
        Car car = Car.builder()
                .brand("Honda")
                .model("Civic")
                .year(2023)
                .numberOfDoors(2)
                .fuelType("Gasoline")
                .build();

        String result = car.toString();
        assertThat(result).contains("brand=Honda");
        assertThat(result).contains("model=Civic");
        assertThat(result).contains("year=2023");
        assertThat(result).contains("numberOfDoors=2");
        assertThat(result).contains("fuelType=Gasoline");
    }
}