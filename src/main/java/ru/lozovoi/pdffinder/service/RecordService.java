package ru.lozovoi.pdffinder.service;

import org.springframework.stereotype.Service;
import ru.lozovoi.pdffinder.utils.FilesFinder;
import ru.lozovoi.pdffinder.utils.PdfConverter;

import java.io.IOException;
import java.util.List;

@Service
public class RecordService {

    PdfConverter pdfConverter;

    public RecordService(PdfConverter pdfConverter) {
        this.pdfConverter = pdfConverter;
    }

    public void getResult(String path) throws IOException {
        List<String> allPaths = FilesFinder.getAllPaths(path);
        allPaths.forEach(pdf-> pdfConverter.convert(pdf));
    }
}
