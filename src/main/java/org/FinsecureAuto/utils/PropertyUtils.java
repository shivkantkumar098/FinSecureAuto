package org.FinsecureAuto.utils;

import jdk.vm.ci.meta.Constant;
import org.FinsecureAuto.constant.FrameworkConstant;
import org.FinsecureAuto.customException.FAILEDToLoadPropertiesFileException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
    //Used to load properties from a configuration file.
   private static final Properties props = new Properties();
   // This static block is executed when the class is loaded.
   // It attempts to load the properties from the specified file path.
    // If the file cannot be found or read, it throws a custom exception.

   static {
        try(FileInputStream fis=new FileInputStream(FrameworkConstant.CONFIG_FILE_PATH)){
                props.load(fis);
        }
        catch (IOException e){
            throw new FAILEDToLoadPropertiesFileException("Failed to load properties file.", e);
        }
   }
   //This method retrieves the value associated with the specified key from the properties file.
   //If the key does not exist, it returns null.
   //It is used to access configuration settings defined in the properties file.
   //The properties file is loaded from the path specified in FrameworkConstant.CONFIG_FILE_PATH.

    public static String get(String key) {
        return props.getProperty(key);
    }

}
