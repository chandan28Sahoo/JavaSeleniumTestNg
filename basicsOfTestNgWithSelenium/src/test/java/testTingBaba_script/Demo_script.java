package testTingBaba_script;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo_script {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.testingbaba.com/");
		driver.findElement(By.xpath("//*[@id=\"myModal2\"]/div/div/div[1]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[5]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"elements-accordion\"]/div[1]/div[1]/h2/button")).click();
		driver.findElement(By.xpath("//*[@id=\"v-pills-tab\"]/a[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"fullname1\"]")).sendKeys("chandan");
		driver.findElement(By.xpath("//*[@id=\"fullemail1\"]")).sendKeys("chandan@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"fulladdresh1\"]")).sendKeys("kolkata sector h block 125");
		driver.findElement(By.xpath("//*[@id=\"paddresh1\"]")).sendKeys("kolkata sector h block 125");
		driver.findElement(By.xpath("//*[@id=\"tab_1\"]/div/div[1]/form/input[3]")).click();
		Thread.sleep(2000);
		List<WebElement> elements = driver.findElements(By.xpath("//*[@class=\"col-md-6 mt-5\"]/label"));
		for (int i = 1; i<=elements.size() -1; i++) {
			System.out.println(elements.get(i).getText());
			i++;
		}
	}
}
