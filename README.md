# Lombok Examples

A comprehensive collection of examples demonstrating Project Lombok features with Java 21.

## 📋 Table of Contents

- [Overview](#overview)
- [Requirements](#requirements)
- [Installation](#installation)
- [Lombok Annotations Examples](#lombok-annotations-examples)
  - [Builder Pattern](#builder-pattern)
  - [SneakyThrows](#sneakythrows)
  - [Value Objects](#value-objects)
  - [Logging](#logging)
  - [Synchronization](#synchronization)
  - [With Annotation](#with-annotation)
  - [Advanced Features](#advanced-features)
- [Running the Examples](#running-the-examples)
- [Testing](#testing)

## Overview

This repository contains practical examples of Project Lombok annotations that reduce boilerplate code in Java applications. Each example includes documentation and unit tests.

## Requirements

- Java 21 or higher
- Maven 3.6+
- Lombok 1.18.36

## Installation

```bash
git clone https://github.com/ayonious/lombok-examples.git
cd lombok-examples
mvn clean install
```

## Lombok Annotations Examples

### Builder Pattern

📁 `src/main/java/com/ayon/lombok/builder/`

#### @Builder
Creates a builder pattern for object construction with a fluent API.

**Features:**
- Fluent interface for object creation
- `@Builder.Default` for default values
- `@Singular` for collection fields
- Support for inheritance with `@SuperBuilder`

```java
@Builder
public class BuilderExample {
    @Builder.Default
    private String name = "John Doe";

    @Singular
    private Set<String> occupations;
}
```

**Examples:**
- `BuilderExample.java` - Basic builder with defaults and singular collections
- `InheritanceBuilderExample.java` - Inheritance with @SuperBuilder

### SneakyThrows

📁 `src/main/java/com/ayon/lombok/sneakythrows/`

#### @SneakyThrows
Allows throwing checked exceptions without declaring them.

**Features:**
- Eliminates try-catch boilerplate
- Can specify specific exceptions
- Useful for lambda expressions

```java
@SneakyThrows
public String readFile(String fileName) {
    return new String(Files.readAllBytes(Paths.get(fileName)));
}
```

**Examples:**
- `SneakyThrowsExample.java` - File I/O and threading without explicit exception handling

### Value Objects

📁 `src/main/java/com/ayon/lombok/value/`

#### @Value
Creates immutable value objects with all fields private final.

**Features:**
- All fields are `private final` by default
- Generates constructor, getters, equals, hashCode, and toString
- Can be combined with `@With` for creating modified copies
- `@NonFinal` to exclude specific fields from being final

```java
@Value
public class ValueExample {
    String firstName;
    String lastName;
    int age;
}
```

**Examples:**
- `ValueExample.java` - Immutable objects, Point2D with distance calculation

### Logging

📁 `src/main/java/com/ayon/lombok/logging/`

#### @Slf4j and Other Logging Annotations
Automatically generates a logger field.

**Supported Loggers:**
- `@Slf4j` - SLF4J logger
- `@Log` - java.util.logging
- `@Log4j` - Apache Log4j
- `@Log4j2` - Apache Log4j 2
- `@CommonsLog` - Apache Commons Logging

```java
@Slf4j
public class LoggingExample {
    public void doSomething() {
        log.info("Info message");
        log.debug("Debug message");
    }
}
```

**Examples:**
- `LoggingExample.java` - SLF4J and java.util.logging examples

### Synchronization

📁 `src/main/java/com/ayon/lombok/sync/`

#### @Synchronized
Safer alternative to synchronized keyword.

**Features:**
- Creates private lock objects automatically
- Support for named locks
- Works with static and instance methods

```java
@Synchronized
public void incrementCounter() {
    counter++;
}

@Synchronized("writeLock")
public void addMessage(String message) {
    messages.add(message);
}
```

**Examples:**
- `SynchronizedExample.java` - Thread-safe operations with different lock strategies

### With Annotation

📁 `src/main/java/com/ayon/lombok/with/`

#### @With
Creates withX methods for immutable object modification.

**Features:**
- Creates new instances with modified field values
- Maintains immutability
- Supports method chaining

```java
@AllArgsConstructor
@Getter
public class WithExample {
    @With private final String name;
    @With private final int age;
}
```

**Examples:**
- `WithExample.java` - Immutable updates, product pricing, configuration management

### Advanced Features

📁 `src/main/java/com/ayon/lombok/advanced/`

#### @Cleanup
Automatic resource management without try-with-resources.

```java
@Cleanup FileInputStream fis = new FileInputStream(fileName);
@Cleanup("dispose") CustomResource resource = new CustomResource();
```

#### @Accessors
Customizes getter/setter generation and behavior.

**Options:**
- `fluent` - Removes get/set prefixes
- `chain` - Returns this for chaining
- `prefix` - Handles field naming conventions

```java
@Accessors(fluent = true, chain = true)
@Getter @Setter
public class AccessorsExample {
    private String name;
}
```

#### @ExtensionMethod
Adds extension methods to existing classes (experimental).

```java
@ExtensionMethod({Arrays.class, Extensions.class})
public class ExtensionMethodExample {
    // Can use custom methods as if they were part of the class
}
```

#### @Delegate
Implements delegation pattern automatically (experimental).

```java
public class DelegateExample implements Collection<String> {
    @Delegate
    private final List<String> list = new ArrayList<>();
}
```

**Examples:**
- `CleanupExample.java` - Resource management
- `AccessorsExample.java` - Fluent interfaces and method chaining
- `ExtensionMethodExample.java` - Extension methods
- `DelegateExample.java` - Delegation pattern

## Legacy Examples

The original examples from the initial project are preserved:

### Basic Annotations

📁 `src/main/java/com/ayon/lombok/ex1-ex8/`

**Annotations covered:**
- `@Getter` - Generates getter methods
- `@Setter` - Generates setter methods
- `@EqualsAndHashCode(of = {"field1", "field2"})` - Customized equals/hashCode
- `@ToString(exclude = "field")` - Customized toString
- `@RequiredArgsConstructor` - Constructor for final fields
- `@NoArgsConstructor` - Empty constructor
- `@AllArgsConstructor` - Constructor for all fields

## Running the Examples

Each example class contains a main method for demonstration:

```bash
# Run a specific example
mvn exec:java -Dexec.mainClass="com.ayon.lombok.builder.BuilderExample"

# Run the original App
mvn exec:java -Dexec.mainClass="com.ayon.app.App"

# Compile all examples
mvn compile

# Run all tests
mvn test
```

## Testing

Tests are located in `src/test/java/` and use JUnit 5 and AssertJ.

```bash
# Run all tests
mvn test

# Run a specific test class
mvn test -Dtest=BuilderExampleTest

# Run with coverage
mvn clean test jacoco:report
```

## Project Structure

```
lombok-examples/
├── src/
│   ├── main/java/com/ayon/
│   │   ├── app/
│   │   │   └── App.java          # Original main application
│   │   └── lombok/
│   │       ├── builder/          # Builder pattern examples
│   │       ├── sneakythrows/     # Exception handling
│   │       ├── value/            # Immutable objects
│   │       ├── logging/          # Logging annotations
│   │       ├── sync/             # Synchronization
│   │       ├── with/             # With annotation
│   │       ├── advanced/         # Advanced features
│   │       └── ex1-ex8/          # Original examples
│   └── test/java/com/ayon/lombok/
│       └── ...                   # Unit tests
├── pom.xml
└── README.md
```

## IDE Setup

### IntelliJ IDEA
1. Install Lombok plugin: Preferences → Plugins → Search "Lombok Plugin"
2. Enable annotation processing: Settings → Build → Compiler → Annotation Processors → Enable annotation processing
3. Restart IntelliJ IDEA

### Eclipse
1. Download lombok.jar from https://projectlombok.org/
2. Run: `java -jar lombok.jar`
3. Follow the installation wizard
4. Restart Eclipse

### VS Code
1. Install Extension Pack for Java
2. Lombok support is included automatically

## Best Practices

1. **Use @Value for DTOs** - Creates truly immutable objects
2. **Prefer @Builder for complex constructors** - More readable than telescoping constructors
3. **Use @Slf4j for consistent logging** - Reduces logger boilerplate
4. **@SneakyThrows sparingly** - Can hide important exceptions
5. **Combine annotations thoughtfully** - @Value + @Builder works well together
6. **Test generated code** - Ensure Lombok generates what you expect

## Troubleshooting

### Common Issues

- **Compilation errors**: Ensure annotation processing is enabled in your IDE
- **IDE not recognizing methods**: Install and enable Lombok plugin
- **Version conflicts**: Check lombok version compatibility with Java version
- **Maven build fails**: Run `mvn clean` before `mvn install`

## License

MIT License - see LICENSE file for details

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.