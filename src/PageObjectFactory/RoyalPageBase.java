package PageObjectFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.AssertUtilities;
import Utilities.WebDriverExtensions;

public class RoyalPageBase 
{
    protected WebDriver Driver;
    protected String PageTitle;
    protected String PageUrl;

    public void VerifyPageTitle()
    {
        //AssertUtilities.AssertContains(Driver.Title, PageTitle, Driver);
        AssertUtilities.AssertAreEqual(Driver, PageTitle, Driver.getTitle(), true);
    }

    public void LogOutThePage()
    {
        WebElement logout = WebDriverExtensions.TryFindElement(Driver, By.xpath("//a[@title='Log Out']"));
        WebDriverExtensions.WaitForSeconds(1);
        logout.click();
    }

}
