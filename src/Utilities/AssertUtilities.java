package Utilities;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AssertUtilities 
{
	public static void AssertionDemo()
	{
		Assert.assertEquals("ABCDE", "ABCDE");
		Assert.assertNotEquals("ABCDE", "abcde");
		Assert.assertTrue(5>4);
		Assert.assertFalse(5==4);
		Assert.assertNull(null);
		Assert.assertNotNull("abc");
		Assert.fail();
	}
	
    public static void AssertFail()
    {
    	Assert.fail();
    }

    public static void AssertIsTrue(boolean torf, String errMsg)
    {
        if (torf == true)
        {
            LogUtilities.Log("AssertIsTrue Pass");
        }
        else
        {
            LogUtilities.Log(String.format("AssertIsTrue Failed: %s", errMsg));

        }
    }

    public static boolean AssertAreEqual(WebDriver driver, String expected, String actual, boolean scrnShot)
    {
    	scrnShot = scrnShot? scrnShot : true;
    	
        //if(String.Equals(expected, actual)) // C#
    	if(expected.equals(actual))
        {
            //LogUtilities.Log($"AssertAreEqual: Actual string '{actual}' is expected");  		
            LogUtilities.Log(String.format("AssertAreEqual: Actual string '%s' is expected", actual));    		
            return true;
        }
        else
        {
            //LogUtilities.Log($"AssertAreEqual Failed: Expected is {expected}, Actual is {actual}");
            LogUtilities.Log(String.format("AssertAreEqual Failed: Expected is %s, Actual is %s", expected, actual));    		
        	if(scrnShot)
                ScreenshotUtilities.ITakeScrnShot(driver, expected);
            driver.close();
            Assert.fail();
            return false;
        }
    }

    public static void AssertAreEqual(String expected, String actual)
    {
        //if (String.Equals(expected, actual))
    	if(expected.equals(actual))
        {
            //LogUtilities.Log($"AssertAreEqual: Actual string '{actual}' is expected");
            LogUtilities.Log(String.format("AssertAreEqual: Actual string '%s' is expected", actual));    		
        }
        else
        {
            //LogUtilities.Log($"AssertAreEqual Failed: Expected is {expected}, Actual is {actual}");
            LogUtilities.Log(String.format("AssertAreEqual Failed: Expected is %s, Actual is %s", expected, actual));    		
            //ScreenshotUtilities.ITakeScrnShot(Driver, expected);
            //Assert.AreEqual(expected, actual); //<== Already be taken care of, don't need to throw Exception
            Assert.fail();
        }
    }

    public static void AssertAreEqual(int expected, int actual)
    {
        if (expected == actual)
        {
            //LogUtilities.Log($"AssertAreEqual: Actual number '{actual}' is expected");
            LogUtilities.Log(String.format("AssertAreEqual: Actual number '%s' is expected", actual));    		
        }
        else
        {
            //LogUtilities.Log($"AssertAreEqual Failed: Expected is {expected}, Actual is {actual}");
            LogUtilities.Log(String.format("AssertAreEqual Failed: Expected is %s, Actual is %s", expected, actual));    		
        }
    }

    public static void AssertContains(String wholeString, String subWords, WebDriver driver)
    {
        //if (wholeString.Contains(subWords)) C#
    	if(wholeString.contains(subWords))
        {
            //LogUtilities.Log($"AssertContains: Expected string '{subWords}' is contained in {wholeString}");
            LogUtilities.Log(String.format("AssertContains: Expected string '%s' is contained in %s", subWords, wholeString));    		
        }
        else
        {
            //LogUtilities.Log($"AssertContains: Expected string '{subWords}' is Not contained in {wholeString}");
            LogUtilities.Log(String.format("AssertContains: Expected string '%s' is Not contained in %s", subWords, wholeString));    		
   
        	ScreenshotUtilities.ITakeScrnShot(driver, subWords);
            driver.close();
            Assert.fail();
        }
    }
}
