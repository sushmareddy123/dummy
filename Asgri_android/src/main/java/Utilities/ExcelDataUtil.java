package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelDataUtil extends Utility {
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
		try {
		 path=System.getProperty("user.dir")+"\\ExcelFile\\AutomationControlSheet.xlsx";
		fis=new FileInputStream(path);
		wb =new XSSFWorkbook(fis);
		 for (int i = 0; i < wb.getNumberOfSheets(); i++) {

             System.out.println("Sheet name: " + wb.getSheetName(i));
             if( wb.getSheetName(i)==sheetname) {
            	 System.out.println("sheetname"+sheetname);
            	 sheetname=s;
             }
             
             
         }

     } catch (IOException e) {
         e.printStackTrace();
     } finally {
         if (fis != null) {
             try {
                 fis.close();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
         
     }
	}
	
	public static void gettestcasename(String sheetname, String colName, String rowName) throws IOException
	{

		System.out.println("data");
		
		 path=System.getProperty("user.dir")+"\\ExcelFile\\AutomationControlSheet.xlsx";
		fis=new FileInputStream(path);
		wb =new XSSFWorkbook(fis);
		int sheets=wb.getNumberOfSheets();
		for(int i=0;i<sheets;i++)
		{
			if(wb.getSheetName(i).equalsIgnoreCase(sheetname)) {
				sheet=wb.getSheetAt(i);
		Iterator<Row> rows=sheet.iterator();
		Row firstrow=rows.next();
		Iterator<Cell> ce=firstrow.cellIterator();
		int k=0;
		int coloumn=0;
		while(ce.hasNext())
		{
			Cell value=ce.next();
			if(value.getStringCellValue().equalsIgnoreCase(colName)) {
				coloumn=k;
				
			}
		k++;
		}
		System.out.println("colName"+coloumn);
		while(rows.hasNext())
		{
			Row r=rows.next();
			System.out.println("r.getCell(coloumn).getStringCellValue()"+r.getCell(coloumn).getStringCellValue());
			System.out.println("r.getCell(coloumn).getStringCellValue()"+r.getCell(coloumn).getStringCellValue());

			if(r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(rowName)) {
			System.out.print("getCell(coloumn)"+r.getCell(coloumn));
			}
			
			}
		}
		
			}
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
		public static String readdatafromExcelusingcolumnName(String SheetName,String ColumnName)
				   throws EncryptedDocumentException, InvalidFormatException, IOException {
				 
			 path=System.getProperty("user.dir")+"\\ExcelFile\\AutomationControlSheet.xlsx";
				fis=new FileInputStream(path);
				wb =new XSSFWorkbook(fis);
			
			
			///String SheetName = "LoginDataSheet";
				//  File file = new File(".\\testData\\data.xlsx");
				  //FileInputStream fi = new FileInputStream(file);
				 // Workbook wb = WorkbookFactory.create(fi);
				  Sheet sheet = wb.getSheet(SheetName);
				  // it will take value from first row
				  Row row = sheet.getRow(0);
				// it will give you count of row which is used or filled
				  short lastcolumnused = row.getLastCellNum();

				  int colnum = 0;
				  for (int i = 0; i < lastcolumnused; i++) {
				   if (row.getCell(i).getStringCellValue().equalsIgnoreCase(ColumnName)) {
				    colnum = i;
				    break;
				   }
				  }

				  // it will take value from Second row
				  row = sheet.getRow(1);
				  Cell column = row.getCell(colnum);
				  String CellValue = column.getStringCellValue();

				  return CellValue;

				 }
				       


	
	
	public static void main(String arg[]) throws Exception
	{
		ExcelDataUtil ex=new ExcelDataUtil();
		//System.out.println(ex.getSheetRows("ss"));
		//System.out.println(getsheetcolumns("ss"));
	//	System.out.println(getCellData("ss",1,1));
		
	//	System.out.print(getCellData("ss",1,0));
		//System.out.println(isSuiteRunnable("SuiteControlSheet"));
		readdatafromExcelusingcolumnName("SuiteControlSheet", "SuiteName");
	}
	
}

