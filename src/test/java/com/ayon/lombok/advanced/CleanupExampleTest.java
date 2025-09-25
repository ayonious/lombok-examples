package com.ayon.lombok.advanced;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.assertj.core.api.Assertions.*;

class CleanupExampleTest {

    @TempDir
    Path tempDir;

    @Test
    void testWriteAndReadFile() throws IOException {
        CleanupExample example = new CleanupExample();
        Path tempFile = tempDir.resolve("test.txt");
        String content = "Test content for @Cleanup";

        example.writeFileWithCleanup(tempFile.toString(), content);

        String readContent = Files.readString(tempFile);
        assertThat(readContent).isEqualTo(content);
    }

    @Test
    void testReadFileWithCleanup() throws IOException {
        CleanupExample example = new CleanupExample();
        Path tempFile = tempDir.resolve("read-test.txt");
        String content = "Line 1\nLine 2\nLine 3";
        Files.writeString(tempFile, content);

        assertThatCode(() -> example.readFileWithCleanup(tempFile.toString()))
            .doesNotThrowAnyException();
    }

    @Test
    void testCustomCloseMethod() {
        CleanupExample example = new CleanupExample();

        assertThatCode(() -> example.customCloseMethodExample())
            .doesNotThrowAnyException();
    }

    @Test
    void testCustomResourceDispose() {
        CleanupExample.CustomResource resource = new CleanupExample.CustomResource();

        assertThatCode(() -> {
            resource.doSomething();
            resource.dispose();
        }).doesNotThrowAnyException();
    }

    @Test
    void testReadNonExistentFile() {
        CleanupExample example = new CleanupExample();
        String nonExistentFile = tempDir.resolve("non-existent.txt").toString();

        assertThatThrownBy(() -> example.readFileWithCleanup(nonExistentFile))
            .isInstanceOf(IOException.class);
    }
}