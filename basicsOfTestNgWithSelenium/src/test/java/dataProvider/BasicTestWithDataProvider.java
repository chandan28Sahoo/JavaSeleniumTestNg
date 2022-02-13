package dataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicTestWithDataProvider {

	static WebDriver driver;
	@BeforeTest
	public static void initialiseBrowser() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(2000);
	}
	@Test(dataProvider = "loginTestData")
	public static void orangeHrmLogin(String userName, String password) throws Exception {
		driver.findElement(By.id("txtUsername")).sendKeys(userName);;
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		Assert.assertTrue(driver.findElement(By.id("welcome")).isDisplayed());
		Thread.sleep(5000);
		driver.quit();
	}
	
	@DataProvider(name = "loginTestData")
	public static Object [][] loginData() {
		Object [][] dataObjects = new Object[2][2];
		dataObjects[0][0] = "Admin";
		dataObjects[0][1] = "admin123";
		
		dataObjects[1][0] = "Admin";
		dataObjects[1][1] = "test123";
		
		return dataObjects;
	}
}


















