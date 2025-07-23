package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop;

    public static void initProperties() {
        if (prop == null) {
            try (FileInputStream ip = new FileInputStream("src/test/java/config/config.properties")) {
                prop = new Properties();
                prop.load(ip);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Could not load config.properties");
            }
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }
}
