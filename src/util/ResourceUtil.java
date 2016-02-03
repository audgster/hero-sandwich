package util;

import java.net.MalformedURLException;
import java.net.URL;

public class ResourceUtil {

    public static URL getResourceURL(String relativePath)
    {
        URL defaultClassPath = ClassLoader.getSystemClassLoader().getResource("");

        URL newUrl = null;

        try {
            newUrl = new URL(defaultClassPath, relativePath);
            System.out.println("ResourceUtil: " + newUrl);
        } catch (MalformedURLException e) {
            System.out.println("ResourceUtil: Relative path " + relativePath + " resulted in a malformed URL");
        }

        return newUrl;
    }
}
