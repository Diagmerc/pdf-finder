package ru.lozovoi.pdffinder.utils;

import lombok.Getter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;

@Getter
public class RegexUtil {

    public String VIN;
    public String HWNUM;
    public String SW;
    public String SCN;
    public String BOOTLOADER;
    public String VARIANT_CU;
    public String CU;
    public String MILEAGE;


    public RegexUtil() throws IOException {
        try (FileReader fileReader = new FileReader("settings.json")) {
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);
            MILEAGE = (String) jsonObject.get("MILEAGE");
            CU = (String) jsonObject.get("CU");
            VARIANT_CU = (String) jsonObject.get("VARIANT_CU");
            BOOTLOADER = (String) jsonObject.get("BOOTLOADER");
            SCN = (String) jsonObject.get("SCN");
            SW = (String) jsonObject.get("SW");
            HWNUM = (String) jsonObject.get("HWNUM");
        } catch (Exception e) {
            throw new IOException("There is no regex");
        }
    }
}
