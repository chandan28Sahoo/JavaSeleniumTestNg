package dataProvider;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

public class BasicTestWithDataProvider2 {

	@Test(dataProvider = "datap", dataProviderClass = DataSupplier.class)
	public static void testDataProvider(String s) {
		System.out.println(s);
	}
	

	@DataProvider()
	public static String [] datap1() {
		String[] dataStrings = new String[]{
			"abcd",
			"xyz",
			"lkm"
		};
		return dataStrings;
	}
	
	@DataProvider()
	public static Object [] datap2() {
		Object[] dataStrings = new Object[]{
				1,
			"abcd",
			"xyz",
			"lkm"
		};
		
		return dataStrings;
	}
	
	@DataProvider()
	public static Iterator<String> datap3() {
		List<String> dataStrings = new ArrayList<>();
		dataStrings.add("chandan");
		dataStrings.add("sahoo");
		return dataStrings.iterator();
	}
	
	@DataProvider()
	public static Iterator<String[]> datap4() {
		Set<String[]> dataStrings = new HashSet<>();
		dataStrings.add(new String[] {"chandan","sahoo"});
		dataStrings.add(new String[] {"chandan","sahoo"});
		return dataStrings.iterator();
	}
}


















