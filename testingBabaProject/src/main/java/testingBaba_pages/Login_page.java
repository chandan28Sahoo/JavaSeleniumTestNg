package testingBaba_pages;

import baseLibrary.BaseLibrary;

public class Login_page extends BaseLibrary {
	
	public void getTitle() {
		String titleString =  driver.getTitle();
		System.out.println(titleString);
	}
}
