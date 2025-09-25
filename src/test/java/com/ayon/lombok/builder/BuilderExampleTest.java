package com.ayon.lombok.builder;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class BuilderExampleTest {

    @Test
    void testBuilderWithAllFields() {
        BuilderExample person = BuilderExample.builder()
                .name("Alice")
                .age(30)
                .email("alice@example.com")
                .occupation("Software Engineer")
                .occupation("Tech Lead")
                .hobby("Reading")
                .hobby("Gaming")
                .build();

        assertThat(person.getName()).isEqualTo("Alice");
        assertThat(person.getAge()).isEqualTo(30);
        assertThat(person.getEmail()).isEqualTo("alice@example.com");
        assertThat(person.getOccupations()).containsExactlyInAnyOrder("Software Engineer", "Tech Lead");
        assertThat(person.getHobbies()).containsExactly("Reading", "Gaming");
    }

    @Test
    void testBuilderWithDefaultValues() {
        BuilderExample person = BuilderExample.builder()
                .age(25)
                .email("john@example.com")
                .build();

        assertThat(person.getName()).isEqualTo("John Doe");
        assertThat(person.getAge()).isEqualTo(25);
        assertThat(person.getOccupations()).isNotNull().isEmpty();
        assertThat(person.getHobbies()).isNotNull().isEmpty();
    }

    @Test
    void testSingularCollections() {
        BuilderExample person = BuilderExample.builder()
                .name("Bob")
                .age(28)
                .occupation("Developer")
                .occupation("Developer")
                .build();

        assertThat(person.getOccupations()).hasSize(1);
        assertThat(person.getOccupations()).contains("Developer");
    }

    @Test
    void testToString() {
        BuilderExample person = BuilderExample.builder()
                .name("Test")
                .age(20)
                .build();

        String result = person.toString();
        assertThat(result).contains("name=Test");
        assertThat(result).contains("age=20");
    }
}