package com.logitech.constants;

import java.io.File;

public class EnvironmentConstants {

    public static String PROPERTIES_PATH;

    public static String NAUKRI_URL = "naukriUrl";

    public static String HEROKUAPP_URL = "herokuapp";

    public static String BANNERS_SERVICE = "banners";


    static {
        File srcPath = new File("src/test/resources/config");
        File envFile = new File(srcPath, "environment.properties");
        PROPERTIES_PATH = envFile.getAbsolutePath();
    }
}
