package Functions;

import org.openqa.selenium.WebDriver;

import PageObjects.Documentation_Page;
import utility.WebDr;

public class Documentation {
	
public static void uploadDocuments(WebDriver driver)
{
	try {
	Documentation_Page.SetPage_documentUpload();
	
	WebDr.waitForPageLoad();
	WebDr.click("fileUpload_Link", "Click on the file upload link");
	Thread.sleep(1000);
	
	driver.switchTo().frame("actionIFrame");
	
	WebDr.clickBasedOnList("DocumentList_CBX","Click on the list of checkbox");
	WebDr.waitForPageLoad();
	WebDr.click("DocSubmit_BTN", "Click on the Submit button");
	WebDr.waitForPageLoad();
	WebDr.switchOnDefaultContent();
	driver.switchTo().frame("PWGadget1Ifr");
	driver.switchTo().frame("actionIFrame");
	WebDr.waitForPageLoad();
	WebDr.click("PolicyNo_CBX", "Click on confirm policy no check box");
	//WebDr.waitForPageLoad();
	WebDr.click("SISPolicyNo_CBX", "Click on SIS Policy No check box");
	//WebDr.waitForPageLoad();
	WebDr.click("EventDate_CBX", "Click on Event Date check box");
	//WebDr.waitForPageLoad();
	WebDr.click("EventDescription_CBX", "Click on Event Description check box");
	//WebDr.waitForPageLoad();
	WebDr.click("SubClaimDescrption_CBX", "Click on Sub Claim Descrption check box");
	//WebDr.waitForPageLoad();
	//WebDr.waitForPageLoad();
	WebDr.click("PotientialForRecovery_CBX", "Click on Potiential For Recovery check box");
	
	
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	

}
