package ru.lozovoi.pdffinder.utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PdfConverter {

    public PdfConverter(String path) {
        this.file = path;
    }

    String file;
    PDDocument document;
    String VIN = "Идентификационный номер а/м";
    String HWnum = "901 ";

    {
        try {
            document = PDDocument.load(new File(file));
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);

            Pattern pattern = Pattern.compile(HWnum);
            Matcher matcher = pattern.matcher(text);

            //ищем vin
            Pattern patternVIN = Pattern.compile(VIN);
            Matcher matcherVIN = patternVIN.matcher(text);


            matcherVIN.find();
            System.out.println(text.substring(matcherVIN.start(), matcherVIN.end() + 20));
            //ищем номера HW
            while (matcher.find()) {
                System.out.println(text.substring(matcher.start(), matcher.end() + 20));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

