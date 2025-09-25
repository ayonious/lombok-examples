package com.ayon.lombok.sneakythrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Files;
import static org.assertj.core.api.Assertions.*;

class SneakyThrowsExampleTest {

    @TempDir
    Path tempDir;

    @Test
    void testReadAndWriteFile() throws IOException {
        SneakyThrowsExample example = new SneakyThrowsExample();
        Path tempFile = tempDir.resolve("test.txt");
        String testContent = "Hello, SneakyThrows Testing!";

        example.writeFile(tempFile.toString(), testContent);
        String readContent = example.readFile(tempFile.toString());

        assertThat(readContent).isEqualTo(testContent);
    }

    @Test
    void testSleepQuietly() {
        SneakyThrowsExample example = new SneakyThrowsExample();
        long startTime = System.currentTimeMillis();

        example.sleepQuietly(50);

        long endTime = System.currentTimeMillis();
        assertThat(endTime - startTime).isGreaterThanOrEqualTo(50);
    }

    @Test
    void testReadNonExistentFile() {
        SneakyThrowsExample example = new SneakyThrowsExample();

        assertThatThrownBy(() -> example.readFile("/non/existent/file.txt"))
            .isInstanceOf(Exception.class);
    }

    @Test
    void testDeserializeObject() throws IOException {
        SneakyThrowsExample example = new SneakyThrowsExample();
        String testString = "Test Object";

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(testString);
        }

        Object deserialized = example.deserializeObject(bos.toByteArray());

        assertThat(deserialized).isEqualTo(testString);
    }

    @Test
    void testDeserializeInvalidData() {
        SneakyThrowsExample example = new SneakyThrowsExample();
        byte[] invalidData = "invalid".getBytes();

        assertThatThrownBy(() -> example.deserializeObject(invalidData))
            .isInstanceOf(Exception.class);
    }
}