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

    @Autowired
    VinDataDAO vinDataDAO;
    @Autowired
    HWNumberDAO hwNumberDAO;

    //todo clean this
    public void getResult(String path) throws IOException {
        List<String> allPaths = FilesFinder.getAllPaths(path);
        ArrayList<String> docs = new ArrayList<>();
        allPaths.forEach(pdf -> docs.add(PdfConverter.convert(pdf).toString()));
        for (String doc : docs) {
            VinData vinData = new VinData();
            vinData.setVin(doc);
            vinDataDAO.save(vinData);
        }
    }
}
