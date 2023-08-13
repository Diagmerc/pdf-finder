package ru.lozovoi.pdffinder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lozovoi.pdffinder.dao.HWNumberDAO;
import ru.lozovoi.pdffinder.dao.VinDataDAO;
import ru.lozovoi.pdffinder.utils.FilesFinder;
import ru.lozovoi.pdffinder.utils.PdfConverterUtil;

import java.io.IOException;
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
        allPaths.forEach(doc -> vinDataDAO.saveAll(PdfConverterUtil.convert(doc)));
    }
}
