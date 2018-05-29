package testCases;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import utility.Launcher;

public class Driver {

	public static WebDriver driver;
	public static Map<String, String> dictionary = new HashMap<String, String>();
	public static String userDir;

	public static void AppInovker(String appName, String fn_name) throws Exception {
		switch (appName) {
		case "PEGA":
			TestFlowPEGA.executeTC(Driver.driver, fn_name);
			break;
		default:
			break;

		}
	}

	public void mainDriver() throws Exception {
		userDir = System.getProperty("user.dir");
		System.out.println("====================>"+userDir);
		Launcher.InvokeLauncher();
	}

	public static void main(String ar[]) throws Exception {
		Driver ob = new Driver();
		ob.mainDriver();
	}
}
