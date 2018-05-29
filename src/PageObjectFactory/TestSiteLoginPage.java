package PageObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Utilities.LogUtilities;
import Utilities.WebDriverExtensions;

public class TestSiteLoginPage extends RoyalPageBase
{
    //Class public properties
    @FindBy(how=How.NAME, using ="UserName")
    public WebElement Username;

    @FindBy(how=How.NAME, using ="Password")
    public WebElement Password;

    @FindBy(how=How.XPATH, using =("//button[@type='submit']"))
    public WebElement SubmitBtn;

    //@FindBy(How = How.XPath, Using = ("//a[text()='Forgot your password?']"))]
    @FindBy(how=How.LINK_TEXT, using =("Forgot your password?"))
    public WebElement ResetPassword;

    public void LoginWithCredential(String username, String password)
    {
        try
        {
            Username.sendKeys(username);
            Password.sendKeys(password);
            SubmitBtn.submit();
        }
        catch (Exception e)
        {
            Driver.quit();
            LogUtilities.Log(String.format("LoginWithCredential failed! %s", e.getMessage()));
        }
   }

    //Class Constructors
    public TestSiteLoginPage(WebDriver drv)
    {
        PageTitle = "Royal Alliances | Mailing Services | Irving, TX";
        PageUrl = "https://test.royalalliances.com/Account/Login";
        Driver = drv;
        PageFactory.initElements(Driver, this);
        Driver.get(PageUrl);
        WebDriverExtensions.WaitForPageLoadCompleted(Driver);

        VerifyPageTitle();
    }

}
