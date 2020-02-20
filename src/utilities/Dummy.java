package utilities;

import java.io.IOException;

public class Dummy {

	public static void main(String[] args) throws Exception {
		
		ExcelFileUtiliti exl=new ExcelFileUtiliti();
		
		
		int totalRows=exl.rowCount("Supplier");
		System.out.println("total no of rows are:"+totalRows);
		
		int totalcols=exl.colCount("Supplier");
		System.out.println("total no of cols are:"+totalcols);
		
		String cellData=exl.getData("Supplier", 2, 3);
		System.out.println("the data in 2,3 col is:"+cellData);
		
		exl.setData("Supplier", 4, 9, "Fail");
		
		
	}

}
