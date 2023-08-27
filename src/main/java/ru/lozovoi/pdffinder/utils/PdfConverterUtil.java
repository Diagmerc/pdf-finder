package ru.lozovoi.pdffinder.utils;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component//todo test this code!!!
public class PdfConverterUtil {
    public static String find(String text, String key) {
        Pattern pattern = Pattern.compile(key);
        Matcher matcher = pattern.matcher(text);
        String substring = null;
        while (matcher.find()) {
            substring = text.substring(matcher.start(), matcher.end());
        }
        return substring;
    }
}

