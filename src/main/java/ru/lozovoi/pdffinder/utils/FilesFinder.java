package ru.lozovoi.pdffinder.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FilesFinder {

    public FilesFinder(String path) {
        this.path = path;
    }

    String path;

    List<String> allPaths;

    public List<String> getAllPaths() throws IOException {
        Path dir = Paths.get(path);
        Files.walk(dir).forEach(path -> allPaths.add(String.valueOf(path)));
        return allPaths;
    }
}
