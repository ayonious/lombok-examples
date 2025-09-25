package com.ayon.lombok.value;

import lombok.Value;
import lombok.With;
import lombok.Builder;
import lombok.experimental.NonFinal;
import java.time.LocalDate;
import java.util.List;

@Value
public class ValueExample {
    String firstName;
    String lastName;
    int age;
    List<String> hobbies;

    public static void main(String[] args) {
        ValueExample person = new ValueExample("John", "Doe", 30, List.of("Reading", "Gaming"));

        System.out.println("Person: " + person);
        System.out.println("Full name: " + person.getFirstName() + " " + person.getLastName());

        ValueExample anotherPerson = new ValueExample("John", "Doe", 30, List.of("Reading", "Gaming"));
        System.out.println("Are they equal? " + person.equals(anotherPerson));
        System.out.println("Same hashcode? " + (person.hashCode() == anotherPerson.hashCode()));
    }
}

@Value
@Builder
class ImmutableProduct {
    String id;
    String name;
    double price;
    LocalDate manufacturingDate;

    @NonFinal
    String temporaryNote;
}

@Value
class Point2D {
    @With double x;
    @With double y;

    public double distance(Point2D other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static void main(String[] args) {
        Point2D point1 = new Point2D(3.0, 4.0);
        Point2D point2 = point1.withX(5.0);

        System.out.println("Original point: " + point1);
        System.out.println("Modified point: " + point2);
        System.out.println("Distance: " + point1.distance(point2));
    }
}