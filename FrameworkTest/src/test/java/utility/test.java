package utility;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.bcel.generic.RETURN;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class test {	
	
	 XSSFWorkbook wbook ;
	 XSSFSheet wsheet;
	 XSSFCell cell; 
	//@Test
	public Object[][] read(){
		
		 String[][] testdata=null;
		 int rows=0,cols=0;
		 try {
		FileInputStream file = new FileInputStream(new File("C:\\Users\\Anusha.D\\workspace\\LGE\\src\\HelperMethods\\input1.xlsx"));		
			wbook = new XSSFWorkbook(file);	
			wsheet = wbook.getSheet("Sheet1");
			int firstRow = wsheet.getFirstRowNum();
			int lastRow = wsheet.getLastRowNum();
			
			int firstCell=wsheet.getRow(0).getFirstCellNum();
			int lastCell=wsheet.getRow(0).getLastCellNum();

			rows = lastRow - firstRow + 1;
			
			//TODO: Findout why it is returning one extra column
			cols = lastCell - firstCell;
			
			System.out.println(rows);
			System.out.println(cols);
			
			String val;
			testdata=new String[rows][cols];
			
			for(int i=firstRow;i< firstRow + rows;i++){
				for(int j=firstCell;j<firstCell + cols;j++){

					cell = wsheet.getRow(i).getCell(j);
					val=cell.getStringCellValue();
					//System.out.println(val);
					testdata[i][j]=val;
					//testdata[i][j] = formatter.formatCellValue(cell);
				}
			}
file.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return testdata;
	}
	
	
	@DataProvider(name = "input")
	public Object[][] dataProvider(){
		Object[][] testdata = read();
		return testdata;
		
	}

	@Test(dataProvider="input")
	public void demo(String id, String pwd){
		System.out.println(id);
		System.out.println(pwd);
		writeexcel();
	}
	
	public void writeexcel(){
		try {
		FileInputStream file = new FileInputStream(new File("C:\\Users\\Anusha.D\\workspace\\LGE\\src\\HelperMethods\\input1.xlsx"));		
		FileOutputStream fos;
		
			fos = new FileOutputStream(new File("C:\\Users\\Anusha.D\\workspace\\LGE\\src\\HelperMethods\\input1.xlsx"));		
		wbook = new XSSFWorkbook(file);
		wsheet = wbook.getSheet("Sheet2");
		//int lastRow = wsheet.getLastRowNum();		
		//int lastCell=wsheet.getRow(lastRow).getLastCellNum();
		cell = wsheet.getRow(0).getCell(0);
		cell.setCellValue("hi");
		file.close();
		wbook.write(fos);
		fos.flush();
		fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}