package org.finsecure.utils;

import org.finsecure.constant.FrameworkConstant;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.io.File;

public class ScreenshotUtils {
    public static void takeScreenshot(WebDriver driver,String fileName){
            try{
                TakesScreenshot ts=(TakesScreenshot) driver;
                File src=ts.getScreenshotAs(OutputType.FILE);
                File dest=new File(FrameworkConstant.SCREENSHOT_PATH);
                if(!dest.exists()){
                    dest.mkdirs(); // Create the folder if it doesn't exist
                }
                String timestamp=String.valueOf(System.currentTimeMillis());
                File finalDest=new File(dest,fileName+"_"+timestamp+".png");
                src.renameTo(finalDest); // Rename the file to the final destination
                System.out.println("Screenshot saved at: " + finalDest.getAbsolutePath());
            }catch (WebDriverException e){
                e.printStackTrace();
            }
    }
}
