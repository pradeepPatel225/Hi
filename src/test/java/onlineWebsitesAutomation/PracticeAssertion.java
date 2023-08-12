package onlineWebsitesAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeAssertion {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt=	new ChromeOptions();
		opt.addArguments("remote-allow-origins=*");
		WebDriver driver=	new ChromeDriver(opt);
		driver.get("http://localhost:8888/");
		String actualurl= driver.getCurrentUrl();
		System.out.println(actualurl);
		SoftAssert  sd=new SoftAssert();
		Assert.assertEquals(actualurl, "http://localhost:8888");
		//sd.assertEquals(actualurl, "http://localhost:8888");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("atul");
	}
}
