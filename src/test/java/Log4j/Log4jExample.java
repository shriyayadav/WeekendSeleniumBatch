package Log4j;

import org.apache.log4j.Logger;

//What is log : capturing info/ activities at the time of program execution.
//Types of logs : 1) info 2)fatal 3)error 4)warn 5)debug
//how to generate the logs? : use Apache Log4j APi
//How it works? : it reads log4j configuration from log4j properties file.
//Where to create? : create inside resources folder.

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Log4jExample {
	public static Logger logs = Logger.getLogger(Log4jExample.class);
	WebDriver driver;

//	public static void main(String[] args) {
//		PropertyConfigurator.configure("C:\\Users\\PC\\eclipse-workspace\\WeekendSeleniumBatch\\src\\test\\java\\Log4j\\Log4j.properties");
//				logs.info("Hello Shriya");
//		
//		  logs.error("Please enter the full name");
//		  logs.warn("name should be in capital letter"); logs.debug("Debugging....");
//		  logs.fatal("fatal....");
//		 
//		
//	}

	@BeforeMethod
	public void setUp() {
		PropertyConfigurator.configure("C:\\Users\\PC\\eclipse-workspace\\WeekendSeleniumBatch\\src\\test\\java\\Log4j\\Log4j.properties");
		logs.info("*************************************************Launching the URL***************************************************************");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\eclipse-workspace\\POM\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///E:/Shreya%20Yadav/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		logs.info("*************************************************driver close***************************************************************");
	}

	// verify URL
	@Test
	public void verifyURL() {
		logs.info("*************************************************Test Case Start Verify URL***************************************************************");
		String actual = driver.getTitle();
		String expected = "JavaByKiran | Log in";
		Assert.assertEquals(actual, expected);
		logs.info("*************************************************Verify URL Test case Finish***************************************************************");
	}

	// verify Blank Email
	@Test
	public void verifyBlankEmail() {
		logs.info("*************************************************Test Case Start Verify Blank email***************************************************************");
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("123456");
		WebElement submitbtn = driver.findElement(By.xpath("//button[@type='submit']"));
		submitbtn.click();
		String actual = driver.findElement(By.id("email_error")).getText();
		String expected = "Please enter email";
		Assert.assertEquals(actual, expected);
		logs.info("*************************************************Verify Blank email Test case Finish***************************************************************");
	}

}
