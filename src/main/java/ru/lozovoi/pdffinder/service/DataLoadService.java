package ru.lozovoi.pdffinder.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import ru.lozovoi.pdffinder.dao.CUnitDAO;
import ru.lozovoi.pdffinder.model.CUnit;
import ru.lozovoi.pdffinder.utils.PdfConverterUtil;
import ru.lozovoi.pdffinder.utils.RegexUtil;

import java.io.File;
import java.io.IOException;

@Slf4j
public class DataLoadService {

    @Autowired
    CUnitDAO cUnitDAO;

    public void getCUData(String file) throws IOException {
        RegexUtil regexUtil = new RegexUtil();
        try {
            PDDocument document = PDDocument.load(new File(file));
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);
            String[] split = text.split("_\\d");
            for (String s : split) {
                String thisCU = PdfConverterUtil.find(s,regexUtil.CU);
                if (thisCU != null) {
                    CUnit cUnit = new CUnit();
                    cUnit.setVariantCU(PdfConverterUtil.find(s, regexUtil.VARIANT_CU));
                    cUnit.setSoftware(PdfConverterUtil.find(s, regexUtil.SW));
                    cUnit.setHardware(PdfConverterUtil.find(s, regexUtil.HWNUM));
                    cUnit.setBootloader(PdfConverterUtil.find(s, regexUtil.BOOTLOADER));
                    cUnit.setScn(PdfConverterUtil.find(s, regexUtil.SCN));
                    cUnit.setName(PdfConverterUtil.find(s, thisCU));
                    log.info(cUnit.toString());
                }
            }
            document.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
