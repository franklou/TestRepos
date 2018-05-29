package Utilities;

import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class WebDriverExtensions 
{
    public static WebElement TryFindElement(WebDriver driver, By by)
    {
        WebElement elem = null;
        try
        {
            elem = driver.findElement(by);
        }
        catch (Exception e)
        {
            LogUtilities.Log(String.format("Can Not find element %s", by));
        }
        return elem;
    }
    
    public static void WaitForSeconds(int sec)
    {
        try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }  
    
    public static void WaitForPageLoadCompleted(WebDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver, Globals.TimeoutForPageLoading);
               
        Function<WebDriver, Boolean> PageState = (WebDriver drv) -> 
        {
            String state = ((JavascriptExecutor)drv).executeScript("return document.readyState").toString();  
            if(state.equals("complete"))
            {
            	LogUtilities.Log(String.format("State is %s", state));
            	return true;
            }
            LogUtilities.Log(String.format("State is %s", state));
            return false;
        };
        
        wait.until(PageState);
    }    
}
