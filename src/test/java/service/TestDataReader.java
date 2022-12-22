package service;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestDataReader {
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("dev", new Locale( "RU"));

    public static String getTestData(String key){
        return resourceBundle.getString(key);
    }
}