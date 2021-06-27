package Listners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(ITestListner_Example.class)   // either we make connection here or simply write in testNg.Xml file 
public class LoginPage {
	public static WebDriver driver;

	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\eclipse-workspace\\POM\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///E:/Shreya%20Yadav/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	// verify URL
	@Test
	public void verifyURL() {
		String actual = driver.getTitle();
		String expected = "JavaByKiran | Log";
		Assert.assertEquals(actual, expected);
	}

	// verify Blank Email
	@Test()
	public void verifyBlankEmail() {
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("123456");
		WebElement submitbtn = driver.findElement(By.xpath("//button[@type='submit']"));
		submitbtn.click();
		String actual = driver.findElement(By.id("email_error")).getText();
		String expected = "Please enter email.";
		Assert.assertEquals(actual, expected);
	}

	// verify Blank password
	@Test
	public void verifyBlankPassword() {
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("kiran@gmail.com");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("");
		WebElement submitbtn = driver.findElement(By.xpath("//button[@type='submit']"));
		submitbtn.click();
		String actual = driver.findElement(By.id("password_error")).getText();
		String expected = "Please enter password.";
		Assert.assertEquals(actual, expected);

	}

	// verify Wrong Email
	@Test
	public void verifyWrongEmail() {
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("ikhfjh");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("123456");
		WebElement submitbtn = driver.findElement(By.xpath("//button[@type='submit']"));
		submitbtn.click();
		String actual = driver.findElement(By.id("email_error")).getText();
		String expected = "Please enter email as kiran@gmail.com";
		Assert.assertEquals(actual, expected);

	}

}
