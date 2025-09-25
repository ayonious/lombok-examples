package com.ayon.lombok.advanced;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.ToString;

@Accessors(fluent = true)
@Getter
@Setter
@ToString
public class AccessorsExample {
    private String name;
    private int age;
    private String email;

    public static void main(String[] args) {
        AccessorsExample person = new AccessorsExample()
            .name("John Doe")
            .age(30)
            .email("john@example.com");

        System.out.println("Person: " + person);
        System.out.println("Name: " + person.name());
        System.out.println("Age: " + person.age());
    }
}

@Accessors(chain = true)
@Getter
@Setter
@ToString
class ChainedAccessors {
    private String firstName;
    private String lastName;
    private int score;

    public static void main(String[] args) {
        ChainedAccessors obj = new ChainedAccessors()
            .setFirstName("Jane")
            .setLastName("Smith")
            .setScore(95);

        System.out.println("Chained: " + obj);
    }
}

@Accessors(prefix = {"m", "is"})
@Getter
@Setter
@ToString
class PrefixedAccessors {
    private String mName;
    private int mAge;
    private boolean isActive;
    private String mEmail;

    public static void main(String[] args) {
        PrefixedAccessors obj = new PrefixedAccessors();
        obj.setName("Bob");
        obj.setAge(25);
        obj.setActive(true);
        obj.setEmail("bob@example.com");

        System.out.println("Name: " + obj.getName());
        System.out.println("Active: " + obj.isActive());
        System.out.println("Object: " + obj);
    }
}

@Accessors(fluent = true, chain = true, makeFinal = true)
@Getter
@Setter
@ToString
class CombinedAccessors {
    private String id;
    private String type;
    private double value;

    public CombinedAccessors initialize() {
        return this
            .id("ID-001")
            .type("Premium")
            .value(99.99);
    }

    public static void main(String[] args) {
        CombinedAccessors obj = new CombinedAccessors()
            .initialize();

        System.out.println("Combined accessors: " + obj);
        System.out.println("ID: " + obj.id());
        System.out.println("Type: " + obj.type());
        System.out.println("Value: " + obj.value());
    }
}