package ru.lozovoi.pdffinder.utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component//todo clean this
public class PdfConverter {
    static String VIN = "Идентификационный номер а/м";
    static String HWnum = "901 ";

    public static List<String> convert(String file) {
        try {
            PDDocument document = PDDocument.load(new File(file));
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);

            Pattern pattern = Pattern.compile(HWnum);
            Matcher matcher = pattern.matcher(text);

            //ищем vin
            Pattern patternVIN = Pattern.compile(VIN);
            Matcher matcherVIN = patternVIN.matcher(text);


            while (matcherVIN.find()) {
                System.out.println(text.substring(matcherVIN.start(), matcherVIN.end() + 20));
            }
            //ищем номера HW
            while (matcher.find()) {
                System.out.println(text.substring(matcher.start(), matcher.end() + 20));
            }
            document.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ArrayList<>();
    }
}

