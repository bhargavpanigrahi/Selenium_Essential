package Functions;

import org.openqa.selenium.WebDriver;

import PageObjects.CaseSearch_Page;

import utility.HtmlReporter;
import utility.WebDr;

public class CaseSearch {
	
	public static void caseSearch(WebDriver driver) throws Exception
	{
		try {
		
			CaseSearch_Page.SetPage_CaseSearchPage();
			WebDr.waitForPageLoad();
			WebDr.click("PortalMenu_IMG", "Click on the Portal Menu Image");
			WebDr.waitForPageLoad();
			Thread.sleep(1000);
			
			WebDr.click("MenuItem_LINK", "Click on the Menu Item LINK");
			
			driver.switchTo().frame("PWGadget1Ifr");
			Thread.sleep(1000);
			WebDr.setText("PolicyNumber_TBX", WebDr.getValue("PolicyNumber"), "Enter policy number in the policy no textbox");
			WebDr.waitForPageLoad();
			WebDr.setText("EventDate_TBX", WebDr.getValue("EventDate"), "Enter Event Date in the Event Date textbox");
			WebDr.waitForPageLoad();
			WebDr.click("CaseSearch_BTN", "Click on the Case Search BTN");
			WebDr.waitForPageLoad();
			WebDr.doubleClick("CaseList_LINK");
			//WebDr.click("CaseList_LINK", "Click on the Case LINK");
			WebDr.waitForPageLoad();
		}catch(Exception e)
		{
			String errorMSG=e.getMessage();
			HtmlReporter.WriteStep(errorMSG, "", "", false);
		}
	}
	

}
