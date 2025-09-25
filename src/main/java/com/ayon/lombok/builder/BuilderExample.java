package com.ayon.lombok.builder;

import lombok.Builder;
import lombok.ToString;
import lombok.Singular;
import lombok.Getter;
import java.util.Set;
import java.util.List;

@Builder
@ToString
@Getter
public class BuilderExample {
    @Builder.Default
    private String name = "John Doe";

    private int age;

    private String email;

    @Singular
    private Set<String> occupations;

    @Singular("hobby")
    private List<String> hobbies;

    public static void main(String[] args) {
        BuilderExample person = BuilderExample.builder()
                .name("Alice")
                .age(30)
                .email("alice@example.com")
                .occupation("Software Engineer")
                .occupation("Tech Lead")
                .hobby("Reading")
                .hobby("Gaming")
                .build();

        System.out.println(person);

        BuilderExample defaultPerson = BuilderExample.builder()
                .age(25)
                .build();
        System.out.println("With default name: " + defaultPerson);
    }
}