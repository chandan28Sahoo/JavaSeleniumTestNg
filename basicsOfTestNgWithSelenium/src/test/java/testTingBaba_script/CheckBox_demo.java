package testTingBaba_script;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox_demo {
	@Test
	public void checkBoxTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.testingbaba.com/");
		driver.findElement(By.xpath("//*[@id=\"myModal2\"]/div/div/div[1]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[5]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"elements-accordion\"]/div[1]/div[1]/h2/button")).click();
		driver.findElement(By.xpath("//*[@id=\"v-pills-tab\"]/a[2]")).click();
		Thread.sleep(2000);
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"tab_2\"]/div/iframe")));
		driver.findElement(By.xpath("//*[@id=\"myCheck\"]")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//*[@id=\"v-pills-tab\"]/a[3]")).click();
		List<WebElement> radioElements =  driver.findElements(By.xpath("//*[@class=\"tab-pane fade active show\"]/div/label/input"));
		Thread.sleep(2000);
		for (int i=0; i<= radioElements.size() -1; i++) {
			Thread.sleep(2000);
			System.out.println(radioElements.get(i).getText());
//			webElement.click();
		}
		Thread.sleep(2000);
		driver.quit();
	}
}
