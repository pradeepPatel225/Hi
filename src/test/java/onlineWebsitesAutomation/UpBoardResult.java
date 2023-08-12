package onlineWebsitesAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpBoardResult {

	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "Chrome_Driver\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		//opt.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://upmsp.edu.in/");
		driver.findElement(By.xpath("//a[@href='./ResultIntermediate.aspx']")).click();
		Actions ac=new Actions(driver);
		WebElement rollNumber=driver.findElement(By.xpath("//input[@id='ctl00_cphBody_txt_RollNumber']"));
		for (long i= 2236486001l; i <= 2236486500l ; i++) {
			WebElement districtName=driver.findElement(By.xpath("//select[@id='ctl00_cphBody_ddl_districtCode']"));
			Select districtDropdown =new Select(districtName);
			districtDropdown.selectByVisibleText("KAUSHAMBI - 57");
			districtName=driver.findElement(By.xpath("//select[@id='ctl00_cphBody_ddl_districtCode']"));
			rollNumber=driver.findElement(By.xpath("//input[@id='ctl00_cphBody_txt_RollNumber']"));
			ac.sendKeys(rollNumber, ""+i+"").sendKeys(Keys.ENTER).build().perform();
			WebElement name=driver.findElement(By.xpath("//span[@id='ctl00_cphBody_lbl_C_NAME']"));
			WebElement marks=driver.findElement(By.xpath("//span[@id='ctl00_cphBody_lbl_MRK_OBT']"));
			System.out.println("<<<< RollNumber >>> = "+""+i+" >>>> "+name.getText()+" Get marks = "+marks.getText()+"/500");
			WebElement newSearch=driver.findElement(By.xpath("//a[text()='New Search']"));
			newSearch.click();
	
		}
		
	}

}
