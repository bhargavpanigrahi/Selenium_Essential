package PageObjects;

import java.util.HashMap;
import java.util.Map;

import utility.WebDr;

public class Documentation_Page {
	
	public static void SetPage_documentUpload()
	{
		Map<String, String> documentUpload_Page_Objects=new HashMap<String, String>();
		
		documentUpload_Page_Objects.put("fileUpload_Link", "XPATH|//a[contains(.,'CaseSetupOfFile')]");
		documentUpload_Page_Objects.put("IFrame", "XPATH|//select[@id='ScheduleOfBenefits']");
		documentUpload_Page_Objects.put("DocumentList_CBX", "XPATH|//input[@id='DocCheck']");
		documentUpload_Page_Objects.put("DocSubmit_BTN", "XPATH|//button[@id='submitButton']");
		
		WebDr.page_Objects=documentUpload_Page_Objects;
	}

}
