package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtills {
	public static  FileInputStream fis =null;
	private  static XSSFWorkbook wb =null;
	private  static XSSFSheet sheet=null;
	
	private static 	String path=System.getProperty("user.dir")+"\\ExcelFile\\AutomationControlSheet.xlsx";
	private static String sheetName="TestControlSheet";
public static String getFlagExcel(String sheetName, String searchValue) throws IOException
{
	
	//int sheetSize=2;
	int rowNum=1;
String strVal,strflag = "NA";
//String searchValue= "NA0"
	fis=new FileInputStream(path);
	wb=new XSSFWorkbook(fis);
	int sheets=wb.getNumberOfSheets();
	
	int indexOfheet =wb.getSheetIndex(wb.getSheet(sheetName));
	
	Sheet sheet =wb.getSheet(sheetName);
	 int sheetSize = sheet.getLastRowNum();
	System.out.println("sheetSize"+sheetSize);
	
	for(int i=rowNum;i<=sheetSize;i++)
	{
		strVal = sheet.getRow(i).getCell(1).getStringCellValue();
	
		System.out.println("StrVal"+strVal);
		System.out.println("searchValue"+searchValue);
		if(strVal=="Y")
		{
			strflag = wb.getSheet("SuiteControlSheet").getRow(i).getCell(1).getStringCellValue();
			System.out.print("Stringflagvalue"+strflag);
			break;
		}
	}
	return strflag;
	
}

public static  boolean  isSuiteRunnable(String SuiteName) throws Exception
{
	boolean isRunnable = false;
String strVal;
	try 
	{			
		strVal=getFlagExcel("SuiteControlSheet",SuiteName);
				System.out.println("Error! No such sheet available in Excel file: " + strVal);

		if(strVal.equalsIgnoreCase("Y"))
		{
			isRunnable = true;
		}
		else if(strVal.equalsIgnoreCase("N"))
		{
			isRunnable = false;
		}
		else if(strVal.equalsIgnoreCase("NA"))
		{
			isRunnable = false;
		}
		
	} 
	catch (Exception e) 
	{		e.printStackTrace();
		throw e;
	}
	
	
	
	return isRunnable;
}
public static boolean isScriptRunnable(String suiteName,String scriptName) throws Exception
{
	boolean isRunnable = false;
	String strVal=null;
	try 
	{	
		
		if(suiteName.equalsIgnoreCase("Regression"))
		{
			strVal=getFlagExcel("RegressionSuite",scriptName);
		}
		else if (suiteName.equalsIgnoreCase("Smoke"))
		{
			strVal=getFlagExcel("SmokeSuite",scriptName);
			System.out.println("is runable"+strVal);
		}
		else if (suiteName.equalsIgnoreCase("Functional"))
		{
			strVal=getFlagExcel("FunctionalSuite",scriptName);
		}
		else
			strVal="";
		
		
		if(strVal.equals("")){
			System.out.println("\n************************************************************************");
			System.out.println("No Data is available for:FunctionalSuite_HI, Script Name:" + scriptName);
			System.out.println("************************************************************************\n");
			
			isRunnable = false; 
		}

		if(strVal.equals("Y"))
		{
			isRunnable = true;
		}
		else if(strVal.equals("N"))
		{
			isRunnable = false;
		}
		else if(strVal.equals("NA"))
		{
			isRunnable = false;
		}
	} 
	catch (Exception e) 
	{
		e.printStackTrace();
		throw e;
	}
	return isRunnable;
}
public static boolean getControls(String suiteName, String testCaseID) throws Exception{
	boolean isSuiteRun=false; 
	boolean isScriptRun=false;
	boolean control=false;

	isSuiteRun = ExcelUtills.isSuiteRunnable(suiteName);
	

	if(isSuiteRun)
	{
		isScriptRun = ExcelUtills.isScriptRunnable(suiteName, testCaseID);

		if(isScriptRun)
			control =true;
		
	}
	else 
		control =false;
	

return control;
}

public static void main(String arg[]) throws Exception
{
	getControls("SuiteControlSheet", "SuiteName");
	
}
}
