package ActionasClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsExample {
	
	
	@Test
	public void DragAndDrop() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://javabykiran.com/playground/drag-and-drop");
		WebElement source =driver.findElement(By.xpath("//div[text()='Web Design ']"));//---dragging this element
		WebElement target =driver.findElement(By.xpath("//div[text()='About Us']"));// dropping here
		
		Actions act = new Actions(driver);      
		
		//Drag & Drop
		act.dragAndDrop(source, target).build().perform();
		
		act.clickAndHold(source).pause(2000).moveToElement(target).pause(2000).release(source).build().perform();
		
		//Action a;      
		
	}
	@Test
	public void Refresh() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://javabykiran.com/playground/drag-and-drop");
		
		Actions act = new Actions(driver);      
		Thread.sleep(5000);
		act.keyDown(Keys.CONTROL).sendKeys(Keys.F5).build().perform();
		
		//driver.navaigate().refresh();
		
	}
//	@Test
//	public void toolTip()
//	{
//		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.get("file:///E:/Shreya%20Yadav/Offline%20Website/Offline%20Website/index.html");
//		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
//		driver.findElement(By.id("password")).sendKeys("123456");
//		driver.findElement(By.xpath("//button")).click();
//		driver.findElement(By.xpath("//span[text()='Users']")).click();
//		driver.findElement(By.xpath("//button[text()='Add User']")).click();
//		
//		Actions act=new Actions(driver);
//		
//		WebElement user=driver.findElement(By.id("username"));
////		act.moveToElement(user).perform();
//		String a=user.getAttribute("type");
//         System.out.println(a);

//}

	/*
	 * @Test public void DoubleClick() {
	 * System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	 * WebDriver driver = new ChromeDriver();
	 * driver.get("http://demo.guru99.com/test/simple_context_menu.html");
	 * 
	 * Actions act=new Actions(driver);
	 * 
	 * WebElement link =driver.findElement(By.
	 * xpath("//button[text()='Double-Click Me To See Alert']"));
	 * act.doubleClick(link).perform(); //Switch to the alert box and click on OK
	 * button Alert alert = driver.switchTo().alert();
	 * System.out.println("Alert Text\n" +alert.getText()); alert.accept(); }
	 * 
	 * @Test public void rightClick() {
	 * System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	 * WebDriver driver = new ChromeDriver();
	 * driver.get("http://demo.guru99.com/test/simple_context_menu.html");
	 * 
	 * Actions act=new Actions(driver);
	 * 
	 * WebElement link = driver.findElement(By.cssSelector(".context-menu-one"));
	 * act.contextClick(link).perform(); // Click on Edit link on the displayed menu
	 * options WebElement element =
	 * driver.findElement(By.cssSelector(".context-menu-icon-copy"));
	 * element.click(); }
	 * 
	 * @Test public void moveToElementTest() {
	 * System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	 * WebDriver driver = new ChromeDriver();
	 * driver.get("https://demoqa.com/menu/");
	 * 
	 * Actions act=new Actions(driver);
	 * 
	 * WebElement element =
	 * driver.findElement(By.cssSelector("//*[contains(text(),'Main Item 2')]"));
	 * act.moveToElement(element).perform();
	 * System.out.println("done mouse hover on main item 2");
	 * 
	 * WebElement element1 =
	 * driver.findElement(By.cssSelector("//*[contains(text(),'SUB SUB LIST')]"));
	 * act.moveToElement(element1).perform();
	 * System.out.println("done mouse hover on main item 2 To Sub Sub List");
	 * 
	 * WebElement element2 =
	 * driver.findElement(By.cssSelector("//*[contains(text(),'Sub Sub Item 1')]"));
	 * act.moveToElement(element2).perform();
	 * System.out.println("done mouse hover on Sub Sub List To Sub Sub Item 1"); }
	 */
}