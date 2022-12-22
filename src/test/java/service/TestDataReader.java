package service;

import java.util.ResourceBundle;

/*public class TestDataReader {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment"));

    public static String getTestData(String key){
        return resourceBundle.getString(key);
    }
}*/

import java.util.Locale;
import java.util.ResourceBundle;

public class TestDataReader {
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("dev", new Locale("EN"));

    public static String getTestData(String key){
        return resourceBundle.getString(key);
    }
}