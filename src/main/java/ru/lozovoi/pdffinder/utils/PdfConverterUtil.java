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

@Component//todo test this code!!!
public class PdfConverterUtil {
    static String VIN = "Идентификационный номер а/м";
    static String HWnum = "901 ";

    static String variantCU = "Вариант БУ";

    static List<String> CU = List.of("N73, N3/9, A80, N118, Y3/8n4, N10, N71/1, N69/5, N2/10, N10/8, A76, A76/1, N80, N26/6, N62, N148, N128, N68, N30/4, A40/9, A40/8, A1, N22/7, N69/1, N69/2, N69/3, N69/4, N121/1");

    public static List<VinData> convert(String file) {
        ArrayList<VinData> vins = new ArrayList<>();
        try {
            PDDocument document = PDDocument.load(new File(file));
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);
            find(text, HWnum, 0, 20);
            find(text, VIN, 0, 20);
            for (String s : CU) {
                substringFromTextToText(text, s, variantCU);
            }
            document.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return vins;
    }

    private static String substringFromTextToText(String text, String from, String to) {
        int cuIndex = text.indexOf(from);
        String CUText = text.substring(cuIndex, text.length() - 1);
        return text.substring(cuIndex, text.length() - 1).substring(0, CUText.indexOf(to));
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

