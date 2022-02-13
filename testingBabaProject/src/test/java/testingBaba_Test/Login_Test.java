package testingBaba_Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseLibrary.BaseLibrary;
import testingBaba_pages.Login_page;

public class Login_Test extends BaseLibrary {

	Login_page ob;
	@BeforeTest
	public void getLaunch() {
		getLaunch("http://www.testingbaba.com/");
		ob = new Login_page();
	}
	
	@Test
	public void getTitle() {
		ob.getTitle();
	}
}