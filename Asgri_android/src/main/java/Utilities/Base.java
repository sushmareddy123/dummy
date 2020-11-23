package Utilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {
	public static AndroidDriver<AndroidElement>  driver;
	@Test
	public static AndroidDriver<AndroidElement>capablities() throws MalformedURLException 
	{
		System.out.println("Hello");
		//AndroidDriver<AndroidElement> driver;
	DesiredCapabilities capabilities = new DesiredCapabilities();
	
	File f=new File("src");
	File fs=new File(f,"ASGRI.apk");
	//capabilities.setCapability(MobileCapabilityType, value);
	capabilities.setCapability(MobileCapabilityType.PLATFORM,"Android");
	capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "S8KZV4JFOB9LU8HU");// ichangedby device name to sushma

capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\unic\\Downloads\\ASGRI.apk");

capabilities.setCapability("appPackage", "com.ascentya.Asgri");
capabilities.setCapability("appWaitActivity","com.ascentya.Asgri.Activitys.OnBoard_Activity");
 driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), 
		capabilities);
 return driver;
 
 
	}
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;


	}
}
