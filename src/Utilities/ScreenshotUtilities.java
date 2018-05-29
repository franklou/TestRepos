package Utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtilities 
{
    public static void ITakeScrnShot(WebDriver driver, String ssName)
    {
            //string filePath = KnownFolders.Downloads.Path + "\\ScreenShot";
        	String filePath = "C:\\Downloads\\ScreenShot";
            //if (!Directory.Exists(filePath))
                //Directory.CreateDirectory(filePath);
        	
        	File sshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        	try 
        	{
	        	 // now copy the  screenshot to desired location using copyFile //method
	        	FileUtils.copyFile(sshot, new File(filePath));
        	}     	 
        	catch (IOException e)
        	 {
        		System.out.println(e.getMessage());	 
        	 }
        	
        	/*
            Screenshot ss = ((ITakesScreenshot)driver).GetScreenshot();
            ss.SaveAsFile(filePath + $"\\{ssName}_{DateTime.Now.ToString("yyyy-MM-dd_HH-mm-ss")}.jpeg", ScreenshotImageFormat.Jpeg); //ssName_2016-11-28_21-24-12.Jpeg
            //ss.SaveAsFile(filePath + $"\\{ssName}_{DateTime.Now.ToString("yyyy-MM-dd_HH-mm-ss")}.png", ImageFormat.Png);   //ssName_2016-11-28_21-24-12.Png
            LogUtilities.Log($"A screenshot has been saved in folder {filePath}");
	        }
	        catch (Exception e)
	        {
	            LogUtilities.Log($"TakeScrnShot: {e.Message}");
	            throw;
	        }
	        */
    }
}
