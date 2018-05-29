package Functions;

import org.openqa.selenium.WebDriver;

import PageObjects.CaseDetails_Page;
import utility.WebDr;

public class CaseDetails {
	
	public static void caseDetails(WebDriver driver)
	{
		try {
		CaseDetails_Page.SetPage_caseDetails();
		
	
		WebDr.selectDropDownValueByValue("PolicyProduct_DDL", WebDr.getValue("Product"), "Select policy product drop down value");
		
		WebDr.waitForPageLoad();
		WebDr.selectDropDownValueByValue("ScheduleBenefits_DDL", WebDr.getValue("ScheduleOfBenefits"), "Select Schedule Of Benefits drop down value");
		
		WebDr.waitForPageLoad();
		WebDr.selectDropDownValueByValue("CoverageCode_DDL", WebDr.getValue("SISCoverage"), "Select Coverage Code drop down value");
		
		WebDr.waitForPageLoad();
		WebDr.selectDropDownValueByValue("CoverageType_DDL", WebDr.getValue("Coverage"), "Select Coverage Type drop down value");

		WebDr.waitForPageLoad();
		WebDr.setText("Occupation_TBX", WebDr.getValue("Occupation"), "Enter text in the occupation text box");
		Thread.sleep(1000);
		WebDr.waitForPageLoad();
		WebDr.clickBasedOnList_Index("Occupation_LST", 1, "Click on the desired value from the list");
		/*
		WebDr.waitForPageLoad();
		WebDr.click("ClaimedPersonalID_TBX", "Click on the Claimed Personal ID TBX");*/
		
		WebDr.waitForPageLoad();
		WebDr.click("ClaimedSameAsInsured_CBX", "Click on the Claimed Same As Insured CBX");
		
		WebDr.waitForPageLoad();
		WebDr.selectDropDownValueByValue("ClaimedInsuredRelationship_DDL", WebDr.getValue("Relationship"), "Select Relationship drop down value");
		
		/*WebDr.waitForPageLoad();
		WebDr.click("ClaimantFullName_TBX", "Click on the Claimant FullName TBX");*/
		
		WebDr.waitForPageLoad();
		WebDr.click("CCRepSameAsInsured_CBX", "Click on the Claimed Same As Insured CBX");
		
		WebDr.waitForPageLoad();
		WebDr.selectDropDownValueByValue("ClaimantProvinceCode_DDL", WebDr.getValue("ProvinceCode"), "Select Claimant Province Code drop down value");
		Thread.sleep(1000);
		WebDr.waitForPageLoad();
		WebDr.setText("Description_TBX", WebDr.getValue("EventDescription"), "Enter text in the Event Description text box");
		
		WebDr.waitForPageLoad();
		WebDr.setText("SubClaimDescription_TBX", WebDr.getValue("SubClaimDescription"), "Enter text in the SubClaim Description text box");
		
		
		WebDr.waitForPageLoad();
		WebDr.moveToElement("CauseCode_DDL");
		WebDr.selectDropDownValueByValue("CauseCode_DDL", WebDr.getValue("CauseCode"), "Select CauseCode drop down value");
		
		WebDr.waitForPageLoad();
		WebDr.moveToElement("SubClaimCode_DDL");
		WebDr.selectDropDownValueByValue("SubClaimCode_DDL", WebDr.getValue("SubClaimCode"), "Select SubClaim Code drop down value");
		
		WebDr.waitForPageLoad();
		WebDr.moveToElement("ClaimType_DDL");
		WebDr.selectDropDownValueByValue("ClaimType_DDL", WebDr.getValue("ClaimType"), "Select SubClaim Code drop down value");
		
		WebDr.waitForPageLoad();
		WebDr.moveToElement("CauseOfLoss_DDL");
		WebDr.selectDropDownValueByValue("CauseOfLoss_DDL", WebDr.getValue("CauseOfLoss"), "Select Cause Of Loss drop down value");
		

		WebDr.waitForPageLoad();
		WebDr.moveToElement("ContributingFactor_DDL");
		WebDr.selectDropDownValueByValue("ContributingFactor_DDL", WebDr.getValue("ContributingFactor"), "Select Contributing Factor drop down value");
		
		WebDr.waitForPageLoad();
		WebDr.moveToElement("ConditionCode_DDL");
		WebDr.selectDropDownValueByValue("ConditionCode_DDL", WebDr.getValue("ConditionCode"), "Select Contributing Factor drop down value");
		
		WebDr.waitForPageLoad();
		WebDr.doubleClick("Submit_BTN");
		//WebDr.click("Submit_BTN", "Click on the Submit button");
		
		Thread.sleep(5000);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
