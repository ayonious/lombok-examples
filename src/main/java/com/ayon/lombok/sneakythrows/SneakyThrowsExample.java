package com.ayon.lombok.sneakythrows;

import lombok.SneakyThrows;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SneakyThrowsExample {

    @SneakyThrows
    public String readFile(String fileName) {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    @SneakyThrows(IOException.class)
    public void writeFile(String fileName, String content) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
        }
    }

    @SneakyThrows
    public void sleepQuietly(int milliseconds) {
        Thread.sleep(milliseconds);
    }

    @SneakyThrows({IOException.class, ClassNotFoundException.class})
    public Object deserializeObject(byte[] data) {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(data);
             ObjectInputStream ois = new ObjectInputStream(bis)) {
            return ois.readObject();
        }
    }

    public static void main(String[] args) {
        SneakyThrowsExample example = new SneakyThrowsExample();

        example.sleepQuietly(100);
        System.out.println("Slept for 100ms without handling InterruptedException!");

        String testFile = "test-sneaky.txt";
        example.writeFile(testFile, "Hello, SneakyThrows!");
        System.out.println("File written without try-catch!");

        String content = example.readFile(testFile);
        System.out.println("File content: " + content);

        new File(testFile).delete();
    }
}