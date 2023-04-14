package testng;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Amazon {
	 WebDriver driver;
@BeforeMethod
public void browserlaunch() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("https://www.amazon.in/");
}

@Test(priority = 3)
public void titlename() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	String titlename = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	String title = driver.getTitle();
	AssertJUnit.assertEquals(titlename, title);
}
@Test(priority = 2)
public void imagedisplayed() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	boolean displayed = driver.findElement(By.id("nav-logo-sprites")).isDisplayed();
	AssertJUnit.assertTrue(displayed);
	
}
@Test(priority = 1,retryAnalyzer = IRetryAnalyser.class)
public void bestsellerclick() throws InterruptedException {
	Thread.sleep(1000);
	driver.findElement(By.xpath("//a[@class=\"nav-a  \"][2")).click();
}

@AfterMethod
public void browserquit() {
	driver.quit();
	
}

}