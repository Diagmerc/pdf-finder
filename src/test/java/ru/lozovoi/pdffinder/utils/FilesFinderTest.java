package ru.lozovoi.pdffinder.utils;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilesFinderTest {

    String path = "C:\\Users\\User\\Desktop\\Short tests";

    @Test
    void getAllPaths() throws IOException {
        Path dir = Paths.get(path);
        List<String> allPaths = new ArrayList<>();
        Files.walk(dir).forEach(path -> allPaths.add(String.valueOf(path)));
        Assert.notNull(allPaths, "Object is null");
    }
}