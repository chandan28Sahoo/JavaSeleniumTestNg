package groupTesting;

import org.testng.annotations.Test;
@Test(groups = {"all"})
public class NewTest1 {

	@Test(groups = {"smoke"})
	public void test1() {
		System.out.println("test1");
	}
	@Test(groups = {"smoke","functional"})
	public void test2() {
		System.out.println("test2");
	}
	@Test(groups = {"smoke","sanity"})
	public void test3() {
		System.out.println("test3");
	}
	@Test
	public void test4() {
		System.out.println("test4");
	}
}
