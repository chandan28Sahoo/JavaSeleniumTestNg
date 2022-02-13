package testTingBaba_script;

import java.util.Arrays;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilis.ExcelUtilities;

public class WebTables {
	
	public static void main(String[] args) throws InterruptedException {
		
		String sheetName = "./testData/Data_sheet.xlsx";
		ExcelUtilities excelUtils = new ExcelUtilities(sheetName,3);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.testingbaba.com/");
		driver.findElement(By.xpath("//*[@id=\"myModal2\"]/div/div/div[1]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[5]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"elements-accordion\"]/div[1]/div[1]/h2/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"v-pills-tab\"]/a[4]")).click();
		Thread.sleep(1500);
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"tab_4\"]/div/iframe")));
		Thread.sleep(1000);
	
		String[][] dataStrings = excelUtils.getPostdata();
		for(int i= 0; i<dataStrings.length; i++) {
			for(int j=0; j<dataStrings[i].length - 1; j++) {
				driver.findElement(By.xpath("/html/body/div/form/div[1]/input")).sendKeys(dataStrings[i][j].toString());
				driver.findElement(By.xpath("/html/body/div/form/div[2]/input")).sendKeys(dataStrings[i][j + 1].toString());
				driver.findElement(By.xpath("/html/body/div/form/button")).click();
				Thread.sleep(1500);
			}
		}
		
		String[][] dataUpdateStrings = excelUtils.getUpdateData();
		for(int i= 1; i<=dataUpdateStrings.length; i++) {
			driver.findElement(By.xpath("/html/body/div/table/tbody/tr["  + i + "]/td[3]/button[1]")).click();
			for(int j=1; j<3; j++) {
				driver.findElement(By.xpath("/html/body/div/table/tbody/tr["+ i +"]/td[" + j+  "]/input")).clear();
				driver.findElement(By.xpath("/html/body/div/table/tbody/tr[" + i + "]/td[" + j + "]/input")).clear();
			}
			Thread.sleep(1500);
		}
	
		for(int i= 1; i<=dataUpdateStrings.length; i++) {
			for(int j=1; j<3; j++) {
				driver.findElement(By.xpath("/html/body/div/table/tbody/tr["+ i +"]/td["+ j +"]/input")).sendKeys(dataUpdateStrings[i - 1][j - 1].toString());
				Thread.sleep(1500);				
			}
			driver.findElement(By.xpath("/html/body/div/table/tbody/tr["+ i +"]/td[3]/button[1]")).click();
			Thread.sleep(1000);
		}
		
		Thread.sleep(1000);
		for(int i= 1; i<=dataUpdateStrings.length; i++) {
			driver.findElement(By.xpath("/html/body/div/table/tbody/tr["+1+"]/td[3]/button[2]")).click();
			Thread.sleep(1500);
		}	
	}
}
