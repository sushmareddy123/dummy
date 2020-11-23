package Utilities;
import Utilities.Utility;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

//import com.sun.mail.imap.Utility;

import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidDriverutils extends Utility {
	public static ExtentHtmlReporter htmlReporter;
	public static   ExtentReports extent;
	 public  static ExtentTest logger;
	//public static String deviceVersion;
	//public static String browserVersion;
	//ublic static String webBrowserName;
	//public static AndroidDriver<AndroidElement>  driver;
	 public static SimpleDateFormat sdf;
	 public static  AndroidDriver<AndroidElement> driver;
	public  static void capablities() throws MalformedURLException  
	{
	
		 File app = new File(Utility.GetValue("apkFilePath"));
		 System.out.println("hello"+ app);
			System.out.println("hello"+ Utility.GetValue("platformName"));
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			//capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"");
			capabilities.setCapability(MobileCapabilityType.PLATFORM,Utility.GetValue("platformName"));
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, Utility.GetValue("platformVersion"));
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Utility.GetValue("deviceName"));
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,Utility.GetValue("automationName"));
			capabilities.setCapability(MobileCapabilityType.APP, app);
			//capabilities.setCapability(MobileCapabilityType.UDID,Utility.GetValue("deviceID"));
			capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"45000");
			capabilities.setCapability("autoGrantPermissions", true);
			capabilities.setCapability("autoAcceptAlerts", true);
			capabilities.setCapability("locationServicesAuthorized", true);
			capabilities.setCapability("appWaitActivity",Utility.GetValue("appActivity"));
			capabilities.setCapability("appPackage", Utility.GetValue("appPackage"));
			capabilities.setCapability("appActivity", Utility.GetValue("appActivity"));
			
			
				
				System.out.println("hello");
				 driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				 //return driver;
	}

	
public static String captureScreen() throws IOException {
		
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		 String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
    	//String dest=System.getProperty("user.dir") +"\\ExecutionReports\\Screenshorts\\"+getcurrentdateandtime()+".png";
		String dest=System.getProperty("user.dir") +"\\ExecutionReports\\HtmlReports\\"+dateName+".png";
		//String dest ="D://Automation_Reports//screenshots//"+getcurrentdateandtime()+".png";
		File target = new File(dest);
		FileUtils.copyFile(src, target);
		return dest;
		}
	
	public String getcurrentdateandtime(){
		String str = null;
		try{
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
		Date date = new Date();
		str= dateFormat.format(date);
		str = str.replace(" ", "").replaceAll("/", "").replaceAll(":", "");
		}
		catch(Exception e){

		}
		return str;
		}
	public static void extentreports()
	{
	 String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

 	String path=System.getProperty("user.dir") +"\\ExecutionReports\\HtmlReports\\"+dateName+"MyOwnReport.html";
    
 	htmlReporter = new ExtentHtmlReporter(path);
 	htmlReporter.config().setReportName("AsgriTestReport");
 	htmlReporter.config().setDocumentTitle("Test Result");
 //	htmlReporter.getRunDuration();
     extent = new ExtentReports();
     extent.attachReporter(htmlReporter);
     extent.setSystemInfo("Tester", "Sushma");
     
	}
	
	public static void tearDown()
    {
        extent.flush();
    }
	
	

	
	
	
	
}
