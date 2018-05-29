package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import java.util.concurrent.TimeUnit;

public class WebDriverFactory 
{
    private static WebDriver driver;
    
    public static WebDriver GetBrowser(String browserName)
    {
        String browserType = browserName.toLowerCase();

        switch (browserType)
        {
            case "chrome":
                System.setProperty("webdriver.chrome.driver","C:\\My Stuff\\My Eclipse\\MyAutomationSolution\\Selenium-drivers\\chromedriver.exe");
                driver = new ChromeDriver();
                
                LogUtilities.Log(String.format("Chrome Driver %s created", driver.hashCode()));
                break;

            case "firefox":
      			System.setProperty("webdriver.gecko.driver","C:\\My Stuff\\My Eclipse\\MyAutomationSolution\\Selenium-drivers\\geckodriver.exe");
                driver = new FirefoxDriver();
                
                LogUtilities.Log(String.format("Firefox Driver %s created", driver.hashCode()));
                break;

            case "ie":
			    InternetExplorerOptions options = new InternetExplorerOptions();
			    options.ignoreZoomSettings();
			    System.setProperty("webdriver.ie.driver","C:\\My Stuff\\My Eclipse\\MyAutomationSolution\\Selenium-drivers\\IEDriverServer.exe");
			    driver = new InternetExplorerDriver(options);
			    
                LogUtilities.Log(String.format("IE Driver %s created", driver.hashCode()));
                break;

            default:
                System.setProperty("webdriver.chrome.driver","C:\\My Stuff\\My Eclipse\\MyAutomationSolution\\Selenium-drivers\\chromedriver.exe");
                driver = new ChromeDriver();
                
                LogUtilities.Log(String.format("Chrome Driver %s created", driver.hashCode()));
                break;
        }
        //Driver.Manage().Window.Maximize();	
		driver.manage().timeouts().implicitlyWait(Globals.TimeoutForElementLoading, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Globals.TimeoutForPageLoading, TimeUnit.SECONDS);
 		
        return driver;
    }

    public static void CloseAllDrivers()
    {
        LogUtilities.Log("To be implemented");
    }    
}
