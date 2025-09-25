package com.ayon.lombok.advanced;

import lombok.experimental.Delegate;
import java.util.*;

public class DelegateExample implements Collection<String> {

    @Delegate
    private final List<String> list = new ArrayList<>();

    public void demonstrateDelegate() {
        add("Apple");
        add("Banana");
        add("Cherry");

        System.out.println("Size: " + size());
        System.out.println("Contains 'Banana': " + contains("Banana"));
        System.out.println("Items: " + this);

        remove("Banana");
        System.out.println("After removal: " + this);
    }

    public static void main(String[] args) {
        DelegateExample example = new DelegateExample();
        example.demonstrateDelegate();
    }
}

interface Calculator {
    int add(int a, int b);
    int subtract(int a, int b);
    int multiply(int a, int b);
    int divide(int a, int b);
}

class BasicCalculator implements Calculator {
    public int add(int a, int b) { return a + b; }
    public int subtract(int a, int b) { return a - b; }
    public int multiply(int a, int b) { return a * b; }
    public int divide(int a, int b) { return a / b; }
}

class AdvancedCalculator implements Calculator {
    @Delegate
    private final Calculator basicCalc = new BasicCalculator();

    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public double sqrt(double value) {
        return Math.sqrt(value);
    }

    public static void main(String[] args) {
        AdvancedCalculator calc = new AdvancedCalculator();

        System.out.println("Basic operations (delegated):");
        System.out.println("10 + 5 = " + calc.add(10, 5));
        System.out.println("10 - 5 = " + calc.subtract(10, 5));
        System.out.println("10 * 5 = " + calc.multiply(10, 5));
        System.out.println("10 / 5 = " + calc.divide(10, 5));

        System.out.println("\nAdvanced operations:");
        System.out.println("2^10 = " + calc.power(2, 10));
        System.out.println("√144 = " + calc.sqrt(144));
    }
}

class ExcludeDelegateExample implements Collection<String> {
    @Delegate
    private final Set<String> set = new HashSet<>();

    public void demonstrate() {
        add("Item1");
        add("Item2");
        add("Item1");

        System.out.println("Set size: " + set.size());
    }
}