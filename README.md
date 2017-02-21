# Simplest maven project to test Basic features of Lombok

This is a single java project where I practiced lombok. You will find the example running commands in `App.java` file

## Setup for intellij

If you are using intellij, need to activate annotations processor:
    Settings -> Compiler -> Annotation Processors

Now install lombok plugin:

    Preferences -> Plugins
    Click Browse repositories...
    Search for "Lombok Plugin"
    Install
    Restart IntelliJ


See the pom.xml file to see what line is doing what

## Simple commands to try with maven

### Create jar file for maven:
```
mvn package
```

### Run maven project:
```
mvn exec:java -Dexec.mainClass="com.ayon.app.App"
```


Project structure:
```
.
├── README.md
├── pom.xml
└── src
    └── main
        └── java
            └── com
                └── ayon
                    ├── app
                    │   └── App.java
                    └── lombok
                        ├── ex1
                        │   └── LombokExample.java
                        ├── ex2
                        │   └── LombokExample2.java
                        ├── ex3
                        │   └── LombokExample3.java
                        ├── ex4
                        │   └── LombokExample4.java
                        ├── ex5
                        │   └── LombokExample5.java
                        └── ex6
                            └── LombokExample6.java
```
