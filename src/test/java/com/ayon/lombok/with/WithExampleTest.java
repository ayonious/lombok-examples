package com.ayon.lombok.with;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.*;

class WithExampleTest {

    @Test
    void testWithCreatesNewInstance() {
        LocalDate now = LocalDate.now();
        WithExample original = new WithExample("John Doe", 30, "john@example.com", now);
        WithExample modified = original.withName("Jane Doe");

        assertThat(original.getName()).isEqualTo("John Doe");
        assertThat(modified.getName()).isEqualTo("Jane Doe");
        assertThat(modified.getAge()).isEqualTo(original.getAge());
        assertThat(modified.getEmail()).isEqualTo(original.getEmail());
        assertThat(modified.getCreatedAt()).isEqualTo(original.getCreatedAt());
        assertThat(original).isNotSameAs(modified);
    }

    @Test
    void testChainingWithMethods() {
        LocalDate now = LocalDate.now();
        WithExample original = new WithExample("John", 25, "john@old.com", now);

        WithExample updated = original
            .withName("Jane")
            .withAge(26)
            .withEmail("jane@new.com");

        assertThat(updated.getName()).isEqualTo("Jane");
        assertThat(updated.getAge()).isEqualTo(26);
        assertThat(updated.getEmail()).isEqualTo("jane@new.com");
        assertThat(updated.getCreatedAt()).isEqualTo(now);
    }
}

class ProductTest {

    @Test
    void testApplyDiscount() {
        Product product = new Product(
            "PROD-001",
            "Laptop",
            new BigDecimal("1000.00"),
            10,
            LocalDate.now()
        );

        Product discountedProduct = product.applyDiscount(10);

        assertThat(product.getPrice()).isEqualTo(new BigDecimal("1000.00"));
        assertThat(discountedProduct.getPrice()).isEqualTo(new BigDecimal("900.00"));
        assertThat(discountedProduct.getId()).isEqualTo(product.getId());
        assertThat(discountedProduct.getName()).isEqualTo(product.getName());
        assertThat(discountedProduct.getQuantity()).isEqualTo(product.getQuantity());
    }

    @Test
    void testUpdateStock() {
        Product product = new Product(
            "PROD-002",
            "Mouse",
            new BigDecimal("25.99"),
            50,
            LocalDate.now()
        );

        Product updatedStock = product.updateStock(30);

        assertThat(product.getQuantity()).isEqualTo(50);
        assertThat(updatedStock.getQuantity()).isEqualTo(30);
        assertThat(updatedStock.getPrice()).isEqualTo(product.getPrice());
    }

    @Test
    void testChainedUpdates() {
        Product product = new Product(
            "PROD-003",
            "Keyboard",
            new BigDecimal("79.99"),
            20,
            LocalDate.now()
        );

        Product updated = product
            .withName("Mechanical Keyboard")
            .withPrice(new BigDecimal("129.99"))
            .withQuantity(15);

        assertThat(updated.getName()).isEqualTo("Mechanical Keyboard");
        assertThat(updated.getPrice()).isEqualTo(new BigDecimal("129.99"));
        assertThat(updated.getQuantity()).isEqualTo(15);
        assertThat(updated.getId()).isEqualTo(product.getId());
    }
}

class ConfigurationTest {

    @Test
    void testWithDefaults() {
        Configuration config = new Configuration("localhost", 3000, false, 5000);
        Configuration withDefaults = config.withDefaults();

        assertThat(withDefaults.getServerUrl()).isEqualTo("localhost");
        assertThat(withDefaults.getPort()).isEqualTo(8080);
        assertThat(withDefaults.isEnableSsl()).isTrue();
        assertThat(withDefaults.getTimeout()).isEqualTo(30000);
    }

    @Test
    void testProductionConfig() {
        Configuration config = new Configuration("dev.local", 3000, false, 10000);
        Configuration productionConfig = config
            .withServerUrl("api.production.com")
            .withDefaults();

        assertThat(productionConfig.getServerUrl()).isEqualTo("api.production.com");
        assertThat(productionConfig.getPort()).isEqualTo(8080);
        assertThat(productionConfig.isEnableSsl()).isTrue();
        assertThat(productionConfig.getTimeout()).isEqualTo(30000);
    }
}