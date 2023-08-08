package ru.lozovoi.pdffinder.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class FilesFinder {
    public static List<String> getAllPaths(String path) throws IOException {
        Path dir = Paths.get(path);
        List<String> allPdf = new ArrayList<>();
        Files.walk(dir)
                .forEach(path1 -> allPdf.add(String.valueOf(path1)));
        List<String> pdf = allPdf.stream().filter(path1 -> path1.endsWith("pdf"))
                .toList();
        return pdf;
    }
}
