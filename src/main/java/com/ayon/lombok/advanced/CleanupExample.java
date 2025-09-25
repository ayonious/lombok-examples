package com.ayon.lombok.advanced;

import lombok.Cleanup;
import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class CleanupExample {

    public void readFileWithCleanup(String fileName) throws IOException {
        @Cleanup FileInputStream fis = new FileInputStream(fileName);
        @Cleanup InputStreamReader isr = new InputStreamReader(fis);
        @Cleanup BufferedReader reader = new BufferedReader(isr);

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }

    public void writeFileWithCleanup(String fileName, String content) throws IOException {
        @Cleanup FileWriter writer = new FileWriter(fileName);
        writer.write(content);
    }

    public void scannerExample() throws FileNotFoundException {
        @Cleanup Scanner scanner = new Scanner(new File("test.txt"));
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }

    public void customCloseMethodExample() throws Exception {
        @Cleanup("dispose") CustomResource resource = new CustomResource();
        resource.doSomething();
    }

    static class CustomResource {
        public void doSomething() {
            System.out.println("Using custom resource");
        }

        public void dispose() {
            System.out.println("Disposing custom resource");
        }
    }

    public static void main(String[] args) {
        CleanupExample example = new CleanupExample();

        try {
            String testFile = "cleanup-test.txt";
            example.writeFileWithCleanup(testFile, "Hello, @Cleanup!\nThis is a test.");
            System.out.println("Reading file with @Cleanup:");
            example.readFileWithCleanup(testFile);

            example.customCloseMethodExample();

            new File(testFile).delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}