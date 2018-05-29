package Functions;

import org.openqa.selenium.WebDriver;
import PageObjects.TakeAction_Page;
import utility.WebDr;



public class TakeAction {
	
	public static void takeAction_ClaimDetails(WebDriver driver)
	{
		try {
	    TakeAction_Page.SetPage_takeAction();
	    
	    WebDr.waitForPageLoad();
		WebDr.switchOnDefaultContent();
		driver.switchTo().frame("PWGadget1Ifr");
		WebDr.waitForPageLoad();
		driver.switchTo().frame("actionIFrame");
		WebDr.waitForPageLoad();
		WebDr.click("PolicyNo_CBX", "Click on confirm policy no check box");
		WebDr.click("SISPolicyNo_CBX", "Click on SIS Policy No check box");
		WebDr.click("EventDate_CBX", "Click on Event Date check box");
		WebDr.click("EventDescription_CBX", "Click on Event Description check box");
		WebDr.click("SubClaimDescrption_CBX", "Click on Sub Claim Descrption check box");
		WebDr.click("PotientialForRecovery_CBX", "Click on Potiential For Recovery check box");
		WebDr.setText("CauseOfDeath_TBX", WebDr.getValue("CauseOfDeath"), "Enter text in Cause Of Death textbox");
		WebDr.click("No_CBX", "Click on No check box");
		WebDr.waitForPageLoad();
		WebDr.setText("MedicalDiagnosis_TBX", WebDr.getValue("MedicalDiagnosis"), "Enter text in Medical Diagnosis textbox");
		WebDr.click("Sumbit_BTN", "Click on Submit button");
		WebDr.waitForPageLoad();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("PWGadget1Ifr");
		Thread.sleep(1000);
		driver.switchTo().frame("actionIFrame");
		WebDr.click("Sumbit_BTN", "Click on Submit button");
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		
		
	public static void takeAction_ReserveAndPaymentDetails(WebDriver driver)
	{
		try {
	    TakeAction_Page.SetPage_takeAction();
	    
		WebDr.waitForPageLoad();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("PWGadget1Ifr");
		Thread.sleep(1000);
		driver.switchTo().frame("actionIFrame");
		WebDr.waitForPageLoad();
		
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
