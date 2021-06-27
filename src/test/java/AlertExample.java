import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertExample {
	
	
	
/*	Alert : Alert is a small message box which appears on screen to give user some information & notification
 *          and its ask permission to perform specific task.
 *          
 *    Types of alert :  1) Simple Alert()       : displays information or warning on screen
 *                      2) Prompt Alert()       : ask some input from user & selenium webdriver can enter text using sendKeys()
 *                      3) Confirmation Alert() : ask permission to do some type of operation
 */

	public static void main(String[] args) {
		
	
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("file:///E:/Shreya%20Yadav/Offline%20Website/Offline%20Website/index.html");
	driver.manage().window().maximize();

	driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
	driver.findElement(By.id("password")).sendKeys("123456");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	driver.findElement(By.xpath("//li[3]/a/span")).click();
	
	
	Alert alert=driver.switchTo().alert();      // Alert is an interface, it has 4 methods
	alert.accept();
	alert.dismiss();
	String msg=driver.switchTo().alert().getText();
	System.out.println(msg);
	driver.switchTo().alert().sendKeys("yes");
	

}
}