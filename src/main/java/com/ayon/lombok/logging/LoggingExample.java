package com.ayon.lombok.logging;

import lombok.extern.slf4j.Slf4j;
import lombok.extern.java.Log;
import lombok.Getter;
import lombok.Setter;

@Slf4j
public class LoggingExample {

    @Getter @Setter
    private String name;

    public void doSomething() {
        log.debug("Debug message - doing something");
        log.info("Info message - operation started");
        log.warn("Warning message - something might be wrong");

        try {
            riskyOperation();
        } catch (Exception e) {
            log.error("Error occurred during risky operation", e);
        }
    }

    private void riskyOperation() throws Exception {
        log.trace("Entering risky operation");
        if (Math.random() > 0.5) {
            throw new RuntimeException("Random failure!");
        }
        log.trace("Exiting risky operation successfully");
    }

    public void performCalculation(int a, int b) {
        log.info("Performing calculation with a={} and b={}", a, b);
        int result = a + b;
        log.info("Calculation result: {}", result);
    }

    public static void main(String[] args) {
        LoggingExample example = new LoggingExample();
        example.setName("TestLogger");

        log.info("Starting application with name: {}", example.getName());
        example.doSomething();
        example.performCalculation(5, 10);
        log.info("Application finished");
    }
}

@Log
class JavaUtilLoggingExample {

    public void demonstrateJavaLogging() {
        log.fine("Fine level message");
        log.info("Info level message from java.util.logging");
        log.warning("Warning level message");
        log.severe("Severe level message");

        log.info(String.format("Formatted message: %s %d", "Number", 42));
    }

    public static void main(String[] args) {
        JavaUtilLoggingExample example = new JavaUtilLoggingExample();
        example.demonstrateJavaLogging();
    }
}