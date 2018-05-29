package PageObjects;

import java.util.HashMap;
import java.util.Map;

import utility.WebDr;

public class CaseDetails_Page {
	
	public static void SetPage_caseDetails()
	{
		Map<String, String> caseDetails_Page_Objects=new HashMap<String, String>();
		
		caseDetails_Page_Objects.put("PolicyProduct_DDL", "XPATH|//select[@name='$PPolicyPage$pProduct']");
		caseDetails_Page_Objects.put("ScheduleBenefits_DDL", "XPATH|//select[@id='ScheduleOfBenefits']");
		caseDetails_Page_Objects.put("CoverageCode_DDL", "XPATH|//select[@id='SIS_CoverageCode']");
		caseDetails_Page_Objects.put("CoverageType_DDL", "XPATH|//select[@id='CoverageType']");
		caseDetails_Page_Objects.put("Occupation_TBX", "XPATH|//input[@name='$PpyWorkPage$pOccupation']");
		caseDetails_Page_Objects.put("Occupation_LST", "XPATH|//table[@class='gridTable ']/tbody/tr");
		caseDetails_Page_Objects.put("ClaimedPersonalID_TBX", "XPATH|//input[@id='ClaimedPersonalID']");
		caseDetails_Page_Objects.put("ClaimedSameAsInsured_CBX", "XPATH|(//input[@name='$PpyWorkPage$pClaimedSameAsInsured'])[2]");
		caseDetails_Page_Objects.put("ClaimedInsuredRelationship_DDL", "XPATH|//select[@id='ClaimedInsuredRelationship']");
		caseDetails_Page_Objects.put("ClaimantFullName_TBX", "XPATH|//input[@id='CCRepClaimant_FullName']");
		caseDetails_Page_Objects.put("CCRepSameAsInsured_CBX", "XPATH|(//input[@name='$PpyWorkPage$pCCRepSameAsInsured'])[2]");
		caseDetails_Page_Objects.put("ClaimantProvinceCode_DDL", "XPATH|//select[@id='CCRepClaimant_ProvinceCode']");
		caseDetails_Page_Objects.put("Description_TBX", "XPATH|//input[@id='Description']");
		caseDetails_Page_Objects.put("SubClaimDescription_TBX", "XPATH|//input[@id='SubClaimDescription']");
		caseDetails_Page_Objects.put("CauseCode_DDL", "XPATH|//select[@id='CauseCode']");
		caseDetails_Page_Objects.put("SubClaimCode_DDL", "XPATH|//select[@id='SubClaimCode']");
		caseDetails_Page_Objects.put("ClaimType_DDL", "XPATH|//select[@id='ClaimType']");
		caseDetails_Page_Objects.put("ContributingFactor_DDL", "XPATH|//select[@id='ContributingFactor']");
		caseDetails_Page_Objects.put("CauseOfLoss_DDL", "XPATH|//select[@name='$PpyWorkPage$pCauseOfLoss']");
		caseDetails_Page_Objects.put("ConditionCode_DDL", "XPATH|//select[@id='ConditionCode']");
		caseDetails_Page_Objects.put("Submit_BTN", "XPATH|//table[@id='HarnessFooter']/tbody/tr/td[3]/table");
		
		WebDr.page_Objects=caseDetails_Page_Objects;
		
		
	}
	}

