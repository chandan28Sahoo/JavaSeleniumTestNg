package groupTesting;

import org.apache.commons.lang.ObjectUtils.Null;
import org.testng.annotations.Test;

public class TestDependency {
	
	static String trackingNumber;
	@Test()
	public  void createShipment(){
		System.out.println(5/0);
		System.out.println("create shipment");
		trackingNumber = "abc123";
	}
	
	@Test(dependsOnMethods = {"createShipment"})
	public  void trackShipment() throws Exception{
		if(trackingNumber != null) {
			System.out.println("track shipment");
		}
		else {
			throw new Exception("invalid tracking number");
		}
	}
	
	@Test(dependsOnMethods = {"createShipment"})
	public  void cancleShipment() throws Exception{
		if(trackingNumber != null) {
			System.out.println("cancle shipment");
		}
		else {
			throw new Exception("invalid tracking number");
		}
	}
}
