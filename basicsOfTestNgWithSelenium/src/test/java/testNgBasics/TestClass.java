package testNgBasics;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass {
	@Test
	public void testGoogle() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
		WebElement searchElement =  driver.findElement(By.name("q"));
		searchElement.sendKeys("HYR Tutorials",Keys.ENTER);
//		driver.findElement(By.name("q")).sendKeys("HYR Tutorials",Keys.ENTER);
		String expectedTitle = "HYR Tutorials - Google Searchhhh";
		String actualTitle = driver.getTitle();
		//AssertJUnit.assertEquals(actualTitle, expectedTitle,"title miss-match");
		Assert.assertNotEquals(actualTitle, expectedTitle,"title miss-match");
		Thread.sleep(2000);
		driver.quit();
	}
	@Test
	public void testFacebook() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://facebook.com");
		driver.findElement(By.id("email")).sendKeys("7586022804");
		driver.findElement(By.id("pass")).sendKeys("password@123");
		Thread.sleep(1000);
		driver.findElement(By.name("login")).click();
		Thread.sleep(5000);
		driver.quit();
	}

}
