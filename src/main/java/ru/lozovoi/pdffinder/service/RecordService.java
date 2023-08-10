package ru.lozovoi.pdffinder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lozovoi.pdffinder.dao.HWNumberDAO;
import ru.lozovoi.pdffinder.dao.VinDataDAO;
import ru.lozovoi.pdffinder.model.VinData;
import ru.lozovoi.pdffinder.utils.FilesFinder;
import ru.lozovoi.pdffinder.utils.PdfConverter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecordService {

    PdfConverter pdfConverter;

    @Autowired
    VinDataDAO vinDataDAO;
    @Autowired
    HWNumberDAO hwNumberDAO;

    public RecordService(PdfConverter pdfConverter) {
        this.pdfConverter = pdfConverter;
    }

    //todo clean this
    public void getResult(String path) throws IOException {
        List<String> allPaths = FilesFinder.getAllPaths(path);
        allPaths.forEach(pdf -> pdfConverter.convert(pdf));

    }
}
