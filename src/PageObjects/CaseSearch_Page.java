package PageObjects;

import java.util.HashMap;
import java.util.Map;

import utility.WebDr;

public class CaseSearch_Page {
	
	public static void SetPage_CaseSearchPage() {
		
		Map<String, String> caseSearch_Page_Objects=new HashMap<String, String>();
		
		caseSearch_Page_Objects.put("PortalMenu_IMG", "XPATH|(//img[@class='pzbtn-img'])[1]");
		caseSearch_Page_Objects.put("MenuItem_LINK", "XPATH|//td[contains(.,'Seguro com Base em S6')]");
		caseSearch_Page_Objects.put("PolicyNumber_TBX", "XPATH|//input[@id='PolicyNumber']");
		caseSearch_Page_Objects.put("EventDate_TBX", "XPATH|//input[@id='EventDate']");
		caseSearch_Page_Objects.put("CaseSearch_BTN", "XPATH|//button[@class='pzhc']");
		caseSearch_Page_Objects.put("CaseList_LINK", "XPATH|//tr[@class=' listTableRowStyle']/td[contains(.,'N707P66300')]");
		
		WebDr.page_Objects=caseSearch_Page_Objects;
	}

}
