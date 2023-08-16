package ru.lozovoi.pdffinder.utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Component;
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
            //todo find here
            document.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return vins;
    }

    private static String find(String text, String key, Integer startTextSubstring, Integer endTextSubString) {
        Pattern pattern = Pattern.compile(key);
        Matcher matcher = pattern.matcher(text);
        String substring = null;
        while (matcher.find()) {
//                System.out.println(text.substring(matcher.start(), matcher.end() + 20));
            substring = text.substring(matcher.start() + startTextSubstring, matcher.end() + endTextSubString);
        }
        return substring;
    }
}

