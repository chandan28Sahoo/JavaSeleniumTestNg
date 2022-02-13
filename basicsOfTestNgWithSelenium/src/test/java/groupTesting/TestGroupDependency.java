package groupTesting;

import org.testng.annotations.Test;

public class TestGroupDependency {
	@Test(groups = {"smoke"})
	public void test1() {
		System.out.println("smoke");
	}
	@Test(groups = {"smoke"})
	public void test2() {
		System.out.println("smoke");
	}
	@Test(groups = {"smoke"})
	public void test3() {
		System.out.println("smoke");
	}
	
	@Test(groups = {"functional"})
	public void test5() {
		System.out.println("functional");
	}
	@Test(groups = {"sanity"})
	public void test6() {
		System.out.println("sanity");
	}
	
	@Test(groups = {"sanity"})
	public void test7() {
		System.out.println("sanity");
	}
	
	@Test(groups = {"functional"})
	public void test8() {
		System.out.println("functional");
	}
	
	
	@Test(dependsOnGroups = {"smoke", "functional"})
	public void test0() {
		System.out.println("main test");
	}
}
