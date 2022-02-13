package testNgBasics;

import org.testng.annotations.Test;

public class FlightBooking {

	@Test(priority = 1)
	public void signUp() {
		System.out.println("signUp");
	}
	
	@Test(priority = 2)
	public void logIn() {
		System.out.println("login");
	}
	
	@Test(priority = 3)
	public void searchForFlight() {
		System.out.println("searchForFlight");
	}

	@Test(priority = 4)
	public void bookingTheFlight() {
		System.out.println("bookingTheFlight");
	}
	
	@Test(priority = 5)
	public void saveTheTicket() {
		System.out.println("saveTheTicket");
	}
	@Test(priority = 6)
	public void logOut() {
		System.out.println("logOut");
	}
}
