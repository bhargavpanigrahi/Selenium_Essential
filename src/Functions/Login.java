package Functions;

import org.openqa.selenium.WebDriver;

import PageObjects.Login_Page;
import testCases.Driver;
import utility.HtmlReporter;
import utility.WebDr;

public class Login extends Driver{
	
	
	public static void login(WebDriver driver) throws Exception
	{
		try {
		
			Login_Page.SetPage_LoginPage();
			WebDr.setText("UserName", WebDr.getValue("UserName"), "Enter the username in the username textbox");
			WebDr.setText("PassWord", WebDr.getValue("PassWord"), "Enter the password in the password textbox");
			WebDr.click("Login_BTN", "Click on the login button");
			
		}catch(Exception e)
		{
			String errorMSG=e.getMessage();
			HtmlReporter.WriteStep(errorMSG, "", "", false);
		}	
			
			
		
	}
	

}
