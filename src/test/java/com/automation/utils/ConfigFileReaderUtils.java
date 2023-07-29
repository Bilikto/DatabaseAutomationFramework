package com.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReaderUtils {

    private static Properties property;
    private static String configFilePath = "/src/test/resources/config/config.properties";

    public static void initConfig() {
        property = new Properties();
        try {
            property.load(new FileInputStream(System.getProperty("user.dir") + configFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return property.getProperty(key);
    }

    //for testing purpose
    public static void main(String[] args) {
        ConfigFileReaderUtils.initConfig();
        System.out.println(ConfigFileReaderUtils.getProperty("app.url"));
    }

}
