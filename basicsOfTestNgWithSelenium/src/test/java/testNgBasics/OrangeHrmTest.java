package testNgBasics;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHrmTest {
	static WebDriver driver;
	@Parameters("browserName")
	@BeforeTest
	public static void initialiseBrowser(@Optional("chrome") String browserName) {
		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("browsename is invalid");
			break;
		}
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public static void tearDown() {
		driver.quit();
	}
	@Parameters("url")
	@Test
	public void launchApp(String url) {
		driver.get(url);
	}
	
	@Parameters({"userName","password"})
	@Test
	public void orangeHrmLogin(String userName, String password) throws InterruptedException {
		driver.findElement(By.id("txtUsername")).sendKeys(userName);;
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(2000);
	}
	
	@Test
	public void navigateToMyINfo() throws InterruptedException {
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
	}
	
	@Test
	public void verifyMyINfo() throws InterruptedException {
		boolean actualValue = driver.findElement(By.id("employee-details")).isDisplayed();
		assertTrue(actualValue);
//		System.out.println();
		Thread.sleep(1000);
	}
	@Test
	public void verifyLogin() throws InterruptedException {
		WebElement element = driver.findElement(By.id("welcome"));
		assertTrue(element.isDisplayed());
		assertTrue(element.getText().startsWith("Welcome"));
//		System.out.println("element" + element.isDisplayed());
//		System.out.println("element" + element.getText());
//		Thread.sleep(000);
	}
}
