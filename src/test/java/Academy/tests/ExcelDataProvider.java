package Academy.tests;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Academy.TestComponents.TestUtils;

public class ExcelDataProvider {
	
	
	
	@Test(dataProvider = "driveTest")
	public void testCaseData(String name,String home,String id) {
	
		
		
		
	System.out.println(name +" : "+home +" : "+id);
		
		
	}
	
	@DataProvider(name="driveTest")
	public Iterator<Object[]> getData() {
	
		ArrayList<Object[]>testdata=TestUtils.getDataFromExcel();
		
		return testdata.iterator();
		
	}

}
