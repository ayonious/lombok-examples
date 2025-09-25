package com.ayon.lombok.value;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class ValueExampleTest {

    @Test
    void testValueObjectIsImmutable() {
        ValueExample person = new ValueExample("John", "Doe", 30, List.of("Reading"));

        assertThat(person.getFirstName()).isEqualTo("John");
        assertThat(person.getLastName()).isEqualTo("Doe");
        assertThat(person.getAge()).isEqualTo(30);
        assertThat(person.getHobbies()).containsExactly("Reading");
    }

    @Test
    void testEqualsAndHashCode() {
        ValueExample person1 = new ValueExample("John", "Doe", 30, List.of("Reading", "Gaming"));
        ValueExample person2 = new ValueExample("John", "Doe", 30, List.of("Reading", "Gaming"));
        ValueExample person3 = new ValueExample("Jane", "Doe", 30, List.of("Reading", "Gaming"));

        assertThat(person1).isEqualTo(person2);
        assertThat(person1.hashCode()).isEqualTo(person2.hashCode());
        assertThat(person1).isNotEqualTo(person3);
    }

    @Test
    void testToString() {
        ValueExample person = new ValueExample("Alice", "Smith", 25, List.of("Coding"));

        String result = person.toString();
        assertThat(result).contains("firstName=Alice");
        assertThat(result).contains("lastName=Smith");
        assertThat(result).contains("age=25");
    }
}

class Point2DTest {

    @Test
    void testWithAnnotation() {
        Point2D point1 = new Point2D(3.0, 4.0);
        Point2D point2 = point1.withX(5.0);
        Point2D point3 = point2.withY(6.0);

        assertThat(point1.getX()).isEqualTo(3.0);
        assertThat(point1.getY()).isEqualTo(4.0);

        assertThat(point2.getX()).isEqualTo(5.0);
        assertThat(point2.getY()).isEqualTo(4.0);

        assertThat(point3.getX()).isEqualTo(5.0);
        assertThat(point3.getY()).isEqualTo(6.0);

        assertThat(point1).isNotSameAs(point2);
        assertThat(point2).isNotSameAs(point3);
    }

    @Test
    void testDistance() {
        Point2D point1 = new Point2D(0, 0);
        Point2D point2 = new Point2D(3, 4);

        double distance = point1.distance(point2);
        assertThat(distance).isEqualTo(5.0);
    }

    @Test
    void testEquality() {
        Point2D point1 = new Point2D(1.5, 2.5);
        Point2D point2 = new Point2D(1.5, 2.5);
        Point2D point3 = new Point2D(1.5, 3.5);

        assertThat(point1).isEqualTo(point2);
        assertThat(point1).isNotEqualTo(point3);
    }
}