package Wait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WaitExample {

	WebDriver driver;

	@Test
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///E:/Shreya%20Yadav/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);   //time out exception
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);    //no such element exception
		
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("email"))));
		
		Wait<WebDriver> wait1=new FluentWait<WebDriver>(driver)
//				.withTimeout(30, TimeUnit.SECONDS)
//				.pollingEvery(30, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		
		wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("email"))));
		
		
		
	}

}
