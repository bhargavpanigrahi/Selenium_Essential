package PageObjects;

import java.util.HashMap;
import java.util.Map;

import utility.WebDr;

public class Logout_Page {
	
	public static void SetPage_LogoutPage() {
		
		Map<String, String> logout_Page_Objects=new HashMap<String, String>();
		
		logout_Page_Objects.put("PortalMenu_Logout_IMG", "XPATH|//img[@class='pzbtn-img-right']");
		logout_Page_Objects.put("menuItem_Logout_LINK", "XPATH|//tr[@id='/contextMenu/ID1294358612678000']");
	
		WebDr.page_Objects=logout_Page_Objects;
		
		
	}

}
