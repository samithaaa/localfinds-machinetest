package utility;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static FileInputStream fle;
	
	public static String readExcel(int rows,int cols) throws IOException
	{   
	    fle=new FileInputStream("C:\\Users\\LAB-USER-01\\Desktop\\MACHINE_TEST_SAMITHA\\LocalFinds\\src\\test\\resources\\LoginData.xlsx");
	    
		workbook= new XSSFWorkbook(fle);
		
		sheet=workbook.getSheetAt(0);
		
		
		
		return sheet.getRow(rows).getCell(cols).getStringCellValue();
		
	}
	
}
