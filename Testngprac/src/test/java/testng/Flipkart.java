package testng;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Flipkart {

	static WebDriver driver;
	@BeforeMethod
	public void browserlaunch() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\akiru\\eclipse-workspace\\Testngprac\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
	}

	@Test
	public void titlename() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//div//button[text()='✕']")).click();
		String titlename = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		String title = driver.getTitle();
		Assert.assertEquals(titlename, title);
	}
	@Test
	public void imagedisplayed() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		boolean displayed = driver.findElement(By.xpath("//img[@title=\"Flipkart\"]")).isDisplayed();
		Assert.assertTrue(displayed);
		
	}
	@Test
	public void bestsellerclick() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div//button[text()='✕']")).click();
		driver.findElement(By.xpath("//img[@alt=\"Fashion\"]")).click();
	}

	@AfterMethod
	public void browserquit() {
		driver.quit();
		
	}
}
