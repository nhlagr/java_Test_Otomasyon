package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

public class propertiesReader {

    private static Properties properties;
    public static String file = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "sample.properties";

    static {
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            properties.load(fileInputStream);
            properties.load(new InputStreamReader(fileInputStream, Charset.forName("UTF-8")));
            fileInputStream.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static String getHeadless() {
        if(System.getProperty("headless") != null){
            return System.getProperty("headless");
        }else{
            return properties.getProperty("headless");
        }
    }

    public static String getGridLink() {
        if (System.getProperty("gridLink") != null) {
            return System.getProperty("gridLink");
        } else {
            return properties.getProperty("gridLink");
        }
    }

    public static String getGridBrowser() {
        if (System.getProperty("gridBrowser") != null) {
            return System.getProperty("gridBrowser");
        } else {
            return properties.getProperty("gridBrowser");
        }
    }


    public static String getLink(){
        if (System.getProperty("link") != null){
            System.out.println(System.getProperty("link"));
            return System.getProperty("link").replaceAll("ı",  "i");
        }else {
            return properties.getProperty("link").replaceAll("ı", "i");
        }
    }

    public static String getUrl(){
        if(System.getProperty(getLink() + ".url") != null){
            return System.getProperty(getLink() + ".url");
        }else{
            return properties.getProperty(getLink() + ".url");
        }

    }


    public static String getBrowser() {
        if(System.getProperty("browser") != null){
            return System.getProperty("browser");
        }else{
            return properties.getProperty("browser");
        }
    }


}
