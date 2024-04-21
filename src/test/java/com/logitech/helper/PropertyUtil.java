package com.logitech.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class PropertyUtil {

    static Properties envProperties;

    static Properties bootstrapProperties;

    public static void loadProperties(String propPath) throws IOException {
        envProperties = new Properties();
        envProperties.load(new FileInputStream(propPath));
    }

    public static String getProperty(String propertyName) {
        return envProperties.getProperty(propertyName);
    }

    public static void loadBootstrapProperties(String propPath) throws IOException {
        bootstrapProperties = new Properties();
        bootstrapProperties.load(new FileInputStream(propPath));
    }

    public static String getBootStrapProperty(String propName) {
        return bootstrapProperties.getProperty(propName);
    }

}
