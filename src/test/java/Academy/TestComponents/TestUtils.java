package Academy.TestComponents;

import java.util.ArrayList;

import Academy.resources.Xls_Reader;




public class TestUtils {

	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getDataFromExcel() {
		
		
		ArrayList<Object[]>mydata=new ArrayList<Object[]>();
		
		
		reader=new Xls_Reader("C:\\Users\\balachandra.4\\Verynew-Workspace\\SeleniumFrameworkDesignBalu\\src\\main\\java\\Academy\\resources\\testData.xlsx");
		
		
		String sheetName="sheet";
		
		
		for(int rowNum=2;rowNum<=reader.getRowCount(sheetName);rowNum++) {
			
			String name=reader.getCellData(sheetName, "Name", rowNum);
			String home=reader.getCellData(sheetName, "Home", rowNum);
			String id=reader.getCellData(sheetName, "Id", rowNum);
			
			
			Object[] ob= {name,home,id};
			
			mydata.add(ob);
		}
	
		return mydata;
		
	}
	
	
	
}
