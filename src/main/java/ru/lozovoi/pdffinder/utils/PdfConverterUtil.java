package ru.lozovoi.pdffinder.utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Component;
import ru.lozovoi.pdffinder.model.HWNumber;
import ru.lozovoi.pdffinder.model.VinData;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component//todo clean this
public class PdfConverterUtil {
    static String VIN = "Идентификационный номер а/м";
    static String HWnum = "901 ";

    public static List<VinData> convert(String file) {
        ArrayList<VinData> vins = new ArrayList<>();
        try {
            PDDocument document = PDDocument.load(new File(file));
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);

            Pattern pattern = Pattern.compile(HWnum);
            Matcher matcherHW = pattern.matcher(text);

            //ищем vin
            Pattern patternVIN = Pattern.compile(VIN);
            Matcher matcherVIN = patternVIN.matcher(text);

            while (matcherVIN.find()) {
//                System.out.println(text.substring(matcherVIN.start(), matcherVIN.end() + 20));

                String substringVin = text.substring(matcherVIN.start() + 27, matcherVIN.end() + 20);
                if (!substringVin.isEmpty()) {
                    HWNumber hwNumber = new HWNumber();
                    VinData vinData = new VinData();
                    vinData.setVin(substringVin);
                    //ищем номера HW
                    while (matcherHW.find()) {
//                System.out.println(text.substring(matcher.start(), matcher.end() + 20));
                        String substringHW = text.substring(matcherHW.start(), matcherHW.end() + 20);
                        hwNumber.setNumber(substringHW);
                        if (vinData.getHwNumbers() == null) {
                            vinData.setHwNumbers(new ArrayList<>());
                            vinData.getHwNumbers().add(hwNumber);
                        } else {
                            vinData.getHwNumbers().add(hwNumber);
                        }
                    }
                    vins.add(vinData);
                }
            }
            document.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return vins;
    }
}

