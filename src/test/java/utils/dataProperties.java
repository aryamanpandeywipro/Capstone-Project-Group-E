package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class dataProperties {
    public static String getData(String key) {
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream(
                    "src/test/resources/data.properties"));
            return prop.getProperty(key);
        } catch (Exception e) {
            return null;
        }
    }
}