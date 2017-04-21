package utility;

import java.io.File;
import java.io.IOException;

import org.apache.bcel.generic.RETURN;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadExcel {	
	
	@Test
	public Object[][] read(){
		String[][] testdata=null;
		 XSSFWorkbook wbook ;
		 XSSFSheet wsheet;
		 XSSFCell cell;
		try {
			File file = new File("C:\\Users\\Anusha.D\\workspace\\LGE\\src\\HelperMethods\\input1.xlsx");
			wbook = new XSSFWorkbook(file);
			wsheet = wbook.getSheet("Sheet1");
			int rows =wsheet.getLastRowNum();
			int cols=wsheet.getRow(rows).getLastCellNum();
			System.out.println(rows);
			System.out.println(cols);
			testdata = new String[rows][cols-1];
			String val;
			for(int i=0;i<=rows;i++){
				for(int j=0;j<=cols;j++){
					cell = wsheet.getRow(i).getCell(j);
					val=cell.getStringCellValue();
					System.out.println(val);
					//System.out.println(i+""+j);
					testdata[i][j]=val;
					//testdata[i][j] = formatter.formatCellValue(cell);

				}
			}

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
		
	}
	
}
