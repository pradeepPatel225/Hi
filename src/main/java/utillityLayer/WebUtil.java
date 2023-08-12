package utillityLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebUtil {
	public  WebDriver driver;
	public ExtentReports extentReportObj;
	private ExtentTest extLogger;
	public Actions actionObj;
	public Select selectObj;

	
	
	
	
	/**
	 * @Purpose - For Generate the report
	 * @Parameter - String ,String
	 * @Work - by using this method we can generate the report in our folder
	 * @Return - void
	 */
	public void initHtmlReport() {

		DateFormat dateAndTime = new SimpleDateFormat("hh-mm-ss _ dd-MM-yyyy");
		String curentDateAndTime = dateAndTime.format(new Date());
		File fls = new File("src\\test\\resources\\TestReport\\" + curentDateAndTime + ".html");
		ExtentSparkReporter exr = new ExtentSparkReporter(fls);
		extentReportObj = new ExtentReports();
		extentReportObj.attachReporter(exr);
		extentReportObj.setSystemInfo("Os Name", System.getProperty("os.name"));
		extentReportObj.setSystemInfo("BrowserName", "Chrome");
		extentReportObj.setSystemInfo(" Envoirment", " QA");
		extentReportObj.setSystemInfo("UserName", "Pradeep Gupta");
		System.out.println("Report intilized successfully");
		
	}


	public ExtentTest setExtentLogger(String testCaseId) {
		extLogger = extentReportObj.createTest(testCaseId);
		return extLogger;

	}



	/**
	 * @Purpose - For flushed the previous report
	 * @Parameter -
	 * @Work - by using this method we can flushed the previous report
	 * @Return - void
	 */
	public void flushReport() {
		extentReportObj.flush();
		System.out.println("Report is Flushed sucessfully");
		extLogger.log(Status.INFO, " Report is Flushed successfully");

	}



	/**
	 * @Purpose - Browser Launch
	 * @Parameter - String
	 * @Work - by using this method we can launch browsers , it will provide
	 *       implicitlyWait
	 * @Return - void
	 */
	public void launchBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions cop = new ChromeOptions();
			cop.addArguments("remote-allow-origins=*");
			driver = new ChromeDriver(cop);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			System.out.println(browserName + " browser is launched successfully");
			extLogger.log(Status.INFO, browserName + " browser is launched successfully");

		} else if (browserName.equalsIgnoreCase("firefox")) {
//			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
			System.out.println(browserName + " browser is launched successfully");
			extLogger.log(Status.INFO, browserName + " browser is launched successfully");

		} else if (browserName.equalsIgnoreCase("IO")) {
//			WebDriverManager.chromedriver().setup();
			EdgeOptions eo = new EdgeOptions();
			eo.addArguments("--remote-allow-origins=*");
			driver = new EdgeDriver(eo);
			System.out.println(browserName + " browser is launched successfully");
			extLogger.log(Status.INFO, browserName + " browser is launched successfully");

		} else if (browserName.equalsIgnoreCase("Safari")) {
			WebDriverManager.chromedriver().setup();
			driver = new SafariDriver();
			System.out.println(browserName + " browser is launched successfully");
			extLogger.log(Status.INFO, browserName + " browser is launched successfully");

		}

	}



	/**
	 * @Purpose - Hit the Url
	 * @Parameter - String
	 * @Work - By using this method we can hit the URL
	 * @Return - void
	 */
	public void hitUrl(String url) {
		try {
			driver.get(url);
			System.out.println(url + " This Url is hit successfully by using get() method");
			extLogger.log(Status.INFO, url + " This Url is hit successfully by using get() method");

		} catch (Exception e) {
			driver.navigate().to(url);
			System.out.println(url + " This Url is hit successfully by using navigate.To()");
			extLogger.log(Status.INFO, url + " This Url is hit successfully by using navigate.To()");
		}

	}



	/**
	 * @Purpose - Close the browser
	 * @Parameter - String
	 * @Work - By using this method we can close the current browser
	 * @Return - void
	 */
	public void close() {
		driver.close();
		System.out.println("Browser closed successfully");
		extLogger.log(Status.INFO, " Browser closed successfully");

	}



	/**
	 * @Purpose - Close all the browser
	 * @Parameter - String
	 * @Work - By using this method we can close the all browser
	 * @Return - void
	 */
	public void quit() {
		driver.quit();
		System.out.println("Browser closed successfully");
		extLogger.log(Status.INFO, " Browser closed successfully");

	}



	public String configDataRead(String passKeyName) {
		InputStream fis;
		Properties propObj = null;
		try {
			fis = new FileInputStream("Config.properties");
			propObj = new Properties();
			propObj.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String data = propObj.getProperty(passKeyName);
		return data;
	}


	/**
	 * @Purpose - Input data in text box
	 * @Parameter - WebElement,String,String
	 * @Work - By using this method we can input the data in the text box
	 * @Return - void
	 */
	public void sendkeys(WebElement we, String inputData, String elementName) {

		try {
			verifyElementIsDisplyed(we, elementName);
			verifyElementIsEnabled(we, elementName);
			we.clear();
			we.sendKeys(inputData);
			System.out.println(inputData + " is entered successfully in " + elementName);
			extLogger.log(Status.INFO, inputData + " is entered successfully in " + elementName);

		} catch (ElementNotInteractableException e) {
			verifyElementIsDisplyed(we, elementName);
			verifyElementIsEnabled(we, elementName);
			we.clear();
			jsSendkeys(we, inputData, elementName);
			System.out.println(
					inputData + " is entered successfully in " + elementName + " with the  help of javaScript");
			extLogger.log(Status.INFO,
					inputData + " is entered successfully in " + elementName + " with the  help of javaScript");

		} catch (NoSuchElementException e) {
			verifyElementIsDisplyed(we, elementName);
			verifyElementIsEnabled(we, elementName);
			we.clear();
			actionSendkeys(we, inputData, elementName);
			System.out.println(inputData + " is entered successfully in " + elementName
					+ " with the  help of actions class sendkeys");
			extLogger.log(Status.INFO, inputData + " is entered successfully in " + elementName
					+ " with the  help of actions class sendkeys");

		}
	}



	/**
	 * @Purpose - handle pop up massages
	 * @Parameter - String
	 * @Work - By using this method we can handle the pop up massage
	 * @Return - void
	 */
	public void popPupHandle(String choosePopupCondition) {
		if (choosePopupCondition.equalsIgnoreCase("accept")) {
			driver.switchTo().alert().accept();
			System.out.println("Popup Accepted Successfully");
			extLogger.log(Status.INFO, " Popup Accepted Successfully");

		} else if (choosePopupCondition.equalsIgnoreCase("dismiss")) {
			driver.switchTo().alert().dismiss();
			System.out.println("Popup dismissed Successfully");
			extLogger.log(Status.INFO, "Popup dismissed Successfully");

		}

	}



	/**
	 * @Purpose - Handle Iframe
	 * @Parameter - int,String
	 * @Work - By using this method we can handle iframe by index
	 * @Return - void
	 */
	public void handleIframe(int index, String elementName) {
		driver.switchTo().frame(index);
		System.out.println(elementName + " " + "Iframe is handled successfully by Index");
		extLogger.log(Status.INFO, elementName + " " + "Iframe is handled successfully by Index");

	}

	/**
	 * @Purpose - Handle Iframe
	 * @Parameter - WebElement,String
	 * @Work - By using this method we can handle iframe by WebElement
	 * @Return - void
	 */
	public void handleIframe(WebElement we, String elementName) {
		driver.switchTo().frame(we);
		System.out.println(elementName + " " + "Iframe is handled successfully by Weblement");
		extLogger.log(Status.INFO, elementName + " " + "Iframe is handled successfully by Weblement");

	}

	/**
	 * @Purpose - Handle Iframe
	 * @Parameter - String,String
	 * @Work - By using this method we can handle iframe by Id or Name
	 * @Return - void
	 */
	public void handleIframe(String idOrName, String elementName) {
		driver.switchTo().frame(idOrName);
		System.out.println(elementName + " " + "Iframe is handled successfully by Id or Name");
		extLogger.log(Status.INFO, elementName + " " + "Iframe is handled successfully by Id or Name");

	}

	/**
	 * @Purpose - Handle dropdown
	 * @Parameter - WebElement,String,String
	 * @Work - By using this method we will select theme selectByIndex
	 * @Return - void
	 */
	public void selectByIndex(WebElement we, int index, String elementName) {

		selectObj = new Select(we);
		try {
			selectObj.selectByIndex(index);

		} catch (StaleElementReferenceException e) {

			selectObj = new Select(we);
			selectObj.selectByIndex(index);
		}
		System.out.println(elementName + " drop down is selected successfully");
		extLogger.log(Status.INFO, elementName + " drop down is selected successfully");

	}

	/**
	 * @Purpose - Handle dropdown
	 * @Parameter - WebElement,String,String
	 * @Work - By using this method we will select theme selectByVisibleText
	 * @Return - void
	 */
	public void selectByVisibleText(WebElement we, String visibleTextOrValue, String elementName) {

		selectObj = new Select(we);
		try {
			selectObj.selectByVisibleText(visibleTextOrValue);

		} catch (StaleElementReferenceException e) {

			selectObj = new Select(we);
			selectObj.selectByValue(visibleTextOrValue);
		}

		System.out.println(elementName + " drop down " + visibleTextOrValue + " is selected successfully");
		extLogger.log(Status.INFO, elementName + " drop down " + visibleTextOrValue + " is selected successfully");

	}

	/**
	 * @Purpose - Handle dropdown
	 * @Parameter - WebElement,String,String
	 * @Work - By using this method we will select theme selectByValue
	 * @Return - void
	 */
	public void selectByValue(WebElement we, String Value, String elementName) {

		selectObj = new Select(we);
		try {
			selectObj.selectByVisibleText(Value);

		} catch (StaleElementReferenceException e) {

			selectObj = new Select(we);
			selectObj.selectByValue(Value);
		}

		System.out.println(elementName + " drop down " + Value + " is selected successfully");
		extLogger.log(Status.INFO, elementName + " drop down " + Value + " is selected successfully");

	}

	/**
	 * @Purpose - Mouseover on any element
	 * @Parameter - WebElementd,String
	 * @Work - By using this method we can click on any element
	 * @Return - void
	 */
	public void mouseOver(WebElement we, String elementName) {
		actionObj = new Actions(driver);
		actionObj.moveToElement(we).build().perform();
		System.out.println("MouseOver successflly on " + elementName);
		extLogger.log(Status.INFO, "MouseOver successflly on " + elementName);

	}

	/**
	 * @Purpose - Click on element
	 * @Parameter - WebElementd,String,String
	 * @Work - By using this method we can click on any element
	 * @Return - void
	 */
	public void actionSendkeys(WebElement we, String inputData, String elementName) {

		try {

			actionObj = new Actions(driver);
			actionObj.sendKeys(we, inputData).build().perform();

		} catch (StaleElementReferenceException e) {

			actionObj = new Actions(driver);
			actionObj.sendKeys(we, inputData).build().perform();
		}
		System.out.println(
				inputData + " is entered successfully in " + elementName + " with the  help of actions class sendkeys");
		extLogger.log(Status.INFO,
				inputData + " is entered successfully in " + elementName + " with the  help of actions class sendkeys");

	}

	/**
	 * @Purpose - Click on element
	 * @Parameter - String,String
	 * @Work - By using this method we can click on any element
	 * @Return - void
	 */
	public void actionClick(WebElement we, String elementName) {

		try {

			actionObj = new Actions(driver);
			actionObj.click(we).build().perform();

		} catch (Exception e) {

			actionObj = new Actions(driver);
			actionObj.click(we).build().perform();
		}
		System.out.println(elementName + " is clicked successfully with the help of actionClick");
		extLogger.log(Status.INFO, elementName + " is clicked successfully with the help of actionClick");

	}

	/**
	 * @Purpose - Double click on any element
	 * @Parameter - String,String
	 * @Work - By using this method we can Double click on any element
	 * @Return - void
	 */
	public void doubleClick(WebElement we, String elementName) {

		actionObj = new Actions(driver);
		actionObj.doubleClick(we).build().perform();
		System.out.println("double click is done successfully on " + elementName);
		extLogger.log(Status.INFO, "double click is done successfully on " + elementName);

	}

	/**
	 * @Purpose - Right click on any element
	 * @Parameter - String,String
	 * @Work - By using this method we can right click on any element
	 * @Return - void
	 */
	public void rightClick(WebElement we, String elementName) {

		actionObj = new Actions(driver);
		actionObj.contextClick(we).build().perform();
		System.out.println("Right click is done successfully on " + elementName);
		extLogger.log(Status.INFO, "Right click is done successfully on " + elementName);

	}

	/**
	 * @Purpose - One element to other element Drag and Drop
	 * @Parameter - WebElement,WebElement,WebElement,String
	 * @Work - By using this method we can Drag and Drop One element to other
	 *       element
	 * @Return - void
	 */
	public void dragAndDrop(WebElement weDrag, WebElement weDrop, String elementName) {

		try {

			actionObj = new Actions(driver);
			actionObj.dragAndDrop(weDrag, weDrop).build().perform();

		} catch (StaleElementReferenceException e) {

			actionObj = new Actions(driver);
			actionObj.dragAndDrop(weDrag, weDrop).build().perform();
		}
		System.out.println(elementName + " is dpropped successfuly");
		extLogger.log(Status.INFO, elementName + " is dpropped successfuly");

	}

	/**
	 * @Purpose - Click on element
	 * @Parameter - String,String
	 * @Work - By using this method we can click on any element
	 * @Return - void
	 */
	public void jsClick(WebElement we, String elementName) {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", we);
		System.out.println(elementName + " is clicked succesfully by js click");
		extLogger.log(Status.INFO, elementName + " is clicked succesfully by js click");

	}

	/**
	 * @Purpose - Input data in text box
	 * @Parameter - WebElement,String,String
	 * @Work - By using this method we can input the value in the text box
	 * @Return - void
	 */
	public void jsSendkeys(WebElement we, String inputData, String elementName) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].value='" + inputData + "'", we);
		System.out.println(inputData + " is entered successfully in " + elementName + " with the  help of javaScript");
		extLogger.log(Status.INFO,
				inputData + " is entered successfully in " + elementName + " with the  help of javaScript");
	}

	/**
	 * @Purpose - Click on element
	 * @Parameter - String,String
	 * @Work - By using this method we can click on any element
	 * @Return - void
	 */
	public void click(WebElement we, String elementName) {

		try {
			we.click();
			System.out.println(elementName + " is clicked successfully");
			extLogger.log(Status.INFO, elementName + " is clicked successfully");

		} catch (ElementNotInteractableException e) { // Parnet
			jsClick(we, elementName);

		} catch (StaleElementReferenceException e) {

			we.click();
			System.out.println("Find fresh xpath successfully");
			extLogger.log(Status.INFO, "Find fresh xpath successfully");

		}
	}


	/**
	 * @Purpose - Take the Screenshot
	 * @Parameter - String
	 * @Work - By using this method we can get the screenshot of failed page
	 * @Return - void
	 */
	public void takeScreenShot(String Name) {
		try {
			TakesScreenshot tc = (TakesScreenshot) driver;
			File from = tc.getScreenshotAs(OutputType.FILE);
			File to = new File("src\\test\\resources\\Snapshot\\" + Name + "Snapshot.png");
			Files.copy(from, to);
			String imagePath = to.getAbsolutePath();
			extLogger.addScreenCaptureFromPath(imagePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/// stale element excepection

	/**
	 * @Purpose - Fetch the Attribute
	 * @Parameter - String,String
	 * @Work - By using this method we can Fetch the attribute value of that element
	 *       and validate that attribute value
	 * @Return - void
	 */
	public String getAtribute(WebElement we, String AtributeName) {

		String actualAtrValue = "";
		try {
			actualAtrValue = we.getAttribute(AtributeName);
			System.out.println("Attribute value of " + AtributeName + " is successfully fetched");
			extLogger.log(Status.INFO, "Attribute value of " + AtributeName + " is successfully fetched");

			return actualAtrValue;

		} catch (StaleElementReferenceException e) {
			String weObj = we.toString();
			String arr[] = weObj.split(":");
			String lastvalue = arr[arr.length - 1];
			String freshxpath = lastvalue.substring(0, lastvalue.length() - 1).trim();
			we = driver.findElement(By.xpath(freshxpath));
		}
		return actualAtrValue;
	}




	/**
	 * @Purpose - Fetch the InnqerText
	 * @Parameter - String,String
	 * @Work - By using this method we can Fetch the InnerText of that element and
	 *       validate that text
	 * @Return - void
	 */
	public void getText(WebElement we, String expectedText, String elementName) {

		String actualText;
		try {
			actualText = we.getText();
		} catch (StaleElementReferenceException e) {

			actualText = we.getText();
		}
		if (actualText.equalsIgnoreCase(expectedText)) {
			System.out.println("Verification is passed Inner text of " + elementName + " is actual text==> "
					+ actualText + " successfully fetched");
			extLogger.log(Status.PASS, "Verification is passed Inner text of " + elementName + " is actual text==> "
					+ actualText + " successfully fetched");

		} else {
			System.out.println("Verification is failed Inner text of " + elementName + " is actual text==> "
					+ actualText + " successfully fetched");
			extLogger.log(Status.FAIL, "Verification is failed Inner text of " + elementName + " is actual text==> "
					+ actualText + " successfully fetched");

		}
		Assert.assertEquals(actualText, expectedText);
	}




	/**
	 * @Purpose - Handle Multiple window
	 * @Parameter - String
	 * @Work - By using this method we can Switch the window by Url
	 * @Return - void
	 */
	public void switchWindowByUrl(String expUrl) {
		Set<String> setWindowColl = driver.getWindowHandles();
		for (String handle : setWindowColl) {
			driver.switchTo().window(handle);
			String actUrl = driver.getCurrentUrl();
			if (actUrl.contains(expUrl)) {
				break;
			}
		}
	}



	/**
	 * @Purpose - Handle Multiple window
	 * @Parameter - String
	 * @Work - By using this method we can Switch the window by title
	 * @Return - void
	 */
	public void switchWindowByTitle(String expTitle) {
		Set<String> setWindowColl = driver.getWindowHandles();
		for (String handleValue : setWindowColl) {
			driver.switchTo().window(handleValue);
			String actTitle = driver.getTitle();
			if (actTitle.equalsIgnoreCase(expTitle)) {
				break;
			}
		}
	}


	/**
	 * @Purpose - Get the title of page
	 * @Parameter - String,String
	 * @Work - By using this method we can get the title of page and validate that
	 *       title
	 * @Return - void
	 */
	public void verifyPageTitle(String expectedTitle, String pageName) {
		try {
			String actualTitle = driver.getTitle();
			if (actualTitle.equalsIgnoreCase(expectedTitle)) {
				System.out.println("Verification is passed . Title of " + pageName + " is: " + actualTitle);
				extLogger.log(Status.PASS, "Verification is passed . Title of " + pageName + " is: " + actualTitle);

			} else {
				System.out.println("Verification is failed . Title of " + pageName + " is: " + actualTitle);
				extLogger.log(Status.FAIL, "Verification is failed . Title of " + pageName + " is: " + actualTitle);

			}
		} catch (Exception e) {
			takeScreenShot("Pradeep");
		}
	}



	/**
	 * @Purpose - Fetch the InnerText
	 * @Parameter -WebElement, String,String
	 * @Work - By using this method we can Fetch the InnerText of that element and
	 *       validate that text
	 * @Return - void
	 */
	public void verifyInnerText(WebElement we, String expectedInnerText, String elementName) {

		String actualInnerText;

		try {
			actualInnerText = we.getText();

			if (actualInnerText.equalsIgnoreCase(expectedInnerText)) {
				System.out.println(elementName + " verification is passed. Where Actual-" + actualInnerText
						+ " && Expected-" + expectedInnerText);
				extLogger.log(Status.PASS, elementName + " verification is passed. Where Actual-" + actualInnerText
						+ " && Expected-" + expectedInnerText);

			} else {
				takeScreenShot("Pradeep");
				System.out.println(elementName + "verification is failed. Where Actual-" + actualInnerText
						+ " && Expected-" + expectedInnerText);
				extLogger.log(Status.FAIL, elementName + "verification is failed. Where Actual-" + actualInnerText
						+ " && Expected-" + expectedInnerText);

				/// assertion
				Assert.assertEquals(actualInnerText, expectedInnerText);
				SoftAssert softAssert = new SoftAssert();
				softAssert.assertEquals(actualInnerText, expectedInnerText);

			}
		} catch (StaleElementReferenceException e) {
			takeScreenShot("Pradeep");
			actualInnerText = we.getText();
		}

	}



	/**
	 * @Purpose - Fetch the Attribute
	 * @Parameter - String,String
	 * @Work - By using this method we can Fetch the attribute value of that element
	 *       and validate that attribute value
	 * @Return - void
	 */
	public void verifyIAttributeValue(WebElement we, String attributeName, String expectedAttribute,
			String elementName) {
		String actualAttribute;

		try {
			actualAttribute = we.getAttribute(attributeName);
			if (actualAttribute.equalsIgnoreCase(expectedAttribute)) {
				System.out.println(elementName + "verification is passed. Where Actual-" + actualAttribute
						+ " && Expected-" + expectedAttribute);
				extLogger.log(Status.PASS, elementName + "verification is passed. Where Actual-" + actualAttribute
						+ " && Expected-" + expectedAttribute);

			} else {
				takeScreenShot("Pradeep");
				System.out.println(elementName + "verification is failed. Where Actual-" + actualAttribute
						+ " && Expected-" + expectedAttribute);
				extLogger.log(Status.FAIL, elementName + "verification is failed. Where Actual-" + actualAttribute
						+ " && Expected-" + expectedAttribute);

			}
		} catch (StaleElementReferenceException e) {
			actualAttribute = we.getAttribute(attributeName);
			takeScreenShot("Pradeep");
		}
	}



	/**
	 * @Purpose - Verify element is Displayed or not on UI
	 * @Parameter - String,String
	 * @Work - By using this method we can verify element is Displayed or not on UI
	 * @Return - void
	 */
	public void verifyElementIsDisplyed(WebElement we, String elementName) {

		boolean status;
		try {
			status = we.isDisplayed();

			if (status == true) {
				System.out.println("Verification is passed " + elementName + " is displyed");
				extLogger.log(Status.PASS, "Verification is passed " + elementName + " is displyed");

			} else {
				takeScreenShot("Pradeep");
				System.out.println("Verification is failed " + elementName + " is not displayed");
				extLogger.log(Status.FAIL, "Verification is failed " + elementName + " is not displayed");

			}
		} catch (StaleElementReferenceException e) {

			status = we.isDisplayed();
			takeScreenShot("Pradeep");

		}
	}



	/**
	 * @Purpose - Verify element is Displayed or not on UI
	 * @Parameter - String,String
	 * @Work - By using this method we can verify element is Displayed or not on UI
	 * @Return - void
	 */
	public void verifyElementIsNotDisplyed(WebElement we, String elementName) {

		boolean status;
		try {
			status = we.isDisplayed();

			if (!status == true) {
				System.out.println("Verification is Passed " + elementName + " is not visible");
				extLogger.log(Status.PASS, "Verification is Passed " + elementName + " is not visible");

			} else {
				takeScreenShot("Pradeep");
				System.out.println("Verification failed " + elementName + " is visible");
				extLogger.log(Status.FAIL, "Verification is failed " + elementName + " is visible");

			}
		} catch (StaleElementReferenceException e) {

			status = we.isDisplayed();
			takeScreenShot("Pradeep");

		}
	}



	/**
	 * @Purpose - Verify element is enabled or not on UI
	 * @Parameter - String,String
	 * @Work - By using this method we can verify element is not enabled or not on
	 *       UI
	 * @Return - void
	 */
	public void verifyElementIsEnabled(WebElement we, String elementName) {

		boolean status;
		try {
			status = we.isEnabled();

			if (status == true) {
				System.out.println("Verification is passed " + elementName + " is enabled");
				extLogger.log(Status.PASS, "Verification is passed " + elementName + " is enabled");

			} else {
				takeScreenShot("Pradeep");
				System.out.println("Verification is failed " + elementName + " is disabled");
				extLogger.log(Status.FAIL, " Verification is failed " + elementName + " is disabled");
			}
		} catch (StaleElementReferenceException e) {
			status = we.isEnabled();
			takeScreenShot("Pradeep");

		}

	}



	/**
	 * @Purpose - Verify element is not enabled or not on UI
	 * @Parameter - String,String
	 * @Work - By using this method we can verify element is enabled or not on UI
	 * @Return - void
	 */
	public void verifyElementIsDisable(WebElement we, String elementName) {

		// refreshPage();
		boolean status;
		try {
			status = we.isEnabled();

			if (!status == true) {
				System.out.println("Verification is passed " + elementName + " is Disable");
				extLogger.log(Status.PASS, "Verification is passed " + elementName + " is Disable");

			} else {
				takeScreenShot("Pradeep");
				System.out.println("Verification is failed " + elementName + " is not Disable");
				extLogger.log(Status.FAIL, "Verification is failed " + elementName + " is not Disable");
			}
		} catch (StaleElementReferenceException e) {
			status = we.isEnabled();
			takeScreenShot("Pradeep");
		}

	}



	/**
	 * @Purpose - Verify element is selected or not on UI
	 * @Parameter - String,String
	 * @Work - By using this method we can verify element is selected or not on UI
	 * @Return - void
	 */
	public void verifyIsSelected(WebElement we, String elementName) {

		boolean status;
		try {
			status = we.isSelected();

			if (status == true) {
				System.out.println("Verification is passed " + elementName + " is Selected");
				extLogger.log(Status.PASS, "Verification is passed " + elementName + " is Selected");

			} else {
				takeScreenShot("Pradeep");

				System.out.println("Verification is Failed " + elementName + " is not Selected");
				extLogger.log(Status.FAIL, "Verification is Failed " + elementName + " is not Selected");

			}
		} catch (StaleElementReferenceException e) {

			status = we.isSelected();
			takeScreenShot("Pradeep");

		}
	}



	/**
	 * @Purpose - Verify element is selected in dropDown
	 * @Parameter - String,String,String
	 * @Work - By using this method we can verify element is selected in dropDown
	 * @Return - void
	 */
	public void verifySelectedTextInDropdown(WebElement we, String expectedSelectedText, String elementName) {

		String actualSelectedText;
		try {
			selectObj = new Select(we);
			WebElement weSelectedOption = selectObj.getFirstSelectedOption();
			actualSelectedText = weSelectedOption.getText();

			if (actualSelectedText.equalsIgnoreCase(expectedSelectedText)) {
				System.out.println(elementName + " Verification is passed. where actual selected value-"
						+ actualSelectedText + " && expected value-" + expectedSelectedText);
				extLogger.log(Status.PASS, elementName + " Verification is passed. where actual selected value-"
						+ actualSelectedText + " && expected value-" + expectedSelectedText);

			} else {
				takeScreenShot("Pradeep");
				System.out.println(elementName + " Verification is failed. where actual selected value-"
						+ actualSelectedText + " && expected value-" + expectedSelectedText);
				extLogger.log(Status.FAIL, elementName + " Verification is failed. where actual selected value-"
						+ actualSelectedText + " && expected value-" + expectedSelectedText);

			}
		} catch (StaleElementReferenceException e) {
			selectObj = new Select(we);
			WebElement weSelectedOption = selectObj.getFirstSelectedOption();
			actualSelectedText = weSelectedOption.getText();
			takeScreenShot("Pradeep");
		}
	}



	public String readData(String passKeyName) throws IOException {
		InputStream fis = new FileInputStream("ReadData.properties");
		Properties propObj = new Properties();
		propObj.load(fis);
		String data = propObj.getProperty(passKeyName);
		return data;
	}



	public String dateSetting() {

		SimpleDateFormat sd = new SimpleDateFormat("dd-MMM-yyyy hh_mm_ss");
		String time = sd.format(new Date());
		return time;
	}



	/* maximize method */
	public void maximize() {
		driver.manage().window().maximize();
		System.out.println("broswer is maximize successfully");
		extLogger.log(Status.INFO, "broswer is maximize successfully");
	}



	/* minimize method */
	public void minimize() {
		driver.manage().window().minimize();
		System.out.println("broswer is minimize successfully");
		extLogger.log(Status.INFO, "browser is minimize successfully");
	}



	/*
	 * we create generic method of navigate URL
	 */
	public void navigateUrl(String url) {
		driver.get(url);
		System.out.println("URL Navigate " + url + " successfully");
		extLogger.log(Status.INFO, "URL Navigate " + url + " successfully");
	}



	public void signOut(WebElement we, String elementName) {
		we.click();
	}

	// public ExtentHtmlReporter extReport;
	// public ExtentReports extreport;
	//
	// private ExtentTest extLogger;
	//
	// public ExtentReports initReports(String reportResultName) {
	// ExtentHtmlReporter ExtHtmlReport= new ExtentHtmlReporter(reportResultName);
	// ExtHtmlReport.config().setReportName(" Function Repoirts Automation");
	// ExtHtmlReport.config().setDocumentTitle(" SeleniumPlayGround Functionality
	// Reports");
	// extreport= new ExtentReports();
	// extreport.setSystemInfo(" username",System.getProperty(" user.name"));
	// extreport.setSystemInfo(" OS",System.getProperty(" user.os"));
	// extreport.setSystemInfo(" Envoirment"," QA");
	// extreport.attachReporter(ExtHtmlReport);
	// return extreport;
	// }
	//
	// public void setExtentLogger(String testCaseID) {
	// extLogger=extreport.createTest(testCaseID);
	//
	// //extLoggerObj=extreport.createTest(testCaseID);
	// }
	// public void setextenttext(ExtentReports ext) {
	// extreport=ext;
	// }
	//
	// public void flushReport() {
	// extreport.flush();
	// }

	// public void setExtendLogger(String testCaseId_Name) {
	// extLogger = extentReportObj.createTest(testCaseId_Name);
	// System.out.println("logger set for "+testCaseId_Name);

	// }

	// public ExtentTest getExtentLoggerVar() {
	// return extLogger;
	//
	// }

}
