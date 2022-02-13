package groupTesting;

import org.testng.annotations.Test;

public class NewTest2 {

	@Test(groups = {"functional","regration"})
	public void test5() {
		System.out.println("test5");
	}
	@Test(groups = {"functional","sanity"})
	public void test6() {
		System.out.println("test6");
	}
	@Test(groups = {"functional","smoke","sanity"})
	public void test7() {
		System.out.println("test7");
	}
	@Test
	public void test8() {
		System.out.println("test8");
	}
}
