package com.automation.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {


    private static Properties properties = new Properties();


static{
    try {
        FileInputStream file = new FileInputStream("configuration.properties");
        //3 Load the "properties" obj with "file"
        properties.load(file);
        file.close();
    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        e.printStackTrace();
        System.out.println("FILE NOT FOUND WITH GIVEN PATH!!!");
    }
}
// create a utility method to use the obj to read
// Use "properties" obj to read from the file


public static String getProperty(String keyword){
    return properties.getProperty(keyword);
}



}
