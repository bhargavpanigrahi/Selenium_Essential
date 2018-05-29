package utility;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testCases.Driver;

public class WebDr extends Driver {

	public static Map<String, String> page_Objects = new HashMap<String, String>();
	public static WebElement element = null;
	public static String getExcelValue;
	public static String getValue;
	public static String actualText;
	public static String actualText1;
	public static String actualText_1;
	public static String actualText2;
	public static String getXpath;
	public static String parentWindowID;
	public static String getFirstSelectedOption;
	public static String getActualextBoxLength;
	public static String getActualextBoxValue;

	public static void openApplication(String browser, String URL) {
		DesiredCapabilities oCap = null;
		try {
			if (Launcher.remoteFlag.equals("Yes")) {
				switch (browser) {
				case "IE":
					oCap = DesiredCapabilities.internetExplorer();
					oCap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
					oCap.setBrowserName("ie");
					break;
				case "Chrome":
					oCap = DesiredCapabilities.chrome();
					oCap.setBrowserName("chrome");
					break;
				case "Firefox":
					oCap = DesiredCapabilities.firefox();
					break;
				default:
					break;

				}

				switch (Launcher.nodePlatform) {
				case "XP":
					oCap.setPlatform(Platform.XP);
					break;
				case "VISTA":
					oCap.setPlatform(Platform.VISTA);
					break;
				case "WIN8":
					oCap.setPlatform(Platform.WIN8);
					break;
				default:
					break;
				}

				driver = new RemoteWebDriver(new URL(Launcher.nodeURL + "/wd/hub"), oCap);
			} else {
				switch (browser) {
				case "IE":
					System.setProperty("webdriver.ie.driver",
							"C:\\Users\\BHPANI\\project\\Pega_Automation\\Plugin\\IEDriverServer.exe");
					
					DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
					//C:\\Users\\BHPANI\\Downloads\\IEDriverServer_Win32_2.48.0\\IEDriverServer.exe
					capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

					capabilities.setCapability("requireWindowFocus", true);

					 driver = new InternetExplorerDriver(capabilities);

					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.get(URL);
					
					
					break;
				case "Chrome":
					System.setProperty("webdriver.ie.driver",
							"C:\\Users\\BHPANI\\Downloads\\IEDriverServer_Win32_2.48.0\\IEDriverServer.exe");
					driver = new ChromeDriver();
					driver.get(URL);
					driver.manage().deleteAllCookies();
					break;
				case "Firefox":
					driver = new FirefoxDriver();
					driver.get(URL);
				default:
					break;
				}

			}
			//driver.manage().window().maximize();
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (Exception e) {

			System.out.println(e);
			System.out.println("Failed to create driver object -" + "Method openApplication in WebDr");

		}
	}

	public static String getValue(String objectName) {
		try {
			return Driver.dictionary.get(objectName);
		} catch (Exception e) {
			return null;
		}
	}
	
	

	public static WebElement getElement(String str) {
		String desc = page_Objects.get(str);
		System.out.println(desc);
		String[] a = desc.split("\\|");
		switch (a[0]) {
		case "ID":
			WebElement x = Driver.driver.findElement(By.id(a[1]));
			return x;

		case "XPATH":
			return Driver.driver.findElement(By.xpath(a[1]));

		default:
			System.out.println("element check");
			break;
		}

		return null;

	}

	public static List<WebElement> getElements(String str) {
		String desc = page_Objects.get(str);
		System.out.println(desc);
		String[] a = desc.split("\\|");
		switch (a[0]) {
		case "ID":
			return driver.findElements(By.id(a[1]));

		case "XPATH":
			return driver.findElements(By.xpath(a[1]));

		default:
			System.out.println("element check");
			break;
		}

		return null;

	}

	public static boolean exists(String elementName, boolean expected, String description) throws Exception {
		WebElement elmn = getElement(elementName);
		boolean state = false;

		if (elmn.isDisplayed() && expected == true) {
			HtmlReporter.WriteStep(description, "Exists", "Exists", true);
			state = true;
		} else if (elmn.isDisplayed() && expected == false) {
			HtmlReporter.WriteStep(description, "Should not Exists", "Exists", false);
			state = false;
		} else if (!elmn.isDisplayed() && expected == true) {
			HtmlReporter.WriteStep(description, "Exists", "Does not Exists", false);
			state = true;
		} else if (!elmn.isDisplayed() && expected == false) {
			HtmlReporter.WriteStep(description, "Does not Exists", "Does not Exists", true);
			state = false;
		}
		return state;
	}

	public static boolean enabled(String elementName, boolean expected, String description) throws Exception {
		WebElement elmn = getElement(elementName);
		boolean state = false;

		if (elmn.isEnabled() && expected == true) {
			HtmlReporter.WriteStep(description, "Exists", "Exists", true);
			state = true;
		} else if (elmn.isEnabled() && expected == false) {
			HtmlReporter.WriteStep(description, "Should not Exists", "Exists", false);
			state = false;
		} else if (!elmn.isEnabled() && expected == true) {
			HtmlReporter.WriteStep(description, "Exists", "Does not Exists", false);
			state = true;
		} else if (!elmn.isEnabled() && expected == false) {
			HtmlReporter.WriteStep(description, "Does not Exists", "Does not Exists", true);
			state = false;
		}
		return state;
	}

	public static boolean displayed(String elementName, boolean expected, String description) throws Exception {
		WebElement elmn = getElement(elementName);
		boolean state = false;

		if (elmn.isDisplayed() && expected == true) {
			HtmlReporter.WriteStep(description, "Exists", "Exists", true);
			state = true;
		} else if (elmn.isDisplayed() && expected == false) {
			HtmlReporter.WriteStep(description, "Should not Exists", "Exists", false);
			state = false;
		} else if (!elmn.isDisplayed() && expected == true) {
			HtmlReporter.WriteStep(description, "Exists", "Does not Exists", false);
			state = true;
		} else if (!elmn.isDisplayed() && expected == false) {
			HtmlReporter.WriteStep(description, "Does not Exists", "Does not Exists", true);
			state = false;
		}
		return state;
	}

	public static void click(String elementName, String description) throws Exception {
		WebElement elmn = getElement(elementName);

		if (elmn.isDisplayed() && elmn.isEnabled()) {
			elmn.click();
			HtmlReporter.WriteStep(description, "Click", "Clicked", true);
		}

		else {
			HtmlReporter.WriteStep("Object not visible - " + description, "Click", "Not Clicked", false);

		}
	}

	public static void setText(String elementName, String textToSet, String description) throws Exception {

		if (textToSet != null) {
			WebElement elmn = getElement(elementName);
			if (elmn.isDisplayed()) {
				elmn.sendKeys(textToSet);
				HtmlReporter.WriteStep(description, "Enter Text", "Entered - " + textToSet, true);
			} else {
				HtmlReporter.WriteStep("Object not visible - " + description, "Enter Text",
						" Not Entered - " + textToSet, false);

			}
		}
	}

	public static void verifyText(String elementName, boolean matchSubString, String expectedText, String description)
			throws Exception {
		WebElement elmn = getElement(elementName);
		if (elmn.isDisplayed()) {
			String actualText = elmn.getText();
			if (matchSubString == true) {
				if (actualText.contains(expectedText)) {
					HtmlReporter.WriteStep(description, "Verify Text", "Verified - " + expectedText, true);
				} else {
					HtmlReporter.WriteStep(description, "Verify Text -" + expectedText,
							"Verification failed -" + actualText, false);
				}
			} else if (matchSubString == false) {
				if (actualText.contains(expectedText)) {
					HtmlReporter.WriteStep(description, "Verify Text", "Verified - " + expectedText, true);
				} else {
					HtmlReporter.WriteStep(description, "Verify Text -" + expectedText,
							"Verification failed -" + actualText, false);
				}
			}

		} else {
			HtmlReporter.WriteStep("Object not visible -" + description, "Verify Text -" + expectedText, "Not Verified",
					false);
		}
	}

	public static void selectListValue(String elementName, String expectedTextValue, String description)
			throws Exception {
		List<WebElement> value = getElements(elementName);
		for (WebElement element : value) {
			if (element.getText().equalsIgnoreCase(expectedTextValue)) {
				System.out.println(element.getText());
				element.click();
				HtmlReporter.WriteStep(description, "Click on value as=====>" + expectedTextValue + "",
						"Clicked on value as=====>" + expectedTextValue + "", true);
			} else {
				HtmlReporter.WriteStep(description, "Unable to click on value as=====>" + expectedTextValue + "",
						"Unable to clicked on value as=====>" + expectedTextValue + "", false);
			}
		}

	}

	public static void selectDropValue(String elementName, String expectedTextValue, String description)
			throws Exception {
		List<WebElement> elmn = getElements(elementName);
		for (WebElement element : elmn) {
			if (element.getText().equalsIgnoreCase(expectedTextValue)) {

				element.click();
				HtmlReporter.WriteStep(description, "Select drop down value as=====>" + expectedTextValue + "",
						"Drop down value as=====>" + expectedTextValue + "is selected", true);
			} else {
				HtmlReporter.WriteStep(description,
						"Unable to select drop down value as=====>" + expectedTextValue + "",
						"Unable to select drop down value as=====>" + expectedTextValue + "", false);
			}
		}

	}

	public static void selectDropDownValueByVisibleText(String elementName, String text, String description)
			throws Exception {
		WebElement elmn = getElement(elementName);

		if (elmn.isDisplayed()) {
			Select select = new Select(elmn);
			select.selectByVisibleText(text);
			HtmlReporter.WriteStep(description, "Select drop down value as===>" + text + "",
					"Drop down value as====>" + text + "is selected", true);
		} else {
			HtmlReporter.WriteStep("Object not visible - " + description, "Enter Text", "Object not visible -", false);
		}

	}

	public static void selectDropDownValueByIndex(String elementName, int index, String description) throws Exception {
		WebElement elmn = getElement(elementName);

		if (elmn.isDisplayed()) {
			Select select = new Select(elmn);
			select.selectByIndex(index);
			HtmlReporter.WriteStep(description, "Select drop down value having===>" + index + "as index",
					"Drop down value having====>" + index + "as index is selected", true);
		} else {
			HtmlReporter.WriteStep("Object not visible - " + description, "Enter Index", "Object not visible -", false);
		}

	}

	public static void selectDropDownValueByValue(String elementName, String value, String description)
			throws Exception {
		WebElement elmn = getElement(elementName);

		if (elmn.isDisplayed()) {
			Select select = new Select(elmn);
			select.selectByValue(value);
			HtmlReporter.WriteStep(description, "Select drop down value having===>" + value + "as value",
					"Drop down value having====>" + value + "as value is selected", true);
		} else {
			HtmlReporter.WriteStep("Object not visible - " + description, "Enter value", "Object not visible -", false);
		}

	}

	public static void getText(String elementName, String expectedText, String description) throws Exception {
		WebElement elmn = getElement(elementName);
		String getTextValue = elmn.getText();
		if (elmn.isDisplayed() && getTextValue.equalsIgnoreCase(expectedText)) {
			HtmlReporter.WriteStep(description, "Expected get text value======>" + expectedText + "should be displayed",
					"Actual get text value as====>" + getTextValue + "is displayed", true);
		} else {
			HtmlReporter.WriteStep("Object not visible" + description,
					"Expected get text value======>" + expectedText + "should be displayed", "Object not visible - ",
					false);
		}
	}

	public static void getListValue(String elementName, int index, String description) throws Exception {
		List<WebElement> elmn = getElements(elementName);
		getValue = elmn.get(index).getText();
		if (elmn.get(index).getText().equalsIgnoreCase(getValue)) {
			elmn.get(index).click();
			HtmlReporter.WriteStep(description, "Select value as====>" + getValue + "",
					"Value" + getValue + "is selected", true);
		} else {
			HtmlReporter.WriteStep("Object not visible - " + description, "Select value as====>" + getValue + "",
					"Object not visible - ", false);
		}
	}

	public static void getTextBasedOnListIndex(String elementName, int index, String expectedText, String description)
			throws Exception {
		List<WebElement> elmn = getElements(elementName);
		actualText = elmn.get(index).getText().trim();

		if (actualText.equalsIgnoreCase(expectedText)) {
			System.out.println("================" + elmn.get(index).getText());
			HtmlReporter.WriteStep(description, "Expected get text value is====>" + elmn.get(index).getText() + "",
					"Actual get text value is===>" + elmn.get(index).getText() + "", true);
		} else {
			HtmlReporter.WriteStep(description, "Expected get text value is===>" + expectedText + "",
					"Actual get text value is===>" + elmn.get(index).getText() + "", false);
		}
	}

	public static void getTextBasedOnListIndex_1(String elementName, int index, String expectedText, String description)
			throws Exception {
		List<WebElement> elmn = getElements(elementName);
		actualText_1 = elmn.get(index).getText().trim();

		if (actualText_1.equalsIgnoreCase(expectedText)) {
			System.out.println("================" + elmn.get(index).getText());
			HtmlReporter.WriteStep(description, "Expected get text value is====>" + elmn.get(index).getText() + "",
					"Actual get text value is===>" + elmn.get(index).getText() + "", true);
		} else {
			HtmlReporter.WriteStep(description, "Expected get text value is===>" + expectedText + "",
					"Actual get text value is===>" + elmn.get(index).getText() + "", false);
		}
	}

	public static void getTextBasedOnListIndex1(String elementName, int index) throws Exception {
		List<WebElement> elmn = getElements(elementName);
		actualText = elmn.get(index).getText().trim();
	}

	
	public static void switchOnFrame(String elementName) throws Exception {
		WebElement elmn = getElement(elementName);
		driver.switchTo().frame(elmn);
	}
	
	public static void switchOnDefaultContent() throws Exception {
	
		driver.switchTo().defaultContent();
	}

	public static void getTextBasedOnListIndex2(String elementName, int index) throws Exception {
		List<WebElement> elmn = getElements(elementName);
		actualText2 = elmn.get(index).getText().trim();
	}

	public static void clickByIteration(String elementName, String expectedText, String description) throws Exception {

		List<WebElement> elmn = getElements(elementName);
		for (WebElement webElement : elmn) {
			if (webElement.getText().contains(expectedText)) {
				webElement.click();
				HtmlReporter.WriteStep(description, "Value to be selected====>" + expectedText + "",
						"Selected value is==>" + expectedText + "", true);
			}
		}

	}

	public static void getTextByIteration(String elementName, String expectedText, String description)
			throws Exception {

		List<WebElement> elmn = getElements(elementName);
		for (WebElement webElement : elmn) {
			if (webElement.getText().contains(expectedText)) {
				webElement.click();
				HtmlReporter.WriteStep(description, "Value to be selected====>" + expectedText + "",
						"Selected value is==>" + expectedText + "", true);
				break;
			} else {
				HtmlReporter.WriteStep(description, "Value to be selected====>" + expectedText + "",
						"Element not visible", false);
			}
		}

	}

	public static void getTextByIteration_1(String elementName, String expectedText, String description)
			throws Exception {

		List<WebElement> elmn = getElements(elementName);
		for (WebElement webElement : elmn) {

			HtmlReporter.WriteStep(description, webElement.getText(), webElement.getText(), true);
		}

	}

	public static void clearMethod(String elementName) {
		WebElement elmn = getElement(elementName);
		elmn.clear();
	}

	public static void clickBasedOnList(String elementName,String description)
			throws Exception {
		List<WebElement> elmn = getElements(elementName);
		for (int i = 0; i < elmn.size(); i++) {
			if(elmn.size()>0) {
				elmn.get(i).click();
			
				HtmlReporter.WriteStep(description + "====>" + i + " ", "Click",
						"Clicked", true);
			}else {
				HtmlReporter.WriteStep("Object not visible -" + description, "Click", "Oject not visible - ", false);

			}

		}}
				
				

			


			

	
	public static void clickBasedOnList_Index(String elementName, int index, String description) throws Exception {
		List<WebElement> elmn = getElements(elementName);
		if (elmn.size() > 0) {
			elmn.get(index).click();
			HtmlReporter.WriteStep(description, "Select option as===>" + elmn.get(index).getText() + " ",
					"Selected option as===>" + elmn.get(index).getText() + " ", true);
		} else {
			HtmlReporter.WriteStep("Object not visible -" + description, "Click", "Oject not visible - ", false);
		}
	}

	public static void clickBasedOnList_Text(String elementName, String textValue, String description)
			throws Exception {
		List<WebElement> elmn = getElements(elementName);
		for (WebElement webElement : elmn) {
			if (webElement.getText().equalsIgnoreCase(textValue)) {
				webElement.click();
				HtmlReporter.WriteStep(description, "Select option as===>" + webElement.getText() + "",
						"Selected option as===>" + webElement.getText() + "", true);

			} else {
				HtmlReporter.WriteStep("Object not visible -" + description, "Click", "Oject not visible - ", false);
			}
		}
	}

	public static void moveToElement(String elementName) {
		Actions action = new Actions(driver);
		WebElement elmn = getElement(elementName);
		action.moveToElement(elmn).build().perform();
	}

	public static void StaleElementHandleByID(String elementID) {
		int count = 0;
		while (count < 4) {
			try {
				WebElement elmn = getElement(elementID);
				elmn.click();
			} catch (StaleElementReferenceException e) {
				e.toString();
				System.out.println("Trying to recover from a stale element :" + e.getMessage());
				count = count + 4;
			}
		}
	}

	public static void enterTextBoxValueBasedOnList(String elementName, int index, String textBoxName,
			String textBoxValue, String description) throws Exception {
		List<WebElement> elmn = getElements(elementName);

		if (elmn.size() > 0) {
			elmn.get(index).sendKeys(textBoxValue);
			HtmlReporter.WriteStep(description,
					"Enter text box value as====>" + textBoxValue + "in thetext box===>" + textBoxName + "",
					"Entered text box value as===>" + textBoxValue + "in the text box===>" + textBoxName + "", true);
		} else {
			HtmlReporter.WriteStep("Object not visible - " + description, "Enter Text", "Object not visible - ", false);
		}
	}

	public static void waitForNumberOfWindowsEqualTo(final int numberOfWindows) {
		new WebDriverWait(driver, 60) {
		}.until(new ExpectedCondition<Boolean>() {

			public Boolean apply(WebDriver driver) {
				return (driver.getWindowHandles().size() == numberOfWindows);
			}

		});

	}

	public static void handleMultipleWindows() throws InterruptedException {
		Thread.sleep(8000);
		for (String winHandle : driver.getWindowHandles()) {
			System.out.println(winHandle);
			driver.switchTo().window(winHandle);
		}
	}

	public static void handleParentWindow() {
		String getWindowId = driver.getWindowHandle();
		parentWindowID = getWindowId;
		System.out.println("Parent Window IDs======>" + parentWindowID);
	}

	public static void switchOnParentWindow() throws InterruptedException {
		Thread.sleep(4000);
		System.out.println("Switch on parent window========>" + parentWindowID);
		driver.switchTo().window(parentWindowID);
	}

	public static void waitForElement(String elementName) {
		WebElement elmn = getElement(elementName);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(elmn));
		element.getSize();
	}

