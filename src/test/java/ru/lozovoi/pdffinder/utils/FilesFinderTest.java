package ru.lozovoi.pdffinder.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.List;
class FilesFinderTest extends AbstractUtilTests {
    @Test
    void getAllPaths() throws IOException {
        List<String> allPaths = FilesFinder.getAllPaths(path);
        Assert.notNull(allPaths, "Package is empty");
    }
}