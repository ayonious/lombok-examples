package com.ayon.lombok.logging;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.assertj.core.api.Assertions.*;

class LoggingExampleTest {

    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
    }

    @Test
    void testLoggingMethods() {
        LoggingExample example = new LoggingExample();
        example.setName("TestLogger");

        assertThat(example.getName()).isEqualTo("TestLogger");

        assertThatCode(() -> example.doSomething())
            .doesNotThrowAnyException();
    }

    @Test
    void testPerformCalculation() {
        LoggingExample example = new LoggingExample();

        assertThatCode(() -> example.performCalculation(5, 10))
            .doesNotThrowAnyException();
    }

    @Test
    void testRiskyOperationHandlesExceptions() {
        LoggingExample example = new LoggingExample();

        assertThatCode(() -> {
            for (int i = 0; i < 10; i++) {
                example.doSomething();
            }
        }).doesNotThrowAnyException();
    }
}

class JavaUtilLoggingExampleTest {

    @Test
    void testJavaUtilLogging() {
        JavaUtilLoggingExample example = new JavaUtilLoggingExample();

        assertThatCode(() -> example.demonstrateJavaLogging())
            .doesNotThrowAnyException();
    }
}