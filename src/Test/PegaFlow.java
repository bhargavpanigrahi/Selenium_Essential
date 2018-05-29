
package Test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.ExcelData;

public class PegaFlow extends ExcelData {
	// public static int scenarioid=1;
	public static String status;
	public String caseNo;
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {

		/*for (scenarioid = 1; scenarioid <= lastrow; scenarioid++) {*/

			endToendFlow();

		}
	

	public static void endToendFlow() throws Exception {

		try {

			// TestDataDO currentData = ExcelProcessor.testDataList.get(1); //pass the run
			// number here

			System.setProperty("webdriver.ie.driver",

					"C:\\Users\\BHPANI\\Downloads\\IEDriverServer_Win32_2.48.0\\IEDriverServer.exe");

			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();

			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

			capabilities.setCapability("requireWindowFocus", true);

			driver = new InternetExplorerDriver(capabilities);

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.get(URL);

			driver.findElement(By.id("txtUserID")).sendKeys(Username);
			driver.findElement(By.id("txtPassword")).sendKeys(Password);

			Actions action1 = new Actions(driver);
			action1.moveToElement(driver.findElement(By.xpath("//button[@id='sub']"))).doubleClick().build().perform();

			waitForElement(driver, "(//img[@class='pzbtn-img'])[1]");

			driver.findElement(By.xpath("(//img[@class='pzbtn-img'])[1]")).click();

			WebElement web = driver.findElement(By.xpath("//td[contains(.,'Seguro com Base em S6')]"));
			Actions actions = new Actions(driver);
			actions.moveToElement(web).doubleClick().build().perform();

			driver.switchTo().frame("PWGadget1Ifr");
			Thread.sleep(1000);
			waitForElement(driver, "//input[@id='PolicyNumber']");
			driver.findElement(By.xpath("//input[@id='PolicyNumber']")).sendKeys(PolicyNo);

			driver.findElement(By.xpath("//input[@id='EventDate']")).sendKeys(Evntdate);

			driver.findElement(By.xpath("//button[@class='pzhc']")).click();

			Actions action = new Actions(driver);
			action.moveToElement(
					driver.findElement(By.xpath("//tr[@class=' listTableRowStyle']/td[contains(.,'N707P66300')]")))
					.doubleClick().build().perform();

			waitForElement(driver, "//select[@name='$PPolicyPage$pProduct']");
			WebElement ele = driver.findElement(By.xpath("//select[@name='$PPolicyPage$pProduct']"));

			Select sel = new Select(ele);
			sel.selectByValue(Product);

			waitmenthod1(driver, "//select[@id='ScheduleOfBenefits']");
			WebElement ele1 = driver.findElement(By.xpath("//select[@id='ScheduleOfBenefits']"));

			Select sel1 = new Select(ele1);
			sel1.selectByValue(scheduleOfbenefits);

			waitForElement(driver, "//select[@id='SIS_CoverageCode']");
			WebElement ele2 = driver.findElement(By.xpath("//select[@id='SIS_CoverageCode']"));

			Select sel2 = new Select(ele2);
			sel2.selectByValue(SIScoverage);

			waitForElement(driver, "//select[@id='CoverageType']");
			WebElement ele3 = driver.findElement(By.xpath("//select[@id='CoverageType']"));

			Select sel3 = new Select(ele3);
			sel3.selectByValue(coverage);

			waitmenthod1(driver, "//input[@name='$PpyWorkPage$pOccupation']");
			driver.findElement(By.xpath("//input[@name='$PpyWorkPage$pOccupation']")).sendKeys(occupation);

			try {
				waitmenthod1(driver, "//table[@class='gridTable ']/tbody/tr");
				List<WebElement> listItems = driver.findElements(By.xpath("//table[@class='gridTable ']/tbody/tr"));
				Thread.sleep(2000);

				listItems.get(7).click();
			} catch (Exception e) {

			}

			waitForElement(driver, "//input[@id='ClaimedPersonalID']");
			driver.findElement(By.xpath("//input[@id='ClaimedPersonalID']")).click();

			waitForElement(driver, "(//input[@name='$PpyWorkPage$pClaimedSameAsInsured'])[2]");
			driver.findElement(By.xpath("(//input[@name='$PpyWorkPage$pClaimedSameAsInsured'])[2]")).click();

			waitmenthod1(driver, "//select[@id='ClaimedInsuredRelationship']");
			WebElement ele4 = driver.findElement(By.xpath("//select[@id='ClaimedInsuredRelationship']"));
			Select sel4 = new Select(ele4);
			sel4.selectByValue(relationship);

			waitForElement(driver, "//input[@id='CCRepClaimant_FullName']");
			driver.findElement(By.xpath("//input[@id='CCRepClaimant_FullName']")).click();

			waitForElement(driver, "(//input[@name='$PpyWorkPage$pCCRepSameAsInsured'])[2]");
			driver.findElement(By.xpath("(//input[@name='$PpyWorkPage$pCCRepSameAsInsured'])[2]")).click();
			Thread.sleep(1000);

			waitmenthod1(driver, "//select[@id='CCRepClaimant_ProvinceCode']");
			WebElement ele5 = driver.findElement(By.xpath("//select[@id='CCRepClaimant_ProvinceCode']"));
			Select sel5 = new Select(ele5);
			sel5.selectByValue(provincecode);

			waitmenthod1(driver, "//input[@id='Description']");
			driver.findElement(By.xpath("//input[@id='Description']")).sendKeys(eventdescription);

			waitmenthod1(driver, "//input[@id='SubClaimDescription']");
			driver.findElement(By.xpath("//input[@id='SubClaimDescription']")).sendKeys(subclaimdescription);

			waitForElement(driver, "//select[@id='CauseCode']");
			WebElement ele6 = driver.findElement(By.xpath("//select[@id='CauseCode']"));
			Actions act = new Actions(driver);
			act.moveToElement(ele6).build().perform();

			waitForLoad(driver);
			Select sel6 = new Select(ele6);
			Thread.sleep(1000);
			sel6.selectByVisibleText(causecode);

			waitForElement(driver, "//select[@id='SubClaimCode']");
			WebElement ele7 = driver.findElement(By.xpath("//select[@id='SubClaimCode']"));
			act.moveToElement(ele7).build().perform();
			waitForLoad(driver);
			Select sel7 = new Select(ele7);
			Thread.sleep(1000);
			sel7.selectByVisibleText(subclaimcode);

			waitForLoad(driver);
			waitForElement(driver, "//select[@id='ClaimType']");
			WebElement ele8 = driver.findElement(By.xpath("//select[@id='ClaimType']"));
			act.moveToElement(ele8).build().perform();
			Thread.sleep(1000);
			waitForLoad(driver);
			Select sel8 = new Select(ele8);
			Thread.sleep(1000);
			sel8.selectByVisibleText(claimtype);

			waitForLoad(driver);
			waitForElement(driver, "//select[@id='ContributingFactor']");
			WebElement ele10 = driver.findElement(By.xpath("//select[@id='ContributingFactor']"));
			act.moveToElement(ele10).build().perform();
			waitForLoad(driver);
			Select sel10 = new Select(ele10);
			Thread.sleep(1000);
			sel10.selectByVisibleText(contributingfactor);

			waitForLoad(driver);
			waitForElement(driver, "//select[@name='$PpyWorkPage$pCauseOfLoss']");
			WebElement ele9 = driver.findElement(By.xpath("//select[@name='$PpyWorkPage$pCauseOfLoss']"));
			act.moveToElement(ele9).build().perform();
			waitForLoad(driver);
			Select sel9 = new Select(ele9);
			Thread.sleep(1000);
			sel9.selectByVisibleText(causeofloss);

			waitForLoad(driver);
			waitForElement(driver, "//select[@id='ConditionCode']");
			WebElement ele11 = driver.findElement(By.xpath("//select[@id='ConditionCode']"));
			act.moveToElement(ele11).build().perform();
			waitForLoad(driver);
			Select sel11 = new Select(ele11);
			Thread.sleep(1000);
			sel11.selectByVisibleText(conditioncode);

			waitForElement(driver, "//button[contains(.,'With Out Claimkit')]");
			driver.findElement(By.xpath("//button[contains(.,'With Out Claimkit')]")).click();
			Thread.sleep(3000);
			WebElement web1 = driver.findElement(By.xpath("//a[contains(.,'CaseSetupOfFile')]"));
			Actions acti = new Actions(driver);
			acti.moveToElement(web1).doubleClick().build().perform();
			Thread.sleep(3000);
			WebElement ment = driver.findElement(By.xpath("(//button[@class='buttonTdButton'])[1]"));
			String str1 = ment.getText();
			System.out.println("====================>" + str1);

			Thread.sleep(1000);

			List<WebElement> frames1 = driver.findElements(By.tagName("iframe"));

			int frame1 = frames1.size();
			for (int i = 0; i < frame1; i++) {
				String names1 = frames1.get(i).getAttribute("name");
				System.out.println(frame1);
				System.out.println("=========>" + names1);
			}

			driver.switchTo().frame("actionIFrame");

			List<WebElement> listItems1 = driver.findElements(By.xpath("//input[@id='DocCheck']"));

			System.out.println("===================>" + listItems1.size());
			Thread.sleep(2000);

			for (int i = 0; i < listItems1.size(); i++) {
				try {

					Thread.sleep(1000);
					listItems1.get(i).click();

					Thread.sleep(2000);

				} catch (Exception e) {

				}

			}

			Thread.sleep(2000);

			driver.findElement(By.xpath("//button[@id='submitButton']")).click();

			Thread.sleep(3000);

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PWGadget1Ifr");

			List<WebElement> frames = driver.findElements(By.tagName("iframe"));

			int frame = frames.size();
			for (int i = 0; i < frame; i++) {
				String names = frames.get(i).getAttribute("name");
				System.out.println(frame);
				System.out.println("================>" + names);
			}

			Thread.sleep(1000);

			driver.switchTo().frame("actionIFrame");

			new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS)
					.ignoring(InvalidSelectorException.class);

			driver.findElement(By.id("ConfirmPolicyNumber")).click();
			Thread.sleep(1000);

			driver.findElement(By.xpath("(//input[@id='ConfirmSISPolicyNumber'])[1]")).click();
			Thread.sleep(1000);

			driver.findElement(By.xpath("//input[@id='ConfirmEventDate']")).click();
			Thread.sleep(1000);

			driver.findElement(By.xpath("//input[@id='ConfirmEventDescription']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//input[@id='ConfirmSISPolicyNumber'])[2]")).click();
			Thread.sleep(1000);

			driver.findElement(By.id("VerifyPotentialForRecoveryNo")).click();

			driver.findElement(By.id("CauseOfDeath")).sendKeys(causeofdeath);

			driver.findElement(By.id("CestaBasicaNo")).click();
			Thread.sleep(2000);
			driver.findElement(By.name("$PpyWorkPage$pMedicalDiagnosis")).sendKeys(medicaldiagnosis);

			driver.findElement(By.id("submitButton")).click();

			Thread.sleep(3000);

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PWGadget1Ifr");

			List<WebElement> frames2 = driver.findElements(By.tagName("iframe"));

			int frame2 = frames2.size();
			for (int i = 0; i < frame2; i++) {
				String names1 = frames2.get(i).getAttribute("name");
				System.out.println(frame2);
				System.out.println("================>" + names1);
			}

			Thread.sleep(1000);

			driver.switchTo().frame("actionIFrame");
			Thread.sleep(1000);
			driver.findElement(By.id("submitButton")).click();

			Thread.sleep(3000);

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PWGadget1Ifr");

			List<WebElement> frames3 = driver.findElements(By.tagName("iframe"));

			int frame3 = frames3.size();
			for (int i = 0; i < frame3; i++) {
				String names2 = frames3.get(i).getAttribute("name");
				System.out.println(frame3);
				System.out.println("================>" + names2);
			}

			Thread.sleep(1000);

			driver.switchTo().frame("actionIFrame");
			Thread.sleep(1000);

			waitForLoad(driver);
			Thread.sleep(1000);
			driver.findElement(By.id("NumberOfEvents")).sendKeys(numberofevents);

			WebElement type = driver.findElement(By.xpath("//select[@id='BenefitType']"));

			Select select = new Select(type);
			select.selectByValue(benefittype);
			waitForLoad(driver);
			Thread.sleep(2000);
			driver.findElement(By.id("TotalClaimAmount")).sendKeys(totalclaimAmt);
			Thread.sleep(2000);
			WebElement bentype = driver.findElement(By.xpath("//select[@id='BenificiaryType']"));

			Select select1 = new Select(bentype);
			select1.selectByVisibleText(benificiarytype);

			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@class='iconInsert']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='IsSelectedBen']")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("BENBeneficiaryName")).sendKeys(beneficiaryname);
			Thread.sleep(1000);
			WebElement benrel = driver.findElement(By.xpath("//select[@id='BENRelationship']"));
			Thread.sleep(1000);
			Select select2 = new Select(benrel);
			select2.selectByVisibleText(Benrelationship);

			WebElement IndemnityTypeCode = driver.findElement(By.xpath("//select[@id='IndemnityTypeCode']"));
			Thread.sleep(1000);
			Select select3 = new Select(IndemnityTypeCode);
			select3.selectByVisibleText(indemnitytypecode);

			Thread.sleep(1000);
			driver.findElement(By.id("submitButton")).click();
			Thread.sleep(1000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("PWGadget1Ifr");

			List<WebElement> frames4 = driver.findElements(By.tagName("iframe"));

			int frame4 = frames4.size();
			for (int i = 0; i < frame4; i++) {
				String names3 = frames4.get(i).getAttribute("name");
				System.out.println(frame4);
				System.out.println("================>" + names3);
			}

			Thread.sleep(1000);

			driver.switchTo().frame("actionIFrame");
			Thread.sleep(1000);

			driver.findElement(By.xpath("//input[@class='Beneficiary Selection']")).click();
			Thread.sleep(1000);

			waitmenthod1(driver, "//span[text()='NO' or contains(.,'YES')]");

			driver.findElement(By.xpath("//textarea[@id='pyNote']")).sendKeys(comment);
			Thread.sleep(1000);

			driver.findElement(By.xpath("//button[@id='submitButton']")).click();
			Thread.sleep(1000);

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PWGadget1Ifr");

			List<WebElement> frames5 = driver.findElements(By.tagName("iframe"));

			int frame5 = frames5.size();
			for (int i = 0; i < frame5; i++) {
				String names4 = frames5.get(i).getAttribute("name");
				System.out.println(frame5);
				System.out.println("================>" + names4);
			}

			Thread.sleep(1000);

			driver.switchTo().frame("actionIFrame");

			WebElement payltr = driver.findElement(By.xpath("//select[@id='isGenerate']"));
			Thread.sleep(1000);
			Select selec = new Select(payltr);
			selec.selectByVisibleText(paymentletter);

			driver.findElement(By.xpath("//input[@id='ReceiptDate']")).sendKeys(receiptdate);

			driver.findElement(By.xpath("(//img[@class='inactvIcon'])[2]")).click();

			driver.findElement(By.xpath("//td[@id='nextMonth']")).click();

			driver.findElement(By.xpath("//a[contains(.,'10')]")).click();

			WebElement payMtd = driver.findElement(By.xpath("(//select[@id='<%=propName%>'])[1]"));
			Thread.sleep(1000);
			Select selec1 = new Select(payMtd);
			selec1.selectByValue(paymentmethod);

			WebElement payMode = driver.findElement(By.xpath("(//select[@id='<%=propName%>'])[2]"));
			Thread.sleep(1000);
			Select selec2 = new Select(payMode);
			selec2.selectByValue(paymentmode);

			driver.findElement(By.xpath("//input[@id='PaymentDescription1']")).sendKeys(paymentdescription);

			driver.findElement(By.xpath("//input[@id='PaymentToSend1']")).click();

			Thread.sleep(1000);
			driver.findElement(By.id("submitButton")).click();

			Thread.sleep(1000);

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PWGadget1Ifr");

			List<WebElement> frames6 = driver.findElements(By.tagName("iframe"));

			int frame6 = frames6.size();
			for (int i = 0; i < frame6; i++) {
				String names5 = frames6.get(i).getAttribute("name");
				System.out.println(frame6);
				System.out.println("================>" + names5);
			}

			Thread.sleep(1000);

			driver.switchTo().frame("actionIFrame");

			driver.findElement(By.id("submitButton")).click();

			driver.switchTo().defaultContent();

			waitmenthod1(driver, "(//label[@id='tabTitle'])[1]");

			String caseNo = driver.findElement(By.xpath("(//label[@id='tabTitle'])[1]")).getText();

			driver.findElement(By.xpath("//span[@class='menu-item-title']")).click();

			Thread.sleep(1000);
			driver.switchTo().frame("PWGadget2Ifr");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='CaseNumber']")).sendKeys(caseNo);

			driver.findElement(By.xpath("//button[@class='pzhc']/div[contains(.,'Search')]")).click();

			status = driver.findElement(By.xpath("//tr[@class=' listTableRowStyle']/td[6]")).getText();

			System.out.println("The status of the payment is : " + status);

			int i = 0;
			while ((!status.trim().equalsIgnoreCase("Pending - All Payments Conf")) && i < 15) {
				if ((!status.trim().equalsIgnoreCase("Pending - All Payments Conf")))

				{
					Thread.sleep(1000);
					driver.findElement(By.xpath("//input[@id='CaseNumber']")).clear();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//input[@id='CaseNumber']")).sendKeys(caseNo);
					Thread.sleep(1000);
					driver.findElement(By.xpath("//button[@class='pzhc']/div[contains(.,'Search')]")).click();

					status = driver.findElement(By.xpath("//tr[@class=' listTableRowStyle']/td[6]")).getText();
					Thread.sleep(20000);
				}
				i++;

			}
			System.out.println("The status of the payment is : " + status);

		} catch (StaleElementReferenceException e) {

		}
	}

	public static void waitForElement(WebDriver driver, String xpath) throws InterruptedException {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

	}

	public static void waitForLoad(WebDriver driver) {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(pageLoadCondition);
	}

	public static void waitmenthod(final String idvalue) {

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)

				.withTimeout(30, TimeUnit.SECONDS)

				.pollingEvery(5, TimeUnit.SECONDS)

				.ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver) {

				return driver.findElement(By.id(idvalue));

			}
		});

	}

	public static void waitmenthod1(WebDriver driver, final String Xpath) throws InterruptedException {

		Thread.sleep(1000);
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)

				.withTimeout(120, TimeUnit.SECONDS)

				.pollingEvery(10, TimeUnit.SECONDS)

				.ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver) {

				WebElement element = driver.findElement(By.xpath(Xpath));
				if (element.getSize() == null) {
					System.out.println("FluentWait failed");
					return null;

				} else {
					return element;
				}
			}
		});

	}

	public static void waitmenthod3(String classNamevalue) {

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)

				.withTimeout(30, TimeUnit.SECONDS)

				.pollingEvery(5, TimeUnit.SECONDS)

				.ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver) {

				return driver.findElement(By.className("classNamevalue"));

			}
		});

	}

}
