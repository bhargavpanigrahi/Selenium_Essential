package PageObjects;

import java.util.HashMap;
import java.util.Map;

import utility.WebDr;

public class Login_Page {
	
	public static void SetPage_LoginPage() {
	
	Map<String, String> login_Page_Objects=new HashMap<String, String>();
	
	login_Page_Objects.put("UserName", "ID|txtUserID");
	login_Page_Objects.put("PassWord", "ID|txtPassword");
	login_Page_Objects.put("Login_BTN", "XPATH|//button[@id='sub']");
	
	WebDr.page_Objects=login_Page_Objects;
}
}