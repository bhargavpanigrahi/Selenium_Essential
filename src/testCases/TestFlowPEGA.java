package testCases;

import org.openqa.selenium.WebDriver;

import Functions.CaseDetails;
import Functions.CaseSearch;
import Functions.Documentation;
import Functions.Login;
import Functions.Logout;
import Functions.TakeAction;

public class TestFlowPEGA {

	
	public static void executeTC(WebDriver driver,String str_tc) throws Exception
	
	{
		switch(str_tc)
		{
		case "TC_01":
			TC_01(driver);
			break;
			
		default: break;
		}
	}

	public static void TC_01(WebDriver driver) throws Exception {
		System.out.println("TestFlowPEGA java- TC_01 Invoked");
		Login.login(driver);
		CaseSearch.caseSearch(driver);
		CaseDetails.caseDetails(driver);
		Documentation.uploadDocuments(driver);
		TakeAction.takeAction_ClaimDetails(driver);
		Logout.logout(driver);
		
		
	}
}
