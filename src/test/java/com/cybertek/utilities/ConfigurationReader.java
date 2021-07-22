package com.cybertek.utilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * reads the properties file configuration.properties
 */
public class ConfigurationReader {

    private static Properties properties;

    static {  // static bloc cunku it runs before everytihing  ++>  we are gona load the information one time and we will get the information with the method below(public static String get(String keyName) )

        try {
            // what file to read        //configuration.properties  ==> right clik content path
            String path = "configuration.properties";  //direk under the Project name oldugu icin bu path i dierk src ya da test in altinda degil
            // read the file into java, finds the file using the string path
            FileInputStream input = new FileInputStream(path);//  object creting with Constructor takes path values
            // properties --> class that store properties in key / value format
            properties = new Properties();  //creating object from Properties Class
            // the values from the file input is loaded / fed in to the properties object
            properties.load(input); // properties object has load() method that takes and loads key and values from Configuration Reader file

            input.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static String get(String keyName) {         // yukaris sirf bu method icin get(0 methodu return String value
                                                            // getProperty(keySets) ile value retirn ediyor
        return properties.getProperty(keyName);
    }


}
