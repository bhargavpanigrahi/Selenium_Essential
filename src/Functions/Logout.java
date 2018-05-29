package Functions;

import org.openqa.selenium.WebDriver;


import PageObjects.Logout_Page;
import testCases.Driver;
import utility.HtmlReporter;
import utility.WebDr;

public class Logout extends Driver {

	public static void logout(WebDriver driver) throws Exception
	{
		try {
		
			Logout_Page.SetPage_LogoutPage();
			driver.switchTo().defaultContent();
			
			WebDr.click("PortalMenu_Logout_IMG", "Click on the Portal Menu Logout Image");
			WebDr.waitForPageLoad();
			Thread.sleep(1000);
			WebDr.doubleClick("menuItem_Logout_LINK");
			//WebDr.click("menuItem_Logout_LINK", "Click on the menu Item Logout LINK");
			Thread.sleep(5000);
			
		}catch(Exception e)
		{
			String errorMSG=e.getMessage();
			HtmlReporter.WriteStep(errorMSG, "", "", false);
		}
	}
	
}
