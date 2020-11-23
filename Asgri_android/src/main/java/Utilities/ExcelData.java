package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelData {
	public static  FileInputStream fis =null;

public static   XSSFWorkbook wb =null;
public  static XSSFSheet sheet=null;
public static XSSFRow  row=null;
public static XSSFCell cell=null;
public static String sheetName=null;
public static String s;
private static 	String path=System.getProperty("user.dir")+"\\ExcelFile\\AutomationControlSheet.xlsx";

public static void getsheetname(String sheetname) throws IOException
{
	System.out.println("data");

	 path=System.getProperty("user.dir")+"\\ExcelFile\\AutomationControlSheet.xlsx";
	fis=new FileInputStream(path);
	wb =new XSSFWorkbook(fis);
	sheet=wb.getSheetAt(0);


}



public  int getSheetRows(String SheetName) {
	int index=wb.getSheetIndex(SheetName);
	sheet=wb.getSheetAt(index);
	return (sheet.getLastRowNum()+1);
}
	
	public static int getsheetcolumns(String SheetName)
	{
		int  index=wb.getSheetIndex(SheetName);
		sheet=wb.getSheetAt(index);
		row=sheet.getRow(0);
		return(row.getLastCellNum());
	}
public static String getCellData(String SheetName,String colName,int rowNum) throws IOException {
	 path=System.getProperty("user.dir")+"\\ExcelFile\\AutomationControlSheet.xlsx";
	fis=new FileInputStream(path);
	wb =new XSSFWorkbook(fis);
	int colNum=-1;
	int index=wb.getSheetIndex(SheetName);
	sheet=wb.getSheetAt(index);
	for(int i=0;i<getsheetcolumns(SheetName);i++) {
		row=sheet.getRow(0);
		cell=row.getCell(i);
		if(cell.getStringCellValue().equals(colName)) {
			colNum=cell.getColumnIndex();
			break;
		}
	}
		row=sheet.getRow(rowNum);
		cell=row.getCell(colNum);
		//System.out.print("cell"+cell);
		
		String CellData=null;
		switch (cell.getCellType()) {

		case Cell.CELL_TYPE_FORMULA:
			CellData = "" + cell.getCellFormula();
			break;

		case Cell.CELL_TYPE_NUMERIC:
			CellData = "" + cell.getNumericCellValue();
			break;

		case Cell.CELL_TYPE_STRING:
			CellData = "" + cell.getStringCellValue();
			break;

		default:
		}
		return(CellData);
	}


public static void main(String arg[]) throws Exception
{
	getCellData("TC_LoginValidation", "UserName",1);
	getCellData("TC_LoginValidation", "Password",1);
	
}
	}
	
			


