package dataProvider;

import org.testng.annotations.DataProvider;

public class DataSupplier {
	
	@DataProvider(indices = {0,1})
	public static String [] datap() {
		String[] dataStrings = new String[]{
			"abcd",
			"xyz",
			"lkm"
		};
		return dataStrings;
	}
}
