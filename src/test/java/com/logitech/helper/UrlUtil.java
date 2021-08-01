package com.logitech.helper;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlUtil {

    public static String getPath(String fullUrl) throws MalformedURLException {
        return new URL(fullUrl).getPath();
    }
}
