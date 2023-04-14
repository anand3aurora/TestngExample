package testng;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practise {
	public static WebDriver driver;

	public static void main(String[] args) throws AWTException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		WebElement desk1 = driver.findElement(By.id("desktop-grid-1"));
		Actions ac = new Actions(driver);
		ac.contextClick(desk1).build().perform();
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_ENTER);

		WebElement desk2 = driver.findElement(By.id("desktop-grid-2"));
		ac.contextClick(desk1).build().perform();
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_ENTER);

		String parentwindow = driver.getWindowHandle();
		
		List<String> childwindows = new ArrayList(driver.getWindowHandles());
		for(int i=0; i<=childwindows.size(); i++) {
			driver.switchTo().window(childwindows.get(2));
			break;
		}
		driver.close();
		

}
}