package com.ayon.lombok.advanced;

import lombok.experimental.ExtensionMethod;
import java.util.Arrays;
import java.util.List;

@ExtensionMethod({Arrays.class, Extensions.class})
public class ExtensionMethodExample {

    public void demonstrateExtensions() {
        String text = "  Hello World  ";
        String reversed = text.reverse();
        System.out.println("Reversed: " + reversed);

        int[] numbers = {3, 1, 4, 1, 5, 9};
        numbers.sort();
        System.out.println("Sorted: " + Arrays.toString(numbers));

        List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
        String joined = list.joinWith(", ");
        System.out.println("Joined: " + joined);

        String empty = "";
        System.out.println("Is empty? " + empty.isNullOrEmpty());

        Integer number = 42;
        System.out.println("Is even? " + number.isEven());
        System.out.println("Is odd? " + number.isOdd());
    }

    public static void main(String[] args) {
        ExtensionMethodExample example = new ExtensionMethodExample();
        example.demonstrateExtensions();
    }
}

class Extensions {
    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static String joinWith(List<String> list, String delimiter) {
        return String.join(delimiter, list);
    }

    public static boolean isEven(Integer number) {
        return number != null && number % 2 == 0;
    }

    public static boolean isOdd(Integer number) {
        return number != null && number % 2 != 0;
    }
}