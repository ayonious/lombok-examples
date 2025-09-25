package com.ayon.lombok.with;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.With;
import lombok.Value;
import java.time.LocalDate;
import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@ToString
public class WithExample {
    @With private final String name;
    @With private final int age;
    @With private final String email;
    private final LocalDate createdAt;

    public static void main(String[] args) {
        WithExample person = new WithExample(
            "John Doe",
            30,
            "john@example.com",
            LocalDate.now()
        );

        System.out.println("Original: " + person);

        WithExample updatedPerson = person
            .withName("Jane Doe")
            .withAge(25)
            .withEmail("jane@example.com");

        System.out.println("Updated: " + updatedPerson);
        System.out.println("Original unchanged: " + person);
    }
}

@Value
class Product {
    @With String id;
    @With String name;
    @With BigDecimal price;
    @With int quantity;
    LocalDate lastUpdated;

    public Product applyDiscount(double percentage) {
        BigDecimal discountedPrice = price.multiply(
            BigDecimal.valueOf(1 - percentage / 100)
        ).setScale(2, BigDecimal.ROUND_HALF_UP);
        return this.withPrice(discountedPrice);
    }

    public Product updateStock(int newQuantity) {
        return this.withQuantity(newQuantity);
    }

    public static void main(String[] args) {
        Product product = new Product(
            "PROD-001",
            "Laptop",
            new BigDecimal("999.99"),
            10,
            LocalDate.now()
        );

        System.out.println("Original product: " + product);

        Product discountedProduct = product.applyDiscount(15);
        System.out.println("After 15% discount: " + discountedProduct);

        Product updatedStock = discountedProduct.updateStock(5);
        System.out.println("After stock update: " + updatedStock);

        Product chainedUpdate = product
            .withName("Gaming Laptop")
            .withPrice(new BigDecimal("1299.99"))
            .withQuantity(20);
        System.out.println("Chained updates: " + chainedUpdate);
    }
}

@AllArgsConstructor
@Getter
@ToString
class Configuration {
    @With private final String serverUrl;
    @With private final int port;
    @With private final boolean enableSsl;
    @With private final int timeout;

    public Configuration withDefaults() {
        return this
            .withPort(8080)
            .withEnableSsl(true)
            .withTimeout(30000);
    }

    public static void main(String[] args) {
        Configuration config = new Configuration(
            "localhost",
            3000,
            false,
            10000
        );

        System.out.println("Initial config: " + config);

        Configuration productionConfig = config
            .withServerUrl("api.production.com")
            .withDefaults();

        System.out.println("Production config: " + productionConfig);
    }
}