	public static void waitForPageLoad() {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(pageLoadCondition);
		} catch (Throwable error) {

		}
	}

	public static void getTextOnAlertPopup(String elementName, int index, String expectedText, String description)
			throws Exception {
		String actualText = driver.switchTo().alert().getText();

		if (actualText.equalsIgnoreCase(expectedText)) {
			HtmlReporter.WriteStep(description, "Expected get text value is====>" + expectedText + "",
					"Actual get text value is===>" + actualText + "", true);
		} else {
			HtmlReporter.WriteStep(description, "Expected get text value is====>" + expectedText + "",
					"Actual get text value is===>" + actualText + "", false);
		}
	}
	
	public static void acceptAlert(String description)
			throws Exception {
		
      driver.switchTo().alert().accept();
	}
	
	

	public static void doubleClick(String elementName) {
		WebElement elmn = getElement(elementName);
		Actions action = new Actions(driver);
		action.moveToElement(elmn).doubleClick().build().perform();
	}

	public static void getFirstSelectedOption(String elementName) {
		WebElement elmn = getElement(elementName);
		Select myselect = new Select(elmn);
		WebElement option = myselect.getFirstSelectedOption();
		getFirstSelectedOption = option.getText();

	}

	public static void getTextBoxListValue(String elementName, int index, String expectedText, String description)
			throws Exception {
		List<WebElement> optionsValue = getElements(elementName);
		String getValue = optionsValue.get(index).getAttribute("value");
		if (getValue.equalsIgnoreCase(expectedText)) {
			HtmlReporter.WriteStep(description, "Expected text box value====>" + expectedText + "",
					"Actual text box value====>" + getValue + "", true);
		} else {
			HtmlReporter.WriteStep(description, "Expected text box value====>" + expectedText + "",
					"Actual text box value====>" + getValue + "", false);
		}
	}

	public static void getTextBoxValue(String elementName, String expectedText, String description) throws Exception {
		WebElement elmn = getElement(elementName);
		String getValue = elmn.getAttribute("value");
		if (getValue.equalsIgnoreCase(expectedText)) {
			HtmlReporter.WriteStep(description, "Expected text box value====>" + expectedText + "",
					"Actual text box value====>" + getValue + "", true);
		} else {
			HtmlReporter.WriteStep(description, "Expected text box value====>" + expectedText + "",
					"Actual text box value====>" + getValue + "", false);
		}
	}

	public static void verifyFieldEditable(String elementName, String expectedLength, String description)
			throws Exception {
		WebElement elmn = getElement(elementName);
		String getAttributeValue = elmn.getAttribute("readonly");

		if (getAttributeValue.equalsIgnoreCase(expectedLength)) {
			HtmlReporter.WriteStep(description, "field is un-editable", "field is un-editable", true);
		} else {
			HtmlReporter.WriteStep(description, "field is un-editable", "field is editable", true);
		}
	}

	public static void triggerMail() {
		 
		// Create object of Property file
		Properties props = new Properties();
 
		// this will set host of server- you can change based on your requirement 
		props.put("mail.smtp.host", "smtp.gmail.com");
 
		// set the port of socket factory 
		props.put("mail.smtp.socketFactory.port", "465");
 
		// set socket factory
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
 
		// set the authentication to true
		props.put("mail.smtp.auth", "true");
 
		// set the port of SMTP server
		props.put("mail.smtp.port", "465");
 
		// This will handle the complete authentication
		Session session = Session.getDefaultInstance(props,
 
				new javax.mail.Authenticator() {
 
					protected PasswordAuthentication getPasswordAuthentication() {
 
					return new PasswordAuthentication("add your email", "add your password");
 
					}
 
				});
 
		try {
 
			// Create object of MimeMessage class
			Message message = new MimeMessage(session);
 
			// Set the from address
			message.setFrom(new InternetAddress("mukeshotwani.50@gmail.com"));
 
			// Set the recipient address
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("mukesh.otwani50@gmail.com"));
            
                        // Add the subject link
			message.setSubject("Testing Subject");
 
			// Create object to add multimedia type content
			BodyPart messageBodyPart1 = new MimeBodyPart();
 
			// Set the body of email
			messageBodyPart1.setText("This is message body");
 
			// Create another object to add another content
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
 
			// Mention the file which you want to send
			String filename = "G:\\a.xlsx";
 
			// Create data source and pass the filename
			DataSource source = new FileDataSource(filename);
 
			// set the handler
			messageBodyPart2.setDataHandler(new DataHandler(source));
 
			// set the file
			messageBodyPart2.setFileName(filename);
 
			// Create object of MimeMultipart class
			Multipart multipart = new MimeMultipart();
 
			// add body part 1
			multipart.addBodyPart(messageBodyPart2);
 
			// add body part 2
			multipart.addBodyPart(messageBodyPart1);
 
			// set the content
			message.setContent(multipart);
 
			// finally send the email
			Transport.send(message);
 
			System.out.println("=====Email Sent=====");
 
		} catch (MessagingException e) {
 
			throw new RuntimeException(e);
 
		}
 
	}
	
}
